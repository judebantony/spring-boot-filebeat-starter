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
	private boolean codecJsonPretty;
	private boolean codecJsonEscapeHtml;
	private String path;
	private String filename;
	private Long rotate_every_kb;
	private Integer number_of_files;
	private String permissions;

}
