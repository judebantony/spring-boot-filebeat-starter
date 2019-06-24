/**
 * 
 */
package com.jba.boot.filebeat.autoconfigure;

import java.util.Map;

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
public class FileBeatOutputCodecJsonProperties {
	private Map<String, String> json;
}
