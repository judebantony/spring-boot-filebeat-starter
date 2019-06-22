/**
 * 
 */
package com.jba.boot.filebeat.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.jba.boot.filebeat.autoconfigure.FileBeatProperties;
import com.jba.boot.filebeat.autoconfigure.FileBeatStarterProperties;
import com.jba.boot.filebeat.model.FileBeatConfig;

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
	private FileBeatStarterProperties fileBeatStarterProperties;

	@Autowired
	private FileBeatDownloader fileBeatDownloader;

	Function<FileBeatProperties, FileBeatConfig> convertToYml = (properties) -> {
		FileBeatConfig objFileBeatConfig = new FileBeatConfig();
		if (null != properties) {
			BeanUtils.copyProperties(objFileBeatConfig, properties);
		}
		return objFileBeatConfig;
	};

	public void createFileBeatConfig() {
		if (!isFileBeatConfigAlreadyPresent()) {
			ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
			try {
				String fileBeatYml = mapper.writeValueAsString(convertToYml.apply(fileBeatProperties));
				log.debug("filbeat config file {} ", fileBeatYml);
				if (StringUtils.hasText(fileBeatYml)) {
					Files.write(Paths.get(getFileBeatConfigPath()), fileBeatYml.getBytes());
				}
			} catch (IOException e) {
				log.error(e.getMessage());
			}
		}
	}

	public String getFileBeatConfigPath() {
		if (StringUtils.hasText(fileBeatStarterProperties.getFileBeatConfigDir())) {
			File configDir = new File(getFileBeatConfigProvidedPath());
			if (configDir.exists()) {
				return getFileBeatConfigProvidedPath();
			}
		}
		return getFileBeatConfigFullPath();
	}

	private boolean isFileBeatConfigAlreadyPresent() {
		boolean isFileBeatConfigAlreadyPresent = false;
		if (StringUtils.hasText(fileBeatStarterProperties.getFileBeatConfigDir())) {
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
		configPath.append(fileBeatStarterProperties.getFileBeatConfigDir()).append(File.pathSeparator)
				.append(FileBeatStarterConstants.FILEBEAT_CONFIG_FILE);
		log.debug("Filebeat Config Path :: {}", configPath.toString());
		return configPath.toString();
	}

}
