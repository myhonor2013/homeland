<%@ page language="java"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
<% 
	String urlRoot = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + request.getContextPath()+"/";
%>
<base href="<%=urlRoot%>"/>
<link rel=stylesheet href="<%=urlRoot%>/css/base.css">
<title>Oops!</title>
</head>
<body>
<h3>Error occurs!</h3>
<a href="">http://localhost:8080/first/index.jsp</a>
</body>
</html>