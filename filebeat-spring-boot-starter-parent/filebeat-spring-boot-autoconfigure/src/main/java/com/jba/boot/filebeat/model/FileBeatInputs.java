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
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(Include.NON_NULL)
public class FileBeatInputs {

	@JsonProperty("type")
	private String type;
	@JsonProperty("enabled")
	private boolean enabled;
	@JsonProperty("paths")
	private List<String> paths;
	@JsonProperty("encoding")
	private String encoding;
	@JsonProperty("exclude_lines")
	private String excludeLines;
	@JsonProperty("include_lines")
	private String includeLines;
	@JsonProperty("exclude_files")
	private String excludeFiles;
	@JsonProperty("fields")
	private Map<String, String> fields;
	@JsonProperty("fields_under_root")
	private boolean fieldsUnderRoot;
	@JsonProperty("ignore_older")
	private Integer ignoreOlder;
	@JsonProperty("multiline")
	private Map<String, String> multiline;
	@JsonProperty("scan_frequency")
	private String scanFrequency;
	@JsonProperty("harvester_buffer_size")
	private Long harvesterBufferSize;
	@JsonProperty("max_bytes")
	private Long maxBytes;
	@JsonProperty("recursive_glob")
	private Map<String, String> recursiveGlob;
	@JsonProperty("json")
	private Map<String, String> json;

}
