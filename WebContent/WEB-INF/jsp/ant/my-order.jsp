<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <title>我的订单</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
    <script src="<%=request.getContextPath()%>/js/jquery-1.10.1.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/common.js"></script>
</head>

<script type="text/javascript">
$(document).ready(function(){
	 var skin = ${skin};//获取input的节点
	   if (skin<=0 ) {
		alert("您还没有订单或正在施工的任务！");
		history.go(-1);
	 
	};
});

</script>
<body class="">
    <div class="index">
        <div class="g-order-list">
             
            <div class="m-order-cent">
            <c:forEach items="${task }" var="taskinfo">
                <ul>
                    <li>
                        <a href="<%=request.getContextPath()%>/Userinfo/ListDetails.shtml/${taskinfo.taskId}/${taskinfo.userId}">
                            <div class="z-center">
                                <div class="details">
                                    <p>任务摘要：${taskinfo.taskInstruction }</p>
                                    <p>薪资：${ taskinfo.salaryNum}</p>
                                    <p>任务时间：${taskinfo.taskDate}</p>
                                    <p style="color: blue;">任务地点：${taskinfo.taskAddress}</p>
                                </div>
                            </div>
                        </a>
                    </li>
                    <li>
                </ul>
                </c:forEach>
            </div>
        </div>
        <div class="g-lj-bottom">
            <a href="<%=request.getContextPath()%>/Userinfo/orderlist.shtml/${userId}">抢单</a>
            <a href="<%=request.getContextPath()%>/working/orderwork.shtml/${userId}">施工</a>
            <a href="<%=request.getContextPath()%>/Userinfo/PersonalCenter.shtml/${userId}">个人中心</a>
        </div>
    </div>
    
<!-- <script type="text/javascript">
$(document).ready(function(){
	 var skin = ${skin};//获取input的节点
	   if (skin<=0 ) {
		alert("不好意思，新发布的任务已被抢完！");
		/* history.go(-1);
	  */
	  return false;
	}  
});

</script> -->
</body>
</html>