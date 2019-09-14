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
public interface InstallerStrategy {
	void install(String downloadFileName, String installPath) throws FileNotFoundException, IOException;

	OS getOs();
}
