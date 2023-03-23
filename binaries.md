# NGINX tracing modules

Below you find bundles that provide both the `libinstana_sensor.so` as well as the matching `ngx_http_ot_module.so` for all supported versions of NGINX, NGINX Plus and OpenResty.

To pick the right package, you need to know the version of NGINX, NGINX Plus or OpenResty you want to trace.
You can find that by running the `nginx -v` command.

All packages released in the [official NGINX repository](http://nginx.org/en/linux_packages.html) are supported, including both glibc-based versions (RHEL/CentOS, Ubuntu, Debian, SLES) and musl-based (Alpine Linux). **Custom builds of NGINX are not supported due to issues with binary compatibility.**
Also, due to quirks of how NGINX packages are compiled, we sometimes need to provide multiple binaries for some other packages offered by particular distribution.
For example, for some versions you may find two bundles for Alpine, one matching the package provided in the official NGINX repository, and the other based on the [Alpine Linux Packages](https://pkgs.alpinelinux.org/packages?name=nginx&branch=edge) repository.

**Note:** All the links below are secured with HTTP Basic Authentication.
To download the files, use `_` as the username and a valid agent key as password.

## NGINX Plus

### NGINX Plus R28

* [NGINX Plus Official Repository](https://docs.nginx.com/nginx/admin-guide/installing-nginx/installing-nginx-plus/):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.23.2.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.23.2.zip)

### NGINX Plus R27

* [NGINX Plus Official Repository](https://docs.nginx.com/nginx/admin-guide/installing-nginx/installing-nginx-plus/):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.21.6.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.21.6.zip)

### NGINX Plus R26

* [NGINX Plus Official Repository](https://docs.nginx.com/nginx/admin-guide/installing-nginx/installing-nginx-plus/):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.21.5.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.21.5.zip)

### NGINX Plus R25

* [NGINX Plus Official Repository](https://docs.nginx.com/nginx/admin-guide/installing-nginx/installing-nginx-plus/):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.21.3.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.21.3.zip)

### NGINX Plus R24

* [NGINX Plus Official Repository](https://docs.nginx.com/nginx/admin-guide/installing-nginx/installing-nginx-plus/):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.19.10.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.19.10.zip)

### NGINX Plus R23

* [NGINX Plus Official Repository](https://docs.nginx.com/nginx/admin-guide/installing-nginx/installing-nginx-plus/):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.19.5.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.19.5.zip)

### NGINX Plus R22

* [NGINX Plus Official Repository](https://docs.nginx.com/nginx/admin-guide/installing-nginx/installing-nginx-plus/):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.19.0.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.19.0.zip)

### NGINX Plus R21

* [NGINX Plus Official Repository](https://docs.nginx.com/nginx/admin-guide/installing-nginx/installing-nginx-plus/):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.17.9.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.17.9.zip)

### NGINX Plus R20

* [NGINX Plus Official Repository](https://docs.nginx.com/nginx/admin-guide/installing-nginx/installing-nginx-plus/):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.17.6.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.17.6.zip)

### NGINX Plus R19

* [NGINX Plus Official Repository](https://docs.nginx.com/nginx/admin-guide/installing-nginx/installing-nginx-plus/):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.17.3.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.17.3.zip)

### NGINX Plus R18

* [NGINX Plus Official Repository](https://docs.nginx.com/nginx/admin-guide/installing-nginx/installing-nginx-plus/):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.15.10.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.15.10.zip)

## NGINX

### NGINX 1.23.3

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.23.3.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.23.3.zip)

### NGINX 1.23.2

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.23.2.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.23.2.zip)

### NGINX 1.23.1

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.23.1.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.23.1.zip)

### NGINX 1.23.0

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.23.0.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.23.0.zip)

### NGINX 1.22.1

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.22.1.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.22.1.zip)

* [Alpine Linux Packages](https://pkgs.alpinelinux.org/packages):
  * [Alpine Linux 3.16](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.22.1_alpine.zip)

### NGINX 1.22.0

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.22.0.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.22.0.zip)

### NGINX 1.21.6

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.21.6.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.21.6.zip)

### NGINX 1.21.5

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.21.5.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.21.5.zip)

### NGINX 1.21.4

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.21.4.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.21.4.zip)

### NGINX 1.21.3

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.21.3.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.21.3.zip)

### NGINX 1.21.2

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.21.2.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.21.2.zip)

### NGINX 1.21.1

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.21.1.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.21.1.zip)

### NGINX 1.21.0

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.21.0.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.21.0.zip)

### NGINX 1.20.2

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.20.2.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.20.2.zip)

* [Alpine Linux Packages](https://pkgs.alpinelinux.org/packages):
  * [Alpine Linux 3.14/3.15](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.20.2_alpine.zip)

### NGINX 1.20.1

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.20.1.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.20.1.zip)

* [Alpine Linux Packages](https://pkgs.alpinelinux.org/packages):
  * [Alpine Linux 3.14](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.20.1_alpine.zip)

### NGINX 1.20.0

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.20.0.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.20.0.zip)

* [Alpine Linux Packages](https://pkgs.alpinelinux.org/packages):
  * [Alpine Linux 3.14](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.20.0_alpine.zip)

### NGINX 1.19.10

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.19.10.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.19.10.zip)

### NGINX 1.19.9

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.19.9.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.19.9.zip)

### NGINX 1.19.8

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.19.8.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.19.8.zip)

### NGINX 1.19.7

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.19.7.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.19.7.zip)

### NGINX 1.19.6

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.19.6.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.19.6.zip)

### NGINX 1.19.5

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.19.5.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.19.5.zip)

### NGINX 1.19.4

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.19.4.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.19.4.zip)

### NGINX 1.19.3

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.19.3.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.19.3.zip)

### NGINX 1.19.2

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.19.2.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.19.2.zip)

### NGINX 1.19.1

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.19.1.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.19.1.zip)

### NGINX 1.19.0

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.19.0.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.19.0.zip)

### NGINX 1.18.0

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.18.0.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.18.0.zip)

* [Alpine Linux Packages](https://pkgs.alpinelinux.org/packages):
  * [Alpine Linux 3.12](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.18.0_alpine.zip)

### NGINX 1.17.10

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.17.10.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.17.10.zip)

### NGINX 1.17.9

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.17.9.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.17.9.zip)

### NGINX 1.17.8

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.17.8.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.17.8.zip)

### NGINX 1.17.7

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.17.7.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.17.7.zip)

### NGINX 1.17.6

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.17.6.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.17.6.zip)

### NGINX 1.17.5

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.17.5.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.17.5.zip)

### NGINX 1.17.4

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.17.4.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.17.4.zip)

### NGINX 1.17.3

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.17.3.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.17.3.zip)

### NGINX 1.17.2

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.17.2.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.17.2.zip)

### NGINX 1.17.1

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.17.1.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.17.1.zip)

### NGINX 1.17.0

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.17.0.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.17.0.zip)

### NGINX 1.16.1

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.16.1.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.16.1.zip)

* [Alpine Linux Packages](https://pkgs.alpinelinux.org/packages):
  * [Alpine Linux 3.11/3.10](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.16.1_alpine.zip)

* [EPEL Repository](https://fedoraproject.org/wiki/EPEL):
  * [CentOS/RHEL 7](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.16.1_amazon.zip)

### NGINX 1.16.0

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.16.0.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.16.0.zip)

### NGINX 1.15.12

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.15.12.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.15.12.zip)

### NGINX 1.15.10

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.15.10.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.15.10.zip)

### NGINX 1.15.3

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.15.3.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.15.3.zip)

* [Alpine Linux Packages](https://pkgs.alpinelinux.org/packages):
  * [Alpine Linux 3.14](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.15.3_alpine.zip)

* [Debian Packages](https://www.debian.org/distrib/packages#view)
  * [Debian 10/9](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.15.3_ubuntu.zip)

### NGINX 1.15.0

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.15.0.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.15.0.zip)

### NGINX 1.14.2

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.14.2.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.14.2.zip)

* [Alpine Linux Packages](https://pkgs.alpinelinux.org/packages):
  * [Alpine Linux 3.9/3.8](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.14.2_alpine.zip)

* [Debian Packages](https://www.debian.org/distrib/packages#view)
  * [Debian 10/9](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.14.2_ubuntu.zip)

### NGINX 1.14.1

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.14.1.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.14.1.zip)

### NGINX 1.14.0

* [NGINX Official Repository](http://nginx.org/en/linux_packages.html):
  * [Glibc based Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.14.0.zip)
  * [Alpine Linux](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-musl-nginx-1.14.0.zip)

* [Ubuntu Packages](https://packages.ubuntu.com/):
  * [Ubuntu 18.04](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-nginx-1.14.0_ubuntu.zip)

## OpenResty

### OpenResty 1.21.4

* [OpenResty Repository](https://openresty.org/en/linux-packages.html):
  * [OpenResty 1.21.4.1](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-openresty-1.21.4_compat.zip)
    * Supported only on Amazon Linux and CentOS

* [OpenResty DockerHub containers](https://hub.docker.com/r/openresty/openresty)
  * [OpenResty 1.21.4.1 Debian](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-openresty-1.21.4.zip)
  * [OpenResty 1.21.4.1 CentOS](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-openresty-1.21.4_compat.zip)

### OpenResty 1.19.9

* [OpenResty Repository](https://openresty.org/en/linux-packages.html):
  * [OpenResty 1.19.9.1](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-openresty-1.19.9_compat.zip)
    * Supported only on Amazon Linux and CentOS

* [OpenResty DockerHub containers](https://hub.docker.com/r/openresty/openresty)
  * [OpenResty 1.19.9.1 Debian](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-openresty-1.19.9.zip)
  * [OpenResty 1.19.9.1 CentOS](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-openresty-1.19.9_compat.zip)

### OpenResty 1.19.3

* [OpenResty Repository](https://openresty.org/en/linux-packages.html):
  * [OpenResty 1.19.3.1](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-openresty-1.19.3_compat.zip)
    * Supported only on Amazon Linux and CentOS
  * [OpenResty 1.19.3.2](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-openresty-1.19.3_compat.zip)
    * Supported only on Amazon Linux and CentOS

* [OpenResty DockerHub containers](https://hub.docker.com/r/openresty/openresty)
  * [OpenResty 1.19.3.1 Debian](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-openresty-1.19.3.zip)
  * [OpenResty 1.19.3.2 Debian](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-openresty-1.19.3.zip)
  * [OpenResty 1.19.3.1 CentOS](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-openresty-1.19.3_compat.zip)
  * [OpenResty 1.19.3.2 CentOS](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-openresty-1.19.3_compat.zip)

* [3scale containers](https://quay.io/repository/3scale/s2i-openresty-centos7?tag=latest&tab=tags)
  * [OpenResty 1.19.3.1](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-openresty-1.19.3.zip)

### OpenResty 1.17.8

* [OpenResty Repository](https://openresty.org/en/linux-packages.html):
  * [OpenResty 1.17.8.1](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-openresty-1.17.8_compat.zip)
    * Supported only on Amazon Linux
  * [OpenResty 1.17.8.2](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-openresty-1.17.8_compat.zip)
    * Supported only on Amazon Linux

* [OpenResty DockerHub containers](https://hub.docker.com/r/openresty/openresty)
  * [OpenResty 1.17.8.2](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-openresty-1.17.8.zip)
    * Supported only for Debian based images

### OpenResty 1.17.4

* [3scale containers](https://quay.io/repository/3scale/s2i-openresty-centos7?tag=latest&tab=tags)
  * [OpenResty 1.17.4.1rc0](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-openresty-1.17.4_3scale.zip)

### OpenResty 1.15.8

* [OpenResty Repository](https://openresty.org/en/linux-packages.html):
  * [OpenResty 1.15.8.1](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-openresty-1.15.8.zip)
    * Supported only on Amazon Linux
  * [OpenResty 1.15.8.2](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-openresty-1.15.8.zip)
    * Supported only on Amazon Linux
  * [OpenResty 1.15.8.3](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-openresty-1.15.8_compat.zip)
    * Supported only on Amazon Linux

### OpenResty 1.13.6

* [OpenResty Repository](https://openresty.org/en/linux-packages.html):
  * [OpenResty 1.13.6.1](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-openresty-1.13.6.zip)
    * Supported only on Amazon Linux
  * [OpenResty 1.13.6.2](https://artifact-public.instana.io/artifactory/shared/com/instana/nginx_tracing/1.8.1/linux-amd64-glibc-openresty-1.13.6.zip)
    * Supported only on Amazon Linux
