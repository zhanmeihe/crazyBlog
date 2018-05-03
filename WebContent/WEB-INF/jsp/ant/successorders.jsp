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
    <title>抢单成功</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
    <script src="<%=request.getContextPath()%>/js/jquery-1.10.1.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/common.js"></script>
</head>
<body class="bg-succ">
    <div class="index">
        <div class="g-success">
            <p>项目经理联系方式</p>
            <p>姓名：张璐</p>
            <p>电话：18518018018</p>
            <div>
                <span>工作要求</span>
                <p>1,必须穿工装</p>
                <p>2,如迟到，扣除10%</p>
                <p>3,工期超时，扣除10%</p>
                <p>4,当日未到，星级评价降低</p>
            </div>
            <div>
                <span>验收标准</span>
                <p>1,</p>
                <p>2,</p>
                <p>3,</p>
            </div>
            <div class="g-field fanhui-index"><a href="<%=request.getContextPath()%>/Userinfo/workclock.shtml/${userId}/${taskId}">确定</a></div>
        </div>
    </div>
</body>
</html>