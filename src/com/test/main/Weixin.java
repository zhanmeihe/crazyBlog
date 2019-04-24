package com.test.main;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Weixin {

	
	public static void main(String[] args) throws IOException {
		 
		 
		  
		 // 请求客户端及参数
	    CloseableHttpClient client = HttpClients.createDefault();
	    // Post请求
	    HttpGet httpget = new HttpGet("https://mp.weixin.qq.com/mp/profile_ext?action=home&__biz=MzIyNzgzNTE3OQ==&scene=124&uin=MjE4NDUyNTgwMw%3D%3D&key=e241e26d5d8d4a51bc1ae055bba12e6d6e0bbdc76ea62a5362eef093edbe3c91caac015610a0585b15cfd75b9ef433692de584da8a19ea6b86c50ab97c43d52121e5ce359f5a6c9296498c9234219573&devicetype=iMac+MacBookPro11%2C4+OSX+OSX+10.13.6+build(17G65)&version=12031210&lang=zh_CN&nettype=WIFI&a8scene=0&fontScale=100&pass_ticket=J%2BDC9aLZtyjkAL6Zo%2FdtgePGPD9uRYko4xPl%2F9HgWJtdq3oaNln1T64EDl1%2FyzVl");
	    //在这里我们给Post请求的头部加上User-Agent来伪装成微信内置浏览器
	    httpget.setHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/605.1.15 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36 MicroMessenger/6.5.2.501 NetType/WIFI WindowsWechat Chrome/39.0.2171.95 Safari/537.36 MicroMessenger/6.5.2.501 NetType/WIFI WindowsWechat");
	    //这个是在网上看到的，要加上这个，避免其他错误
	    httpget.setHeader("Cookie", "devicetype=iMacMacBookPro114OSXOSX10.13.6build(17G65); lang=zh_CN; pass_ticket=J+DC9aLZtyjkAL6Zo/dtgePGPD9uRYko4xPl/9HgWJtdq3oaNln1T64EDl1/yzVl; version=12031210; wap_sid2=COvv1JEIElw4ZFVSYk1EQURFbk5hY3hXVmJBM29YTUQyRWI2SHA4YnJDSDdwTlVSblRldzExYzYzVjRXRmpfbzEwR25DN2JKZEdiVFF3VmE3aHFpLXBlZ25XUld3ZEFEQUFBfjC05q7dBTgNQJVO; wxuin=2184525803; pgv_pvid=9706790050; pgv_pvi=3663827968; eas_sid=R1G583v6y0n7p6O5k4J2Z259j0; tvfe_boss_uuid=4c3b5452c6419311; pac_uid=0_5b72a4b863cd0; sd_cookie_crttime=1533566125834; sd_userid=58141533566125834");
	    httpget.setHeader("Host", "mp.weixin.qq.com");
	    //发送Post请求
	    CloseableHttpResponse response = client.execute(httpget);
	    HttpEntity entity = response.getEntity();
System.err.println("***"+EntityUtils.toString(entity));
	 	 
			 
		}
}
