package com.ayd.heshi.framwork.activity;

import java.io.FileOutputStream;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ayd.heshi.R;
import com.ayd.heshi.base.BaseActivity;
import com.ayd.heshi.util.ConstantUtil;
import com.ayd.heshi.util.EditTextUtil;
import com.ayd.heshi.util.PhotoToBitmapUtil;

/**
 * 写灵感的界面
 * 
 * @author Administrator
 * 
 */
public class WriteInspirationActivity extends BaseActivity {
	// 系统拍照返回的常量
	private static int REQUEST_CAPTURE_IMAGE = 1;
	// 调用系统相册返回的常量
	private static int RESULT_LOAD_IMAGE = 2;
	private String imageName;// 调出的图片名称
	private String imageUrl;// 图片路径

	// 布局
	private LinearLayout actionBarBack;
	private EditText writeInspirationEt;
	private boolean isPush = true;// 是否按下

	// 控件按钮
	private RelativeLayout writeInspirationLayout;
	private TextView writeUnder, writeCamera, writePicture, writeCancel,
			writeCheck;

	@Override
	public void setContentLayout() {
		setContentView(R.layout.activity_write_inspiration);
	}

	@Override
	public void dealLogicBeforeInitView() {
		// 每次打开界面时，edittext总是自动获取焦点，弹出软键盘，所以先隐藏软键盘
		// getWindow().setSoftInputMode(
		// WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
	}

	@Override
	public void initView() {
		actionBarBack = (LinearLayout) findViewById(R.id.action_bar_back);
		writeInspirationEt = (EditText) findViewById(R.id.write_inspiration_et);
		actionBarBack.setOnClickListener(this);
		writeInspirationEt.setOnClickListener(this);

		writeInspirationLayout = (RelativeLayout) findViewById(R.id.write_inspiration_layout);
		writeUnder = (TextView) findViewById(R.id.write_under);
		writeCamera = (TextView) findViewById(R.id.write_camera);
		writePicture = (TextView) findViewById(R.id.write_picture);
		writeCancel = (TextView) findViewById(R.id.write_cancel);
		writeCheck = (TextView) findViewById(R.id.write_check);
		writeUnder.setOnClickListener(this);
		writeCamera.setOnClickListener(this);
		writePicture.setOnClickListener(this);
		writeCancel.setOnClickListener(this);
		writeCheck.setOnClickListener(this);
	}

	@Override
	public void dealLogicAfterInitView() {

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.action_bar_back:
			// 结束当前页面
			finish();
			break;
		case R.id.write_inspiration_et:
			// 按下，弹出软键盘，并显示按钮 -- 按钮可以使用，否则不能使用
			if (isPush) {
				// 第一次按下，显示光标和按钮，并弹出软键盘
				isPush = false;
				writeInspirationEt.setCursorVisible(true);// 显示光标
				writeInspirationLayout.setVisibility(View.VISIBLE);// 显示按钮
				writeUnder.setClickable(true);
				writeCamera.setClickable(true);
				writePicture.setClickable(true);
				writeCancel.setClickable(true);
				writeCheck.setClickable(true);
			}
			break;
		case R.id.write_under:
			// 按下,隐藏光标，隐藏软键盘，并隐藏按钮，设置按钮不可用
			isPush = true;
			writeInspirationEt.setCursorVisible(false);// 隐藏光标
			writeInspirationLayout.setVisibility(View.INVISIBLE);// 隐藏按钮
			writeUnder.setClickable(false);
			writeCamera.setClickable(false);
			writePicture.setClickable(false);
			writeCancel.setClickable(false);
			writeCheck.setClickable(false);
			hideSoftInput(writeInspirationEt);
			break;
		case R.id.write_camera:
			// 打开相机
			tokenCamera();
			break;
		case R.id.write_picture:
			// 打开相册
			tokenPick();
			break;
		case R.id.write_cancel:
			// 取消

			break;
		case R.id.write_check:
			// 确认

			break;
		}
	}

	/**
	 * 隐藏软键盘
	 */
	private void hideSoftInput(EditText mEditText) {
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(mEditText.getWindowToken(), 0);
	}

	/**
	 * 打开相册
	 */
	private void tokenPick() {
		Intent intent = new Intent(Intent.ACTION_PICK,
				android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
		startActivityForResult(intent, RESULT_LOAD_IMAGE);
	}

	/**
	 * 打开相机 -- 生成的filename 以当前的时间为名字
	 */
	private void tokenCamera() {
		Intent it = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		if (it.resolveActivity(getPackageManager()) != null) {
			startActivityForResult(it, REQUEST_CAPTURE_IMAGE);
		}
	}

	/**
	 * 返回照片
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == REQUEST_CAPTURE_IMAGE && resultCode == RESULT_OK) {
			// 拍照的返回
			Bundle extras = data.getExtras();
			Bitmap photoBitmap = (Bitmap) extras.get("data");
			imageName = System.currentTimeMillis() + ".png";
			imageUrl = ConstantUtil.photoPath + imageName;
			// 操作 -- 把图片插入到edittext中
			EditTextUtil.insertPicture(writeInspirationEt, imageUrl,
					photoBitmap);

			PhotoToBitmapUtil.rorate(imageUrl);// 旋转图片
			savePhotoToPick(photoBitmap, imageUrl);// 把拍照之后的照片存储到相册中

		} else if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK
				&& null != data) {
			// 相册的返回
			Uri selectdeImage = data.getData();
			String[] filePathColumn = { MediaStore.Images.Media.DATA };

			Cursor cursor = getContentResolver().query(selectdeImage,
					filePathColumn, null, null, null);
			cursor.moveToFirst();

			int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
			imageUrl = cursor.getString(columnIndex);
			int index = imageUrl.lastIndexOf("/");
			imageName = imageUrl.substring(index + 1);
			System.out.println("==系统相册的图片地址：" + imageUrl + "==图片名称："
					+ imageName);
			Bitmap bitmap = BitmapFactory.decodeFile(imageUrl);
			// 操作 -- 把图片插入到edittext中
			EditTextUtil.insertPicture(writeInspirationEt, imageUrl, bitmap);
		}
	}

	/**
	 * 把拍照之后的图片存储到相册中
	 */
	private void savePhotoToPick(Bitmap bitmap, String imageUrl) {
		try {
			FileOutputStream out = new FileOutputStream(imageUrl);
			bitmap.compress(CompressFormat.PNG, 100, out);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
