
Filebeat Spring Boot Starter

This is an open source project for Spring boot starter implementation for filebeat log collector. 
This will download the filebeat binaries from internet and install it on the host. 
This will also start the filebeat as a separate process with custom configuration specified in the application spring configuration.
This will be useful for developing spring boot application and collect the application log to ELK stack.
And it will work in different infrastructure(Linux VMs, Docker, k8n), which is compatible of running filebeat binary.

The main advantaged are :
1) Support for filebeat configurations 
2) Support for pushing log to Kafka,ElasticSearch, Radis,File and Console
3) Currently support only Linux base OS.	
	