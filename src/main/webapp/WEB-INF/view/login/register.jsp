<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String urlRoot = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + request.getContextPath()+"/";
%>
<!DOCTYPE HTML>
<html>
  <head>
  	<base href="<%=urlRoot%>"/>
  	<meta http-equiv="content-type" content="text/html;charset=utf-8">
    <link rel= "Shortcut Icon" href= "image/favicon.ico" type="image/x-icon" >
	<link rel=stylesheet href="css/base.css" type="text/css" media=screen>
	<link rel=stylesheet href="css/login/register.css" type="text/css" media=screen>
    <title>Register now!</title>
  </head>
	<body>
	   <div class="nav"></div>
	   <div class="main">
	   		<div class="register">
	   			<input type="text" placeholder="用户名"/>
	   			<input type="text" placeholder="邮箱"/>
	   			<input type="password" placeholder="密码"/>
	   			<input type="password" placeholder="重复密码"/>
	   			<button id="submit">登录</button>
	   		</div>
	   </div>
	   <div class="footer"></div>
	</body>
</html>