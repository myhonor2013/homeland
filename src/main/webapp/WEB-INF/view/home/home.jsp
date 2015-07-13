<!DOCTYPE HTML>
<%@ page language="java"  pageEncoding="UTF-8"%>
<html>
<% 
	String urlRoot = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + request.getContextPath(); 
	String username=(String)request.getAttribute("username");
%>
  <head>
 	  <link rel= "Shortcut Icon" href= "<%=urlRoot%>/image/favicon.ico" type="image/x-icon" >
  	  <link rel=stylesheet href="<%=urlRoot%>/css/base.css">
  	  <link rel=stylesheet href="<%=urlRoot%>/css/site/homesite.css">
      <title>Geek Home</title>
  </head>
  <script type="text/javascript" src="<%=urlRoot%>/js/lib/jquery-2.0.3.js"></script>
  <script type="text/javascript" src="<%=urlRoot%>/js/home_header.js"></script>
  <body>
  	<div class="home_top">
  		<div class="login_info">
  			Welcome you <a href="#" onclick="openPersonalSettings()" target="_blank"><%=username%></a>
  		</div>
  		<div class="logout">
  			<a href="<%=urlRoot%>/">log out</a>
  		</div>
  		<div class="li_header">
	  		<ul>
	  			<li class="header_server"><a href="#" onclick="openLinux()" target="_self">Linux</a> </li>
	  			<li class="header_storage"><a href="#" onclick="openStorage()" target="_self">Storage</a> </li>
	  			<li class="header_cpp"><a href="#" onclick="openCpp()" target="_self">C/CPP</a></li>
	  			<li class="header_web"><a href="#" onclick="openWeb()" target="_self">Web</a></li>
	  			<li class="header_db"><a href="#" onclick="openDb()" target="_self">Database</a></li>
	  		</ul>
  		</div>
   </div>
   <div class="nav">
   	<jsp:include page="linux/linux_nav.jsp" />
   </div>
   <div class="contents" id="contents" >
   	<jsp:include page="linux/linux.jsp" flush="true"/>
   </div>
 </body>
  <script type="text/javascript">
  	$(document).ready(function(){
  		$('.header_server a').addClass('high_tab');
  	});
  	
  </script>
</html>