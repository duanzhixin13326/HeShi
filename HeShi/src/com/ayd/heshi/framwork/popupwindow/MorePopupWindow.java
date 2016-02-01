package com.ayd.heshi.framwork.popupwindow;

import com.ayd.heshi.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;

/**
 * ��������ĵ�����
 * 
 * @author Administrator
 * 
 */
public class MorePopupWindow extends PopupWindow {
	private View contentView;

	public MorePopupWindow(Activity context) {
		LayoutInflater mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		contentView = mInflater.inflate(R.layout.taxon_layout, null);
		int h = context.getWindowManager().getDefaultDisplay().getHeight();
		int w = context.getWindowManager().getDefaultDisplay().getWidth();
		// ����SelectPicPopupWindow��View
		this.setContentView(contentView);
		// ����SelectPicPopupWindow��������Ŀ���
		this.setWidth(w / 2 + 50);
		this.setHeight(LayoutParams.MATCH_PARENT);
		// ����SelectPoPupWindow��������ɵ��
		this.setFocusable(true);
		this.setOutsideTouchable(true);
		// ˢ��״̬
		this.update();
		// ʵ����һ��ColorDrawable��ɫΪ��͸��
		ColorDrawable dw = new ColorDrawable(00000000);
		// ��back���������ط�ʹ����ʧ��������������ܳ���OnDismisslistener�����������ؼ��仯�Ȳ���
		this.setBackgroundDrawable(dw);
		// ����SelectPicPopupWindow�������嶯��Ч��
		this.setAnimationStyle(R.style.AnimationPreview);
	}

	public void showPopupWindow(View parent) {
		if (!this.isShowing()) {
			this.showAsDropDown(parent, parent.getLayoutParams().width / 2, 18);
		} else {
			this.dismiss();
		}
	}
}
