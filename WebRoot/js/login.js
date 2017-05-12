function login() {
	var username = $('.username').val();
	var password = $('.password').val();
	var md5 = hex_md5(password+'nzj');
	$.ajax({
		type: "post",
		url: "login",
		dataType: "json",
		cache: false,
		data: {
			'phone': username,
			'password':md5,
		},
		success: function(data) {
			if(data.code=='1'){
				//mainCode = data.code;
				//SetCookie('name', data.msg);
                 location.href = "index.html";
			}else if(data.code=='-1'){
				alert(data.msg);
				location.href = "checkUserDetail.html";
			}else{
				$('.loginMsg').html(data.msg);
			}
		},
		error: function(jqXHR) {
			$('.loginMsg').html('网络异常');
		}
	});
}

function youkeLogin(){
	$.ajax({
		type: "post",
		url: "logout",
		dataType: "json",
		cache: false,
		success: function(data) {
			location.href="index.html";
		},
		error: function(jqXHR) {
			$('.loginMsg').html('网络异常');
		}
	});
}

//写入到Cookie  
//name:cookie名称  value:cookie值   
function SetCookie(name, value) {  
    var Days = 30;  
    var exp = new Date();  
    exp.setTime(exp.getTime() + 7*24*60*60*1000);//过期时间7天
    document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString();  
}  