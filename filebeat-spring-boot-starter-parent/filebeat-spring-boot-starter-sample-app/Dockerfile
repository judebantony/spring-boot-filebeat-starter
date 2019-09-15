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
ENTRYPOINT [ "/tmp/startSampleApp.sh"]
EXPOSE 8761
