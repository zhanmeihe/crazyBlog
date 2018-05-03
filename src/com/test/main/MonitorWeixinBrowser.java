package com.test.main;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * 模拟微信浏览器请求
 */
public class MonitorWeixinBrowser {

	
	public static void main(String[] args) {
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx58c3690739e2df3d&redirect_uri=http%3A%2F%2Fwww.antarchi.com%2FUserinfo%2FIndexRe.shtml&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
		String html =  getHttpClientHtml(url, "UTF-8");
		System.err.println(html);
	}
	/**
	 * 根据URL获得所有的html信息
	 */
	public static String getHttpClientHtml(String url,String code) {
		String html = null;
		HttpClient httpClient = new DefaultHttpClient();// 创建httpClient对象
		HttpGet httpget = new HttpGet(url);// 以get方式请求该URL
		httpget.setHeader("User-Agent", "Mozilla/5.0 (Linux; U; Android 2.3.6; zh-cn; GT-S5660 Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1 MicroMessenger/4.5.255");
		//httpget.setHeader("User-Agent","mozilla/5.0 (iphone; cpu iphone) applewebkit/534.46 (khtml, like gecko) mobile/9b206 micromessenger/5.0");
		//httpget.setHeader("Referer", "https://mp.weixin.qq.com");
		try {
			HttpResponse responce = httpClient.execute(httpget);// 得到responce对象
			int resStatu = responce.getStatusLine().getStatusCode();// 返回码
			if (resStatu == HttpStatus.SC_OK) {// 200正常 其他就不对
				// 获得相应实体
				HttpEntity entity = responce.getEntity();
				if (entity != null) {
					html = new String(EntityUtils.toString(entity));// 获得html源代码
				}
			}
		} catch (Exception e) {
			System.out.println("访问【" + url + "】出现异常!");
			e.printStackTrace();
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
		return html;
	}
	
	
	
	
}
