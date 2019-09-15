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
	String FILEBEAT_WINDOWS_CMDEXE ="cmd";
	String FILEBEAT_WINDOWS_CMD ="cmd /c start";
	String FILEBEAT_WINDOWS_CMD_C ="/c";
	String FILEBEAT_WINDOWS_CMD_START ="start";
	String FILEBEAT_WINDOWS_CMD_CD ="cd";
	String FILEBEAT_WINDOWS_CMD_AND ="&&";
	String FILEBEAT_WINDOWS_EXE = "filebeat.exe";
	String FILEBEAT_CONFIG_FILE = "filebeat.yml";
	String FILEBEAT_PARAMETER = " -c ";
	String FILEBEAT_DEMON_PARAMETER = " -e ";
	String FILEBEAT_PIPE_PARAMETER = " > ";
	String FILEBEAT_DEMON_PARAMETER_AND = " &";
	String FILEBEAT_COMMAND_PARAMETER_AND = " && ";
	String FILEBEAT_CHMOD_EXE = "chmod -R 700 ";
	String FILEBEAT_CHMOD_WRITE = "chmod -R go-w ";
	String FILEBEAT_LOG_FILE = "filebeat-logs";
	String UNIX_PROCESS = "java.lang.UNIXProcess";
	String WINDOWS_PROCESS = "java.lang.Win32Process";
	String PROCESS ="java.lang.ProcessImpl";
	String PID = "pid";
	String SPACE = " ";
	String HANDLE ="handle";
}
