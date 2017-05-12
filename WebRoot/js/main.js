//var mainUrl = "http://192.168.1.1.226:8080/nzj/";
var mainUrl = "";
$(document).ready(function() {
	
	for(var i = 0; i < 3; i++) {
		$('.nannyUl').append("<li id='nannyUl" + i + "' class='nannyClass'><img class='nannyUlImg' src='image/" + (i + 1) + ".png' /><a style='margin-left: 30px;' href='#a" + i + "'>aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa</a></li>")
	}
	//新闻栏列表
	var newText = ['未来家政行业的发展趋势', '你选择成为一名月嫂到底有前途吗？', '林志玲摇身一变成为月嫂！？', '某月嫂月入上万']
	for(var i = 0; i < 4; i++) {
		$('#newsUl').append("<li id='newsUl" + i + "' class='newsClass'>" + "<a title='" + newText[i] + "' href='#a" + i + "'>" + newText[i] + "</a>" + "</li>")
	}
	//公告栏列表
	var noticeUlText = ['《家政服务法律规及政策》', '《国务院办公厅关于发展家庭服务业的指导意见》', '《北京市人民政府办公厅关于鼓励发展家政服务业（"家七条"）的意见》', '《家政服务2017年规范》', '《2017年最新家政免责申明》', '《近日，商务部制定并下发了（家政服务合同）范本》'];
	for(var i = 0; i < 5; i++) {
		$('.noticeUl').append("<li style='list-style-type:none;' id='noticeUl" + i + "' class='noticeClass'><img class='noticeUlImg' src='image/file.png' /><a title='" + noticeUlText[i] + "' href='#a" + i + "'>" + noticeUlText[i] + "</a><img class='noticeUlImg' src='image/dowload.png' /></li>")
	}
	//	  alert(getCookie("username"));
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
	clearTimeout(t); //清除定时器
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

