
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<base href='<%=request.getContextPath()%>/'>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="referrer" content="never">
<meta name="referrer" content="unsafe-url">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="apple-mobile-web-app-status-bar-style" content="yes">
<link href="<%=request.getContextPath()%>/images/logo.ico"
	rel="shortcut icon" type="image/x-icon">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.11.1.min.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/common.css?v=1.5.1" />
<!--[if lt IE 9]>
    <script type="text/javascript" src="js/html5shiv.js"></script>
    <![endif]-->
<script>
    
	function randCode(o) {
		var url = $(o).attr('src');
		//alert(url);
		$(o).attr('src', url + '?t=' + new Date());
	}
        var _hmt = _hmt || [];
        (function() {
            var hm = document.createElement("script");
            hm.src = "https://hm.baidu.com/hm.js?6bcd52f51e9b3dce32bec4a3997715ac";
            var s = document.getElementsByTagName("script")[0];
            s.parentNode.insertBefore(hm, s);
        })();
        var CFG={
            BASE_URL : "https://csdnimg.cn/release/passport/",    //当前页面对应的虚拟路径,页面j
            API_URL  : "https://passport.csdn.net/",               //当前项目默认的后端API地址
            ROOT_URL  : "https://passport.csdn.net/",              //当前项目根路径, JS跳转
            STATIC_URL : "https://csdnimg.cn/release/passport/",             //本项目静态资源
            STATIC_GLOBAL_URL : "https://csdnimg.cn/"              //全局静态资源
        }
    </script>
<title>疯狂博客注册账号</title>
<script>
	 var errclass = "";
     var errmsg = "";
     var okcalsses = [];
     
     (function() {
		 window._smConf = {
		 organization: 'E2fSjOLnvVdMRc4jLSih',
		 staticHost: 'static.fengkongcloud.com'
		 };
		 var url = (function () {
		 var originHost = "static2.fengkongcloud.com";
		 var isHttps = 'https:' === document.location.protocol;
		 var protocol = isHttps ? 'https://' : 'http://';
		 var fpJsPath = '/fpv2.js';
		 var url = protocol + _smConf.staticHost + fpJsPath;
		 var ua = navigator.userAgent.toLowerCase();
		 var isWinXP = /windows\s(?:nt\s5.1)|(?:xp)/.test(ua);
		 var isLowIE = /msie\s[678]\.0/.test(ua);
		 if(isHttps && isWinXP && isLowIE) {
		 url = protocol + originHost + fpJsPath;
		 }
		 return url;
		 })();
		 var sm = document.createElement("script");
		 var s = document.getElementsByTagName("script")[0];
		 sm.src = url;
		 s.parentNode.insertBefore(sm, s);
		})();
     
     
     function validateForm() {
    	 alert("1");
 		var username = $.trim($('input[name="userName"]').val());
 		var password = $.trim($('input[name="passWord"]').val());
 		var checkcode = $.trim($('input[name="checkCode"]').val());
 		var nickNmae = $.trim($('input[name="nickNmae"]').val());
 		var confirmpassword = $.trim($('input[name="confirmpassword"]').val());
 		var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/; 
 		if (username == '') {
 			alert('请输入手机号');
 			return false;
 		}
 		if(!myreg.test($("#name").val())){
 			alert('请填写有效的手机号码');
 			return false;
 		}
 		if (nickNmae == '') {
 			alert('请输入用户名');
 			return false;
 		}
 		if (password == '') {
 			alert('请输入密码');
 			return false;
 		}
 		if(password!=confirmpassword){
 			alert('输入密码不一致');
 			return false;
 		}
 		 if (checkcode == '') {
 			alert('请输入验证码');
 			return false;
 		} 
 		return true;
 	}
     
     function reload(){  
         document.getElementById("image").src="<%=request.getContextPath()%>/Checkimage?date="+new Date().getTime();;
			$("#checkCode").val(""); // 将验证码清空  
		}

		function verificationcode() {
			var text = $.trim($("#checkCode").val());
			var names = $.trim($("#name").val());
			var passs = $.trim($("#pass").val());
			var passs2 = $.trim($("#pass2").val());
			var nickn = $.trim($("#nickn").val());
			/* var phone = $.trim($("#phonecode").val());
			var veriycode = $.trim($("#pn").val()); */
			
			$.post("${pageContext.request.contextPath}/verificationCode", {op : text}, 
					function(data) {
				data = parseInt($.trim(data));
				//alert(data);
				if(names != '' && passs != ''&&text!='' &&nickn!='' &passs2!=''){
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
					$("#span").text("验证码失败!").css("color", "red");
					reload();
				}
			} else {
				alert("请输入用户名，密码，附加码");
			}
		});
		$("#checkcode").val("");
	}
</script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/loginnew.css?v=1.5.1" />
<script type="text/javascript" charset="utf-8"
	src="<%=request.getContextPath()%>/js/pass.js?v=1.5.1"></script>
<!-- <script type="text/javascript" charset="gb2312" src="https://csdnimg.cn/release/passport/js/passport.js?v=1.5.1"></script>
 -->
</head>
<body>


	<div class="login_main">

		<div class="login_r_wrap">
			<div class="login_c regist_c">
				<!-- <div class="login_c_t">差一步就完成</div> -->
				<div style="padding-top: 25px; padding-left: 25px;">
					<b style="font-size: 20px;">注册疯狂博客账号</b>
				</div>
				<div class="login_c_c regist_c_c">

					<form id="handleform"
						action="<%=request.getContextPath()%>/Userinfo/blogRegistr"
						method="post"  >
						<ul class="step2_list">
							<li><input type="text" class="iphone" id="name"
								name="userName" placeholder="输入手机号"></li>
							<li><input type="text" placeholder="用户名" id="nickn"
								class="nickname" name="nickNmae" value=""></li>
							<!--  <li>
                  <input type="text" placeholder="邮箱" class="re_email" name="email" value=""> 
                </li> -->
							<li><input type="password" placeholder="输入密码"
								class="re_password" id="pass" name="passWord"></li>
							<li><input type="password" placeholder="再次输入密码"
								class="re_password_again" id="pass2" name="confirmpassword">
								<!--  <div class="sys_pwd_wapper">系统推荐密码：<a href="javascript:void(0);" id="sys_pwd"></a></div> -->
							</li>

							<p>
								<label></label> <input class="code" placeholder="附加码"
									name="checkCode" id="checkCode" type="text" size="15" /> <span><img
									id="image" src="<%=request.getContextPath()%>/Checkimage"
									onclick="randCode(this);" alt="" width="110" height="60"
									style="" /></span>
							</p>
						</ul>
						<!-- <input type="hidden" name="fkid" id="fkid" value="" /> -->
						<input id="regist" accesskey="l" value="注册提交" tabindex="6"
							type="submit" class="next_btn regist" onclick="return validateForm()">
						<!-- data-kuick='{"act":"csdn06","desc":"下一步:提交注册信息"}' -->
					</form>
				</div>
			</div>
			<div class="login_copyright">
				All Rights Reserved 版权所有：<a href="http://www.pioneersv.cn">占美和个人博客</a>
				备案号：京ICP备17010763号
			</div>
			<a href="https://icp.aizhan.com/" target="_blank"><img
				src="https://icp.aizhan.com/geticp/?host=pioneersv.cn&style=img"
				style="width: 126px; height: 41px; border: 0;" /></a>
		</div>
	</div>
</body>

</html>



