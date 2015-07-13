<!DOCTYPE HTML>
<%@ page language="java"  pageEncoding="UTF-8"%>
<html>
<% 
	//String urlRoot = "http://"+ request.getLocalAddr()+":"+ request.getLocalPort() + request.getContextPath(); 
	String urlRoot = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + request.getContextPath(); 
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
	  		<form>
				 <div class="login_input"> <input id="username" class="username fg6" name="username" type="text" placeholder="username"/>
				 	<span id="empty_username" class="empty fg7" style="visibility:hidden">Pls input username!</span>
			 	</div>
			     <div class="login_input"> <input id="password" class="password fg6" name="password" type="password"  placeholder="password"/>
			    	<span id="empty_password" class="empty fg7"  style="visibility:hidden">Pls input username!</span>
			    </div>	
		     	 <div class="submit"><a id="signup" class="submit bg2 fg1" href="#">Sign Up</a></div>
		    </form>      
	 	</div>
	 <div class="footer fg4">甘果版权所有。感谢楚橘。请联系<a class="fg2" href="mailto:mazhongbin@yeah.net" >mazhongbin@yeah.net</a></div>
	 <div id="dlg" style="display:none">
	 	<div class="dlg_bg"></div>
	 	<div class="dlg_info bg3">
	 		<div id="dlg_close" class="dlg_close"><a href="#">X</a></div>
	 		<div class="dlg_contents">Username or password isn't correct!</div>
	 		<div id="dlg_confirm" class="dlg_confirm"><a href="#" >OK</a></div>
	 	</div>
	 </div>
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
  <script type="text/javascript" src="<%=urlRoot%>/js/login/login.js"></script>
  <script type="text/javascript">
  	$(document).ready(function(){
  		$("#username").focus();
  		document.onkeydown=function(e){
  			if(!window.event){
  				return;
  			}
  			var keycode=e.keyCode;
  			switch(keycode){
  			case 13:
  				signup();
  				break;
  			default:
  				return;
  			}
  		};
  	});
  </script>
</html>