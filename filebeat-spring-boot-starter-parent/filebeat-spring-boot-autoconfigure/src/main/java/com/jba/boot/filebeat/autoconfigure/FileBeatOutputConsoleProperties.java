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
public class FileBeatOutputConsoleProperties {
	private boolean enabled;
	private FileBeatOutputCodecJsonProperties codec;
}
