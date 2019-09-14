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
public class WindowsProcessStarterStrategy extends BaseProcessStarterStrategy {

	@Override
	public String startProcess(String installPath, String configPath) throws FileNotFoundException, IOException {
		StringBuilder fileBeatExecuatble = new StringBuilder().append(FileBeatStarterConstants.FILEBEAT_WINDOWS_CMDEXE)
				.append(FileBeatStarterConstants.SPACE).append(FileBeatStarterConstants.FILEBEAT_WINDOWS_CMD_C)
				.append(FileBeatStarterConstants.SPACE).append(FileBeatStarterConstants.FILEBEAT_WINDOWS_CMD_CD)
				.append(FileBeatStarterConstants.SPACE).append(installPath).append(FileBeatStarterConstants.SPACE)
				.append(FileBeatStarterConstants.FILEBEAT_WINDOWS_CMD_AND).append(FileBeatStarterConstants.SPACE)
				.append(FileBeatStarterConstants.FILEBEAT_WINDOWS_CMD_START).append(FileBeatStarterConstants.SPACE)
				.append(FileBeatStarterConstants.FILEBEAT_WINDOWS_EXE);
		log.info("Filebeat Run Command in Windows:: {}", fileBeatExecuatble.toString());
		Process process = Runtime.getRuntime().exec(fileBeatExecuatble.toString(), null, new File(installPath));
		String pid = getPidOfProcess(process);
		log.info("Filebeat is started! pid = {}", pid);
		return pid;
	}

	@Override
	public OS getOs() {
		return OS.WINDOWS;
	}

}
