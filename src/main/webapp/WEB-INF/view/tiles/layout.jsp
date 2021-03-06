<%@ page language="java"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>  
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML>
<html>
<% 
	String urlRoot = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + request.getContextPath()+"/"; 
%>
  <head>
  	  <base href="<%=urlRoot%>"/>
 	  <link rel= "Shortcut Icon" href= "image/favicon.ico" type="image/x-icon" >
  	  <link rel=stylesheet href="css/common/base.css">
      <title><tiles:insertAttribute name="title" /></title>
      <meta http-equiv="Cache-Control"content="max-age=-1"/>
	   <script type="text/javascript" src="js/lib/jquery-2.0.3.js"></script>
  </head>
  <body>
  <div id="header">
  		<tiles:insertAttribute name="header" />
   </div>
   <div id="side">
   		<tiles:insertAttribute name="side" />
   </div> 	
   <div id="body">
   		<tiles:insertAttribute name="body" />
   </div>
   <div id="footer">
   		<tiles:insertAttribute name="footer" />
   </div> 	
  <script type="text/javascript" src="js/home_header.js"></script>
 </body>
  <script type="text/javascript">
  	$(document).ready(function(){
  		$('.header_server a').addClass('high_tab');
  		$('#login_info>a').on('click',openPersonalSettings)
  	});
  	
  </script>
</html>