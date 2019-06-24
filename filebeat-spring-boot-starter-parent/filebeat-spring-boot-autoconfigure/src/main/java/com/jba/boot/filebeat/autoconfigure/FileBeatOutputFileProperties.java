/**
 * 
 */
package com.jba.boot.filebeat.autoconfigure;

import org.springframework.validation.annotation.Validated;

import lombok.Data;
import lombok.ToString;

/**
 * @author Jude
 *
 */
@Data
@ToString
@Validated
public class FileBeatOutputFileProperties {
	private boolean enabled;
	private FileBeatOutputCodecJsonProperties codec;
	private String path;
	private String filename;
	private Long rotateEveryKb;
	private Integer numberOfFiles;
	private String permissions;

}
