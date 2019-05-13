package com.jba.boot.filebeat.utils;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jba.boot.filebeat.autoconfigure.FileBeatProperties;

import lombok.extern.slf4j.Slf4j;



@Component
@Slf4j
public class FileBeatProcessStarter {

	@Autowired
	private FileBeatProperties fileBeatProperties;

	public void startFileBeat() throws FileNotFoundException, IOException {
		try {
			StringBuilder fileBeatExecuatble = new StringBuilder();
			fileBeatExecuatble.append(fileBeatProperties.getFileBeatExecutablePath())
					.append(fileBeatProperties.getFileBeatConfigPath());
			log.debug("Filebeat Run Command :: {}",fileBeatExecuatble.toString());
			Runtime.getRuntime().exec(fileBeatExecuatble.toString());
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

}
