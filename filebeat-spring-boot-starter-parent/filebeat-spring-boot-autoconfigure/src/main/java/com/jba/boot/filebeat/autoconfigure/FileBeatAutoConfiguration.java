/**
 * 
 */
package com.jba.boot.filebeat.autoconfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jude
 *
 */
@Configuration
@EnableConfigurationProperties(FileBeatProperties.class)
public class FileBeatAutoConfiguration {

	@Autowired
	private FileBeatProperties fileBeatProperties;
	
	
	
}
