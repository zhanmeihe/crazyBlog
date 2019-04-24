<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.util.*"%>
<%@ page import="java.net.URLDecoder"%>
<%@ page import="sun.misc.BASE64Decoder"%>
<%@ page import="java.text.SimpleDateFormat"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录 - 疯狂博客</title>
<link href="<%=request.getContextPath()%>/css/login-patch.css"
	rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/jquery-1.7.2.js"
	type="text/javascript"></script>
<link href="<%=request.getContextPath()%>/images/logo.ico"
	rel="shortcut icon" type="image/x-icon">
	<script type="text/javascript">
	$(document).ready(function() {
		if (window.self != window.top) {
			top.location.href = window.location.href;
		}
	});
	 
	function randCode(o) {
		var url = $(o).attr('src');
		//alert(url);
		$(o).attr('src', url + '?t=' + new Date());
	}
	 
	function validateForm() {
		var username = $.trim($('input[name="userName"]').val());
		var password = $.trim($('input[name="passWord"]').val());
		var checkcode = $.trim($('input[name="checkCode"]').val());
		if (username == '') {
			alert('请输入用户名');
			return false;
		}
		if (password == '') {
			alert('请输入密码');
			return false;
		}
		 if (checkcode == '') {
			alert('请输入验证码');
			return false;
		} 
		return true;
	}
</script>
 <%
 String date = "";
 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
  date = formatter.format(new Date());   
 
 %>
	<%
		String user = "";
		String userid = "";
		
		Cookie cookies[] = request.getCookies();
		//int ss = cookies.length;
		//out.println(" cookie的数量为：" + cookies.length);
		//out.println("<br>"+"<br>"); 
		if(cookies!=null){
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("userName")) {
					user = cookies[i].getValue();

					if (user == null) {
						user = null;
					} else if (user != null) {
						BASE64Decoder decoder = new BASE64Decoder();

						byte[] b = decoder.decodeBuffer(user);
						user = new String(b);
					}
				}
				if (cookies[i].getName().equals("userid")) {
					userid = cookies[i].getValue();
					if (userid == null) {
						userid = "null";
					} else if (userid != null) {
						BASE64Decoder decoder = new BASE64Decoder();

						byte[] b = decoder.decodeBuffer(userid);
						userid = new String(b);
					}
				}

				//out.println("getName="+cookies[i].getName()+"<br>"); 
			}
		}else{
			  user = "";
			 userid = "";
		}
 
	%>

	<%
		String tokenV = new Date().getTime() + "";
	%>
     

	<script type="text/javascript">  
	function addCookie(name,value,expiresHours){ 
		  var cookieString=name+"="+escape(value); 
		  //判断是否设置过期时间,0代表关闭浏览器时失效
		  if(expiresHours>0){ 
		    var date=new Date(); 
		    date.setTime(date.getTime()+expiresHours*1000); 
		    cookieString=cookieString+";expires=" + date.toUTCString(); 
		  } 
		    document.cookie=cookieString; 
		} 
		//修改cookie的值
		function editCookie(name,value,expiresHours){ 
		  var cookieString=name+"="+escape(value); 
		  if(expiresHours>0){ 
		   var date=new Date(); 
		   date.setTime(date.getTime()+expiresHours*1000); //单位是毫秒
		   cookieString=cookieString+";expires=" + date.toGMTString(); 
		  } 
		   document.cookie=cookieString; 
		} 
		//根据名字获取cookie的值
		function getCookieValue(name){ 
		   var strCookie=document.cookie; 
		   var arrCookie=strCookie.split("; "); 
		   for(var i=0;i<arrCookie.length;i++){ 
		    var arr=arrCookie[i].split("="); 
		    if(arr[0]==name){
		     return unescape(arr[1]);
		     break;
		    }else{
		       return ""; 
		       break;
		     } 
		   } 
		     
		}
	//异步请求验证码
	$(function(){
  $("#second").click(function (){
    sendCode($("#second"));
  });
  v = getCookieValue("secondsremained");//获取cookie值
  if(v>0){
    settime($("#second"));//开始倒计时
  }
})
//发送验证码
function sendCode(obj){
  var phonenum = $("#phonecode").val();
  var result = isPhoneNum();
  if(result){
    doPostBack('${base}/login/getCode.htm',backFunc1,{"phonenum":phonenum});
    addCookie("secondsremained",60,60);//添加cookie记录,有效时间60s
    settime(obj);//开始倒计时
  }
}
//将手机利用ajax提交到后台的发短信接口
function doPostBack(url,backFunc,queryParam) {
  $.ajax({
    async : false,
    cache : false,
    type : 'POST',
    url : url,// 请求的action路径
    data:queryParam,
    error : function() {// 请求失败处理函数
    },
    success : backFunc
  });
}
function backFunc1(data){
  var d = $.parseJSON(data);
  if(!d.success){
    alert(d.msg);
  }else{//返回验证码
    alert("模拟验证码:"+d.msg);
    $("#code").val(d.msg);
  }
}
//开始倒计时
var countdown;
function settime(obj) { 
  countdown=getCookieValue("secondsremained");
  if (countdown == 0) { 
    obj.removeAttr("disabled");  
    obj.val("免费获取验证码"); 
    return;
  } else { 
    obj.attr("disabled", true); 
    obj.val("重新发送(" + countdown + ")"); 
    countdown--;
    editCookie("secondsremained",countdown,countdown+1);
  } 
  setTimeout(function() { settime(obj) },1000) //每1000毫秒执行一次
} 
//校验手机号是否合法
function isPhoneNum(){
  var phonenum = $("#phonecode").val();
  var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/; 
  if(!myreg.test(phonenum)){ 
    alert('请输入有效的手机号码！'); 
    return false; 
  }else{
    return true;
  }
}
	
       function reload(){  
          document.getElementById("image").src="<%=request.getContextPath()%>/Checkimage?date="+new Date().getTime();;
			$("#checkCode").val(""); // 将验证码清空  
		}

		function verificationcode() {
			var text = $.trim($("#checkCode").val());
			var names = $.trim($("#name").val());
			var passs = $.trim($("#pass").val());
			/* var phone = $.trim($("#phonecode").val());
			var veriycode = $.trim($("#pn").val()); */
			
			$.post("${pageContext.request.contextPath}/verificationCode", {op : text}, 
					function(data) {
				data = parseInt($.trim(data));
				//alert(data);
				if(names != '' && passs != ''&&text!=''){
					if(data > 0){
						$("#span").text("验证成功!").css("color", "green");
						alert("验证成功！");
						 $.ajax({
							    url : '${pageContext.request.contextPath}/u',
							    data : $("#handleform").serialize(),
							    type : 'POST', 
							    //dataType : 'json', 
							    async:true, 
							    success : function(data) {//这是个回调函数 data表示从action中传过来的json数据
								
							    window.location = "<%=request.getContextPath()%>";
													}
												});
									} else {
										$("#span").text("验证码失败!").css("color",
												"red");
										reload();
									}
								} else {
									alert("请输入用户名，密码，附加码");
								}
							});
			$("#checkcode").val("");
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
						<li><a href="http://www.focode.cn/personal.jsp" target="_blank" style="font-style: normal;">注册</a></li>
					</ul>
				</div>
				<div style="padding-top: 25px; padding-left: 25px;">
					<b style="font-size: 20px;">登录疯狂博客</b>
				</div>
			</div>
		</div>
		<div id="login_content">
			<div class="loginForm">
				<form id="handleform" method="post"
					action="<%=request.getContextPath()%>/u"
					onsubmit="return validateForm();">
					<p>
						<label></label> <input placeholder="手机号或邮箱"  type="text" id="name" name="userName"
							size="20" class="login_input" value="" />
					</p>
					<p>
						<label></label> <input placeholder="密码" id="pass" type="password" name="passWord"
							size="20" class="login_input" value="" />
					</p>
					<!-- <p>
						<label></label> <input placeholder="手机号" id="phonecode" type="text" name="phonecode"
							size="20" class="login_input" value="" />
					</p> -->
					<p>
						<label></label> <input class="code" placeholder="附加码" name="checkCode"
							id="checkCode" type="text" size="5" /> <span><img
							id="image" src="<%=request.getContextPath()%>/Checkimage"
							onclick="randCode(this);" alt="" width="90" height="40" style="" /></span>
					</p>
					
					<!-- <p>
						<label></label> <input placeholder="验证码" class="pn" name="pn"
							id="pn" type="text" size="5" /> <span><input
							id="second" style="font-size: 1px; width: 90px;" type="button"
							value="免费获取验证码" /></span>
					</p> -->
					<span id="span"></span>
					<div class="login_bar">
						<input class="sub" type="submit" value=""
							
							/>
							<!-- onclick="verificationcode()" -->
					</div>

				</form>
			</div>
			<div class="login_banner"></div>
			<div class="login_main"></div>
		</div>
		<div id="login_footer">Copyright &copy; 2018 www.focode.cn
			Inc. All Rights Reserved.</div>
	</div>
</body>
</html>