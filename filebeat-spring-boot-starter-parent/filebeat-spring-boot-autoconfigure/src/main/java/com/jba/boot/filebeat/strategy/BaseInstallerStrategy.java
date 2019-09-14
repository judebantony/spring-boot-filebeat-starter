/**
 * 
 */
package com.jba.boot.filebeat.strategy;

import java.io.File;

/**
 * @author Jude
 *
 */
public abstract class BaseInstallerStrategy implements InstallerStrategy {

	public File extactFile(String installPath, String entryName) {
		File curfile = new File(installPath, entryName);
		File parent = curfile.getParentFile();
		if (!parent.exists()) {
			parent.mkdirs();
		}
		return curfile;

	}
	
	public void deleteDownloadFile(String downloadFileName) {
		File downloadFile = new File(downloadFileName);
		downloadFile.delete();
	}


}
