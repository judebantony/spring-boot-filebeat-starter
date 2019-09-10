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
import com.jba.boot.filebeat.utils.OSInfo.OS;

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

	public String downloadFileName(OS os) throws IOException {
		String downloadFileName = null;
		switch (os) {
		case WINDOWS:
			downloadFileName = fileBeatProperties.getWindowsDownloadFilename();
			break;
		case UNIX:
			downloadFileName = fileBeatProperties.getLinuxDownloadFilename();
			break;
		case MAC:
			downloadFileName = fileBeatProperties.getMacDownloadFilename();
			break;
		default:
			downloadFileName = fileBeatProperties.getLinuxDownloadFilename();
		}
		return downloadFileName;
	}

	public void downloadFileBeat(OS os) throws IOException {
		String downloadVersion = null;
		switch (os) {
		case WINDOWS:
			downloadVersion = fileBeatProperties.getWindowsDownloadUrl();
			break;
		case UNIX:
			downloadVersion = fileBeatProperties.getLinuxDownloadUrl();
			break;
		case MAC:
			downloadVersion = fileBeatProperties.getMacDownloadUrl();
			break;
		default:
			downloadVersion = fileBeatProperties.getLinuxDownloadUrl();
		}

		if (!this.isFileBeatInstalled(os)) {
			log.info("Filebeat is downloading!");
			URL url = new URL(downloadVersion);
			try (ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());
					FileOutputStream fileOutputStream = new FileOutputStream(getDownloadFileName(os));
					FileChannel fileChannel = fileOutputStream.getChannel()) {
				fileChannel.transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
				fileOutputStream.close();
			}
			log.info("Filebeat is downloaded!");
		} else {
			log.info("Filebeat is already downloaded!");
		}
	}

	public boolean isFileBeatInstalled(OS os) {
		File insatllDir = new File(getInstallPath(os));
		return insatllDir.exists();
	}

	public String getDownloadFileName(OS os) {
		String downloadVersion = null;
		switch (os) {
		case WINDOWS:
			downloadVersion = fileBeatProperties.getWindowsDownloadFilename();
			break;
		case UNIX:
			downloadVersion = fileBeatProperties.getLinuxDownloadFilename();
			break;
		case MAC:
			downloadVersion = fileBeatProperties.getMacDownloadFilename();
			break;
		default:
			downloadVersion = fileBeatProperties.getLinuxDownloadFilename();
		}

		StringBuilder downloadFileName = new StringBuilder();
		downloadFileName.append(getInstallBasePath(os));
		downloadFileName.append(File.separator).append(downloadVersion);
		log.info("Filebeat Download File Name :: {}", downloadFileName.toString());
		return downloadFileName.toString();
	}

	public String getInstallBasePath(OS os) {
		StringBuilder installPath = new StringBuilder();
		if (StringUtils.hasText(fileBeatProperties.getFileBeatInstalledBaseDir())) {
			installPath.append(fileBeatProperties.getFileBeatInstalledBaseDir());
		} else {
			installPath.append(System.getProperty(FileBeatStarterConstants.CURRENT_DIR));
		}
		log.info("Filebeat Install Base Path :: {}", installPath.toString());
		return installPath.toString();
	}

	public String getInstallPath(OS os) {
		String osVersion = null;
		switch (os) {
		case WINDOWS:
			osVersion = fileBeatProperties.getWindowsVersion();
			break;
		case UNIX:
			osVersion = fileBeatProperties.getLinuxVersion();
			break;
		case MAC:
			osVersion = fileBeatProperties.getMacVersion();
			break;
		default:
			osVersion = fileBeatProperties.getLinuxVersion();
		}

		StringBuilder installPath = new StringBuilder();
		installPath.append(getInstallBasePath(os)).append(File.separator).append(FileBeatStarterConstants.FILEBEAT_DIR)
				.append(FileBeatStarterConstants.FILEBEAT_SEPARATOR).append(fileBeatProperties.getVersion())
				.append(FileBeatStarterConstants.FILEBEAT_SEPARATOR).append(osVersion);
		log.info("Filebeat Install Path :: {}", installPath.toString());
		return installPath.toString();
	}

}
