<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
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
						<label>用户名：</label>
						<input type="text" name="account" size="20" class="login_input" value=""/>
					</p>
					<p>
						<label>密码：</label>
						<input type="password" name="passwd" size="20" class="login_input" value=""/>
					</p>
					<p>
						<label>验证码：</label>
						<input class="code" name="code" type="text" size="5" />
						<span><img src="security/kaptchaImg.do" alt="" width="90" height="40" onclick="randCode(this);" style="" /></span>
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
</html> --%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="image/jpeg"
	import="java.awt.*,java.awt.image.*,java.util.*,javax.imageio.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'MyJsp.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
<link rel="stylesheet" type="text/css" href="styles.css">
-->
</head>
<body>
	<%!Color getRandColor(int fc, int bc) {//给定范围获得随机颜色
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}%>
	<%
		//设置页面不缓存
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		// 在内存中创建图象
		int width = 60, height = 20;
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		// 获取图形上下文
		Graphics g = image.getGraphics();
		//生成随机类
		Random random = new Random();
		// 设定背景色
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);
		//设定字体
		g.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		//画边框
		//g.setColor(new Color());
		//g.drawRect(0,0,width-1,height-1);
		// 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < 155; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}
		// 取随机产生的认证码(4位数字)
		String sRand = "";
		for (int i = 0; i < 4; i++) {
			String rand = String.valueOf(random.nextInt(10));
			sRand += rand;
			// 将认证码显示到图象中
			g.setColor(new Color(20 + random.nextInt(110), 20 + random
					.nextInt(110), 20 + random.nextInt(110)));//调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
			g.drawString(rand, 13 * i + 6, 16);
		}
		// 将认证码存入SESSION
		session.setAttribute("rand", sRand);
		// 图象生效
		g.dispose();
		// 输出图象到页面
		ImageIO.write(image, "JPEG", response.getOutputStream());
	%>
	<a></a>
</body>
</html>