  <%@ page language="java"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
	<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>  
	<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>
	<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<link rel=stylesheet href="css/photo/photo.css" type="text/css" media=screen>
	  <div class="photo">
		  <form method="post" enctype="multipart/form-data" action="photo/add">
		  	<label>请选择图片</label>
		  	<input type="file" name="photo"></input>
		  	<input type="submit" value="上传"/>
		  	</form>
	  </div>