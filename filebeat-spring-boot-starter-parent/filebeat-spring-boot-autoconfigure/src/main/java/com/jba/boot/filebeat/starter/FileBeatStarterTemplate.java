/**
 * 
 */
package com.jba.boot.filebeat.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jba.boot.filebeat.utils.FileBeatDownloader;
import com.jba.boot.filebeat.utils.FileBeatInstaller;
import com.jba.boot.filebeat.utils.FileBeatProcessStarter;

/**
 * @author Jude
 *
 */
@Component
public class FileBeatStarterTemplate {

	@Autowired
	private FileBeatDownloader fileBeatDownloader;

	@Autowired
	private FileBeatInstaller fileBeatInstaller;

	@Autowired
	private FileBeatProcessStarter fileBeatProcessStarter;

	public FileBeatProcessContext startFileBeat() {
		FileBeatProcessContext fileBeatProcessContext = new FileBeatProcessContext();
		try {
			fileBeatDownloader.downloadFileBeat();
			fileBeatInstaller.installFileBeat();
			fileBeatProcessContext.setProcessId(fileBeatProcessStarter.startFileBeat());
			String message = String.format("Filebeat Stated with pid = %s and processing the log file %s",
					fileBeatProcessContext.getProcessId(), fileBeatProcessContext.getLogFile());
			fileBeatProcessContext.setMessage(message);
		} catch (Exception e) {
			String message = String.format("Fail to start or install Filebeat %s", e.getMessage());
			fileBeatProcessContext.setMessage(message);
		}
		return fileBeatProcessContext;

	}
}
