package com.ayd.heshi.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * �ַ����жϵĹ�����
 * 
 * @author Administrator
 * 
 */
public class StringUtil {
	/**
	 * �ж��ַ��� ������ʽ
	 * @param regex
	 * @param str
	 * @return
	 */
	public static boolean match(String regex,String str){
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
}
