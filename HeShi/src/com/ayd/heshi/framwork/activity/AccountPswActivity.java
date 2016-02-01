package com.ayd.heshi.framwork.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ayd.heshi.R;
import com.ayd.heshi.base.BaseActivity;

/**
 * 帐号和密码界面
 * 
 * @author Administrator
 * 
 */
public class AccountPswActivity extends BaseActivity {
	// 控件按钮
	private LinearLayout actionBarBack;
	// 界面抬头变动
	private TextView actionBarText;

	// 点击控件
	private RelativeLayout accoutEmail, accoutPhone, accoutPsw, accoutWeixin,
			accoutQQ, accoutWeibo;
	private TextView accoutEmailText, accoutPhoneText, accoutWeixinText,
			accoutQQText, accoutWeiboText;
	private int index;// 判断跳转过去的页面 0为修改密码，1为修改手机号

	public void setContentLayout() {
		setContentView(R.layout.activity_account_psw);
	}

	@Override
	public void dealLogicBeforeInitView() {
		
	}

	@Override
	public void initView() {
		actionBarBack = (LinearLayout) findViewById(R.id.action_bar_back);
		actionBarBack.setOnClickListener(this);
		actionBarText = (TextView) findViewById(R.id.action_bar_text);

		// 控件
		accoutEmail = (RelativeLayout) findViewById(R.id.accout_email_btn);
		accoutPhone = (RelativeLayout) findViewById(R.id.accout_phone_btn);
		accoutPsw = (RelativeLayout) findViewById(R.id.accout_psw_btn);
		accoutWeixin = (RelativeLayout) findViewById(R.id.accout_weixin_btn);
		accoutQQ = (RelativeLayout) findViewById(R.id.accout_qq_btn);
		accoutWeibo = (RelativeLayout) findViewById(R.id.accout_weibo_btn);
		accoutEmailText = (TextView) findViewById(R.id.accout_email_text);
		accoutPhoneText = (TextView) findViewById(R.id.accout_phone_text);
		accoutWeixinText = (TextView) findViewById(R.id.accout_weixin_text);
		accoutQQText = (TextView) findViewById(R.id.accout_qq_text);
		accoutWeiboText = (TextView) findViewById(R.id.accout_weibo_text);
		setViewOnClick();
	}

	@Override
	public void dealLogicAfterInitView() {
		// 抬头的文字改变
		actionBarText.setText(getResources().getText(R.string.username_psw));
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.action_bar_back:
			finish();
			break;
		case R.id.accout_email_btn:
			// 显示邮箱 -- 修改吗？

			break;
		case R.id.accout_phone_btn:
			// 修改手机号
			index = 1;
			jumpToAuthenticate(index);
			break;
		case R.id.accout_psw_btn:
			// 修改密码
			index = 0;
			jumpToAuthenticate(index);
			break;
		case R.id.accout_weixin_btn:
			// 绑定微信

			break;
		case R.id.accout_qq_btn:
			// 绑定qq

			break;
		case R.id.accout_weibo_btn:
			// 绑定微博

			break;
		}
	}

	private void setViewOnClick() {
		accoutEmail.setOnClickListener(this);
		accoutPhone.setOnClickListener(this);
		accoutPsw.setOnClickListener(this);
		accoutWeixin.setOnClickListener(this);
		accoutQQ.setOnClickListener(this);
		accoutWeibo.setOnClickListener(this);
	}

	/**
	 * 根据情况，跳转到验证身份界面
	 * 
	 * @param index
	 */
	private void jumpToAuthenticate(int index) {
		Intent intent = new Intent(AccountPswActivity.this,
				AuthenticateActivity.class);
		Bundle bundle = new Bundle();
		bundle.putInt("auteIndex", index);
		intent.putExtras(bundle);
		startActivity(intent);
	}

}
