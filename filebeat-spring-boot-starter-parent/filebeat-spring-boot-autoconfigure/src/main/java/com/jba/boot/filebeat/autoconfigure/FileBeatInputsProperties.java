/**
 * 
 */
package com.jba.boot.filebeat.autoconfigure;

import java.util.Map;

import lombok.Data;
import lombok.ToString;

/**
 * @author Jude
 *
 */
@Data
@ToString
public class FileBeatInputsProperties {

	private String type;
	private boolean enabled;
	private String[] paths;
	private String excludeLines;
	private String includeLines;
	private String excludeFiles;
	private Map<String, String> fields;

}
