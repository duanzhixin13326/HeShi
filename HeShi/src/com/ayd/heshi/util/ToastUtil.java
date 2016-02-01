package com.ayd.heshi.util;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
	/**
	 * ��ʱ����ʾToast
	 * 
	 * @param context
	 * @param str
	 */
	public static void showToastShort(Context context, String str) {
		Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
	}

	/**
	 * ��ʱ����ʾToast
	 * 
	 * @param context
	 * @param str
	 */
	public static void showToastLong(Context context, String str) {
		Toast.makeText(context, str, Toast.LENGTH_LONG).show();
	}

	/**
	 * ��ʱ����ʾToast
	 * 
	 * @param context
	 * @param id
	 */
	public static void showToastShort(Context context, int id) {
		Toast.makeText(context, id, Toast.LENGTH_SHORT).show();
	}

	/**
	 * ��ʱ����ʾToast
	 * 
	 * @param context
	 * @param id
	 */
	public static void showToastLong(Context context, int id) {
		Toast.makeText(context, id, Toast.LENGTH_LONG).show();
	}
}
