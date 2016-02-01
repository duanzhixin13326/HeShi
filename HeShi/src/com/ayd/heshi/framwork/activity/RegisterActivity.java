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
 * ע�����
 * 
 * @author Administrator
 * 
 */
@SuppressLint("NewApi")
public class RegisterActivity extends BaseActivity {
	private LinearLayout actionBarBack;
	private TextView actionBarText;

	// �ؼ�
	private EditText registerPhone, registerCode, registerPsw;// �ֻ��ţ���֤�룬����
	private Button getCode, registerDone;// ��ȡ��֤���ţ����ע��
	private TextView toLogin;// ���ص���¼����

	// �ַ���
	private String telephone = "", password = "", theCode = "";// �ֻ��ţ�����,�������֤��
	private String yzm = "";// ��ȡ����֤��

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
	 * ���ÿؼ��Ŀɵ��
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
			// ����
			finish();
			break;
		case R.id.register_get_code:
			// ��ȡ��֤��
			telephone = registerPhone.getText().toString();
			if (telephone.isEmpty()) {
				showToast(R.string.please_send_phone_first);
			} else {
				if (!LoginUtil.isMobileNo(telephone)) {
					// ������������ʽ��������������
					showToast(R.string.please_send_phone_again);
				} else {
					MyCount mc = new MyCount(60000, 1000, getCode);
					mc.start();
					new Thread(new Runnable() {

						@Override
						public void run() {
							// ��ȡ��֤��Ľӿ�

						}
					}).start();
				}
			}

			break;
		case R.id.register_done:
			// ���ע��
			telephone = registerPhone.getText().toString();
			theCode = registerCode.getText().toString();
			password = registerPsw.getText().toString();
			String reg_psw = "^[0-9A-Za-z]{6,10}$";// �ж�����ĸ�ʽ

			if (telephone.isEmpty()) {
				// �������Ϊ�գ���������
				showToast(string.please_send_phone_first);
			} else if (!LoginUtil.isMobileNo(telephone)) {
				// ������������ʽ��������������
				showToast(R.string.please_send_phone_again);
			} else if (theCode.equals("")) {
				// �����֤��Ϊ�գ���������
				showToast(string.please_send_thecode_first);
			} else if (!yzm.equals(theCode)) {
				// ����������֤�����ȡ����֤�벻һ�£�����������
				showToast(string.thecode_iswrong);
			} else if (password.equals("")) {
				// �������Ϊ�գ���������
				showToast(string.please_send_login_psw);
			} else if (!StringUtil.match(reg_psw, password)) {
				// �������������ʽ����ȷ������������
				showToast(string.please_send_psw_again);
			} else {
				new Thread(new Runnable() {

					@Override
					public void run() {
						// ע��Ľӿ� -- ��һ���ӿ�

					}
				}).start();
			}

			break;
		case R.id.register_to_login:
			// ȥ��¼
			startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
			break;
		}
	}
}
