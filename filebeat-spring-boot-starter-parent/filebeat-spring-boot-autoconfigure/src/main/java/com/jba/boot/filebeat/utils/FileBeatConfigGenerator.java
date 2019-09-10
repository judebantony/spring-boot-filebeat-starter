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

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.jba.boot.filebeat.autoconfigure.FileBeatProperties;
import com.jba.boot.filebeat.autoconfigure.FileBeatStarterProperties;
import com.jba.boot.filebeat.model.FileBeatConfig;
import com.jba.boot.filebeat.model.FileBeatInputs;
import com.jba.boot.filebeat.model.FileBeatOutputCodecJson;
import com.jba.boot.filebeat.model.FileBeatOutputConsole;
import com.jba.boot.filebeat.model.FileBeatOutputElasticSearch;
import com.jba.boot.filebeat.model.FileBeatOutputFile;
import com.jba.boot.filebeat.model.FileBeatOutputKafka;
import com.jba.boot.filebeat.model.FileBeatOutputLogstash;
import com.jba.boot.filebeat.model.FileBeatOutputPartitionHash;
import com.jba.boot.filebeat.model.FileBeatOutputRedis;
import com.jba.boot.filebeat.model.FileBeatOutputSSL;
import com.jba.boot.filebeat.model.FileBeatXpackMonitoring;
import com.jba.boot.filebeat.utils.OSInfo.OS;

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

	@Autowired
	private FileBeatConfigValidator fileBeatConfigValidator;

	Function<FileBeatProperties, FileBeatConfig> convertToYml = (properties) -> {
		FileBeatConfig objFileBeatConfig = new FileBeatConfig();
		BeanUtils.copyProperties(properties, objFileBeatConfig);
		// Input
		if (null != properties.getInputs()) {
			FileBeatInputs inputs = new FileBeatInputs();
			BeanUtils.copyProperties(properties.getInputs(), inputs);
			objFileBeatConfig.setInputs(inputs);
		}

		// outputConsole
		if (null != properties.getOutputConsole()) {
			FileBeatOutputConsole outputConsole = new FileBeatOutputConsole();
			BeanUtils.copyProperties(properties.getOutputConsole(), outputConsole);
			objFileBeatConfig.setOutputConsole(outputConsole);
			if (null != properties.getOutputConsole().getCodec()) {
				FileBeatOutputCodecJson codec = new FileBeatOutputCodecJson();
				BeanUtils.copyProperties(properties.getOutputConsole().getCodec(), codec);
				outputConsole.setCodec(codec);
			}
		}

		// outputFile
		if (null != properties.getOutputFile()) {
			FileBeatOutputFile outputFile = new FileBeatOutputFile();
			BeanUtils.copyProperties(properties.getOutputFile(), outputFile);
			objFileBeatConfig.setOutputFile(outputFile);
			if (null != properties.getOutputFile().getCodec()) {
				FileBeatOutputCodecJson codec = new FileBeatOutputCodecJson();
				BeanUtils.copyProperties(properties.getOutputFile().getCodec(), codec);
				outputFile.setCodec(codec);
			}
		}

		// outputElasticSearch
		if (null != properties.getOutputElasticSearch()) {
			FileBeatOutputElasticSearch outputElasticSearch = new FileBeatOutputElasticSearch();
			BeanUtils.copyProperties(properties.getOutputElasticSearch(), outputElasticSearch);
			objFileBeatConfig.setOutputElasticSearch(outputElasticSearch);
			if (null != properties.getOutputElasticSearch().getSsl()) {
				FileBeatOutputSSL ssl = new FileBeatOutputSSL();
				BeanUtils.copyProperties(properties.getOutputElasticSearch().getSsl(), ssl);
				outputElasticSearch.setSsl(ssl);
			}
		}

		// outputKafka
		if (null != properties.getOutputKafka()) {
			FileBeatOutputKafka outputKafka = new FileBeatOutputKafka();
			BeanUtils.copyProperties(properties.getOutputKafka(), outputKafka);
			objFileBeatConfig.setOutputKafka(outputKafka);
			if (null != properties.getOutputKafka().getSsl()) {
				FileBeatOutputSSL ssl = new FileBeatOutputSSL();
				BeanUtils.copyProperties(properties.getOutputKafka().getSsl(), ssl);
				outputKafka.setSsl(ssl);
			}
			if (null != properties.getOutputKafka().getCodec()) {
				FileBeatOutputCodecJson codec = new FileBeatOutputCodecJson();
				BeanUtils.copyProperties(properties.getOutputKafka().getCodec(), codec);
				outputKafka.setCodec(codec);
			}
			if (null != properties.getOutputKafka().getPartition()) {
				FileBeatOutputPartitionHash partition = new FileBeatOutputPartitionHash();
				BeanUtils.copyProperties(properties.getOutputKafka().getPartition(), partition);
				outputKafka.setPartition(partition);
			}
		}

		// outputLogstash
		if (null != properties.getOutputLogstash()) {
			FileBeatOutputLogstash outputLogstash = new FileBeatOutputLogstash();
			BeanUtils.copyProperties(properties.getOutputLogstash(), outputLogstash);
			objFileBeatConfig.setOutputLogstash(outputLogstash);
			if (null != properties.getOutputLogstash().getSsl()) {
				FileBeatOutputSSL ssl = new FileBeatOutputSSL();
				BeanUtils.copyProperties(properties.getOutputLogstash().getSsl(), ssl);
				outputLogstash.setSsl(ssl);
			}
		}

		// outputRedis
		if (null != properties.getOutputRedis()) {
			FileBeatOutputRedis outputRedis = new FileBeatOutputRedis();
			BeanUtils.copyProperties(properties.getOutputRedis(), outputRedis);
			objFileBeatConfig.setOutputRedis(outputRedis);
			if (null != properties.getOutputRedis().getSsl()) {
				FileBeatOutputSSL ssl = new FileBeatOutputSSL();
				BeanUtils.copyProperties(properties.getOutputRedis().getSsl(), ssl);
				outputRedis.setSsl(ssl);
			}
			if (null != properties.getOutputRedis().getCodec()) {
				FileBeatOutputCodecJson codec = new FileBeatOutputCodecJson();
				BeanUtils.copyProperties(properties.getOutputRedis().getCodec(), codec);
				outputRedis.setCodec(codec);
			}

		}

		// xpackMonitoring
		if (null != properties.getXpackMonitoring()) {
			FileBeatXpackMonitoring xpackMonitoring = new FileBeatXpackMonitoring();
			BeanUtils.copyProperties(properties.getXpackMonitoring(), xpackMonitoring);
			objFileBeatConfig.setXpackMonitoring(xpackMonitoring);
			if (null != properties.getOutputElasticSearch()) {
				FileBeatOutputElasticSearch outputElasticSearch = new FileBeatOutputElasticSearch();
				BeanUtils.copyProperties(properties.getOutputElasticSearch(), outputElasticSearch);
				objFileBeatConfig.setOutputElasticSearch(outputElasticSearch);
				if (null != properties.getOutputElasticSearch().getSsl()) {
					FileBeatOutputSSL ssl = new FileBeatOutputSSL();
					BeanUtils.copyProperties(properties.getOutputElasticSearch().getSsl(), ssl);
					outputElasticSearch.setSsl(ssl);
				}
			}
		}

		return objFileBeatConfig;
	};

	public void createFileBeatConfig(OS os) {
		if (!isFileBeatConfigAlreadyPresent(os)) {
			ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
			mapper.setSerializationInclusion(Include.NON_NULL);
			try {
				FileBeatConfig fileBeatConfig = convertToYml.apply(fileBeatProperties);
				if (fileBeatConfigValidator.validateFileBeatConfig(fileBeatConfig)) {
					String fileBeatYml = mapper.writeValueAsString(fileBeatConfig);
					log.info("filbeat config file = {} ", fileBeatYml);
					if (StringUtils.hasText(fileBeatYml)) {
						Files.write(Paths.get(getFileBeatConfigPath(os)), fileBeatYml.getBytes());
					}
				}
			} catch (IOException e) {
				log.error(e.getMessage());
			}
		} else {
			log.info(" filebeat config is already present !");
		}
	}

	public String getFileBeatConfigPath(OS os) {
		String configFilePath = null;
		if ((os == OS.UNIX || os == OS.MAC) && StringUtils.hasText(fileBeatStarterProperties.getFileBeatConfigDir())) {
			configFilePath = getFileBeatConfigProvidedPath();
		} else {
			configFilePath = getFileBeatConfigFullPath(os);
		}
		return configFilePath;
	}

	private boolean isFileBeatConfigAlreadyPresent(OS os) {
		boolean isFileBeatConfigAlreadyPresent = false;
		String configFilePath = null;
		if (StringUtils.hasText(fileBeatStarterProperties.getFileBeatConfigDir())) {
			configFilePath = getFileBeatConfigProvidedPath();
		}
		if (StringUtils.hasText(configFilePath)) {
			File configDir = new File(configFilePath);
			if (configDir.exists()) {
				isFileBeatConfigAlreadyPresent = true;
			}
		}
		log.info("Filebeat Config Path is already present or not :: {}", isFileBeatConfigAlreadyPresent);
		return isFileBeatConfigAlreadyPresent;
	}

	private String getFileBeatConfigFullPath(OS os) {
		StringBuilder configPath = new StringBuilder().append(fileBeatDownloader.getInstallPath(os));
		if (os == OS.UNIX) {
			configPath.append(File.separator).append(FileBeatStarterConstants.FILEBEAT_CONF);
		}
		configPath.append(File.separator).append(FileBeatStarterConstants.FILEBEAT_CONFIG_FILE);
		log.info("Filebeat Config Path :: {}", configPath.toString());
		return configPath.toString();
	}

	private String getFileBeatConfigProvidedPath() {
		StringBuilder configPath = new StringBuilder();
		configPath.append(fileBeatStarterProperties.getFileBeatConfigDir()).append(File.separator)
				.append(FileBeatStarterConstants.FILEBEAT_CONFIG_FILE);
		log.debug("Filebeat Config Path :: {}", configPath.toString());
		return configPath.toString();
	}

}
