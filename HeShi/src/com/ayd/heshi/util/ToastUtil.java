package com.ayd.heshi.util;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
	/**
	 * 短时间显示Toast
	 * 
	 * @param context
	 * @param str
	 */
	public static void showToastShort(Context context, String str) {
		Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
	}

	/**
	 * 长时间显示Toast
	 * 
	 * @param context
	 * @param str
	 */
	public static void showToastLong(Context context, String str) {
		Toast.makeText(context, str, Toast.LENGTH_LONG).show();
	}

	/**
	 * 短时间显示Toast
	 * 
	 * @param context
	 * @param id
	 */
	public static void showToastShort(Context context, int id) {
		Toast.makeText(context, id, Toast.LENGTH_SHORT).show();
	}

	/**
	 * 长时间显示Toast
	 * 
	 * @param context
	 * @param id
	 */
	public static void showToastLong(Context context, int id) {
		Toast.makeText(context, id, Toast.LENGTH_LONG).show();
	}
}
