<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html> --%>

 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>蚁聊移动管理平台</title>
<link href="<%=request.getContextPath()%>/css/login-patch.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/jquery-1.7.2.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function(){
	if (window.self != window.top){
		top.location.href = window.location.href;			
	}
});
	/**
	**验证码
	**/
	function randCode(o){
		var url = $(o).attr('src');
		$(o).attr('src',url+'?t='+new Date());
	}
	/**
	**校验提交
	**/
	function validateForm(){
		var account = $.trim($('input[name="account"]').val());
		var passwd = $.trim($('input[name="passwd"]').val());
		var code = $.trim($('input[name="code"]').val());
		if (account == ''){
			alert('请输入用户名');
			return false;
		}
		if (passwd == ''){
			alert('请输入密码');
			return false;
		}
		if (code == ''){
			alert('请输入验证码');
			return false;
		}
		return true;
	}	
</script>

<script type="text/javascript">
function changge(){
var img=document.getElementById("yanzheng");
img.src=img.src+"?"; //意思是让图片重新加载一次 效果类似与直接刷新yanzhengma.jsp有了这个，就能让图片重新加载了
}
</script>
</head>
<body>
	<div id="login">
		<div id="login_header">
			<h1 class="login_logo"></h1>
			<div class="login_headerContent">
				<div class="navList">
					<ul>
						<li><a href="#">设为首页</a></li>
						<li><a href="#">反馈</a></li>
						<li><a href="#" target="_blank">帮助</a></li>
					</ul>
				</div>
				<div style="padding-top: 25px; padding-left: 25px;"><b style="font-size: 20px;">登录蚁聊移动管理平台</b></div>
			</div>
		</div>
		<div id="login_content">
			<div class="loginForm">
				<form method="post" action="security/doLogin.do" onsubmit="return validateForm();">
					<p>
						<label></label>
						<input type="text" name="account" size="20" class="login_input" value=""/>
					</p>
					<p>
						<label></label>
						<input type="password" name="passwd" size="20" class="login_input" value=""/>
					</p>
					<p>
						<label></label>
						<input class="code" name="code" type="text" size="5" />
						<span><img src="<%=request.getContextPath()%>/Checkimage" alt="" width="90" height="40" onclick="randCode(this);" style="" /></span>
					</p>
					<div class="login_bar">
						<input class="sub" type="submit" value=" " />
					</div>
				</form>
			</div>
			<div class="login_banner"></div>
			<div class="login_main">
				
				
			</div>
		</div>
		<div id="login_footer">
			Copyright &copy; 2013 www.burning mountain.com Inc. All Rights Reserved.
		</div>
	</div>
</body>
</html>