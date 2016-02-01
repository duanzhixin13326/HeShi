package com.ayd.heshi.framwork.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ayd.heshi.R;
import com.ayd.heshi.base.BaseActivity;

/**
 * ��Ϣ���ý���
 * 
 * @author Administrator
 * 
 */
public class SetMessageActivity extends BaseActivity {
	// �ؼ���ť
	private LinearLayout actionBarBack;

	// ����̧ͷ�䶯
	private TextView actionBarText;

	public void setContentLayout() {
		setContentView(R.layout.activity_set_message);
	}

	@Override
	public void dealLogicBeforeInitView() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initView() {
		actionBarBack = (LinearLayout) findViewById(R.id.action_bar_back);
		actionBarBack.setOnClickListener(this);
		actionBarText = (TextView) findViewById(R.id.action_bar_text);
	}

	@Override
	public void dealLogicAfterInitView() {
		// ̧ͷ�����ָı�
		actionBarText.setText(getResources().getText(R.string.set_msg));
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

}
