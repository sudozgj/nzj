//var mainUrl = "http://192.168.1.1.226:8080/nzj/";
var mainUrl = "";
$(document).ready(function() {
	getDateShow();
});

//每隔30分钟提示用户登录失效
function check_login() {
	$.ajax({
		type: "post",
		url: mainUrl + "getSession",
		async: false,
		cache: false,
		success: function(data) {
			if(data.data == null) {
				if(confirm("用户登录已失效，是否重新登录？")) {
					location.href = "login.html";
				}
			}
		},
		error: function(data) {
			alert("error");
		}
	});
};

//根据ajax请求返回的code来提示用户是否登录
function main_code(c, m) {
	if(c == -999) {
		if(confirm("用户登录已失效，是否重新登录？")) {
			location.href = "login.html";
		}
	} else if(c == 1) {
		if(confirm("注册成功，是否重新登录？")) {
			location.href = "login.html";
		}
	} else {
		alert(m);
	}
}

//取Cookie的值  
function getCookie(name) {
	var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
	if(arr = document.cookie.match(reg)) return unescape(arr[2]);
	else return null;
}

var t = null;
t = setTimeout(getDateShow, 1000); //开始执行
function getDateShow() {
//	clearTimeout(t); //清除定时器
	var date = new Date();
	var seperator1 = "-";
	var seperator2 = ":";
	var month = date.getMonth() + 1;
	var strDate = date.getDate();
	var getHours = date.getHours(); //时
	var getMinutes = date.getMinutes(); //分
	var getSeconds = date.getSeconds(); //秒
	if(month >= 1 && month <= 9) {
		month = "0" + month;
	}
	if(strDate >= 0 && strDate <= 9) {
		strDate = "0" + strDate;
	}

	if(getHours >= 1 && getHours <= 9) {
		getHours = "0" + getHours;
	}
	if(getMinutes >= 1 && getMinutes <= 9) {
		getMinutes = "0" + getMinutes;
	}
	if(getSeconds >= 1 && getSeconds <= 9) {
		getSeconds = "0" + getSeconds;
	}
	var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate +
		" " + getHours + seperator2 + getMinutes +
		seperator2 + getSeconds;
	$('.timeShow').html(currentdate);
	t = setTimeout(getDateShow, 1000); //设定定时器，循环执行             
}

function changeTime(ts) { //时间戳转时间函数
	//	var timestamp = new Date(parseInt(ts) * 1000).toLocaleString().replace(/年|月/g, "-").substr(0, 8);
	var date = new Date(parseInt(ts) * 1000);
	var seperator1 = "-";
	var seperator2 = ":";
	var month = date.getMonth() + 1;
	var strDate = date.getDate();
	var getHours = date.getHours(); //时
	var getMinutes = date.getMinutes(); //分
	var getSeconds = date.getSeconds(); //秒
	if(month >= 1 && month <= 9) {
		month = "0" + month;
	}
	if(strDate >= 0 && strDate <= 9) {
		strDate = "0" + strDate;
	}

	if(getHours >= 1 && getHours <= 9) {
		getHours = "0" + getHours;
	}
	if(getMinutes >= 1 && getMinutes <= 9) {
		getMinutes = "0" + getMinutes;
	}
	if(getSeconds >= 1 && getSeconds <= 9) {
		getSeconds = "0" + getSeconds;
	}
	var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate +
		" " + getHours + seperator2 + getMinutes +
		seperator2 + getSeconds;
	//		$('#eTime').val(currentdate.substr(0,10));
	return currentdate.substr(0, 10);

};
