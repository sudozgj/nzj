$(function() {
	//获取用户信息
	$.ajax({
		type: "post",
		url: mainUrl + "getUser",
		async: false,
		cache: false,
		success: function(data) {
			//							main_code(data.code,data.msg);
			if(data.code == -999) {
				if(confirm("用户登录已失效，是否重新登录？")) {
					window.parent.location.href = "login.html";
				}
			} else {
				if(data.code == 1) {
					console.log(JSON.stringify(data));
					$("#userId").val(data.data.id);
					$("#id").val(data.data.did);

					$("#username_info").val(data.data.username);
					$("#company_info").val(data.data.company);
					$("#contact_info").val(data.data.contact);
					$("#telephone_info").val(data.data.telephone);
					$("#dphone_info").val(data.data.dphone);
					$("#address_info").val(data.data.address);

					$("#username").val(data.data.username);
					$("#company").val(data.data.company);
					$("#contact").val(data.data.contact);
					$("#telephone").val(data.data.telephone);
					$("#dphone").val(data.data.dphone);
					$("#address").val(data.data.address);
				} else {
					alert(data.msg);
				}
			}
		},
		error: function(data) {
			alert("error");
		}
	});

	//修改用户信息
	$('#btn_user_mod').click(function() {
		if($("#username").val() == '' || $("#company").val() == '' || $("#contact").val() == '' || $("#telephone").val() == '' || $("#dphone").val() == '' || $("#address").val() == '') {
			alert("标有'*'号为必填信息");
		} else if(!/^[0-9]*$/.test($("#telephone").val())) {
            alert("手机号码输入格式错误");
		} else if(!/^[0-9]*$/.test($("#dphone").val())){
			alert("电话号码输入格式错误");
		}else {
			var formData = new FormData(document.getElementById("user_mod"));
			$.ajax({
				type: "post",
				url: "updateUserDetail",
				data: formData,
				async: false,
				cache: false,
				contentType: false,
				processData: false,
				success: function(data) {
					//							main_code(data.code,data.msg);
					if(data.code == -999) {
						if(confirm("用户登录已失效，是否重新登录？")) {
							window.location.href = "login.html";
						}
					} else if(data.code == 1) {
						window.location.href = "user_info.html";
					} else {
						alert(data.msg);
					}
				},
				error: function(data) {
					alert("error");
				}
			});
		};
	});
});