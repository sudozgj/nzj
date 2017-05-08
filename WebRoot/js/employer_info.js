function a() {
	$.ajax({
		type: "post",
		url: mainUrl + "getEmployerList",
		dataType: "json",
		data: {
			'start': 0,
			'limit': 15
		},
		success: function(data) {
			console.log(JSON.stringify(data))
		},
		error: function(jqXHR) {
			alert("网络异常");
		}
	});
}