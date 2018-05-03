<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.test.main.*"%>


<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");

	FileUploder up = new FileUploder(request);
	up.setSavePath("upload"); //保存路径
	String[] fileType = { ".rar", ".doc", ".docx", ".zip", ".pdf",".txt", ".swf", ".wmv", ".gif", ".png", ".jpg", ".jpeg", ".bmp" }; //允许的文件类型
	up.setAllowFiles(fileType);
	up.setMaxSize(20000); //允许的文件最大尺寸，单位KB
	up.upload();
	//response.getWriter().print(
			//"{'url':'" + up.getUrl() + "','fileType':'" + up.getType()
					//+ "','state':'" + up.getState() + "','original':'"
					//+ up.getOriginalName() + "'}");
	System.out.print("{success:true,msg:'成功',url:'"+up.getUrl()+"',state:'"+up.getState()+"',original:'"+up.getOriginalName()+"'}");
	response.getWriter().print("{success:true,msg:'成功',url:'"+up.getUrl()+"',state:'"+up.getState()+"',original:'"+up.getOriginalName()+"'}");
	
%>