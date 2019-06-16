/**
 * 
 */
package com.jba.boot.filebeat.autoconfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jba.boot.filebeat.starter.FileBeatProcessContext;
import com.jba.boot.filebeat.starter.FileBeatStarterTemplate;
import com.jba.boot.filebeat.utils.FileBeatDownloader;
import com.jba.boot.filebeat.utils.FileBeatInstaller;
import com.jba.boot.filebeat.utils.FileBeatProcessStarter;

/**
 * @author Jude
 *
 */
@Configuration
@ConditionalOnClass({ FileBeatDownloader.class, FileBeatInstaller.class, FileBeatProcessStarter.class })
@EnableConfigurationProperties(FileBeatProperties.class)
public class FileBeatAutoConfiguration {

	@Autowired
	private FileBeatStarterTemplate fileBeatStarterTemplate;

	@Bean
	@ConditionalOnMissingBean
	public FileBeatProcessContext getFileBeatProcessContext() {
		return fileBeatStarterTemplate.startFileBeat();
	}

}
