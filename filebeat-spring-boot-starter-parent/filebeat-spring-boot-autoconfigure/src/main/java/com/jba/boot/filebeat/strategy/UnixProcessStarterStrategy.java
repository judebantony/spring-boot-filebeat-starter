/**
 * 
 */
package com.jba.boot.filebeat.strategy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.stereotype.Component;

import com.jba.boot.filebeat.utils.FileBeatStarterConstants;
import com.jba.boot.filebeat.utils.OSInfo.OS;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Jude
 *
 */
@Component
@Slf4j
public class UnixProcessStarterStrategy extends BaseProcessStarterStrategy {

	@Override
	public String startProcess(String installPath, String configPath) throws FileNotFoundException, IOException {
		StringBuilder fileBeatExecuatble = new StringBuilder().append(FileBeatStarterConstants.FILEBEAT_CHMOD_EXE)
				.append(installPath).append(FileBeatStarterConstants.FILEBEAT_COMMAND_PARAMETER_AND)
				.append(FileBeatStarterConstants.FILEBEAT_CHMOD_WRITE).append(installPath)
				.append(FileBeatStarterConstants.FILEBEAT_COMMAND_PARAMETER_AND).append(installPath)
				.append(File.separator).append(FileBeatStarterConstants.FILEBEAT_BIN).append(File.separator)
				.append(FileBeatStarterConstants.FILEBEAT_EXE).append(FileBeatStarterConstants.FILEBEAT_PARAMETER)
				.append(configPath).append(FileBeatStarterConstants.FILEBEAT_DEMON_PARAMETER)
				.append(FileBeatStarterConstants.FILEBEAT_PIPE_PARAMETER).append(installPath).append(File.separator)
				.append(FileBeatStarterConstants.FILEBEAT_LOG_FILE)
				.append(FileBeatStarterConstants.FILEBEAT_DEMON_PARAMETER_AND);
		log.info("Filebeat Run Command in Unix :: {}", fileBeatExecuatble.toString());
		Process process = Runtime.getRuntime().exec(fileBeatExecuatble.toString());
		String pid = getPidOfProcess(process);
		log.info("Filebeat is started! pid = {}", pid);
		return pid;
	}

	@Override
	public OS getOs() {
		return OS.UNIX;
	}

}
