<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%
 
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
/* div {
	float: left;
	
} */
</style>
<title>网易全览</title>
</head>
<body>



<div>
<c:forEach items="${arraytype}" var="listType">
<script type="text/javascript">

var ff ="http://192.168.1.146:8877/APP/unis/videodetail.PHP?videotype=BoBo";
function stringToHex(ff){
	var val="";
	    temp = str.substring(0,7);
	    if(temp == 'http://'){
	        val = 'http://';
	        str = str.substring(7,str.length);
	    }
	for(var i = 0; i < str.length; i++){
	        if(str.charCodeAt(i) == '47') val += '/';
	        else if(str.charCodeAt(i) == '63') val += '?';
	        else if(str.charCodeAt(i) == '38') val += '&';
	        else if(str.charCodeAt(i) == '61') val += '=';
	        else if(str.charCodeAt(i) == '58') val += ':';
	else val += "%" + str.charCodeAt(i).toString(16);
	    }
	return val;
	}
	var str = "http://192.168.1.146:8877/APP/unis/videodetail.PHP?videotype=BoBo"; 
	stringToHex(ff);
	//alert(stringToHex(ff));
	 


</script>
 <a href="<%=request.getContextPath()%>/unis/videodetail.PHP?videotype=${listType.progType }&start=0&pageSzie=20"  onclick="stringToHex();" >${listType.progType }</a> 
 <a>：${listType.num }</a> 
 <br>
</c:forEach>
</div>
</body>
</html>