# NGINX tracing modules

Below you find bundles that provide both the `libinstana_sensor.so` as well as the matching `ngx_http_ot_module.so` for all supported versions of NGINX, NGINX Plus and OpenResty.

To pick the right package, you need to know the version of NGINX, NGINX Plus or OpenResty you want to trace.
You can find that by running the `nginx -v` command.

We provide support for all packages released in the [official NGINX repository](http://nginx.org/en/linux_packages.html), both glibc-based versions (RHEL/CentOS, Ubuntu, Debian, SLES) and musl-based (Alpine Linux).
Also, due to quirks of how NGINX packages are compiled, we sometimes need to provide multiple binaries for some other packages offered by particular distribution.
For example, for some versions you may find two bundles for Alpine, one matching the package provided in the official NGINX repository, and the other based on the [Alpine Linux Packages](https://pkgs.alpinelinux.org/packages?name=nginx&branch=edge) repository.

**Note:** All the links below are secured with HTTP Basic Authentication.
To download the files, use `_` as the username and a valid agent key as password.

## NGINX Plus

### NGINX Plus R22

* [NGINX Plus Official Repository](https://docs.nginx.com/nginx/admin-guide/installing-nginx/installing-nginx-plus/):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.19.0.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-musl-nginx-1.19.0.zip)
  * [CentOS/RHEL 6](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.19.0_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.
  * [Amazon Linux 1/2018.03](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.19.0_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.

### NGINX Plus R21

* [NGINX Plus Official Repository](https://docs.nginx.com/nginx/admin-guide/installing-nginx/installing-nginx-plus/):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.9.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-musl-nginx-1.17.9.zip)
  * [CentOS/RHEL 6](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.9_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.
  * [Amazon Linux 1/2018.03](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.9_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.

### NGINX Plus R20

* [NGINX Plus Official Repository](https://docs.nginx.com/nginx/admin-guide/installing-nginx/installing-nginx-plus/):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.6.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-musl-nginx-1.17.6.zip)
  * [CentOS/RHEL 6](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.6_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.
  * [Amazon Linux 1/2018.03](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.6_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.

### NGINX Plus R19

* [NGINX Plus Official Repository](https://docs.nginx.com/nginx/admin-guide/installing-nginx/installing-nginx-plus/):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.3.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-musl-nginx-1.17.3.zip)
  * [CentOS/RHEL 6](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.3_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.
  * [Amazon Linux 1/2018.03](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.3_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.

### NGINX Plus R18

* [NGINX Plus Official Repository](https://docs.nginx.com/nginx/admin-guide/installing-nginx/installing-nginx-plus/):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.15.10.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-musl-nginx-1.15.10.zip)
  * [CentOS/RHEL 6](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.15.10_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.
  * [Amazon Linux 1/2018.03](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.15.10_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.

## NGINX

### NGINX 1.19.2

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.19.2.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-musl-nginx-1.19.2.zip)
  * [CentOS/RHEL 6](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.19.2_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.
  * [Amazon Linux 1/2018.03](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.19.2_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.

### NGINX 1.19.1

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.19.1.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-musl-nginx-1.19.1.zip)
  * [CentOS/RHEL 6](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.19.1_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.
  * [Amazon Linux 1/2018.03](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.19.1_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.

### NGINX 1.19.0

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.19.0.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-musl-nginx-1.19.0.zip)
  * [CentOS/RHEL 6](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.19.0_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.
  * [Amazon Linux 1/2018.03](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.19.0_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.

### NGINX 1.18.0

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.18.0.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-musl-nginx-1.18.0.zip)
  * [CentOS/RHEL 6](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.18.0_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.
  * [Amazon Linux 1/2018.03](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.18.0_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.

* [Alpine Linux Packages](https://pkgs.alpinelinux.org/packages):
  * [Alpine Linux 3.12](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-musl-nginx-1.18.0_alpine.zip)

### NGINX 1.17.10

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.10.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-musl-nginx-1.17.10.zip)
  * [CentOS/RHEL 6](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.10_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.
  * [Amazon Linux 1/2018.03](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.10_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.

### NGINX 1.17.9

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.9.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-musl-nginx-1.17.9.zip)
  * [CentOS/RHEL 6](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.9_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.
  * [Amazon Linux 1/2018.03](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.9_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.

### NGINX 1.17.8

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.8.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-musl-nginx-1.17.8.zip)
  * [CentOS/RHEL 6](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.8_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.
  * [Amazon Linux 1/2018.03](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.8_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.

### NGINX 1.17.7

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.7.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-musl-nginx-1.17.7.zip)
  * [CentOS/RHEL 6](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.7_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.
  * [Amazon Linux 1/2018.03](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.7_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.

### NGINX 1.17.6

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.6.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-musl-nginx-1.17.6.zip)
  * [CentOS/RHEL 6](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.6_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.
  * [Amazon Linux 1/2018.03](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.6_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.

### NGINX 1.17.5

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.5.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-musl-nginx-1.17.5.zip)
  * [CentOS/RHEL 6](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.5_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.
  * [Amazon Linux 1/2018.03](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.5_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.

### NGINX 1.17.4

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.4.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-musl-nginx-1.17.4.zip)
  * [CentOS/RHEL 6](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.4_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.
  * [Amazon Linux 1/2018.03](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.4_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.

### NGINX 1.17.3

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.3.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-musl-nginx-1.17.3.zip)
  * [CentOS/RHEL 6](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.3_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.
  * [Amazon Linux 1/2018.03](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.3_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.

### NGINX 1.17.2

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.2.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-musl-nginx-1.17.2.zip)
  * [CentOS/RHEL 6](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.2_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.
  * [Amazon Linux 1/2018.03](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.2_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.

### NGINX 1.17.1

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.1.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-musl-nginx-1.17.1.zip)
  * [CentOS/RHEL 6](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.1_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.
  * [Amazon Linux 1/2018.03](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.1_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.

### NGINX 1.17.0

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.0.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-musl-nginx-1.17.0.zip)
  * [CentOS/RHEL 6](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.0_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.
  * [Amazon Linux 1/2018.03](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.17.0_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.

### NGINX 1.16.1

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.16.1.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-musl-nginx-1.16.1.zip)
  * [CentOS/RHEL 6](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.16.1_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.
  * [Amazon Linux 1/2018.03](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.16.1_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.

* [Amazon Linux Repository](https://aws.amazon.com/amazon-linux-ami/2018-03-packages/):
  * [Amazon Linux 1/2018.03](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.16.1_amazon.zip)

* [Alpine Linux Packages](https://pkgs.alpinelinux.org/packages):
  * [Alpine Linux 3.11/3.10](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-musl-nginx-1.16.1_alpine.zip)

* [EPEL Repository](https://fedoraproject.org/wiki/EPEL):
  * [CentOS/RHEL 7](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.16.1_amazon.zip)

### NGINX 1.16.0

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.16.0.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-musl-nginx-1.16.0.zip)
  * [CentOS/RHEL 6](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.16.0_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.
  * [Amazon Linux 1/2018.03](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.16.0_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.

### NGINX 1.15.12

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.15.12.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-musl-nginx-1.15.12.zip)
  * [CentOS/RHEL 6](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.15.12_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.
  * [Amazon Linux 1/2018.03](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.15.12_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.

### NGINX 1.15.10

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.15.10.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-musl-nginx-1.15.10.zip)
  * [CentOS/RHEL 6](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.15.10_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.
  * [Amazon Linux 1/2018.03](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.15.10_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.

### NGINX 1.15.0

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.15.0.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-musl-nginx-1.15.0.zip)
  * [CentOS/RHEL 6](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.15.0_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.
  * [Amazon Linux 1/2018.03](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.15.0_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.

### NGINX 1.14.2

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.14.2.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-musl-nginx-1.14.2.zip)
  * [CentOS/RHEL 6](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.14.2_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.
  * [Amazon Linux 1/2018.03](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.14.2_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.

* [Alpine Linux Packages](https://pkgs.alpinelinux.org/packages):
  * [Alpine Linux 3.9/3.8](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-musl-nginx-1.14.2_alpine.zip)

### NGINX 1.14.1

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.14.1.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-musl-nginx-1.14.1.zip)
  * [CentOS/RHEL 6](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.14.1_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.
  * [Amazon Linux 1/2018.03](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.14.1_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.

* [Amazon Linux Repository](https://aws.amazon.com/amazon-linux-ami/2018-03-packages/):
  * [Amazon Linux 1/2018.03](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.14.1_amazon.zip)

### NGINX 1.14.0

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.14.0.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-musl-nginx-1.14.0.zip)
  * [CentOS/RHEL 6](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.14.0_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.
  * [Amazon Linux 1/2018.03](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.14.0_compatnfo.zip)
    * This NGINX variant is compiled without `NGX_HAVE_TCP_FASTOPEN`.

* [Ubuntu Packages](https://packages.ubuntu.com/):
  * [Ubuntu 18.04](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-nginx-1.14.0_ubuntu.zip)

## OpenResty

### OpenResty 1.17.8

* [OpenResty Repository](https://openresty.org/en/linux-packages.html):
  * [OpenResty 1.17.8.1](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-openresty-1.17.8_compat.zip)
    * Supported only on Amazon Linux 1/2018.03
  * [OpenResty 1.17.8.2](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-openresty-1.17.8_compat.zip)
    * Supported only on Amazon Linux 1/2018.03

* [OpenResty DockerHub containers](https://hub.docker.com/r/openresty/openresty)
  * [OpenResty 1.17.8.2](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-openresty-1.17.8.zip)
    * Supported only for Debian based images

### OpenResty 1.15.8

* [OpenResty Repository](https://openresty.org/en/linux-packages.html):
  * [OpenResty 1.15.8.1](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-openresty-1.15.8.zip)
    * Supported only on Amazon Linux 1/2018.03
  * [OpenResty 1.15.8.2](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-openresty-1.15.8.zip)
    * Supported only on Amazon Linux 1/2018.03
  * [OpenResty 1.15.8.3](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-openresty-1.15.8_compat.zip)
    * Supported only on Amazon Linux 1/2018.03

### OpenResty 1.13.6

* [OpenResty Repository](https://openresty.org/en/linux-packages.html):
  * [OpenResty 1.13.6.1](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-openresty-1.13.6.zip)
    * Supported only on Amazon Linux 1/2018.03
  * [OpenResty 1.13.6.2](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.1.1/linux-amd64-glibc-openresty-1.13.6.zip)
    * Supported only on Amazon Linux 1/2018.03
