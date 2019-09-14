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
public class MacProcessStarterStrategy extends BaseProcessStarterStrategy {

	@Override
	public String startProcess(String installPath, String configPath) throws FileNotFoundException, IOException {
		StringBuilder fileBeatExecuatble = new StringBuilder().append(installPath).append(File.separator)
				.append(FileBeatStarterConstants.FILEBEAT_BIN).append(File.separator)
				.append(FileBeatStarterConstants.FILEBEAT_EXE).append(FileBeatStarterConstants.FILEBEAT_PARAMETER)
				.append(configPath).append(FileBeatStarterConstants.FILEBEAT_DEMON_PARAMETER);
		log.info("Filebeat Run Command in Mac :: {}", fileBeatExecuatble.toString());
		Process process = Runtime.getRuntime().exec(fileBeatExecuatble.toString());
		String pid = getPidOfProcess(process);
		log.info("Filebeat is started! pid = {}", pid);
		return pid;
	}

	@Override
	public OS getOs() {
		return OS.MAC;
	}

}
