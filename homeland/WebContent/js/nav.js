function onClickNavTitle(){
	$('.nav_contents .nav_first .nav_second').each(function(){
		$(this).slideToggle('300');
	});
	loadNodeStatus();
}

function onClickNavFirst(obj){
	$(obj).siblings().each(function(){
		$(this).slideToggle('300');
	});
	doLoad(obj);
}	
	
function loadNodeStatus(){
	$('.nav_contents .nav_first .nav_first_menu').each(function(){
		doLoad(this);
		});
}

function doLoad(obj){
	var image;
	var regx = new RegExp("display: block","g");
	if($(obj).siblings() && $($(obj).siblings()[0]).attr('style') && !$($(obj).siblings()[0]).attr('style').match(regx)){
		image='<img src="../image/plus.gif"/>';
		}
	else{
		image='<img src="../image/minus.gif"/>';
	}
	$(obj).html(image+'<a href="#" >'+$(obj).text()+'</a>');
}

function openLKD(){
//	$(".contents").text('');
	$(".contents").html('<div class="contents" id="contents" ><jsp:include page="linux/LKD.jsp" flush="true"/></div>');
	//$(".contents").html('Hello');
}