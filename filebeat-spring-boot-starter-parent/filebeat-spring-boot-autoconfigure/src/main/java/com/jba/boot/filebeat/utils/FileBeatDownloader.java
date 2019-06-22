/**
 * 
 */
package com.jba.boot.filebeat.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.jba.boot.filebeat.autoconfigure.FileBeatStarterProperties;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Jude
 *
 */
@Component
@Slf4j
public class FileBeatDownloader {

	@Autowired
	private FileBeatStarterProperties fileBeatProperties;

	public void downloadFileBeat() throws IOException {
		if (!this.isFileBeatInstalled()) {
			URL url = new URL(fileBeatProperties.getLinuxDownloadUrl());
			try (ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());
					FileOutputStream fileOutputStream = new FileOutputStream(getDownloadFileName());
					FileChannel fileChannel = fileOutputStream.getChannel()) {
				fileChannel.transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
				fileOutputStream.close();
			}
			log.debug("Filebeat is downloaded!");
		}
	}

	public boolean isFileBeatInstalled() {
		File insatllDir = new File(getInstallPath());
		return insatllDir.exists();
	}

	public String getDownloadFileName() {
		StringBuilder downloadFileName = new StringBuilder();
		downloadFileName.append(getInstallBasePath());
		downloadFileName.append(File.pathSeparator).append(fileBeatProperties.getDownloadFilename());
		log.debug("Filebeat Download File Name :: {}", downloadFileName.toString());
		return downloadFileName.toString();
	}

	public String getInstallBasePath() {
		StringBuilder installPath = new StringBuilder();
		if (StringUtils.hasText(fileBeatProperties.getFileBeatInstalledBaseDir())) {
			installPath.append(fileBeatProperties.getFileBeatInstalledBaseDir());
		} else {
			installPath.append(System.getProperty(FileBeatStarterConstants.CURRENT_DIR));
		}
		log.debug("Filebeat Install Base Path :: {}", installPath.toString());
		return installPath.toString();
	}

	public String getInstallPath() {
		StringBuilder installPath = new StringBuilder();
		installPath.append(getInstallBasePath()).append(File.pathSeparator)
				.append(FileBeatStarterConstants.FILEBEAT_DIR).append(FileBeatStarterConstants.FILEBEAT_SEPARATOR)
				.append(fileBeatProperties.getVersion()).append(FileBeatStarterConstants.FILEBEAT_SEPARATOR)
				.append(fileBeatProperties.getOsVersion());
		log.debug("Filebeat Install Path :: {}", installPath.toString());
		return installPath.toString();
	}

}
