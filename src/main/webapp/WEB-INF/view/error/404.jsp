<%@ page language="java"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
  <head>
  		<% 
			String urlRoot = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + request.getContextPath()+"/";
		%>
		<base href="<%=urlRoot%>"/>
  	  <link rel= "Shortcut Icon" href= "image/favicon.ico" type="image/x-icon" >
  	  <link rel=stylesheet href="css/common/base.css">
      <title>天天网</title>
  </head>
  <body style="text-align:center;margin-top:200px;font-size: 40px;">
  	<h1 >抱歉，正在紧张施工中...</h1>
  </body>
</html>