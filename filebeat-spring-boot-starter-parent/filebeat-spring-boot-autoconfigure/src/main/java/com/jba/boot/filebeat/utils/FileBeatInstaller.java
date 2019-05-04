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

import com.jba.boot.filebeat.autoconfigure.FileBeatProperties;

@Component
public class FileBeatInstaller {

	@Autowired
	private FileBeatProperties fileBeatProperties;

	public void installFileBeat() throws FileNotFoundException, IOException {
		StringBuilder downloadFileName = new StringBuilder()
				.append(System.getProperty(FileBeatStarterConstants.CURRENT_DIR))
				.append(fileBeatProperties.getDownloadFilename());

		try (TarArchiveInputStream fin = new TarArchiveInputStream(new FileInputStream(downloadFileName.toString()))) {
			TarArchiveEntry entry;
			while ((entry = fin.getNextTarEntry()) != null) {
				if (entry.isDirectory()) {
					continue;
				}
				File curfile = new File(System.getProperty(FileBeatStarterConstants.CURRENT_DIR), entry.getName());
				File parent = curfile.getParentFile();
				if (!parent.exists()) {
					parent.mkdirs();
				}
				IOUtils.copy(fin, new FileOutputStream(curfile));
			}
		}
	}
	
}
