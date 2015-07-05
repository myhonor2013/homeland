<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<% 
	//String urlRoot = "http://"+ request.getLocalAddr()+":"+ request.getLocalPort() + request.getContextPath(); 
	String urlRoot = "http://localhost:8080" + request.getContextPath(); 
	String username=(String)request.getAttribute("username");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="<%=urlRoot%>/css/base.css">
<title>Oops!</title>
</head>
<body>
<h3>Error occurs!</h3>
<a href="http://localhost:8080/first/index.jsp">http://localhost:8080/first/index.jsp</a>
</body>
</html>