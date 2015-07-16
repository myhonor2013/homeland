/**
 * 
 */

$("#signup").click(signup);

function signup() {
	$(".empty").css("visibility", "hidden");
	$(this).text($(this).text() + "...");
	var username = $("#username").val();
	var password = $("#password").val();
	if (null == username || "" == username) {
		$("#empty_username").css("visibility", "visible");
		return;
	}
	if (null == password || "" == password) {
		$("#empty_password").css("visibility", "visible");
		return;
	}

	$.ajax({
		type : "POST",
		url : "login/login.action",
		data : {
			userInfo : {
				username : username,
				password : password
			},
			username : username,
			password : password
		},
		// dataType: "json",
		success : function(data) {
			if (data === "success") {
				window.location.href = "home.action";
			} else {
				$("#dlg").show();
			}
		},
		error : function(data) {
			$("#dlg").show();
		}
	});
}

$("#dlg_close").click(close_prompt_dlg);

$("#dlg_confirm").click(close_prompt_dlg);

function close_prompt_dlg() {
	$("#dlg").hide();
}