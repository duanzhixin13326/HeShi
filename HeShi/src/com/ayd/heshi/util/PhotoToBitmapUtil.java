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
 * 把拍照后的图片，转化成bitmap方便裁剪的工具类
 * 
 * @author Administrator
 * 
 */
public class PhotoToBitmapUtil {
	/**
	 * 拍照时，把图片解析成bitmap，方便裁剪，旋转等
	 * 
	 * @param 输入图片的路径
	 */
	public static void rorate(String path) {
		BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
		bitmapOptions.inSampleSize = 8;
		File file = new File(path);

		// 获取图片的旋转角度，有些系统把拍照的图片旋转了
		int degree = readPictureDegree(file.getAbsolutePath());
		if (degree != 0) {
			Bitmap cameraBitmap = BitmapFactory.decodeFile(path, bitmapOptions);
			// 把图片旋转为正的方向
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
				cameraBitmap.recycle();// 释放资源
			}
		}
	}

	/**
	 * 旋转图片
	 * 
	 * @param angle
	 *            -- 角度
	 * @param bitmap
	 *            -- 图片
	 * @return
	 */
	public static Bitmap rotaingImageView(int angle, Bitmap bitmap) {
		// 旋转图片的动作
		Matrix matrix = new Matrix();
		matrix.postRotate(angle);
		// 创建新的图片
		Bitmap resizeBitmap = Bitmap.createBitmap(bitmap, 0, 0,
				bitmap.getWidth(), bitmap.getHeight(), matrix, true);
		return resizeBitmap;
	}

	/**
	 * 读取图片属性 - 图片旋转的角度
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
