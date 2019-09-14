package com.jba.boot.filebeat.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jba.boot.filebeat.strategy.InstallerStrategy;
import com.jba.boot.filebeat.utils.OSInfo.OS;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FileBeatInstaller {

	@Autowired
	private FileBeatDownloader fileBeatDownloader;

	@Autowired
	private List<InstallerStrategy> installerStrategies;

	public void installFileBeat(OS os) throws FileNotFoundException, IOException {
		if (!fileBeatDownloader.isFileBeatInstalled(os)) {
			log.info("Filebeat Installing started");
			for (InstallerStrategy installerStrategy : installerStrategies) {
				if (os == installerStrategy.getOs()) {
					installerStrategy.install(fileBeatDownloader.getDownloadFileName(os),
							fileBeatDownloader.getInstallBasePath(os));
					break;
				}
			}
			log.info("Filebeat is installed!");
		} else {
			log.info("Filebeat is already installed!");
		}
	}

}
