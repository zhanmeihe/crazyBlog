<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">
<head>
<link type="favicon" rel="shortcut icon" href="<%=request.getContextPath()%>/images/favicon.ico" />
<meta charset="UTF-8">
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"
	name="viewport">
<meta content="yes" name="apple-mobile-web-app-capable">
<meta content="black" name="apple-mobile-web-app-status-bar-style">
<meta content="telephone=no" name="format-detection">
<title>蚂蚁阿奇注册</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
<script src="<%=request.getContextPath()%>/js/jquery-1.10.1.min.js"></script>
<script src="<%=request.getContextPath()%>/js/common.js"></script>
<script src="<%=request.getContextPath()%>/js/cover.js"></script>
</head>
<body>
 
 <script type="text/javascript">
 
 
 var checksubmitflg = false; 
 function checksubmit() { 
 if (checksubmitflg == true) { 
 return false; 
 } 
 checksubmitflg = true; 
 return true; 
 } 
 document.ondblclick = function docondblclick() { 
 window.event.returnvalue = false; 
 }
 document.onclick = function doconclick() { 
 if (checksubmitflg) { 
 window.event.returnvalue = false; 
 } 
 } 
 
 </script>

	<form action="<%=request.getContextPath()%>/Userinfo/UserRegistr"
		onsubmit="return formValidate();" method="post"
		enctype="multipart/form-data">
		<div class="index">
			<div class="g-personal">
				<div class="m-name">
					<div>
						<label for="">姓名：</label><input name="UserName" type="text"
							class="name" value="${snsUserInfo.nickname}" placeholder="请输入您的姓名">
					</div>
					<div class="gender">
						<span>性别：</span> <label for=""><input type="radio"
							name="identity" value="男"><span>男</span></label> <label for=""><input
							type="radio" name="identity" value="女"><span>女</span></label>
					</div>
					<input type="hidden" name="openId"  value="${snsUserInfo.openId}"/>
					<input type="hidden" name="headImgUrl"  value="${snsUserInfo.headImgUrl}"/>
					<div>
						<label for="">手机号：</label><input name="PhoneNum" type="text"
							class="phone" placeholder="请输入您的手机号">
					</div>
					<div>
						<label for="">身份证号：</label><input name="IdcardNum" type="text"
							class="identity" placeholder="请输入您的身份证号">
					</div>
					<div>
						<label for="">工龄：</label> <select name="YearNum" id="">
							<option>1-3年</option>
							<option>3年以上</option>
						</select>
					</div>
					<div class="type-work">
						<span>工种:</span>
						<div class="z-type-work">
							<label for=""><input name="WorkType" type="checkbox"
								value="防水">防水</label> <label for=""><input
								name="WorkType" type="checkbox" value="水工">水工</label> <label
								for=""><input name="WorkType" type="checkbox" value="电工">电工</label>
							<label for=""><input name="WorkType" type="checkbox"
								value="瓦工">瓦工</label> <label for=""><input
								name="WorkType" type="checkbox" value="木工">木工</label> <label
								for=""><input name="WorkType" type="checkbox" value="司机">司机</label>
							<label for=""><input name="WorkType" type="checkbox"
								value="安门">安门</label> <label for=""><input
								name="WorkType" type="checkbox" value="保洁">保洁</label> <label
								for=""><input name="WorkType" type="checkbox"
								value="腻子工">腻子工</label> <label for=""><input
								name="WorkType" type="checkbox" value="油漆工">油漆工</label> <label
								for=""><input name="WorkType" type="checkbox"
								value="贴壁纸">贴壁纸</label> <label for=""><input
								name="WorkType" type="checkbox" value="安装,搬运">安装,搬运</label>
						</div>
					</div>
				</div>
				<div class="g-field m-fieldBottom">
					<input type="submit" value="下一步">
				</div>
			</div>
		</div>
	</form>
	<script>
        $('.on-shou').on('click', function() {
            formValidate();
        });
        
        
    </script>
    <script type="text/javascript">
    document.getElementById("checkbox").checked;
    </script>
</body>
</html>