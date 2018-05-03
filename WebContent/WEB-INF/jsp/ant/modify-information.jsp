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
    <title>修改个人信息</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
    <script src="<%=request.getContextPath()%>/js/jquery-1.10.1.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/common.js"></script>
    <script src="<%=request.getContextPath()%>/js/cover.js"></script>
</head>
<body>
    <div class="index">
    <form action="<%=request.getContextPath()%>/Userinfo/modifyUser.shtml" 
    method="post" onsubmit="return formValidatemodify();">
        <div class="g-personal">
            <div class="m-name">
                <div><label for="">姓名：</label><input name="UserName" type="text" class="name" placeholder="请输入您的姓名"></div>
                <div class="gender"><span>性别：</span><label for=""><input type="radio" name="identity" value="男"><span>男</span></label><label for=""><input type="radio" name="identity" value="女"><span>女</span></label></div>
                <div><label for="">手机号：</label><input name="PhoneNum" type="text" class="phone" placeholder="请输入您的手机号"></div>
                <div><label for="">工龄：</label>
                    <select name="YearNum" id="YearNum">
                        <option>1-3年</option>
                        <option>3年以上</option>
                    </select>
                </div>
            </div>
            <div class="g-field m-fieldBottom"><input type="submit" value="完成"></div>
        </div>
        <input type="hidden" name="userId"  value="${userId}"/>
        </form>
    </div>
   <%--  <script>
        $('.ok-modity').on('click', function() {
        	 formValidate();
              window.location.href = "<%=request.getContextPath()%>/Userinfo/PersonalCenter.shtml";  
        });
    </script> --%>
</body>
</html>