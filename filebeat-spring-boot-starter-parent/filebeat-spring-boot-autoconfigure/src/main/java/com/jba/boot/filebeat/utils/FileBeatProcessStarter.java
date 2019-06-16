package com.jba.boot.filebeat.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.jba.boot.filebeat.autoconfigure.FileBeatProperties;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FileBeatProcessStarter {

	@Autowired
	private FileBeatProperties fileBeatProperties;

	@Autowired
	private FileBeatDownloader fileBeatDownloader;

	public String startFileBeat() throws FileNotFoundException, IOException {
		String pid = null;
		try {
			StringBuilder fileBeatExecuatble = new StringBuilder();
			fileBeatExecuatble.append(fileBeatDownloader.getInstallPath()).append(File.pathSeparator)
					.append(FileBeatStarterConstants.FILEBEAT_BIN).append(File.pathSeparator)
					.append(FileBeatStarterConstants.FILEBEAT_EXE).append(FileBeatStarterConstants.FILEBEAT_PARAMETER);
			if (StringUtils.hasText(fileBeatProperties.getFileBeatConfigPath())) {
				fileBeatExecuatble.append(fileBeatProperties.getFileBeatConfigPath());
			} else {
				fileBeatExecuatble.append(fileBeatDownloader.getInstallPath());
			}
			fileBeatExecuatble.append(File.pathSeparator).append(FileBeatStarterConstants.FILEBEAT_CONF)
					.append(File.pathSeparator).append(FileBeatStarterConstants.FILEBEAT_FILE)
					.append(FileBeatStarterConstants.FILEBEAT_DEMON_PARAMETER);
			log.debug("Filebeat Run Command :: {}", fileBeatExecuatble.toString());
			Process process = Runtime.getRuntime().exec(fileBeatExecuatble.toString());
			pid = getPidOfProcess(process);
			log.debug("Filebeat is started! pid = {}",pid);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return pid;
	}

	public String getPidOfProcess(Process process) {
		Long pid = -1L;
		try {
			if (null != process && process.getClass().getName().equals(FileBeatStarterConstants.UNIX_PROCESS)) {
				Field f = process.getClass().getDeclaredField(FileBeatStarterConstants.PID);
				f.setAccessible(true);
				pid = f.getLong(process);
				f.setAccessible(false);
			}
		} catch (Exception e) {
			pid = -1L;
		}
		return pid.toString();
	}

}
