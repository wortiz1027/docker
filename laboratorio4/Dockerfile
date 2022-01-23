# -----------------------------------------------------
# - DOCKERFILE
# - AUTOR: Wilman Alberto Ortiz Navarro
# - FECHA: 21-Octubre-2019
# - DESCRIPCION: Dockerfile que permite la creacion del
# -              contenedor con el jdk 11
# -----------------------------------------------------

# escape=\ (backslash)
# Imagen base del Docker Registry para compilar nuestro microservicio
FROM centos-cicd2:8082/alpine:latest

# Parametrizacion
ARG JDK_BIN=openjdk-11+28_linux-x64_bin.tar.gz
ARG BUILD_DATE
ARG BUILD_VERSION
ARG EMAIL=willman.ortiz@outlook.com
ARG INSTALL_PATH=/opt/software/java

# Informacion de la persona que mantiene la imagen
LABEL org.opencontainers.image.created=$BUILD_DATE \
	  org.opencontainers.image.authors="Wilman Ortiz Navarro <$EMAIL>" \
	  org.opencontainers.image.url="https://gitlab.com/wortiz1027/docker/blob/master/laboratorio4/Dockerfile" \
	  org.opencontainers.image.documentation="https://gitlab.com/wortiz1027/docker/blob/master/README.md" \
	  org.opencontainers.image.source="https://gitlab.com/wortiz1027/docker/blob/master/laboratorio4/Dockerfile" \
	  org.opencontainers.image.version=$BUILD_VERSION \
	  org.opencontainers.image.revision=$BUILD_REVISION \
	  org.opencontainers.image.vendor="developer.io" \
	  org.opencontainers.image.licenses="" \
	  org.opencontainers.image.title="Alpine Jdk 11 Docker Image" \
	  org.opencontainers.image.description="Imagen docker con alpine para instalar jdk 11..."


RUN mkdir -p $INSTALL_PATH; cd $INSTALL_PATH \
	wget https://download.java.net/openjdk/jdk11/ri/$JDK_BIN \
	&& tar xzfv $JDK_BIN \
	&& rm -f $JDK_BIN

ENV JAVA_HOME=$INSTALL_PATH/jdk-11
ENV PATH="$PATH:$JAVA_HOME/bin"
	