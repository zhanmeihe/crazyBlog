<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.util.*"%>
<%@ page import="java.net.URLDecoder"%>
<%@ page import="sun.misc.BASE64Decoder"%>

<!DOCTYPE html>
<!--[if IE 6]><html class="ie lt-ie8"><![endif]-->
<!--[if IE 7]><html class="ie lt-ie8"><![endif]-->
<!--[if IE 8]><html class="ie ie8"><![endif]-->
<!--[if IE 9]><html class="ie ie9"><![endif]-->
<!--[if !IE]><!-->
<html>
<!--<![endif]-->

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0,user-scalable=no">

<!-- Start of Baidu Transcode -->
<meta name="referrer" content="never">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<meta http-equiv="Cache-Control" content="no-transform" />
<meta name="applicable-device" content="pc,mobile">
<meta name="MobileOptimized" content="width" />
<meta name="HandheldFriendly" content="true" />
<meta name="mobile-agent"
	content="format=html5;url=https://www.jianshu.com/p/48b39838a1f1">
<!-- End of Baidu Transcode -->

<meta name="description" content="${content }...">

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
	content="format=html5; url=https://www.jianshu.com/p/48b39838a1f1">

<!-- Apple -->
<meta name="apple-mobile-web-app-title" content="疯狂博客">

<!--  Meta for Smart App Banner -->
<meta name="apple-itunes-app"
	content="app-id=888237539, app-argument=jianshu://notes/24886681">
<!-- End -->

<!--  Meta for Twitter Card -->
<meta content="summary" property="twitter:card">
<meta content="疯狂博客" property="twitter:site">
<meta content="${blogdetail.title }" property="twitter:title">
<meta content="${content}..." property="twitter:description">
<meta content="<%=request.getContextPath()%>/b/${ blogdetail.blogId}"
	property="twitter:url">
<!-- End -->

<!--  Meta for OpenGraph -->
<meta property="fb:app_id" content="865829053512461">
<meta property="og:site_name" content="疯狂博客">
<meta property="og:title" content="${blogdetail.title }">
<meta property="og:type" content="article">
<meta property="og:url"
	content="<%=request.getContextPath()%>/b/${blogdetail.blogId}">
<meta property="og:description" content="${content }...">
<!-- End -->

<!--  Meta for Facebook Applinks -->

<meta property="al:ios:app_store_id" content="888237539" />
<meta property="al:ios:app_name" content="疯狂博客" />

<meta property="al:android:app_name" content="疯狂博客" />
<!-- End -->


<title>${blogdetail.title }-疯狂博客</title>


<link rel="stylesheet" media="all"
	href="<%=request.getContextPath()%>/css/web-1.css" />
<link rel="stylesheet" media="all"
	href="<%=request.getContextPath()%>/css/entry-a9201972e0c141d2fe27.css" />
<style type="text/css">
@charset "UTF-8";
/*
 * 变量
*/
.like[data-v-6ddd02c6] {
	display: inline-block;
}

.like .like-group[data-v-6ddd02c6] {
	position: relative;
	padding: 13px 0 15px 0;
	font-size: 0;
	border: 1px solid black;
	border-radius: 40px;
}

.like .like-group[data-v-6ddd02c6]:hover {
	background-color: rgba(236, 97, 73, 0.05);
}

.like .like-group .btn-like[data-v-6ddd02c6] {
	display: inline-block;
	font-size: 19px;
}

.like .like-group .btn-like[data-v-6ddd02c6]:before {
	content: '';
	position: absolute;
	left: 12px;
	top: 2px;
	width: 50px;
	height: 50px;
	background-image:
		url(https://cdn2.jianshu.io/assets/web/like_animation_steps-62a00a7b52377d3069927cdb8e61fd34.png);
	background-position: left;
	background-repeat: no-repeat;
	background-size: 1000px 50px;
}

.like .like-group .btn-like a[data-v-6ddd02c6] {
	position: relative;
	padding: 18px 30px 18px 55px;
	color: #EA6F5A;
}

.like .like-group .modal-wrap[data-v-6ddd02c6] {
	font-size: 18px;
	border-left: 1px solid rgba(236, 97, 73, 0.4);
	display: inline-block;
	margin-left: -15px;
}

.like .like-group .modal-wrap a[data-v-6ddd02c6] {
	color: #EA6F5A;
	padding: 18px 26px 18px 18px;
}

.like .like-group.like-animation[data-v-6ddd02c6],.like .like-group.active[data-v-6ddd02c6]
	{
	background-color: black;
}

.like .like-group.like-animation .btn-like a[data-v-6ddd02c6],.like .like-group.active .btn-like a[data-v-6ddd02c6]
	{
	color: white;
}

.like .like-group.like-animation .modal-wrap[data-v-6ddd02c6],.like .like-group.active .modal-wrap[data-v-6ddd02c6]
	{
	border-left: 1px solid white;
}

.like .like-group.like-animation .modal-wrap a[data-v-6ddd02c6],.like .like-group.active .modal-wrap a[data-v-6ddd02c6]
	{
	color: white;
}

.like .like-group.like-animation .btn-like[data-v-6ddd02c6]:before {
	-webkit-animation: likeBlast-data-v-6ddd02c6 0.6s 1 steps(19);
	animation: likeBlast-data-v-6ddd02c6 0.6s 1 steps(19);
	background-position: right;
}

@
-webkit-keyframes likeBlast { 0% {
	background-position: left;
}

100%
{
background-position




:


 


right




;
}
}
@
keyframes likeBlast-data-v-6ddd02c6 { 0% {
	background-position: left;
}

100%
{
background-position




:


 


right




;
}
}
.like .like-group.active .btn-like[data-v-6ddd02c6]:before {
	background-position: right;
}
</style>

<link rel="stylesheet" media="all"
	href="<%=request.getContextPath()%>/css/entry.css" />
<link href="<%=request.getContextPath()%>/css/base.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/index.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/images/logo.ico"
	rel="shortcut icon" type="image/x-icon">
<!-- Start of 访问统计 -->
<script type="text/javascript">

window.onload = function () { 
	
	<%-- $.ajax({
	    url : '${pageContext.request.contextPath}/writepl',
	    data : $("#writeCom").serialize(),
	    type : 'POST', 
	    dataType : 'json', 
	    async:true, 
	    success : function(data,strStatus,xhr) {//这是个回调函数 data表示从action中传过来的json数据
	    	   $.each(data.object,function(i,n){  
	    		 //alert(n.blogId);
	    		 //alert(data.object[0].BlogId);
	    		 
	    		 var ss = "<div> <div class='author'><div data-v-f3bf5228='' class='v-tooltip-container' style='z-index: 0;'> <div class='v-tooltip-content'><a href='/u/f79de69d59e3' target='_blank' class='avatar'><img	src='//upload.jianshu.io/users/upload_avatars/4920384/b4f1c76b-52eb-427a-833a-91a1df9f9e56.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/114/h/114'></a></div></div<div class='info'><a href='/u/f79de69d59e3' target='_blank' class='name'>虬田</a>	<div class='meta'><span>6楼 · 2018.04.17 17:12</span></div></div>	</div><div class='comment-wrap'><p>体会到你的深深思念</p><div class='tool-group'>	<a data-v-cdecbe24='' id='like-button-22919309' class='like-button'><span data-v-cdecbe24=''>4人赞</span></a> <a	 class=''><i class='iconfont ic-comment'></i> <span>回复</span></a><a class='report'><span>举报</span></a>		</div></div></div>				";
	    		/**
					"<p>"+n.blogContent+"</p>"
	    		**/
                $("#comment-22919309").append(ss);  
	    		   $("#content").val("");
            });  
	    window.location = "<%=request.getContextPath()%>";
				}
	    
	    }); --%>
}
</script>
<script>
	var _hmt = _hmt || [];
	(function() {
		var hm = document.createElement("script");
		hm.src = "//hm.baidu.com/hm.js?0c0e9d9b1e7d617b3e6842e85b9fb068";
		var s = document.getElementsByTagName("script")[0];
		s.parentNode.insertBefore(hm, s);
	})();
</script>

<script type="text/javascript">

$(".like-btn").bind({  
    click:function(){  
        vote_like();  
        $(this).attr("rel",1);  
    }  
});  

function vote_like(){  
    $.ajax({  
        url: "${ROOT}/action/report_like.jsp",  
        type: "POST",  
        dataType: "json",  
        data: {reportId: "${report.reportId}"},  
        success: function (json) {  
            if (json.status == 1) {  
                var topele=$("#likeNum"),topcurrent = parseInt(topele.text());  
                $(".plus").show(0).stop(true).animate({"top":-18,opacity:0},500,function(){topele.text(topcurrent + 1);});  
            } else {  
                alert(json.msg);  
            }  
        }  
    });  
}  

</script>
<script type="text/javascript">

function verification() {
		var a = document.getElementById('likenum');
	 	var blogId = ${blogdetail.blogId};
	 	var userId = '${user.userId}';
		var s = a.innerText; 
		var d = s +',' + blogId +','+ userId;
	//alert(d);
	$.post("${pageContext.request.contextPath}/addZanIndel", {op : d}, 
			function(data) {
		data = parseInt($.trim(data));
			if(data < 0){
				alert("继续操作请注册或登录!");
				$("#errormassage").text("继续操作请注册或登录!").css("color", "red");
				window.location = "<%=request.getContextPath()%>/sign_login";
				/* alert("验证成功！"); */

			} else {
				$("#likenum").text(data);

			}

		});
	}
	
function sendPinglun() {
	
	var a = document.getElementById('likenum');
	var v = $.trim(document.getElementById('content').value);
	 
 	var blogId = ${blogdetail.blogId};
 	var userId = '${user.userId}';
	var s = a.innerText; 
	var d = s +',' + blogId +','+ userId;
	//alert(v);
	 if(v == ''){
			alert("评论内容不能为空！");
		} 
	if(userId == ''){
		alert("请登录操作评论！");
		window.location = "<%=request.getContextPath()%>/sign_login";
		 
	}
	else{
		$.ajax({
		    url : '${pageContext.request.contextPath}/writepl',
		    data : $("#writeCom").serialize(),
		    type : 'POST', 
		    dataType : 'json', 
		    async:true, 
		    success : function(data,strStatus,xhr) {//这是个回调函数 data表示从action中传过来的json数据
		    	   $.each(data.object,function(i,n){  
		    		 //alert(n.blogId);
		    		 //alert(data.object[0].BlogId);
		    		 
		    		 var ss = "<div> <div class='author'><div data-v-f3bf5228='' class='v-tooltip-container' style='z-index: 0;'> <div class='v-tooltip-content'><a href='/u/f79de69d59e3' target='_blank' class='avatar'><img	src='//upload.jianshu.io/users/upload_avatars/4920384/b4f1c76b-52eb-427a-833a-91a1df9f9e56.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/114/h/114'></a></div></div<div class='info'><a href='/u/f79de69d59e3' target='_blank' class='name'>虬田</a>	<div class='meta'><span>6楼 · 2018.04.17 17:12</span></div></div>	</div><div class='comment-wrap'><p>体会到你的深深思念</p><div class='tool-group'>	<a data-v-cdecbe24='' id='like-button-22919309' class='like-button'><span data-v-cdecbe24=''>4人赞</span></a> <a	 class=''><i class='iconfont ic-comment'></i> <span>回复</span></a><a class='report'><span>举报</span></a>		</div></div></div>				";
		    		/**
						"<p>"+n.blogContent+"</p>"
		    		**/
                    $("#comment-22919309").append(ss);  
		    		   $("#content").val("");
                });  
               /*  alert(data.code);
                alert(data.msg);
                alert(data.object[0].maxBlogId);
                alert(data.object.imageUrl); */
		   <%--  window.location = "<%=request.getContextPath()%>"; --%>
					}
		    
		    });
	}
	 <%-- $.ajax({
		    url : '${pageContext.request.contextPath}/writepl',
		    data : $("#writeCom").serialize(),
		    type : 'POST', 
		    //dataType : 'json', 
		    async:true, 
		    success : function(data,strStatus,xhr) {//这是个回调函数 data表示从action中传过来的json数据
		    	   $.each(data.object,function(i,n){  
		    		// alert(n.maxBlogId);
                   // $("#div1").append("<p>"+n.blogContent+"</p>");  
		    		   $("#content").val("");
                });  
               /*  alert(data.code);
                alert(data.msg);
                alert(data.object[0].maxBlogId);
                alert(data.object.imageUrl); */
		    window.location = "<%=request.getContextPath()%>";
					}
		    
		    }); --%>
//alert(d);
<%-- $.post("${pageContext.request.contextPath}/addZanIndel", {op : d}, 
		function(data) {
	data = parseInt($.trim(data));
		if(data < 0){
			alert("继续操作请注册或登录!");
			$("#errormassage").text("继续操作请注册或登录!").css("color", "red");
			window.location = "<%=request.getContextPath()%>/sign_login";
			/* alert("验证成功！"); */

		} else {
			$("#likenum").text(data);

		}

	}); --%>
}

function validateForm() {
	 
	var ids = $.trim($('input[name="userId"]').val());
	var pinglun = $.trim($('input[name="pinglun"]').val());
	
	if (ids == '') {
		alert('请登录操作评论！');
		return false;
	}
	 if (pinglun == '') {
		alert('评论内容不能为空！');
		return false;
	}/*
	 if (checkcode == '') {
		alert('请输入验证码');
		return false;
	}  */
	return true;
}
</script>
<%
	String user = "";
	String userid = "";
	Cookie cookies[] = request.getCookies();

	//out.println(" cookie的数量为：" + cookies.length);
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
	}

	//用户名解码展现
	/* if (user == null){
		user = null;
	}else if(user!=null){
		BASE64Decoder decoder = new BASE64Decoder();
	 
		byte[] b = decoder.decodeBuffer(user);
		user =  new String(b);
	} */
	/* if (user == null) {
		user = null;
	} else if (user != null) {
		BASE64Decoder decoder = new BASE64Decoder();

		byte[] b = decoder.decodeBuffer(user);
		user = new String(b);
	} */
%>


<!-- End of 访问统计 -->
</head>

<body lang="zh-CN" class="reader-song-font">
	<!-- 全局顶部导航栏 -->
	<!-- <span id = "errormassage" style="font-style: "></span> -->
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="width-limit">
			<!-- 左上方 Logo -->
			<a class="logo" href="<%=request.getContextPath()%>"><img
				src="<%=request.getContextPath()%>/images/logo.png" alt="疯狂博客" /></a>

			<!-- 右上角 -->
			<!-- 登录显示写文章 -->
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
			<a class="btn write-btn" target="_blank"
				href="<%=request.getContextPath()%>/editw"> <i
				class="iconfont ic-write"></i>撰写
			</a>

			<div class="user">
				<div data-hover="dropdown">
					<a class="avatar"
						href="<%=request.getContextPath()%>/u/${user.userId}_"><img
						src="${ user.headUrl}" alt="120" /></a>
				</div>
				<ul class="dropdown-menu">
					<li><a
						href="<%=request.getContextPath()%>/u/${user.userId}_"> <i
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

			<div id="view-mode-ctrl"></div>
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#menu" aria-expanded="false">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
				<%--     <div class="collapse navbar-collapse" id="menu">
        <ul class="nav navbar-nav">
<!--             <li class="tab ">
              <a href="/">
                <span class="menu-text">发现</span><i class="iconfont ic-navigation-discover menu-icon"></i>
</a>            </li>
             <li class="tab ">
              <a href="/subscriptions">
                <span class="menu-text">关注</span><i class="iconfont ic-navigation-follow menu-icon"></i>
</a>            </li>  
            <li class="tab notification v-notification-dropdown-menu ">
              <a class="notification-btn" href="/notifications" data-hover="dropdown">
                <span class="menu-text">消息</span>
                <i class="iconfont ic-navigation-notification menu-icon"></i>
                <span class="badge"></span>
              </a>
            </li> -->
          <li class="search">
            <form target="_blank" action="/search" accept-charset="UTF-8" method="get"><input name="utf8" type="hidden" value="&#x2713;" />
              <input type="text" name="q" id="q" value="" autocomplete="off" placeholder="搜索" class="search-input" />
              <a class="search-btn" href="javascript:void(null)"><i class="iconfont ic-search"></i></a>
</form>          </li>
        </ul>
      </div>  --%>
			</div>
		</div>
	</nav>


	<div class="note">
		<a target="_blank" href="/apps/download?utm_source=sbc"
			id="web-note-ad-fixed"><span class="close">&times;</span></a>
		<div class="post">
			<div class="article">
			 <div id = "div1"></div>
				<!-- <span id = "errormassage"></span> -->
				<h1 class="title">${blogdetail.title }</h1>

				<!-- 作者区域 -->
				<div class="author">
					<a class="avatar"
						href="<%=request.getContextPath()%>/u/${user2.userId}_"> <img
						src="${user2.headUrl }" alt="无" />
					</a>

					<div class="info">
						<span class="name"><a
							href="<%=request.getContextPath()%>/u/${user2.userId}_">${user2.nickName }</a></span>
						<!-- 关注用户按钮 -->
						<!--  <div props-data-classes="user-follow-button-header" data-author-follow-button></div> -->
						<!-- 文章数据信息 -->
						<div class="meta">
							<!-- 如果文章更新时间大于发布时间，那么使用 tooltip 显示更新时间 -->
							<span class="publish-time" data-toggle="tooltip"
								data-placement="bottom" title="最后编辑于 ${blogdetail.updateDate }">${blogdetail.createblogDate }</span>
							<span class="wordage">字数 ${num}</span>

						</div>
					</div>
					<!-- 如果是当前作者，加入编辑按钮 -->
				</div>




				<!-- 文章内容 -->
				<div data-note-content class="show-content">
					<div class="show-content-free">
						<div class="image-package">

							<c:set var="img" scope="session" value="${blogdetail.imageUrl}" />
							<c:if test="${img > ' '}">
								<div class="image-container"
									style="max-width: 510px; max-height: 484px;">
									<div class="image-container-fill"
										style="padding-bottom: 94.89999999999999%;"></div>
									<%--   <p>打印为: <c:out value="${img}"/><p>   --%>
									<div class="image-view" data-width="510" data-height="484">
										<img src="${ blogdetail.imageUrl}" data-original-width="510"
											data-original-height="484" data-original-format="image/png"
											data-original-filesize="367287">
									</div>
								</div>
							</c:if>
							<div class="image-caption"></div>
						</div>
						${blogdetail.blogContent}
					</div>
				</div>
			</div>

			<!-- 连载目录项 -->

			<!-- 打赏文章、购买文章、购买连载 -->
			<!-- <div data-vcomp="free-reward-panel"></div> -->
			<!-- 	 
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br> -->
			<br> <br> <br> <br>

			<!--       <div class="show-foot">
        <a class="notebook" href="/nb/11094599">
          <i class="iconfont ic-search-notebook"></i>
          <span>日记本</span>
</a>        <div class="copyright" data-toggle="tooltip" data-html="true" data-original-title="转载请联系作者获得授权，并标注“简书作者”。">
          © 著作权归作者所有
        </div>
        <div class="modal-wrap" data-report-note>
          <a id="report-modal">举报文章</a>
        </div>
      </div> -->

			<!-- 文章底部作者信息 -->
			<div class="follow-detail">
				<div class="info">
					<a class="avatar"
						href="<%=request.getContextPath()%>/u/${user2.userId }_"> <img
						src="${user2. headUrl}" alt="96" /> <!--  <a class="btn btn-success follow"><i class="iconfont ic-follow"></i><span>关注</span></a> -->
					</a>
					<div props-data-classes="user-follow-button-footer"
						data-author-follow-button></div>
					<a class="title"
						href="<%=request.getContextPath()%>/u/${user2.userId }_">${user2.nickName}</a>
					<p>写了 70597 字，被 7271 人关注，获得了 15164 个喜欢</p>

				</div>
				<div class="signature">愿你自己成为太阳，驱散万里乌云，照亮来处去处，纵然身边无人守候，也可以拥有温暖自己的力量。</div>
			</div>


			<div class="meta-bottom">

				<div data-v-6ddd02c6="" class="like">
					<div data-v-6ddd02c6="" class="btn like-group">
						<div data-v-6ddd02c6="" class="btn-like">
							<a href="javascript:void(0);" onclick="verification()"
								data-v-6ddd02c6="">喜欢</a>
						</div>
						<div data-v-6ddd02c6="" class="modal-wrap">
							<a id="likenum" data-v-6ddd02c6="">${blogdetail.praiseCount }</a>
						</div>
					</div>
				</div>
				<!-- <div class="share-group">
        <a class="share-circle" data-action="weixin-share" data-toggle="tooltip" data-original-title="分享到微信">
          <i class="iconfont ic-wechat"></i>
        </a>
        <a class="share-circle" data-action="weibo-share" data-toggle="tooltip" href="javascript:void((function(s,d,e,r,l,p,t,z,c){var%20f='http://v.t.sina.com.cn/share/share.php?appkey=1881139527',u=z||d.location,p=['&amp;url=',e(u),'&amp;title=',e(t||d.title),'&amp;source=',e(r),'&amp;sourceUrl=',e(l),'&amp;content=',c||'gb2312','&amp;pic=',e(p||'')].join('');function%20a(){if(!window.open([f,p].join(''),'mb',['toolbar=0,status=0,resizable=1,width=440,height=430,left=',(s.width-440)/2,',top=',(s.height-430)/2].join('')))u.href=[f,p].join('');};if(/Firefox/.test(navigator.userAgent))setTimeout(a,0);else%20a();})(screen,document,encodeURIComponent,'','','http://cwb.assets.jianshu.io/notes/images/26669864/weibo/image_73e6c7c8e29a.jpg', '推荐 @诗音姑娘 的文章《普通本科考985、211，真的没有用吗？》（ 分享自 @简书 ）','https://www.jianshu.com/p/1b1d0bdae253?utm_campaign=maleskine&amp;utm_content=note&amp;utm_medium=reader_share&amp;utm_source=weibo','页面编码gb2312|utf-8默认gb2312'));" data-original-title="分享到微博">
          <i class="iconfont ic-weibo"></i>
        </a>
          <a class="share-circle" data-toggle="tooltip" href="http://cwb.assets.jianshu.io/notes/images/26669864/weibo/image_73e6c7c8e29a.jpg" target="_blank" data-original-title="下载长微博图片">
            <i class="iconfont ic-picture"></i>
          </a>
        <a class="share-circle more-share" tabindex="0" data-toggle="popover" data-placement="top" data-html="true" data-trigger="focus" href="javascript:void(0);" data-content="
          <ul class=&quot;share-list&quot;>
            <li><a href=&quot;javascript:void(function(){var d=document,e=encodeURIComponent,r='http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?url='+e('https://www.jianshu.com/p/1b1d0bdae253?utm_campaign=maleskine&amp;utm_content=note&amp;utm_medium=reader_share&amp;utm_source=qzone')+'&amp;title='+e('推荐 诗音姑娘 的文章《普通本科考985、211，真的没有用吗？》'),x=function(){if(!window.open(r,'qzone','toolbar=0,resizable=1,scrollbars=yes,status=1,width=600,height=600'))location.href=r};if(/Firefox/.test(navigator.userAgent)){setTimeout(x,0)}else{x()}})();&quot;><i class=&quot;social-icon-sprite social-icon-zone&quot;></i><span>分享到QQ空间</span></a></li>
            <li><a href=&quot;javascript:void(function(){var d=document,e=encodeURIComponent,r='https://twitter.com/share?url='+e('https://www.jianshu.com/p/1b1d0bdae253?utm_campaign=maleskine&amp;utm_content=note&amp;utm_medium=reader_share&amp;utm_source=twitter')+'&amp;text='+e('推荐 诗音姑娘 的文章《普通本科考985、211，真的没有用吗？》（ 分享自 @jianshucom ）')+'&amp;related='+e('jianshucom'),x=function(){if(!window.open(r,'twitter','toolbar=0,resizable=1,scrollbars=yes,status=1,width=600,height=600'))location.href=r};if(/Firefox/.test(navigator.userAgent)){setTimeout(x,0)}else{x()}})();&quot;><i class=&quot;social-icon-sprite social-icon-twitter&quot;></i><span>分享到Twitter</span></a></li>
            <li><a href=&quot;javascript:void(function(){var d=document,e=encodeURIComponent,r='https://www.facebook.com/dialog/share?app_id=483126645039390&amp;display=popup&amp;href=https://www.jianshu.com/p/1b1d0bdae253?utm_campaign=maleskine&amp;utm_content=note&amp;utm_medium=reader_share&amp;utm_source=facebook',x=function(){if(!window.open(r,'facebook','toolbar=0,resizable=1,scrollbars=yes,status=1,width=450,height=330'))location.href=r};if(/Firefox/.test(navigator.userAgent)){setTimeout(x,0)}else{x()}})();&quot;><i class=&quot;social-icon-sprite social-icon-facebook&quot;></i><span>分享到Facebook</span></a></li>
            <li><a href=&quot;javascript:void(function(){var d=document,e=encodeURIComponent,r='https://plus.google.com/share?url='+e('https://www.jianshu.com/p/1b1d0bdae253?utm_campaign=maleskine&amp;utm_content=note&amp;utm_medium=reader_share&amp;utm_source=google_plus'),x=function(){if(!window.open(r,'google_plus','toolbar=0,resizable=1,scrollbars=yes,status=1,width=450,height=330'))location.href=r};if(/Firefox/.test(navigator.userAgent)){setTimeout(x,0)}else{x()}})();&quot;><i class=&quot;social-icon-sprite social-icon-google&quot;></i><span>分享到Google+</span></a></li>
            <li><a href=&quot;javascript:void(function(){var d=document,e=encodeURIComponent,s1=window.getSelection,s2=d.getSelection,s3=d.selection,s=s1?s1():s2?s2():s3?s3.createRange().text:'',r='http://www.douban.com/recommend/?url='+e('https://www.jianshu.com/p/1b1d0bdae253?utm_campaign=maleskine&amp;utm_content=note&amp;utm_medium=reader_share&amp;utm_source=douban')+'&amp;title='+e('普通本科考985、211，真的没有用吗？')+'&amp;sel='+e(s)+'&amp;v=1',x=function(){if(!window.open(r,'douban','toolbar=0,resizable=1,scrollbars=yes,status=1,width=450,height=330'))location.href=r+'&amp;r=1'};if(/Firefox/.test(navigator.userAgent)){setTimeout(x,0)}else{x()}})()&quot;><i class=&quot;social-icon-sprite social-icon-douban&quot;></i><span>分享到豆瓣</span></a></li>
          </ul>
        " data-original-title="" title="">更多分享</a>
      </div> -->
			</div>
			<div id="comment-list" class="comment-list">
				<div>
					<form class="new-comment" id = "writeCom" onsubmit="return validateForm();">
					  <c:set var="img" scope="session" value="${user. headUrl}" />  
							<c:choose>
								<c:when test="${img> ' ' }">
								<a class="avatar"><img
							src="${user. headUrl}"></a>
								</c:when>
								<c:otherwise>
								  <a class="avatar"><img
							src="<%=request.getContextPath()%>/images/timg.jpeg"></a>  
								</c:otherwise>
							</c:choose>
						
						<textarea name="pinglun" id = "content"  placeholder="评论..."></textarea>
						<div class="write-function-block">
						<input type="hidden" name="bolgId" value="${blogdetail.blogId}"/>
						<input type="hidden" name="userId" value="${user.userId }"/> 
						<a  href="javascript:void(0);" onclick="sendPinglun()" class="btn btn-send">发送</a> 
							<!-- <a class="cancel">取消</a> -->
						</div>
					</form>
					<!---->
				</div>
				<div id="normal-comment-list" class="normal-comment-list">
					<div>
						<div>
							<div class="top-title">
								<span>161条评论</span>  
								 
							</div>
						</div>
						<!---->
						<!---->
						<div class="comments-placeholder" style="display: none;">
							<div class="author">
								<div class="avatar"></div>
								<div class="info">
									<div class="name"></div>
									<div class="meta"></div>
								</div>
							</div>
							<div class="text"></div>
							<div class="text animation-delay"></div>
							<div class="tool-group">
								<i class="iconfont ic-zan-active"></i>
								<div class="zan"></div>
								<i class="iconfont ic-list-comments"></i>
								<div class="zan"></div>
							</div>
						</div>
						<div id="comment-22919309" class="comment">
							<!-- <div>
								<div class="author">
									<div data-v-f3bf5228="" class="v-tooltip-container"
										style="z-index: 0;">
										<div class="v-tooltip-content">
											<a href="/u/f79de69d59e3" target="_blank" class="avatar"><img
												src="//upload.jianshu.io/users/upload_avatars/4920384/b4f1c76b-52eb-427a-833a-91a1df9f9e56.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/114/h/114"></a>
										</div>
										
									</div>
									<div class="info">
										<a href="/u/f79de69d59e3" target="_blank" class="name">虬田</a>
										
										
										<div class="meta">
											<span>6楼 · 2018.04.17 17:12</span>
										</div>
									</div>
								</div>
								<div class="comment-wrap">
									<p>体会到你的深深思念</p>
									<div class="tool-group">
										<a data-v-cdecbe24="" id="like-button-22919309"
											class="like-button"><span data-v-cdecbe24="">4人赞</span></a> <a
											class=""><i class="iconfont ic-comment"></i> <span>回复</span></a>
										<a class="report"><span>举报</span></a>
										
									</div>
								</div>
							</div> -->
							<!-- <div class="sub-comment-list">
								 
									 
											 
           
								 
										 
										 
								 
									 
					 
							<div>
								<div class="author">
									<div data-v-f3bf5228="" class="v-tooltip-container"
										style="z-index: 0;">
										<div class="v-tooltip-content">
											<a href="/u/fcf4fc8a6ba3" target="_blank" class="avatar"><img
												src="//upload.jianshu.io/users/upload_avatars/8516846/f1dbb01b-b194-4c90-b1f0-7aa094d3f9d1?imageMogr2/auto-orient/strip|imageView2/1/w/114/h/114"></a>  </div>
									</div> <div class="info">
										<a href="/u/fcf4fc8a6ba3" target="_blank" class="name">升号</a> <div
											class="meta">
											<span>12楼 · 2018.04.17 17:25</span>
										</div>
									</div>
								</div> <div class="comment-wrap">
									<p>棒棒哒</p> <div class="tool-group">
										<a data-v-cdecbe24="" id="like-button-22919815"
											class="like-button"><span data-v-cdecbe24="">4人赞</span></a> <a
											class=""><i class="iconfont ic-comment"></i> <span>回复</span></a> <a
											class="report"><span>举报</span></a>
									</div>
								</div>
							</div> <div class="sub-comment-list">
								<div id="comment-22919929" class="sub-comment">
									<p>
									<div data-v-f3bf5228="" class="v-tooltip-container"
										style="z-index: 0;">
										<div class="v-tooltip-content">
											<a href="/u/9617ac822dc6" target="_blank">山青青</a>：
            </div>
									</div> <span><a href="/users/fcf4fc8a6ba3"
										class="maleskine-author" target="_blank"
										data-user-slug="fcf4fc8a6ba3">@升号</a> 谢谢！</span>
									</p> <div class="sub-tool-group">
										<span>2018.04.17 17:29</span> <a class=""><i
											class="iconfont ic-comment"></i> <span>回复</span></a> <a
											class="report"><span>举报</span></a>
									</div>
								</div> <div class="sub-comment more-comment">
									<a class="add-comment-btn"><i
										class="iconfont ic-subcomment"></i> <span>添加新评论</span></a>
								</div>
							</div>
						</div>
						<div id="comment-22922462" class="comment">
							<div>
								<div class="author">
									<div data-v-f3bf5228="" class="v-tooltip-container"
										style="z-index: 0;">
										<div class="v-tooltip-content">
											<a href="/u/388da17cc571" target="_blank" class="avatar"><img
												src="//upload.jianshu.io/users/upload_avatars/8514864/9ffeec25-dbd7-4c79-8ddd-6c33b9820db5?imageMogr2/auto-orient/strip|imageView2/1/w/114/h/114"></a>  </div>
									</div> <div class="info">
										<a href="/u/388da17cc571" target="_blank" class="name">邢晓华</a> <div
											class="meta">
											<span>21楼 · 2018.04.17 18:50</span>
										</div>
									</div>
								</div> <div class="comment-wrap">
									<p>骨血相连，永远的父亲！🙏 🙏 🙏</p> <div class="tool-group">
										<a data-v-cdecbe24="" id="like-button-22922462"
											class="like-button"><span data-v-cdecbe24="">3人赞</span></a> <a
											class=""><i class="iconfont ic-comment"></i> <span>回复</span></a> <a
											class="report"><span>举报</span></a>
									</div>
								</div>
							</div> <div class="sub-comment-list">
								<div id="comment-22925312" class="sub-comment">
									<p>
									<div data-v-f3bf5228="" class="v-tooltip-container"
										style="z-index: 0;">
										<div class="v-tooltip-content">
											<a href="/u/9617ac822dc6" target="_blank">山青青</a>：
            </div>
									</div> <span><a href="/users/388da17cc571"
										class="maleskine-author" target="_blank"
										data-user-slug="388da17cc571">@邢晓华</a> 谢谢妹妹支持！</span>
									</p> <div class="sub-tool-group">
										<span>2018.04.17 20:14</span> <a class=""><i
											class="iconfont ic-comment"></i> <span>回复</span></a> <a
											class="report"><span>举报</span></a>
									</div>
								</div> <div class="sub-comment more-comment">
									<a class="add-comment-btn"><i
										class="iconfont ic-subcomment"></i> <span>添加新评论</span></a>
								</div>
							</div>
						</div>
						<div id="comment-22922594" class="comment">
							<div>
								<div class="author">
									<div data-v-f3bf5228="" class="v-tooltip-container"
										style="z-index: 0;">
										<div class="v-tooltip-content">
											<a href="/u/7263bd8e7f19" target="_blank" class="avatar"><img
												src="//upload.jianshu.io/users/upload_avatars/8518919/ed285f05-156c-4a18-b73e-8dbc4a60bdfa?imageMogr2/auto-orient/strip|imageView2/1/w/114/h/114"></a>  </div>
									</div> <div class="info">
										<a href="/u/7263bd8e7f19" target="_blank" class="name">海棠银杏枫</a> <div
											class="meta">
											<span>23楼 · 2018.04.17 18:54</span>
										</div>
									</div>
								</div> <div class="comment-wrap">
									<p>写得非常感人。从一直以来掩藏自己，到如今敢于直面内心的痛苦、委屈和失落，这是一种飞跃和成长。其实正像你文中说的，父亲这个名字已经刻在了你的生命里，父女之间的纽带是刻骨铭心的，无论你是否敢于正视它，它都会一直在那里。这就是血浓于水。赞！</p> <div
										class="tool-group">
										<a data-v-cdecbe24="" id="like-button-22922594"
											class="like-button"><span data-v-cdecbe24="">3人赞</span></a> <a
											class=""><i class="iconfont ic-comment"></i> <span>回复</span></a> <a
											class="report"><span>举报</span></a>
									</div>
								</div>
							</div> <div class="sub-comment-list">
								<div id="comment-22925272" class="sub-comment">
									<p>
									<div data-v-f3bf5228="" class="v-tooltip-container"
										style="z-index: 0;">
										<div class="v-tooltip-content">
											<a href="/u/9617ac822dc6" target="_blank">山青青</a>：
            </div>
									</div> <span><a href="/users/7263bd8e7f19"
										class="maleskine-author" target="_blank"
										data-user-slug="7263bd8e7f19">@海棠银杏枫</a> 谢谢如此细心点评，不愧是知心好友，抱一下！🌺🌺🌺</span>
									</p> <div class="sub-tool-group">
										<span>2018.04.17 20:13</span> <a class=""><i
											class="iconfont ic-comment"></i> <span>回复</span></a> <a
											class="report"><span>举报</span></a>
									</div>
								</div> <div class="sub-comment more-comment">
									<a class="add-comment-btn"><i
										class="iconfont ic-subcomment"></i> <span>添加新评论</span></a>
								</div>
							</div>
						</div>
						<div id="comment-22924432" class="comment">
							<div>
								<div class="author">
									<div data-v-f3bf5228="" class="v-tooltip-container"
										style="z-index: 0;">
										<div class="v-tooltip-content">
											<a href="/u/352f7983e92c" target="_blank" class="avatar"><img
												src="//upload.jianshu.io/users/upload_avatars/8515461/aaa3385b-7bce-47bd-a28f-84e9fbd7b7f8?imageMogr2/auto-orient/strip|imageView2/1/w/114/h/114"></a>  </div>
									</div> <div class="info">
										<a href="/u/352f7983e92c" target="_blank" class="name">美丽芬芳_b8eb</a> <div
											class="meta">
											<span>29楼 · 2018.04.17 19:48</span>
										</div>
									</div>
								</div> <div class="comment-wrap">
									<p>爸爸没能停留在记忆里，却流淌在血液中。I文笔流畅，值得拜读。</p> <div class="tool-group">
										<a data-v-cdecbe24="" id="like-button-22924432"
											class="like-button"><span data-v-cdecbe24="">3人赞</span></a> <a
											class=""><i class="iconfont ic-comment"></i> <span>回复</span></a> <a
											class="report"><span>举报</span></a>
									</div>
								</div>
							</div> <div class="sub-comment-list">
								<div id="comment-22925127" class="sub-comment">
									<p>
									<div data-v-f3bf5228="" class="v-tooltip-container"
										style="z-index: 0;">
										<div class="v-tooltip-content">
											<a href="/u/9617ac822dc6" target="_blank">山青青</a>：
            </div>
									</div> <span><a href="/users/352f7983e92c"
										class="maleskine-author" target="_blank"
										data-user-slug="352f7983e92c">@美丽芬芳_b8eb</a> 谢谢妹妹支持！</span>
									</p> <div class="sub-tool-group">
										<span>2018.04.17 20:09</span> <a class=""><i
											class="iconfont ic-comment"></i> <span>回复</span></a> <a
											class="report"><span>举报</span></a>
									</div>
								</div> <div class="sub-comment more-comment">
									<a class="add-comment-btn"><i
										class="iconfont ic-subcomment"></i> <span>添加新评论</span></a>
								</div>
							</div>
						</div>
						<div id="comment-22924650" class="comment">
							<div>
								<div class="author">
									<div data-v-f3bf5228="" class="v-tooltip-container"
										style="z-index: 0;">
										<div class="v-tooltip-content">
											<a href="/u/4541ddf92b6d" target="_blank" class="avatar"><img
												src="//upload.jianshu.io/users/upload_avatars/8516065/6962a419-b443-427d-b544-e4756b509ceb?imageMogr2/auto-orient/strip|imageView2/1/w/114/h/114"></a>  </div>
									</div> <div class="info">
										<a href="/u/4541ddf92b6d" target="_blank" class="name">方丽_d09a</a> <div
											class="meta">
											<span>30楼 · 2018.04.17 19:56</span>
										</div>
									</div>
								</div> <div class="comment-wrap">
									<p>文章写得非常感人。看完文章，早已成了泪水。爸爸——多么熟悉而又陌生的字眼</p> <div
										class="tool-group">
										<a data-v-cdecbe24="" id="like-button-22924650"
											class="like-button"><span data-v-cdecbe24="">3人赞</span></a> <a
											class=""><i class="iconfont ic-comment"></i> <span>回复</span></a> <a
											class="report"><span>举报</span></a>
									</div>
								</div>
							</div> <div class="sub-comment-list">
								<div id="comment-22925121" class="sub-comment">
									<p>
									<div data-v-f3bf5228="" class="v-tooltip-container"
										style="z-index: 0;">
										<div class="v-tooltip-content">
											<a href="/u/9617ac822dc6" target="_blank">山青青</a>：
            </div>
									</div> <span><a href="/users/4541ddf92b6d"
										class="maleskine-author" target="_blank"
										data-user-slug="4541ddf92b6d">@方丽_d09a</a> 抱抱妹妹！</span>
									</p> <div class="sub-tool-group">
										<span>2018.04.17 20:09</span> <a class=""><i
											class="iconfont ic-comment"></i> <span>回复</span></a> <a
											class="report"><span>举报</span></a>
									</div>
								</div> <div class="sub-comment more-comment">
									<a class="add-comment-btn"><i
										class="iconfont ic-subcomment"></i> <span>添加新评论</span></a>
								</div>
							</div>
						</div>
						<div id="comment-22930068" class="comment">
							<div>
								<div class="author">
									<div data-v-f3bf5228="" class="v-tooltip-container"
										style="z-index: 0;">
										<div class="v-tooltip-content">
											<a href="/u/7ce0b9144aad" target="_blank" class="avatar"><img
												src="//cdn2.jianshu.io/assets/default_avatar/1-04bbeead395d74921af6a4e8214b4f61.jpg"></a>  </div>
									</div> <div class="info">
										<a href="/u/7ce0b9144aad" target="_blank" class="name">食之乐</a> <div
											class="meta">
											<span>35楼 · 2018.04.17 22:14</span>
										</div>
									</div>
								</div> <div class="comment-wrap">
									<p>父亲，是个血融于水的话题。细细读你的文章，能够感受浓浓的思父之情！为你的文章喝彩，为你的从小失去父爱而遗憾！</p> <div
										class="tool-group">
										<a data-v-cdecbe24="" id="like-button-22930068"
											class="like-button"><span data-v-cdecbe24="">3人赞</span></a> <a
											class=""><i class="iconfont ic-comment"></i> <span>回复</span></a> <a
											class="report"><span>举报</span></a>
									</div>
								</div>
							</div> <div class="sub-comment-list">
								<div id="comment-22935491" class="sub-comment">
									<p>
									<div data-v-f3bf5228="" class="v-tooltip-container"
										style="z-index: 0;">
										<div class="v-tooltip-content">
											<a href="/u/9617ac822dc6" target="_blank">山青青</a>：
            </div>
									</div> <span><a href="/users/7ce0b9144aad"
										class="maleskine-author" target="_blank"
										data-user-slug="7ce0b9144aad">@食之乐</a> 谢谢乐乐，早安！</span>
									</p> <div class="sub-tool-group">
										<span>2018.04.18 05:09</span> <a class=""><i
											class="iconfont ic-comment"></i> <span>回复</span></a> <a
											class="report"><span>举报</span></a>
									</div>
								</div> <div class="sub-comment more-comment">
									<a class="add-comment-btn"><i
										class="iconfont ic-subcomment"></i> <span>添加新评论</span></a>
								</div>
							</div>
						</div>
						<div id="comment-22935103" class="comment">
							<div>
								<div class="author">
									<div data-v-f3bf5228="" class="v-tooltip-container"
										style="z-index: 0;">
										<div class="v-tooltip-content">
											<a href="/u/d56fd284a85f" target="_blank" class="avatar"><img
												src="//upload.jianshu.io/users/upload_avatars/4021594/ad87f6376c12.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/114/h/114"></a>  </div>
									</div> <div class="info">
										<a href="/u/d56fd284a85f" target="_blank" class="name">直笔公心</a> <div
											class="meta">
											<span>40楼 · 2018.04.18 02:30</span>
										</div>
									</div>
								</div> <div class="comment-wrap">
									<p>🙏</p> <div class="tool-group">
										<a data-v-cdecbe24="" id="like-button-22935103"
											class="like-button"><span data-v-cdecbe24="">3人赞</span></a> <a
											class=""><i class="iconfont ic-comment"></i> <span>回复</span></a> <a
											class="report"><span>举报</span></a>
									</div>
								</div>
							</div> <div class="sub-comment-list">
								<div id="comment-22935466" class="sub-comment">
									<p>
									<div data-v-f3bf5228="" class="v-tooltip-container"
										style="z-index: 0;">
										<div class="v-tooltip-content">
											<a href="/u/9617ac822dc6" target="_blank">山青青</a>：
            </div>
									</div> <span><a href="/users/d56fd284a85f"
										class="maleskine-author" target="_blank"
										data-user-slug="d56fd284a85f">@直笔公心</a> 谢谢友友！</span>
									</p> <div class="sub-tool-group">
										<span>2018.04.18 05:06</span> <a class=""><i
											class="iconfont ic-comment"></i> <span>回复</span></a> <a
											class="report"><span>举报</span></a>
									</div>
								</div> <div class="sub-comment more-comment">
									<a class="add-comment-btn"><i
										class="iconfont ic-subcomment"></i> <span>添加新评论</span></a>
								</div>
							</div>
						</div>
						<div id="comment-22918891" class="comment">
							<div>
								<div class="author">
									<div data-v-f3bf5228="" class="v-tooltip-container"
										style="z-index: 0;">
										<div class="v-tooltip-content">
											<a href="/u/e6bb5a8bd8d1" target="_blank" class="avatar"><img
												src="//upload.jianshu.io/users/upload_avatars/4590039/7a835149da87.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/114/h/114"></a>  </div>
									</div> <div class="info">
										<a href="/u/e6bb5a8bd8d1" target="_blank" class="name">paper_文</a> <div
											class="meta">
											<span>2楼 · 2018.04.17 17:00</span>
										</div>
									</div>
								</div> <div class="comment-wrap">
									<p>心里好难过，能够感受那种矛盾的心情。</p> <div class="tool-group">
										<a data-v-cdecbe24="" id="like-button-22918891"
											class="like-button"><span data-v-cdecbe24="">2人赞</span></a> <a
											class=""><i class="iconfont ic-comment"></i> <span>回复</span></a> <a
											class="report"><span>举报</span></a>
									</div>
								</div>
							</div> <div class="sub-comment-list">
								<div id="comment-22919489" class="sub-comment">
									<p>
									<div data-v-f3bf5228="" class="v-tooltip-container"
										style="z-index: 0;">
										<div class="v-tooltip-content">
											<a href="/u/9617ac822dc6" target="_blank">山青青</a>：
            </div>
									</div> <span><a href="/users/e6bb5a8bd8d1"
										class="maleskine-author" target="_blank"
										data-user-slug="e6bb5a8bd8d1">@paper_文</a> 谢谢理解支持！</span>
									</p> <div class="sub-tool-group">
										<span>2018.04.17 17:16</span> <a class=""><i
											class="iconfont ic-comment"></i> <span>回复</span></a> <a
											class="report"><span>举报</span></a>
									</div>
								</div> <div class="sub-comment more-comment">
									<a class="add-comment-btn"><i
										class="iconfont ic-subcomment"></i> <span>添加新评论</span></a>
								</div>
							</div>
						</div>
						<div id="comment-22918959" class="comment">
							<div>
								<div class="author">
									<div data-v-f3bf5228="" class="v-tooltip-container"
										style="z-index: 0;">
										<div class="v-tooltip-content">
											<a href="/u/a02ad1baf3c7" target="_blank" class="avatar"><img
												src="//upload.jianshu.io/users/upload_avatars/7085056/cb702208-fd4b-4a07-8401-ae061e6b2b34?imageMogr2/auto-orient/strip|imageView2/1/w/114/h/114"></a>  </div>
									</div> <div class="info">
										<a href="/u/a02ad1baf3c7" target="_blank" class="name">聿禾</a> <div
											class="meta">
											<span>3楼 · 2018.04.17 17:02</span>
										</div>
									</div>
								</div> <div class="comment-wrap">
									<p>好文</p> <div class="tool-group">
										<a data-v-cdecbe24="" id="like-button-22918959"
											class="like-button"><span data-v-cdecbe24="">2人赞</span></a> <a
											class=""><i class="iconfont ic-comment"></i> <span>回复</span></a> <a
											class="report"><span>举报</span></a>
									</div>
								</div>
							</div> <div class="sub-comment-list">
								<div id="comment-22919463" class="sub-comment">
									<p>
									<div data-v-f3bf5228="" class="v-tooltip-container"
										style="z-index: 0;">
										<div class="v-tooltip-content">
											<a href="/u/9617ac822dc6" target="_blank">山青青</a>：
            </div>
									</div> <span><a href="/users/a02ad1baf3c7"
										class="maleskine-author" target="_blank"
										data-user-slug="a02ad1baf3c7">@聿禾</a> 谢谢支持！</span>
									</p> <div class="sub-tool-group">
										<span>2018.04.17 17:15</span> <a class=""><i
											class="iconfont ic-comment"></i> <span>回复</span></a> <a
											class="report"><span>举报</span></a>
 
						</div> -->
					</div>
				</div> <!----> <div>
					<ul class="pagination">
						<!---->  <li><a href="javascript:void(null)" class="active">1</a></li> <li><a>2</a></li>
						<li><a>3</a></li>
						<li><a>4</a></li> <li><a>下一页</a></li>
					</ul>
				</div>
			</div>
			
										<%-- <div class="meta-bottom">
      <div class="btn like-group"></div>
      <div class="share-group">
        <a class="share-circle" data-action="weixin-share" data-toggle="tooltip" data-original-title="分享到微信">
          <i class="iconfont ic-wechat"></i>
        </a>
        <a class="share-circle" data-action="weibo-share" data-toggle="tooltip" href="javascript:void((function(s,d,e,r,l,p,t,z,c){var%20f=&#39;http://v.t.sina.com.cn/share/share.php?appkey=1881139527&#39;,u=z||d.location,p=[&#39;&amp;url=&#39;,e(u),&#39;&amp;title=&#39;,e(t||d.title),&#39;&amp;source=&#39;,e(r),&#39;&amp;sourceUrl=&#39;,e(l),&#39;&amp;content=&#39;,c||&#39;gb2312&#39;,&#39;&amp;pic=&#39;,e(p||&#39;&#39;)].join(&#39;&#39;);function%20a(){if(!window.open([f,p].join(&#39;&#39;),&#39;mb&#39;,[&#39;toolbar=0,status=0,resizable=1,width=440,height=430,left=&#39;,(s.width-440)/2,&#39;,top=&#39;,(s.height-430)/2].join(&#39;&#39;)))u.href=[f,p].join(&#39;&#39;);};if(/Firefox/.test(navigator.userAgent))setTimeout(a,0);else%20a();})(screen,document,encodeURIComponent,&#39;&#39;,&#39;&#39;,&#39;http://cwb.assets.jianshu.io/notes/images/24886681/weibo/image_91cdb366e1d3.jpg&#39;, &#39;推荐 林妖妖的盛夏光年 的文章《简书取消首页投稿，码字者何去何从？》（ 分享自 @简书 ）&#39;,&#39;https://www.jianshu.com/p/48b39838a1f1?utm_campaign=maleskine&amp;utm_content=note&amp;utm_medium=reader_share&amp;utm_source=weibo&#39;,&#39;页面编码gb2312|utf-8默认gb2312&#39;));" data-original-title="分享到微博">
          <i class="iconfont ic-weibo"></i>
        </a>
          <a class="share-circle" data-toggle="tooltip" href="http://cwb.assets.jianshu.io/notes/images/24886681/weibo/image_91cdb366e1d3.jpg" target="_blank" data-original-title="下载长微博图片">
            <i class="iconfont ic-picture"></i>
          </a>
        <a class="share-circle more-share" tabindex="0" data-toggle="popover" data-placement="top" data-html="true" data-trigger="focus" href="javascript:void(0);" data-content='
          <ul class="share-list">
            <li><a href="javascript:void(function(){var d=document,e=encodeURIComponent,r=&#39;http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?url=&#39;+e(&#39;https://www.jianshu.com/p/48b39838a1f1?utm_campaign=maleskine&amp;utm_content=note&amp;utm_medium=reader_share&amp;utm_source=qzone&#39;)+&#39;&amp;title=&#39;+e(&#39;推荐 林妖妖的盛夏光年 的文章《简书取消首页投稿，码字者何去何从？》&#39;),x=function(){if(!window.open(r,&#39;qzone&#39;,&#39;toolbar=0,resizable=1,scrollbars=yes,status=1,width=600,height=600&#39;))location.href=r};if(/Firefox/.test(navigator.userAgent)){setTimeout(x,0)}else{x()}})();"><i class="social-icon-sprite social-icon-zone"></i><span>分享到QQ空间</span></a></li>
            <li><a href="javascript:void(function(){var d=document,e=encodeURIComponent,r=&#39;https://twitter.com/share?url=&#39;+e(&#39;https://www.jianshu.com/p/48b39838a1f1?utm_campaign=maleskine&amp;utm_content=note&amp;utm_medium=reader_share&amp;utm_source=twitter&#39;)+&#39;&amp;text=&#39;+e(&#39;推荐 林妖妖的盛夏光年 的文章《简书取消首页投稿，码字者何去何从？》（ 分享自 @jianshucom ）&#39;)+&#39;&amp;related=&#39;+e(&#39;jianshucom&#39;),x=function(){if(!window.open(r,&#39;twitter&#39;,&#39;toolbar=0,resizable=1,scrollbars=yes,status=1,width=600,height=600&#39;))location.href=r};if(/Firefox/.test(navigator.userAgent)){setTimeout(x,0)}else{x()}})();"><i class="social-icon-sprite social-icon-twitter"></i><span>分享到Twitter</span></a></li>
            <li><a href="javascript:void(function(){var d=document,e=encodeURIComponent,r=&#39;https://www.facebook.com/dialog/share?app_id=483126645039390&amp;display=popup&amp;href=https://www.jianshu.com/p/48b39838a1f1?utm_campaign=maleskine&amp;utm_content=note&amp;utm_medium=reader_share&amp;utm_source=facebook&#39;,x=function(){if(!window.open(r,&#39;facebook&#39;,&#39;toolbar=0,resizable=1,scrollbars=yes,status=1,width=450,height=330&#39;))location.href=r};if(/Firefox/.test(navigator.userAgent)){setTimeout(x,0)}else{x()}})();"><i class="social-icon-sprite social-icon-facebook"></i><span>分享到Facebook</span></a></li>
            <li><a href="javascript:void(function(){var d=document,e=encodeURIComponent,r=&#39;https://plus.google.com/share?url=&#39;+e(&#39;https://www.jianshu.com/p/48b39838a1f1?utm_campaign=maleskine&amp;utm_content=note&amp;utm_medium=reader_share&amp;utm_source=google_plus&#39;),x=function(){if(!window.open(r,&#39;google_plus&#39;,&#39;toolbar=0,resizable=1,scrollbars=yes,status=1,width=450,height=330&#39;))location.href=r};if(/Firefox/.test(navigator.userAgent)){setTimeout(x,0)}else{x()}})();"><i class="social-icon-sprite social-icon-google"></i><span>分享到Google+</span></a></li>
            <li><a href="javascript:void(function(){var d=document,e=encodeURIComponent,s1=window.getSelection,s2=d.getSelection,s3=d.selection,s=s1?s1():s2?s2():s3?s3.createRange().text:&#39;&#39;,r=&#39;http://www.douban.com/recommend/?url=&#39;+e(&#39;https://www.jianshu.com/p/48b39838a1f1?utm_campaign=maleskine&amp;utm_content=note&amp;utm_medium=reader_share&amp;utm_source=douban&#39;)+&#39;&amp;title=&#39;+e(&#39;简书取消首页投稿，码字者何去何从？&#39;)+&#39;&amp;sel=&#39;+e(s)+&#39;&amp;v=1&#39;,x=function(){if(!window.open(r,&#39;douban&#39;,&#39;toolbar=0,resizable=1,scrollbars=yes,status=1,width=450,height=330&#39;))location.href=r+&#39;&amp;r=1&#39;};if(/Firefox/.test(navigator.userAgent)){setTimeout(x,0)}else{x()}})()"><i class="social-icon-sprite social-icon-douban"></i><span>分享到豆瓣</span></a></li>
          </ul>
        '>更多分享</a>
      </div>
    </div> --%>
			
									<div id="vue_comment"></div>
		</div>

		<div class="vue-side-tool" props-data-props-show-qr-code="0"></div>
	</div>

	<script type="application/json" data-name="page-data">{"user_signed_in":true,"locale":"zh-CN","os":"mac","read_mode":"day","read_font":"font1","current_user":{"id":2043581,"nickname":"EdpEternals","slug":"1b4935172ae0","avatar":"http://upload.jianshu.io/users/upload_avatars/2043581/776f30d3-02e5-4595-be5a-14249af2322c.jpg","unread_counts":{"chats":0,"total":0},"has_editable_collection":false},"note_show":{"is_martin_user":false,"is_author":false,"is_following_author":false,"is_liked_note":false,"follow_state":0,"uuid":"3457f7e0-bf30-48d0-a4f2-f62890b4ee6a"},"note":{"id":24886681,"slug":"48b39838a1f1","user_id":5341273,"notebook_id":11094599,"commentable":true,"likes_count":186,"views_count":5880,"public_wordage":1474,"comments_count":183,"total_rewards_count":3,"is_author":false,"paid_type":"free","paid_content_accessible":false,"author":{"nickname":"林妖妖的盛夏光年","total_wordage":265791,"followers_count":814,"total_likes_count":4628}}}</script>

	<script src="<%=request.getContextPath()%>/js/polyfill.js"
		crossorigin="anonymous"></script>
	<script src="<%=request.getContextPath()%>/js/web-base.js"
		crossorigin="anonymous"></script>
	<script src="<%=request.getContextPath()%>/js/web.js"
		crossorigin="anonymous"></script>

	<script src="<%=request.getContextPath()%>/js/entry.js"
		crossorigin="anonymous"></script>
	<script>
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
	</script>

</body>
</html>
