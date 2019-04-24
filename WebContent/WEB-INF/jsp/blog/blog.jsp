<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.util.*"%>
<%@ page import="java.net.URLDecoder"%>
<%@ page import="sun.misc.BASE64Decoder"%>
<%@ page import="java.text.SimpleDateFormat"%>
<!doctype html>
<html>
<head>
<meta charset="gb2312">
<title>疯狂-博客</title>
<meta name="keywords" content="疯狂博客" />
<meta name="description" content="疯狂博客" />
<link href="<%=request.getContextPath()%>/css/base.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/index.css"
	rel="stylesheet">
<%-- 	<link rel="stylesheet" media="all"
	href="<%=request.getContextPath()%>/css/web-221ec98db5f8f985b66f.css" /> --%>
<link href="<%=request.getContextPath()%>/images/logo.ico"
	rel="shortcut icon" type="image/x-icon">
<!--[if lt IE 9]  疯狂博客>
<script src="js/modernizr.js"></script>
<![endif]-->
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.js"></script>
</head>
<body>
	<%
		String date = "";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		date = formatter.format(new Date());
	%>

	<%
		String tokenV = new Date().getTime() + "";
	%>

	<%
		String user = "";
		String userid = "";
		Cookie cookies[] = request.getCookies();
		//out.println(" cookie的数量为：" + cookies);
		//out.println("<br>"+"<br>"); 
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("userName")) {
					user = cookies[i].getValue();
					if (user == null) {
						user = null;
					} else if (user != null) {
						BASE64Decoder decoder = new BASE64Decoder();

						byte[] b = decoder.decodeBuffer(user);
						user = new String(b);
					}
				}
				if (cookies[i].getName().equals("userid")) {
					userid = cookies[i].getValue();
					if (userid == null) {
						userid = "null";
					} else if (userid != null) {
						BASE64Decoder decoder = new BASE64Decoder();

						byte[] b = decoder.decodeBuffer(userid);
						userid = new String(b);
					}
				}

				//out.println("getName="+cookies[i].getName()+"<br>");  
				// out.println("getValue="+cookies[i].getValue()+"<br>");
			}
		} else {
			user = "";
			userid = "";
		}

		//用户名解码展现
		/* if (user == null){
			user = null;
		}else if(user!=null){
			BASE64Decoder decoder = new BASE64Decoder();
		 
			byte[] b = decoder.decodeBuffer(user);
			user =  new String(b);
		} */
	%>
	<%-- //用户名：<%=user%> --%>
	<script type="text/javascript">
	
	
	function handleMove (e) {
		
	 
    var dom = $(".contract_list");//可滚动区域
    var scrollTop = dom.scrollTop();//获取滚动的距离

    this.endClientY = e.touches[0].clientY;//更新手指当前屏幕Y轴位置--结束位置
    console.log("结束位置:",this.endClientY)

    //判断是否滚动到底部
    if (scrollTop - this.lastscrolltop > 0) {
        this.lastscrolltop = dom.scrollTop()
        console.log("继续滚动，scrollTop:", scrollTop)
    } else if (scrollTop != 0 && this.lastscrolltop !=0 && scrollTop - this.lastscrolltop == 0) {
        alert("333");
    	console.log("到底了!")
    }

    //判断手指滑动方向
    if(e.touches[0].clientY < this.startClientY){
        this.movedirection = "UP";
    }else if(e.touches[0].clientY > this.startClientY){
        this.movedirection = "DOWN";
    }else{
        this.movedirection = "CENTER";
    }

    this.startClientY = e.touches[0].clientY;


</script>
	<script type="text/javascript">
	function validateForm() {
		var keyword = $.trim($('input[name="s"]').val());
		 
		if (keyword == '') {
			alert('搜索词不能为空喔！');
			return false;
		}
		 
		  
		return true;
	}
	
	
		function blogData() {
			 
			$.ajax({
				url : '${pageContext.request.contextPath}/search',
				data : $("#searchform").serialize(),
				type : 'GET',
				//dataType : 'json', 
				async : true,
				success : function(data) {//这是个回调函数 data表示从action中传过来的json数据

				}
			});
		}
	</script>

	<div class="topnav">
		<a href="http://www.focode.cn/download/div/2017-07-16/785.html"
			target="_blank">疯狂博客</a>――作品来自<a href="http://www.focode.cn"
			target="_blank">占美和个人博客网站</a>

	</div>
	<div id="wrapper">
		<header>
			<div class="headtop"></div>
			<div class="contenttop">
				<div class="logo f_l">疯狂博客</div>
				<%
					if (user == null || user.equals("")) { //为空时表示你没有登录.,
				%>
				<div class="search f_r" id="login">
					<!-- <input name="Submit" class="input_submit"
							value="登录" type="submit" > -->
					<a href="<%=request.getContextPath()%>/sign_login"><input
						name="Submit" class="input_submit" value="登录" type="submit"></a>
				</div>
				<div class="search f_r" id="login">

					<a href="<%=request.getContextPath()%>/personal.jsp"><input
						name="Submit" class="input_submit" value="注册" type="submit"></a>
				</div>
				<%
					} else {
				%>

				<div class="search f_r" id="login">
					<!-- <input name="Submit" class="input_submit"
							value="登录" type="submit" > -->
					<%--  <%=user%> --%>
					<h2 style="font-size: 2em; color: gray;">
						欢迎用户：<%=user%></h2>

				</div>
				<%
					}
				%>
				<div class="search f_r">
					<form action="<%=request.getContextPath()%>/search" method="get"
						name="searchform" id="searchform"
						onsubmit="return validateForm();">
						<input name="s" placeholder="搜索🔍" id="keyboard" maxlength="15"
							class="input_text" value="${key}"
							style="color: rgb(153, 153, 153);" type="text"> <input
							name="charset" value="utf-8" type="hidden"> <input
							name="page" value="1" type="hidden"> <input name="date"
							value="<%=date%>" type="hidden"> <input name="type"
							value="default" type="hidden"> <input
							class="input_submit" value="搜索" type="submit">

					</form>
					<!-- onfocus="if(value=='请输入关键字'){this.style.color='#000';value=''}"
							onblur="if(value==''){this.style.color='#999';value='请输入关键字'}" -->

				</div>
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#menu" aria-expanded="false">
							<span class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
					</div>
				</div>
				<div class="blank"></div>
				<nav>
					<div class="navigation">
						<ul class="menu">
							<%-- <li><a href="<%=request.getContextPath()%>/index.jsp">登录</a></li> --%>
							<li><a href="<%=request.getContextPath()%>/index.jsp">网站首页</a></li>
							<li><a href="#">关于我</a>
								<ul>
									<li><a href="about.jsp">个人简介</a></li>
									<li><a href="listpic.jsp">个人相册</a></li>
								</ul></li>
							<li><a href="#">我的日记</a>
								<ul>
									<li><a href="newslistpic.jsp">个人日记</a></li>
									<li><a href="newslistpic.jsp">学习笔记</a></li>
								</ul></li>
							<li><a href="newslistpic.jsp">技术文章</a></li>
							<li><a href="#">给我留言</a></li>
						</ul>
					</div>
				</nav>
				<SCRIPT type=text/javascript>
					// Navigation Menu
					$(function() {
						$(".menu ul").css({
							display : "none"
						}); // Opera Fix
						$(".menu li").hover(function() {
							$(this).find('ul:first').css({
								visibility : "visible",
								display : "none"
							}).slideDown("normal");
						}, function() {
							$(this).find('ul:first').css({
								visibility : "hidden"
							});
						});
					});
				</SCRIPT>
			</div>
		</header>
		<div class="jztop"></div>
		<div class="container">
			<div class="bloglist f_l">
				<c:forEach items="${ bloglist}" var="blog">
					<h3>
						<a href="<%=request.getContextPath()%>/b/${blog.blogId}">${blog.title}</a>
					</h3>
					<c:set var="img" scope="session" value="${blog.imageUrl}" />
					<c:if test="${img > ' '}">
						<figure>
							<img src="${blog.imageUrl}" alt="${blog.title}">
						</figure>
					</c:if>

					<ul>
						<p>${blog.blogContent}</p>
						<a title="${blog.title}"
							href="<%=request.getContextPath()%>/b/${blog.blogId}"
							target="_blank" class="readmore">阅读全文&gt;&gt;</a>
					</ul>
					<p class="dateview">
						<span>${blog.createblogDate}</span><span>作者: ${blog.author}</span><span>个人博客：[<a
							href="<%=request.getContextPath()%>/u/${blog.userId}_">心得笔记</a>]
						</span>
					</p>
					<br>

				</c:forEach>
				<p>————————————————————————我也是有底线的哦——————————————————</p>
			</div>
			<div class="r_box f_r">
				<div class="tit01">
					<h3 class="tit">我的导航</h3>
					<div class="gzwm">
						<ul>

							<li><a class="email"
								href="<%=request.getContextPath()%>/u/<%=userid%>_"
								target="_blank">个人主页</a></li>
							<li><a class="qq" href="#mailto:admin@admin.com"
								target="_blank">我的邮箱</a></li>
							<li><a class="tel" href="#" target="_blank">我的QQ</a></li>
							<li><a class="prize" href="#">个人奖项</a></li>
						</ul>
					</div>
				</div>
				<!--tit01 end-->

				<div class="tuwen">
					<h3 class="tit">图文推荐</h3>
					<ul>
						<li><a href="/"><img
								src="<%=request.getContextPath()%>/images/01.jpg"><b>住在手机里的朋友</b></a>
							<p>
								<span class="tulanmu"><a href="/">手机配件</a></span><span
									class="tutime">2015-02-15</span>
							</p></li>
						<li><a href="/"><img
								src="<%=request.getContextPath()%>/images/02.jpg"><b>教你怎样用欠费手机拨打电话</b></a>
							<p>
								<span class="tulanmu"><a href="/">手机配件</a></span><span
									class="tutime">2015-02-15</span>
							</p></li>
						<li><a href="/" title="手机的16个惊人小秘密，据说99.999%的人都不知"><img
								src="<%=request.getContextPath()%>/images/03.jpg"><b>手机的16个惊人小秘密，据说...</b></a>
							<p>
								<span class="tulanmu"><a href="/">手机配件</a></span><span
									class="tutime">2015-02-15</span>
							</p></li>
						<li><a href="/"><img
								src="<%=request.getContextPath()%>/images/06.jpg"><b>住在手机里的朋友</b></a>
							<p>
								<span class="tulanmu"><a href="/">手机配件</a></span><span
									class="tutime">2015-02-15</span>
							</p></li>
						<li><a href="/"><img
								src="<%=request.getContextPath()%>/images/04.jpg"><b>教你怎样用欠费手机拨打电话</b></a>
							<p>
								<span class="tulanmu"><a href="/">手机配件</a></span><span
									class="tutime">2015-02-15</span>
							</p></li>
						<li><a href="/"><img
								src="<%=request.getContextPath()%>/images/02.jpg"><b>教你怎样用欠费手机拨打电话</b></a>
							<p>
								<span class="tulanmu"><a href="/">手机配件</a></span><span
									class="tutime">2015-02-15</span>
							</p></li>
						<li><a href="/" title="手机的16个惊人小秘密，据说99.999%的人都不知"><img
								src="<%=request.getContextPath()%>/images/03.jpg"><b>手机的16个惊人小秘密，据说...</b></a>
							<p>
								<span class="tulanmu"><a href="/">手机配件</a></span><span
									class="tutime">2015-02-15</span>
							</p></li>
					</ul>
				</div>
				<div class="ph">
					<h3 class="tit">点击排行</h3>
					<ul class="rank">
						<li><a href="/jstt/bj/2017-07-13/784.html"
							title="【心路历程】请不要在设计这条路上徘徊啦" target="_blank">【心路历程】请不要在设计这条路上徘徊啦</a></li>
						<li><a href="/news/s/2016-05-20/751.html" title="IP要突破2000+了"
							target="_blank">IP要突破2000+了</a></li>
						<li><a href="/jstt/web/2015-07-03/749.html"
							title="帝国cms首页、自定义页面如何实现分页" target="_blank">帝国cms首页、自定义页面如何实现分页</a></li>
						<li><a href="/jstt/web/2015-02-25/745.html"
							title="【已评选】给我模板PSD源文件，我给你设计HTML！" target="_blank">【已评选】给我模板PSD源文件，我给你设计HTML！</a></li>
						<li><a href="/jstt/bj/2015-02-14/744.html"
							title="【郑重申明】本站只提供静态模板下载！" target="_blank">【郑重申明】本站只提供静态模板下载！</a></li>
						<li><a href="/news/s/2015-01-23/741.html"
							title="【孕期日记】生活本该如此" target="_blank">【孕期日记】生活本该如此</a></li>
						<li><a href="/jstt/bj/2015-01-09/740.html"
							title="【匆匆那些年】总结个人博客经历的这四年…" target="_blank">【匆匆那些年】总结个人博客经历的这四年…</a></li>
						<li><a href="/jstt/web/2015-01-01/739.html"
							title=" 2014年度优秀个人博客排名公布" target="_blank"> 2014年度优秀个人博客排名公布</a></li>
						<li><a href="/jstt/web/2014-12-18/736.html"
							title="2014年度优秀个人博客评选活动" target="_blank">2014年度优秀个人博客评选活动</a></li>
						<li><a href="/jstt/css3/2014-12-09/734.html"
							title="使用CSS3制作文字、图片倒影" target="_blank">使用CSS3制作文字、图片倒影</a></li>
						<li><a href="/jstt/css3/2014-11-18/733.html"
							title="【分享】css3侧边栏导航不同方向划出效果" target="_blank">【分享】css3侧边栏导航不同方向划出效果</a></li>
						<li><a href="/jstt/bj/2014-11-06/732.html"
							title="分享我的个人博客访问量如何做到IP从10到600的(图文)" target="_blank">分享我的个人博客访问量如何做到IP从10到600的(图文)</a></li>
					</ul>
				</div>
				<div class="ad">
					<img src="<%=request.getContextPath()%>/images/03.jpg">
				</div>
			</div>
		</div>
		<!-- container代码 结束 -->
		<div class="jzend"></div>
		<footer>
			<div class="footer">
				<div class="f_l">
					<p>
						All Rights Reserved 版权所有：<a href="http://www.focode.cn">占美和个人博客</a>
						备案号：京ICP备17010763号
					</p>
				</div>
				<div class="f_r textr">
					<p>Design by DanceSmile</p>
				</div>
			</div>
		</footer>
	</div>
</body>
</html>
