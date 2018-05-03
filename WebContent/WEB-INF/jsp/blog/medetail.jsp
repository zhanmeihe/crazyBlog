<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.util.*"%>
<%@ page import="java.net.URLDecoder"%>
<%@ page import="sun.misc.BASE64Decoder"%>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0,user-scalable=no">
<meta name="referrer" content="never">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<meta http-equiv="Cache-Control" content="no-transform" />
<meta name="applicable-device" content="pc,mobile">
<meta name="MobileOptimized" content="width" />
<meta name="HandheldFriendly" content="true" />
<meta name="mobile-agent"
	content="format=html5;url=https://www.jianshu.com/u/1b4935172ae0">

<meta name="description" content="hello  it!fffffsfsvdsfsfsf">

<meta name="360-site-verification"
	content="604a14b53c6b871206001285921e81d8" />
<meta property="wb:webmaster" content="294ec9de89e7fadb" />
<meta property="qc:admins" content="104102651453316562112116375" />
<meta property="qc:admins" content="11635613706305617" />
<meta property="qc:admins" content="1163561616621163056375" />
<meta name="google-site-verification"
	content="cV4-qkUJZR6gmFeajx_UyPe47GW9vY6cnCrYtCHYNh4" />
<meta name="google-site-verification"
	content="HF7lfF8YEGs1qtCE-kPml8Z469e2RHhGajy6JPVy5XI" />
<meta http-equiv="mobile-agent"
	content="format=html5; url=https://www.jianshu.com/u/1b4935172ae0">


<meta name="apple-mobile-web-app-title" content="简书">



<title>${bloguser.nickName }-疯狂博客</title>

<meta name="csrf-param" content="authenticity_token" />
<meta name="csrf-token"
	content="tmLUODiE99P3B9qVZwRybJ3ooXPqVSeRRfRFL0uI4L4xJgjBwJaqjY/JSWHS6OjHmsR9sSUJK9rb2ORDOWlW6A==" />

<link rel="stylesheet" media="all"
	href="<%=request.getContextPath()%>/css/web-221ec98db5f8f985b66f.css" />

<link rel="stylesheet" media="all"
	href="<%=request.getContextPath()%>/css/entry-8ef1fb97351638811ee4.css" />

<link href="<%=request.getContextPath()%>/images/logo.ico"
	rel="shortcut icon" type="image/x-icon">
<link rel="apple-touch-icon-precomposed"
	href="https://cdn2.jianshu.io/assets/apple-touch-icons/57-a6f1f1ee62ace44f6dc2f6a08575abd3c3b163288881c78dd8d75247682a4b27.png"
	sizes="57x57" />
<link rel="apple-touch-icon-precomposed"
	href="https://cdn2.jianshu.io/assets/apple-touch-icons/72-fb9834bcfce738fd7b9c5e31363e79443e09a81a8e931170b58bc815387c1562.png"
	sizes="72x72" />
<link rel="apple-touch-icon-precomposed"
	href="https://cdn2.jianshu.io/assets/apple-touch-icons/76-49d88e539ff2489475d603994988d871219141ecaa0b1a7a9a1914f4fe3182d6.png"
	sizes="76x76" />
<link rel="apple-touch-icon-precomposed"
	href="https://cdn2.jianshu.io/assets/apple-touch-icons/114-24252fe693524ed3a9d0905e49bff3cbd0228f25a320aa09053c2ebb4955de97.png"
	sizes="114x114" />
<link rel="apple-touch-icon-precomposed"
	href="https://cdn2.jianshu.io/assets/apple-touch-icons/120-1bb7371f5e87f93ce780a5f1a05ff1b176828ee0d1d130e768575918a2e05834.png"
	sizes="120x120" />
<link rel="apple-touch-icon-precomposed"
	href="https://cdn2.jianshu.io/assets/apple-touch-icons/152-bf209460fc1c17bfd3e2b84c8e758bc11ca3e570fd411c3bbd84149b97453b99.png"
	sizes="152x152" />

<script language="JavaScript">
	javascript: window.history.forward(1);
</script>


<script language="javascript">
	var secs = 3; //倒计时的秒数 
	var URL;
	function Load(url) {
		URL = url;
		for (var i = secs; i >= 0; i--) {
			window.setTimeout('doUpdate(' + i + ')', (secs - i) * 1000);
		}
	}
	function doUpdate(num) {
		document.getElementById('ShowDiv').innerHTML = '将在' + num + '秒后自动跳转到主页';
		if (num == 0) {
			window.location = URL;
		}
	}
</script>
<!-- <script>
	var _hmt = _hmt || [];
	(function() {
		var hm = document.createElement("script");
		hm.src = "//hm.baidu.com/hm.js?0c0e9d9b1e7d617b3e6842e85b9fb068";
		var s = document.getElementsByTagName("script")[0];
		s.parentNode.insertBefore(hm, s);
	})();
</script> -->


</head>

<body lang="zh-CN" class="reader-song-font">

	<%
		String user = "";
		/* String userid = ""; */
		Cookie cookies[] = request.getCookies();
		//out.println(" cookie的数量为：" + cookies.length);
		//out.println("<br>"+"<br>"); 
		if(cookies != null){
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("userName")) {
					user = cookies[i].getValue();

					/* 	if (user == null){
							user = null;
						}else if(user!=null){
							BASE64Decoder decoder = new BASE64Decoder();
						 
							byte[] b = decoder.decodeBuffer(user);
							user =  new String(b);
						} */
				}
				/* if (cookies[i].getName().equals("userid")) {
					userid = cookies[i].getValue();
					if (userid == null){
						userid = "null";
					}else if(userid!=null){
						BASE64Decoder decoder = new BASE64Decoder();
					 
						byte[] b = decoder.decodeBuffer(userid);
						userid =  new String(b);
					}
				} */

				//out.println("getName="+cookies[i].getName()+"<br>");  
				// out.println("getValue="+cookies[i].getValue()+"<br>");
			}
		}else{
			user = "";
		}
	 
		//用户名解码展现
		/* if (user == null){
			user = null;
		}else if(user!=null){
			BASE64Decoder decoder = new BASE64Decoder();
		 
			byte[] b = decoder.decodeBuffer(user);
			user =  new String(b);
		} */
		if (user == null) {
			user = null;
		} else if (user != null) {
			BASE64Decoder decoder = new BASE64Decoder();

			byte[] b = decoder.decodeBuffer(user);
			user = new String(b);
		}
	%>


	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="width-limit">

			<%
				if (user.equals("")) { //为空时表示你没有登录.,
			%>
			<a class="btn write-btn" target="_blank"
				href="<%=request.getContextPath()%>/editw"> <i
				class="iconfont ic-write"></i>撰写
			</a> <a class="btn log-in"
				href="<%=request.getContextPath()%>/sign_login">登录</a>
				<!-- <a class="style-mode-btn"><i class="iconfont ic-navigation-mode"></i></a> -->
			<%
				} else {
			%>
			<a class="logo"
				href="<%=request.getContextPath()%>/u/<%=user %>_"><img
				src="<%=request.getContextPath()%>/images/logo.png" alt="logo" /></a> <a
				class="btn write-btn" target="_blank"
				href="<%=request.getContextPath()%>/editw"> <i
				class="iconfont ic-write"></i>撰写
			</a>

			<div class="user">
				<div data-hover="dropdown">
					<a class="avatar"
						href="<%=request.getContextPath()%>/u/${bloguser.userId}_"><img
						src="${ bloguser.headUrl}" alt="120" /></a>
				</div>
				<ul class="dropdown-menu">
					<li><a
						href="<%=request.getContextPath()%>/u/${bloguser.userId}_"> <i
							class="iconfont ic-navigation-profile"></i><span>我的主页</span>
					</a></li>
					<!--  <li>
            TODO bookmarks_path
            <a href="/bookmarks">
              <i class="iconfont ic-navigation-mark"></i><span>收藏的文章</span>
</a>          </li>
          <li>
            <a href="/users/1b4935172ae0/liked_notes">
              <i class="iconfont ic-navigation-like"></i><span>喜欢的文章</span>
</a>          </li>
          <li>
            <a href="/my/paid_notes">
              <i class="iconfont ic-paid"></i><span>拥有的付费内容</span>
</a>          </li>
          <li>
            <a href="/wallet">
              <i class="iconfont ic-navigation-wallet"></i><span>我的钱包</span>
</a>          </li> -->
					<li><a href="/settings"> <i
							class="iconfont ic-navigation-settings"></i><span>设置</span>
					</a></li>
					<!-- <li>
            <a href="/faqs">
              <i class="iconfont ic-navigation-feedback"></i><span>帮助与反馈</span>
</a>          </li> -->
					<li><a rel="nofollow" data-method="delete"
						href="<%=request.getContextPath()%>/logOnTransit"> <i
							class="iconfont ic-navigation-signout"></i><span>退出</span>
					</a></li>
				</ul>
			</div>

			<%
				}
			%>



			<%-- 				<a class="logo" href="<%=request.getContextPath()%>/u/${bloguser.userId}"><img
				src="<%=request.getContextPath()%>/images/logo.png" alt="logo" /></a> 
				 <a
				class="btn write-btn" target="_blank" href="<%=request.getContextPath()%>/editw"> <i
				class="iconfont ic-write"></i>撰写
			</a>

			<div class="user">
				<div data-hover="dropdown">
					<a class="avatar" href="<%=request.getContextPath()%>/u/${bloguser.userId}"><img
						src="${ bloguser.headUrl}"
						alt="120" /></a>
				</div>
				<ul class="dropdown-menu">
					<li><a href="<%=request.getContextPath()%>/u/${bloguser.userId}"> <i
							class="iconfont ic-navigation-profile"></i><span>我的主页</span>
					</a></li>
					<!--  <li>
            TODO bookmarks_path
            <a href="/bookmarks">
              <i class="iconfont ic-navigation-mark"></i><span>收藏的文章</span>
</a>          </li>
          <li>
            <a href="/users/1b4935172ae0/liked_notes">
              <i class="iconfont ic-navigation-like"></i><span>喜欢的文章</span>
</a>          </li>
          <li>
            <a href="/my/paid_notes">
              <i class="iconfont ic-paid"></i><span>拥有的付费内容</span>
</a>          </li>
          <li>
            <a href="/wallet">
              <i class="iconfont ic-navigation-wallet"></i><span>我的钱包</span>
</a>          </li> -->
					<li><a href="/settings"> <i
							class="iconfont ic-navigation-settings"></i><span>设置</span>
					</a></li>
					<!-- <li>
            <a href="/faqs">
              <i class="iconfont ic-navigation-feedback"></i><span>帮助与反馈</span>
</a>          </li> -->
					<li><a rel="nofollow" data-method="delete" href="<%=request.getContextPath()%>/logOnTransit">
							<i class="iconfont ic-navigation-signout"></i><span>退出</span>
					</a></li>
				</ul>
			</div> --%>

			<div id="view-mode-ctrl"></div>
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#menu" aria-expanded="false">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
			</div>
		</div>
	</nav>



	<div class="container person">
		<div class="row">
			<div class="col-xs-16 main">
				<div class="main-top">
					<a class="avatar"
						href="<%=request.getContextPath()%>/u/${bloguser2.userId}_"> <img
						src="${bloguser2.headUrl }" alt="240" />
					</a>

					<div class="title">
						<a class="name"
							href="<%=request.getContextPath()%>/u/${bloguser2.userId }_">${bloguser2.nickName }</a>
						<!-- <i class="iconfont ic-man"></i> -->
					</div>
					<div class="info">
						<ul>
							<li>
								<!--  <div class="meta-block">
          <a href="/users/1b4935172ae0/following">
            <p>12</p>
            关注 <i class="iconfont ic-arrow"></i>
</a>        </div> -->
							</li>
							<li>
								<!-- <div class="meta-block">
          <a href="/users/1b4935172ae0/followers">
            <p>0</p>
            粉丝 <i class="iconfont ic-arrow"></i>
</a>        </div> -->
							</li>
							<li>
								<div class="meta-block">
									<a href="<%=request.getContextPath()%>/u/${bloguser2.userId }_">
										<p>${articlenum}</p> 文章 <i class="iconfont ic-arrow"></i>
									</a>
								</div>
							</li>
							<li>
								<div class="meta-block">
									<p>${textnum }</p>
									<div>字数</div>
								</div>
							</li>
							<li>
								<!--  <div class="meta-block">
          <p>1</p>
          <div>收获喜欢</div>
        </div> -->
							</li>
						</ul>
					</div>
				</div>

				<ul class="trigger-menu" data-pjax-container="#list-container">
					<li class="active"><a
						href="<%=request.getContextPath()%>/u/${bloguser2.userId}_"><i
							class="iconfont ic-articles"></i> 文章</a></li>
					<!-- <li class=""><a href="/users/1b4935172ae0/timeline"><i class="iconfont ic-feed"></i> 动态</a></li><li class=""><a href="/u/1b4935172ae0?order_by=commented_at"><i class="iconfont ic-latestcomments"></i> 最新评论</a></li><li class=""><a href="/u/1b4935172ae0?order_by=top"><i class="iconfont ic-hot"></i> 热门</a></li>-->
				</ul>

				<div id="list-container">
					<!-- 文章列表模块 -->
					<ul class="note-list"
						infinite-scroll-url="<%=request.getContextPath()%>/u">


						<li id="note-18527713" data-note-id="18527713" class=""><c:forEach
								items="${ blogdatalist}" var="list">
								<div class="content">
									<div class="author">
										<a class="avatar" target="_blank"
											href="<%=request.getContextPath()%>/u/${bloguser2.userId}_">
											<img src="${bloguser2.headUrl}" alt="64" />
										</a>
										<div class="info">
											<a class="nickname" target="_blank"
												href="<%=request.getContextPath()%>/u/${bloguser2.userId}_">${bloguser2.nickName}</a>
											<span class="time" data-shared-at="${list.createblogDate }">${list.createblogDate }</span>
										</div>
									</div>
									<a class="title" target="_blank"
										href="<%=request.getContextPath()%>/b/${list.blogId}">${list.title }</a>
									<p class="abstract">${list.blogContent }...</p>
									<div class="meta">

										<!-- <a target="_blank" href="/p/01fe34f5d7f9">
        <i class="iconfont ic-list-read"></i> 0
</a>     -->
										<a target="_blank" href="/p/01fe34f5d7f9#comments"> <i
											class="iconfont ic-list-comments"></i> 0
										</a> <span><i class="iconfont ic-list-like"></i> 1</span>
									</div>
								</div>
							</c:forEach> <%-- <div class="content">
								<div class="author">
									<a class="avatar" target="_blank" href="<%=request.getContextPath()%>/u/"> <img
										src="//upload.jianshu.io/users/upload_avatars/2043581/776f30d3-02e5-4595-be5a-14249af2322c.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/64/h/64"
										alt="64" />
									</a>
									<div class="info">
										<a class="nickname" target="_blank" href="/u/1b4935172ae0">EdpEternals</a>
										<span class="time" data-shared-at="2017-10-19T10:29:37+08:00"></span>
									</div>
								</div>
								<a class="title" target="_blank" href="/p/01fe34f5d7f9">找一个你很珍惜的人谈恋爱</a>
								<p class="abstract">
									我和她是在一家公司认识的，依稀记得那样在等电梯，她带了个帽子，(就那种休闲的帽子)，我们一起近了电梯，夹杂了很多上班族。其中不乏我们公司的(当然那时候还不认识公司同事)，而她...
								</p>
								<div class="meta">

									<!-- <a target="_blank" href="/p/01fe34f5d7f9">
        <i class="iconfont ic-list-read"></i> 0
</a>     -->
									<a target="_blank" href="/p/01fe34f5d7f9#comments"> <i
										class="iconfont ic-list-comments"></i> 0
									</a> <span><i class="iconfont ic-list-like"></i> 1</span>
								</div>
							</div> --%></li>

					</ul>

				</div>
			</div>

			<!-- <div class="col-xs-7 col-xs-offset-1 aside">
    <div class="title">个人介绍</div>
    <a class="function-btn" data-action="start-edit-intro" href="javascript:void(0)"><i class="iconfont ic-edit-s"></i>编辑</a>
    <form class="profile-edit js-intro-form" data-type="json" id="edit_user_2043581" action="/users/1b4935172ae0" accept-charset="UTF-8" data-remote="true" method="post"><input name="utf8" type="hidden" value="&#x2713;" /><input type="hidden" name="_method" value="patch" />
      <textarea name="user[intro]" id="user_intro">
hello  it!fffffsfsvdsfsfsf</textarea>
      <input type="submit" name="commit" value="保存" class="btn btn-hollow" data-action="save-edit-intro" data-disable-with="保存" />
      <a data-action="cancel-edit-intro" href="javascript:void(null);">取消</a>
</form>  <div class="description">
    <div class="js-intro">hello  it!fffffsfsvdsfsfsf</div>
    
    
  </div>
  <div class="publication-list"></div>
  <div class="course-list"></div>
  <ul class="list user-dynamic">
    <li>
      <a href="/users/1b4935172ae0/subscriptions">
        <i class="iconfont ic-collection"></i> <span>我关注的专题/文集/连载</span>
</a>    </li>
    <li>
      <a href="/users/1b4935172ae0/liked_notes">
        <i class="iconfont ic-like"></i> <span>我喜欢的文章</span>
</a>    </li>
  </ul>
  专题和文集
  <div class="js-collection-and-notebook-container"></div>
</div> -->

		</div>
	</div>
	<!-- <div data-vcomp="side-tool"></div> -->

	<script type="application/json" data-name="page-data">{"user_signed_in":true,"locale":"zh-CN","os":"mac","read_mode":"day","read_font":"font1","current_user":{"id":2043581,"nickname":"EdpEternals","slug":"1b4935172ae0","avatar":"http://upload.jianshu.io/users/upload_avatars/2043581/776f30d3-02e5-4595-be5a-14249af2322c.jpg","unread_counts":{"chats":0,"total":0}},"user":{"slug":"1b4935172ae0","gender":1},"has_collections":false}</script>

	<script
		src="<%=request.getContextPath()%>/js/babel-polyfill-fe4aded7942fe8b49646.js"
		crossorigin="anonymous"></script>
	<script
		src="<%=request.getContextPath()%>/js/web-base-290befdd384a475f76ea.js"
		crossorigin="anonymous"></script>
	<script
		src="<%=request.getContextPath()%>/js/web-205b445056d60cf9b3c7.js"
		crossorigin="anonymous"></script>

	<script
		src="<%=request.getContextPath()%>/js/entry-454d82eced543c5b003c.js"
		crossorigin="anonymous"></script>
	<!-- <script>
		(function() {
			var bp = document.createElement('script');
			var curProtocol = window.location.protocol.split(':')[0];
			if (curProtocol === 'https') {
				bp.src = 'https://zz.bdstatic.com/linksubmit/push.js';
			} else {
				bp.src = 'http://push.zhanzhang.baidu.com/push.js';
			}
			var s = document.getElementsByTagName("script")[0];
			s.parentNode.insertBefore(bp, s);
		})();
	</script> -->

</body>
</html>