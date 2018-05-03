package com.test.main;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.xml.sax.SAXException;

import com.service.TestCollect.pojo.Video;
import com.zhan.utils.PropertiesFactory;
import com.zhan.utils.Tools;

public class TestReax {

	
	public static String ProgType = "";
	public TestReax() {

	}

	public static void main(String[] args) throws DocumentException, SAXException, IOException {
		
		//getneteaseWebData("https://c.m.163.com/news/t/T1348654085632/0.html 房产");
		
		String url = "http://c.m.163.com/news/a/CMVK2R86000380F1.html";
		
		String id = url.substring(url.lastIndexOf("/"),
				url.lastIndexOf(".")).replace("/", "");
		System.err.println(id);

//		String sos = Tools.getSource(
//				"http://c.m.163.com/news/a/CMSS4J470001899N.html", "utf-8");
//
//		List<String> list = new ArrayList<String>();
//		String title = PropertiesFactory.getProperties("NeteaseVideo").getProperty("title");
//		list.add(title);
//		String description = PropertiesFactory.getProperties("NeteaseVideo").getProperty("content");
//		list.add(description);
//		String text = PropertiesFactory.getProperties("NeteaseVideo").getProperty("main");
//		list.add(text);
//		String dir = PropertiesFactory.getProperties("NeteaseVideo").getProperty("dir");
//		list.add(dir);
//		String likenum = PropertiesFactory.getProperties("NeteaseVideo").getProperty("like");
//		list.add(likenum);
//		String date = PropertiesFactory.getProperties("NeteaseVideo").getProperty("date");
//		list.add(date);
//		String jsonbody = PropertiesFactory.getProperties("NeteaseVideo").getProperty("script");
//		list.add(jsonbody);
//		 Matcher m = Pattern.compile(title).matcher(sos);
//		 Matcher m1 = Pattern.compile(description).matcher(sos);
//		 Matcher m2 = Pattern.compile(text).matcher(sos);
//		 Matcher m3 = Pattern.compile(dir).matcher(sos);
//		 Matcher m4 = Pattern.compile(likenum).matcher(sos);
//		 Matcher m5 = Pattern.compile(date).matcher(sos);
//		 Matcher m6 = Pattern.compile(jsonbody).matcher(sos);
//			if (m.find()) {
//
//				System.out.println(m.group(1).replace("<b>", "")
//						.replace("</p>", "").replace("<p>", "").replace("<b>", "")
//						.replace("</b>", ""));
//				 
//			}
//			if (m1.find()) {
//
//				System.out.println(m1.group(1).replace("<b>", "")
//						.replace("</p>", "").replace("<p>", "").replace("<b>", "")
//						.replace("</b>", ""));
//				 
//			}
//			if (m2.find()) {
//
//				System.out.println(m2.group(1).replace("<b>", "")
//						.replace("</p>", "").replace("<p>", "").replace("<b>", "")
//						.replace("</b>", ""));
//				 
//			}
//			if (m3.find()) {
//
//				System.out.println(m3.group(1).replace("<b>", "")
//						.replace("</p>", "").replace("<p>", "").replace("<b>", "")
//						.replace("</b>", ""));
//				 
//			}
//			if (m4.find()) {
//
//				System.out.println(m4.group(1).replace("<b>", "")
//						.replace("</p>", "").replace("<p>", "").replace("<b>", "")
//						.replace("</b>", ""));
//				 
//			}
//			if (m5.find()) {
//
//				System.out.println(m5.group(1).replace("<b>", "")
//						.replace("</p>", "").replace("<p>", "").replace("<b>", "")
//						.replace("</b>", ""));
//				 
//			}
//			if (m6.find()) {
//
//				System.out.println(m6.group(1).replace("<b>", "")
//						.replace("</p>", "").replace("<p>", "").replace("<b>", "")
//						.replace("</b>", ""));
//				 
			}
//		 for (String string : list) {
//			Video eo = new Video();
//			 Matcher m = Pattern.compile(string).matcher(sos);
//				if (m.find()) {
//
//					System.out.println(m.group(1).replace("<b>", "")
//							.replace("</p>", "").replace("<p>", "").replace("<b>", "")
//							.replace("</b>", ""));
//					String data = m.group(1).replace("<b>", "")
//							.replace("</p>", "").replace("<p>", "").replace("<b>", "")
//							.replace("</b>", "");
//					eo.setActor(data);
//					eo.setAppId(data);
//				}
//				
//		}
	public static void listNodes(Element node) throws IOException {
		@SuppressWarnings("unchecked")
		List<Attribute> list = node.attributes();

		for (Attribute attribute : list) {
			System.out.println("属性" + attribute.getName() + ":"
					+ attribute.getValue());
		}
	 
		if (!(node.getTextTrim().equals(""))) {

			long start = System.currentTimeMillis();
			Video ns = new Video();
			// System.out.println(node.getName() + "：" + node.getText());
			System.out.println(node.getText());

			String url = node.getText();
			url = Tools.getSource(
					url, "utf-8");
//			org.jsoup.nodes.Document doc = Jsoup.connect(url).userAgent("bbb")
//					.timeout(120000).get();

			try {
				List<String> lists = new ArrayList<String>();
				String titles = PropertiesFactory.getProperties("NeteaseVideo").getProperty("title");
				lists.add(titles);
				String notjson = PropertiesFactory.getProperties("NeteaseVideo").getProperty("notjson");
				lists.add(notjson);
				String text = PropertiesFactory.getProperties("NeteaseVideo").getProperty("main");
				lists.add(text);
				String dir = PropertiesFactory.getProperties("NeteaseVideo").getProperty("dir");
				lists.add(dir);
				String likenum = PropertiesFactory.getProperties("NeteaseVideo").getProperty("like");
				lists.add(likenum);
				String dates = PropertiesFactory.getProperties("NeteaseVideo").getProperty("date");
				lists.add(dates);
				String jsonbody = PropertiesFactory.getProperties("NeteaseVideo").getProperty("script");
				lists.add(jsonbody);
				
//				List<Video> vde = new ArrayList<Video>();
//				Video eo = new Video();
				// for (String string : lists) {
						
					  
					 Matcher m = Pattern.compile(titles).matcher(url);
					 Matcher m1 = Pattern.compile(notjson).matcher(url);
					 Matcher m2 = Pattern.compile(text).matcher(url);
					 Matcher m3 = Pattern.compile(dir).matcher(url);
					 Matcher m4 = Pattern.compile(likenum).matcher(url);
					 Matcher m5 = Pattern.compile(dates).matcher(url);
					 Matcher m6 = Pattern.compile(jsonbody).matcher(url);
						if (m.find()) {

							System.out.println(m.group(1).replace("<b>", "")
									.replace("</p>", "").replace("<p>", "").replace("<b>", "")
									.replace("</b>", ""));
							 
						}
						if (m1.find()) {

							System.out.println(m1.group(1));
							JSONObject object = JSONObject.fromObject(m1.group(1).replace("[", "").replace("]",""));
							 System.err.println(object);
							 String img = (String) object.get("img");
							 System.err.println(img.replace("//", ""));
//							JSONArray arr = JSONArray.fromObject(object);
//							System.err.println(arr.get(0));

							 
						}
						if (m2.find()) {

							System.out.println(m2.group(1).replace("<b>", "")
									.replace("</p>", "").replace("<p>", "").replace("<b>", "")
									.replace("</b>", ""));
							 
						}
						if (m3.find()) {

							System.out.println(m3.group(1).replace("<b>", "")
									.replace("</p>", "").replace("<p>", "").replace("<b>", "")
									.replace("</b>", "").trim());
							 
						}
						if (m4.find()) {

							System.out.println(m4.group(1).replace("<b>", "")
									.replace("</p>", "").replace("<p>", "").replace("<b>", "")
									.replace("</b>", ""));
							 
						}
						if (m5.find()) {

							System.out.println(m5.group(1).replace("<b>", "")
									.replace("</p>", "").replace("<p>", "").replace("<b>", "")
									.replace("</b>", ""));
							 
						}
						if (m6.find()) {

							System.out.println(m6.group(1).replace("<b>", "")
									.replace("</p>", "").replace("<p>", "").replace("<b>", "")
									.replace("</b>", ""));
							JSONObject object = JSONObject.fromObject(m6.group(1));
						
							JSONArray array = JSONArray.fromObject(object.get("img"));
							System.out.println("array等于===：：：：=" + array);
							if (array.size() <= 0) {
								System.err.println("空的array：：：：=" + array);
								ns.setImageUrl("");
							} else {
								Object img2 = array.get(0);
								if (img2 != null) {
									String im = String.valueOf(img2);
									JSONObject ob = JSONObject.fromObject(im);
									String imgurl = ob.getString("src");
									System.out.println("文章首页图片：" + imgurl);
									System.err.println("------------分局线----------------");
									ns.setImageUrl(imgurl);
								} else {
									System.out.println("没有获取到图片！");
								}
							}

							if (ProgType.equals("电台")) {
								JSONArray array2 = JSONArray.fromObject(object
										.get("video"));
								Object audio = array2.get(0);
								String source = String.valueOf(audio);
								JSONObject ob = JSONObject.fromObject(source);
								String audiourl = ob.getString("url_mp4");
								ns.setVideoPath(audiourl);
							} else {
								ns.setVideoPath("");
							}
							
							 
						}
			//	}
//				String ul = doc.select("div").get(3).text();
//				String yu = ul.substring(0, ul.lastIndexOf(" "));
//				System.out.println(yu);
//				System.out.println("喜欢数：" + doc.select("span").get(2).text());
//				System.out.println("发布时间：" + doc.select("span").get(0).text());
//
//				Elements e = doc.getElementsByTag("script").eq(1);
//				String js = e.toString().replace("<script>", "")
//						.replace("</script>", "").replace("window.DATA = ", "");
//				if (js != null) {
//
//					JSONObject object = JSONObject.fromObject(js);
//					String title = object.getString("title");
//					ns.setName(title);
//					System.out.println("js----------" + js);
//					JSONArray array = JSONArray.fromObject(object.get("img"));
//					System.out.println("array等于===：：：：=" + array);
//					if (array.size() <= 0) {
//						System.err.println("空的array：：：：=" + array);
//						ns.setImageUrl("");
//					} else {
//						Object img2 = array.get(0);
//						if (img2 != null) {
//							String im = String.valueOf(img2);
//							JSONObject ob = JSONObject.fromObject(im);
//							String imgurl = ob.getString("src");
//							System.out.println("文章首页图片：" + imgurl);
//							ns.setImageUrl(imgurl);
//						} else {
//							System.out.println("没有获取到图片！");
//						}
//					}
//
//					if (ProgType.equals("电台")) {
//						JSONArray array2 = JSONArray.fromObject(object
//								.get("video"));
//						Object audio = array2.get(0);
//						String source = String.valueOf(audio);
//						JSONObject ob = JSONObject.fromObject(source);
//						String audiourl = ob.getString("url_mp4");
//						ns.setVideoPath(audiourl);
//					} else {
//						ns.setVideoPath("");
//					}
//				} else {
//					ns.setVideoPath("");
//					ns.setImageUrl("");
//					ns.setName("");
//				}
//
//				ns.setAppId("16");
//			 
//			 
//				ns.setAppName("网易新闻");
//				ns.setDescription(doc.select("meta").get(1).attr("content"));
//				ns.setArea("");
//				ns.setPlayCount(doc.select("span").get(2).text());
//				ns.setDirector(yu);
//				int date = doc.select("span").get(0).text().indexOf("201");
//				if (date != -1) {
//					ns.setPublishDate(doc.select("span").get(0).text());
//				} else {
//					ns.setPublishDate("2017-"
//							+ doc.select("span").get(0).text());
//				}
// 
//				ns.setUrl(url);
//
//				String id = url.substring(url.lastIndexOf("/"),
//						url.lastIndexOf(".")).replace("/", "");
//				ns.setProgid(id);
//				ns.setActor("");
//
//			//	boolean bool = true;
//
////				bool = daoImpl.existNews(ns);
////				if (!bool) {
////					daoImpl.insertNews(ns);
////					String prog = daoImpl.queryid(ns.getProgid());
////					daoImpl.insertIntoNewsProg(ns, prog);
////				}
//
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("数组越界！");
			} catch (Exception e) {
				System.out.println("有异常，异常为：" + e.getMessage());

			}
			long end = System.currentTimeMillis();
			//System.err.println("总耗时为：" + (end - start));

		}
		@SuppressWarnings("unchecked")
		Iterator<Element> iterator = node.elementIterator();
		while (iterator.hasNext()) {
			Element e = iterator.next();
			listNodes(e);

		}

	}
	
	public static void getneteaseWebData(String portal)
			throws DocumentException, SAXException, IOException {
		long startTime = System.currentTimeMillis();
		Document document = null;

		String[] partPortals = portal.split(" ");
		ProgType = partPortals[1];
		System.err.println("抓取类型====:" + partPortals[1]);
		// Tools.sleep(1200);
		for (int i = 0; i < 5; i++) {
			String weburl = partPortals[0].substring(0,
					partPortals[0].lastIndexOf("/"))
					+ "/" + i + ".html";
			document = DocumentHelper.parseText(Tools.getSource(weburl, "UTF-8"));
			System.err.println("抓取链接====:" + weburl);
			// Tools.sleep(1200);
			SAXReader sab = new SAXReader();

			Document el = sab.read(new ByteArrayInputStream(document.asXML()
					.getBytes("UTF-8")));

			Element root = el.getRootElement();

			listNodes(root);
		}

		long endTime = System.currentTimeMillis();
		System.err.println("程序运行时间：" + (endTime - startTime) + "ms");
	}
	 
}
