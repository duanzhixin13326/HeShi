package com.ayd.heshi.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 登录注册时的方法
 * 
 * @author Administrator
 * 
 */
public class LoginUtil {
	/**
	 * 判断手机号 正哲表达式
	 * 
	 * @param mobiles
	 */
	public static boolean isMobileNo(String mobiles) {
		Pattern p = Pattern
				.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
		Matcher m = p.matcher(mobiles);
		return m.matches();
	}

	/* md5 加密 */
	public static String md5(String str) {
		MessageDigest algorithm = null;
		try {
			algorithm = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
		}
		if (algorithm != null) {
			algorithm.reset();
			algorithm.update(str.getBytes());
			byte[] bytes = algorithm.digest();
			StringBuilder hexString = new StringBuilder();
			for (byte b : bytes) {
				hexString.append(Integer.toHexString(0xFF & b));
			}
			return hexString.toString();
		}
		return "";
	}

	/**
	 * SHA加密
	 */
	public static String getSHA(String str) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA");
			try {
				md.update(str.getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		} catch (NoSuchAlgorithmException e) {
		}
		byte[] digest = md.digest();
		return byte2hex(digest);
	}

	private static String byte2hex(byte[] buff) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buff.length; i++) {
			String hex = Integer.toHexString(buff[i] & 0xFF);
			if (hex.length() == 1) {
				hex = "0" + hex;
			}
			sb.append(hex.toLowerCase());
		}
		return sb.toString();
	}
}
