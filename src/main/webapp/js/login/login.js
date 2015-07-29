/**
 * 
 */

$("#signup").on('click', signup);
$(".locales").on("mouseover", showLocale);
$(".locale").on("mouseover", highlight);
$(".locale").on("mouseout", unHighlight);
$(".locales").on("mouseout", hideLocale);
$(".locale").on("click", switchLocale);
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
		url : "",
		// dataType : "json",
		contentType : 'application/json;charset=UTF-8',
		data : JSON.stringify({
			username : username,
			password : password
		}),
		success : function(data) {
			if (data === "success") {
				window.location.href = "user/" + username;
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
	window.location.href = "?localeName="
			+ $(this).find("input[type='hidden'][name='localeName']").val();
}