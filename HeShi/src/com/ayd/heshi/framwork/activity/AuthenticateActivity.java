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
 * 验证身份界面
 * 
 * @author Administrator
 * 
 */
@SuppressLint("NewApi")
public class AuthenticateActivity extends BaseActivity {
	// 控件
	private LinearLayout actionBarBack;// 返回
	private TextView actionBarText;
	// 页面加载
	private FragmentManager fragmentManager;
	private UpdatePsw upPsw;
	private UpdatePhone upPhone;

	private int index;// 从上个页面传递过来的参数

	@Override
	public void setContentLayout() {
		setContentView(R.layout.activity_authenticate);
	}

	@Override
	public void dealLogicBeforeInitView() {
		// 在初始化界面之前，获取从上个页面传递过来的参数
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
		// 加载界面
		addViewToContent(index);
		// 更改抬头
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
	 * 根据参数加载不同的内容到界面 0为修改密码，1为修改手机号
	 * 
	 * @param index
	 */
	private void addViewToContent(int index) {
		// 开启一个Fragment事务
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
		transaction.commit();// 提交
	}

	/**
	 * 隐藏fragment
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
	 * 根据情况，修改抬头
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
