/**
 * 
 */
package com.jba.boot.filebeat.model;

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
public class FileBeatOutputFile {
	@JsonProperty("enabled")
	private boolean enabled;
	@JsonProperty("codec")
	private FileBeatOutputCodecJson codec;
	@JsonProperty("path")
	private String path;
	@JsonProperty("filename")
	private String filename;
	@JsonProperty("rotate_every_kb")
	private Long rotateEveryKb;
	@JsonProperty("number_of_files")
	private Integer numberOfFiles;
	@JsonProperty("permissions")
	private String permissions;

}
