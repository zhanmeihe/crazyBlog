<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><html>
<head>
</head>
<body>
	<%
		String input = request.getParameter("input");
		String code = (String) session.getAttribute("code");
		if (input.equals(code)) {
			out.println("验证成功!");
		} else {
			out.println("验证失败!");
		}
	%>
</body>
</html>