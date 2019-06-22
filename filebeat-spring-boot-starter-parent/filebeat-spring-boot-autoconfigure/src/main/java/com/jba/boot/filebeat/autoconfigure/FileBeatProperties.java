/**
 * 
 */
package com.jba.boot.filebeat.autoconfigure;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import lombok.Data;

/**
 * @author Jude
 *
 */

@ConfigurationProperties(prefix = "filebeat")
@Data
@Validated
public class FileBeatProperties {
	private FileBeatInputsProperties inputs;
	private Map<String, String> configModules;
	private Map<String, String> templateSettings;
	private Map<String, String> outputElasticsearch;
	private Map<String, String> outputKafka;

}
