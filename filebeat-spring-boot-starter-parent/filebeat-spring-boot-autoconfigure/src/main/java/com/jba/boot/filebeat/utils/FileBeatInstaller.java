package com.jba.boot.filebeat.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jba.boot.filebeat.utils.OSInfo.OS;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FileBeatInstaller {

	@Autowired
	private FileBeatDownloader fileBeatDownloader;

	public void installFileBeat(OS os) throws FileNotFoundException, IOException {
		if (!fileBeatDownloader.isFileBeatInstalled(os)) {
			String installPath = fileBeatDownloader.getInstallBasePath(os);
			String downloadFileName = fileBeatDownloader.getDownloadFileName(os);
			try (TarArchiveInputStream fin = new TarArchiveInputStream(new FileInputStream(downloadFileName))) {
				TarArchiveEntry entry;
				while ((entry = fin.getNextTarEntry()) != null) {
					if (entry.isDirectory()) {
						continue;
					}
					File curfile = new File(installPath, entry.getName());
					File parent = curfile.getParentFile();
					if (!parent.exists()) {
						parent.mkdirs();
					}
					IOUtils.copy(fin, new FileOutputStream(curfile));
				}
			}
			log.info("Filebeat is installed!");
			File downloadFile = new File(downloadFileName);
			downloadFile.delete();
		} else {
			log.info("Filebeat is already installed!");
		}
	}

}
