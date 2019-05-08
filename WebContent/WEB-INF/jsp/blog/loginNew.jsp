<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.util.*"%>
<%@ page import="java.net.URLDecoder"%>
<%@ page import="sun.misc.BASE64Decoder"%>
<%@ page import="java.text.SimpleDateFormat"%> 
<!DOCTYPE html>
<html lang="zh-CN">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title>登录 - 疯狂博客</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" /> 
	<link href="<%=request.getContextPath()%>/images/logo.ico"
	rel="shortcut icon" type="image/x-icon">
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main1.css">
</head>

<body>
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

	<div class="limiter">
		<div class="container-login100" style="background-image: url('images/bg-01.jpg');">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
				<form class="login100-form validate-form" id="handleform" method="post"
					action="<%=request.getContextPath()%>/u"
					>
					<span class="login100-form-title p-b-49">登录</span>

					<div class="wrap-input100 validate-input m-b-23" data-validate="请输入用户名">
						<span class="label-input100">用户名</span>
						<input class="input100" type="text" name="userName" placeholder="请输入用户名" autocomplete="off">
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="请输入密码">
						<span class="label-input100">密码</span>
						<input class="input100" type="password" name="passWord" placeholder="请输入密码">
						<span class="focus-input100" data-symbol="&#xf190;"></span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate="请输入验证码">
						<span class="label-input100">验证码</span>
						<input class="input100" type="text" name="checkCode" placeholder="请输入验证码">
						
						<span class="focus-input100" data-symbol="&#xf190;"></span>
						
					</div>
					<!-- 验证码 -->
					<span><img
							id="image" src="<%=request.getContextPath()%>/Checkimage"
							onclick="randCode(this);" alt="" width="90" height="40" style="" /></span>

					<div class="text-right p-t-8 p-b-31">
						<a href="javascript:">忘记密码？</a>
					</div>

					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							 
							<button class="login100-form-btn">登 录</button>
						</div>
					</div>

					<div class="txt1 text-center p-t-54 p-b-20">
						<span>第三方登录（暂时无法使用第三方登录）</span>
					</div>

					<div class="flex-c-m">
						<a href="javascript:" class="login100-social-item bg1">
							<i class="fa fa-wechat"></i>
						</a>

						<a href="javascript:" class="login100-social-item bg2">
							<i class="fa fa-qq"></i>
						</a>

						<a href="javascript:" class="login100-social-item bg3">
							<i class="fa fa-weibo"></i>
						</a>
					</div>

					<div class="flex-col-c p-t-25">
						<a href="<%=request.getContextPath()%>/personal.jsp" class="txt2">立即注册</a>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<script src="js/main.js"></script>
</body>

</html>