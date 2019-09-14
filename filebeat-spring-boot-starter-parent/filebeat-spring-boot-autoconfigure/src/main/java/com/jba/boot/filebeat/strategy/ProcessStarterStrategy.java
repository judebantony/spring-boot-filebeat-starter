/**
 * 
 */
package com.jba.boot.filebeat.strategy;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.jba.boot.filebeat.utils.OSInfo.OS;

/**
 * @author Jude
 *
 */
public interface ProcessStarterStrategy {
	String startProcess(String installPath, String configPath) throws FileNotFoundException, IOException;

	OS getOs();
}
