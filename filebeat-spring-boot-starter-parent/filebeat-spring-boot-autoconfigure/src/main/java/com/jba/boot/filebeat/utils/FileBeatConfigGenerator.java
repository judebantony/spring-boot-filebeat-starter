/**
 * 
 */
package com.jba.boot.filebeat.utils;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.jba.boot.filebeat.autoconfigure.FileBeatProperties;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Jude
 *
 */
@Component
@Slf4j
public class FileBeatConfigGenerator {

	@Autowired
	private FileBeatProperties fileBeatProperties;

	@Autowired
	private FileBeatDownloader fileBeatDownloader;

	public void createFileBeatConfig() {
		if(!isFileBeatConfigAlreadyPresent()) {
			
		}
	}

	public String getFileBeatConfigPath() {
		if (StringUtils.hasText(fileBeatProperties.getFileBeatConfigDir())) {
			File configDir = new File(getFileBeatConfigProvidedPath());
			if (configDir.exists()) {
				return getFileBeatConfigProvidedPath();
			}
		}
		return getFileBeatConfigFullPath();
	}

	private boolean isFileBeatConfigAlreadyPresent() {
		boolean isFileBeatConfigAlreadyPresent = false;
		if (StringUtils.hasText(fileBeatProperties.getFileBeatConfigDir())) {
			File configDir = new File(getFileBeatConfigProvidedPath());
			if (configDir.exists()) {
				log.debug("Filebeat Config Path is already present :: ");
				isFileBeatConfigAlreadyPresent = true;
			}
		}
		return isFileBeatConfigAlreadyPresent;
	}

	private String getFileBeatConfigFullPath() {
		StringBuilder configPath = new StringBuilder();
		configPath.append(fileBeatDownloader.getInstallPath()).append(File.pathSeparator)
				.append(FileBeatStarterConstants.FILEBEAT_CONF).append(File.pathSeparator)
				.append(FileBeatStarterConstants.FILEBEAT_CONFIG_FILE);
		log.debug("Filebeat Config Path :: {}", configPath.toString());
		return configPath.toString();
	}

	private String getFileBeatConfigProvidedPath() {
		StringBuilder configPath = new StringBuilder();
		configPath.append(fileBeatProperties.getFileBeatConfigDir()).append(File.pathSeparator)
				.append(FileBeatStarterConstants.FILEBEAT_CONFIG_FILE);
		log.debug("Filebeat Config Path :: {}", configPath.toString());
		return configPath.toString();
	}

}
