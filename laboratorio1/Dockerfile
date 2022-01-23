FROM ubuntu:18.04

ARG BUILD_DATE
ARG BUILD_VERSION
ARG BUILD_REVISION

ENV EMAIL="willman.ortiz@gmail.com" \
    DOMAIN1="developer.io" \
    DOMAIN2="www.developer.io" \
	PORT_HTTP=80 \
	PORT_HTTPS=443 \
	DEBIAN_FRONTEND=noninteractive

LABEL org.opencontainers.image.created=$BUILD_DATE \
	  org.opencontainers.image.authors="Wilman Ortiz Navarro <$EMAIL>" \
	  org.opencontainers.image.url="https://gitlab.com/wortiz1027/laboratorio1/blob/develop/Dockerfile" \
	  org.opencontainers.image.documentation="" \
	  org.opencontainers.image.source="https://gitlab.com/wortiz1027/laboratorio1/blob/develop/Dockerfile" \
	  org.opencontainers.image.version=$BUILD_VERSION \
	  org.opencontainers.image.revision=$BUILD_REVISION \
	  org.opencontainers.image.vendor="developer.io" \
	  org.opencontainers.image.licenses="" \
	  org.opencontainers.image.title="Management Customer MicroService" \
	  org.opencontainers.image.description="Imagen docker con ubuntu como base para instalar nginx web server y configurarlo con https"  
	  
RUN export LANG=en_US.UTF-8 && \
    apt-get update -y && apt-get -qq -y dist-upgrade && apt-get install -qq -y --no-install-recommends && \
    apt-get install -y software-properties-common && \	
    apt-get install -y git && \
    apt-get install -y net-tools && \
    apt-get install -y nginx && \
	apt-get -qq clean

RUN add-apt-repository ppa:certbot/certbot && \
    apt-get update -y && \
    apt-get install -y python-certbot-nginx && \    		
	apt-get -qq clean

RUN rm -f /etc/nginx/fastcgi.conf /etc/nginx/fastcgi_params && \
    rm -f /etc/nginx/snippets/fastcgi-php.conf /etc/nginx/snippets/snakeoil.conf
	
RUN git clone --progress --verbose https://github.com/certbot/certbot.git /opt/certbot
RUN . /opt/certbot/certbot-auto certonly --nginx --no-self-upgrade --debug --agree-tos --email $EMAIL -d $DOMAIN1 -d $DOMAIN2 --rsa-key-size 4096

EXPOSE $PORT_HTTP \
       $PORT_HTTPS

ENTRYPOINT ["/usr/sbin/nginx", "-g", "daemon off;"]