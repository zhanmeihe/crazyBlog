<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <%--  <script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/ueditor1_4_3/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/ueditor1_4_3/ueditor.all.min.js"> </script> --%>
<style type="text/css">  
.news {  
    width: 800px;  
    margin: 0 auto;  
}  
</style>
</head>
<body>
<%  
        request.setCharacterEncoding("utf-8");  
        String newsbody = request.getParameter("editorValue");  
    %>  
  
    <div class="news">  
        <%=newsbody%>  
  
    </div> 
 
 

</body>
</html>