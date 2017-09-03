package org.xueliang.commons.util;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.junit.Assert;
import org.junit.Test;

public class DigestUtilsTest {

	@Test
	public void testSha1() throws NoSuchAlgorithmException, IOException {
		String sha1 = "3330A534B40C28A189DA328130A29561795250E0";
		String pathname = "E:\\迅雷下载\\eclipse-java-neon-R-win32-x86_64.zip";
		Assert.assertEquals(sha1.toLowerCase(), DigestUtils.sha1(new File(pathname)));
	}

}
