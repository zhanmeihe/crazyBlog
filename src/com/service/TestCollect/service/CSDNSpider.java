package com.service.TestCollect.service;

import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.zhan.utils.Tools;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 抓取CSDN文章数据{目前只抓取文章内容和标题，其余也可以进行抓取}
 * 100000(六位，多少位就几位) (int)((Math.random()*9+1)*100000)
 * @author zhanmeihe
 *
 */
public class CSDNSpider {

	private static List<String> getlist() {
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
		CSDNSpider.SpiderC();
	}

	public static void SpiderC() throws InterruptedException {
		
		while (true) {
			
			for (String url : getlist()) {
				
				String data = Tools.getGzipSource(url, "utf-8");
				JSONObject json = JSONObject.fromObject(data);
				JSONArray list = JSONArray.fromObject(json.get("articles"));
				for (int i = 0; i < list.size(); i++) {
					JSONObject ob = JSONObject.fromObject(list.get(i));
					// content_views
					// htmledit_views
					System.out.println("CSDN博客标题：" + ob.getString("title"));
					System.out.println("CSDN博客链接：" + ob.getString("url"));
					String html = Tools.source(ob.getString("url"), "utf-8");
					System.out.println("页面信息："+html);
					Document doc = Jsoup.parse(html);
					Elements rows = doc.select("div[class=htmledit_views]");
					if (rows.size() >= 1) {
						Element rowss = rows.get(0);
						System.out.println("htmledit_views：" + rowss.html());
					} else {
						// error_text{404页面不处理}
						Elements el = doc.select("div[class=error_text]");
						if (el.size() >= 1) {
							System.err.println("抱歉404！找不到页面了");
						} else {
							Elements row = doc.select("div[id=content_views]");
							if (row.size()>=1) {
								Element rowss = row.get(0);
								System.err.println("content_views：" + rowss.html());	
							}
							
						}
					}

				}
			}
			System.err.println("CSDN博客网站数据一轮抓取完成，等待五分钟进行新一轮抓取");
			Thread.sleep(300000);
		}
	}

}
