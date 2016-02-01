package com.ayd.heshi.framwork.activity;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ayd.heshi.R;
import com.ayd.heshi.R.string;
import com.ayd.heshi.base.BaseActivity;
import com.ayd.heshi.framwork.fragment.UpdatePhone;
import com.ayd.heshi.framwork.fragment.UpdatePsw;

/**
 * ��֤��ݽ���
 * 
 * @author Administrator
 * 
 */
@SuppressLint("NewApi")
public class AuthenticateActivity extends BaseActivity {
	// �ؼ�
	private LinearLayout actionBarBack;// ����
	private TextView actionBarText;
	// ҳ�����
	private FragmentManager fragmentManager;
	private UpdatePsw upPsw;
	private UpdatePhone upPhone;

	private int index;// ���ϸ�ҳ�洫�ݹ����Ĳ���

	@Override
	public void setContentLayout() {
		setContentView(R.layout.activity_authenticate);
	}

	@Override
	public void dealLogicBeforeInitView() {
		// �ڳ�ʼ������֮ǰ����ȡ���ϸ�ҳ�洫�ݹ����Ĳ���
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		index = bundle.getInt("auteIndex");
	}

	@Override
	public void initView() {
		actionBarBack = (LinearLayout) findViewById(R.id.action_bar_back);
		actionBarBack.setOnClickListener(this);
		actionBarText = (TextView) findViewById(R.id.action_bar_text);
		actionBarText.setText(string.authenticate);
	}

	@Override
	public void dealLogicAfterInitView() {
		fragmentManager = getFragmentManager();
		// ���ؽ���
		addViewToContent(index);
		// ����̧ͷ
		addActionBarText(index);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.action_bar_back:
			finish();
			break;

		default:
			break;
		}
	}

	/**
	 * ���ݲ������ز�ͬ�����ݵ����� 0Ϊ�޸����룬1Ϊ�޸��ֻ���
	 * 
	 * @param index
	 */
	private void addViewToContent(int index) {
		// ����һ��Fragment����
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		hideFragments(transaction);
		switch (index) {
		case 0:
			if (upPsw == null) {
				upPsw = new UpdatePsw();
				transaction.add(R.id.authenticate_content, upPsw);
			} else {
				transaction.show(upPsw);
			}
			break;

		case 1:
			if (upPhone == null) {
				upPhone = new UpdatePhone();
				transaction.add(R.id.authenticate_content, upPhone);
			} else {
				transaction.show(upPhone);
			}
			break;
		}
		transaction.commit();// �ύ
	}

	/**
	 * ����fragment
	 * 
	 * @param transaction
	 */
	private void hideFragments(FragmentTransaction transaction) {
		if (upPsw != null) {
			transaction.hide(upPsw);
		}
		if (upPhone != null) {
			transaction.hide(upPhone);
		}
	}

	/**
	 * ����������޸�̧ͷ
	 * 
	 * @param index
	 */
	private void addActionBarText(int index) {
		switch (index) {
		case 0:
			actionBarText.setText(string.updata_psw);
			break;
		case 1:
			actionBarText.setText(string.updata_phone);
			break;
		}
	}
}
