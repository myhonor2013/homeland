  <%@ page language="java"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <head>
  	  <link rel=stylesheet href="css/common/side.css">
  </head>
  	<div class="nav_title">导航</div>
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
  <script type="text/javascript" src="js/nav.js"></script>
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