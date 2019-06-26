/**
 * 
 */
package com.jba.boot.filebeat.model;

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
public class FileBeatXpackMonitoring {
	@JsonProperty("enabled")
	private boolean enabled;
	@JsonProperty("elasticsearch")
	private FileBeatOutputElasticSearch elasticsearch;
}
