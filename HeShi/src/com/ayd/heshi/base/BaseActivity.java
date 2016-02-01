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
	public boolean isAllowFullScreen;// �Ƿ�����ȫ��

	private ProgressDialog progressDialog;// ������
	private Resources resources;// ��Դ

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		resources = getResources();
		baseApplication = (BaseApplication) getApplicationContext();
		BaseApplication.unDestroyActivityList.add(this);// ��ӵ�ǰ��activity���б���

		// �ж��Ƿ�����ȫ��
		if (isAllowFullScreen) {
			setFullScreen(true);
		} else {
			setFullScreen(false);
		}

		// ����Ҫ�õ��ļ������󷽷�
		setContentLayout();
		dealLogicBeforeInitView();
		initView();
		dealLogicAfterInitView();
	}

	/**
	 * ����ȫ������ʾ���⣬trueΪȫ�����ޱ��⣬falseΪ�ޱ��⣬��setContentView()����ǩ����
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
	 * ��������ı���ķ���
	 */
	// 1�����ò����ļ�
	public abstract void setContentLayout();

	// 2����ʵ��������֮ǰ������߼�
	public abstract void dealLogicBeforeInitView();

	// 3��ʵ���������ļ�
	public abstract void initView();

	// 4����ʵ��������֮������߼� -- ����¼��ȵ�
	public abstract void dealLogicAfterInitView();

	/**
	 * onClick�����ķ�װ���˷����д������¼�
	 */
	public abstract void onClick(View v);
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		BaseApplication.unDestroyActivityList.remove(this);
	}

	/**
	 * �õ���Ļ���
	 */
	public int getScreenWidth(){
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int screenWidth = dm.widthPixels;
		return screenWidth;
	}
	
	/**
	 * �õ���Ļ�߶�
	 */
	public int getScreenHeight(){
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int screenHeight = dm.heightPixels;
		return screenHeight;
	}
	
	/**
	 * ��ʱ����ʾToast
	 */
	public void showToast(String info){
		Toast.makeText(this, info, Toast.LENGTH_SHORT).show();
	}
	
	/**
	 * ��ʱ����ʾToast
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
	 * �ж�����״̬
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
	 * ��ʾ���ڼ��صĽ�����
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
	 * �������ڼ��صĽ�����
	 * 
	 */
	public void dismissProgressDialog() {
		if (null != progressDialog && progressDialog.isShowing() == true) {
			progressDialog.dismiss();
			progressDialog = null;
		}
	}
}
