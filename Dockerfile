FROM ubuntu:14.04

ENV ACTIVATOR_VERSION 1.2.12

# Update packages
RUN apt-get update -y

# Install prerequisites
RUN apt-get install -y wget unzip default-jre default-jdk && \
    rm -rf /var/lib/apt/lists/*

# Install typesafe activator
RUN cd /tmp && \
    wget -q "http://downloads.typesafe.com/typesafe-activator/$ACTIVATOR_VERSION/typesafe-activator-$ACTIVATOR_VERSION.zip" && \
    cd /opt && \
    unzip /tmp/typesafe-activator-$ACTIVATOR_VERSION.zip && \
    ln -s activator-$ACTIVATOR_VERSION activator

# Add a start script
#ADD start-play /opt/

VOLUME ["/app"]

WORKDIR /app

# Expose the defaultplayframework application port
EXPOSE 9000

# elasticsearch service in the foreground
#CMD ["/opt/start-play"]
RUN cd /var/app/current
ENV PATH $PATH:/var/app/current

CMD ["activator", "run"]
