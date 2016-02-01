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
 * 登录界面
 * 
 * @author Administrator
 * 
 */
@SuppressLint("NewApi")
public class LoginActivity extends BaseActivity implements
		PlatformActionListener, Callback {
	// 常量
	private static final int MSG_AUTH_CANCEL = 1;
	private static final int MSG_AUTH_ERROR = 2;
	private Handler handler;

	private LinearLayout actionBarBack;
	private TextView actionBarText;

	// 控件
	private EditText loginTelephone, loginPwd;// 手机号码，密码
	private Button loginDone;// 登录
	private TextView loginToRegister, forgetPwd;// 注册，找回密码

	// 字符串
	private String telephone = "", psw = "";
	// 第三方登录
	private ImageView loginWeixin, loginQQ, loginWeibo;
	private String accessType = "";// 登录方式 1-新浪 2-腾讯 3-微信

	@Override
	public void setContentLayout() {
		setContentView(R.layout.activity_login);
	}

	@Override
	public void dealLogicBeforeInitView() {
		// 初始化sharesdk,具体集成步骤请看文档：
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
			// 返回
			finish();
			break;
		case R.id.login_done:
			// 登录
			telephone = loginTelephone.getText().toString();
			psw = loginPwd.getText().toString();
			if (telephone.isEmpty() || psw.isEmpty()) {
				// 如果电话号码和密码是空的，提示输入帐号和密码
				showToast(R.string.please_send_user_psw);
			} else {
				if (!LoginUtil.isMobileNo(telephone)) {
					// 如果电话号码输入格式错误，请重新输入
					showToast(R.string.please_send_phone_again);
				} else {
					new Thread(new Runnable() {

						@Override
						public void run() {
							// 登录接口 -- 差一个接口

						}
					}) {

					}.start();
				}
			}

			break;
		case R.id.login_to_register:
			// 去注册
			startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
			break;
		case R.id.login_forget_psw:
			// 找回密码 -- 先跳转到修改密码和手机号的界面（test）
			Intent intent = new Intent(LoginActivity.this,
					AuthenticateActivity.class);
			int index = 0;// 0 修改密码，1 修改手机号
			Bundle bundle = new Bundle();
			bundle.putInt("auteIndex", index);
			intent.putExtras(bundle);
			startActivity(intent);
			break;
		case R.id.login_weibo:
			// 新浪微博
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
			// 微信
			accessType = "3";
			// 测试时，需要打包签名；sample测试时，用项目里面的demokey.keystore
			// 打包签名apk,然后才能产生微信的登录
			Platform wechat = ShareSDK.getPlatform(Wechat.NAME);
			authorize(wechat);
			break;
		}
	}

	// 执行授权,获取用户信息
	// 文档：http://wiki.mob.com/Android_%E8%8E%B7%E5%8F%96%E7%94%A8%E6%88%B7%E8%B5%84%E6%96%99
	private void authorize(Platform plat) {
		if (plat == null) {
			return;
		}

		plat.setPlatformActionListener(this);
		// 关闭SSO授权
		plat.SSOSetting(true);
		plat.showUser(null);
	}

	@Override
	public void onCancel(Platform platform, int action) {
		// 取消授权
		if (action == platform.ACTION_USER_INFOR) {
			handler.sendEmptyMessage(MSG_AUTH_CANCEL);
		}
	}

	@Override
	public void onComplete(Platform pf, int arg1, HashMap<String, Object> arg2) {
		// 授权成功
		String id = pf.getDb().getUserId();
		String name = pf.getDb().getUserName();
		ThreeLogin(id, name);
	}

	@Override
	public void onError(Platform platform, int action, Throwable t) {
		// 授权失败
		if (action == platform.ACTION_USER_INFOR) {
			handler.sendEmptyMessage(MSG_AUTH_ERROR);
		}
		t.printStackTrace();
	}

	public void ThreeLogin(final String openid, final String name) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				// 第三方登录的接口

			}
		}).start();

	}

	@Override
	public boolean handleMessage(Message msg) {
		switch (msg.what) {
		case MSG_AUTH_CANCEL:
			// 取消授权
			showToast(string.auth_cancel);
			break;
		case MSG_AUTH_ERROR:
			// 授权失败
			showToast(string.auth_error);
			break;
		}
		return false;
	}

}
