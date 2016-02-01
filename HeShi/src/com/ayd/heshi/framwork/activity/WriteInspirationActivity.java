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
 * д��еĽ���
 * 
 * @author Administrator
 * 
 */
public class WriteInspirationActivity extends BaseActivity {
	// ϵͳ���շ��صĳ���
	private static int REQUEST_CAPTURE_IMAGE = 1;
	// ����ϵͳ��᷵�صĳ���
	private static int RESULT_LOAD_IMAGE = 2;
	private String imageName;// ������ͼƬ����
	private String imageUrl;// ͼƬ·��

	// ����
	private LinearLayout actionBarBack;
	private EditText writeInspirationEt;
	private boolean isPush = true;// �Ƿ���

	// �ؼ���ť
	private RelativeLayout writeInspirationLayout;
	private TextView writeUnder, writeCamera, writePicture, writeCancel,
			writeCheck;

	@Override
	public void setContentLayout() {
		setContentView(R.layout.activity_write_inspiration);
	}

	@Override
	public void dealLogicBeforeInitView() {
		// ÿ�δ򿪽���ʱ��edittext�����Զ���ȡ���㣬��������̣����������������
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
			// ������ǰҳ��
			finish();
			break;
		case R.id.write_inspiration_et:
			// ���£���������̣�����ʾ��ť -- ��ť����ʹ�ã�������ʹ��
			if (isPush) {
				// ��һ�ΰ��£���ʾ���Ͱ�ť�������������
				isPush = false;
				writeInspirationEt.setCursorVisible(true);// ��ʾ���
				writeInspirationLayout.setVisibility(View.VISIBLE);// ��ʾ��ť
				writeUnder.setClickable(true);
				writeCamera.setClickable(true);
				writePicture.setClickable(true);
				writeCancel.setClickable(true);
				writeCheck.setClickable(true);
			}
			break;
		case R.id.write_under:
			// ����,���ع�꣬��������̣������ذ�ť�����ð�ť������
			isPush = true;
			writeInspirationEt.setCursorVisible(false);// ���ع��
			writeInspirationLayout.setVisibility(View.INVISIBLE);// ���ذ�ť
			writeUnder.setClickable(false);
			writeCamera.setClickable(false);
			writePicture.setClickable(false);
			writeCancel.setClickable(false);
			writeCheck.setClickable(false);
			hideSoftInput(writeInspirationEt);
			break;
		case R.id.write_camera:
			// �����
			tokenCamera();
			break;
		case R.id.write_picture:
			// �����
			tokenPick();
			break;
		case R.id.write_cancel:
			// ȡ��

			break;
		case R.id.write_check:
			// ȷ��

			break;
		}
	}

	/**
	 * ���������
	 */
	private void hideSoftInput(EditText mEditText) {
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(mEditText.getWindowToken(), 0);
	}

	/**
	 * �����
	 */
	private void tokenPick() {
		Intent intent = new Intent(Intent.ACTION_PICK,
				android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
		startActivityForResult(intent, RESULT_LOAD_IMAGE);
	}

	/**
	 * ����� -- ���ɵ�filename �Ե�ǰ��ʱ��Ϊ����
	 */
	private void tokenCamera() {
		Intent it = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		if (it.resolveActivity(getPackageManager()) != null) {
			startActivityForResult(it, REQUEST_CAPTURE_IMAGE);
		}
	}

	/**
	 * ������Ƭ
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == REQUEST_CAPTURE_IMAGE && resultCode == RESULT_OK) {
			// ���յķ���
			Bundle extras = data.getExtras();
			Bitmap photoBitmap = (Bitmap) extras.get("data");
			imageName = System.currentTimeMillis() + ".png";
			imageUrl = ConstantUtil.photoPath + imageName;
			// ���� -- ��ͼƬ���뵽edittext��
			EditTextUtil.insertPicture(writeInspirationEt, imageUrl,
					photoBitmap);

			PhotoToBitmapUtil.rorate(imageUrl);// ��תͼƬ
			savePhotoToPick(photoBitmap, imageUrl);// ������֮�����Ƭ�洢�������

		} else if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK
				&& null != data) {
			// ���ķ���
			Uri selectdeImage = data.getData();
			String[] filePathColumn = { MediaStore.Images.Media.DATA };

			Cursor cursor = getContentResolver().query(selectdeImage,
					filePathColumn, null, null, null);
			cursor.moveToFirst();

			int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
			imageUrl = cursor.getString(columnIndex);
			int index = imageUrl.lastIndexOf("/");
			imageName = imageUrl.substring(index + 1);
			System.out.println("==ϵͳ����ͼƬ��ַ��" + imageUrl + "==ͼƬ���ƣ�"
					+ imageName);
			Bitmap bitmap = BitmapFactory.decodeFile(imageUrl);
			// ���� -- ��ͼƬ���뵽edittext��
			EditTextUtil.insertPicture(writeInspirationEt, imageUrl, bitmap);
		}
	}

	/**
	 * ������֮���ͼƬ�洢�������
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
