package com.ayd.heshi.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.BadTokenException;
import android.widget.Toast;

import com.ayd.heshi.R;
import com.ayd.heshi.application.BaseApplication;

public abstract class BaseActivity extends Activity implements OnClickListener{
	protected BaseApplication baseApplication;
	public boolean isAllowFullScreen;// 是否允许全屏

	private ProgressDialog progressDialog;// 进度条
	private Resources resources;// 资源

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		resources = getResources();
		baseApplication = (BaseApplication) getApplicationContext();
		BaseApplication.unDestroyActivityList.add(this);// 添加当前的activity到列表中

		// 判断是否允许全屏
		if (isAllowFullScreen) {
			setFullScreen(true);
		} else {
			setFullScreen(false);
		}

		// 必须要用到的几个抽象方法
		setContentLayout();
		dealLogicBeforeInitView();
		initView();
		dealLogicAfterInitView();
	}

	/**
	 * 设置全屏和显示标题，true为全屏和无标题，false为无标题，在setContentView()方法签调用
	 */
	public void setFullScreen(boolean fullScreen) {
		if (fullScreen) {
			requestWindowFeature(Window.FEATURE_NO_TITLE);
			getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
					WindowManager.LayoutParams.FLAG_FULLSCREEN);
		} else {
			requestWindowFeature(Window.FEATURE_NO_TITLE);
		}
	}

	/**
	 * 几个抽象的必须的方法
	 */
	// 1、设置布局文件
	public abstract void setContentLayout();

	// 2、在实例化布局之前处理的逻辑
	public abstract void dealLogicBeforeInitView();

	// 3、实例化布局文件
	public abstract void initView();

	// 4、在实例化布局之后处理的逻辑 -- 点击事件等等
	public abstract void dealLogicAfterInitView();

	/**
	 * onClick方法的封装，此方法中处理点击事件
	 */
	public abstract void onClick(View v);
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		BaseApplication.unDestroyActivityList.remove(this);
	}

	/**
	 * 得到屏幕宽度
	 */
	public int getScreenWidth(){
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int screenWidth = dm.widthPixels;
		return screenWidth;
	}
	
	/**
	 * 得到屏幕高度
	 */
	public int getScreenHeight(){
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int screenHeight = dm.heightPixels;
		return screenHeight;
	}
	
	/**
	 * 短时间显示Toast
	 */
	public void showToast(String info){
		Toast.makeText(this, info, Toast.LENGTH_SHORT).show();
	}
	
	/**
	 * 长时间显示Toast
	 */
	public void showToastLong(String info){
		Toast.makeText(this, info, Toast.LENGTH_LONG).show();
	}
	
	public void showToast(int resId){
		Toast.makeText(this, resId, Toast.LENGTH_SHORT).show();
	}
	
	public void showTostLong(int resId){
		Toast.makeText(this, resId, Toast.LENGTH_LONG).show();
	}
	
	
	/**
	 * 判断联网状态
	 */
	protected static boolean isNet(Context context) {
		if(context != null){
			ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
			if(mNetworkInfo != null){
				return mNetworkInfo.isAvailable();
			}
		}
		return false;
	}
	
	
	/**
	 * 显示正在加载的进度条
	 */
	public void showProgressDialog(){
		if(progressDialog != null && progressDialog.isShowing()){
			progressDialog.dismiss();
			progressDialog = null;
		}
		progressDialog = new ProgressDialog(BaseActivity.this);
		progressDialog.setMessage(getResources().getString(R.string.logining));
		try {
			progressDialog.show();
		} catch (BadTokenException exception) {
			exception.printStackTrace();
		}
	}
	
	public void showProgressDialog(String msg){
		if(progressDialog != null && progressDialog.isShowing()){
			progressDialog.dismiss();
			progressDialog = null;
		}
		progressDialog = new ProgressDialog(BaseActivity.this);
		progressDialog.setMessage(msg);
		try {
			progressDialog.show();
		} catch (BadTokenException exception) {
			exception.printStackTrace();
		}
	}
	
	public void showProgressDialog2() {
		OnKeyListener keyListener = new OnKeyListener() {
			@Override
			public boolean onKey(DialogInterface dialog, int keyCode,
					KeyEvent event) {
				if (keyCode == KeyEvent.KEYCODE_HOME
						|| keyCode == KeyEvent.KEYCODE_SEARCH) {
					return true;
				}
				return false;
			}
		};
		if (progressDialog != null && progressDialog.isShowing()) {
			progressDialog.dismiss();
			progressDialog = null;
		}
		progressDialog = new ProgressDialog(this, R.style.MyDialog);
		progressDialog.setCanceledOnTouchOutside(true);
		progressDialog.setIndeterminate(false);
		progressDialog.setOnKeyListener(keyListener);
		progressDialog.setCancelable(true);
		progressDialog.show();
		progressDialog.setContentView(R.layout.dialog_loading_process);
	}

	public ProgressDialog createProgressDialog(String msg) {
		ProgressDialog progressDialog = new ProgressDialog(BaseActivity.this);
		progressDialog.setMessage(msg);
		return progressDialog;
	}

	/**
	 * 隐藏正在加载的进度条
	 * 
	 */
	public void dismissProgressDialog() {
		if (null != progressDialog && progressDialog.isShowing() == true) {
			progressDialog.dismiss();
			progressDialog = null;
		}
	}
}
