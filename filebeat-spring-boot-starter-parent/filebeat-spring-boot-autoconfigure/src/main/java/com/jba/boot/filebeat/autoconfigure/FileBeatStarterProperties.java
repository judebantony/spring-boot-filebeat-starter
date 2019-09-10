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
	private String linuxVersion;
	private String windowsVersion;
	private String macVersion;
	private String linuxDownloadUrl;
	private String windowsDownloadUrl;
	private String macDownloadUrl;
	private String linuxDownloadFilename;
	private String windowsDownloadFilename;
	private String macDownloadFilename;
	private String fileBeatInstalledBaseDir;
	private String fileBeatConfigDir;
}
