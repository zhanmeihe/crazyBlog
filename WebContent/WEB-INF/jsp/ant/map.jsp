<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <!--<meta http-equiv="X-UA-Compatible" content="IE=edge">-->
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <title>蚂蚁阿奇定位</title>
    <link rel="stylesheet" href="http://cache.amap.com/lbs/static/main1119.css"/>
    <script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=f1f70d0e21ee4ee8b0a62c5eda7500fa&plugin=AMap.Geocoder"></script>
    <script type="text/javascript" src="http://cache.amap.com/lbs/static/addToolbar.js"></script>
</head>
<body onload="geocoder()">
<div id="container"></div>
<script type="text/javascript">
    var adress=window.sessionStorage.getItem('my-adress')?window.sessionStorage.getItem('my-adress'):"${Addressinfo}";

    var map = new AMap.Map("container", {
        resizeEnable: true,
    });
//    AMap.plugin(['AMap.ToolBar','AMap.Scale','AMap.OverView'], function(){
//            map.addControl(new AMap.ToolBar());
//            map.addControl(new AMap.Scale());
//            map.addControl(new AMap.OverView({isOpen:true}));
//        });
    AMap.plugin(['AMap.ToolBar', 'AMap.Scale', 'AMap.MapType'], function() {
        toolBar = new AMap.ToolBar();  //工具条
        scale = new AMap.Scale();    //比例尺
//        mapType = new AMap.MapType();   //地图种类
        map.addControl(toolBar);
        map.addControl(scale);
//        map.addControl(mapType);
    })
    function geocoder() {
        var geocoder = new AMap.Geocoder({
            city: "010", //城市，默认：“全国”
            radius: 1000 //范围，默认：500
        });
        //地理编码,返回地理编码结果
        geocoder.getLocation(adress,function(status, result) {
            if (status === 'complete' && result.info === 'OK') {
                geocoder_CallBack(result);
            }
        });
    }
    function addMarker(i, d) {
        var marker = new AMap.Marker({
            map: map,
            position: [ d.location.getLng(),  d.location.getLat()]
        });
        var infoWindow = new AMap.InfoWindow({
            content: d.formattedAddress,
            offset: {x: 0, y: -30}
        });
        marker.on("mouseover", function(e) {
            infoWindow.open(map, marker.getPosition());
        });
    }
    //地理编码返回结果展示
    function geocoder_CallBack(data) {
        var resultStr = "";
        //地理编码结果数组
        var geocode = data.geocodes;
        for (var i = 0; i < geocode.length; i++) {
            //拼接输出html
            resultStr += "<span style=\"font-size: 12px;padding:0px 0 4px 2px; border-bottom:1px solid #C1FFC1;\">" + "<b>地址</b>：" + geocode[i].formattedAddress + "" + "&nbsp;&nbsp;<b>的地理编码结果是:</b><b>&nbsp;&nbsp;&nbsp;&nbsp;坐标</b>：" + geocode[i].location.getLng() + ", " + geocode[i].location.getLat() + "" + "<b>&nbsp;&nbsp;&nbsp;&nbsp;匹配级别</b>：" + geocode[i].level + "</span>";
            addMarker(i, geocode[i]);
        }
        map.setFitView();
        //document.getElementById("result").innerHTML = resultStr;
    }
</script>
</body>
</html>