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
				
			} else {
				if(data.code == 1) {
					$("#userId").val(data.data.id);
					$("#id").val(data.data.did);
                    $("#support").val(data.data.support);
					$("#username").val(data.data.username);
					$("#company").val(data.data.company);
					$("#contact").val(data.data.contact);
					$("#telephone").val(data.data.telephone);
					$("#dphone").val(data.data.dphone);
					$("#address").val(data.data.address);
//					alert()
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
		} else if(!/^[0-9]*$/.test($("#dphone").val())) {
			alert("电话号码输入格式错误");
		} else {
			var formData = new FormData(document.getElementById("user_mod"));
			var s_province = document.getElementById('s_province').value;
			var s_city = document.getElementById('s_city').value;
			var address = document.getElementById('address').value;
			formData.append("address",s_province+'-'+s_city+'-'+address);
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
						$('#ModUser').modal('hide');
						alert('修改用户成功');
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

	//修改密码
	$('#btn_userpas_mod').click(function() {
		if($("#oPwd").val() == '' || $("#nPwd").val() == '' || $("#nPwds").val() == '') {
			alert("请完善信息！");
		} else if($("#nPwd").val() != $("#nPwds").val()) {
			alert("输入密码不一致！");
		} else {
			$.ajax({
				type: "post",
				url: "updateUserPassword",
				data: {
					oPwd: $("#oPwd").val(),
					nPwd: $("#nPwd").val()
				},
				async: false,
				cache: false,
				success: function(data) {
					//							main_code(data.code,data.msg);
					if(data.code == -999) {
						if(confirm("用户登录已失效，是否重新登录？")) {
							window.location.href = "login.html";
						}
					} else if(data.code == 1) {
						$('#ModUser').modal('hide');
						alert('修改用户成功');
					} else if(data.code == 0) {
						alert('旧密码输入错误');
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