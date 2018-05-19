package com.service.TestCollect;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
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

import com.google.code.kaptcha.Producer;
import com.service.TestCollect.dao.BlogInfoDao;
import com.service.TestCollect.dao.BlogUserDao;
import com.service.TestCollect.dao.CommentDao;
import com.service.TestCollect.dao.MyorderInfoDao;
import com.service.TestCollect.dao.PraiseDao;
import com.service.TestCollect.dao.TaskInfoDao;
import com.service.TestCollect.dao.UserInfoDao;
import com.service.TestCollect.dao.VideoDao;
import com.service.TestCollect.dao.WorkVideoDao;
import com.service.TestCollect.pojo.BlogInfo;
import com.service.TestCollect.pojo.BlogUser;
import com.service.TestCollect.pojo.Comment;
import com.service.TestCollect.pojo.MyorderInfo;
import com.service.TestCollect.pojo.Praise;
import com.service.TestCollect.pojo.SNSUserInfo;
import com.service.TestCollect.pojo.TaskInfo;
import com.service.TestCollect.pojo.UserInfo;
import com.service.TestCollect.pojo.UserInfofileVo;
import com.service.TestCollect.pojo.Video;
import com.service.TestCollect.pojo.WeixinOauth2Token;
import com.service.TestCollect.pojo.WorkVideo;
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
import com.zhan.utils.Ignore;
import com.zhan.utils.MD5;
import com.zhan.utils.MD5Utils;
import com.zhan.utils.MaptoListUtils;
import com.zhan.utils.PeanUtils;
import com.zhan.utils.PerimageUtils;
import com.zhan.utils.PropertiesFactory;
import com.zhan.utils.RegexConst;
import com.zhan.utils.Tools;

/**
 * 
 * @author zhanmeihe
 * 
 */
@Controller
public class DoMainController implements Runnable {

	private static Logger LOGGER = LoggerFactory
			.getLogger(DoMainController.class);

	private Producer captchaProducer;
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

	/**
	 * 抓取网易端视频接口
	 */
	@ResponseBody
	@RequestMapping(value = "/unis/NeteaseLive/app-htm", method = RequestMethod.GET, produces = "application/json")
	public CommonResponse GetVideoapp(Model model, NeteaseVideoService service,
			HttpServletRequest request, HttpServletResponse response) {
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
	public String videoList(@PathVariable("PageONE") int PageONE,
			@PathVariable("MaxRows") int MaxRows, Model model,
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
	public String IficationVideo(@RequestParam(value = "token") String token,
			Model model) {

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
	public String getDetail(
			@RequestParam(value = "videotype") String videotype,
			@RequestParam(value = "start") int start,
			@RequestParam(value = "pageSzie") int pageSzie,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		try {
			int firstResult = start * pageSzie;
			List<Video> vo = videoDao.queryvideoType(firstResult, pageSzie,
					videotype);
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
	 * @return
	 */

	@RequestMapping(value = "/index.SHTML", method = RequestMethod.GET, produces = "application/json")
	public String IndexPage(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		try {
			HttpSession session = request.getSession();
			session.setAttribute("imagePath", "/home/testproject");
			String value = (String) session.getAttribute("imagePath");
			System.out.println("获取session值是：" + value);
			int start = 0;
			int pageSzie = 6;
			int firstResult = start * pageSzie;
			List<BlogInfo> bi = blogInfoDao.indexquery(firstResult, pageSzie);
			List<BlogInfo> bif = new ArrayList<>();
			for (BlogInfo blogInfo : bi) {
				if (blogInfo.getImageUrl() == null
						|| blogInfo.getImageUrl().equals("")) {
					blogInfo.setImageUrl(PerimageUtils.getImgStr(blogInfo
							.getBlogContent()));
				}

				if (blogInfo.getBlogContent().length() > 150) {
					new PeanUtils();
					String subcontent = PeanUtils.delHTMLTag(blogInfo
							.getBlogContent());
					if (!subcontent.equals("")) {
						subcontent = subcontent.substring(0, 150);
						blogInfo.setBlogContent(subcontent + "...");
					} else {
						blogInfo.setBlogContent(subcontent);
					}
					System.err.println(subcontent);

					bif.add(blogInfo);
				} else {
					new PeanUtils();
					String subcontent = PeanUtils.delHTMLTag(blogInfo
							.getBlogContent());
					blogInfo.setBlogContent(subcontent);
					bif.add(blogInfo);
				}
			}

			model.addAttribute("bloglist", bif);
			return "blog/blog";
		} catch (UnisException e) {
			LOGGER.info("异常", e);
		} catch (Exception e) {
			LOGGER.info("异常", e);
		}
		return null;
	}

	/*
	 * 打开blog详细页
	 */
	 
	@RequestMapping(value = "/b/{blogId}", method = RequestMethod.GET, produces = "application/json")
	public String blogdetail(@PathVariable("blogId") String blogId,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
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
			BlogUser user2 =blogUserDao.queryUser(bo.getUserId());
		
			String content = PeanUtils.delHTMLTag(bo.getBlogContent()
					.substring(0, 50));
			int num = new ChinesepreNum().chineseCount(bo.getBlogContent());
			Praise pe = praiseDao.selectNum(blogId);
			bo.setPraiseCount(pe.getCountZan());
			model.addAttribute("blogdetail", bo);
			model.addAttribute("content", content);
			model.addAttribute("user2", user2);
			model.addAttribute("user", user);
			model.addAttribute("num", num);
			return "blog/blogdetail";
		} catch (UnisException e) {
			LOGGER.info("异常", e);
		} catch (Exception e) {
			LOGGER.info("异常", e);
		}
		// 异常处理返回
		// {后期}
		return "blog/errorpage";
	}

	@Token(save = true)
	@RequestMapping(value = "/sign_login", method = RequestMethod.GET, produces = "application/json")
	public ModelAndView login(HttpSession session, HttpServletRequest request,
			@RequestParam(value = "backUrl", required = false) String backUrl,
			HttpServletResponse response, Model model) {
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
					if (cookie.getName().equals("userName")
							&& !cookie.getValue().equals("")) {
						bu = blogUserDao.queryUserName(MD5Utils
								.getFromBASE64(cookie.getValue()));
					}
					if (cookie.getName().equals("userid")
							&& !cookie.getValue().equals("")) {
						lis = blogInfoDao.selectallData(MD5Utils
								.getFromBASE64(cookie.getValue()));
					}
				}
				if (lis.size() > 1 && bu.getUserId() != null) {

					return new ModelAndView("redirect:/u/" + bu.getUserId()
							+ "_");
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
	public ModelAndView loginsuccess(HttpSession session,
			HttpServletRequest request, HttpServletResponse response,
			Model model, RedirectAttributes attributes,
			@RequestParam(value = "userName") String userName,
			// @RequestParam(value = "backuri") String backuri,
			@RequestParam(value = "passWord") String passWord)
			throws IOException {
		try {
			// url = /crazy_blog/editw
			String url = (String) session.getAttribute("backUrl");
			url = MD5Utils.getFromBASE64(url);
			// System.out.println(backuri);
			// 天 //时 //分 //秒 30 * 24 * 60 * 60;
			int loginMaxAge = 2 * 60 * 60;
			BlogUser users = blogUserDao.queryUserName(userName);

			if (users != null) {
				if (!StringUtils.equals(MD5.GetMD5Code(passWord),
						users.getPassWord())) {
					throw new UnisException("登录密码或用户名错误");
				}
			} else {
				throw new UnisException("用户不存在");
			}
			session = request.getSession();
			String verificationCode = (String) session
					.getAttribute("verificationCode");
			String checkcode = request.getParameter("checkCode");
			PrintWriter out = response.getWriter();
			if (Ignore.ignoreCaseEquals(checkcode, verificationCode)) {
				System.out.println("验证码正确");
			} else {
				throw new UnisException("附加码错误");
			}

			// List<BlogUser> user =
			// blogUserDao.queryUserBlogData(users.getUserId());
			List<BlogInfo> bf = blogInfoDao.selectallData(users.getUserId());
			// 字数count
			int num = 0;

			// num = new
			// ChinesepreNum().chineseCount(blogInfo.getBlogContent());
			// num++;
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < bf.size(); i++) {
				num += new ChinesepreNum().chineseCount(bf.get(i)
						.getBlogContent());
			}
			UserUtil.setUser(users);
			// 获取cookie值
			CookieTool.addCookie(response, "userName",
					MD5Utils.getBASE64(userName), loginMaxAge);
			CookieTool.addCookie(response, "userid",
					MD5Utils.getBASE64(users.getUserId()), loginMaxAge);
			CookieTool.addCookie(response, "passWord",
					MD5Utils.getBASE64(passWord), loginMaxAge);
			session.setAttribute("user", users);
			Cookie[] dd1 = request.getCookies();
			for (int i = 0; i < dd1.length; i++) {
				System.out.println("cookie*****--" + dd1[i].getName() + ":"
						+ dd1[i].getValue());
			}
			List<BlogInfo> blist = new ArrayList<>();
			for (BlogInfo blogInfo : bf) {
				if (blogInfo.getBlogContent().length() >= 150) {

					String content = PeanUtils.delHTMLTag(blogInfo
							.getBlogContent().substring(0, 150));
					blogInfo.setBlogContent(content);
					blist.add(blogInfo);
				} else {
					String content = PeanUtils.delHTMLTag(blogInfo
							.getBlogContent());
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
	public void checkCode(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		String verificationCode = (String) session
				.getAttribute("verificationCode");
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
	 * 点赞
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
	public void addPraise(HttpServletRequest request, Model model,
			HttpServletResponse response) {

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
			@RequestParam(value = "page", required = false) int page,
			HttpServletResponse response) {
		try {
			int maxResult = 10;

			List<BlogInfo> bf = blogInfoDao.searchList(s, page - 1, maxResult);

			List<BlogInfo> bif = new ArrayList<>();
			for (BlogInfo blogInfo : bf) {
				if (blogInfo.getImageUrl() == null
						|| blogInfo.getImageUrl().equals("")) {
					blogInfo.setImageUrl(PerimageUtils.getImgStr(blogInfo
							.getBlogContent()));
				}

				if (blogInfo.getBlogContent().length() > 150) {
					new PeanUtils();
					String subcontent = PeanUtils.delHTMLTag(blogInfo
							.getBlogContent());
					if (!subcontent.equals("")) {
						subcontent = subcontent.substring(0, 150);
						blogInfo.setBlogContent(subcontent + "...");
					} else {
						blogInfo.setBlogContent(subcontent);
					}
					System.err.println(subcontent);

					bif.add(blogInfo);
				} else {
					new PeanUtils();
					String subcontent = PeanUtils.delHTMLTag(blogInfo
							.getBlogContent());
					blogInfo.setBlogContent(subcontent);
					bif.add(blogInfo);
				}
			}
			model.addAttribute("key", s);
			model.addAttribute("bloglist", bif);
			return new ModelAndView("blog/blog");
		} catch (UnisException e) {
			LOGGER.error("异常信息", e);
		} catch (Exception e) {
			LOGGER.debug("异常信息{debug}", e);
		}
		return null;
	}

	/**
	 * @author zhanmeihe 获取验证码
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/Checkimage", method = RequestMethod.GET)
	public ModelAndView getKaptchaImage(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		BufferedImage bfi = new BufferedImage(80, 25,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = bfi.getGraphics();
		g.fillRect(0, 0, 80, 25);
		HttpSession session = request.getSession(); // 保存到session
		session.setAttribute("verificationCode", CheckCode.getCode(bfi, g)
				.toString());
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
	public void logOnTransit(HttpServletRequest request, HttpSession session,
			HttpServletResponse response) throws Exception {
		CookieTool.addCookie(response, "userName", null, 0); // 清除Cookie
		CookieTool.addCookie(response, "passWord", null, 0); // 清除Cookie
		CookieTool.addCookie(response, "userid", null, 0);

		// 清空session
		session.invalidate();
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path + "/";
		// String finalPath = basePath + "sign_login";
		String finalPath = basePath;
		System.out.println("登出：" + finalPath);
		response.sendRedirect(finalPath);

	}

	@RequestMapping(value = "/editw", method = RequestMethod.GET)
	public ModelAndView writerWord(HttpServletRequest request,
			HttpServletResponse response, Model model) {

		try {
			Cookie[] dd1 = request.getCookies();
			if (dd1 == null) {
				model.addAttribute("user", "");
				return new ModelAndView("blog/editWord");
			}
			if (dd1.length > 2) {

				for (int i = 0; i < dd1.length; i++) {
					if (dd1[i].getName().equals("userName")) {
						System.out.println("cookie值：" + "#" + dd1[i].getValue()
								+ "#");
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
	public ModelAndView loginSuccess(@PathVariable("userId") String userIds,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		try {
			List<BlogInfo> lis = new ArrayList<>();
			BlogUser bu = new BlogUser();
			BlogUser bu1 =new BlogUser();
			Map<String, ?> map = RequestContextUtils.getInputFlashMap(request);
			if (map == null) {
				Cookie[] dd1 = request.getCookies();
				if (dd1 != null) {
					for (int i = 0; i < dd1.length; i++) {

						System.out.println("cookie*****--" + dd1[i].getName()
								+ ":" + dd1[i].getValue());
						if (dd1[i].getName().equals("userName")
								&& !dd1[i].getValue().equals("")) {

							// 解密后的username
							String userName = MD5Utils.getFromBASE64(dd1[i]
									.getValue());
							bu = blogUserDao.queryUserName(userName);

						}
						if (dd1[i].getName().equals("userid")
								&& !dd1[i].getValue().equals("")) {
							// 解密后的userId
							String userId = MD5Utils.getFromBASE64(dd1[i]
									.getValue());
							lis = blogInfoDao.selectallData(userId);
						}
					}
					// if (lis.size()<1&&bu.getUserId()==null) {
					// model.addAttribute("errorMsg", "请重新登录");
					// return new ModelAndView("redirect:/sign_login");
					// }
				}
				if (userIds.length() > 1 && userIds.lastIndexOf("_") != -1) {

					userIds = userIds.substring(0, userIds.lastIndexOf("_"));
					 bu1 = blogUserDao.queryUser(userIds);
					if (bu1.getNickName() == null || bu1.getNickName().equals("")) {
						return new ModelAndView("blog/errorpage");
					}
					lis = blogInfoDao.selectallData(userIds);
				}

				else {
					// model.addAttribute("errorMsg", "请重新登录");
					return new ModelAndView("redirect:/sign_login");
				}

			} else {

				List li = new MaptoListUtils().mapTransitionList(map);
				for (int i = 0; i < li.size(); i++) {
					System.out.println(li.get(i).getClass().toString());
					if (li.get(i).getClass().toString()
							.equals("class java.util.ArrayList")) {
						lis = (List<BlogInfo>) li.get(i);
					}
					if (li.get(i)
							.getClass()
							.toString()
							.equals("class com.service.TestCollect.pojo.BlogUser")) {
						bu1 = (BlogUser) li.get(i);
					}
				}
			}
			model.addAttribute("blogdatalist", lis);
			if (map == null) {
				int num = 0;
				for (int i = 0; i < lis.size(); i++) {
					num += new ChinesepreNum().chineseCount(lis.get(i)
							.getBlogContent());
				}
				model.addAttribute("textnum", num);
				model.addAttribute("articlenum", lis.size());
			} else {
				model.addAttribute("textnum", map.get("textnum").toString());
				model.addAttribute("articlenum", map.get("articlenum")
						.toString());
			}
			List<BlogInfo> blist = new ArrayList<>();
			for (BlogInfo blogInfo : lis) {
				if (blogInfo.getBlogContent().length() >= 150) {
					String content = PeanUtils.delHTMLTag(blogInfo
							.getBlogContent());
					if (!content.equals("")) {
						content = content.substring(0, 150);
						blogInfo.setBlogContent(content + "...");
					} else {
						blogInfo.setBlogContent(content);
					}
					blogInfo.setBlogContent(content);
					blist.add(blogInfo);
				} else {
					String content = PeanUtils.delHTMLTag(blogInfo
							.getBlogContent());
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
			return new ModelAndView("blog/medetail");
		} catch (UnisException e) {
			model.addAttribute("errorMsg", "登录错误，请重新登录");
			return new ModelAndView("redirect:/sign_login");
		} catch (Exception e) {
			model.addAttribute("errorMsg", "登录错误，请重新登录");
			return new ModelAndView("redirect:/sign_login");
		}
	}

	@RequestMapping(value = "/blogText", method = RequestMethod.POST)
	public String gettext(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		try {

			String userId = request.getParameter("userid");
			BlogInfo maxid = blogInfoDao.querymaxid();
			String title = request.getParameter("title");
			int blogId = maxid.getMaxBlogId() + 1;
			BlogUser bu = blogUserDao.queryUser(userId);
			BlogInfo bf = new BlogInfo();
			String text = request.getParameter("editorValue");
			if (text == null || text.equals("null")) {
				text = "";
			}
			if (title.equals("") || text.equals("")) {
				model.addAttribute("error", "标题和内容不能为空");
				return "redirect:/editw";
			}
			bf.setBlogContent(text);
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

			return "redirect:/u/" + userId;

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
	public void showIcons(@RequestParam(required = true) String fileName,
			HttpServletResponse response, HttpServletRequest request) {
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
	
	
	/**评论发表
	 * @author zhanmeihe
	 * @param pinglun
	 * @param bolgId
	 * @param userId
	 * @param response
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/writepl",method = RequestMethod.POST,produces = "application/json")
	public CommonResponse WriteComments(@RequestParam(value = "pinglun") String pinglun,
			@RequestParam(value = "bolgId") String bolgId,
			@RequestParam(value = "userId") String userId,
			HttpServletResponse response, HttpServletRequest request)
		{
		try {	
			
			List<BlogInfo> b = blogInfoDao.indexquery(0, 10);
			Comment ct  = new Comment();
			ct.setBlogId(bolgId);
			ct.setCommentContent(pinglun);
			ct.setCommentId(CommonUtils.getUUID());
			ct.setCreateDate(CommonUtils.getNowDate());
			ct.setUpdateDate(CommonUtils.getNowDate());
			ct.setUserId(userId);
			ct.setZanNum(0);
			 commentDao.createComments(ct);
			return  new CommonSuccessResponse(b);
		} catch (UnisException e) {
			LOGGER.debug("2", e);
			return new CommonResponse(e.getCode(), e.getMessage());
		}catch (Exception e) {
			LOGGER.debug("3", e);
			return new SystemErrorResponse();
		}
	}
	
	
	/**初始化加载评论列表
	 * 
	 * @author zhanmeihe
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/INITDATA",method = RequestMethod.GET,produces = "application/json")
	public  CommonResponse initComments(
			HttpServletResponse response, HttpServletRequest request){
		
		try {
			String firstResult = request.getParameter("pagenum");
			String page = request.getParameter("page");
			List<Comment> ct = commentDao.queryCommentAll(
					Integer.parseInt(page), Integer.parseInt(firstResult));
			
			return new CommonSuccessResponse(ct);
			
		} catch (UnisException e) {
			LOGGER.debug("2", e);
			return new CommonResponse(e.getCode(), e.getMessage());
		}catch (Exception e) {
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
			@RequestParam(value = "identity") String Sex,
			@RequestParam(value = "PhoneNum") String PhoneNum,
			@RequestParam(value = "IdcardNum") String IdcardNum,
			@RequestParam(value = "YearNum") String YearNum,
			@RequestParam(value = "WorkType") String WorkType,
			@RequestParam(value = "openId") String openId,
			@RequestParam(value = "headImgUrl") String headImgUrl,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
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
	public String IndexReg(HttpServletRequest request,
			HttpServletResponse response, Model model, Configure conf) {
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
				WeixinOauth2Token weixinOauth2Token = AdvancedUtil
						.getOauth2AccessToken(conf.getproperties("appid"),
								conf.getproperties("secrn"), code);
				// 网页授权接口访问凭证
				String accessToken = weixinOauth2Token.getAccessToken();
				// 用户标识
				String openId = weixinOauth2Token.getOpenId();
				// 获取用户信息
				SNSUserInfo snsUserInfo = AdvancedUtil.getSNSUserInfo(
						accessToken, openId);
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
	public String Test(@PathVariable("userId") String userId,
			HttpServletRequest request, HttpServletResponse response,
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
	public String IndexIdcArd(@PathVariable("AddressName") String AddressName,
			Model model, HttpSession session) {
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
	public String OrderList(@PathVariable("userId") String userId,
			HttpServletRequest request, HttpServletResponse response,
			Model model, HttpSession session) {
		try {
			HttpSession httpSession = request.getSession();
			// httpSession.setMaxInactiveInterval(60);
			if (httpSession.getAttribute("username") != null) {
				System.err.println("有session的，session userId等于"
						+ httpSession.getAttribute("username"));
				model.addAttribute("username",
						httpSession.getAttribute("username"));
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
	public String WorkingList(@PathVariable("userId") String userId,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

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
	public String PersonalCenter(@PathVariable("userId") String userId,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
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
	public String PersonListDetails(@PathVariable("id") String id,
			@PathVariable("userId") String userId, Model model) {
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
	public String ListDetails(@PathVariable("id") String id,
			@PathVariable("userId") String userId, Model model) {
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
	public String GrabSingle(HttpServletResponse response,
			HttpServletRequest request, Model model) {

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
	public String MeOrderLists(@PathVariable("userId") String userId,
			Model model) {
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
	public String Clockin(@RequestParam(value = "userId") String userId,
			@RequestParam(value = "taskId") String taskId, UserInfofileVo vo,
			Model model) throws Exception {
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
	public String Details(@PathVariable("userId") String userId,
			@PathVariable("taskId") String taskId, Model model) {
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
	public String getmodifyinfo(
			@RequestParam(value = "UserName") String UserName,
			@RequestParam(value = "identity") String Sex,
			@RequestParam(value = "PhoneNum") String PhoneNum,
			@RequestParam(value = "YearNum") String YearNum,
			@RequestParam(value = "userId") String userId, Model model) {
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
	public String ImageUp(@RequestParam(value = "userName") String UserName,
			@RequestParam(value = "sex") String Sex,
			@RequestParam(value = "phoneNum") String PhoneNum,
			@RequestParam(value = "idcardNum") String IdcardNum,
			@RequestParam(value = "yearNum") String YearNum,
			@RequestParam(value = "workType") String WorkType,
			@RequestParam(value = "openid") String openid,
			@RequestParam(value = "picImage") String picImage, UserInfo vo,
			UserInfofileVo v1, Model model) {
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
			if (v1.getHeadPic().get(0).getSize() < 10
					|| v1.getHeadPic().get(1).getSize() < 10
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
	public void showIcon(@RequestParam(required = true) String fileName,
			HttpServletResponse response, HttpServletRequest request) {
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

	private void responseOutputFile(HttpServletResponse response,
			String filePath, String defaultFileName) {
		BufferedInputStream bis = null;
		OutputStream outp = null;
		try {
			try {
				bis = new BufferedInputStream(new FileInputStream(filePath));
			} catch (Exception e) {
				bis = new BufferedInputStream(new FileInputStream(
						getNoFile(defaultFileName)));
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
		response.addHeader("Content-Disposition", "attachment;filename="
				+ chopName);
		response.setContentType("APPLICATION/OCTET-STREAM ");
	}

	private String getNoFile(String fileName) {
		String path = this.getClass().getClassLoader().getResource("/")
				.getPath();
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

	private UserInfo ImageUpload(UserInfo vo1, UserInfofileVo vo)
			throws Exception {

		String newFileName = null;

		List<String> image = new ArrayList<>();
		List<MultipartFile> file = vo.getHeadPic();
		for (MultipartFile multipartFile : file) {

			if (vo.getHeadPic() != null) {
				fileSizeOverrun(multipartFile);

				String originalFileName = multipartFile.getOriginalFilename();
				newFileName = CommonUtils.getUUID()
						+ originalFileName.substring(originalFileName
								.lastIndexOf("."));
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
			newFileName = "http://www.antarchi.com/common/showIcon?fileName="
					+ newFileName;
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

	private WorkVideo Video2Upload(WorkVideo vo1, UserInfofileVo vo)
			throws Exception {

		String newFileName = null;
		try {
			List<String> image = new ArrayList<>();
			List<MultipartFile> file = vo.getHeadPic();
			for (MultipartFile multipartFile : file) {

				if (multipartFile != null && multipartFile.getSize() > 0) {
					fileSizeOverrun(multipartFile);

					String originalFileName = multipartFile
							.getOriginalFilename();
					newFileName = CommonUtils.getUUID()
							+ originalFileName.substring(originalFileName
									.lastIndexOf("."));
					File picFile = new File("/FILE/images/" + newFileName);

					try {
						multipartFile.transferTo(picFile);
					} catch (IllegalStateException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						throw new RuleException("上传失败");
					}
					// write picFile http name into mysql database;
					newFileName = "http://www.antarchi.com/common/showIcon?fileName="
							+ newFileName;

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

	public String listToString(@SuppressWarnings("rawtypes") List list,
			char separator) {
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
					System.out.println("时长："
							+ JSONObject.fromObject(array.get(j)).get("length")
									.toString());
					String length = JSONObject.fromObject(array.get(j))
							.get("length").toString();
					int a = Integer.parseInt(length) / 60;
					int b = Integer.parseInt(length) % 60;
					String a1 = String.valueOf(a);
					String b1 = String.valueOf(b);
					String time = a1 + ":" + b1;
					ns.setTimeLength(time);
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
					System.out.println("时长 ===="
							+ JSONObject.fromObject(array.get(i))
									.get("playlength").toString());
					String length = JSONObject.fromObject(array.get(i))
							.get("playlength").toString();
					int aa = Integer.parseInt(length) / 60;
					int bb = Integer.parseInt(length) % 60;
					String a1 = String.valueOf(aa);
					String b1 = String.valueOf(bb);
					String time = a1 + ":" + b1;
					ns.setTimeLength(time);
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

}
