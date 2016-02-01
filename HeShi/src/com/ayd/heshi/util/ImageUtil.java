package com.ayd.heshi.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;

/**
 * ͼƬ������ - ��ͼƬ����һЩ����
 * 
 * @author Administrator
 * 
 */
public class ImageUtil {
	/**
	 * ͼƬ�Ŵ���С
	 */
	public static Bitmap postScaleBitmap(Bitmap bmp, float sx, float sy) {
		// ��ȡBitmap�ĸߺͿ�
		int bmpWidth = bmp.getWidth();
		int bmpHeight = bmp.getHeight();
		// ����resize���bitmap����
		Matrix matrix = new Matrix();
		matrix.setScale(sx, sy);
		Bitmap resizeBmp = Bitmap.createBitmap(bmp, 0, 0, bmpWidth, bmpHeight,
				matrix, true);
		return resizeBmp;
	}

	/**
	 * ��ͼƬ���д��� 1�������ж� ͼƬ�Ŀ�͸� 2�������͸߶�С��700���ͷŴ��ֻ��Ŀ�ߣ�Ҫ�ж��Ƿ����700��
	 * 3�������һ�����700���ͽ������ţ���С��700Ϊֹ
	 * 
	 * @param bmp
	 * @param path
	 * @return
	 */
	public static Bitmap parseBitmap(Bitmap bmp, String path) {
		// ��һ��
		int imgWidth = bmp.getWidth();
		int imgHeight = bmp.getHeight();

		// �ڶ���
		if (imgWidth > 700 || imgHeight > 700) {
			float sx = imgWidth > imgHeight ? ((float) 700) / (float) imgWidth
					: ((float) 700) / (float) imgHeight;
			bmp = postScaleBitmap(bmp, sx, sx);
		} else {
			int value = imgWidth > imgHeight ? imgWidth : imgHeight;
			if (value < 100) {
				bmp = getBitmapByPath(path);
			} else {
				return bmp;
			}
		}
		return bmp;
	}

	public static Bitmap getBitmapByPath(String filePath) {
		return getBitmapByPath(filePath, null);
	}

	public static Bitmap getBitmapByPath(String filePath,
			BitmapFactory.Options options) {
		FileInputStream fis = null;
		Bitmap bitmap = null;
		try {
			File file = new File(filePath);
			fis = new FileInputStream(file);
			bitmap = BitmapFactory.decodeStream(fis, null, options);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return bitmap;
	}

	/**
	 * ����Ҫ�󣬰�ͼƬת����Բ��ͼƬ
	 * 
	 * @param bitmap
	 * @param min
	 * @return
	 */
	public static Bitmap toOvalBitmap(Bitmap bitmap, int min) {
		Paint paint = new Paint();
		paint.setAntiAlias(true);

		Bitmap bmp = Bitmap.createBitmap(min, min, Config.ARGB_8888);
		// ����һ��ͬ����С�Ļ���
		Canvas canvas = new Canvas(bmp);
		// ����Բ��
		canvas.drawCircle(min / 2, min / 2, 0, paint);
		// ʹ��SRC_IN
		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
		canvas.drawBitmap(bitmap, 0, 0, paint);
		return bmp;
	}
}
