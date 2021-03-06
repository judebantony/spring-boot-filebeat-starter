/**
 * 
 */
package com.jba.boot.filebeat.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jba.boot.filebeat.utils.FileBeatConfigGenerator;
import com.jba.boot.filebeat.utils.FileBeatDownloader;
import com.jba.boot.filebeat.utils.FileBeatInstaller;
import com.jba.boot.filebeat.utils.FileBeatProcessStarter;
import com.jba.boot.filebeat.utils.OSInfo;
import com.jba.boot.filebeat.utils.OSInfo.OS;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Jude
 *
 */
@Component
@Slf4j
public class FileBeatStarterTemplate {

	@Autowired
	private FileBeatDownloader fileBeatDownloader;

	@Autowired
	private FileBeatInstaller fileBeatInstaller;

	@Autowired
	private FileBeatConfigGenerator fileBeatConfigGenerator;

	@Autowired
	private FileBeatProcessStarter fileBeatProcessStarter;

	public FileBeatProcessContext startFileBeat() {
		FileBeatProcessContext fileBeatProcessContext = new FileBeatProcessContext();
		try {
			OS os = OSInfo.getOs();
			if (OSInfo.isSupported()) {
				fileBeatDownloader.downloadFileBeat(os);
				fileBeatInstaller.installFileBeat(os);
				fileBeatConfigGenerator.createFileBeatConfig(os);
				fileBeatProcessContext.setProcessId(fileBeatProcessStarter.startFileBeat(os));
				fileBeatProcessContext
						.setMessage(String.format("Filebeat Stated with pid = %s and processing the log file %s",
								fileBeatProcessContext.getProcessId(), fileBeatProcessContext.getLogFile()));
			} else {
				log.info("This OS is not supported for this starter {}", os.getVersion());
				fileBeatProcessContext
						.setMessage(String.format("This OS is not supported for this starter %s", os.getVersion()));
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			fileBeatProcessContext.setMessage(String.format("Fail to start or install Filebeat %s", e.getMessage()));
		}
		return fileBeatProcessContext;
	}
}
