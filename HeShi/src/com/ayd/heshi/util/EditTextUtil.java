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
 * 输入框工具类
 * 
 * @author Administrator
 * 
 */
public class EditTextUtil {
	/**
	 * 向输入框中插入文本
	 * 
	 * @param editText
	 */
	public static void insertTextView(EditText editText, String str) {
		Editable eb = editText.getEditableText();
		// 获得光标所在位置
		int startPosition = editText.getSelectionStart();
		// 插入文本
		eb.insert(startPosition, str);
	}

	/**
	 * 向输入框中插入图片 imagePath:图片的绝对路径
	 */
	public static void insertPicture(EditText editText, String imagePath,
			Bitmap image) {
		SpannableString ss = new SpannableString(imagePath);

		// 定义插入图片
		Drawable drawable = new BitmapDrawable(image);
		ss.setSpan(new ImageSpan(drawable, ImageSpan.ALIGN_BASELINE), 0,
				ss.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		drawable.setBounds(2, 0, drawable.getIntrinsicWidth() + 20,
				drawable.getIntrinsicHeight() + 20);

		Editable eb = editText.getEditableText();
		// 获得光标所在位置
		int qqPosition = editText.getSelectionStart();
		// 插入图片
		eb.insert(qqPosition, ss);
		editText.setText(eb);// 把eb添加到edittext中
		editText.setSelection(qqPosition + ss.length());// 设置edittext中光标在最后面显示
	}
}
