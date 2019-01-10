FROM nginx:1.13.12-alpine
MAINTAINER Lev Khrushchev <levas1992@gmail.com>
COPY ./rest-docs/nginx-conf/nginx.conf /etc/nginx/nginx.conf
COPY ./rest-docs/nginx-conf/default.conf /etc/nginx/conf.d/default.conf
COPY ./rest-docs/html /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
