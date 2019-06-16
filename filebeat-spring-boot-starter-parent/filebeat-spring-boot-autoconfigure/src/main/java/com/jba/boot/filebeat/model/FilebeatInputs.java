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
@JsonIgnoreProperties(ignoreUnknown=true)
public class FilebeatInputs {

	@JsonProperty("type")
	private String type;
	@JsonProperty("enabled")
	private boolean enabled;
	@JsonProperty("paths")
	private String[] paths;
	@JsonProperty("exclude_lines")
	private String excludeLines;
	@JsonProperty("include_lines")
	private String includeLines;
	@JsonProperty("exclude_files")
	private String excludeFiles;
	@JsonProperty("fields")
	private Map<String, String> fields;

}
