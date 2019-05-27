package com.service.TestCollect.service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.service.TestCollect.dao.BlogInfoDao;
import com.service.TestCollect.pojo.BlogInfo;
import com.zhan.utils.CommonUtils;
import com.zhan.utils.Tools;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 抓取CSDN文章数据{目前只抓取文章内容和标题，其余也可以进行抓取} 100000(六位，多少位就几位)
 * (int)((Math.random()*9+1)*100000)
 * 
 * @author zhanmeihe
 *
 */

public class CSDNSpider {

	public List<String> getlist() {
		List<String> csdnurl = new ArrayList<>();
		csdnurl.add("https://www.csdn.net/api/articles?type=more&category=home");
		csdnurl.add("https://www.csdn.net/api/articles?type=more&category=newarticles");
		csdnurl.add("https://www.csdn.net/api/articles?type=more&category=news");
		csdnurl.add("https://www.csdn.net/api/articles?type=more&category=ai");
		csdnurl.add("https://www.csdn.net/api/articles?type=more&category=cloud");
		csdnurl.add("https://www.csdn.net/api/articles?type=more&category=db");
		csdnurl.add("https://www.csdn.net/api/articles?type=more&category=career");
		csdnurl.add("https://www.csdn.net/api/articles?type=more&category=game");
		csdnurl.add("https://www.csdn.net/api/articles?type=more&category=engineering");
		csdnurl.add("https://www.csdn.net/api/articles?type=more&category=web");
		csdnurl.add("https://www.csdn.net/api/articles?type=more&category=mobile");
		csdnurl.add("https://www.csdn.net/api/articles?type=more&category=iot");
		csdnurl.add("https://www.csdn.net/api/articles?type=more&category=ops");
		csdnurl.add("https://www.csdn.net/api/articles?type=more&category=fund");
		csdnurl.add("https://www.csdn.net/api/articles?type=more&category=lang");
		csdnurl.add("https://www.csdn.net/api/articles?type=more&category=avi");
		csdnurl.add("https://www.csdn.net/api/articles?type=more&category=sec");
		csdnurl.add("https://www.csdn.net/api/articles?type=more&category=other");
		csdnurl.add("https://www.csdn.net/api/articles?type=more&category=arch");
		csdnurl.add("https://www.csdn.net/api/articles?type=more&category=arch");
		csdnurl.add("https://www.csdn.net/api/articles?type=more&category=arch");
		csdnurl.add("https://www.csdn.net/api/articles?type=more&category=arch");
		csdnurl.add("https://www.csdn.net/api/articles?type=more&category=arch");
		csdnurl.add("https://www.csdn.net/api/articles?type=more&category=arch");

		return csdnurl;
	}

	public static void main(String[] args) throws InterruptedException {
		String url = "http://api.tv.cnrmobile.com/mobileapi/getlivelist";
		Map<String, String> map = new HashMap<>();
		map.put("startPage", "0");
		map.put("pageNumber", "17");
		// map.put("imsi", "460000980266678");
		// map.put("nodeType", "0");
		// map.put("version", "2.7.3");
		map.put("userId", "1629856");
		// map.put("platform", "0");
		// map.put("sid", "1");
		// map.put("token", "");
		// map.put("isCity", "0");
		// map.put("imei", "865422030943807");
		map.put("channelName", "卫视");
		map.put("sn", "9002945C13ECECAA7A97709B4038488C");
		// map.put("userType", "0");
		// map.put("netWork", "wifi网络");
		map.put("nodeId", "261");
		map.put("channelId", "CNRL010024");
		JSONObject jsonResult = JSONObject.fromObject(postMap(url, map));
		
		url = "http://api.tv.cnrmobile.com/program/playinfo";
		JSONArray lists = JSONArray.fromObject(jsonResult.getString("demandProgramList"));
		for (int i = 0; i < lists.size(); i++) {
			map.clear();
			jsonResult = JSONObject.fromObject(lists.get(i));
			System.out.println(jsonResult.getString("playId"));
			map.put("ht_type", "false");
			map.put("userId", "1629856");
			map.put("sn", "9002945C13ECECAA7A97709B4038488C");
			map.put("channelId", "CNRL010024");
			map.put("playId", jsonResult.getString("playId"));
			jsonResult  = JSONObject.fromObject(postMap(url, map));
			JSONArray list = JSONArray.fromObject(jsonResult.getString("playSources"));
			jsonResult = JSONObject.fromObject(list.get(0));
			System.out.println(jsonResult.getString("sourceUrl"));
		}
	}

	public void SpiderC() throws InterruptedException {

		List<String> title = new ArrayList<>();
		int u = 0;
		long starttime = System.currentTimeMillis();
		while (true) {

			for (String url : getlist()) {

				// String data = Tools.getGzipSource(url, "utf-8");
				JSONObject json = httpGet(url);
				// JSONObject.fromObject(data);
				JSONArray list = JSONArray.fromObject(json.get("articles"));
				for (int i = 0; i < list.size(); i++) {
					u++;
					JSONObject ob = JSONObject.fromObject(list.get(i));
					// content_views
					// htmledit_views

					// 临时排重
					if (title.contains(ob.getString("title"))) {
						System.out.println("已经存在");
						continue;
					}

//					BlogInfo blog = new BlogInfo();
//					blog.setAuthor("code神");
//					blog.setBlogId(ob.getString("url").substring(ob.getString("url").lastIndexOf("/")+1));
//					blog.setUserId("1");
//					blog.setComments("");
//					blog.setCommentsNum(0);
//					blog.setCreateblogDate(CommonUtils.getNowDate());
//					blog.setUpdateDate(CommonUtils.getNowDate());
//					blog.setImageUrl("");
//					blog.setPraiseCount(0);
					// title.add(ob.getString("title"));
					System.out.println("CSDN博客标题：" + ob.getString("title"));
					// blog.setTitle(ob.getString("title"));
					System.out.println("CSDN博客链接：" + ob.getString("url"));
					String html = Tools.source(ob.getString("url"), "utf-8");
					// System.out.println("页面信息："+html);
					Document doc = Jsoup.parse(html);
					Elements rows = doc.select("div[class=htmledit_views]");
					if (rows.size() >= 1) {
						Element rowss = rows.get(0);
						System.out.println("htmledit_views：" + rowss.html());
						// blog.setBlogContent(rowss.html());
					} else {
						// error_text{404页面不处理}
						Elements el = doc.select("div[class=error_text]");
						if (el.size() >= 1) {
							System.err.println("抱歉404！找不到页面了");
						} else {
							Elements row = doc.select("div[id=content_views]");
							if (row.size() >= 1) {
								Element rowss = row.get(0);
								System.err.println("content_views：" + rowss.html());
								// blog.setBlogContent(rowss.html());
							}

						}
					}
					// blogInfoDao.create(blog);
				}
			}
			long endtime = System.currentTimeMillis();
			long resulttime = (endtime - starttime) / 1000;
			System.err.println("CSDN博客网站数据一轮抓取完成，等待20秒进行新一轮抓取,爬去数量：" + u + "耗时为：" + resulttime + "秒");
			Thread.sleep(20000);
		}
	}

	/**
	 * httppost
	 * 
	 * @param url
	 * @param jsonParam
	 * @param noNeedResponse
	 * @return
	 */
	public static JSONObject httpPost(String url, JSONObject jsonParam, boolean noNeedResponse) {
		// post请求返回结果
		DefaultHttpClient httpClient = new DefaultHttpClient();
		JSONObject jsonResult = null;
		HttpPost method = new HttpPost(url);
		try {
			if (null != jsonParam) {
				// 解决中文乱码问题
				StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
				entity.setContentEncoding("UTF-8");
				entity.setContentType("application/json");
				method.setEntity(entity);
			}
			HttpResponse result = httpClient.execute(method);
			url = URLDecoder.decode(url, "UTF-8");
			/** 请求发送成功，并得到响应 **/
			if (result.getStatusLine().getStatusCode() == 200) {
				String str = "";
				try {
					/** 读取服务器返回过来的json字符串数据 **/
					str = EntityUtils.toString(result.getEntity());
					if (!noNeedResponse) {
						return null;
					}
					/** 把json字符串转换成json对象 **/
					jsonResult = JSONObject.fromObject(str);
				} catch (Exception e) {
					System.out.println("\"post请求提交失败:\"" + url + e);

				}
			}
		} catch (IOException e) {
			System.err.println("post请求提交失败:" + url + e);
		}
		return jsonResult;
	}

	/**
	 * httppost请求
	 */
	public static String postMap(String url, Map<String, String> map) {
		String result = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		List<NameValuePair> pairs = new ArrayList<NameValuePair>();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			pairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}
		CloseableHttpResponse response = null;
		try {
			post.setEntity(new UrlEncodedFormEntity(pairs, "UTF-8"));
			response = httpClient.execute(post);
			if (response != null && response.getStatusLine().getStatusCode() == 200) {
				HttpEntity entity = response.getEntity();
				result = entityToString(entity);
			}
			return result;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpClient.close();
				if (response != null) {
					response.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return null;
	}

	private static String entityToString(HttpEntity entity) throws IOException {
		String result = null;
		if (entity != null) {
			long lenth = entity.getContentLength();
			if (lenth != -1 && lenth < 2048) {
				result = EntityUtils.toString(entity, "UTF-8");
			} else {
				InputStreamReader reader1 = new InputStreamReader(entity.getContent(), "UTF-8");
				CharArrayBuffer buffer = new CharArrayBuffer(2048);
				char[] tmp = new char[1024];
				int l;
				while ((l = reader1.read(tmp)) != -1) {
					buffer.append(tmp, 0, l);
				}
				result = buffer.toString();
			}
		}
		return result;
	}

	public static JSONObject httpGet(String url) {
		// get请求返回结果
		JSONObject jsonResult = null;
		try {
			DefaultHttpClient client = new DefaultHttpClient();
			// 发送get请求
			HttpGet request = new HttpGet(url);
			request.setHeader("Accept",
					"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
			request.setHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,nb;q=0.6,ja;q=0.5");
			request.setHeader("Connection", "keep-alive");
			request.setHeader("Cookie",
					"uuid_tt_dd=10_37208317730-1541092207669-552428; smidV2=20181102151327fb690d1eb224b217736392fd6a11d3cb004c9ca6c73732f20; _ga=GA1.2.1657390146.1541412400; Hm_ct_6bcd52f51e9b3dce32bec4a3997715ac=1788*1*PC_VC; ADHOC_MEMBERSHIP_CLIENT_ID1.0=be435443-d132-2020-164e-28b8f0c8107b; UM_distinctid=1670cd84e1290f-0d99c193f740b5-35677407-13c680-1670cd84e132dc; dc_session_id=10_1542530679470.716368; ARK_ID=JS4ddfef9dede576587c5f69d9ab5521164ddf; UserName=qq_28567955; UserInfo=RAKcvTaZbT0Hgexz82jgVudy52Tynz9vFj3FxDQqegLqWerGVqG%2Fdcz1AWP6sX5c2Vg4JkzEaA358vRk0VONWw1njQNu%2B1lxXA1rI4qq%2B6H1gi%2Fpp8gBrwPPCY7CJG21oS8PpEwdc3zE9hlq%2FsFQhA%3D%3D; UserToken=48c6f9e696c04581ac9fe8cfdf5d0024; UserNick=qq_28567955; AU=915; UN=qq_28567955; BT=1543392050654; TY_SESSION_ID=ff2cb899-5e17-48fc-82ac-78b8c89156be; tipShow=true; __yadk_uid=UDlVaK2OHFfhTaqBXWQUjFl64X0ySt7d; dc_tos=piytiq; Hm_lvt_6bcd52f51e9b3dce32bec4a3997715ac=1543509967,1543510216,1543512044,1543512051; Hm_lpvt_6bcd52f51e9b3dce32bec4a3997715ac=1543512051");
			request.setHeader("Host", "www.csdn.net");

			request.setHeader("User-Agent",
					"Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Mobile Safari/537.36");

			HttpResponse response = client.execute(request);

			/** 请求发送成功，并得到响应 **/
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				/** 读取服务器返回过来的json字符串数据 **/
				String strResult = EntityUtils.toString(response.getEntity());
				/** 把json字符串转换成json对象 **/
				jsonResult = JSONObject.fromObject(strResult);
				url = URLDecoder.decode(url, "UTF-8");
			} else {
				System.err.println("get请求提交失败:" + url);
			}
		} catch (IOException e) {
			System.err.println("get请求提交失败:" + url + e);
		}
		return jsonResult;
	}
}
