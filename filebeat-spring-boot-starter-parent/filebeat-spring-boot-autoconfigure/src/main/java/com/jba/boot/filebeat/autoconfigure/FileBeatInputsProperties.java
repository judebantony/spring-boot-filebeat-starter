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
	private String encoding;
	private List<String> paths;
	private String excludeLines;
	private String includeLines;
	private String excludeFiles;
	private boolean fieldsUnderRoot;
	private Integer ignoreOlder;
	private Map<String, String> fields;
	private Map<String, String> multiline;
	private String scanFrequency;
	private Long harvesterBufferSize;
	private Long maxBytes;
	private Map<String, String> recursiveGlob;
	private Map<String, String> json;
}
