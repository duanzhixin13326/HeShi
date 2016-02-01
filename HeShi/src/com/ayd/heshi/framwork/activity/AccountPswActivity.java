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
 * �ʺź��������
 * 
 * @author Administrator
 * 
 */
public class AccountPswActivity extends BaseActivity {
	// �ؼ���ť
	private LinearLayout actionBarBack;
	// ����̧ͷ�䶯
	private TextView actionBarText;

	// ����ؼ�
	private RelativeLayout accoutEmail, accoutPhone, accoutPsw, accoutWeixin,
			accoutQQ, accoutWeibo;
	private TextView accoutEmailText, accoutPhoneText, accoutWeixinText,
			accoutQQText, accoutWeiboText;
	private int index;// �ж���ת��ȥ��ҳ�� 0Ϊ�޸����룬1Ϊ�޸��ֻ���

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

		// �ؼ�
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
		// ̧ͷ�����ָı�
		actionBarText.setText(getResources().getText(R.string.username_psw));
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.action_bar_back:
			finish();
			break;
		case R.id.accout_email_btn:
			// ��ʾ���� -- �޸���

			break;
		case R.id.accout_phone_btn:
			// �޸��ֻ���
			index = 1;
			jumpToAuthenticate(index);
			break;
		case R.id.accout_psw_btn:
			// �޸�����
			index = 0;
			jumpToAuthenticate(index);
			break;
		case R.id.accout_weixin_btn:
			// ��΢��

			break;
		case R.id.accout_qq_btn:
			// ��qq

			break;
		case R.id.accout_weibo_btn:
			// ��΢��

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
	 * �����������ת����֤��ݽ���
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
