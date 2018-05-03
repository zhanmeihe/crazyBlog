<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style> 
body{ text-align:center} 
.div{ margin:0 auto; width:400px; height:100px; border:1px solid #F00} 
/* css注释：为了观察效果设置宽度 边框 高度等样式 */ 
</style> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${vidpath.name}</title>
</head>
<body>
	<div ><object classid='clsid:D27CDB6E-AE6D-11cf-96B8-4445535411111'
		codebase='http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0'
		width='800' height='720'>
		<param name='movie' value='Flvplayer.swf' />
		<param name='quality' value='high' />
		<param name='allowFullScreen' value='true' />
		<param name='FlashVars'
			value='vcastr_file=${vidpath.videoPath }&IsAutoPlay=1&IsContinue=0' />
		<embed style="width: 750px; height: 400px;"
			src='<%=request.getContextPath()%>/video/Flvplayer.swf'
			allowfullscreen='true'
			flashvars='vcastr_file=${vidpath.videoPath }&IsAutoPlay=1&IsContinue=0'
			quality='high'
			pluginspage='http://www.macromedia.com/go/getflashplayer'
			type='application/x-shockwave-flash' width='800' height='720' />
	</object></div>
	
<h3>${vidpath.name}</h3>
	<div>
		<a href="${vidpath. url}">原链接地址：</a> <br> <a
			href="${vidpath. url}">${vidpath. url}</a>
		<h4>创建时间：${ vidpath.publishDate}</h4>

		<h4>系统时间：${ vidpath.sysDate}</h4>
	</div>
</body>
</html>