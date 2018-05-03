<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>New Document</TITLE>
</HEAD>
<BODY>

	<object classid='clsid:D27CDB6E-AE6D-11cf-96B8-4445535411111'
		codebase='http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0'
		width='300' height='260'>
		<param name='movie' value='Flvplayer.swf' />
		<param name='quality' value='high' />
		<param name='allowFullScreen' value='true' />
		<param name='FlashVars'
			value='vcastr_file=http://flv4.bn.netease.com/videolib3/1706/10/uJyNO0923/SD/uJyNO0923.flv&IsAutoPlay=0&IsContinue=1' />
		<embed src='<%=request.getContextPath()%>/video/Flvplayer.swf'
			allowfullscreen='true'
			flashvars='vcastr_file=http://flv4.bn.netease.com/videolib3/1706/10/uJyNO0923/SD/uJyNO0923.flv&IsAutoPlay=0&IsContinue=1'
			quality='high'
			pluginspage='http://www.macromedia.com/go/getflashplayer'
			type='application/x-shockwave-flash' width='300' height='260' />
	</object>
	<div>网易</div>
</BODY>
</HTML>
