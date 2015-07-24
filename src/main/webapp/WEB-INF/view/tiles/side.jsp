  <%@ page language="java"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
	<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>  
	<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>
	<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
  <head>
  	  <link rel=stylesheet href="css/common/side.css">
  </head>
  	<div class="nav_title">导航</div>
  	<div class="nav_contents">
		<c:forEach var="nav" items="${navs}">
			<c:choose>
				<c:when test="${nav.orderno==cur}"><div class="nav_item curItem"></c:when>
				<c:otherwise><div class="nav_item"></c:otherwise>
			</c:choose>
				<a href="${nav.url}">${nav.name}</a>
			</div>
			<s:url value="/nav/${nav.name}" var="navUrl"></s:url>
		</c:forEach>
  	</div>
  <script type="text/javascript" src="js/nav.js"></script>
  <script type="text/javascript">
  	$(document).ready(function(){
  		//加title的超链接以制造单击显示隐藏效果
  		var title=$('.nav_title');
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