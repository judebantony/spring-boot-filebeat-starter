package com.jba.boot.filebeat.starter;

import lombok.Data;

/**
 * 
 * @author Jude
 *
 */
@Data
public class FileBeatProcessContext {

	private String processId;
	private String message;
	private String logFile;
	private String targetOutput;
}
