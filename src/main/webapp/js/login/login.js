/**
 * 
 */

$("#signup").on('click', signup);
$(".locales").on("mouseover", showLocale);
$(".locale").on("mouseover", highlight);
$(".locale").on("mouseout", unHighlight);
$(".locales").on("mouseout", hideLocale);
$(".locales").on("click", switchLocale);
function hideLocale() {
	$(".locale").hide();
}
function showLocale() {
	$(".locale").show();
}
function highlight() {
	$(this).css("background-color", "#953268");
}
function unHighlight() {
	$(this).css("background-color", "#329541");
}
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
				window.location.href = "home/home.action";
			} else {
				$("#dlg").show();
			}
		},
		error : function(data) {
			$("#dlg").show();
		}
	});
}

$("#dlg_close").click(closePromptDlg);

$("#dlg_confirm").click(closePromptDlg);

function closePromptDlg() {
	$("#dlg").hide();
}

function switchLocale() {
	window.location.href = "index.action?"
			+ encodeURIComponent("localeName="
					+ $("input[type='hidden'][name='localeName']").val());
}