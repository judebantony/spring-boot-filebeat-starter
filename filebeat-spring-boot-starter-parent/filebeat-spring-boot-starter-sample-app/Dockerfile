FROM centos
RUN yum install -y java
RUN yum install -y bash
RUN yum install -y glibc.i686
MAINTAINER Jude Antony <judebantony@gmail.com>
USER root

VOLUME /tmp
VOLUME /data
WORKDIR /tmp

ADD target/filebeat-starter-sampleapp.jar /tmp/
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/tmp/filebeat-starter-sampleapp.jar"]
EXPOSE 5050
