<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">

handleMove (e) {
    var dom = $(".contract_list");//可滚动区域
    var scrollTop = dom.scrollTop();//获取滚动的距离

    this.endClientY = e.touches[0].clientY;//更新手指当前屏幕Y轴位置--结束位置
    console.log("结束位置:",this.endClientY)

    //判断是否滚动到底部
    if (scrollTop - this.lastscrolltop > 0) {
        this.lastscrolltop = dom.scrollTop()
        console.log("继续滚动，scrollTop:", scrollTop)
    } else if (scrollTop != 0 && this.lastscrolltop !=0 && scrollTop - this.lastscrolltop == 0) {
        alert("333");
    	console.log("到底了!")
    }

    //判断手指滑动方向
    if(e.touches[0].clientY < this.startClientY){
        this.movedirection = "UP";
    }else if(e.touches[0].clientY > this.startClientY){
        this.movedirection = "DOWN";
    }else{
        this.movedirection = "CENTER";
    }

    this.startClientY = e.touches[0].clientY;


</script>
</body>
</html>