<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport">
    <meta content="yes" name="apple-mobile-web-app-capable">
    <meta content="black" name="apple-mobile-web-app-status-bar-style">
    <meta content="telephone=no" name="format-detection">
    <title>订单详情</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
    <script src="<%=request.getContextPath()%>/js/jquery-1.10.1.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/common.js"></script>
</head>
<body class="">
    <div class="index">
        <div class="g-order-list">
             
            <div class="m-order-cent">
                <div class="m-details">
                    <div class="details">
                        <p>施工任务：${info.taskInstruction}</p>
                        <p>施工量：${info.productionNum }</p>
                        <p>薪资：${info.salaryNum }</p>
                        <p>施工时间：${info.taskDate }</p>
                    </div>
                </div>
                <div class="m-details">
                    <div class="details">
                        <span class="qingdan">请自带以下工具清单：</span>
                        <p>1：${info.listIng}</p>
                       <!--  <p>2：电刨子，台钻，水平仪</p>
                        <p>3：水钻，曲线锯，直钉枪</p>
                        <p>4：马钉枪，钢钉枪，纹钉枪</p> -->

                    </div>
                </div>
                <div class="m-details aggregate">
                    <span style="color: blue;">集合地点：</span><a style="color: blue;" class="map-gation">${info.taskAddress }</a>
                </div>
               <!--  <div class="g-field order-derail"><input type="submit" value="我要抢单"></input></div> -->
            </div>
        </div>
        <div class="g-lj-bottom">
            <a href="<%=request.getContextPath()%>/Userinfo/orderlist.shtml/${info.userId}">抢单</a>
            <a href="<%=request.getContextPath()%>/working/orderwork.shtml/${info.userId}">施工</a>
            <a href="<%=request.getContextPath()%>/Userinfo/PersonalCenter.shtml/${info.userId}">个人中心</a>
        </div>
    </div>
    <script>
        $(".map-gation").click(function () {
          var addRess = $(this).html();
            window.sessionStorage.setItem('my-adress',addRess);
            window.location.href = "<%=request.getContextPath()%>/MapAddress/GpsAddress.shtml/${info.taskAddress}";
        })
    </script>
</body>
</html>