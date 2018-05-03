<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<link type="favicon" rel="shortcut icon" href="<%=request.getContextPath()%>/images/favicon.ico" />
    <meta charset="UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport">
    <meta content="yes" name="apple-mobile-web-app-capable">
    <meta content="black" name="apple-mobile-web-app-status-bar-style">
    <meta content="telephone=no" name="format-detection">
    <title>注册成功</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
    <script src="<%=request.getContextPath()%>/js/jquery-1.10.1.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/common.js"></script>
</head>
<body class="bg-succ">
    <div class="index">
        <div class="g-success">
            <span class="titile">注册成功</span>
            <p>工人编号：<span>${info.personNum }</span></p>
            <p class="name"><span>${info.userName}</span>师傅</p>
            <div>欢迎加入蚂蚁阿奇</div>
            <div>施工时必须穿工服</div>
            <div>领取工服请联系工程负责人</div>
            <div>姓名：杨增旺</div>
            <div>电话：17801157396</div>
            <div class="g-field fanhui-index"><a href="<%=request.getContextPath()%>/Userinfo/PersonalCenter.shtml/${userId}">确定</a></div>
        </div>
    </div>
</body>
</html>