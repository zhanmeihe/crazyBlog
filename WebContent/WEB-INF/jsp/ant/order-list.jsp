<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ page import = "javax.servlet.http.HttpServletRequest"%>
	
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
    <title>订单列表</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
    <script src="<%=request.getContextPath()%>/js/jquery-1.10.1.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/common.js"></script>
</head>

<script type="text/javascript">
$(document).ready(function(){
	 var skin = ${skin};//获取input的节点
	   if (skin<=0 ) {
		alert("不好意思，新发布的任务已被抢完！");
		history.go(-1);
	};
});
</script>

<script type="text/javascript">
$(document).ready(function(){
var rs = ${username};
var sessionValue = session.getAttribute("username");//这里写你后台传出来的key
 var test = $(sessionValue);
   //这里判断一下
  if(sessionValue =="" || sessionValue ==null){
    alert("登录失效，稍等返回首页！");
    window.location.href = "<%=request.getContextPath()%>/index.jsp";
  };
});

</script>
<body class=""  oninit() = "onLoad()">
    <div class="index">
        <div class="g-order-list">
            
            <div class="m-order-cent">
                <ul>
                <c:forEach items="${task}" var="taskinfo">
                 <li>
                        <a href="<%=request.getContextPath()%>/Userinfo/ListDetailsOrder.shtml/${taskinfo.id}/${userId}">
                            <div class="z-center">
                                <div class="details">
                                    <p>任务摘要：${taskinfo.taskInstruction }</p>
                                    <p>薪资：${taskinfo.salaryNum }</p>
                                    <p>任务时间：${taskinfo.taskDate }</p>
                                    <p style="color: blue;">任务地点：${taskinfo.taskAddress }</p>
                                </div>
                            </div>
                        </a>
                    </li> 
                </c:forEach>
                   
                </ul>
            </div>
        </div>
        <div class="g-lj-bottom">
            <a href="<%=request.getContextPath()%>/Userinfo/orderlist.shtml/${userId}">抢单</a>
            <a href="<%=request.getContextPath()%>/working/orderwork.shtml/${userId}">施工</a>
            <a href="<%=request.getContextPath()%>/Userinfo/PersonalCenter.shtml/${userId}">个人中心</a>
        </div>
    </div>
</body>

</html>