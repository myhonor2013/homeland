<%@page import="java.util.ResourceBundle"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="org.myhonor.tinystar.framework.Constants" %>
<%@ page import="java.util.Locale" %>
<%
    String urlRoot = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + request.getContextPath()+"/";
	String localeName=(String)request.getSession().getAttribute(Constants.LOCALENAME);
	String[] localeArr=localeName.split("_");
	Locale locale=new Locale(localeArr[0],localeArr[1]);
    ResourceBundle resource = ResourceBundle.getBundle("org.myhonor.tinystar.resources.tinystar",
            locale);
%>
<!DOCTYPE HTML>
<html>
  <head>
  	<base href="<%=urlRoot%>"/>
  	<meta http-equiv="content-type" content="text/html;charset=utf-8">
    <link rel= "Shortcut Icon" href= "image/favicon.ico" type="image/x-icon" >
	<link rel=stylesheet href="css/common/base.css" type="text/css" media=screen>
	<link rel=stylesheet href="css/login/login.css" type="text/css" media=screen>
    <title>Please login:</title>
  </head>
  
  
  <body>
	  <div class="right_bar">
		  <a href="register" class="bg1 fg1"><%= resource.getString("login.signup") %></a>
		  <div class="locales">
			  <div class="bg1 fg1 cur_locale">中文<input type="hidden" name="localeName" value="zh_CN"/></div>
			  <div class="locale">English<input type="hidden" name="localeName" value="en_US"/></div>
		  </div>
	  </div>
	  <div class="login fg2">
	  	<div class="label fg3"><%= resource.getString("site.name") %></div>
	  		<form name="user">
				 <div class="login_input"> <input id="username" class="username fg6" name="username" type="text" placeholder="username"/>
				 	<span id="empty_username" class="empty fg7" style="visibility:hidden"><%= resource.getString("username.empty") %></span>
			 	</div>
			     <div class="login_input"> <input id="password" class="password fg6" name="password" type="password"  placeholder="password"/>
			    	<span id="empty_password" class="empty fg7"  style="visibility:hidden"><%= resource.getString("password.empty") %></span>
			    </div>	
		     	 <div class="submit"><a id="signup" class="submit bg2 fg1" href="#"><%= resource.getString("login.signin") %></a></div>
		    </form>      
	 	</div>
	 <div class="footer fg4"><%= resource.getString("right.declare") %><a class="fg2" href="mailto:mazhongbin@yeah.net" > mazhongbin@yeah.net</a></div>
	 <div id="dlg" style="display:none">
	 	<div class="dlg_bg"></div>
	 	<div class="dlg_info bg3">
	 		<div id="dlg_close" class="dlg_close"><a href="#">X</a></div>
	 		<div class="dlg_contents">Username or password isn't correct!</div>
	 		<div id="dlg_confirm" class="dlg_confirm"><a href="#" >OK</a></div>
	 	</div>
	 </div>
 </body>
 <script type="text/javascript" src="js/lib/jquery-2.0.3.js"></script>
  <script type="text/javascript" src="js/login/login.js"></script>
  <script type="text/javascript">
  	$(document).ready(function(){
  		$("#username").focus();
  		$(".locale").hide();
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
  		
  		//处理语言选择
  		var snkLangHtml=$("input[type='hidden'][name='localeName'][value=${localeName}]");
  		var snkLang=snkLangHtml.parent();
  		if(!snkLang.hasClass("cur_locale")){
	  		var curLang=$(".cur_locale");
	  		var tmp=snkLang.html();
	  		snkLang.html(curLang.html());
	  		curLang.html(tmp);
  		}
  	});
  </script>
</html>