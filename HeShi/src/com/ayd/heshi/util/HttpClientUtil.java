package com.ayd.heshi.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

/**
 * 网络连接类 - 数据请求和上传
 * 
 * @author Administrator
 * 
 */
public class HttpClientUtil {
	/**
	 * get 请求
	 * 
	 * @param url
	 * @return
	 */
	public static String getString(String url) {
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		HttpResponse httpResponse = null;
		try {
			httpResponse = httpClient.execute(httpGet);
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				String string = EntityUtils.toString(httpResponse.getEntity(),
						"UTF-8");
				return string;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * get 请求
	 * 
	 * @param url
	 * @return
	 */
	public static String get(String url) {
		URL u;
		try {
			u = new URL(url);
			HttpsURLConnection conn = (HttpsURLConnection) u.openConnection();
			conn.setReadTimeout(2000);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			int code = conn.getResponseCode();
			if (code == 200) {
				InputStream is = conn.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(
						is, "utf-8"));
				StringBuffer buffer = new StringBuffer();
				String cahe = "";
				if ((cahe = br.readLine()) != null) {
					buffer.append(cahe);
				}
				return buffer.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 上传文件(单个文件) -- 如图片
	 * 
	 * @return
	 */
	public static void sendPost(String url, RequestParams params) {
		HttpUtils http = new HttpUtils();
		http.send(HttpRequest.HttpMethod.POST, url,
				new RequestCallBack<String>() {

					@Override
					public void onFailure(HttpException arg0, String arg1) {

					}

					@Override
					public void onSuccess(ResponseInfo<String> arg0) {
						String result = arg0.result;
						System.out.println("上传成功之后，获取的数据：" + result);

					}
				});
	}
}
