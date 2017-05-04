function login() {
	var username = $('.username').val();
	var password = $('.password').val();
	$.ajax({
		type: "post",
		url: mainUrl+"login",
		dataType: "json",
		data: {
			'phone': username,
			'password':password,
		},
		success: function(data) {
			if(data.code=='1'){
                 SetCookie("username", data.username);
                 location.href = "index.html";
			}else{
				$('.loginMsg').html(data.msg);
			}
		}
//		error: function(jqXHR) {
//			$('.loginMsg').html('网络异常');
//		}
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