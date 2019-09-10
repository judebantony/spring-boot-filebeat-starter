package com.jba.boot.filebeat.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

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
			log.info("Filebeat Installing started");
			String installPath = fileBeatDownloader.getInstallBasePath(os);
			String downloadFileName = fileBeatDownloader.getDownloadFileName(os);
			log.info("downloadFileName = {}", downloadFileName);
			log.info("installPath = {}", installPath);
			if (os == OS.UNIX || os == OS.MAC) {
				try (TarArchiveInputStream fin = new TarArchiveInputStream(new FileInputStream(downloadFileName))) {
					TarArchiveEntry entry;
					while ((entry = fin.getNextTarEntry()) != null) {
						if (entry.isDirectory()) {
							continue;
						}
						IOUtils.copy(fin, new FileOutputStream(extactFile(installPath, entry.getName())));					}
				}
			} else if (os == OS.WINDOWS) {
				try (ZipInputStream fin = new ZipInputStream(new FileInputStream(downloadFileName))) {
					ZipEntry entry;
					while ((entry = fin.getNextEntry()) != null) {
						if (entry.isDirectory()) {
							continue;
						}
						IOUtils.copy(fin, new FileOutputStream(extactFile(installPath, entry.getName())));
					}
				}
			}
			log.info("Filebeat is installed!");
			File downloadFile = new File(downloadFileName);
			downloadFile.delete();
		} else {
			log.info("Filebeat is already installed!");
		}
	}

	private File extactFile(String installPath , String entryName) {
		File curfile = new File(installPath, entryName);
		File parent = curfile.getParentFile();
		if (!parent.exists()) {
			parent.mkdirs();
		}
		return curfile;
		
	}
	
}
