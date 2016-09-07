package org.xueliang.commons.util;


public class FileUtils {

	public static String getFileExtname(String filename) {
		int dotIndex = filename.indexOf(".");
		if (dotIndex >= 0) {
			return "." + filename.substring(dotIndex + 1);
		}
		return "";
	}
}
