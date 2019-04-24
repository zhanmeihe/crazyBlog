package com.zhan.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SizeVideoUtils {

	/**
	 * ��ȡ����URL��Դ�ļ���С
	 */
	public SizeVideoUtils() {

	}

	public int getFileLength(String url1) throws IOException {
		int length = 0;
		URL url;
		try {
			url = new URL(url1);
			HttpURLConnection urlcon = (HttpURLConnection) url.openConnection();
			length = urlcon.getContentLength();
			urlcon.disconnect();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return length;
	}
  public static void main(String[] args) {
	SizeVideoUtils s = new SizeVideoUtils();
	try {
		System.out.println(s.getFileLength("http://vod.gslb.cmvideo.cn/600084/20160105/16/3010866773/3010870575/3010866775_63.mp4.m3u8?msisdn=0496650545249&mdspid=&spid=699013&netType=1&sid=3010866776&pid=2028597139&timestamp=20170619173250&SecurityKey=20170619173250&resourceId=&resourceType=&Channel_ID=1004_10010001005&ProgramID=614014971&ParentNodeID=-99&cc=614014637&assertID=3010866776&encrypt=7d2eadd58c8d36d16bb60577fe1f3510"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
