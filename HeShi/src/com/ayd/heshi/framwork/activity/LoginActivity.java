package com.ayd.heshi.framwork.activity;

import java.util.HashMap;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.wechat.friends.Wechat;

import com.ayd.heshi.R;
import com.ayd.heshi.R.string;
import com.ayd.heshi.base.BaseActivity;
import com.ayd.heshi.util.LoginUtil;

/**
 * ��¼����
 * 
 * @author Administrator
 * 
 */
@SuppressLint("NewApi")
public class LoginActivity extends BaseActivity implements
		PlatformActionListener, Callback {
	// ����
	private static final int MSG_AUTH_CANCEL = 1;
	private static final int MSG_AUTH_ERROR = 2;
	private Handler handler;

	private LinearLayout actionBarBack;
	private TextView actionBarText;

	// �ؼ�
	private EditText loginTelephone, loginPwd;// �ֻ����룬����
	private Button loginDone;// ��¼
	private TextView loginToRegister, forgetPwd;// ע�ᣬ�һ�����

	// �ַ���
	private String telephone = "", psw = "";
	// ��������¼
	private ImageView loginWeixin, loginQQ, loginWeibo;
	private String accessType = "";// ��¼��ʽ 1-���� 2-��Ѷ 3-΢��

	@Override
	public void setContentLayout() {
		setContentView(R.layout.activity_login);
	}

	@Override
	public void dealLogicBeforeInitView() {
		// ��ʼ��sharesdk,���弯�ɲ����뿴�ĵ���
		// http://wiki.mob.com/Android_%E5%BF%AB%E9%80%9F%E9%9B%86%E6%88%90%E6%8C%87%E5%8D%97
		ShareSDK.initSDK(LoginActivity.this);
	}

	@Override
	public void initView() {
		handler = new Handler(this);
		actionBarBack = (LinearLayout) findViewById(R.id.action_bar_back);
		actionBarText = (TextView) findViewById(R.id.action_bar_text);
		actionBarText.setText(getResources().getText(R.string.login));
		loginTelephone = (EditText) findViewById(R.id.login_telephone_et);
		loginPwd = (EditText) findViewById(R.id.login_password_et);
		loginDone = (Button) findViewById(R.id.login_done);
		loginToRegister = (TextView) findViewById(R.id.login_to_register);
		forgetPwd = (TextView) findViewById(R.id.login_forget_psw);
		loginWeixin = (ImageView) findViewById(R.id.login_wx);
		loginQQ = (ImageView) findViewById(R.id.login_qq);
		loginWeibo = (ImageView) findViewById(R.id.login_weibo);
		setViewonClick();
	}

	@Override
	public void dealLogicAfterInitView() {

	}

	private void setViewonClick() {
		actionBarBack.setOnClickListener(this);
		loginDone.setOnClickListener(this);
		loginToRegister.setOnClickListener(this);
		forgetPwd.setOnClickListener(this);
		loginWeixin.setOnClickListener(this);
		loginQQ.setOnClickListener(this);
		loginWeibo.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.action_bar_back:
			// ����
			finish();
			break;
		case R.id.login_done:
			// ��¼
			telephone = loginTelephone.getText().toString();
			psw = loginPwd.getText().toString();
			if (telephone.isEmpty() || psw.isEmpty()) {
				// ����绰����������ǿյģ���ʾ�����ʺź�����
				showToast(R.string.please_send_user_psw);
			} else {
				if (!LoginUtil.isMobileNo(telephone)) {
					// ����绰���������ʽ��������������
					showToast(R.string.please_send_phone_again);
				} else {
					new Thread(new Runnable() {

						@Override
						public void run() {
							// ��¼�ӿ� -- ��һ���ӿ�

						}
					}) {

					}.start();
				}
			}

			break;
		case R.id.login_to_register:
			// ȥע��
			startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
			break;
		case R.id.login_forget_psw:
			// �һ����� -- ����ת���޸�������ֻ��ŵĽ��棨test��
			Intent intent = new Intent(LoginActivity.this,
					AuthenticateActivity.class);
			int index = 0;// 0 �޸����룬1 �޸��ֻ���
			Bundle bundle = new Bundle();
			bundle.putInt("auteIndex", index);
			intent.putExtras(bundle);
			startActivity(intent);
			break;
		case R.id.login_weibo:
			// ����΢��
			accessType = "1";
			Platform sina = ShareSDK.getPlatform(SinaWeibo.NAME);
			authorize(sina);
			break;
		case R.id.login_qq:
			// qq
			accessType = "2";
			Platform qq = ShareSDK.getPlatform(QQ.NAME);
			authorize(qq);
			break;
		case R.id.login_wx:
			// ΢��
			accessType = "3";
			// ����ʱ����Ҫ���ǩ����sample����ʱ������Ŀ�����demokey.keystore
			// ���ǩ��apk,Ȼ����ܲ���΢�ŵĵ�¼
			Platform wechat = ShareSDK.getPlatform(Wechat.NAME);
			authorize(wechat);
			break;
		}
	}

	// ִ����Ȩ,��ȡ�û���Ϣ
	// �ĵ���http://wiki.mob.com/Android_%E8%8E%B7%E5%8F%96%E7%94%A8%E6%88%B7%E8%B5%84%E6%96%99
	private void authorize(Platform plat) {
		if (plat == null) {
			return;
		}

		plat.setPlatformActionListener(this);
		// �ر�SSO��Ȩ
		plat.SSOSetting(true);
		plat.showUser(null);
	}

	@Override
	public void onCancel(Platform platform, int action) {
		// ȡ����Ȩ
		if (action == platform.ACTION_USER_INFOR) {
			handler.sendEmptyMessage(MSG_AUTH_CANCEL);
		}
	}

	@Override
	public void onComplete(Platform pf, int arg1, HashMap<String, Object> arg2) {
		// ��Ȩ�ɹ�
		String id = pf.getDb().getUserId();
		String name = pf.getDb().getUserName();
		ThreeLogin(id, name);
	}

	@Override
	public void onError(Platform platform, int action, Throwable t) {
		// ��Ȩʧ��
		if (action == platform.ACTION_USER_INFOR) {
			handler.sendEmptyMessage(MSG_AUTH_ERROR);
		}
		t.printStackTrace();
	}

	public void ThreeLogin(final String openid, final String name) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				// ��������¼�Ľӿ�

			}
		}).start();

	}

	@Override
	public boolean handleMessage(Message msg) {
		switch (msg.what) {
		case MSG_AUTH_CANCEL:
			// ȡ����Ȩ
			showToast(string.auth_cancel);
			break;
		case MSG_AUTH_ERROR:
			// ��Ȩʧ��
			showToast(string.auth_error);
			break;
		}
		return false;
	}

}
