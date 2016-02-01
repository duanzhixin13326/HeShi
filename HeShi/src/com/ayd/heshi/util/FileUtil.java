package com.ayd.heshi.util;

import java.io.File;

import android.os.Environment;

/**
 * 文件工具类
 * 
 * @author Administrator
 * 
 */
public class FileUtil {
	/**
	 * 获取sdcard路径
	 * 
	 * @return
	 */
	public static String getSdcardPath() {
		if (Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) {
			return Environment.getExternalStorageDirectory().toString();
		} else {
			return "/";
		}
	}

	/**
	 * 获取文件的后缀名
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getFileExt(String fileName) {
		int index = fileName.lastIndexOf(".");
		if (index != -1) {
			return fileName.substring(index + 1).toLowerCase();
		}
		return "";
	}
}
