package com.ayd.heshi.framwork.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ayd.heshi.R;
import com.ayd.heshi.base.BaseActivity;

public class HelpSugActivity extends BaseActivity {
	// 控件按钮
	private LinearLayout actionBarBack;

	// 界面抬头变动
	private TextView actionBarText;

	@Override
	public void setContentLayout() {
		setContentView(R.layout.activity_help_sug);
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
		actionBarText.setText(getResources().getText(R.string.help_and_sug));
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
