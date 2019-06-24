/**
 * 
 */
package com.jba.boot.filebeat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	private boolean enabled;
	private FileBeatOutputElasticSearch elasticsearch;
}
