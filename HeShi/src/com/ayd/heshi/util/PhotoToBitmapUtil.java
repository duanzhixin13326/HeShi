package com.ayd.heshi.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;

/**
 * �����պ��ͼƬ��ת����bitmap����ü��Ĺ�����
 * 
 * @author Administrator
 * 
 */
public class PhotoToBitmapUtil {
	/**
	 * ����ʱ����ͼƬ������bitmap������ü�����ת��
	 * 
	 * @param ����ͼƬ��·��
	 */
	public static void rorate(String path) {
		BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
		bitmapOptions.inSampleSize = 8;
		File file = new File(path);

		// ��ȡͼƬ����ת�Ƕȣ���Щϵͳ�����յ�ͼƬ��ת��
		int degree = readPictureDegree(file.getAbsolutePath());
		if (degree != 0) {
			Bitmap cameraBitmap = BitmapFactory.decodeFile(path, bitmapOptions);
			// ��ͼƬ��תΪ���ķ���
			Bitmap bitmap = rotaingImageView(degree, cameraBitmap);
			FileOutputStream fileOutputStream = null;
			try {
				fileOutputStream = new FileOutputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
			try {
				fileOutputStream.flush();
				fileOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (cameraBitmap.isRecycled()) {
				cameraBitmap.recycle();// �ͷ���Դ
			}
		}
	}

	/**
	 * ��תͼƬ
	 * 
	 * @param angle
	 *            -- �Ƕ�
	 * @param bitmap
	 *            -- ͼƬ
	 * @return
	 */
	public static Bitmap rotaingImageView(int angle, Bitmap bitmap) {
		// ��תͼƬ�Ķ���
		Matrix matrix = new Matrix();
		matrix.postRotate(angle);
		// �����µ�ͼƬ
		Bitmap resizeBitmap = Bitmap.createBitmap(bitmap, 0, 0,
				bitmap.getWidth(), bitmap.getHeight(), matrix, true);
		return resizeBitmap;
	}

	/**
	 * ��ȡͼƬ���� - ͼƬ��ת�ĽǶ�
	 * 
	 * @param path
	 * @return
	 */
	public static int readPictureDegree(String path) {
		int degree = 0;
		ExifInterface exifInterface;
		try {
			exifInterface = new ExifInterface(path);
			int orientation = exifInterface.getAttributeInt(
					ExifInterface.TAG_ORIENTATION,
					ExifInterface.ORIENTATION_NORMAL);
			switch (orientation) {
			case ExifInterface.ORIENTATION_ROTATE_90:
				degree = 90;
				break;
			case ExifInterface.ORIENTATION_ROTATE_180:
				degree = 180;
				break;
			case ExifInterface.ORIENTATION_ROTATE_270:
				degree = 270;
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return degree;
	}
}
