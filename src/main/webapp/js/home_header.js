function openLinux(){
clearSelectedClass();
$(".header_server a").addClass("high_tab");
}
function openStorage(){
	clearSelectedClass();
	$(".header_storage a").addClass("high_tab");
}
function openCpp(){
	clearSelectedClass();
	$(".header_cpp a").addClass("high_tab");
}
function openWeb(){
	clearSelectedClass();
	$(".header_web a").addClass("high_tab");
}
function openDb(){
	clearSelectedClass();
	$(".header_db a").addClass("high_tab");
}
function clearSelectedClass(){
	$(".header_server a").removeClass("high_tab");
$(".header_storage a").removeClass("high_tab");
$(".header_cpp a").removeClass("high_tab");
$(".header_web a").removeClass("high_tab");
$(".header_db a").removeClass("high_tab");
}

function openPersonalSettings(){
	var username='myhonor';
	$.ajax({
		  type: 'POST',
		  url: 'openPersonalSettings.action',
		  data: {username:username},
		  dataType: 'json',
		  success: function (res){
			  var a=res;
			  var b=res.test;
		  }
		});
}