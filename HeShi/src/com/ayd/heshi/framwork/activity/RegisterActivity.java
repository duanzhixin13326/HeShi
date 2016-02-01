package com.ayd.heshi.framwork.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ayd.heshi.R;
import com.ayd.heshi.R.string;
import com.ayd.heshi.Uzi.MyCount;
import com.ayd.heshi.base.BaseActivity;
import com.ayd.heshi.util.LoginUtil;
import com.ayd.heshi.util.StringUtil;

/**
 * 注册界面
 * 
 * @author Administrator
 * 
 */
@SuppressLint("NewApi")
public class RegisterActivity extends BaseActivity {
	private LinearLayout actionBarBack;
	private TextView actionBarText;

	// 控件
	private EditText registerPhone, registerCode, registerPsw;// 手机号，验证码，密码
	private Button getCode, registerDone;// 获取验证短信，完成注册
	private TextView toLogin;// 返回到登录界面

	// 字符串
	private String telephone = "", password = "", theCode = "";// 手机号，密码,输入的验证码
	private String yzm = "";// 获取的验证码

	@Override
	public void setContentLayout() {
		setContentView(R.layout.activity_register);
	}

	@Override
	public void dealLogicBeforeInitView() {

	}

	@Override
	public void initView() {
		actionBarBack = (LinearLayout) findViewById(R.id.action_bar_back);
		actionBarText = (TextView) findViewById(R.id.action_bar_text);
		actionBarText.setText(getResources().getText(R.string.register));
		registerPhone = (EditText) findViewById(R.id.register_telephone_et);
		registerCode = (EditText) findViewById(R.id.register_thecode_et);
		registerPsw = (EditText) findViewById(R.id.register_password_et);
		getCode = (Button) findViewById(R.id.register_get_code);
		registerDone = (Button) findViewById(R.id.register_done);
		toLogin = (TextView) findViewById(R.id.register_to_login);
		setViewOnClick();
	}

	@Override
	public void dealLogicAfterInitView() {

	}

	/**
	 * 设置控件的可点击
	 */
	private void setViewOnClick() {
		actionBarBack.setOnClickListener(this);
		getCode.setOnClickListener(this);
		registerDone.setOnClickListener(this);
		toLogin.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.action_bar_back:
			// 返回
			finish();
			break;
		case R.id.register_get_code:
			// 获取验证码
			telephone = registerPhone.getText().toString();
			if (telephone.isEmpty()) {
				showToast(R.string.please_send_phone_first);
			} else {
				if (!LoginUtil.isMobileNo(telephone)) {
					// 如果号码输入格式有误，请重新输入
					showToast(R.string.please_send_phone_again);
				} else {
					MyCount mc = new MyCount(60000, 1000, getCode);
					mc.start();
					new Thread(new Runnable() {

						@Override
						public void run() {
							// 获取验证码的接口

						}
					}).start();
				}
			}

			break;
		case R.id.register_done:
			// 完成注册
			telephone = registerPhone.getText().toString();
			theCode = registerCode.getText().toString();
			password = registerPsw.getText().toString();
			String reg_psw = "^[0-9A-Za-z]{6,10}$";// 判断密码的格式

			if (telephone.isEmpty()) {
				// 如果号码为空，请先输入
				showToast(string.please_send_phone_first);
			} else if (!LoginUtil.isMobileNo(telephone)) {
				// 如果号码输入格式有误，请重新输入
				showToast(R.string.please_send_phone_again);
			} else if (theCode.equals("")) {
				// 如果验证码为空，请先输入
				showToast(string.please_send_thecode_first);
			} else if (!yzm.equals(theCode)) {
				// 如果输入的验证码与获取的验证码不一致，请重新输入
				showToast(string.thecode_iswrong);
			} else if (password.equals("")) {
				// 如果密码为空，请先输入
				showToast(string.please_send_login_psw);
			} else if (!StringUtil.match(reg_psw, password)) {
				// 如果输入的密码格式不正确，请重新输入
				showToast(string.please_send_psw_again);
			} else {
				new Thread(new Runnable() {

					@Override
					public void run() {
						// 注册的接口 -- 差一个接口

					}
				}).start();
			}

			break;
		case R.id.register_to_login:
			// 去登录
			startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
			break;
		}
	}
}
