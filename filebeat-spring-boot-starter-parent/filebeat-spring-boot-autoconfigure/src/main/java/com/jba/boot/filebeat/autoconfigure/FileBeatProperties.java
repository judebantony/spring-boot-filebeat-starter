/**
 * 
 */
package com.jba.boot.filebeat.autoconfigure;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import lombok.Data;

/**
 * @author Jude
 *
 */
@Component
@ConfigurationProperties(prefix = "filebeat")
@Data
@Validated
public class FileBeatProperties {
	private FileBeatInputsProperties inputs;
	private Map<String, String> configModules;
	private Map<String, String> templateSettings;
	private Map<String, String> setupKibana;
	private Map<String, String> processors;
	private Map<String, String> logging;
	private Map<String, String> path;
	private Map<String, String> setup;
	private FileBeatOutputElasticSearchProperties outputElasticSearch;
	private FileBeatOutputKafkaProperties outputKafka;
	private FileBeatOutputLogstashProperties outputLogstash;
	private FileBeatOutputFileProperties outputFile;
	private FileBeatOutputConsoleProperties outputConsole;
	private FileBeatOutputRedisProperties outputRedis;
	private FileBeatXpackMonitoringProperties xpackMonitoring;
	private boolean seccompEnabled = true;
	private boolean httpEnabled;
	private String httpHost;
	private String httpPort;
}
