package com.service.TestCollect.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.service.TestCollect.dao.VideoDao;
import com.service.TestCollect.pojo.Video;
import com.zhan.utils.CommonUtils;
import com.zhan.utils.Tools;

public class NeteaseVideoService {

	@Resource
	private VideoDao videoDao;

	public NeteaseVideoService() {
	}

	public void saveNeteaseVideo(String portal) throws InterruptedException {
		String porType = null;
		String[] url = portal.split(" ");
		porType = url[1];
		System.err.println("抓取视频类型：" + porType);
		if (porType.equals("BoBo")) {

			for (int i = 0; i < 11; i++) {
				String ui = url[0].substring(0, url[0].lastIndexOf("/")) + "/"
						+ i + "-10.html";
				String source = Tools.getSource(ui, "utf-8");
				JSONObject obo = JSONObject.fromObject(source);
				JSONArray array = JSONArray.fromObject(obo.get("VBK3JKUIF"));
				for (int j = 0; j < array.size(); j++) {
					Video ns = new Video();
					ns.setAppId("16");
					ns.setProgType(porType);
					System.out.println("图片："
							+ JSONObject.fromObject(array.get(j)).get("cover")
									.toString());
					ns.setImageUrl(JSONObject.fromObject(array.get(j))
							.get("cover").toString());
					ns.setProgid(JSONObject.fromObject(array.get(j)).get("vid")
							.toString());
					ns.setPublishDate(JSONObject.fromObject(array.get(j))
							.get("ptime").toString());
					ns.setName(JSONObject.fromObject(array.get(j)).get("title")
							.toString());
					ns.setSysDate(CommonUtils.getNowDate());
					System.out.println("详细地址："
							+ "http://3g.163.com/v/video/"
							+ JSONObject.fromObject(array.get(j)).get("vid")
									.toString() + ".html");
					ns.setUrl("http://3g.163.com/v/video/"
							+ JSONObject.fromObject(array.get(j)).get("vid")
									.toString() + ".html");
					String vid = JSONObject.fromObject(array.get(j)).get("vid")
							.toString();
					System.out.println("标题："
							+ JSONObject.fromObject(array.get(j)).get("title")
									.toString());
					System.out.println("说明："
							+ JSONObject.fromObject(array.get(j))
									.get("description").toString());
					System.out.println("播放地址："
							+ JSONObject.fromObject(array.get(j))
									.get("mp4_url").toString());
					System.out.println("主键id："
							+ JSONObject.fromObject(array.get(j)).get("vid")
									.toString());
					System.out.println("发布时间："
							+ JSONObject.fromObject(array.get(j)).get("ptime")
									.toString());
					ns.setDescription(JSONObject.fromObject(array.get(j))
							.get("description").toString());
					ns.setArea("");
					ns.setVideoPath(JSONObject.fromObject(array.get(j))
							.get("mp4_url").toString());
					ns.setActor("");
					ns.setAppName("网易新闻.点播");
					ns.setDirector("");
					ns.setPlayCount("");
					if (videoDao.queryId(vid) == null) {
						videoDao.create(ns);
					}
				}
			}

		} else {

			String vid = Tools.source(url[0], "GBK")
					.replace("callback_video(", "").replace(")", "");

			System.err.println("点播视频vid" + vid);

			try {
				JSONObject ob = JSONObject.fromObject(vid);
				JSONArray array = JSONArray.fromObject(ob.get("list"));
				for (int i = 0; i < array.size(); i++) {
					Video ns = new Video();
					ns.setAppId("");
					ns.setProgType(porType);
					ns.setSysDate(CommonUtils.getNowDate());
					String title = JSONObject.fromObject(array.get(i))
							.get("title").toString();
					ns.setName(title);
					System.out.println("标题 ====" + title);
					String weburl = JSONObject.fromObject(array.get(i))
							.get("url").toString();
					ns.setUrl(weburl);
					System.out.println("网址 ====" + weburl);
					String imgurl = JSONObject.fromObject(array.get(i))
							.get("img").toString();
					ns.setImageUrl(imgurl);
					System.out.println("图片 ====" + imgurl);
					String vid2 = JSONObject.fromObject(array.get(i))
							.get("vid").toString();
					ns.setProgid(vid2);

					String comment = JSONObject.fromObject(array.get(i))
							.get("comment").toString();
					if (comment.equals("{}")) {
						System.out.println("空的");
						// JSONArray comment = JSONArray.fromObject();
						ns.setPublishDate("");

					} else {

						JSONObject JO = JSONObject.fromObject(comment);
						String date = JO.getString("createTime");
						System.out.println("创建时间++++"
								+ JO.getString("createTime"));
						ns.setPublishDate(date);
					}
					ns.setDescription(title);
					ns.setArea("");

					String a = vid2.substring(vid2.length() - 2,
							vid2.length() - 1);
					String b = vid2.substring(vid2.length() - 1);
					String xml = "http://xml.ws.126.net/video/" + a + "/" + b
							+ "/1000_" + vid2 + ".xml";
					System.out.println(xml);
					String data = Tools.getSource(xml, "GBK");
					Matcher m = Pattern.compile("<flv>([^<]+)</flv>").matcher(
							data);
					if (m.find()) {
						String url2 = m.group(1);
						System.out.println("正则解析数据" + url2);
						ns.setVideoPath(url2);
						ns.setActor("");
						ns.setAppName("网易新闻.点播");
						ns.setDirector("");
						ns.setPlayCount("");

						System.err.println("没问题！");
					} else {
						ns.setVideoPath("");
						ns.setActor("");
						ns.setAppName("网易新闻.点播");
						ns.setDirector("");
						ns.setPlayCount("");

						System.err.println("不要走这！！");
					}
					if (videoDao.queryId(vid2) == null) {
						videoDao.create(ns);
					}
				}
				System.out.println("总数 ====" + array.size());
			} catch (Exception e) {
				System.err.println("异常为：" + e);
			}

		}
	}

}
