/**
 * 
 */
package com.jba.boot.filebeat.strategy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.compress.utils.IOUtils;
import org.springframework.stereotype.Component;

import com.jba.boot.filebeat.utils.OSInfo.OS;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Jude
 *
 */
@Component
@Slf4j
public class WindowsInstallerStrategy extends BaseInstallerStrategy {

	@Override
	public void install(String downloadFileName, String installPath) throws FileNotFoundException, IOException {
		log.info("downloadFileName = {}", downloadFileName);
		log.info("installPath = {}", installPath);
		try (ZipInputStream fin = new ZipInputStream(new FileInputStream(downloadFileName))) {
			ZipEntry entry;
			while ((entry = fin.getNextEntry()) != null) {
				if (entry.isDirectory()) {
					continue;
				}
				IOUtils.copy(fin, new FileOutputStream(extactFile(installPath, entry.getName())));
			}
		}
		log.info("Filebeat is installed in Windows!");
		deleteDownloadFile(downloadFileName);
	}

	@Override
	public OS getOs() {
		return OS.WINDOWS;
	}

}
