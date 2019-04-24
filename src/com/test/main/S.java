package com.test.main;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import ch.qos.logback.classic.Logger;

public class S {
	private static Logger LOGGER ;
	public static void main(String[] args) throws ClientProtocolException, IOException {
		S s = new S();
		LOGGER.info("11");
		s.getReponse("http://365jia.cn/news/api3/365jia/news/categories/hefei?page=1");
	}

	public String getReponse(String url) throws ClientProtocolException, IOException {
		String readContent = null;
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(url);
		System.out.println("0.Send the URL to Sina Sever....");
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();

		System.out.println("1.Get Response Status: " + response.getStatusLine());
		if (entity != null) {
			System.out.println("  Get ResponseContentEncoding():" + entity.getContentEncoding());
			System.out.println("  Content Length():" + entity.getContentLength());
			// getResponse
			InputStream in = entity.getContent();
			int count = 0;
			while (count == 0) {
				count = Integer.parseInt("" + entity.getContentLength());// in.available();
			}
			byte[] bytes = new byte[count];
			int readCount = 0; // 已经成功读取的字节的个数
			while (readCount <= count) {
				if (readCount == count)
					break;
				readCount += in.read(bytes, readCount, count - readCount);
			}

			// 转换成字符串
			readContent = new String(bytes, 0, readCount, "gzip"); // convert to string using bytes

			System.out.println("2.Get Response Content():\n" + readContent);
		}
		return readContent;
	}

}
