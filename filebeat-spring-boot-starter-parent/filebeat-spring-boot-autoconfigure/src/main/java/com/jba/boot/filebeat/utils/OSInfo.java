/**
 * 
 */
package com.jba.boot.filebeat.utils;

import java.io.IOException;
import java.util.Locale;

/**
 * @author Jude
 *
 */
public final class OSInfo {

	public enum OS {
		WINDOWS, UNIX, SOLARIS, MAC, POSIX_UNIX, OTHER;

		private String version;

		public String getVersion() {
			return version;
		}

		public void setVersion(String version) {
			this.version = version;
		}
	}

	private static OS os = OS.OTHER;

	static {
		try {
			String osName = System.getProperty("os.name");
			if (osName == null) {
				throw new IOException("os.name not found");
			}
			osName = osName.toLowerCase(Locale.ENGLISH);
			if (osName.contains("windows")) {
				os = OS.WINDOWS;
			} else if (osName.contains("linux") || osName.contains("mpe/ix") || osName.contains("freebsd")
					|| osName.contains("irix") || osName.contains("digital unix") || osName.contains("unix")
					|| osName.contains("aix")) {
				os = OS.UNIX;
			} else if (osName.contains("mac os")) {
				os = OS.MAC;
			} else if (osName.contains("sun os") || osName.contains("sunos") || osName.contains("solaris")) {
				os = OS.SOLARIS;
			} else if (osName.contains("hp-ux")) {
				os = OS.POSIX_UNIX;
			} else {
				os = OS.OTHER;
			}
		} catch (Exception ex) {
			os = OS.OTHER;
		} finally {
			os.setVersion(System.getProperty("os.version"));
		}
	}

	public static OS getOs() {
		return os;
	}

	public static boolean isWindows() {
		return (getOs() == OS.WINDOWS);
	}

	public static boolean isMac() {
		return (getOs() == OS.MAC);
	}

	public static boolean isUnix() {
		return (getOs() == OS.UNIX);
	}

	public static boolean isSolaris() {
		return (getOs() == OS.SOLARIS);
	}

	public static boolean isSupported() {
		return (OSInfo.isUnix() || OSInfo.isWindows() || OSInfo.isMac()) ? true : false;
	}

}
