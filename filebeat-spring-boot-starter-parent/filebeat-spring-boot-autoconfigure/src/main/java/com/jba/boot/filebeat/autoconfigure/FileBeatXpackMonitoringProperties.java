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
public class FileBeatXpackMonitoringProperties {
	private boolean enabled;
	private FileBeatOutputElasticSearchProperties elasticsearch;
}
