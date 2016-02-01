package com.ayd.heshi.Uzi;

import com.ayd.heshi.R.color;
import com.ayd.heshi.R.string;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.widget.Button;

public class MyCount extends CountDownTimer {
	private Button tv_seconds;

	public MyCount(long millisInFuture, long countDownInterval) {
		super(millisInFuture, countDownInterval);
	}

	public MyCount(long millisInFuture, long countDownInterval,
			Button tv_seconds) {
		super(millisInFuture, countDownInterval);
		this.tv_seconds = tv_seconds;
	}

	@Override
	public void onFinish() {
		tv_seconds.setTextColor(color.check_text);
		tv_seconds.setText(string.get_code_again);
		tv_seconds.setEnabled(true);
	}

	@Override
	public void onTick(long millisUntilFinished) {
		tv_seconds.setTextColor(color.check_text);
		// tv_seconds.setBackgroundColor(Color.WHITE);
		tv_seconds.setEnabled(false);
		tv_seconds.setText(millisUntilFinished / 1000 + "ÃëºóÖØ·¢");
	}

}
