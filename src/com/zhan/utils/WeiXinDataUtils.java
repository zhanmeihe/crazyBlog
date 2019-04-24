package com.zhan.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.net.URLEncoder;
import javax.annotation.Resource;

import com.jayway.jsonpath.JsonPath;
import com.service.TestCollect.dao.CollectionTaskDao;
import com.service.TestCollect.dao.WeiXinArticleDao;
import com.service.TestCollect.dao.WeiXinNumberDao;
import com.service.TestCollect.pojo.CollectionTask;
import com.service.TestCollect.pojo.WeiXinArticle;
import com.service.TestCollect.pojo.WeiXinNumber;

public class WeiXinDataUtils {

	@Resource
	private WeiXinNumberDao weiXinNumberDao;
	@Resource
	private WeiXinArticleDao weiXinArticleDao;
	@Resource
	private CollectionTaskDao collectionTaskDao;

	public String getWxHis() {
		String url = "";
		// TODO Auto-generated method stub
		/**
		 * 当前页面为公众号历史消息时，读取这个程序 在采集队列表中有一个load字段，当值等于1时代表正在被读取
		 * 首先删除采集队列表中load=1的行 然后从队列表中任意select一行
		 */
		collectionTaskDao.deleteByLoad(1);
		CollectionTask queue = collectionTaskDao.selectRandomOne();

		System.out.println("queue is null?" + queue);
		if (queue == null) {// 队列表为空
			/**
			 * 队列表如果空了，就从存储公众号biz的表中取得一个biz， 这里我在公众号表中设置了一个采集时间的time字段，按照正序排列之后，
			 * 就得到时间戳最小的一个公众号记录，并取得它的biz
			 */
			WeiXinNumber weiXin = weiXinNumberDao.selectOne();

			String biz = weiXin.getBiz();
			url = "https://mp.weixin.qq.com/mp/profile_ext?action=home&__biz=" + biz + "#wechat_redirect";// 拼接公众号历史消息url地址（第二种页面形式）
			// 更新刚才提到的公众号表中的采集时间time字段为当前时间戳。
			weiXin.setCollect(System.currentTimeMillis());
			  weiXinNumberDao.updateByPrimaryKey(weiXin);

			System.out.println("getHis weiXin updateResult:" + 1);
		} else {
			// 取得当前这一行的content_url字段
			url = queue.getContentUrl();
			// 将load字段update为1
			collectionTaskDao.updateByContentUrl(queue);
		}
		// 将下一个将要跳转的$url变成js脚本，由anyproxy注入到微信页面中。
		// echo
		// "<script>setTimeout(function(){window.location.href='".$url."';},2000);</script>";
		int randomTime = new Random().nextInt(3) + 3;
		String jsCode = "<script>setTimeout(function(){window.location.href='" + url + "';}," + randomTime * 1000
				+ ");</script>";
		return jsCode;
	}

	public void getMsgExt(String str, String url) {
		// TODO Auto-generated method stub
		String biz = "";
		String sn = "";
		Map<String, String> queryStrs = HttpUrlParser.parseUrl(url);
		if (queryStrs != null) {
			biz = queryStrs.get("__biz");
			biz = biz + "==";
			sn = queryStrs.get("sn");
			sn = "%" + sn + "%";
		}
		/**
		 * $sql = "select * from `文章表` where `biz`='".$biz."' and `content_url`
		 * like '%".$sn."%'" limit 0,1; 根据biz和sn找到对应的文章
		 */
		// Post post = postMapper.selectByBizAndSn(biz, sn);
		Post post = null;

		if (post == null) {
			System.out.println("biz:" + biz);
			System.out.println("sn:" + sn);
			// tmpListMapper.deleteByLoad(1);
			return;
		}

		// System.out.println("json数据:"+str);
		Integer read_num;
		Integer like_num;
		try {
			read_num = JsonPath.read(str, "['appmsgstat']['read_num']");// 阅读量
			like_num = JsonPath.read(str, "['appmsgstat']['like_num']");// 点赞量
		} catch (Exception e) {
			read_num = 123;// 阅读量
			like_num = 321;// 点赞量
			System.out.println("read_num:" + read_num);
			System.out.println("like_num:" + like_num);
			System.out.println(e.getMessage());
		}

		/**
		 * 在这里同样根据sn在采集队列表中删除对应的文章，代表这篇文章可以移出采集队列了 $sql = "delete from `队列表`
		 * where `content_url` like '%".$sn."%'"
		 */
		// tmpListMapper.deleteBySn(sn);

		// 然后将阅读量和点赞量更新到文章表中。
		post.setReadnum(read_num);
		post.setLikenum(like_num);
		// postMapper.updateByPrimaryKey(post);

	}

	public String getWxPost() {
		// TODO Auto-generated method stub
		/**
		 * 当前页面为公众号文章页面时，读取这个程序 首先删除采集队列表中load=1的行 然后从队列表中按照“order by id
		 * asc”选择多行(注意这一行和上面的程序不一样)
		 */
		TmpListMapper tmpListMapper = null;
		tmpListMapper.deleteByLoad(1);
		List<TmpList> queues = tmpListMapper.selectMany(5);
		String url = "";
		if (queues != null && queues.size() != 0 && queues.size() > 1) {
			TmpList queue = queues.get(0);
			url = queue.getContentUrl();
			queue.setIsload(1);
			int result = tmpListMapper.updateByPrimaryKey(queue);
			System.out.println("update result:" + result);
		} else {
			System.out.println("getpost queues is null?" + queues == null ? null : queues.size());
			// WeiXin weiXin = weiXinMapper.selectOne();
			WeiXin weiXin = null;
			String biz = weiXin.getBiz();
			if ((Math.random() > 0.5 ? 1 : 0) == 1) {
				url = "http://mp.weixin.qq.com/mp/getmasssendmsg?__biz=" + biz
						+ "#wechat_webview_type=1&wechat_redirect";// 拼接公众号历史消息url地址（第一种页面形式）
			} else {
				url = "https://mp.weixin.qq.com/mp/profile_ext?action=home&__biz=" + biz + "#wechat_redirect";// 拼接公众号历史消息url地址（第二种页面形式）
			}
			url = "https://mp.weixin.qq.com/mp/profile_ext?action=home&__biz=" + biz + "#wechat_redirect";// 拼接公众号历史消息url地址（第二种页面形式）
			// 更新刚才提到的公众号表中的采集时间time字段为当前时间戳。
			weiXin.setCollect(System.currentTimeMillis());
			// int result = weiXinMapper.updateByPrimaryKey(weiXin);
			int result = 0;
			System.out.println("getPost weiXin updateResult:" + result);
		}
		int randomTime = new Random().nextInt(3) + 3;
		String jsCode = "<script>setTimeout(function(){window.location.href='" + url + "';}," + randomTime * 1000
				+ ");</script>";
		return jsCode;

	}

	public static Map<String, String> parseUrl(String url) {
		String[] e = url.split("&");
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < e.length; i++) {
			if (i == 1) {

				String st = e[i].substring(0, e[i].indexOf("="));
				String end = e[i].substring(e[i].indexOf("=") + 1);
				map.put(st, end);
			} else {
				String redult[] = e[i].split("=");
				map.put(redult[0], redult[1]);
			}

		}
		System.err.println(map.get("__biz"));

		return map;

	}

	public void getMsgJson(String str, String url) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String biz = "";
		Map<String, String> queryStrs = parseUrl(url);
		if (queryStrs != null) {
			biz = queryStrs.get("__biz");
			// biz = biz + "==";
		}
		/**
		 * 从数据库中查询biz是否已经存在，如果不存在则插入， 这代表着我们新添加了一个采集目标公众号。
		 */
		List<WeiXinNumber> results = new ArrayList<>();
				
		results=	weiXinNumberDao.selectByBiz(biz);
		if (results == null || results.size() == 0) {
			WeiXinNumber wxd = new WeiXinNumber();
			wxd.setBiz(biz);
			wxd.setCollect(System.currentTimeMillis());
			weiXinNumberDao.create(wxd);
		}
		// 解析str变量

		List<Object> lists = JsonPath.read(str, "['list']");
		for (Object list : lists) {
			Object json = list;
			int type = JsonPath.read(json, "['comm_msg_info']['type']");
			if (type == 49) {// type=49表示是图文消息
				String content_url = JsonPath.read(json, "$.app_msg_ext_info.content_url");
				content_url = content_url.replace("\\", "").replaceAll("amp;", "");// 获得图文消息的链接地址
				int is_multi = JsonPath.read(json, "$.app_msg_ext_info.is_multi");// 是否是多图文消息
				Integer datetime = JsonPath.read(json, "$.comm_msg_info.datetime");// 图文消息发送时间
				/**
				 * 在这里将图文消息链接地址插入到采集队列库tmplist中 （队列库将在后文介绍，主要目的是建立一个批量采集队列，
				 * 另一个程序将根据队列安排下一个采集的公众号或者文章内容）
				 */
				try {
					if (content_url != null && !"".equals(content_url)) {
						CollectionTask tmpList = new CollectionTask();
						tmpList.setContentUrl(content_url);
						collectionTaskDao.create(tmpList);
					}
				} catch (Exception e) {
					System.out.println("队列已存在,不插入！");
				}

				/**
				 * 在这里根据$content_url从数据库post中判断一下是否重复
				 */
				List<WeiXinArticle> postList = weiXinArticleDao.selectByContentUrl(content_url);

				boolean contentUrlExist = false;
				if (postList != null && postList.size() != 0) {
					contentUrlExist = true;
				}

				if (!contentUrlExist) {// '数据库post中不存在相同的$content_url'
					Integer fileid = JsonPath.read(json, "$.app_msg_ext_info.fileid");// 一个微信给的id
					String title = JsonPath.read(json, "$.app_msg_ext_info.title");// 文章标题
					String title_encode = URLEncoder.encode(title, "utf-8");
					String digest = JsonPath.read(json, "$.app_msg_ext_info.digest");// 文章摘要
					String source_url = JsonPath.read(json, "$.app_msg_ext_info.source_url");// 阅读原文的链接
					source_url = source_url.replace("\\", "");
					String cover = JsonPath.read(json, "$.app_msg_ext_info.cover");// 封面图片
					cover = cover.replace("\\", "");
					/**
					 * 存入数据库
					 */
					System.out.println("头条标题：" + title);
					System.out.println("微信ID：" + fileid);
					System.out.println("文章摘要:" + digest);
					System.out.println("阅读原文链接:" + source_url);
					System.out.println("封面图片地址:" + cover);

					WeiXinArticle wxa = new WeiXinArticle();
					wxa.setBiz(biz);
					wxa.setTitle(title);
					wxa.setTitleEncode(title_encode);
					wxa.setFieldId(fileid);
					wxa.setDigest(digest);
					wxa.setSourceUrl(source_url);
					wxa.setCover(cover);
					wxa.setIsTop(1);// 标记一下是头条内容
					wxa.setIsMulti(is_multi);
					wxa.setDatetime(datetime);
					wxa.setContentUrl(content_url);

					weiXinArticleDao.create(wxa);
				}

				if (is_multi == 1) {// 如果是多图文消息
					List<Object> multiLists = JsonPath.read(json, "['app_msg_ext_info']['multi_app_msg_item_list']");
					for (Object multiList : multiLists) {
						Object multiJson = multiList;
						content_url = JsonPath.read(multiJson, "['content_url']").toString().replace("\\", "")
								.replaceAll("amp;", "");// 图文消息链接地址
						/**
						 * 这里再次根据$content_url判断一下数据库中是否重复以免出错
						 */
						contentUrlExist = false;
						List<WeiXinArticle> posts = weiXinArticleDao.selectByContentUrl(content_url);

						if (posts != null && posts.size() != 0) {
							contentUrlExist = true;
						}
						if (!contentUrlExist) {// '数据库中不存在相同的$content_url'
							/**
							 * 在这里将图文消息链接地址插入到采集队列库中 （队列库将在后文介绍，主要目的是建立一个批量采集队列，
							 * 另一个程序将根据队列安排下一个采集的公众号或者文章内容）
							 */
							if (content_url != null && !"".equals(content_url)) {
								CollectionTask tmpListT = new CollectionTask();
								tmpListT.setContentUrl(content_url);
								collectionTaskDao.create(tmpListT);
							}

							String title = JsonPath.read(multiJson, "$.title");
							String title_encode = URLEncoder.encode(title, "utf-8");
							Integer fileid = JsonPath.read(multiJson, "$.fileid");
							String digest = JsonPath.read(multiJson, "$.digest");
							String source_url = JsonPath.read(multiJson, "$.source_url");
							source_url = source_url.replace("\\", "");
							String cover = JsonPath.read(multiJson, "$.cover");
							cover = cover.replace("\\", "");
							System.out.println("标题:" + title);
							System.out.println("微信ID:" + fileid);
							System.out.println("文章摘要:" + digest);
							System.out.println("阅读原文链接:" + source_url);
							System.out.println("封面图片地址:" + cover);
							WeiXinArticle post = new WeiXinArticle();
							post.setBiz(biz);
							post.setTitle(title);
							post.setTitleEncode(title_encode);
							post.setFieldId(fileid);
							post.setDigest(digest);
							post.setSourceUrl(source_url);
							post.setCover(cover);
							post.setIsTop(0);// 标记一下不是头条内容
							post.setIsMulti(is_multi);
							post.setDatetime(datetime);
							post.setContentUrl(content_url);

							weiXinArticleDao.create(post);

						}
					}
				}
			}
		}
	}

}
