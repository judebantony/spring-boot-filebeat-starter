/**
 * 
 */
package com.jba.boot.filebeat.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jba.boot.filebeat.autoconfigure.FileBeatProperties;

/**
 * @author Jude
 *
 */
@Component
public class FileBeatDownloader {

	@Autowired
	private FileBeatProperties fileBeatProperties;

	public void downloadFileBeat() throws IOException {
		URL url = new URL(fileBeatProperties.getLinuxDownloadUrl());
		StringBuilder downloadFileName = new StringBuilder()
				.append(System.getProperty(FileBeatStarterConstants.CURRENT_DIR))
				.append(fileBeatProperties.getDownloadFilename());
		try (ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());
				FileOutputStream fileOutputStream = new FileOutputStream(downloadFileName.toString());
				FileChannel fileChannel = fileOutputStream.getChannel()) {
			fileChannel.transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
			fileOutputStream.close();
		}
	}
}
