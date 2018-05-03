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
    <title>施工详情</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
    <script src="<%=request.getContextPath()%>/js/jquery-1.10.1.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/common.js"></script>
    <script src="<%=request.getContextPath()%>/js/swipeslider.min.js"></script>
</head>
<script type="text/javascript"> 
       function doSubmit(){ 
            var file = document.getElementById('FILE_VIDE'); 
           /*  var file2 = document.getElementById('FILE_VIDE2'); 
            var file3 = document.getElementById('FILE_VIDE3');  */
            if (file.value == "" ) { 
alert("请上传您的视频！"); 
 
 return false;
} 
       } 
</script> 

<body class="goal_bg">
    <div class="index">
    <form action="<%=request.getContextPath()%>/workin/Clockin.shtml" onsubmit="return doSubmit();" method="post" enctype="multipart/form-data">
        <div class="">
            <div class="m-order-title">施工详情</div>
        </div>
        <div class="g-details">
            <div class="m-clock-in">
                <span class="in">上班打卡</span>
                <span>2017-7-7</span>
            </div>
            <div class="m-check-audio">
                <!--<div class="check-arrive">验收视频</div>-->
                <div class="work">
                    <span class="go-work">抵达现场</span>
                    <div class="s-scene">
                        <ul>
                            <li><input name="headPic" id="FILE_VIDE" type="file" value="请录制现场视频">请录制现场视频</li>
                            <li><input name="headPic" id="FILE_VIDE" type="file" value="请录制现场视频">请录制现场视频</li>
                            <li><input name="headPic" id="FILE_VIDE" type="file" value="请录制现场视频">请录制现场视频</li>
                        </ul>
                    </div>
                </div>
                <input type="hidden" name="userId" value="${userId}"/>
                <input type="hidden" name="taskId" value="${taskId}"/>
                <div class="work">
                    <span class="go-work">施工过程</span>
                    <div class="s-scene">
                        <ul>
                            <li><input name="headPic" id="FILE_VIDE2" type="file" value="施工过程视频">施工过程视频</li>
                            <li><input name="headPic" id="FILE_VIDE2" type="file" value="施工过程视频">施工过程视频</li>
                            <li><input name="headPic" id="FILE_VIDE2" type="file" value="施工过程视频">施工过程视频</li>
                        </ul>
                    </div>
                </div>
                <div class="work">
                    <span class="go-work">当日工作结束</span>
                    <div class="s-scene">
                        <ul>
                            <li><input name="headPic" id="FILE_VIDE3" type="file" value="工作结束视频">工作结束视频</li>
                            <li><input name="headPic" id="FILE_VIDE3" type="file" value="工作结束视频">工作结束视频</li>
                            <li><input name="headPic" id="FILE_VIDE3" type="file" value="工作结束视频">工作结束视频</li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="g-field m-fieldBottom"><input type="submit" value="确定" class="sure-aubio"></div>
        </div>
        </form>
    </div>
    <script src=<%=request.getContextPath()%>/js/details.js></script>
</body>
</html>