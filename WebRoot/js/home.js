$(document).ready(function() {
	//获取主页面阿姨共享列表
	$.ajax({
		type: "post",
		url: "getAllShareAuntList",
		data: {
			start: 0,
			limit: 8
		},
		async: false,
		cache: false,
		success: function(data) {
			if(data.code == 1) {
				//加载主页客户列表
				var nanny_table = $('#nanny_table');
				nanny_table.empty();
                var td = '';
                for (i=0; i<data.data.result.length; i++) {
                	if(i%2==0){
                		td += "<tr style='background: #e0e0e0;'><td class='home_table'><img src='image/3.png' /></td><td class='home_table1'>需求："+data.data.result[i].contact+"</td><td class='home_table4'>技能："+data.data.result[i].skill+"</td><td class='home_table2'>联系电话："+data.data.result[i].phone+"</td><td class='home_table3'>发布时间："+changeTime(data.data.result[i].time)+"</td></tr>"
                	}else{
                		td += "<tr><td class='home_table'><img src='image/3.png' /></td><td class='home_table1'>需求："+data.data.result[i].contact+"</td><td class='home_table4'>技能："+data.data.result[i].skill+"</td><td class='home_table2'>联系电话："+data.data.result[i].phone+"</td><td class='home_table3'>发布时间："+changeTime(data.data.result[i].time)+"</td></tr>"
                	};
                };
                nanny_table.append(td);
			} else {
				alert(data.msg);
				location.href = "login.html";
			}
		},
		error: function(data) {
			alert("error");
		}
	});
	//获取主页面客户共享列表
	$.ajax({
		type: "post",
		url: "getAllShareEmployerList",
		data: {
			start: 0,
			limit: 8
		},
		async: false,
		cache: false,
		success: function(data) {
			if(data.code == 1) {
				//加载主页客户列表
				var clientele_table = $('#clientele_table');
				clientele_table.empty();
                var td = '';
                for (i=0; i<data.data.result.length; i++) {
                	if(i%2==0){
                		td += "<tr style='background: #e0e0e0;'><td class='home_table'><img src='image/3.png' /></td><td class='home_table1'>需求："+data.data.result[i].contact+"</td><td class='home_table4'></td><td class='home_table2'>联系电话："+data.data.result[i].phone+"</td><td class='home_table3'>发布时间："+changeTime(data.data.result[i].time)+"</td></tr>"
                	}else{
                		td += "<tr><td class='home_table'><img src='image/3.png' /></td><td class='home_table1'>需求："+data.data.result[i].contact+"</td><td class='home_table4'></td><td class='home_table2'>联系电话："+data.data.result[i].phone+"</td><td class='home_table3'>发布时间："+changeTime(data.data.result[i].time)+"</td></tr>"
                	};
                	
                };
                clientele_table.append(td);
			} else {
				alert(data.msg);
				location.href = "login.html";
			}
		},
		error: function(data) {
			alert("error");
		}
	});
	$('.more_span').click(function() {
});
});

