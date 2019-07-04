/**
 * 
 */
package com.jba.boot.filebeat.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @author Jude
 *
 */
@Component
@PropertySource("classpath:filebeatStarter.properties")
@ConfigurationProperties(prefix = "filebeat-starter", ignoreInvalidFields = true)
@Data
public class FileBeatStarterProperties {
	private String version;
	private String osVersion;
	private String linuxDownloadUrl;
	private String downloadFilename;
	private String fileBeatInstalledBaseDir;
	private String fileBeatConfigDir;
}
