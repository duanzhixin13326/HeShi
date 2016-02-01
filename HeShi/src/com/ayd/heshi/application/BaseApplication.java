package com.ayd.heshi.application;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

public class BaseApplication extends Application {
	/**
	 * 存放活动状态的Activity列表
	 */
	public static List<Activity> unDestroyActivityList = new ArrayList<Activity>();
	public BaseApplication baseApplication;

	public synchronized BaseApplication getInstance() {
		if (null == baseApplication) {
			baseApplication = new BaseApplication();
		}
		return baseApplication;
	}

	@Override
	public void onCreate() {
		baseApplication = this;
		super.onCreate();
	}

	/**
	 * 得到系统的版本号
	 * 
	 * @return
	 */
	public String getOSVersion() {
		return android.os.Build.VERSION.RELEASE;
	}

	/**
	 * 得到应用的版本号
	 */
	public int getAppVersionCode() {
		PackageManager packageManager = getPackageManager();
		PackageInfo packageInfo = null;
		int versionCode = 0;
		try {
			packageInfo = packageManager.getPackageInfo(getPackageName(), 0);
			versionCode = packageInfo.versionCode;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		return versionCode;
	}

	/**
	 * 得到应用的版本信息
	 * 
	 * @return
	 */
	public String getAppVersionName() {
		PackageManager packageManager = getPackageManager();
		PackageInfo packageInfo = null;
		String versionName = "";
		try {
			packageInfo = packageManager.getPackageInfo(getPackageName(), 0);
			versionName = packageInfo.versionName;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		return versionName;
	}

	/**
	 * 退出系统
	 */
	public void quit() {
		for (Activity activity : unDestroyActivityList) {
			if (null != activity) {
				activity.finish();
			}
		}
		unDestroyActivityList.clear();
	}

}
