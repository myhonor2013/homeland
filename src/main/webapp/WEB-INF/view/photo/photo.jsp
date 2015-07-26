  <%@ page language="java"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
	<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>  
	<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>
	<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<head>
		<meta http-equiv="Cache-Control"content="max-age=0"/>
	</head>
	<link rel=stylesheet href="css/photo/photo.css" type="text/css" media=screen>
	  <div class="photo">
		  <form method="post" enctype="multipart/form-data" action="photo/photo">
			  	<label>请选择图片</label>
			  	<input type="file" name="photo"></input>
			  	<input type="submit" value="上传"/>
		  	</form>
		  	<div class="show">
		  		<img alt="还没有图片" src="${photo}">
			  	<div class="play">
			  		<div class="go prev" ></div>
			  		<div class="go next"></div>
			  	</div>
		  	</div>
	  </div>
	  <script>
	  $(".photo .play").on("mouseover", showIcon);
	  $(".photo img").on("mouseover", showIcon);
	  $(".photo .play").on("mouseout", hideIcon);
	  $(".photo img").on("mouseout", hideIcon);
	  function showIcon() {
	  	$(".photo .play").show();
	  }
	  function hideIcon() {
	  	$(".photo .play").hide();
	  }
	  
	  $(document).ready(function(){
		  $(".prev").on('click',function(){go(-1)});
		  $(".next").on('click',function(){go(1)});
		  
		  function go(direction){
			  var picUrl=$(".show>img").attr("src");
			  $.ajax({
					type : "GET",
					url : "photo/getPhoto",
					// dataType : "json",
					data : {
						curPic : (picUrl.substring(picUrl.lastIndexOf("/")+1)),
						direction : direction
					},
					success : function(data) {
						$(".show>img").attr("src",data);
						$("input[name='picName']").val(data.substring(data.lastIndexOf("/")+1));
					},
					error : function(data) {
					}
				}); 
		  }
	  	});
	  </script>