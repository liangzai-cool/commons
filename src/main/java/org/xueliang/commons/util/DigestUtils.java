package org.xueliang.commons.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestUtils {

    public static String sha1(File file) throws IOException, NoSuchAlgorithmException {
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
    
    public static String sha1(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        byte[] result = digest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
    
    public static String md5(byte[] bytes) {
        String md5 = "MD5";
        try {
            MessageDigest md = MessageDigest.getInstance(md5);
            md.update(bytes);
            return String.valueOf(new BigInteger(1, md.digest()));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("Could not find MessageDigest with algorithm \"" + md5 + "\"", e);
        }
    }
    
    public static String md5(String input) {
        return md5(input.getBytes());
    }
}