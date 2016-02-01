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
 * 图片工具类 - 对图片进行一些处理
 * 
 * @author Administrator
 * 
 */
public class ImageUtil {
	/**
	 * 图片放大缩小
	 */
	public static Bitmap postScaleBitmap(Bitmap bmp, float sx, float sy) {
		// 获取Bitmap的高和宽
		int bmpWidth = bmp.getWidth();
		int bmpHeight = bmp.getHeight();
		// 产生resize后的bitmap对象
		Matrix matrix = new Matrix();
		matrix.setScale(sx, sy);
		Bitmap resizeBmp = Bitmap.createBitmap(bmp, 0, 0, bmpWidth, bmpHeight,
				matrix, true);
		return resizeBmp;
	}

	/**
	 * 对图片进行处理 1，首先判断 图片的宽和高 2，如果宽和高都小于700，就放大到手机的宽高（要判断是否大于700）
	 * 3，如果有一项大于700，就进行缩放，都小于700为止
	 * 
	 * @param bmp
	 * @param path
	 * @return
	 */
	public static Bitmap parseBitmap(Bitmap bmp, String path) {
		// 第一步
		int imgWidth = bmp.getWidth();
		int imgHeight = bmp.getHeight();

		// 第二步
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
	 * 根据要求，把图片转换成圆形图片
	 * 
	 * @param bitmap
	 * @param min
	 * @return
	 */
	public static Bitmap toOvalBitmap(Bitmap bitmap, int min) {
		Paint paint = new Paint();
		paint.setAntiAlias(true);

		Bitmap bmp = Bitmap.createBitmap(min, min, Config.ARGB_8888);
		// 产生一个同样大小的画布
		Canvas canvas = new Canvas(bmp);
		// 绘制圆形
		canvas.drawCircle(min / 2, min / 2, 0, paint);
		// 使用SRC_IN
		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
		canvas.drawBitmap(bitmap, 0, 0, paint);
		return bmp;
	}
}
