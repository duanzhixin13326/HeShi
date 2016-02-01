package com.ayd.heshi.framwork.fragment;

import com.ayd.heshi.R;
import com.ayd.heshi.R.string;
import com.ayd.heshi.Uzi.MyCount;
import com.ayd.heshi.util.LoginUtil;
import com.ayd.heshi.util.StringUtil;
import com.ayd.heshi.util.ToastUtil;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * 更改手机号
 * 
 * @author Administrator
 * 
 */
@SuppressLint("NewApi")
public class UpdatePhone extends Fragment implements OnClickListener {
	// 控件
	private EditText pswEdit, newTelEdit, codeEdit;// 输入密码、输入新号码，输入验证码
	private Button getCode, done;
	// 字符串
	private String newPhone, thecode, password;// 新手机号，验证码，登录密码
	private String yzm;// 验证码

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_updata_phone, container,
				false);
		findView(view);
		return view;
	}

	/**
	 * 界面控件初始化
	 * 
	 * @param v
	 */
	private void findView(View v) {
		pswEdit = (EditText) v.findViewById(R.id.newphone_psw_et);
		newTelEdit = (EditText) v.findViewById(R.id.newphone_tel_et);
		codeEdit = (EditText) v.findViewById(R.id.newphone_code_et);
		getCode = (Button) v.findViewById(R.id.newphone_get_code);
		done = (Button) v.findViewById(R.id.newphone_done);
		getCode.setOnClickListener(this);
		done.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.newphone_get_code:
			// 获取验证码
			newPhone = newTelEdit.getText().toString();
			if (newPhone.isEmpty()) {
				ToastUtil.showToastShort(getActivity(),
						string.please_send_phone_first);
			} else {
				if (!LoginUtil.isMobileNo(newPhone)) {
					ToastUtil.showToastShort(getActivity(),
							string.please_send_phone_again);
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
		case R.id.newphone_done:
			// 完成
			password = pswEdit.getText().toString();
			newPhone = newTelEdit.getText().toString();
			thecode = codeEdit.getText().toString();
			String reg_psw = "^[0-9A-Za-z]{6,10}$";// 判断密码的格式

			if (password.equals("")) {
				ToastUtil.showToastShort(getActivity(),
						string.please_send_login_psw);
			} else if (!StringUtil.match(reg_psw, password)) {
				ToastUtil.showToastShort(getActivity(),
						string.please_send_psw_again);
			} else if (newPhone.isEmpty()) {
				ToastUtil.showToastShort(getActivity(),
						string.please_send_new_phone);
			} else if (!LoginUtil.isMobileNo(newPhone)) {
				ToastUtil.showToastShort(getActivity(),
						string.please_send_phone_again);
			} else if (thecode.equals("")) {
				ToastUtil.showToastShort(getActivity(),
						string.please_send_thecode_first);
			} else if (!yzm.equals(thecode)) {
				ToastUtil.showToastShort(getActivity(), string.thecode_iswrong);
			} else {
				new Thread(new Runnable() {

					@Override
					public void run() {
						// 修改手机号的接口
						
					}
				}).start();
			}

			break;
		}
	}
}
