/**
 * 
 */
package com.jba.boot.filebeat.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import lombok.Data;

/**
 * @author Jude
 *
 */
@PropertySources({
    @PropertySource("classpath:filebeatStarter.properties"),
    @PropertySource(value="file:filebeatStarter.properties", ignoreResourceNotFound=true)
})
@ConfigurationProperties(prefix = "filebeat.starter")
@Data
public class FileBeatStarterProperties {
	private String version;
	private String osVersion;
	private String linuxDownloadUrl;
	private String downloadFilename;
	private String fileBeatInstalledBaseDir;
	private String fileBeatConfigDir;
}
