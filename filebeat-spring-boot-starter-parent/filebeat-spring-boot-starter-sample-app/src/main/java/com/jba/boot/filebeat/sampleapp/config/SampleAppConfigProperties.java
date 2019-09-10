/**
 * 
 */
package com.jba.boot.filebeat.sampleapp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

/**
 * @author Jude
 *
 */
@Configuration
@PropertySource("classpath:sampleapp.properties")
@ConfigurationProperties(prefix = "sampleapp")
@Data
public class SampleAppConfigProperties {
	
	private String desc;
}
