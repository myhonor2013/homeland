<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//CN">
<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<html>
<% 
	String urlRoot = "http://localhost:8080" + request.getContextPath(); 
%>
  <head>
 	  <link rel= "Shortcut Icon" href= "<%=urlRoot%>/image/favicon.ico" type="image/x-icon" >
  	  <link rel=stylesheet href="<%=urlRoot%>/css/base.css">
  	  <link rel=stylesheet href="<%=urlRoot%>/css/contents/nav.css">
      <title>Linux Nav</title>
  </head>
  <script type="text/javascript" src="<%=urlRoot%>/js/lib/jquery-2.0.3.js"></script>
  <script type="text/javascript" src="<%=urlRoot%>/js/nav.js"></script>
  <body>
  	<div class="nav_title">Linux Nav</div>
  	<div class="nav_contents">
  		<div class="nav_first">
  			<div class="nav_first_menu">Source Code</div>
	  		<div class="nav_second">
	  		<a href="#" onclick="openLKD()" target="_self">LKD</a></div>
	  		<div class="nav_second">
	  		ULK</div>
	  		<div class="nav_second">
	  		Linux内核完全解析</div>
  		</div>
  		<div class="nav_first">
	  		<div class="nav_first_menu">Scripts</div>
	  		<div class="nav_second">
	  		Shell</div>
	  		<div class="nav_second">
	  		Sed</div>
	  		<div class="nav_second">
	  		awk</div>
	  		<div class="nav_second">
	  		python</div>
	  		<div class="nav_second">
	  		PHP</div>
  		</div>
  		<div class="nav_first">
  			<div class="nav_first_menu">Embedded Programming</div>
	  		<div class="nav_second">
	  		Boot Loader</div>
	  		<div class="nav_second">
	  		LFS</div>
	  		<div class="nav_second">
	  		Makefile</div>
	  		<div class="nav_second">
	  		Android</div>
  		</div>
  		<div class="nav_first">
  			<div class="nav_first_menu">Misc</div>
	  		<div class="nav_second">
	  		文章汇总</div>
	  		<div class="nav_second">
	  		学习记录</div>
  		</div>
  	</div>
 </body>
  <script type="text/javascript">
  	$(document).ready(function(){
  		//加title的超链接以制造单击显示隐藏效果
  		var title=$('.nav_title');
  		title.html('<a href="#" >'+title.text()+'</a>');
  		
  		var image='<img src="../image/minus.gif"/>';
  		$('.nav_contents .nav_first .nav_first_menu').each(function(){
  			$(this).html(image+'<a href="#" >'+$(this).text()+'</a>');
  			});
  		
  		
  		//title单击显示隐藏
  		title.click(function(){
  			onClickNavTitle();
  		});
  		
  		//一级菜单单击显示隐藏
  		$('.nav_first .nav_first_menu').click(function(){
  			onClickNavFirst(this);
  		});
  	});
  </script>
</html>