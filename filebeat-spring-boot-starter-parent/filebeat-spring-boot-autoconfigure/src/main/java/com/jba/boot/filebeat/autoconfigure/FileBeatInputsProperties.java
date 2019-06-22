/**
 * 
 */
package com.jba.boot.filebeat.autoconfigure;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotBlank;

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
public class FileBeatInputsProperties {
	@NotBlank(message = "type is mandatory")
	private String type;
	private boolean enabled;
	private List<String> paths;
	private String excludeLines;
	private String includeLines;
	private String excludeFiles;
	private Map<String, String> fields;
	private Map<String, String> multiline;
}
