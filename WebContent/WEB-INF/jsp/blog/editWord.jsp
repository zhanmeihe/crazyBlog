<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<%@ page import="java.net.URLDecoder"%>
<%@ page import="sun.misc.BASE64Decoder"%>
<%@ page import="java.text.SimpleDateFormat"%> 
<%@ page import="java.util.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>疯狂博客 - 撰写</title>
<link href="<%=request.getContextPath()%>/images/logo.ico"
	rel="shortcut icon" type="image/x-icon">
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<script type="text/javascript" charset="utf-8"
	src="<%=request.getContextPath()%>/ueditor1_4_3/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="<%=request.getContextPath()%>/ueditor1_4_3/ueditor.all.min.js">
	
</script>
<script type="text/javascript">
 
function validateForm() {
	/* var username = $.trim($('input[name="userName"]').val());*/
	var tit = $.trim($('input[name="title"]').val()); 
	var content = $.trim($('input[id="editor"]').val());
	alert("2111");
	if (tit == '') {
		alert('标题不能为空！');
		return false;
	}
	if (content == '') {
		alert('内容不能为空！');
		return false;
	}
	/*  if (checkcode == '') {
		alert('请输入验证码');
		return false;
	}  */
	return true;
}

</script>
<script type="text/javascript">
  var ue = UE.getEditor('container', {
    toolbars: [
      ['fullscreen','source','undo','redo','indent','bold','italic','underline','fontborder','snapscreen','print','preview','link','unlink','insertrow','insertcol','mergeright','mergedown','deleterow','deletecol','splittorows','splittocols','splittocells','fontfamily','fontsize','simpleupload','insertimage','spechars','searchreplace','justifyleft','justifyright','justifycenter'],
      ['justifyjustify','forecolor','backcolor','attachment','imagecenter','wordimage','inserttable','strikethrough', 'superscript', 'subscript', 'removeformat', 'formatmatch', 'autotypeset', 'blockquote', 'pasteplain', '|', 'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist', 'selectall', 'cleardoc']
    ],
    iframeCssUrl: '<%=request.getContextPath()%>/ueditor1_4_3/themes/iframe.css',// 引入css
    autoHeightEnabled: true,
    autoFloatEnabled: true
  });
</script>


<style type="text/css">
.text1 {
	width: 1019.5px;
	height: 40px
}
</style>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8"
	src="<%=request.getContextPath()%>/ueditor1_4_3/lang/zh-cn/zh-cn.js"></script>

<style type="text/css">
div {
	width: 100%;
}
</style>

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
<%-- 
<%
	String name=session.getAttribute("");
    if(name==null)
    {
    	response.sendRedirect(finalPath);
    }
    else
    {
    response.sendRedirect(finalPath);    
    }
%> --%>
</head>
<body>
	<%
		String date = "";
		SimpleDateFormat formatter = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		date = formatter.format(new Date());
	%>



	<%-- <%
		String username = (String) session.getAttribute("userName");
	 
		if (username != null)//如果这个不等于空，那么证明已经登录
		{
			//request.setAttribute("msgs", "ddd");
		} else {
	%>
	<script type="text/javascript">
		 
		alert("请先登陆");
		 
		window.location = "<%=request.getContextPath()%>/sign_login"
	</script>
	<%
		//如果session 为空那么证明没有登录将跳到login.jsp
		}
	%>
 --%>
<%
request.setCharacterEncoding("utf-8");
String ss = request.getParameter("error");
%>
	<script type="text/javascript">
 	 
 var token = '${user}';
 if(token==null||token==''){
	 alert("您还没有登录，请先登录或注册");
	 
		window.location = "<%=request.getContextPath()%>/sign_login";
		}
 var error =<%=ss%>;
 if(error != null){
	 alert(error);
 }
 
  
	
  
	</script>
	
	
	<br>
	<br>
	<div id="">
		<form action="<%=request.getContextPath()%>/blogText" method="post" onsubmit="return validateForm();">
		<!-- <span>搜索</span> -->
			 
			<!-- placeholder="<%=date%>" -->
				<input  class="text1" style="color: gray; right: 100px; font-size: 25px; font-style: italic;" type="text" value="<%=date%>" name="title" />
			 <span id="span" style="color: red;">${error}</span>
			<script id="editor" type="multipart/form-data" style="width:1024px;height:500px;"></script>
			<input type="hidden" name = "userid" value="<%=userid%>"/>
			<div id="btns"><input type="submit" size="6" value="发表文章"></div>
		</form>
		
	</div>
	 
	<div id="btns">
		<div>
			<!-- <button onclick="getContent()">获得内容</button> -->
			<!--  <button onclick="getAllHtml()">获得整个html的内容</button>
        
        <button onclick="setContent()">写入内容</button>
        <button onclick="setContent(true)">追加内容</button>
        <button onclick="getContentTxt()">获得纯文本</button>
        <button onclick="getPlainTxt()">获得带格式的纯文本</button>
        <button onclick="hasContent()">判断是否有内容</button>
        <button onclick="setFocus()">使编辑器获得焦点</button>
        <button onmousedown="isFocus(event)">编辑器是否获得焦点</button>
        <button onmousedown="setblur(event)" >编辑器失去焦点</button> -->

		</div>
		<div>
			<!--  <button onclick="getText()">获得当前选中的文本</button>
        <button onclick="insertHtml()">插入给定的内容</button>
        <button id="enable" onclick="setEnabled()">可以编辑</button>
        <button onclick="setDisabled()">不可编辑</button>
        <button onclick=" UE.getEditor('editor').setHide()">隐藏编辑器</button>
        <button onclick=" UE.getEditor('editor').setShow()">显示编辑器</button>
        <button onclick=" UE.getEditor('editor').setHeight(300)">设置高度为300默认关闭了自动长高</button> -->
		</div>

		<div>
			<!--  <button onclick="getLocalData()" >获取草稿箱内容</button>
        <button onclick="clearLocalData()" >清空草稿箱</button> -->
		</div>

	</div>
	<div>
		<!--   <button onclick="createEditor()">
    创建编辑器</button>
    <button onclick="deleteEditor()">
    删除编辑器</button> -->
	</div>

	<script type="text/javascript">
		//实例化编辑器
		//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
		var ue = UE.getEditor('editor');

		function isFocus(e) {
			alert(UE.getEditor('editor').isFocus());
			UE.dom.domUtils.preventDefault(e)
		}
		function setblur(e) {
			UE.getEditor('editor').blur();
			UE.dom.domUtils.preventDefault(e)
		}
		function insertHtml() {
			var value = prompt('插入html代码', '');
			UE.getEditor('editor').execCommand('insertHtml', value)
		}
		function createEditor() {
			enableBtn();
			UE.getEditor('editor');
		}
		function getAllHtml() {
			alert(UE.getEditor('editor').getAllHtml())
		}
		/* function getContent() {
			var arr = [];
			arr.push("使用editor.getContent()方法可以获得编辑器的内容");
			arr.push("内容为：");
			arr.push(UE.getEditor('editor').getContent());
			alert(arr.join("\n"));
		} */
		function getPlainTxt() {
			var arr = [];
			arr.push("使用editor.getPlainTxt()方法可以获得编辑器的带格式的纯文本内容");
			arr.push("内容为：");
			arr.push(UE.getEditor('editor').getPlainTxt());
			alert(arr.join('\n'))
		}
		function setContent(isAppendTo) {
			var arr = [];
			arr.push("使用editor.setContent('欢迎使用ueditor')方法可以设置编辑器的内容");
			UE.getEditor('editor').setContent('欢迎使用ueditor', isAppendTo);
			alert(arr.join("\n"));
		}
		function setDisabled() {
			UE.getEditor('editor').setDisabled('fullscreen');
			disableBtn("enable");
		}

		function setEnabled() {
			UE.getEditor('editor').setEnabled();
			enableBtn();
		}

		function getText() {
			//当你点击按钮时编辑区域已经失去了焦点，如果直接用getText将不会得到内容，所以要在选回来，然后取得内容
			var range = UE.getEditor('editor').selection.getRange();
			range.select();
			var txt = UE.getEditor('editor').selection.getText();
			alert(txt)
		}

		function getContentTxt() {
			var arr = [];
			arr.push("使用editor.getContentTxt()方法可以获得编辑器的纯文本内容");
			arr.push("编辑器的纯文本内容为：");
			arr.push(UE.getEditor('editor').getContentTxt());
			alert(arr.join("\n"));
		}
		function hasContent() {
			var arr = [];
			arr.push("使用editor.hasContents()方法判断编辑器里是否有内容");
			arr.push("判断结果为：");
			arr.push(UE.getEditor('editor').hasContents());
			alert(arr.join("\n"));
		}
		function setFocus() {
			UE.getEditor('editor').focus();
		}
		function deleteEditor() {
			disableBtn();
			UE.getEditor('editor').destroy();
		}
		function disableBtn(str) {
			var div = document.getElementById('btns');
			var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
			for (var i = 0, btn; btn = btns[i++];) {
				if (btn.id == str) {
					UE.dom.domUtils.removeAttributes(btn, [ "disabled" ]);
				} else {
					btn.setAttribute("disabled", "true");
				}
			}
		}
		function enableBtn() {
			var div = document.getElementById('btns');
			var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
			for (var i = 0, btn; btn = btns[i++];) {
				UE.dom.domUtils.removeAttributes(btn, [ "disabled" ]);
			}
		}

		function getLocalData() {
			alert(UE.getEditor('editor').execCommand("getlocaldata"));
		}

		function clearLocalData() {
			UE.getEditor('editor').execCommand("clearlocaldata");
			alert("已清空草稿箱")
		}
	</script>
</body>
</html>