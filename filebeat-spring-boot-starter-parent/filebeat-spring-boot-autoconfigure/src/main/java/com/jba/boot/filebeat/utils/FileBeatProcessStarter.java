package com.jba.boot.filebeat.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jba.boot.filebeat.strategy.ProcessStarterStrategy;
import com.jba.boot.filebeat.utils.OSInfo.OS;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FileBeatProcessStarter {

	@Autowired
	private FileBeatDownloader fileBeatDownloader;

	@Autowired
	private FileBeatConfigGenerator fileBeatConfigGenerator;

	@Autowired
	private List<ProcessStarterStrategy> ProcessStarterStrategies;

	public String startFileBeat(OS os) throws FileNotFoundException, IOException {
		String pid = null;
		try {
			for (ProcessStarterStrategy processStarterStrategy : ProcessStarterStrategies) {
				if (os == processStarterStrategy.getOs()) {
					pid = processStarterStrategy.startProcess(fileBeatDownloader.getInstallPath(os),
							fileBeatConfigGenerator.getFileBeatConfigPath(os));
					break;
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return pid;
	}

}
