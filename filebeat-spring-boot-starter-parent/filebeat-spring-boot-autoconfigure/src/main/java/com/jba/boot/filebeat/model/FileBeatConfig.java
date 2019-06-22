/**
 * 
 */
package com.jba.boot.filebeat.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class FileBeatConfig {
	@JsonProperty("filebeat.inputs")
	private FileBeatInputs inputs;
	@JsonProperty("filebeat.config.modules")
	private Map<String, String> configModules;
	@JsonProperty("setup.template.settings")
	private Map<String, String> templateSettings;
	@JsonProperty("output.elasticsearch")
	private Map<String, String> outputElasticsearch;
	@JsonProperty("output.kafka")
	private Map<String, String> outputKafka;

}
