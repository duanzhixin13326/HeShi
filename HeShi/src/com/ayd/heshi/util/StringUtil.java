package com.ayd.heshi.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串判断的工具类
 * 
 * @author Administrator
 * 
 */
public class StringUtil {
	/**
	 * 判断字符串 正则表达式
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
