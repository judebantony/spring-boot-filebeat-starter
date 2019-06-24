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
	
}
