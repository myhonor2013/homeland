<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//CN">
<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<html>
<% 
	//String urlRoot = "http://"+ request.getLocalAddr()+":"+ request.getLocalPort() + request.getContextPath(); 
	String urlRoot = "http://localhost:9080" + request.getContextPath(); 
%>
  <head>
  	<meta http-equiv="content-type" content="text/html;charset=utf-8">
 	  <link rel= "Shortcut Icon" href= "<%=urlRoot%>/image/favicon.ico" type="image/x-icon" >
  	  <link rel=stylesheet href="<%=urlRoot%>/css/base.css" type="text/css" media=screen>
  	  <link rel=stylesheet href="<%=urlRoot%>/css/login/loginstyle.css" type="text/css" media=screen>
      <title>Please login:</title>
  </head>
  <script type="text/javascript" src="<%=urlRoot%>/js/lib/jquery-2.0.3.js"></script>
  <body>
	  <div class="register bg1"><a href="#" class="fg1">register</a></div>
	  <div class="login fg2">
	  	<div class="label fg3">甘楚家园</div>
	  	<form class="form" name="form" method="post" action="login.action">
	  	  <div class="login_input">
			 <div> <input id="username" class="username fg6" name="username" type="text" placeholder="username"/> </div>
		     <div> <input id="password" class="password fg6" name="password" type="password"  placeholder="password"/><br/> </div>
	      </div>
	      <input class="submit bg2 fg1" type="submit" value="Sign Up" />
	 	</form>
	  </div>
	 <div class="footer fg4">甘果版权所有。感谢楚橘。请联系<a class="fg2" href="mailto:mazhongbin@yeah.net" >mazhongbin@yeah.net</a></div>
 </body>
<!--  
  <body>
      <s:form name="login" action="login" method="post" >
          <s:textfield name="username" label="username"></s:textfield>
          <s:password name="password"  label="password"></s:password>
          <s:submit></s:submit>
      </s:form>
  </body>
  -->
  <script type="text/javascript">
  
  </script>
</html>