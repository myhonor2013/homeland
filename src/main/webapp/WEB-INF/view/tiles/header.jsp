  <%@ page language="java"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <head>
  	  <link rel=stylesheet href="css/common/header.css">
  </head>
	<div class="login_info" id="login_info">
		Welcome you <a href="#"  target="_blank">${username}</a>
	</div>
	<div class="logout" id="logout">
		<a href="logout">log out</a>
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
  <script type="text/javascript" src="js/nav.js"></script>
</html>