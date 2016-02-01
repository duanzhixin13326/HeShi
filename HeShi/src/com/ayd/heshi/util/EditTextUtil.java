package com.ayd.heshi.util;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.widget.EditText;

/**
 * ����򹤾���
 * 
 * @author Administrator
 * 
 */
public class EditTextUtil {
	/**
	 * ��������в����ı�
	 * 
	 * @param editText
	 */
	public static void insertTextView(EditText editText, String str) {
		Editable eb = editText.getEditableText();
		// ��ù������λ��
		int startPosition = editText.getSelectionStart();
		// �����ı�
		eb.insert(startPosition, str);
	}

	/**
	 * ��������в���ͼƬ imagePath:ͼƬ�ľ���·��
	 */
	public static void insertPicture(EditText editText, String imagePath,
			Bitmap image) {
		SpannableString ss = new SpannableString(imagePath);

		// �������ͼƬ
		Drawable drawable = new BitmapDrawable(image);
		ss.setSpan(new ImageSpan(drawable, ImageSpan.ALIGN_BASELINE), 0,
				ss.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		drawable.setBounds(2, 0, drawable.getIntrinsicWidth() + 20,
				drawable.getIntrinsicHeight() + 20);

		Editable eb = editText.getEditableText();
		// ��ù������λ��
		int qqPosition = editText.getSelectionStart();
		// ����ͼƬ
		eb.insert(qqPosition, ss);
		editText.setText(eb);// ��eb��ӵ�edittext��
		editText.setSelection(qqPosition + ss.length());// ����edittext�й�����������ʾ
	}
}
