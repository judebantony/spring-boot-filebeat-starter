package com.jba.boot.filebeat.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jba.boot.filebeat.utils.OSInfo.OS;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.WinNT;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FileBeatProcessStarter {

	@Autowired
	private FileBeatDownloader fileBeatDownloader;

	@Autowired
	private FileBeatConfigGenerator fileBeatConfigGenerator;

	public String startFileBeat(OS os) throws FileNotFoundException, IOException {
		String pid = null;
		try {
			StringBuilder fileBeatExecuatble = new StringBuilder().append(fileBeatDownloader.getInstallPath(os))
					.append(File.separator);
			if (os == OS.UNIX || os == OS.MAC) {
				fileBeatExecuatble.append(FileBeatStarterConstants.FILEBEAT_BIN).append(File.separator)
						.append(FileBeatStarterConstants.FILEBEAT_EXE)
						.append(FileBeatStarterConstants.FILEBEAT_PARAMETER)
						.append(fileBeatConfigGenerator.getFileBeatConfigPath(os))
						.append(FileBeatStarterConstants.FILEBEAT_DEMON_PARAMETER);
				log.info("Filebeat Run Command :: {}", fileBeatExecuatble.toString());
				Process process = Runtime.getRuntime().exec(fileBeatExecuatble.toString());
				pid = getPidOfProcess(process);
				log.info("Filebeat is started! pid = {}", pid);
			} else if (os == OS.WINDOWS) {
				fileBeatExecuatble.append(FileBeatStarterConstants.FILEBEAT_WINDOWS_EXE).append(FileBeatStarterConstants.SPACE)
						.append(fileBeatConfigGenerator.getFileBeatConfigPath(os));
				log.info("Filebeat Run Command :: {}", fileBeatExecuatble.toString());
				Process process = Runtime.getRuntime().exec(fileBeatExecuatble.toString(), null,
						new File(fileBeatDownloader.getInstallBasePath(os)));
				pid = getPidOfProcess(process);
				log.info("Filebeat is started! pid = {}", pid);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return pid;
	}

	public String getPidOfProcess(Process process) {
		Long pid = -1L;
		try {
			if (null != process) {
				if (process.getClass().getName().equals(FileBeatStarterConstants.UNIX_PROCESS)) {
					Field f = process.getClass().getDeclaredField(FileBeatStarterConstants.PID);
					f.setAccessible(true);
					pid = f.getLong(process);
					f.setAccessible(false);
				} // for windows
				else if (process.getClass().getName().equals(FileBeatStarterConstants.WINDOWS_PROCESS)
						|| process.getClass().getName().equals(FileBeatStarterConstants.PROCESS)) {
					Field f = process.getClass().getDeclaredField(FileBeatStarterConstants.HANDLE);
					f.setAccessible(true);
					long handl = f.getLong(process);
					Kernel32 kernel = Kernel32.INSTANCE;
					WinNT.HANDLE hand = new WinNT.HANDLE();
					hand.setPointer(Pointer.createConstant(handl));
					int result = kernel.GetProcessId(hand);
					f.setAccessible(false);
					pid = new Long(result);
				}
			}
		} catch (Exception e) {
			pid = -1L;
		}
		return pid.toString();
	}

}
