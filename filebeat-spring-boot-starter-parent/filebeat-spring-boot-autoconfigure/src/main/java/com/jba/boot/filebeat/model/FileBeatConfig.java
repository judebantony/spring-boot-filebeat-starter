/**
 * 
 */
package com.jba.boot.filebeat.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

/**
 * @author Jude
 *
 */
@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class FileBeatConfig {
	@JsonProperty("filebeat.inputs")
	private List<FileBeatInputs> inputs;
	@JsonProperty("filebeat.config.modules")
	private Map<String, String> configModules;
	@JsonProperty("setup.template.settings")
	private Map<String, String> templateSettings;
	@JsonProperty("setup.kibana")
	private Map<String, String> setupKibana;
	@JsonProperty("processors")
	private Map<String, String> processors;
	@JsonProperty("logging")
	private Map<String, String> logging;
	@JsonProperty("path")
	private Map<String, String> path;
	@JsonProperty("setup.dashboards")
	private Map<String, String> setup;
	@JsonProperty("output.console")
	private FileBeatOutputConsole outputConsole;
	@JsonProperty("output.file")
	private FileBeatOutputFile outputFile;
	@JsonProperty("output.elasticsearch")
	private FileBeatOutputElasticSearch outputElasticSearch;
	@JsonProperty("output.kafka")
	private FileBeatOutputKafka outputKafka;
	@JsonProperty("output.logstash")
	private FileBeatOutputLogstash outputLogstash;
	@JsonProperty("output.redis")
	private FileBeatOutputRedis outputRedis;
	@JsonProperty("xpack.monitoring")
	private FileBeatXpackMonitoring xpackMonitoring;
	@JsonProperty("seccomp.enabled")
	private boolean seccompEnabled = true;
	@JsonProperty("http.enabled")
	private boolean httpEnabled;
	@JsonProperty("http.host")
	private String httpHost;
	@JsonProperty("http.port")
	private String httpPort;
}
