/**
 * 
 */
package com.jba.boot.filebeat.strategy;

import java.lang.reflect.Field;

import com.jba.boot.filebeat.utils.FileBeatStarterConstants;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.WinNT;

/**
 * @author Jude
 *
 */
public abstract class BaseProcessStarterStrategy implements ProcessStarterStrategy {

	public String getPidOfProcess(Process process) {
		Long pid = -1L;
		try {
			if (null != process) {
				if (process.getClass().getName().equals(FileBeatStarterConstants.UNIX_PROCESS)) {
					Field f = process.getClass().getDeclaredField(FileBeatStarterConstants.PID);
					f.setAccessible(true);
					pid = f.getLong(process);
					f.setAccessible(false);
				} // for windows
				else if (process.getClass().getName().equals(FileBeatStarterConstants.WINDOWS_PROCESS)
						|| process.getClass().getName().equals(FileBeatStarterConstants.PROCESS)) {
					Field f = process.getClass().getDeclaredField(FileBeatStarterConstants.HANDLE);
					f.setAccessible(true);
					long handl = f.getLong(process);
					Kernel32 kernel = Kernel32.INSTANCE;
					WinNT.HANDLE hand = new WinNT.HANDLE();
					hand.setPointer(Pointer.createConstant(handl));
					int result = kernel.GetProcessId(hand);
					f.setAccessible(false);
					pid = new Long(result);
				}
			}
		} catch (Exception e) {
			pid = -1L;
		}
		return pid.toString();
	}

}
