package com.ayd.heshi.framwork.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ayd.heshi.R;
import com.ayd.heshi.base.BaseActivity;

/**
 * 我的灵感库界面
 * 
 * @author Administrator
 * 
 */
public class InspirationHome extends BaseActivity {
	// 控件按钮
	private LinearLayout actionBarBack;
	// 界面抬头变动
	private TextView actionBarText;

	@Override
	public void setContentLayout() {
		setContentView(R.layout.activity_inspiration_home);
	}

	@Override
	public void dealLogicBeforeInitView() {
		
	}

	@Override
	public void initView() {
		actionBarBack = (LinearLayout) findViewById(R.id.action_bar_back);
		actionBarBack.setOnClickListener(this);
		actionBarText = (TextView) findViewById(R.id.action_bar_text);
	}

	@Override
	public void dealLogicAfterInitView() {
		// 抬头的文字改变
		actionBarText.setText(getResources().getText(R.string.set_msg));

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.action_bar_back:
			// 结束当前页面
			finish();
			break;

		default:
			break;
		}
	}
	

}
