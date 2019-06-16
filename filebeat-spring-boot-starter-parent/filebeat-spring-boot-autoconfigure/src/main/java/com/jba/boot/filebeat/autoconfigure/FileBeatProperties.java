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
    @PropertySource("classpath:filebeat.properties"),
    @PropertySource(value="file:filebeat.properties", ignoreResourceNotFound=true)
})
@ConfigurationProperties(prefix = "filebeat")
@Data
public class FileBeatProperties {
	private String version;
	private String osVersion;
	private String linuxDownloadUrl;
	private String downloadFilename;
	private String fileBeatInstalledBaseDir;
	private String fileBeatConfigDir;
}
