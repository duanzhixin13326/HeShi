package com.ayd.heshi.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * �洢�����صĹ�����
 * 
 * @author Administrator
 * 
 */
public class ShareParam {
	private static final String SHAREDPEFERENCES_NAME = "heshi";

	/**
	 * ����String �������ݵ�����
	 * 
	 * @param context
	 * @param key
	 * @param value
	 */
	public static void putStringParam(Context context, String key, String value) {
		SharedPreferences ffchat = context.getSharedPreferences(
				SHAREDPEFERENCES_NAME, Context.MODE_PRIVATE);
		Editor ffchatedit = ffchat.edit();
		ffchatedit.putString(key, value);
		ffchatedit.commit();
	}

	/**
	 * ����int �������ݵ�����
	 * 
	 * @param context
	 * @param key
	 * @param value
	 */
	public static void putIntParam(Context context, String key, int value) {
		SharedPreferences ffchat = context.getSharedPreferences(
				SHAREDPEFERENCES_NAME, Context.MODE_PRIVATE);
		Editor ffchatedit = ffchat.edit();
		ffchatedit.putInt(key, value);
		ffchatedit.commit();
	}

	/**
	 * ���� boolean �������ݵ�����
	 * 
	 * @param context
	 * @param key
	 * @param value
	 */
	public static void putBooleanParam(Context context, String key,
			boolean value) {
		SharedPreferences ffchat = context.getSharedPreferences(
				SHAREDPEFERENCES_NAME, Context.MODE_PRIVATE);
		Editor ffchatedit = ffchat.edit();
		ffchatedit.putBoolean(key, value);
		ffchatedit.commit();
	}

	/**
	 * �ӱ��ػ�ȡString ��������
	 * 
	 * @param context
	 * @param key
	 */
	public static String getStringParam(Context context, String key) {
		SharedPreferences ffchat = context.getSharedPreferences(
				SHAREDPEFERENCES_NAME, Context.MODE_PRIVATE);
		String result = ffchat.getString(key, "");
		return result;
	}

	/**
	 * �ӱ��ػ�ȡint ��������
	 * 
	 * @param context
	 * @param key
	 * @return
	 */
	public static int getIntParam(Context context, String key) {
		SharedPreferences ffchat = context.getSharedPreferences(
				SHAREDPEFERENCES_NAME, Context.MODE_PRIVATE);
		int result = ffchat.getInt(key, 0);
		return result;
	}

	/**
	 * �ӱ��ػ�ȡBoolean ��������
	 * 
	 * @param context
	 * @param key
	 * @return
	 */
	public static boolean getBooleanParam(Context context, String key) {
		SharedPreferences ffchat = context.getSharedPreferences(
				SHAREDPEFERENCES_NAME, Context.MODE_PRIVATE);
		return ffchat.getBoolean(key, false);
	}

	/**
	 * �ӱ�����ɾ������
	 * 
	 * @param context
	 * @param key
	 */
	public static void deleteParamValue(Context context, String key) {
		SharedPreferences ffchat = context.getSharedPreferences(
				SHAREDPEFERENCES_NAME, Context.MODE_PRIVATE);
		Editor ffchatedit = ffchat.edit();
		ffchatedit.remove(key);
		ffchatedit.commit();
	}
}
