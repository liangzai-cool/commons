package org.xueliang.commons.upload.util;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.junit.Assert;
import org.junit.Test;
import org.xueliang.commons.util.EncryptUtils;

public class EncryptUtilsTest {

	@Test
	public void testSHA1() throws NoSuchAlgorithmException, IOException {
		String sha1 = "3330A534B40C28A189DA328130A29561795250E0";
		String pathname = "E:\\迅雷下载\\eclipse-java-neon-R-win32-x86_64.zip";
		Assert.assertEquals(sha1.toLowerCase(), EncryptUtils.SHA1(new File(pathname)));
	}

}
