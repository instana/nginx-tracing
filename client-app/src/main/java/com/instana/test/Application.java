package com.instana.test;

import com.instana.sdk.annotation.Span;
import com.instana.sdk.support.SpanSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URL;

@SpringBootApplication
@SuppressWarnings("unused")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	static class ApiImpl {

		private final URL targetUrl;

		private final RestTemplate restTemplate;

		ApiImpl(final URL targetUrl, final RestTemplate restTemplate) {
			this.targetUrl = targetUrl;
			this.restTemplate = restTemplate;
		}

		ResponseEntity<String> issueRequest() {
			try {
				ResponseEntity<String> entity = restTemplate.getForEntity(targetUrl.toURI(), String.class);

				HttpStatus responseStatus = entity.getStatusCode();

				if (!responseStatus.is2xxSuccessful()) {
					throw new RuntimeException(String.format("Request failed with HTTP status %s", responseStatus));
				}

				return entity;
			} catch (Exception ex) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.toString());
			}
		}

	}

	@Configuration
	static class RestTemplateConfiguration {

		@Bean
		RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
			return restTemplateBuilder
				.setConnectTimeout(200)
				.setReadTimeout(1_000)
				.build();
		}

	}

	@Configuration
	public static class ApiImplConfiguration {

		@Bean
		ApiImpl apiImpl(@Value("${target_url}") URL targetUrl, RestTemplate restTemplate) {
			return new ApiImpl(targetUrl, restTemplate);
		}

	}

	@Configuration
	@EnableScheduling
	static class SchedulingConfiguration {

		@Autowired
		private ApiImpl apiImpl;

		@Scheduled(fixedRate=1_000)
		@Span(value="recurrent-task", type = Span.Type.ENTRY)
		void issueRequest() {
			apiImpl.issueRequest();
		}

	}

}