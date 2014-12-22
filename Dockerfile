FROM ubuntu:14.04

ENV ACTIVATOR_VERSION 1.2.12
ENV PATH $PATH:/var/app/current

# Update packages
RUN apt-get update -y

# Install prerequisites
RUN apt-get install -y wget unzip default-jre default-jdk && \
    rm -rf /var/lib/apt/lists/*

# Install typesafe activator
RUN cd /tmp && \
    wget -q "http://downloads.typesafe.com/typesafe-activator/$ACTIVATOR_VERSION/typesafe-activator-$ACTIVATOR_VERSION.zip" && \
    cd /opt && \
    unzip /tmp/typesafe-activator-$ACTIVATOR_VERSION.zip

#RUN cd /var/app/current

# Add a start script
#ADD start-play /opt/

VOLUME ["/app"]

WORKDIR /app

# Expose the defaultplayframework application port
EXPOSE 9000

# elasticsearch service in the foreground
#CMD ["/opt/start-play"]

CMD ["activator", "run"]
