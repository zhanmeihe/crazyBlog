<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id=win
		style="display: none; POSITION: absolute; left: 50%; top: 50%; width: 600px; height: 400px; margin-left: -300px; margin-top: -200px; border: 1px solid #888; background-color: #edf; text-align: center">
		这是DIV登录框示例<br> <a href="javascript:closeLogin();">关闭登录框</a>
	</div>
	<script>
		function openLogin() {
			document.getElementById("win").style.display = "";
		}
		function closeLogin() {
			document.getElementById("win").style.display = "none";
		}
	</script>
	<a href="javascript:openLogin();">打开登录框</a>
</body>
</html>