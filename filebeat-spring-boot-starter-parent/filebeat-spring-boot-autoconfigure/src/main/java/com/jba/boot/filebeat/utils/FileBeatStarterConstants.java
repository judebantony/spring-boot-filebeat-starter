package com.jba.boot.filebeat.utils;

/**
 * 
 * @author Jude
 *
 */

public interface FileBeatStarterConstants {
	String CURRENT_DIR = "user.dir";
	String FILEBEAT_DIR = "filebeat";
	String FILEBEAT_SEPARATOR = "-";
	String FILEBEAT_BIN = "bin";
	String FILEBEAT_CONF = "conf";
	String FILEBEAT_EXE = "filebeat";
	String FILEBEAT_FILE = "filebeat.yml";
	String FILEBEAT_PARAMETER = " -c ";
	String FILEBEAT_DEMON_PARAMETER = " -e ";
	String UNIX_PROCESS = "java.lang.UNIXProcess";
	String PID = "pid";
}
