package org.xueliang.commons.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtils {

	public static String SHA1(File file) throws IOException, NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("SHA-1");
		FileInputStream fileInputStream = new FileInputStream(file);
		byte[] bytes = new byte[1024];
		int len = -1;
		while ((len = fileInputStream.read(bytes)) >= 0) {
			digest.update(bytes, 0, len);
		}
		fileInputStream.close();
		byte[] digestResult = digest.digest();
		
		// Create Hex String
		StringBuffer hexString = new StringBuffer();
		// 字节数组转换为 十六进制 数
		for (int i = 0; i < digestResult.length; i++) {
			String shaHex = Integer.toHexString(digestResult[i] & 0xFF);
			if (shaHex.length() < 2) {
				hexString.append(0);
			}
			hexString.append(shaHex);
		}
		return hexString.toString();
	}
}