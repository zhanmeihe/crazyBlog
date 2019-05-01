package com.service.TestCollect;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.jayway.jsonpath.JsonPath;
import com.service.TestCollect.dao.BlogInfoDao;
import com.service.TestCollect.dao.BlogUserDao;
import com.service.TestCollect.dao.CollectionTaskDao;
import com.service.TestCollect.dao.CommentDao;
import com.service.TestCollect.dao.CommentZanDao;
import com.service.TestCollect.dao.MyorderInfoDao;
import com.service.TestCollect.dao.PraiseDao;
import com.service.TestCollect.dao.TaskInfoDao;
import com.service.TestCollect.dao.UserInfoDao;
import com.service.TestCollect.dao.VideoDao;
import com.service.TestCollect.dao.WeiXinArticleDao;
import com.service.TestCollect.dao.WeiXinNumberDao;
import com.service.TestCollect.dao.WorkVideoDao;
import com.service.TestCollect.pojo.BlogInfo;
import com.service.TestCollect.pojo.BlogUser;
import com.service.TestCollect.pojo.CollectionTask;
import com.service.TestCollect.pojo.Comment;
import com.service.TestCollect.pojo.CommentZan;
import com.service.TestCollect.pojo.MyorderInfo;
import com.service.TestCollect.pojo.Praise;
import com.service.TestCollect.pojo.SNSUserInfo;
import com.service.TestCollect.pojo.TaskInfo;
import com.service.TestCollect.pojo.UserInfo;
import com.service.TestCollect.pojo.UserInfofileVo;
import com.service.TestCollect.pojo.Video;
import com.service.TestCollect.pojo.WeiXinArticle;
import com.service.TestCollect.pojo.WeiXinNumber;
import com.service.TestCollect.pojo.WeixinOauth2Token;
import com.service.TestCollect.pojo.WorkVideo;
import com.service.TestCollect.service.CSDNSpider;
import com.service.TestCollect.service.NeteaseVideoService;
import com.service.TestCollect.weixinutils.AdvancedUtil;
import com.zhan.ex.RuleException;
import com.zhan.ex.UnisException;
import com.zhan.response.CommonResponse;
import com.zhan.response.CommonSuccessResponse;
import com.zhan.response.SuccessResponse;
import com.zhan.response.SystemErrorResponse;
import com.zhan.session.Token;
import com.zhan.session.UserUtil;
import com.zhan.utils.CheckCode;
import com.zhan.utils.ChinesepreNum;
import com.zhan.utils.CommonUtils;
import com.zhan.utils.Configure;
import com.zhan.utils.Const;
import com.zhan.utils.CookieTool;
import com.zhan.utils.CookieUtils;
import com.zhan.utils.FileReaderUtils;
import com.zhan.utils.HttpUrlParser;
import com.zhan.utils.Ignore;
import com.zhan.utils.MD5;
import com.zhan.utils.MD5Utils;
import com.zhan.utils.Main;
import com.zhan.utils.MaptoListUtils;
import com.zhan.utils.PeanUtils;
import com.zhan.utils.PerimageUtils;
import com.zhan.utils.Post;
import com.zhan.utils.PropertiesFactory;
import com.zhan.utils.RegexConst;
import com.zhan.utils.TmpList;
import com.zhan.utils.TmpListMapper;
import com.zhan.utils.Tools;
import com.zhan.utils.WeiXin;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 
 * @author zhanmeihe
 * 
 */
@Controller
public class DoMainController implements Runnable {

	private static Logger LOGGER = LoggerFactory.getLogger(DoMainController.class);
	// private static Class<Logger> LOGGER = Logger.class;

	/**
	 * 初始化获取阅读数所需要的参数{biz}
	 */
	private String biz = "";

	private static int line = 0;
	/**
	 * 初始化获取阅读数所需要的参数{biz}
	 */
	private String sn = "";
	@Resource
	private VideoDao videoDao;
	@Resource
	private UserInfoDao userInfoDao;
	@Resource
	private TaskInfoDao taskInfoDao;
	@Resource
	private MyorderInfoDao myorderInfoDao;
	@Resource
	private WorkVideoDao workVideoDao;
	@Resource
	private BlogInfoDao blogInfoDao;
	@Resource
	private BlogUserDao blogUserDao;
	@Resource
	private PraiseDao praiseDao;
	@Resource
	private CommentDao commentDao;
	@Resource
	private WeiXinNumberDao weiXinNumberDao;
	@Resource
	private WeiXinArticleDao weiXinArticleDao;
	@Resource
	private CollectionTaskDao collectionTaskDao;
	@Resource
	private CommentZanDao commentZanDao;

	@RequestMapping(value = "/getProxy", method = RequestMethod.GET)
	public void getProxy(HttpServletResponse response) {

		try {
			System.err.println("代理开始.......");
			Main.ProxyIp();
		} catch (UnisException e) {
			LOGGER.error("异常", e);
		} catch (Exception e) {
			LOGGER.error("异常", e);
		}
	}

	@RequestMapping(value = "/getWxHis", method = RequestMethod.GET)
	public void getWxHis(HttpServletResponse response) {

		try {

			String url = "";
			// TODO Auto-generated method stub
			/**
			 * 当前页面为公众号历史消息时，读取这个程序 在采集队列表中有一个load字段，当值等于1时代表正在被读取 首先删除采集队列表中load=1的行
			 * 然后从队列表中任意select一行
			 */
			Thread.sleep(700);
			collectionTaskDao.deleteByLoad(1);
			CollectionTask queue = collectionTaskDao.selectRandomOne();

			System.out.println("queue is null?" + queue);
			if (queue == null) {// 队列表为空
				/**
				 * 队列表如果空了，就从存储公众号biz的表中取得一个biz， 这里我在公众号表中设置了一个采集时间的time字段，按照正序排列之后，
				 * 就得到时间戳最小的一个公众号记录，并取得它的biz
				 */
				WeiXinNumber weiXin = weiXinNumberDao.selectOne();
				if (null == weiXin) {
					weiXin = weiXinNumberDao.selectOne();
				}
				String biz = weiXin.getBiz();
				url = "https://mp.weixin.qq.com/mp/profile_ext?action=home&__biz=" + biz + "#wechat_redirect";// 拼接公众号历史消息url地址（第二种页面形式）
				// 更新刚才提到的公众号表中的采集时间time字段为当前时间戳。
				weiXin.setCollect(System.currentTimeMillis());
				weiXinNumberDao.updateByPrimaryKey(weiXin);

				System.out.println("getHis weiXin updateResult:" + 1);
			} else {
				// 取得当前这一行的content_url字段
				url = queue.getContentUrl();
				queue.setLoad(1);
				// 将load字段update为1
				collectionTaskDao.updateByContentUrl(queue);
			}
			// url = "https://mp.weixin.qq.com/mp/profile_ext?action=home&__biz=" +
			// "MjM5NjE1MDkwMA=="
//					+ "#wechat_redirect";// 拼接公众号历史消息url地址（第二种页面形式）
			int randomTime = new Random().nextInt(3) + 3;
			String jsCode = "<script>setTimeout(function(){window.location.href='" + url + "';}," + randomTime * 1000
					+ ");</script>";
			System.err.println("返回到微信页面getWxHis：" + jsCode);
			PrintWriter out = response.getWriter();
			out.println(jsCode);
			out.flush();
			out.close();
		} catch (UnisException e) {

			LOGGER.info("异常", e);

		} catch (Exception e) {

			LOGGER.error("异常", e);

		}
	}

	@RequestMapping(value = "/getMsgExt", method = RequestMethod.POST)
	public String getMsgExt(@RequestParam(value = "str") String str, @RequestParam(value = "url") String url,

			HttpServletRequest request, HttpServletResponse response, Model model) {

		try {
			String s = str;
			String u = url;
			str = URLDecoder.decode(str, "UTF-8").replace("&quot;", "\"").replace("\\", "");
			url = URLDecoder.decode(url, "UTF-8").replace("&quot;", "\"").replace("\\", "");
			System.err.println(str);
			System.err.println(url);

			// TODO Auto-generated method stub
			String biz = "";
			String sn = "";
			Map<String, String> queryStrs = parseUrl(url);
			if (queryStrs != null) {
				biz = queryStrs.get("__biz");
				// biz = biz + "==";
				sn = queryStrs.get("sn");

			}
			/**
			 * $sql = "select * from `文章表` where `biz`='".$biz."' and `content_url` like
			 * '%".$sn."%'" limit 0,1; 根据biz和sn找到对应的文章
			 */
			// start
//			WeiXinArticle post = weiXinArticleDao.selectByBizAndSn(biz, sn);
//
//			if (post == null) {
//				System.out.println("biz:" + biz);
//				System.out.println("sn:" + sn);
//				collectionTaskDao.deleteByLoad(1);
//			}
//
//			Integer read_num;
//			int like_num;
//			try {
//				read_num = JsonPath.read(str, "['appmsgstat']['read_num']");// 阅读量
//				like_num = JsonPath.read(str, "['appmsgstat']['like_num']");// 点赞量
//			} catch (Exception e) {
//				read_num = 123;// 阅读量
//				like_num = 321;// 点赞量
//				System.out.println("read_num:" + read_num);
//				System.out.println("like_num:" + like_num);
//				System.out.println(e.getMessage());
//			}
//
//			/**
//			 * 在这里同样根据sn在采集队列表中删除对应的文章，代表这篇文章可以移出采集队列了 $sql = "delete from `队列表`
//			 * where `content_url` like '%".$sn."%'"
//			 */
//			collectionTaskDao.deleteBySn(sn);
//
//			// 然后将阅读量和点赞量更新到文章表中。
//			post.setReadNum(read_num);
//			post.setLikeNum(like_num);
//			weiXinArticleDao.updateByPrimaryKey(post);
//         
			// end
			return "redirect:/getWxPost";
		} catch (UnisException e) {
			model.addAttribute("errormsg", e);
			LOGGER.info("异常", e);
		} catch (Exception e) {
			model.addAttribute("errormsg", e);
			LOGGER.error("异常", e);
		}
		return "redirect:/getWxPost";
	}

	@RequestMapping(value = "/getWxPost", method = RequestMethod.GET)
	public void getWxPost(HttpServletRequest request, HttpServletResponse response, Model model) {

		try {

			// TODO Auto-generated method stub
			/**
			 * 当前页面为公众号文章页面时，读取这个程序 首先删除采集队列表中load=1的行 然后从队列表中按照“order by id
			 * asc”选择多行(注意这一行和上面的程序不一样)
			 */

			collectionTaskDao.deleteByLoad(1);
			List<CollectionTask> queues = collectionTaskDao.selectMany(5);
			String url = "";
			if (queues != null && queues.size() != 0 && queues.size() > 1) {
				CollectionTask queue = queues.get(0);
				url = queue.getContentUrl();
				queue.setLoad(1);
				collectionTaskDao.updateByPrimaryKey(queue);
				System.out.println("update result:" + 1);
			} else {
				System.out.println("getpost queues is null?" + queues == null ? null : queues.size());
				WeiXinNumber weiXin = weiXinNumberDao.selectOne();

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
				weiXinNumberDao.updateByPrimaryKey(weiXin);

				System.out.println("getPost weiXin updateResult:" + 1);
			}
			int randomTime = new Random().nextInt(3) + 3;
			url = "https://mp.weixin.qq.com/mp/profile_ext?action=home&__biz=MjM5NjE1MDkwMA==#wechat_redirect";
			String jsCode = "<script>setTimeout(function(){window.location.href='" + url + "';}," + randomTime * 1000
					+ ");</script>";
			// jsCode = url;

			System.err.println("返回到微信页面getWxPost：" + jsCode);
			PrintWriter out = response.getWriter();
			out.println(jsCode);
			out.flush();
			out.close();
		} catch (UnisException e) {

			LOGGER.info("异常", e);

		} catch (Exception e) {

			LOGGER.error("异常", e);
		}
	}

	@RequestMapping(value = "/getMsgJson", method = RequestMethod.POST)
	public ModelAndView getMsgJson(@RequestParam(value = "str") String str, @RequestParam(value = "url") String url,

			HttpServletRequest request, HttpServletResponse response, Model model) {

		try {

			str = URLDecoder.decode(str, "UTF-8").replace("&quot;", "\"").replace("\\", "");
			url = URLDecoder.decode(url, "UTF-8").replace("&quot;", "\"").replace("\\", "");
			boolean re = true;
			while (re) {
				if (!str.equals("")) {
					DoMainController.line = 2;
					System.err.println(str);
					System.err.println(url);
					// wxd.getMsgJson1(URLDecoder.decode(str, "UTF-8").replace("&quot;",
					// "\"").replace("\\", ""),
					// URLDecoder.decode(url, "UTF-8").replace("&quot;",
					// "\"").replace("\\", ""));
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

					results = weiXinNumberDao.selectByBiz(biz);
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
//								if (!str.equals("")) {
//									str = "";
//									Const.a = 0;
//									continue;
//								} else {
//									Const.a++;
//									Thread.sleep(500);
//									if (Const.a == 300) {
//										System.err.println("开始执行下一个公众号"+Const.a);
//									}
//								}

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
								List<Object> multiLists = JsonPath.read(json,
										"['app_msg_ext_info']['multi_app_msg_item_list']");
								for (Object multiList : multiLists) {
									Object multiJson = multiList;
									content_url = JsonPath.read(multiJson, "['content_url']").toString()
											.replace("\\", "").replaceAll("amp;", "");// 图文消息链接地址
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
						// result = false;
					}
					str = "";
					Const.a = 0;
					continue;
				} else {
					Const.a++;
					Thread.sleep(500);
					if (Const.a == 300) {
						PrintWriter out = response.getWriter();
						System.err.println("开始执行下一个公众号" + Const.a);
						Const.a = 0;
						out.println("阿里斯顿哈刘德华卡仕达双卡双待啦");
						out.flush();
						out.close();

					}
				}
			}

		} catch (UnisException e) {
			model.addAttribute("errormsg", e);
			LOGGER.info("异常", e);
		} catch (Exception e) {
			model.addAttribute("errormsg", e);
			LOGGER.error("异常", e);
		}
		return null;
	}

	/**
	 * 抓取网易端视频接口
	 */
	@ResponseBody
	@RequestMapping(value = "/unis/NeteaseLive/app-htm", method = RequestMethod.GET, produces = "application/json")
	public CommonResponse GetVideoapp(Model model, NeteaseVideoService service, HttpServletRequest request,
			HttpServletResponse response) {
		try {

			List<String> lines = PropertiesFactory.loadAllWebs();
			for (String line : lines) {
				List<String> portals = PropertiesFactory.loadPortalsByWeb(line);
				for (String portal : portals) {
					saveNeteaseVideo(portal);
				}
			}
			return new SuccessResponse();
		} catch (UnisException e) {
			LOGGER.info("异常", e);
			return new CommonResponse(e.getCode(), e.getMessage());
		} catch (Exception e) {
			LOGGER.info("异常", e);
		}
		return new SystemErrorResponse();
	}

	/**
	 * 展示和播放网易视频接口
	 */

	@RequestMapping(value = "/unis/show.video.htl/{vid}/.php", method = RequestMethod.GET)
	public String VideoShow(@PathVariable("vid") String vid, Model model) {

		try {
			Video vo = videoDao.queryId(vid);
			model.addAttribute("vidpath", vo);
			return "netease/Showvideo";
		} catch (UnisException e) {
			model.addAttribute("errormsg", e);
			LOGGER.info("异常", e);
			return "errorpage/error";
		} catch (Exception e) {
			model.addAttribute("errormsg", e);
			LOGGER.error("异常", e);
			return "errorpage/error";
		}
	}

	/**
	 * 查询网易视频接口
	 */
	@RequestMapping(value = "/video/netease.py/{PageONE}/{MaxRows}", method = RequestMethod.GET)
	public String videoList(@PathVariable("PageONE") int PageONE, @PathVariable("MaxRows") int MaxRows, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			int firstResult = PageONE * MaxRows;
			List<Video> de = videoDao.querydata(firstResult, MaxRows);
			model.addAttribute("videolist", de);
			return "netease/NeteasteVideo";
		} catch (UnisException e) {
			model.addAttribute("errormsg", e);
			LOGGER.info("异常", e);
			return "errorpage/error";
		} catch (Exception e) {
			model.addAttribute("errormsg", e);
			LOGGER.info("异常", e);
			return "errorpage/error";
		}
	}

	/**
	 * 获取所有分类total数接口
	 */

	@RequestMapping(value = "/unis/category/InUYBOIh8hMHHOHIG-htm", method = RequestMethod.GET, produces = "application/json")
	public String IficationVideo(@RequestParam(value = "token") String token, Model model) {

		try {

			List<Video> de = videoDao.querytype();
			model.addAttribute("arraytype", de);
			return "netease/VideoType";
		} catch (UnisException e) {
		} catch (Exception e) {
			model.addAttribute("errormsg", e);
			LOGGER.info("异常", e);
			return "errorpage/error";
		}
		return "errorpage/error";
	}

	@RequestMapping(value = "/unis/videodetail.PHP", method = RequestMethod.GET, produces = "application/json")
	public String getDetail(@RequestParam(value = "videotype") String videotype,
			@RequestParam(value = "start") int start, @RequestParam(value = "pageSzie") int pageSzie,
			HttpServletRequest request, HttpServletResponse response, Model model) {

		try {
			int firstResult = start * pageSzie;
			List<Video> vo = videoDao.queryvideoType(firstResult, pageSzie, videotype);
			model.addAttribute("videolist", vo);
			return "netease/NeteasteVideo";
		} catch (UnisException e) {
			model.addAttribute("errormsg", e);
			LOGGER.info("异常", e);
			return "errorpage/error";
		} catch (Exception e) {
			model.addAttribute("errormsg", e);
			LOGGER.info("异常", e);
			return "errorpage/error";
		}
	}

	/**
	 * {------------------------博客网站项目接口---------------------}
	 */
	/**
	 * jsp页面跳转接口
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return 需要使用高版本MySQLjar包{不然会报错！！！！Unexpected exception encountered during
	 *         query}
	 */

	@RequestMapping(value = "/Userinfo/blogRegistr", method = RequestMethod.POST)
	public String blogRegistr(@RequestParam(value = "userName") String UserName,
			@RequestParam(value = "nickNmae") String nickNmae, @RequestParam(value = "passWord") String passWord,

			HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			BlogUser user = new BlogUser();
			user.setAddress("");
			user.setAge(12);
			user.setCreateDate(CommonUtils.getNowDate());
			user.setHeadUrl("http://www.focode.cn/common/showImage?fileName=imagefile/system.jpg");
			user.setNickName(nickNmae);
			user.setPassWord(MD5.GetMD5Code(passWord));
			user.setSex(0);
			user.setSignature("");
			user.setUpdateDate(CommonUtils.getNowDate());
			user.setUserId(CommonUtils.getUUID());
			user.setUserName(UserName);
			user.setWork("");
			BlogUser users = blogUserDao.queryUserName(UserName);
			if (null == users) {
				blogUserDao.create(user);
				model.addAttribute("userName", UserName);
				model.addAttribute("passWord", passWord);
				return "forward:/u";
			} else {
				model.addAttribute("errorMsg", "用户已经存在请登录");

				return "redirect:/sign_login";
			}

		} catch (Exception e) {
			LOGGER.error("异常", e);
		}
		return null;
	}

	@RequestMapping(value = "/index.SHTML", method = RequestMethod.GET, produces = "application/json")
	public String IndexPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			HttpSession session = request.getSession();
			session.setAttribute("imagePath", "/home/testproject");
			String value = (String) session.getAttribute("imagePath");
			System.out.println("获取session值是：" + value);
			int start = 0;
			 
			List<BlogInfo> bi = blogInfoDao.indexquery(start, 10);
			List<BlogInfo> bif = new ArrayList<>();
			for (BlogInfo blogInfo : bi) {
//				String v = "/home/blogfile/uplaod/file/2019042815/";
//				blogInfo.setBlogContent(FileReaderUtils.readFile(v+blogInfo.getBlogContent().substring(blogInfo.getBlogContent().lastIndexOf("/")+1)));
				blogInfo.setBlogContent(FileReaderUtils.readFile(blogInfo.getBlogContent()));
				if (blogInfo.getImageUrl() == null || blogInfo.getImageUrl().equals("")) {
					blogInfo.setImageUrl(PerimageUtils.getImgStr(blogInfo.getBlogContent()));
				}

				if (blogInfo.getBlogContent().length() > 150) {
					new PeanUtils();
					String subcontent = PeanUtils.delHTMLTag(blogInfo.getBlogContent());
					if (!subcontent.equals("") && subcontent.length() >= 150) {
						subcontent = subcontent.substring(0, 150);
						blogInfo.setBlogContent(subcontent + "...");
					} else {
						blogInfo.setBlogContent(subcontent);
					}
					System.err.println(subcontent);

					bif.add(blogInfo);
				} else {
					new PeanUtils();
					String subcontent = PeanUtils.delHTMLTag(blogInfo.getBlogContent());
					blogInfo.setBlogContent(subcontent);
					bif.add(blogInfo);
				}
			}
			model.addAttribute("nextpage", 0);
			model.addAttribute("bloglist", bif);

			return "blog/blog";
		}

		catch (UnisException e) {
			LOGGER.info("异常", e);
		} catch (Exception e) {

		}
		return null;
	}
	
	@RequestMapping(value = "/page/Pagination/{nextpage}", method = RequestMethod.GET, produces = "application/json")
	public String Page(@PathVariable("nextpage") int nextpage,HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			HttpSession session = request.getSession();
			session.setAttribute("imagePath", "/home/testproject");
			String value = (String) session.getAttribute("imagePath");
			System.out.println("获取session值是：" + value);
			 nextpage = nextpage+1; 
			List<BlogInfo> bi = blogInfoDao.indexquery(nextpage*10, 10);
			List<BlogInfo> bif = new ArrayList<>();
			for (BlogInfo blogInfo : bi) {
				//String v = "/home/blogfile/uplaod/file/2019042815/";
				//blogInfo.setBlogContent(FileReaderUtils.readFile(v+blogInfo.getBlogContent().substring(blogInfo.getBlogContent().lastIndexOf("/")+1)));
				blogInfo.setBlogContent(FileReaderUtils.readFile(blogInfo.getBlogContent()));
				if (blogInfo.getImageUrl() == null || blogInfo.getImageUrl().equals("")) {
					blogInfo.setImageUrl(PerimageUtils.getImgStr(blogInfo.getBlogContent()));
				}

				if (blogInfo.getBlogContent().length() > 150) {
					new PeanUtils();
					String subcontent = PeanUtils.delHTMLTag(blogInfo.getBlogContent());
					if (!subcontent.equals("") && subcontent.length() >= 150) {
						subcontent = subcontent.substring(0, 150);
						blogInfo.setBlogContent(subcontent + "...");
					} else {
						blogInfo.setBlogContent(subcontent);
					}
					System.err.println(subcontent);

					bif.add(blogInfo);
				} else {
					new PeanUtils();
					String subcontent = PeanUtils.delHTMLTag(blogInfo.getBlogContent());
					blogInfo.setBlogContent(subcontent);
					bif.add(blogInfo);
				}
			}
			model.addAttribute("nextpage", nextpage);
			model.addAttribute("bloglist", bif);

			return "blog/blog";
		}

		catch (UnisException e) {
			LOGGER.info("异常", e);
		} catch (Exception e) {

		}
		return null;
	}

	/*
	 * 打开blog详细页
	 */

	@RequestMapping(value = "/b/{blogId}", method = RequestMethod.GET, produces = "application/json")
	public String blogdetail(@PathVariable("blogId") String blogId, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		try {

			BlogInfo bo = blogInfoDao.queryId(blogId);
			if (bo == null) {
				// 返回错误页面
				return "blog/errorpage";
			}
			BlogUser user = new BlogUser();
			if (CookieUtils.ifCookies(request)) {
				Cookie[] cookie = request.getCookies();
				for (Cookie cookies : cookie) {
					if (cookies.getName().equals("userid")) {
						user = blogUserDao.queryUser(MD5Utils.getFromBASE64(cookies.getValue()));
					}
				}

			}
			BlogUser user2 = blogUserDao.queryUser(bo.getUserId());

			int subStringNum = 50;
			bo.setBlogContent(FileReaderUtils.readFile(bo.getBlogContent()));
			subStringNum = bo.getBlogContent().length() >= 50 ? subStringNum : bo.getBlogContent().length();
			String content = PeanUtils.delHTMLTag(bo.getBlogContent().substring(0, subStringNum));
			int num = new ChinesepreNum().chineseCount(bo.getBlogContent());
			Praise pe = praiseDao.selectNum(blogId);
			// 待优化
			List<Comment> coc = commentDao.queryCommentAll(0, 1000, blogId);
			bo.setPraiseCount(pe.getCountZan());
			model.addAttribute("blogdetail", bo);
			model.addAttribute("content", content);
			model.addAttribute("user2", user2);
			model.addAttribute("user", user);
			model.addAttribute("num", num);
			model.addAttribute("pinglunnum", coc.size());
			return "blog/blogdetail";
		} catch (UnisException e) {
			LOGGER.info("异常", e);
		} catch (Exception e) {
			LOGGER.info("异常", e);
			System.err.println(e);
		}
		// 异常处理返回
		// {后期}
		return "blog/errorpage";
	}

	@Token(save = true)
	@RequestMapping(value = "/sign_login", method = RequestMethod.GET, produces = "application/json")
	public ModelAndView login(HttpSession session, HttpServletRequest request,
			@RequestParam(value = "backUrl", required = false) String backUrl, HttpServletResponse response,
			Model model) {
		try {
			String error = request.getParameter("errorMsg");
			session.setAttribute("backUrl", backUrl);
			List<BlogInfo> lis = new ArrayList<>();
			BlogUser bu = new BlogUser();
			Cookie[] dd1 = request.getCookies();
			if (dd1 == null) {
				model.addAttribute("user", "");
				return new ModelAndView("blog/editWord");
			}
			if (dd1.length >= 3) {

				for (Cookie cookie : dd1) {
					if (cookie.getName().equals("userName") && !cookie.getValue().equals("")) {
						bu = blogUserDao.queryUserName(MD5Utils.getFromBASE64(cookie.getValue()));
					}
					if (cookie.getName().equals("userid") && !cookie.getValue().equals("")) {
						lis = blogInfoDao.selectallData(MD5Utils.getFromBASE64(cookie.getValue()),0);
					}
				}
				if (lis.size() > 1 && bu.getUserId() != null) {

					return new ModelAndView("redirect:/u/" + bu.getUserId() + "_");
				}
			} else {
				model.addAttribute("errorMsg", "请重新登录");
				return new ModelAndView("blog/login");
			}
			if (error != null && !error.equals("")) {
				model.addAttribute("error", request.getParameter("errorMsg"));
			} else {
				model.addAttribute("errorMsg", "请重新登录");
			}
			return new ModelAndView("blog/login");
		} catch (UnisException e) {
			LOGGER.info("异常", e);
			model.addAttribute("errorMsg", "请重新登录");
		} catch (Exception e) {
			LOGGER.info("异常", e);
			model.addAttribute("errorMsg", "请重新登录");
		}
		// model.addAttribute("errorMsg", "请重新登录");
		return new ModelAndView("redirect:/sign_login");
	}

	@Token(remove = true)
	// @Valid BlogUser ff,验证
	@RequestMapping(value = "/u", method = RequestMethod.POST, produces = "application/json")
	public ModelAndView loginsuccess(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			Model model, RedirectAttributes attributes, @RequestParam(value = "userName") String userName,
			// @RequestParam(value = "backuri") String backuri,
			@RequestParam(value = "passWord") String passWord) throws IOException {
		try {
			// url = /crazy_blog/editw
			String url = (String) session.getAttribute("backUrl");
			url = MD5Utils.getFromBASE64(url);
			// System.out.println(backuri);
			// 天 //时 //分 //秒 30 * 24 * 60 * 60;
			int loginMaxAge = 2 * 60 * 60;
			BlogUser users = blogUserDao.queryUserName(userName);

			if (users != null) {
				if (!StringUtils.equals(MD5.GetMD5Code(passWord), users.getPassWord())) {
					String z = MD5.GetMD5Code(passWord);
					String s = users.getPassWord();

					throw new UnisException("登录密码或用户名错误");
				}
			} else {
				throw new UnisException("用户不存在");
			}
			session = request.getSession();
			String verificationCode = (String) session.getAttribute("verificationCode");
			String checkcode = request.getParameter("checkCode");
			// PrintWriter out = response.getWriter();
			if (Ignore.ignoreCaseEquals(checkcode, verificationCode)) {
				System.out.println("验证码正确");
			} else {
				throw new UnisException("附加码错误");
			}

			// List<BlogUser> user =
			// blogUserDao.queryUserBlogData(users.getUserId());
			List<BlogInfo> bf = blogInfoDao.selectallData(users.getUserId(),0);
			// 字数count
			int num = 0;

			// num = new
			// ChinesepreNum().chineseCount(blogInfo.getBlogContent());
			// num++;
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < bf.size(); i++) {
				 bf.get(i).setBlogContent(FileReaderUtils.readFile(bf.get(i).getBlogContent()));
				num += new ChinesepreNum().chineseCount(bf.get(i).getBlogContent());
			}
			UserUtil.setUser(users);
			// 获取cookie值
			CookieTool.addCookie(response, "userName", MD5Utils.getBASE64(userName), loginMaxAge);
			CookieTool.addCookie(response, "userid", MD5Utils.getBASE64(users.getUserId()), loginMaxAge);
			CookieTool.addCookie(response, "passWord", MD5Utils.getBASE64(passWord), loginMaxAge);
			session.setAttribute("user", users);
			Cookie[] dd1 = request.getCookies();
			for (int i = 0; i < dd1.length; i++) {
				System.out.println("cookie*****--" + dd1[i].getName() + ":" + dd1[i].getValue());
			}
			List<BlogInfo> blist = new ArrayList<>();
			for (BlogInfo blogInfo : bf) {
				blogInfo.setBlogContent(FileReaderUtils.readFile(blogInfo.getBlogContent()));
				if (blogInfo.getBlogContent().length() >= 150) {
					
					String content = PeanUtils.delHTMLTag(blogInfo.getBlogContent().substring(0, 150));
					blogInfo.setBlogContent(content);
					blist.add(blogInfo);
				} else {
					String content = PeanUtils.delHTMLTag(blogInfo.getBlogContent());
					blogInfo.setBlogContent(content);
					blist.add(blogInfo);
				}

			}
			if (url != null && !url.equals("")) {
				return new ModelAndView("redirect:" + url.substring(11));
			}
			
			attributes.addFlashAttribute("blogdatalist", blist);
			attributes.addFlashAttribute("textnum", num);
			attributes.addFlashAttribute("bloguser", users);
			attributes.addFlashAttribute("articlenum", bf.size());
			// 转发post forward
			// 重定向 get
			// return "redirect:/s";
			// return "blog/medetail";
			// return new ModelAndView("redirect:/u/" + users.getUserId());
			return new ModelAndView("redirect:/index.SHTML");
			// return new ModelAndView("blog/blog");
		} catch (UnisException e) {
			LOGGER.info("异常", e);
			Cookie[] dd = request.getCookies();
			System.out.println(dd.length);
			attributes.addAttribute("errorMsg", e.getMessage());
			attributes.addAttribute(dd[0].getName(), dd[0].getValue());

			return new ModelAndView("redirect:/sign_login");

		} catch (Exception e) {
			LOGGER.info("异常", e);
			attributes.addAttribute("errorMsg", e.getMessage());
			return new ModelAndView("redirect:/sign_login");
		}

	}

	/**
	 * @author zhanmeihe 验证验证码
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/verificationCode", method = RequestMethod.POST)
	public void checkCode(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		String verificationCode = (String) session.getAttribute("verificationCode");
		String checkcode = request.getParameter("op");
		PrintWriter out = response.getWriter();
		if (Ignore.ignoreCaseEquals(checkcode, verificationCode)) {
			out.println(1);
		} else {
			out.println(0);
		}
		out.flush();
		out.close();

	}

	/**
	 * 采集CSDN
	 * 
	 * @throws InterruptedException
	 */
	@RequestMapping(value = "/spidercsdn", method = RequestMethod.GET)
	public void SpiderCsdn() throws InterruptedException {

		try {
			CSDNSpider sc = new CSDNSpider();

			List<String> title = new ArrayList<>();
			int u = 0;
			long starttime = System.currentTimeMillis();
			while (true) {

				for (String url : sc.getlist()) {

					// String data = Tools.getGzipSource(url, "utf-8");
					JSONObject json = sc.httpGet(url);
					// JSONObject.fromObject(data);
					JSONArray list = JSONArray.fromObject(json.get("articles"));
					for (int i = 0; i < list.size(); i++) {
						u++;
						JSONObject ob = JSONObject.fromObject(list.get(i));
						// content_views
						// htmledit_views

						// 临时排重
//						if (title.contains(ob.getString("title"))) {
//							System.out.println("已经存在");
//							continue;
//						}
						boolean d = blogInfoDao
								.ifExist(ob.getString("url").substring(ob.getString("url").lastIndexOf("/") + 1));
						if (d) {
							continue;
						}
						BlogInfo blog = new BlogInfo();
						blog.setAuthor("code神");
						blog.setBlogId(ob.getString("url").substring(ob.getString("url").lastIndexOf("/") + 1));
						blog.setUserId("1");
						blog.setComments("");
						blog.setCommentsNum(0);
						blog.setCreateblogDate(CommonUtils.getNowDate());
						blog.setUpdateDate(CommonUtils.getNowDate());
						blog.setImageUrl("");
						blog.setPraiseCount(0);
						// title.add(ob.getString("title"));
						System.out.println("CSDN博客标题：" + ob.getString("title"));
						blog.setTitle(ob.getString("title"));
						System.out.println("CSDN博客链接：" + ob.getString("url"));
						String html = Tools.source(ob.getString("url"), "utf-8");
						// System.err.println(html);
						Document doc = Jsoup.parse(html);

						Elements rows = doc.select("div[class=htmledit_views]");

						if (rows.size() >= 1) {
							System.out.println(3);
							Element rowss = rows.get(0);
							if (rowss.html().isEmpty() || rowss.html().length() <= 0) {
								continue;
							}
							blog.setBlogContent(rowss.html());

						} else {
							// error_text{404页面不处理}

							Elements el = doc.select("div[class=error_text]");
							if (el.size() >= 1) {
								System.out.println("抱歉404！找不到页面了");
								continue;
							} else {
								Elements row = doc.select("div[id=content_views]");

								if (row.size() >= 1) {

									Element rowss = row.get(0);
									if (rowss.html().isEmpty() || rowss.html().length() <= 0) {
										continue;
									}
									blog.setBlogContent(rowss.html());
								}
							}
						}
						
						blog.setBlogContent(new UtilsController().updateBlogData(blog));
						blogInfoDao.create(blog);
						System.out.println("抓取博客入库success！");
					}
				}
				long endtime = System.currentTimeMillis();
				long resulttime = (endtime - starttime) / 1000;
				System.err.println("CSDN博客网站数据一轮抓取完成，" + "等待20秒进行新一轮抓取,爬去数量：" + u + "耗时为：" + resulttime + "秒");
				Thread.sleep(20000);
			}
		} catch (UnisException e) {
			LOGGER.error("异常信息", e);
			System.out.println(e);
		} catch (Exception e) {
			LOGGER.error("异常信息", e);
			System.out.println(e);
		}
	}

	/**
	 * 评论点赞
	 */
	@RequestMapping(value = "/CommentLike", method = RequestMethod.POST)
	public void addPraiseComment(HttpServletRequest request, Model model, HttpServletResponse response) {

		try {
			Comment cot = new Comment();

			String[] params = request.getParameter("op").split(",");
			Cookie[] dd1 = request.getCookies();
			PrintWriter out = response.getWriter();
			cot = commentDao.queryComment(params[0]);
			if (CookieUtils.ifCookies(request)) {
				String user = "";
				for (Cookie cookie : dd1) {
					if (cookie.getName().equals("userName")) {
						user = cookie.getValue();
						continue;
					}
				}
				model.addAttribute("user", user);
				CommentZan co = commentZanDao.selectCommentData(params[1], params[0]);
				if (null == co) {
					CommentZan cz = new CommentZan();
					cz.setcommentId(params[0]);
					cz.setCreateDate(CommonUtils.getNowDate());
					cz.setUpdateDate(CommonUtils.getNowDate());
					cz.setUserId(params[1]);
					cz.setStatus(1);
					commentZanDao.createCommentZan(cz);
					cot.setUpdateDate(CommonUtils.getNowDate());
					cot.setZanNum(cot.getZanNum() + 1);
					commentDao.updateComments(cot);
				} else {
					co.setUpdateDate(CommonUtils.getNowDate());
					int status = 0;
					if (co.getStatus() == 1) {
						status = 0;
						cot.setUpdateDate(CommonUtils.getNowDate());
						cot.setZanNum(cot.getZanNum() - 1);
						commentDao.updateComments(cot);
						co.setStatus(0);
					} else {
						status = 1;
						cot.setUpdateDate(CommonUtils.getNowDate());
						cot.setZanNum(cot.getZanNum() + 1);
						commentDao.updateComments(cot);
						co.setStatus(1);
					}
					commentZanDao.updateCommentZan(co);

				}

				// int num = commentZanDao.queryCommentNum(params[0]);
				// out.println(num);
				out.println(1);
			} else {
				out.println(-1);
			}
			out.flush();
			out.close();

		} catch (UnisException e) {
			LOGGER.error("异常信息", e);
		} catch (Exception e) {
			LOGGER.error("异常信息", e);
		}
	}

	/**
	 * 文章点赞
	 * 
	 * @author zhanmeihe
	 * @param blogid
	 * @param userId
	 * @param likeNum
	 * @param request
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/addZanIndel", method = RequestMethod.POST)
	public void addPraise(HttpServletRequest request, Model model, HttpServletResponse response) {

		try {
			String[] params = request.getParameter("op").split(",");
			Cookie[] dd1 = request.getCookies();
			PrintWriter out = response.getWriter();

			if (CookieUtils.ifCookies(request)) {
				String user = "";
				for (Cookie cookie : dd1) {
					if (cookie.getName().equals("userName")) {
						user = cookie.getValue();
						continue;
					}
				}
				model.addAttribute("user", user);
				Praise pe = praiseDao.queryonetomeny(params[1], params[2]);
				if (null == pe) {
					Praise pes = new Praise();

					pes.setBlogId(params[1]);
					pes.setUserId(params[2]);
					pes.setCreateDate(CommonUtils.getNowDate());
					pes.setUpdateDate(CommonUtils.getNowDate());
					pes.setPraiseId(CommonUtils.getUUID());
					pes.setPraisestatus(1);
					praiseDao.createZan(pes);
				} else {
					pe.setUpdateDate(CommonUtils.getNowDate());
					int status = 0;
					if (pe.getPraisestatus() == 1) {
						status = 0;
					} else {
						status = 1;
					}

					pe.setPraisestatus(status);
					praiseDao.updatePraise(pe);
				}

				pe = praiseDao.selectNum(params[1]);
				out.println(pe.getCountZan());
			} else {
				out.println(-1);
			}
			out.flush();
			out.close();

		} catch (UnisException e) {
			LOGGER.error("异常信息", e);
		} catch (Exception e) {
			LOGGER.error("异常信息", e);
		}
	}

	/**
	 * {搜索}
	 * 
	 * @author zhanmeihe
	 * @param request
	 * @param s
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView searchKeyword(HttpServletRequest request, Model model,
			@RequestParam(value = "s", required = true) String s,
			@RequestParam(value = "page", required = false) int page,RedirectAttributes attributes, HttpServletResponse response) {
		try {
			int maxResult = 10;
			System.err.println("搜索关键字："+s);
			List<BlogInfo> bf = blogInfoDao.searchList(s, 0, maxResult);
			List<BlogInfo> bif = new ArrayList<>();
			if (bf.size()==0) {
				attributes.addAttribute("tip","没有结果");
				model.addAttribute("nextpage", 0);
				model.addAttribute("key", s);
				model.addAttribute("bloglist", bif);
				return new ModelAndView("blog/blog");
			}
			for (BlogInfo blogInfo : bf) {
				//String v = "/home/blogfile/uplaod/file/2019050110/";
				//blogInfo.setBlogContent(FileReaderUtils.readFile(v+blogInfo.getBlogContent().substring(blogInfo.getBlogContent().lastIndexOf("/")+1)));
				blogInfo.setBlogContent(FileReaderUtils.readFile(blogInfo.getBlogContent()));
				if (blogInfo.getImageUrl() == null || blogInfo.getImageUrl().equals("")) {
					blogInfo.setImageUrl(PerimageUtils.getImgStr(blogInfo.getBlogContent()));
				}

				if (blogInfo.getBlogContent().length() > 150) {
					new PeanUtils();
					String subcontent = PeanUtils.delHTMLTag(blogInfo.getBlogContent());
					if (!subcontent.equals("")&&subcontent.length()>=150) {
						subcontent = subcontent.substring(0, 150);
						blogInfo.setBlogContent(subcontent + "...");
					} else {
						blogInfo.setBlogContent(subcontent);
					}
					System.err.println(subcontent);

					bif.add(blogInfo);
				} else {
					new PeanUtils();
					String subcontent = PeanUtils.delHTMLTag(blogInfo.getBlogContent());
					blogInfo.setBlogContent(subcontent);
					bif.add(blogInfo);
				}
			}
			model.addAttribute("nextpage", 0);
			model.addAttribute("key", s);
			model.addAttribute("bloglist", bif);
			return new ModelAndView("blog/blog");
		} catch (UnisException e) {
			LOGGER.error("异常信息", e);
			attributes.addAttribute("errorMsg", e.getMessage());
			System.err.println(e.getMessage());
			return new ModelAndView("redirect:/index.SHTML");
		} catch (Exception e) {
			LOGGER.debug("异常信息{debug}", e);
			System.err.println(e.getMessage());
			attributes.addAttribute("errorMsg", e.getMessage());
			return new ModelAndView("redirect:/index.SHTML");
		}
	}

	/**
	 * @author zhanmeihe 获取验证码
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/Checkimage", method = RequestMethod.GET)
	public ModelAndView getKaptchaImage(HttpServletRequest request, HttpServletResponse response) throws Exception {

		BufferedImage bfi = new BufferedImage(80, 25, BufferedImage.TYPE_INT_RGB);
		Graphics g = bfi.getGraphics();
		g.fillRect(0, 0, 80, 25);
		HttpSession session = request.getSession(); // 保存到session
		session.setAttribute("verificationCode", CheckCode.getCode(bfi, g).toString());
		ImageIO.write(bfi, "JPG", response.getOutputStream()); // 写到输出流
		try {
			response.getOutputStream().flush();
		} finally {
			response.getOutputStream().close();
		}
		return null;
	}

	/**
	 * 退出登录
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/logOnTransit")
	public void logOnTransit(HttpServletRequest request, HttpSession session, HttpServletResponse response)
			throws Exception {
		CookieTool.addCookie(response, "userName", null, 0); // 清除Cookie
		CookieTool.addCookie(response, "passWord", null, 0); // 清除Cookie
		CookieTool.addCookie(response, "userid", null, 0);

		// 清空session
		session.invalidate();
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
				+ "/";
		// String finalPath = basePath + "sign_login";
		String finalPath = basePath;
		System.out.println("登出：" + finalPath);
		response.sendRedirect(finalPath);

	}

	@RequestMapping(value = "/editw", method = RequestMethod.GET)
	public ModelAndView writerWord(HttpServletRequest request, HttpServletResponse response, Model model) {

		try {
			Cookie[] dd1 = request.getCookies();
			if (dd1 == null) {
				model.addAttribute("user", "");
				return new ModelAndView("blog/editWord");
			}
			if (dd1.length > 2) {

				for (int i = 0; i < dd1.length; i++) {
					if (dd1[i].getName().equals("userName")) {
						System.out.println("cookie值：" + "#" + dd1[i].getValue() + "#");
						model.addAttribute("user", dd1[i].getValue());
					}
				}
			}

			return new ModelAndView("blog/editWord");

		} catch (UnisException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ModelAndView("redirect:/sign_login");
	}

	@RequestMapping(value = "/u/{userId}", method = RequestMethod.GET, produces = "application/json")
	public ModelAndView loginSuccess(@PathVariable("userId") String userIds, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		try {
			List<BlogInfo> lis = new ArrayList<>();
			BlogUser bu = new BlogUser();
			BlogUser bu1 = new BlogUser();
			Map<String, ?> map = RequestContextUtils.getInputFlashMap(request);
			if (map == null) {
				Cookie[] dd1 = request.getCookies();
				if (dd1 != null) {
					for (int i = 0; i < dd1.length; i++) {

						System.out.println("cookie*****--" + dd1[i].getName() + ":" + dd1[i].getValue());
						if (dd1[i].getName().equals("userName") && !dd1[i].getValue().equals("")) {

							// 解密后的username
							String userName = MD5Utils.getFromBASE64(dd1[i].getValue());
							bu = blogUserDao.queryUserName(userName);

						}
						if (dd1[i].getName().equals("userid") && !dd1[i].getValue().equals("")) {
							// 解密后的userId
							String userId = MD5Utils.getFromBASE64(dd1[i].getValue());
							lis = blogInfoDao.selectallData(userId,0);
						}
					}
					// if (lis.size()<1&&bu.getUserId()==null) {
					// model.addAttribute("errorMsg", "请重新登录");
					// return new ModelAndView("redirect:/sign_login");
					// }
				}
				if (userIds.length() > 1 && userIds.lastIndexOf("_") != -1) {

					userIds = userIds.substring(0, userIds.indexOf("_"));
					bu1 = blogUserDao.queryUser(userIds);
					if (bu1.getNickName() == null || bu1.getNickName().equals("")) {
						return new ModelAndView("blog/errorpage");
					}
					lis = blogInfoDao.selectallData(userIds,0);
					List<BlogInfo> blist = new ArrayList<>();
					for (BlogInfo blogInfo : lis) {
						//String v = "/home/blogfile/uplaod/file/2019042815/";
						//blogInfo.setBlogContent(FileReaderUtils.readFile(v+blogInfo.getBlogContent().substring(blogInfo.getBlogContent().lastIndexOf("/")+1)));
						blogInfo.setBlogContent(FileReaderUtils.readFile(blogInfo.getBlogContent()));
						blist.add(blogInfo);
					}
					lis = blist;
				}

				else {
					// model.addAttribute("errorMsg", "请重新登录");
					//return new ModelAndView("redirect:/sign_login");
					model.addAttribute("errormsg", "找不到该用户！");
					return new ModelAndView("errorpage/error");
					
				}

			} else {

				List li = new MaptoListUtils().mapTransitionList(map);
				for (int i = 0; i < li.size(); i++) {
					System.out.println(li.get(i).getClass().toString());
					if (li.get(i).getClass().toString().equals("class java.util.ArrayList")) {
						lis = (List<BlogInfo>) li.get(i);
					}
					if (li.get(i).getClass().toString().equals("class com.service.TestCollect.pojo.BlogUser")) {
						bu1 = (BlogUser) li.get(i);
					}
				}
				List<BlogInfo> blist = new ArrayList<>();
				for (BlogInfo blogInfo : lis) {
					//String v = "/home/blogfile/uplaod/file/2019042815/";
					//blogInfo.setBlogContent(FileReaderUtils.readFile(v+blogInfo.getBlogContent().substring(blogInfo.getBlogContent().lastIndexOf("/")+1)));
					blogInfo.setBlogContent(FileReaderUtils.readFile(blogInfo.getBlogContent()));
					blist.add(blogInfo);
				}
				lis = blist;
			}

			model.addAttribute("blogdatalist", lis);
			if (map == null) {
				int num = 0;
				for (int i = 0; i < lis.size(); i++) {
					num += new ChinesepreNum().chineseCount(lis.get(i).getBlogContent());
				}
				model.addAttribute("textnum", num);
				model.addAttribute("articlenum", lis.size());
			} else {
				model.addAttribute("textnum", map.get("textnum").toString());
				model.addAttribute("articlenum", map.get("articlenum").toString());
			}
			List<BlogInfo> blist = new ArrayList<>();
			for (BlogInfo blogInfo : lis) {
				// blogInfo.setBlogContent(FileReaderUtils.readFile(blogInfo.getBlogContent()));
				if (blogInfo.getBlogContent().length() >= 150) {
					String content = PeanUtils.delHTMLTag(blogInfo.getBlogContent());
					if (!content.equals("") && content.length() >= 150) {
						content = content.substring(0, 150);
						blogInfo.setBlogContent(content + "...");
					} else {
						blogInfo.setBlogContent(content);
					}
					blogInfo.setBlogContent(content);
					blist.add(blogInfo);
				} else {
					String content = PeanUtils.delHTMLTag(blogInfo.getBlogContent());
					blogInfo.setBlogContent(content);
					blist.add(blogInfo);
				}

			}
			if (bu1.getUserId() == null) {
				return new ModelAndView("blog/errorpage");
			}
			model.addAttribute("blogdatalist", blist);
			model.addAttribute("bloguser", bu);
			model.addAttribute("bloguser2", bu1);
			model.addAttribute("nextPage", 0);
			model.addAttribute("userId", userIds);
			return new ModelAndView("blog/medetail");
		} catch (UnisException e) {
			model.addAttribute("errorMsg", "登录错误，请重新登录");
			return new ModelAndView("redirect:/sign_login");
		} catch (Exception e) {
			model.addAttribute("errorMsg", "登录错误，请重新登录");
			return new ModelAndView("redirect:/sign_login");
		}
	}
	
	@RequestMapping(value = "/blog/page/{nextPage}/{userId}",method = RequestMethod.GET)
	public ModelAndView pageData(@PathVariable("nextPage") int nextPage,
			@PathVariable("userId") String userIds,HttpServletRequest request,
			HttpServletResponse response, Model model) {
		try {
			nextPage = nextPage + 1;
			nextPage = nextPage*10;
			System.out.println("当前页码："+nextPage);
			List<BlogInfo> lis = new ArrayList<>();
			BlogUser bu = new BlogUser();
			BlogUser bu1 = new BlogUser();
			Map<String, ?> map = RequestContextUtils.getInputFlashMap(request);
			if (map == null) {
				Cookie[] dd1 = request.getCookies();
				if (dd1 != null) {
					for (int i = 0; i < dd1.length; i++) {

						System.out.println("cookie*****--" + dd1[i].getName() + ":" + dd1[i].getValue());
						if (dd1[i].getName().equals("userName") && !dd1[i].getValue().equals("")) {

							// 解密后的username
							String userName = MD5Utils.getFromBASE64(dd1[i].getValue());
							bu = blogUserDao.queryUserName(userName);

						}
						if (dd1[i].getName().equals("userid") && !dd1[i].getValue().equals("")) {
							// 解密后的userId
							String userId = MD5Utils.getFromBASE64(dd1[i].getValue());
							lis = blogInfoDao.selectallData(userId,nextPage);
						}
					}
				}
				if (userIds.length() > 1 && userIds.lastIndexOf("_") != -1) {

					userIds = userIds.substring(0, userIds.indexOf("_"));
					bu1 = blogUserDao.queryUser(userIds);
					if (bu1.getNickName() == null || bu1.getNickName().equals("")) {
						return new ModelAndView("blog/errorpage");
					}
					lis = blogInfoDao.selectallData(userIds,nextPage);
					List<BlogInfo> blist = new ArrayList<>();
					for (BlogInfo blogInfo : lis) {
						//String v = "/home/blogfile/uplaod/file/2019042815/";
						//blogInfo.setBlogContent(FileReaderUtils.readFile(v+blogInfo.getBlogContent().substring(blogInfo.getBlogContent().lastIndexOf("/")+1)));
						blogInfo.setBlogContent(FileReaderUtils.readFile(blogInfo.getBlogContent()));
						blist.add(blogInfo);
					}
					lis = blist;
				}

				else {
					// model.addAttribute("errorMsg", "请重新登录");
					model.addAttribute("errormsg", "找不到该用户！");
					return new ModelAndView("errorpage/error");
				}

			} else {

				List li = new MaptoListUtils().mapTransitionList(map);
				for (int i = 0; i < li.size(); i++) {
					System.out.println(li.get(i).getClass().toString());
					if (li.get(i).getClass().toString().equals("class java.util.ArrayList")) {
						lis = (List<BlogInfo>) li.get(i);
					}
					if (li.get(i).getClass().toString().equals("class com.service.TestCollect.pojo.BlogUser")) {
						bu1 = (BlogUser) li.get(i);
					}
				}
				List<BlogInfo> blist = new ArrayList<>();
				for (BlogInfo blogInfo : lis) {
					//String v = "/home/blogfile/uplaod/file/2019042815/";
					//blogInfo.setBlogContent(FileReaderUtils.readFile(v+blogInfo.getBlogContent().substring(blogInfo.getBlogContent().lastIndexOf("/")+1)));
					blogInfo.setBlogContent(FileReaderUtils.readFile(blogInfo.getBlogContent()));
					blist.add(blogInfo);
				}
				lis = blist;
			}

			model.addAttribute("blogdatalist", lis);
			if (map == null) {
				int num = 0;
				for (int i = 0; i < lis.size(); i++) {
					 					
					num += new ChinesepreNum().chineseCount(lis.get(i).getBlogContent());
				}
				model.addAttribute("textnum", num);
				model.addAttribute("articlenum", lis.size());
			} else {
				model.addAttribute("textnum", map.get("textnum").toString());
				model.addAttribute("articlenum", map.get("articlenum").toString());
			}
			List<BlogInfo> blist = new ArrayList<>();
			for (BlogInfo blogInfo : lis) {
				 
				if (blogInfo.getBlogContent().length() >= 150) {
					String content = PeanUtils.delHTMLTag(blogInfo.getBlogContent());
					if (!content.equals("") && content.length() >= 150) {
						content = content.substring(0, 150);
						blogInfo.setBlogContent(content + "...");
					} else {
						blogInfo.setBlogContent(content);
					}
					blogInfo.setBlogContent(content);
					blist.add(blogInfo);
				} else {
					String content = PeanUtils.delHTMLTag(blogInfo.getBlogContent());
					blogInfo.setBlogContent(content);
					blist.add(blogInfo);
				}

			}
			if (bu1.getUserId() == null) {
				return new ModelAndView("blog/errorpage");
			}
			model.addAttribute("userId", userIds);
			model.addAttribute("nextPage", nextPage/10);
			model.addAttribute("blogdatalist", blist);
			model.addAttribute("bloguser", bu);
			model.addAttribute("bloguser2", bu1);
			//model.addAttribute("nextPage", nextPage);
			return new ModelAndView("blog/medetail");
		} catch (UnisException e) {
			model.addAttribute("errorMsg", "登录错误，请重新登录");
			//return new ModelAndView("redirect:/sign_login");
		} catch (Exception e) {
			model.addAttribute("errorMsg", "登录错误，请重新登录");
			//return new ModelAndView("redirect:/sign_login");
		}
		return new ModelAndView("blog/errorpage");
	}

	@RequestMapping(value = "/blogText", method = RequestMethod.POST)
	public String gettext(HttpServletRequest request, HttpServletResponse response, Model model) {
		try {

			String userId = request.getParameter("userid");
			BlogInfo maxid = blogInfoDao.querymaxid();
			int blogId = 0;
			if (null == maxid) {
				blogId = 100;
			} else {
				blogId = maxid.getMaxBlogId() + 1;
			}
			String title = request.getParameter("title");

			BlogUser bu = blogUserDao.queryUser(userId);
			BlogInfo bf = new BlogInfo();
			String text = request.getParameter("editorValue");

			long a = text.length();
			System.err.println(a);
			if (text == null || text.equals("null")) {
				text = "";
			}
			if (title.equals("") || text.equals("")) {
				model.addAttribute("error", "标题和内容不能为空");
				return "redirect:/editw";
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
			String FileName = sdf.format(new Date());
			String localPath = Const.ON_UPLOADFILE_PATH + FileName + "/" + String.valueOf(blogId) + ".txt";
			FileReaderUtils.write(localPath, text, "utf-8");
			bf.setBlogContent(localPath);
			bf.setAuthor(bu.getNickName());
			bf.setBlogId(String.valueOf(blogId));
			bf.setUserId(userId);
			bf.setComments("");
			bf.setCommentsNum(0);
			bf.setCreateblogDate(CommonUtils.getNowDate());
			bf.setUpdateDate(CommonUtils.getNowDate());
			bf.setImageUrl("");
			bf.setPraiseCount(0);
			bf.setTitle(title);
			blogInfoDao.create(bf);

			return "redirect:/u/" + userId + "_";

		} catch (UnisException e) {
			LOGGER.info("异常", e);
			model.addAttribute("errorMsg", e);
			return "redirect:/sign_login";
		} catch (Exception e) {
			LOGGER.info("异常", e);
			model.addAttribute("errorMsg", e);
			return "redirect:/sign_login";
		}
	}

	@RequestMapping(value = "/common/showImage")
	public void showIcons(@RequestParam(required = true) String fileName, HttpServletResponse response,
			HttpServletRequest request) {
		try {
			validate(fileName);
			String filePath = Const.URL_BLOG_FILE_UPLOAD + fileName;
			request.setAttribute("decorator", "none");
			setResponse(fileName, response);
			responseOutputFile(response, filePath, "default_icon.png");
		} catch (Exception e) {
			responseError(response, e.getMessage());
		}
	}

	/**
	 * 评论发表
	 * 
	 * @author zhanmeihe
	 * @param pinglun
	 * @param bolgId
	 * @param userId
	 * @param response
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/writepl", method = RequestMethod.POST, produces = "application/json")
	public CommonResponse WriteComments(@RequestParam(value = "pinglun") String pinglun,
			@RequestParam(value = "bolgId") String bolgId, @RequestParam(value = "userId") String userId,
			HttpServletResponse response, HttpServletRequest request) {
		try {

			// List<BlogInfo> b = blogInfoDao.indexquery(0, 10);
			Comment ct = new Comment();
			ct.setBlogId(bolgId);
			ct.setCommentContent(pinglun);
			ct.setCommentId(CommonUtils.getUUID());
			ct.setCreateDate(CommonUtils.getNowDate());
			ct.setUpdateDate(CommonUtils.getNowDate());
			ct.setUserId(userId);
			ct.setZanNum(0);
			commentDao.createComments(ct);
			List<Comment> ctc = commentDao.queryCommentAll(Integer.parseInt("0"), Integer.parseInt("10"), bolgId);
			return new CommonSuccessResponse(ctc);
		} catch (UnisException e) {
			LOGGER.debug("2", e);
			return new CommonResponse(e.getCode(), e.getMessage());
		} catch (Exception e) {
			LOGGER.debug("3", e);
			return new SystemErrorResponse();
		}
	}

	/**
	 * 初始化加载评论列表
	 * 
	 * @author zhanmeihe
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/INITDATA", method = RequestMethod.GET, produces = "application/json")
	public CommonResponse initComments(HttpServletResponse response, HttpServletRequest request) {

		try {
			String firstResult = request.getParameter("pagenum");
			String page = request.getParameter("page");
			String blogid = request.getParameter("blogId");
			List<Comment> ct = commentDao.queryCommentAll(Integer.parseInt(page), Integer.parseInt(firstResult),
					blogid);
			return new CommonSuccessResponse(ct);

		} catch (UnisException e) {
			LOGGER.debug("2", e);
			return new CommonResponse(e.getCode(), e.getMessage());
		} catch (Exception e) {
			LOGGER.debug("3", e);
			return new SystemErrorResponse();
		}
	}

	/**
	 * -----------------{蚂蚁阿奇工程项目接口}-------------------------
	 */

	/**
	 * 注册提交信息content
	 */
	@RequestMapping(value = "/Userinfo/UserRegistr", method = RequestMethod.POST)
	public String Registr(@RequestParam(value = "UserName") String UserName,
			@RequestParam(value = "identity") String Sex, @RequestParam(value = "PhoneNum") String PhoneNum,
			@RequestParam(value = "IdcardNum") String IdcardNum, @RequestParam(value = "YearNum") String YearNum,
			@RequestParam(value = "WorkType") String WorkType, @RequestParam(value = "openId") String openId,
			@RequestParam(value = "headImgUrl") String headImgUrl, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		try {
			// model.addAttribute("phone", PhoneNum);
			// System.err.println(UserName);
			// System.err.println(Sex);
			// System.err.println(PhoneNum);
			// System.err.println(IdcardNum);
			// System.err.println(YearNum);
			// System.err.println(WorkType);

			UserInfo user = new UserInfo();
			user.setUserName(UserName);
			user.setSex(String.valueOf(Sex));
			user.setPhoneNum(PhoneNum);
			user.setIdcardNum(IdcardNum);
			user.setYearNum(YearNum);
			user.setWorkType(WorkType);
			user.setOpenid(openId);
			user.setPicImage(headImgUrl);
			user.setCreatetime(CommonUtils.getNowDate());
			model.addAttribute("info", user);
			model.addAttribute("idcardNum", user.getIdcardNum());
			return "ant/idcard";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "ant/index";
	}

	/**
	 * 注册页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/Userinfo/IndexRe.shtml", method = RequestMethod.GET)
	public String IndexReg(HttpServletRequest request, HttpServletResponse response, Model model, Configure conf) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			// 用户同意授权后，能获取到code
			String code = request.getParameter("code");
			String state = request.getParameter("state");
			String ss = "123";
			// // 用户同意授权
			if (!"authdeny".equals(code)) {
				// // 获取网页授权access_token
				WeixinOauth2Token weixinOauth2Token = AdvancedUtil.getOauth2AccessToken(conf.getproperties("appid"),
						conf.getproperties("secrn"), code);
				// 网页授权接口访问凭证
				String accessToken = weixinOauth2Token.getAccessToken();
				// 用户标识
				String openId = weixinOauth2Token.getOpenId();
				// 获取用户信息
				SNSUserInfo snsUserInfo = AdvancedUtil.getSNSUserInfo(accessToken, openId);
				// 设置要传递的参数
				request.setAttribute("snsUserInfo", snsUserInfo);
				request.setAttribute("state", state);
				String openid = snsUserInfo.getOpenId();
				UserInfo info = new UserInfo();
				info = userInfoDao.queryId(snsUserInfo.getOpenId(), null);
				HttpSession session = request.getSession();
				// userInfoDao.queryId("a78bef1e17804fa68c412b6fcb39385e");
				if (info != null) {

					// request.getSession().setAttribute("name",info.getOpenid());
					model.addAttribute("user", info);
					model.addAttribute("idcardNum", info.getIdcardNum());
					session.setAttribute("userInfo", info);
					return "ant/personal-center";
				} else {
					model.addAttribute("snsUserInfo", snsUserInfo);
					return "ant/personal";
					/**
					 * 保留页面
					 */
					// return "ant/index";
				}
			}
			// return "ant/personal";
			// return "ant/info";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "ant/fail";
	}

	/**
	 * 注册页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/Userinfo/testlocal.shtml/{userId}", method = RequestMethod.GET)
	public String Test(@PathVariable("userId") String userId, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, Model model, Configure conf) {
		try {
			// 59320f39375c463b8b08d1095d5027c1
			String ss = "123";
			if (!"authdeny".equals(ss)) {

				UserInfo dd = userInfoDao.MaxId();
				System.out.println(dd.getPersonNum());
				UserInfo info = new UserInfo();
				info = userInfoDao.queryId(null, userId);
				if (info != null) {
					model.addAttribute("user", info);
					HttpSession httpSession = request.getSession();
					httpSession.setAttribute("username", "张三");
					model.addAttribute("idcardNum", info.getIdcardNum());
					return "ant/personal-center";
				} else {
					model.addAttribute("snsUserInfo", null);
					return "ant/personal";
				}
			}
		} catch (UnisException e) {
			System.err.println(e);
		} catch (Exception e) {
			System.err.println(e);
		}
		return "ant/fail";
	}

	/**
	 * 上传身份证页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/MapAddress/GpsAddress.shtml/{AddressName}", method = RequestMethod.GET)
	public String IndexIdcArd(@PathVariable("AddressName") String AddressName, Model model, HttpSession session) {
		try {

			model.addAttribute("Addressinfo", AddressName);
			return "ant/map";
		} catch (UnisException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "ant/fail";
	}

	/**
	 * 跳转抢单{list}页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/Userinfo/orderlist.shtml/{userId}", method = RequestMethod.GET)
	public String OrderList(@PathVariable("userId") String userId, HttpServletRequest request,
			HttpServletResponse response, Model model, HttpSession session) {
		try {
			HttpSession httpSession = request.getSession();
			// httpSession.setMaxInactiveInterval(60);
			if (httpSession.getAttribute("username") != null) {
				System.err.println("有session的，session userId等于" + httpSession.getAttribute("username"));
				model.addAttribute("username", httpSession.getAttribute("username"));
			} else {
				System.err.println("没有获取到session");
			}
			if (userId != null) {
				List<TaskInfo> info = taskInfoDao.selectInfo();
				model.addAttribute("task", info);
				if (info.size() <= 0) {
					model.addAttribute("skin", info.size());
				}
				model.addAttribute("userId", userId);
				return "ant/order-list";
			}
			return "ant/index";

		} catch (Exception e) {
			// TODO: handle exception
		}
		return "ant/fail";
	}

	/**
	 * 施工页面数据展示
	 */

	@RequestMapping(value = "/working/orderwork.shtml/{userId}", method = RequestMethod.GET)
	public String WorkingList(@PathVariable("userId") String userId, HttpServletRequest request,
			HttpServletResponse response, Model model) {

		try {
			if (userId != null) {
				List<MyorderInfo> order = myorderInfoDao.queryOrder(userId);
				// if (order == null) {
				// UserInfo info = userInfoDao.queryId(null, userId);
				// model.addAttribute("idcardNum", info.getIdcardNum());
				// model.addAttribute("user", info);
				// return "ant/personal-center";
				// }
				model.addAttribute("orderinfo", order);
				model.addAttribute("skin", order.size());
				if (order.size() > 0) {
					model.addAttribute("userId", order.get(0).getUserId());
				}

				return "ant/working";
			} else {
				return "ant/index";
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return "ant/fail";

	}

	/**
	 * 跳转个人中心
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/Userinfo/PersonalCenter.shtml/{userId}", method = RequestMethod.GET)
	public String PersonalCenter(@PathVariable("userId") String userId, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		try {
			if (userId != null) {
				UserInfo info = userInfoDao.queryId(null, userId);
				model.addAttribute("user", info);
				model.addAttribute("idcardNum", info.getIdcardNum());
				return "ant/personal-center";
			} else {
				return "ant/index";
			}
		} catch (UnisException e) {
			LOGGER.info("异常", e);
			return "ant/index";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "ant/index";
	}

	/**
	 * 跳转个人订单详情
	 * 
	 * @return
	 */
	@RequestMapping(value = "/Userinfo/ListDetails.shtml/{id}/{userId}", method = RequestMethod.GET)
	public String PersonListDetails(@PathVariable("id") String id, @PathVariable("userId") String userId, Model model) {
		try {
			if (id != null && userId != null) {
				MyorderInfo orderinfo = myorderInfoDao.selectOrderInfo(id);
				model.addAttribute("info", orderinfo);
				return "ant/my-order-list-details";
			}
			return "ant/index";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "ant/index";
	}

	/**
	 * 跳转抢单订单详情
	 * 
	 * @return
	 */
	@RequestMapping(value = "/Userinfo/ListDetailsOrder.shtml/{id}/{userId}", method = RequestMethod.GET)
	public String ListDetails(@PathVariable("id") String id, @PathVariable("userId") String userId, Model model) {
		try {
			if (id != null && userId != null) {
				TaskInfo task = taskInfoDao.findId(id);
				model.addAttribute("info", task);
				model.addAttribute("userId", userId);
				return "ant/order-list-details";
			}
			return "ant/index";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "ant/index";
	}

	/**
	 * 抢单请求{action---}
	 * 
	 * @return
	 */

	@RequestMapping(value = "/orderInfo/GrabSingle.shtml", method = RequestMethod.POST)
	public String GrabSingle(HttpServletResponse response, HttpServletRequest request, Model model) {

		String taskid = request.getParameter("taskId");
		String userId = request.getParameter("userId");
		try {
			if (taskid != null && userId != null) {
				TaskInfo task = taskInfoDao.findId(taskid);
				UserInfo user = userInfoDao.queryId(null, userId);
				String[] userList = user.getWorkType().split(",");
				String[] list = task.getListIng().split(",");
				Arrays.sort(userList);
				Arrays.sort(list);
				if (Arrays.equals(userList, list)) {

					TaskInfo taskup = new TaskInfo();
					taskup.setOrderState(1);
					taskup.setId(taskid);
					taskup.setUpdateDate(CommonUtils.getNowDate());
					taskInfoDao.updateTaskInfo(taskup);
					MyorderInfo order = new MyorderInfo();

					order.setCreateTime(CommonUtils.getNowDate());
					order.setTaskId(taskid);
					order.setUserId(userId);
					order.setListIng(task.getListIng());
					order.setProductionNum(task.getProductionNum());
					order.setSalaryNum(task.getSalaryNum());
					order.setState(2);
					order.setTaskAddress(task.getTaskAddress());
					order.setTaskDate(task.getTaskDate());
					order.setTaskInstruction(task.getTaskInstruction());
					order.setUpdateDate(CommonUtils.getNowDate());
					myorderInfoDao.createTask(order);

					model.addAttribute("userId", userId);
					model.addAttribute("taskId", order.getTaskId());
					return "ant/successorders";
				} else {
					model.addAttribute("userId", userId);
					return "ant/fail";
				}

			} else {
				model.addAttribute("userId", userId);
				return "ant/index";
			}
		} catch (UnisException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("userId", userId);
		return "ant/fail";

	}

	@RequestMapping(value = "/Userinfo/testre.shtml", method = RequestMethod.GET)
	public String testre() {
		try {
			System.err.println("跳转页面！");
			return "ant/personal";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "ant/order-list";
	}

	/**
	 * 跳转修改个人信息页面
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/Userinfo/modifyInfo.shtml/{userId}", method = RequestMethod.GET)
	public String modifyInfo(@PathVariable("userId") String userId, Model model) {
		try {
			model.addAttribute("userId", userId);
			return "ant/modify-information";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "ant/index";
	}

	@RequestMapping(value = "/Userinfo/orderlists.shtml/{userId}", method = RequestMethod.GET)
	public String MeOrderLists(@PathVariable("userId") String userId, Model model) {
		try {
			if (userId != null) {
				List<MyorderInfo> info = myorderInfoDao.queryOrder(userId);
				if (info.size() <= 0) {
					model.addAttribute("skin", info.size());
				}
				model.addAttribute("task", info);
				model.addAttribute("userId", userId);
				return "ant/my-order";
			} else {
				return "ant/index";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "ant/fail";
	}

	/**
	 * 上班打卡页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/workin/Clockin.shtml", method = RequestMethod.POST)
	public String Clockin(@RequestParam(value = "userId") String userId, @RequestParam(value = "taskId") String taskId,
			UserInfofileVo vo, Model model) throws Exception {
		try {
			WorkVideo info = new WorkVideo();
			info.setUserId(userId);
			info.setCreateDate(CommonUtils.getNowDate());
			info.setUpdatetime(CommonUtils.getNowDate());
			info.setTaskId(taskId);
			Video2Upload(info, vo);
			model.addAttribute("userId", userId);
			return "ant/index";
		} catch (UnisException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "ant/fail";
	}

	/**
	 * 跳转上班
	 * 
	 * @param userId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/Userinfo/workclock.shtml/{userId}/{taskId}", method = RequestMethod.GET)
	public String Details(@PathVariable("userId") String userId, @PathVariable("taskId") String taskId, Model model) {
		try {
			model.addAttribute("userId", userId);
			model.addAttribute("taskId", taskId);
			return "ant/details";
		} catch (UnisException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "ant/fail";
	}

	@RequestMapping(value = "/Userinfo/modifyUser.shtml", method = RequestMethod.POST)
	public String getmodifyinfo(@RequestParam(value = "UserName") String UserName,
			@RequestParam(value = "identity") String Sex, @RequestParam(value = "PhoneNum") String PhoneNum,
			@RequestParam(value = "YearNum") String YearNum, @RequestParam(value = "userId") String userId,
			Model model) {
		try {
			if (userId != null) {
				UserInfo info = new UserInfo();
				info.setUserName(UserName);
				info.setSex(Sex);
				info.setPhoneNum(PhoneNum);
				info.setYearNum(YearNum);
				info.setCreatetime(CommonUtils.getNowDate());
				info.setUserId(userId);
				userInfoDao.updateUserInfo(info);
				info = userInfoDao.queryId(null, userId);
				model.addAttribute("user", info);
				return "ant/personal-center";
			} else {
				return "ant/index";
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return "ant/index";
	}

	/**
	 * 上传身份证接收二进制文件流
	 * 
	 * @param vo
	 */
	@RequestMapping(value = "/Userinfo/ImageUpage.shtml", method = RequestMethod.POST)
	public String ImageUp(@RequestParam(value = "userName") String UserName, @RequestParam(value = "sex") String Sex,
			@RequestParam(value = "phoneNum") String PhoneNum, @RequestParam(value = "idcardNum") String IdcardNum,
			@RequestParam(value = "yearNum") String YearNum, @RequestParam(value = "workType") String WorkType,
			@RequestParam(value = "openid") String openid, @RequestParam(value = "picImage") String picImage,
			UserInfo vo, UserInfofileVo v1, Model model) {
		try {
			UserInfo in = userInfoDao.MaxId();
			vo.setUserId(CommonUtils.getUUID());
			vo.setUserName(UserName);
			vo.setSex(Sex);
			vo.setPersonNum(in.getPersonNum() + 1);
			vo.setPhoneNum(PhoneNum);
			vo.setIdcardNum(IdcardNum);
			vo.setYearNum(YearNum);
			vo.setWorkType(WorkType);
			vo.setOpenid(openid);
			vo.setPicImage(picImage);
			vo.setCreatetime(CommonUtils.getNowDate());
			vo.setUpdateDate(CommonUtils.getNowDate());
			if (v1.getHeadPic().get(0).getSize() < 10 || v1.getHeadPic().get(1).getSize() < 10
					|| v1.getHeadPic().get(2).getSize() < 10) {

				model.addAttribute("userId", vo.getUserId());
				userInfoDao.create(vo);
				model.addAttribute("info", in);
				return "ant/success";
			}
			// if (v1.getHeadPic().get(0).g) {
			//
			// }

			UserInfo info = ImageUpload(vo, v1);
			System.err.println("上传成功！");
			model.addAttribute("userId", vo.getUserId());
			model.addAttribute("info", info);
			return "ant/success";
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("上传失败！");
		}
		System.out.println("上传成功！");
		return "ant/index";
	}

	/**
	 * 上传施工上班视频
	 * 
	 * @param vo
	 */
	@RequestMapping(value = "/Userinfo/VideoValidation.shtml", method = RequestMethod.POST)
	public String VideoUpload(UserInfo vo, UserInfofileVo v1) {
		try {

			ImageUpload(vo, v1);
			System.err.println("上传成功！");
			return "redirect:/Userinfo/PersonalCenter.shtml";
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("上传失败！");
		}
		return "redirect:/Userinfo/PersonalCenter.shtml";
	}

	@RequestMapping(value = "/common/showIcon", method = RequestMethod.GET)
	public void showIcon(@RequestParam(required = true) String fileName, HttpServletResponse response,
			HttpServletRequest request) {
		try {
			// validate(fileName);
			String filePath = "/FILE/images/" + fileName;
			request.setAttribute("decorator", "none");
			setResponse(fileName, response);
			responseOutputFile(response, filePath, "default_icon.png");
		} catch (Exception e) {
			responseError(response, e.getMessage());
		}
	}

	// @RequestMapping(value = "/common/showFile")
	// public void showFile(@RequestParam(required = true) String fileName,
	// HttpServletResponse response,
	// HttpServletRequest request) {
	// try {
	// //validate(fileName);
	// String filePath = Const.MP3_FILE_URL + fileName;
	// request.setAttribute("decorator", "none");
	// setResponse(fileName, response);
	// responseOutputFile(response, filePath, "noFile.jpg");
	// } catch (Exception e) {
	// responseError(response, e.getMessage());
	// }
	// }

	private void responseOutputFile(HttpServletResponse response, String filePath, String defaultFileName) {
		BufferedInputStream bis = null;
		OutputStream outp = null;
		try {
			try {
				bis = new BufferedInputStream(new FileInputStream(filePath));
			} catch (Exception e) {
				bis = new BufferedInputStream(new FileInputStream(getNoFile(defaultFileName)));
			}
			outp = response.getOutputStream();
			byte[] b = new byte[1024];
			int length = 0;
			if (null != outp) {
				while ((length = bis.read(b)) != -1) {
					outp.write(b, 0, length);
				}
				outp.flush();
			}
		} catch (Throwable e) {
			LOGGER.debug("", e);
		} finally {
			IOUtils.closeQuietly(outp);
			IOUtils.closeQuietly(bis);
		}
	}

	private void setResponse(String chopName, HttpServletResponse response) {
		response.reset();
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		response.addHeader("Content-Disposition", "attachment;filename=" + chopName);
		response.setContentType("APPLICATION/OCTET-STREAM ");
	}

	private String getNoFile(String fileName) {
		String path = this.getClass().getClassLoader().getResource("/").getPath();
		path = StringUtils.replace(path, "\\", "/");
		path = StringUtils.replace(path, "/WEB-INF/classes/", "/style/imgs/");
		path = path + fileName;
		return path;
	}

	private void validate(String fileName) throws Exception {
		if (StringUtils.isBlank(fileName)) {
			throw new Exception("File name cannot be empty!");
		}
		Pattern pattern = Pattern.compile(RegexConst.PHOTO);
		Matcher matcher = pattern.matcher(fileName.toLowerCase());
		if (!matcher.matches()) {
			throw new Exception("File name error!");
		}
	}

	private void responseError(HttpServletResponse response, String message) {
		PrintWriter fs = null;
		try {
			response.setCharacterEncoding("UTF-8");
			fs = response.getWriter();
			fs.write("{\"code\":\"300\",\"msg\":\"" + message + "\"}");
			fs.flush();
		} catch (IOException e) {
			IOUtils.closeQuietly(fs);
		}

	}

	private UserInfo ImageUpload(UserInfo vo1, UserInfofileVo vo) throws Exception {

		String newFileName = null;

		List<String> image = new ArrayList<>();
		List<MultipartFile> file = vo.getHeadPic();
		for (MultipartFile multipartFile : file) {

			if (vo.getHeadPic() != null) {
				fileSizeOverrun(multipartFile);

				String originalFileName = multipartFile.getOriginalFilename();
				newFileName = CommonUtils.getUUID() + originalFileName.substring(originalFileName.lastIndexOf("."));
				File picFile = new File("/FILE/images/" + newFileName);

				try {
					multipartFile.transferTo(picFile);
				} catch (IllegalStateException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuleException("上传失败");
				}
				// write picFile http name into mysql database;
			}
			newFileName = "http://www.antarchi.com/common/showIcon?fileName=" + newFileName;
			// vo.setIconUrl(newFileName);
			image.add(newFileName);
			// UserInfo user = modifyHeadPic(vo);
			// userimInfoDao.updateimUserPic(user);

		}
		String dd = listToString(image, ',');
		System.err.println(dd);
		vo1.setCheckIdcardPicUrl(listToString(image, ','));

		userInfoDao.create(vo1);
		// for (int i = 0; i < vo.getCheckIdcardPicUrl().size(); i++) {
		//
		// System.err.println(vo.getCheckIdcardPicUrl().get(i));
		// }

		return vo1;

	}

	private WorkVideo Video2Upload(WorkVideo vo1, UserInfofileVo vo) throws Exception {

		String newFileName = null;
		try {
			List<String> image = new ArrayList<>();
			List<MultipartFile> file = vo.getHeadPic();
			for (MultipartFile multipartFile : file) {

				if (multipartFile != null && multipartFile.getSize() > 0) {
					fileSizeOverrun(multipartFile);

					String originalFileName = multipartFile.getOriginalFilename();
					newFileName = CommonUtils.getUUID() + originalFileName.substring(originalFileName.lastIndexOf("."));
					File picFile = new File("/FILE/images/" + newFileName);

					try {
						multipartFile.transferTo(picFile);
					} catch (IllegalStateException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						throw new RuleException("上传失败");
					}
					// write picFile http name into mysql database;
					newFileName = "http://www.antarchi.com/common/showIcon?fileName=" + newFileName;

					image.add(newFileName);
				}

			}
			String dd = listToString(image, ',');
			System.err.println(dd);
			vo1.setFileUrl(listToString(image, ','));

			workVideoDao.createVideo(vo1);
			// for (int i = 0; i < vo.getCheckIdcardPicUrl().size(); i++) {
			//
			// System.err.println(vo.getCheckIdcardPicUrl().get(i));
			// }

			return vo1;

		} catch (UnisException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	public String listToString(@SuppressWarnings("rawtypes") List list, char separator) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append(separator);
		}
		return sb.toString().substring(0, sb.toString().length() - 1);
	}

	private void fileSizeOverrun(MultipartFile file) throws Exception {
		if (file != null && file.getSize() > (10 * 1024 * 1024)) {
			throw new Exception("大小超过10M");
		}
	}

	public void saveNeteaseVideo(String portal) throws InterruptedException {
		String porType = null;
		String[] url = portal.split(" ");
		porType = url[1];
		System.err.println("抓取视频类型：" + porType);
		if (porType.equals("BoBo")) {

			for (int i = 0; i < 11; i++) {
				String ui = url[0].substring(0, url[0].lastIndexOf("/")) + "/" + i + "-10.html";
				String source = Tools.getSource(ui, "utf-8");
				JSONObject obo = JSONObject.fromObject(source);
				JSONArray array = JSONArray.fromObject(obo.get("VBK3JKUIF"));
				for (int j = 0; j < array.size(); j++) {
					Video ns = new Video();
					ns.setAppId("16");
					ns.setProgType(porType);
					System.out.println("图片：" + JSONObject.fromObject(array.get(j)).get("cover").toString());
					System.out.println("时长：" + JSONObject.fromObject(array.get(j)).get("length").toString());
					String length = JSONObject.fromObject(array.get(j)).get("length").toString();
					int a = Integer.parseInt(length) / 60;
					int b = Integer.parseInt(length) % 60;
					String a1 = String.valueOf(a);
					String b1 = String.valueOf(b);
					String time = a1 + ":" + b1;
					ns.setTimeLength(time);
					ns.setImageUrl(JSONObject.fromObject(array.get(j)).get("cover").toString());
					ns.setProgid(JSONObject.fromObject(array.get(j)).get("vid").toString());
					ns.setPublishDate(JSONObject.fromObject(array.get(j)).get("ptime").toString());
					ns.setName(JSONObject.fromObject(array.get(j)).get("title").toString());
					ns.setSysDate(CommonUtils.getNowDate());
					System.out.println("详细地址：" + "http://3g.163.com/v/video/"
							+ JSONObject.fromObject(array.get(j)).get("vid").toString() + ".html");
					ns.setUrl("http://3g.163.com/v/video/" + JSONObject.fromObject(array.get(j)).get("vid").toString()
							+ ".html");
					String vid = JSONObject.fromObject(array.get(j)).get("vid").toString();
					System.out.println("标题：" + JSONObject.fromObject(array.get(j)).get("title").toString());
					System.out.println("说明：" + JSONObject.fromObject(array.get(j)).get("description").toString());
					System.out.println("播放地址：" + JSONObject.fromObject(array.get(j)).get("mp4_url").toString());
					System.out.println("主键id：" + JSONObject.fromObject(array.get(j)).get("vid").toString());
					System.out.println("发布时间：" + JSONObject.fromObject(array.get(j)).get("ptime").toString());
					ns.setDescription(JSONObject.fromObject(array.get(j)).get("description").toString());
					ns.setArea("");
					ns.setVideoPath(JSONObject.fromObject(array.get(j)).get("mp4_url").toString());
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

			String vid = Tools.source(url[0], "GBK").replace("callback_video(", "").replace(")", "");

			System.err.println("点播视频vid" + vid);

			try {
				JSONObject ob = JSONObject.fromObject(vid);
				JSONArray array = JSONArray.fromObject(ob.get("list"));
				for (int i = 0; i < array.size(); i++) {
					Video ns = new Video();
					ns.setAppId("");
					ns.setProgType(porType);
					ns.setSysDate(CommonUtils.getNowDate());
					String title = JSONObject.fromObject(array.get(i)).get("title").toString();
					ns.setName(title);
					System.out.println("标题 ====" + title);
					String weburl = JSONObject.fromObject(array.get(i)).get("url").toString();
					ns.setUrl(weburl);
					System.out.println("网址 ====" + weburl);
					String imgurl = JSONObject.fromObject(array.get(i)).get("img").toString();
					System.out.println("时长 ====" + JSONObject.fromObject(array.get(i)).get("playlength").toString());
					String length = JSONObject.fromObject(array.get(i)).get("playlength").toString();
					int aa = Integer.parseInt(length) / 60;
					int bb = Integer.parseInt(length) % 60;
					String a1 = String.valueOf(aa);
					String b1 = String.valueOf(bb);
					String time = a1 + ":" + b1;
					ns.setTimeLength(time);
					ns.setImageUrl(imgurl);
					System.out.println("图片 ====" + imgurl);
					String vid2 = JSONObject.fromObject(array.get(i)).get("vid").toString();
					ns.setProgid(vid2);

					String comment = JSONObject.fromObject(array.get(i)).get("comment").toString();
					if (comment.equals("{}")) {
						System.out.println("空的");
						// JSONArray comment = JSONArray.fromObject();
						ns.setPublishDate("");

					} else {

						JSONObject JO = JSONObject.fromObject(comment);
						String date = JO.getString("createTime");
						System.out.println("创建时间++++" + JO.getString("createTime"));
						ns.setPublishDate(date);
					}
					ns.setDescription(title);
					ns.setArea("");

					String a = vid2.substring(vid2.length() - 2, vid2.length() - 1);
					String b = vid2.substring(vid2.length() - 1);
					String xml = "http://xml.ws.126.net/video/" + a + "/" + b + "/1000_" + vid2 + ".xml";
					System.out.println(xml);
					String data = Tools.getSource(xml, "GBK");
					Matcher m = Pattern.compile("<flv>([^<]+)</flv>").matcher(data);
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

	@Override
	public void run() {
		List<String> lines = PropertiesFactory.loadAllWebs();
		for (String line : lines) {
			List<String> portals = PropertiesFactory.loadPortalsByWeb(line);
			for (String portal : portals) {
				try {
					saveNeteaseVideo(portal);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public void tets() {

		// UserInfo info =
		// userInfoDao.queryId("a78bef1e17804fa68c412b6fcb39385e");
		// System.err.println(info.getAddress());
	}

	public static void main(String[] args) {
		String[] aa = { "搜索", "得到", "恩恩" };
		String[] bb = { "搜索", "恩恩", "得到" };
		Arrays.sort(aa);
		Arrays.sort(bb);
		if (Arrays.equals(aa, bb)) {
			System.out.println(aa);
			System.out.println(bb);
			System.err.println("ok");
		} else {
			System.err.println("no");
		}
		//
		// DoMainController ff = new DoMainController();
		// ff.tets();
		//
		// System.err.println(CommonUtils.getUUID());
	}

	public String getWxHis1() {
		String url = "";
		// TODO Auto-generated method stub
		/**
		 * 当前页面为公众号历史消息时，读取这个程序 在采集队列表中有一个load字段，当值等于1时代表正在被读取 首先删除采集队列表中load=1的行
		 * 然后从队列表中任意select一行
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

	public void getMsgExt1(String str, String url) {
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
		 * $sql = "select * from `文章表` where `biz`='".$biz."' and `content_url` like
		 * '%".$sn."%'" limit 0,1; 根据biz和sn找到对应的文章
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
		 * 在这里同样根据sn在采集队列表中删除对应的文章，代表这篇文章可以移出采集队列了 $sql = "delete from `队列表` where
		 * `content_url` like '%".$sn."%'"
		 */
		// tmpListMapper.deleteBySn(sn);

		// 然后将阅读量和点赞量更新到文章表中。
		post.setReadnum(read_num);
		post.setLikenum(like_num);
		// postMapper.updateByPrimaryKey(post);

	}

	public String getWxPost1() {
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
				if (redult.length < 2) {
					map.put(redult[0], "");
				} else {
					map.put(redult[0], redult[1]);
				}

			}

		}
		System.err.println(map.get("__biz"));

		return map;

	}

	public void getMsgJson1(String str, String url) throws UnsupportedEncodingException {
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

		results = weiXinNumberDao.selectByBiz(biz);
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
