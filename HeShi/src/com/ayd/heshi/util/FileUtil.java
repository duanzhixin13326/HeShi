package com.ayd.heshi.util;

import java.io.File;

import android.os.Environment;

/**
 * �ļ�������
 * 
 * @author Administrator
 * 
 */
public class FileUtil {
	/**
	 * ��ȡsdcard·��
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
	 * ��ȡ�ļ��ĺ�׺��
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
