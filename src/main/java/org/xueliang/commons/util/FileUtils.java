package org.xueliang.commons.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileUtils {

	public static String getFileExtname(String filename) {
		if (filename == null) {
			throw new NullPointerException();
		}
		int dotIndex = filename.indexOf(".");
		if (dotIndex >= 0) {
			return "." + filename.substring(dotIndex + 1);
		}
		return "";
	}
	
	public static String readContentAsString(File file) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(file);
		return readContentAsString(fileInputStream);
	}
	
	public static String readContentAsString(InputStream inputStream) throws IOException {
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		StringBuilder stringBuilder = new StringBuilder();
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			stringBuilder.append(line);
		}
		return stringBuilder.toString();
	}
}
