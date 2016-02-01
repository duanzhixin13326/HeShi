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
 * ��������
 * 
 * @author Administrator
 * 
 */
@SuppressLint("NewApi")
public class UpdatePsw extends Fragment implements OnClickListener {
	// �ؼ�
	private EditText telEdit, codeEdit, passwordEdit;// ����绰���롢��֤�롢������
	private Button getCode, done;

	// �ַ���
	private String phone, thecode, newPsw;// �绰���룬�������֤�룬������
	private String yzm;// ��ȡ����֤��

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_updata_psw, container,
				false);
		findView(view);
		return view;
	}

	/**
	 * ����ؼ���ʼ��
	 * 
	 * @param v
	 */
	private void findView(View v) {
		telEdit = (EditText) v.findViewById(R.id.newpsw_telephone_et);
		codeEdit = (EditText) v.findViewById(R.id.newpsw_thecode_et);
		passwordEdit = (EditText) v.findViewById(R.id.newpsw_password_et);
		getCode = (Button) v.findViewById(R.id.newpsw_get_code);
		done = (Button) v.findViewById(R.id.newpsw_done);
		getCode.setOnClickListener(this);
		done.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.newpsw_get_code:
			// ��ȡ��֤��
			phone = telEdit.getText().toString();
			if (phone.isEmpty()) {
				ToastUtil.showToastShort(getActivity(),
						string.please_send_phone_first);
			} else {
				if (!LoginUtil.isMobileNo(phone)) {
					ToastUtil.showToastShort(getActivity(),
							string.please_send_phone_again);
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
		case R.id.newpsw_done:
			// ��ɸ���
			phone = telEdit.getText().toString();
			thecode = codeEdit.getText().toString();
			newPsw = passwordEdit.getText().toString();

			String reg_psw = "^[0-9A-Za-z]{6,10}$";// �ж�����ĸ�ʽ
			if (phone.isEmpty()) {
				ToastUtil.showToastShort(getActivity(),
						string.please_send_phone_first);
			} else if (!LoginUtil.isMobileNo(phone)) {
				ToastUtil.showToastShort(getActivity(),
						string.please_send_phone_again);
			} else if (thecode.equals("")) {
				ToastUtil.showToastShort(getActivity(),
						string.please_send_thecode_first);
			} else if (!yzm.equals(thecode)) {
				ToastUtil.showToastShort(getActivity(), string.thecode_iswrong);
			} else if (newPsw.equals("")) {
				// �������Ϊ�գ���������
				ToastUtil.showToastShort(getActivity(),
						string.please_send_login_psw);
			} else if (StringUtil.match(reg_psw, newPsw)) {
				// �������������ʽ����ȷ������������
				ToastUtil.showToastShort(getActivity(),
						string.please_send_psw_again);
			} else {
				new Thread(new Runnable() {

					@Override
					public void run() {
						// ��������Ľӿ�

					}
				}).start();
			}

			break;
		}
	}
}
