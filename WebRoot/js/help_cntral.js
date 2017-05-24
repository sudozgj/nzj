var json = null;
var total = null;
$(document).ready(function() {
	//添加共享保姆
	$('#add_share_aunt_btn').click(function() {
		var formData = new FormData(document.getElementById("add_aunt_form"));
		$.ajax({
			type: "post",
			url: mainUrl + "addShareAunt",
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
					$('#add_share_aunt').modal('hide');
					location.reload();
					alert('添加共享阿姨成功');
				} else {
					alert(data.msg);
				}
			},
			error: function(data) {
				alert("error");
			}
		});
	});

	//添加共享客户
	$('#add_share_clientele_btn').click(function() {
		var formData = new FormData(document.getElementById("add_clientele_form"));
		$.ajax({
			type: "post",
			url: mainUrl + "addShareEmployer",
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
					$('#add_share_clientele').modal('hide');
					location.reload();
					alert('添加共享客户成功');
				} else {
					alert(data.msg);
				}
			},
			error: function(data) {
				alert("error");
			}
		});
	});
});

function addShareNanny() {
	$("#myTabDrop1>span").text('添加共享保姆');
};

function shareNanny() {
	$("#myTabDrop1>span").text('已共享保姆');
};

function unShareNanny() {
	$("#myTabDrop1>span").text('未共享保姆');
};

//修改已共享保姆
function updateShareNanny(eachData) {
	$("input[type=reset]").trigger("click");
	$('#mod_contact').val(eachData.contact);
	$('#mod_phone').val(eachData.phone);
	$('#mod_skill').val(eachData.skill);
	$('#mod_remark').val(eachData.remark);
	$('#mod_share_aunt_btn').click(function() {
		$.ajax({
			type: "post",
			url: mainUrl + "updateShareAunt",
			data: {
				id: eachData.id,
				skill: $('#mod_skill').val(),
				remark: $('#mod_remark').val(),
				contact: $('#mod_contact').val(),
				phone: $('#mod_phone').val(),
				userId: eachData.userId,
				share: eachData.share
			},
			async: false,
			cache: false,
			success: function(data) {
				if(data.code == -999) {
					if(confirm("用户登录已失效，是否重新登录？")) {
						window.location.href = "login.html";
					}
				} else if(data.code == 1) {
					$('#mod_share_aunt').modal('hide');
					location.reload();
					alert('修改成功');
				} else {
					alert(data.msg);
				}
			},
			error: function(data) {
				alert("error");
			}
		});
	});
};

//删除已共享保姆
function deleteShareNanny(deleteId) {
	$.ajax({
		type: "post",
		url: mainUrl + "deleteShareAunt",
		data: {
			id: deleteId
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
				location.reload();
				alert('删除成功');
			} else {
				alert(data.msg);
			}
		},
		error: function(data) {
			alert("error");
		}
	});
};

//修改已共享客户
function updateShareClientele(eachData) {
	$("input[type=reset]").trigger("click");
	$('#mod_content').val(eachData.content);
	$('#mod_contact').val(eachData.contact);
	$('#mod_phone').val(eachData.phone);
	$('#mod_remark').val(eachData.remark);
	$('#mod_share_clientele_btn').click(function() {
		$.ajax({
			type: "post",
			url: mainUrl + "updateShareEmployer",
			data: {
				id: eachData.id,
				content: $('#mod_content').val(),
				contact: $('#mod_contact').val(),
				phone: $('#mod_phone').val(),
				remark: $('#mod_remark').val(),
				userId: eachData.userId,
				share: eachData.share
			},
			async: false,
			cache: false,
			success: function(data) {
				if(data.code == -999) {
					if(confirm("用户登录已失效，是否重新登录？")) {
						window.location.href = "login.html";
					}
				} else if(data.code == 1) {
					$('#mod_share_aunt').modal('hide');
					location.reload();
					alert('修改成功');
				} else {
					alert(data.msg);
				}
			},
			error: function(data) {
				alert("error");
			}
		});
	});
};

//删除已共享客户
function deleteShareClientele(deleteId) {
	$.ajax({
		type: "post",
		url: mainUrl + "deleteShareEmployer",
		data: {
			id: deleteId
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
				location.reload();
				alert('删除成功');
			} else {
				alert(data.msg);
			}
		},
		error: function(data) {
			alert("error");
		}
	});
};

/*********************************已共享客户分页列表（开始）***************************************/
var jsonClientele = null;
var totalClientele = null;
$(function() {
	//refreshData(20,1,10,json.length);
	var pageSize = 20;
	var pageNo = 1;
	builderUQTQueryMsgE(getJsonArrayByPageSizeE(pageSize, pageNo));

	var totalPage = getTotllePageE(pageSize);
	var totalRecords = totalClientele;
	//生成分页控件 根据分页的形式在这里设置
	kkpagerE.init({
		pno: pageNo,
		//总页码
		total: totalPage,
		//总数据条数
		totalRecords: totalRecords,
		//页面条数
		pageSize: pageSize
	});
	kkpagerE.generPageHtml();

});

/**
 * 获取总页数
 * @returns {number}
 */
var getTotllePageE = function(pageSize) {
		var jsonCount = totalClientele;
		var shang = jsonCount / pageSize;
		var yushu = jsonCount % pageSize;
		if(yushu > 0) {
			shang++;
		}
		return shang;
	}
	/**
	 * 获取分页后的数据
	 * @param pageSize分页后的条目数
	 * @param pageNo当前第几页
	 * @returns {*}
	 */
var getJsonArrayByPageSizeE = function(pageSize, pageNo) {
	$.ajax({
		type: "post",
		url: mainUrl + "getShareEmployerList",
		dataType: "json",
		async: false,
		cache: false,
		data: {
			'start': (pageNo - 1) * pageSize,
			'limit': pageSize
		},
		success: function(data) {
			if(data.code == -999) {
				if(confirm("用户登录已失效，是否重新登录？")) {
					window.parent.location.href = "login.html";
				}
			} else if(data.code == 1) {
				jsonClientele = data.data.result;
				totalClientele = data.data.count;
			} else {
				alert(data.msg);
			}

		},
		error: function(jqXHR) {
			alert("网络异常");
		}
	});
	var jsonCount = totalClientele;
	var shang = getTotllePageE(pageSize);
	//  var startIndex = (pageNo);
	//  var endIndex = (shang == pageNo)? jsonCount:pageSize;
	return jsonClientele.slice(0, 20);
}

/**
 * 刷新页面数据
 * @param pageSize   每页显示条数
 * @param pageNum    第几页
 */
function refreshData(pageSize, pageNo) {
	builderUQTQueryMsgE(getJsonArrayByPageSizeE(pageSize, pageNo));

	var totalPage = getTotllePageE(pageSize);
	var totalRecords = totalClientele;
	//生成分页控件 根据分页的形式在这里设置
	kkpagerE.init({
		pno: pageNo,
		//总页码
		total: totalPage,
		//总数据条数
		totalRecords: totalRecords,
		//页面条数
		pageSize: pageSize
	});
	kkpagerE.generPageHtml();

}

/**
 * 构建表格数据
 */
var builderUQTQueryMsgE = function(UQTQueryMsg) {
	var UQT_shareClienteleTable = $('#UQT_shareClienteleTable');
	UQT_shareClienteleTable.empty();
	var th = '<tr><th scope="col" class="eng_name" >需求</th><th scope="col" class="query_pro" >备注</th><th class="match_type" scope="col">联系人 </th><th scope="col"  class="match_type">联系电话</th><th class="match_type" scope="col">发布时间</th><th scope="col"  class="dis_dta">操作</th><th class="dis_hidden" style="display: none">隐藏属性</th></tr>';

	UQT_shareClienteleTable.append(th);
	var tr;
	$.each(UQTQueryMsg, function(i, eachData) {
		tr = $('<tr>');
		if(i % 2 == 0) {
			tr.css('background-color', '#f5f5f5');
		} else {
			tr.css('background-color', '#FFFFFF');
		};
		var listId = eachData.id;
		var listContent = eachData.content;
		var listRemark = eachData.remark;
		var listContact = eachData.contact;
		var listPhone = eachData.phone;
		var listTime = eachData.time;
		tr.append("<td class='eng_name'>" + listContent + "</td>" +
			"<td class='query_pro'>" + listRemark + "</td>" +
			"<td class='match_type'>" + listContact + "</td>" +
			"<td class='match_type'>" + listPhone + "</td>" +
			"<td class='match_type'>" + changeTime(listTime) + "</td>" +
			"<td class='dis_dta'>" +
			"<a class='editOp' href='' data-toggle='modal' data-target='#mod_share_clientele' onclick='updateShareClientele(" + JSON.stringify(eachData) + ")'>修改</a>" +
			"<a class='editOp' href='javascript:void(0);' onclick='deleteShareClientele(" + listId + ")'>删除</a>" +
			"</td>" +
			"<td class='dis_hidden' style='display: none'>" +
			"</td>"
		);
		UQT_shareClienteleTable.append(tr);
	});
}

/**
 * Created by huipu on 2016/1/28.
 *	分页插件
 */
var kkpagerE = {
	//divID
	pagerid: 'shareClientele_pager',
	//当前页码
	pno: 1,
	//总页码
	total: 1,
	//总数据条数
	totalRecords: 0,
	//是否显示总页数
	isShowTotalPage: true,
	//是否显示总记录数
	isShowTotalRecords: true,
	//是否显示页码跳转输入框
	isGoPage: true,
	//页面条数默认大小
	pagesize: 20,
	//链接前部
	hrefFormer: '',
	//链接尾部
	hrefLatter: '',
	/****链接算法****/
	getLink: function(n) {
		//这里的算法适用于比如：
		//hrefFormer=http://baidu.com/news/20131212
		//hrefLatter=.html
		//那么首页（第1页）就是http://baidu.com/news/20131212.html
		//第2页就是http://baidu.com/news/20131212_2.html
		//第n页就是http://baidu.com/news/20131212_n.html
		if(n == 1) {
			return this.hrefFormer + this.hrefLatter;
		} else {
			return this.hrefFormer + '_' + n + this.hrefLatter;
		}
	},
	//跳转框得到输入焦点时
	focus_gopage: function() {
		var btnGo = $('#btn_go');
		$('#btn_go_input').attr('hideFocus', true);
		btnGo.show();
		btnGo.css('left', '0px');
		$('#go_page_wrap').css('border-color', '#6694E3');
		btnGo.animate({
			left: '+=44'
		}, 50, function() {
			//$('#go_page_wrap').css('width','88px');
		});
	},

	//跳转框失去输入焦点时

	blur_gopage: function() {
		setTimeout(function() {
			var btnGo = $('#btn_go');
			//$('#go_page_wrap').css('width','44px');
			btnGo.animate({
				left: '-=44'
			}, 100, function() {
				$('#btn_go').css('left', '0px');
				$('#btn_go').hide();
				$('#go_page_wrap').css('border-color', '#DFDFDF');
			});
		}, 400);
	},
	//根据页数刷新页面数据
	gopage: function(data) {
		var currentPage = '';
		if(data.tagName == 'A') {
			//点击的是a标签，这里写你的代码
			var tempPage = $(data).html();
			if(tempPage == '下一页') {
				currentPage = parseInt(this.pno) + 1;
			} else if(tempPage == '上一页') {
				currentPage = parseInt(this.pno) - 1;
			} else {
				currentPage = tempPage;
			}
		} else {
			//手动输入要跳转的页数
			var str_page = $("#btn_go_input").val();
			if(isNaN(str_page)) {
				$("#btn_go_input").val(this.next);
				return;
			}
			var n = parseInt(str_page);
			if(n < 1 || n > this.totalClientele) {
				$("#btn_go_input").val(this.next);
				return;
			}
			currentPage = n;
		}
		refreshData(this.pagesize, currentPage);
		//不管是点击页码还是手动输入页码，都要将下一页的页码选中
		//此时，只需要重新加载本组件即可
	},
	changepageSize: function(data) {
		//更改每页显示条数
		//刷新数据时初始化页数为1，
		var pageSize = $(data).val();
		//alert('要初始化的页面条数为:'+pageSize);
		refreshData(pageSize, 1);
	},
	//分页按钮控件初始化
	init: function(config) {

		//页面条数初始化
		this.pagesize = config.pageSize;
		//赋值
		this.pno = isNaN(config.pno) ? 1 : parseInt(config.pno);
		this.totalClientele = isNaN(config.totalClientele) ? 1 : parseInt(config.totalClientele);
		this.totalRecords = isNaN(config.totalRecords) ? 0 : parseInt(config.totalRecords);
		if(config.pagerid) {
			this.pagerid = pagerid;
		}
		if(config.isShowTotalPage != undefined) {
			this.isShowTotalPage = config.isShowTotalPage;
		}
		if(config.isShowTotalRecords != undefined) {
			this.isShowTotalRecords = config.isShowTotalRecords;
		}
		if(config.isGoPage != undefined) {
			this.isGoPage = config.isGoPage;
		}
		this.hrefFormer = config.hrefFormer || '';
		this.hrefLatter = config.hrefLatter || '';
		if(config.getLink && typeof(config.getLink) == 'function') {
			this.getLink = config.getLink;
		}
		//验证
		if(this.pno < 1) this.pno = 1;
		this.totalClientele = (this.totalClientele <= 1) ? 1 : this.totalClientele;
		if(this.pno > this.totalClientele) this.pno = this.totalClientele;
		this.prv = (this.pno <= 2) ? 1 : (this.pno - 1);
		this.next = (this.pno >= this.totalClientele - 1) ? this.totalClientele : (this.pno + 1);
		this.hasPrv = (this.pno > 1);
		this.hasNext = (this.pno < this.totalClientele);

		this.inited = true;
	},
	//生成分页控件Html
	generPageHtml: function() {
		if(!this.inited) {
			return;
		}

		var str_prv = '',
			str_next = '';
		if(this.hasPrv) {
			str_prv = '<a href="javascript:void(0);"  onclick="kkpagerE.gopage(this);" title="上一页">上一页</a>';
			//str_prv = '<a href="javascript:void(0);""javascript:void(0);""' + this.getLink(this.prv) + '" title="上一页">上一页</a>';
		} else {
			str_prv = '<span class="disabled">上一页</span>';
		}

		if(this.hasNext) {
			str_next = '<a href="javascript:void(0);" onclick="kkpagerE.gopage(this);"  title="下一页">下一页</a>';
			//str_next = '<a href="javascript:void(0);""javascript:void(0);""' + this.getLink(this.next) + '" title="下一页">下一页</a>';
		} else {
			str_next = '<span class="disabled">下一页</span>';
		}

		var str = '';
		var dot = '<span>...</span>';
		var total_info = '';
		if(this.isShowTotalPage || this.isShowTotalRecords) {
			total_info = '<span class="normalsize">共';
			if(this.isShowTotalPage) {
				total_info += this.totalClientele + '页';
				if(this.isShowTotalRecords) {
					total_info += '&nbsp;/&nbsp;';
				}
			}
			if(this.isShowTotalRecords) {
				total_info += this.totalRecords + '条数据';
			}

			total_info += '</span>';
		}

		var pageSize = '<select id="select_pagesize" onchange="kkpagerE.changepageSize(this)">';

		if(this.pagesize == 10)
			pageSize += '<option selected="selected" value="10" >10</option>';
		else
			pageSize += '<option  value="10" >10</option>';
		if(this.pagesize == 15)
			pageSize += '<option selected="selected" value="15" >15</option>';
		else
			pageSize += '<option  value="15" >15</option>';
		if(this.pagesize == 20)
			pageSize += '<option selected="selected" value="20" >20</option>';
		else
			pageSize += '<option  value="20" >20</option>';
		pageSize += '</select><span class="normalsize" >条/页</span>';

		var gopage_info = '';
		if(this.isGoPage) {
			gopage_info = '&nbsp;<span class="normalsize" >转到</span><span id="go_page_wrap" style="display:inline-block;width:44px;height:18px;border:1px solid #DFDFDF;margin:0px 1px;padding:0px;position:relative;left:0px;top:5px;">' +
				'<input type="button" id="btn_go" onclick="kkpagerE.gopage(this);" style="width:44px;height:20px;line-height:20px;padding:0px;font-family:arial,宋体,sans-serif;text-align:center;border:0px;background-color:#0063DC;color:#FFF;position:absolute;left:0px;top:-1px;display:none;" value="确定" />' +
				'<input type="text" id="btn_go_input" onfocus="kkpagerE.focus_gopage()" onkeypress="if(event.keyCode<48 || event.keyCode>57)return false;" onblur="kkpagerE.blur_gopage()" style="width:42px;height:16px;text-align:center;border:0px;position:absolute;left:0px;top:0px;outline:none;" value="' + this.pno + '" /></span><span class="normalsize" >页</span>';
		}

		//分页处理
		if(this.totalClientele <= 8) {
			for(var i = 1; i <= this.totalClientele; i++) {
				if(this.pno == i) {
					str += '<span class="curr">' + i + '</span>';
				} else {
					str += '<a href="javascript:void(0);" onclick="kkpagerE.gopage(this);" title="第' + i + '页">' + i + '</a>';
				}
			}
		} else {
			if(this.pno <= 5) {
				for(var i = 1; i <= 7; i++) {
					if(this.pno == i) {
						str += '<span class="curr">' + i + '</span>';
					} else {
						str += '<a href="javascript:void(0);" onclick="kkpagerE.gopage(this);" title="第' + i + '页">' + i + '</a>';
					}
				}
				str += dot;
			} else {
				str += '<a href="javascript:void(0);" onclick="kkpagerE.gopage(this);" title="第1页">1</a>';
				str += '<a href="javascript:void(0);" onclick="kkpagerE.gopage(this);" title="第2页">2</a>';
				str += dot;

				var begin = this.pno - 2;
				var end = this.pno + 2;
				if(end > this.totalClientele) {
					end = this.totalClientele;
					begin = end - 4;
					if(this.pno - begin < 2) {
						begin = begin - 1;
					}
				} else if(end + 1 == this.totalClientele) {
					end = this.totalClientele;
				}
				for(var i = begin; i <= end; i++) {
					if(this.pno == i) {
						str += '<span class="curr">' + i + '</span>';
					} else {
						str += '<a href="javascript:void(0);" onclick="kkpagerE.gopage(this);" title="第' + i + '页">' + i + '</a>';
					}
				}
				if(end != this.totalClientele) {
					str += dot;
				}
			}
		}

		str = "&nbsp;" + pageSize + "&nbsp;" + str_prv + str + str_next + total_info + gopage_info;
		$("#" + this.pagerid).html(str);
	}
};

function getParameter(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if(r != null) return unescape(r[2]);
	return null;
};

/*********************************已共享客户分页列表（开始）***************************************/

/*********************************已共享保姆分页列表（开始）***************************************/
$(function() {
	//refreshData(20,1,10,json.length);
	var pageSize = 10;
	var pageNo = 1;
	builderUQTQueryMsg(getJsonArrayByPageSize(pageSize, pageNo));

	var totalPage = getTotllePage(pageSize);
	var totalRecords = total;
	//生成分页控件 根据分页的形式在这里设置
	kkpager.init({
		pno: pageNo,
		//总页码
		total: totalPage,
		//总数据条数
		totalRecords: totalRecords,
		//页面条数
		pageSize: pageSize
	});
	kkpager.generPageHtml();

});

/**
 * 获取总页数
 * @returns {number}
 */
var getTotllePage = function(pageSize) {
		var jsonCount = total;
		var shang = jsonCount / pageSize;
		var yushu = jsonCount % pageSize;
		if(yushu > 0) {
			shang++;
		}
		return shang;
	}
	/**
	 * 获取分页后的数据
	 * @param pageSize分页后的条目数
	 * @param pageNo当前第几页
	 * @returns {*}
	 */
var getJsonArrayByPageSize = function(pageSize, pageNo) {
	$.ajax({
		type: "post",
		url: mainUrl + "getShareAuntList",
		dataType: "json",
		async: false,
		cache: false,
		data: {
			'start': (pageNo - 1) * pageSize,
			'limit': pageSize
		},
		success: function(data) {
			if(data.code == -999) {
				if(confirm("用户登录已失效，是否重新登录？")) {
					window.parent.location.href = "login.html";
				}
			} else if(data.code == 1) {
				json = data.data.result;
				total = data.data.count
			} else {
				alert(data.msg);
			}
			//			console.log(JSON.stringify(data))
			//			builderUQTQueryMsg(data);

		},
		error: function(jqXHR) {
			alert("网络异常");
		}
	});
	var jsonCount = total;
	var shang = getTotllePage(pageSize);
	//  var startIndex = (pageNo);
	//  var endIndex = (shang == pageNo)? jsonCount:pageSize;
	return json.slice(0, 10);
}

/**
 * 刷新页面数据
 * @param pageSize   每页显示条数
 * @param pageNum    第几页
 */
function refreshData(pageSize, pageNo) {
	builderUQTQueryMsg(getJsonArrayByPageSize(pageSize, pageNo));

	var totalPage = getTotllePage(pageSize);
	var totalRecords = total;
	//生成分页控件 根据分页的形式在这里设置
	kkpager.init({
		pno: pageNo,
		//总页码
		total: totalPage,
		//总数据条数
		totalRecords: totalRecords,
		//页面条数
		pageSize: pageSize
	});
	kkpager.generPageHtml();

}

/**
 * 构建表格数据
 */
var builderUQTQueryMsg = function(UQTQueryMsg) {
	var UQT_shareNannyTable = $('#UQT_shareNannyTable');
	UQT_shareNannyTable.empty();
	var th = '<tr><th scope="col" class="eng_name" >联系人</th><th scope="col" class="query_pro" >联系电话</th><th class="match_type" scope="col">技能</th><th scope="col"  class="dis_order">备注</th><th scope="col"  class="dis_dta">操作</th><th class="dis_hidden" style="display: none">隐藏属性</th></tr>';

	UQT_shareNannyTable.append(th);
	var tr;
	$.each(UQTQueryMsg, function(i, eachData) {
		tr = $('<tr>');
		if(i % 2 == 0) {
			tr.css('background-color', '#f5f5f5');
		} else {
			tr.css('background-color', '#FFFFFF');
		}
		//      alert(total%2==0);
		//      tr.css('background-color','red');
		var listId = eachData.id;
		var listContact = eachData.contact;
		var listPhone = eachData.phone;
		var listSkill = eachData.skill;
		var listRemark = eachData.remark;
		tr.append("<td class='eng_name'>" + listContact + "</td>" +
			"<td class='query_pro'>" + listPhone + "</td>" +
			"<td class='match_type'>" + listSkill + "</td>" +
			"<td class='dis_order'>" + listRemark + "</td>" +
			"<td class='dis_dta'>" +
			"<a class='editOp' href='' data-toggle='modal' data-target='#mod_share_aunt' onclick='updateShareNanny(" + JSON.stringify(eachData) + ")'>修改</a>" +
			"<a class='editOp' href='javascript:void(0);' onclick='deleteShareNanny(" + listId + ")'>删除</a>" +
			"</td>" +
			"<td class='dis_hidden' style='display: none'></td>"
		);
		UQT_shareNannyTable.append(tr);
	});
}

/**
 * Created by huipu on 2016/1/28.
 *	分页插件
 */
var kkpager = {
	//divID
	pagerid: 'shareNanny_pager',
	//当前页码
	pno: 1,
	//总页码
	total: 1,
	//总数据条数
	totalRecords: 0,
	//是否显示总页数
	isShowTotalPage: true,
	//是否显示总记录数
	isShowTotalRecords: true,
	//是否显示页码跳转输入框
	isGoPage: true,
	//页面条数默认大小
	pagesize: 10,
	//链接前部
	hrefFormer: '',
	//链接尾部
	hrefLatter: '',
	/****链接算法****/
	getLink: function(n) {
		//这里的算法适用于比如：
		//hrefFormer=http://baidu.com/news/20131212
		//hrefLatter=.html
		//那么首页（第1页）就是http://baidu.com/news/20131212.html
		//第2页就是http://baidu.com/news/20131212_2.html
		//第n页就是http://baidu.com/news/20131212_n.html
		if(n == 1) {
			return this.hrefFormer + this.hrefLatter;
		} else {
			return this.hrefFormer + '_' + n + this.hrefLatter;
		}
	},
	//跳转框得到输入焦点时
	focus_gopage: function() {
		var btnGo = $('#btn_go');
		$('#btn_go_input').attr('hideFocus', true);
		btnGo.show();
		btnGo.css('left', '0px');
		$('#go_page_wrap').css('border-color', '#6694E3');
		btnGo.animate({
			left: '+=44'
		}, 50, function() {
			//$('#go_page_wrap').css('width','88px');
		});
	},

	//跳转框失去输入焦点时

	blur_gopage: function() {
		setTimeout(function() {
			var btnGo = $('#btn_go');
			//$('#go_page_wrap').css('width','44px');
			btnGo.animate({
				left: '-=44'
			}, 100, function() {
				$('#btn_go').css('left', '0px');
				$('#btn_go').hide();
				$('#go_page_wrap').css('border-color', '#DFDFDF');
			});
		}, 400);
	},
	//根据页数刷新页面数据
	gopage: function(data) {
		var currentPage = '';
		if(data.tagName == 'A') {
			//点击的是a标签，这里写你的代码
			var tempPage = $(data).html();
			if(tempPage == '下一页') {
				currentPage = parseInt(this.pno) + 1;
			} else if(tempPage == '上一页') {
				currentPage = parseInt(this.pno) - 1;
			} else {
				currentPage = tempPage;
			}
		} else {
			//手动输入要跳转的页数
			var str_page = $("#btn_go_input").val();
			if(isNaN(str_page)) {
				$("#btn_go_input").val(this.next);
				return;
			}
			var n = parseInt(str_page);
			if(n < 1 || n > this.total) {
				$("#btn_go_input").val(this.next);
				return;
			}
			currentPage = n;
		}
		refreshData(this.pagesize, currentPage);
		//不管是点击页码还是手动输入页码，都要将下一页的页码选中
		//此时，只需要重新加载本组件即可
	},
	changepageSize: function(data) {
		//更改每页显示条数
		//刷新数据时初始化页数为1，
		var pageSize = $(data).val();
		//alert('要初始化的页面条数为:'+pageSize);
		refreshData(pageSize, 1);
	},
	//分页按钮控件初始化
	init: function(config) {

		//页面条数初始化
		this.pagesize = config.pageSize;
		//赋值
		this.pno = isNaN(config.pno) ? 1 : parseInt(config.pno);
		this.total = isNaN(config.total) ? 1 : parseInt(config.total);
		this.totalRecords = isNaN(config.totalRecords) ? 0 : parseInt(config.totalRecords);
		if(config.pagerid) {
			this.pagerid = pagerid;
		}
		if(config.isShowTotalPage != undefined) {
			this.isShowTotalPage = config.isShowTotalPage;
		}
		if(config.isShowTotalRecords != undefined) {
			this.isShowTotalRecords = config.isShowTotalRecords;
		}
		if(config.isGoPage != undefined) {
			this.isGoPage = config.isGoPage;
		}
		this.hrefFormer = config.hrefFormer || '';
		this.hrefLatter = config.hrefLatter || '';
		if(config.getLink && typeof(config.getLink) == 'function') {
			this.getLink = config.getLink;
		}
		//验证
		if(this.pno < 1) this.pno = 1;
		this.total = (this.total <= 1) ? 1 : this.total;
		if(this.pno > this.total) this.pno = this.total;
		this.prv = (this.pno <= 2) ? 1 : (this.pno - 1);
		this.next = (this.pno >= this.total - 1) ? this.total : (this.pno + 1);
		this.hasPrv = (this.pno > 1);
		this.hasNext = (this.pno < this.total);

		this.inited = true;
	},
	//生成分页控件Html
	generPageHtml: function() {
		if(!this.inited) {
			return;
		}

		var str_prv = '',
			str_next = '';
		if(this.hasPrv) {
			str_prv = '<a href="javascript:void(0);"  onclick="kkpager.gopage(this);" title="上一页">上一页</a>';
			//str_prv = '<a href="javascript:void(0);""javascript:void(0);""' + this.getLink(this.prv) + '" title="上一页">上一页</a>';
		} else {
			str_prv = '<span class="disabled">上一页</span>';
		}

		if(this.hasNext) {
			str_next = '<a href="javascript:void(0);" onclick="kkpager.gopage(this);"  title="下一页">下一页</a>';
			//str_next = '<a href="javascript:void(0);""javascript:void(0);""' + this.getLink(this.next) + '" title="下一页">下一页</a>';
		} else {
			str_next = '<span class="disabled">下一页</span>';
		}

		var str = '';
		var dot = '<span>...</span>';
		var total_info = '';
		if(this.isShowTotalPage || this.isShowTotalRecords) {
			total_info = '<span class="normalsize">共';
			if(this.isShowTotalPage) {
				total_info += this.total + '页';
				if(this.isShowTotalRecords) {
					total_info += '&nbsp;/&nbsp;';
				}
			}
			if(this.isShowTotalRecords) {
				total_info += this.totalRecords + '条数据';
			}

			total_info += '</span>';
		}

		var pageSize = '<select id="select_pagesize" onchange="kkpager.changepageSize(this)">';

		if(this.pagesize == 10)
			pageSize += '<option selected="selected" value="10" >10</option>';
		else
			pageSize += '<option  value="10" >10</option>';
		if(this.pagesize == 15)
			pageSize += '<option selected="selected" value="15" >15</option>';
		else
			pageSize += '<option  value="15" >15</option>';
		pageSize += '</select><span class="normalsize" >条/页</span>';

		var gopage_info = '';
		if(this.isGoPage) {
			gopage_info = '&nbsp;<span class="normalsize" >转到</span><span id="go_page_wrap" style="display:inline-block;width:44px;height:18px;border:1px solid #DFDFDF;margin:0px 1px;padding:0px;position:relative;left:0px;top:5px;">' +
				'<input type="button" id="btn_go" onclick="kkpager.gopage(this);" style="width:44px;height:20px;line-height:20px;padding:0px;font-family:arial,宋体,sans-serif;text-align:center;border:0px;background-color:#0063DC;color:#FFF;position:absolute;left:0px;top:-1px;display:none;" value="确定" />' +
				'<input type="text" id="btn_go_input" onfocus="kkpager.focus_gopage()" onkeypress="if(event.keyCode<48 || event.keyCode>57)return false;" onblur="kkpager.blur_gopage()" style="width:42px;height:16px;text-align:center;border:0px;position:absolute;left:0px;top:0px;outline:none;" value="' + this.pno + '" /></span><span class="normalsize" >页</span>';
		}

		//分页处理
		if(this.total <= 8) {
			for(var i = 1; i <= this.total; i++) {
				if(this.pno == i) {
					str += '<span class="curr">' + i + '</span>';
				} else {
					str += '<a href="javascript:void(0);" onclick="kkpager.gopage(this);" title="第' + i + '页">' + i + '</a>';
				}
			}
		} else {
			if(this.pno <= 5) {
				for(var i = 1; i <= 7; i++) {
					if(this.pno == i) {
						str += '<span class="curr">' + i + '</span>';
					} else {
						str += '<a href="javascript:void(0);" onclick="kkpager.gopage(this);" title="第' + i + '页">' + i + '</a>';
					}
				}
				str += dot;
			} else {
				str += '<a href="javascript:void(0);" onclick="kkpager.gopage(this);" title="第1页">1</a>';
				str += '<a href="javascript:void(0);" onclick="kkpager.gopage(this);" title="第2页">2</a>';
				str += dot;

				var begin = this.pno - 2;
				var end = this.pno + 2;
				if(end > this.total) {
					end = this.total;
					begin = end - 4;
					if(this.pno - begin < 2) {
						begin = begin - 1;
					}
				} else if(end + 1 == this.total) {
					end = this.total;
				}
				for(var i = begin; i <= end; i++) {
					if(this.pno == i) {
						str += '<span class="curr">' + i + '</span>';
					} else {
						str += '<a href="javascript:void(0);" onclick="kkpager.gopage(this);" title="第' + i + '页">' + i + '</a>';
					}
				}
				if(end != this.total) {
					str += dot;
				}
			}
		}

		str = "&nbsp;" + pageSize + "&nbsp;" + str_prv + str + str_next + total_info + gopage_info;
		$("#" + this.pagerid).html(str);
	}
};

function getParameter(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if(r != null) return unescape(r[2]);
	return null;
};

/*********************************已共享保姆分页列表（开始）***************************************/

/*********************************未共享保姆分页列表（开始）***************************************/
var jsonUnShareNanny = null;
var totalUnShareNanny = null;
$(function() {
	//refreshData(20,1,10,json.length);
	var pageSize = 20;
	var pageNo = 1;
	builderUQTQueryMsgC(getJsonArrayByPageSizeC(pageSize, pageNo));

	var totalPage = getTotllePageC(pageSize);
	var totalRecords = totalUnShareNanny;
	//生成分页控件 根据分页的形式在这里设置
	kkpagerC.init({
		pno: pageNo,
		//总页码
		total: totalPage,
		//总数据条数
		totalRecords: totalRecords,
		//页面条数
		pageSize: pageSize
	});
	kkpagerC.generPageHtml();

});

/**
 * 获取总页数
 * @returns {number}
 */
var getTotllePageC = function(pageSize) {
		var jsonCount = totalUnShareNanny;
		var shang = jsonCount / pageSize;
		var yushu = jsonCount % pageSize;
		if(yushu > 0) {
			shang++;
		}
		return shang;
	}
	/**
	 * 获取分页后的数据
	 * @param pageSize分页后的条目数
	 * @param pageNo当前第几页
	 * @returns {*}
	 */
var getJsonArrayByPageSizeC = function(pageSize, pageNo) {
	$.ajax({
		type: "post",
		url: mainUrl + "getUnShareAuntList",
		dataType: "json",
		async: false,
		cache: false,
		data: {
			'start': (pageNo - 1) * pageSize,
			'limit': pageSize
		},
		success: function(data) {
			if(data.code == -999) {
				if(confirm("用户登录已失效，是否重新登录？")) {
					window.parent.location.href = "login.html";
				}
			} else if(data.code == 1) {
				jsonUnShareNanny = data.data.result;
				totalUnShareNanny = data.data.count;
			} else {
				alert(data.msg);
			}

		},
		error: function(jqXHR) {
			alert("网络异常");
		}
	});
	var jsonCount = totalUnShareNanny;
	var shang = getTotllePageC(pageSize);
	//  var startIndex = (pageNo);
	//  var endIndex = (shang == pageNo)? jsonCount:pageSize;
	return jsonUnShareNanny.slice(0, 20);
}

/**
 * 刷新页面数据
 * @param pageSize   每页显示条数
 * @param pageNum    第几页
 */
function refreshData(pageSize, pageNo) {
	builderUQTQueryMsgC(getJsonArrayByPageSizeC(pageSize, pageNo));

	var totalPage = getTotllePageC(pageSize);
	var totalRecords = totalUnShareNanny;
	//生成分页控件 根据分页的形式在这里设置
	kkpagerC.init({
		pno: pageNo,
		//总页码
		total: totalPage,
		//总数据条数
		totalRecords: totalRecords,
		//页面条数
		pageSize: pageSize
	});
	kkpagerC.generPageHtml();

}

/**
 * 构建表格数据
 */
var builderUQTQueryMsgC = function(UQTQueryMsg) {
	var UQT_unShareNannyTable = $('#UQT_unShareNannyTable');
	UQT_unShareNannyTable.empty();
	var th = '<tr><th scope="col" class="eng_name" >需求</th><th scope="col" class="query_pro" >备注</th><th class="match_type" scope="col">联系人 </th><th scope="col"  class="match_type">联系电话</th><th class="match_type" scope="col">发布时间</th><th class="dis_hidden" style="display: none">隐藏属性</th></tr>';

	UQT_unShareNannyTable.append(th);
	var tr;
	$.each(UQTQueryMsg, function(i, eachData) {
		tr = $('<tr>');
		if(i % 2 == 0) {
			tr.css('background-color', '#f5f5f5');
		} else {
			tr.css('background-color', '#FFFFFF');
		};
		var listContent = eachData.content;
		var listRemark = eachData.remark;
		var listContact = eachData.contact;
		var listPhone = eachData.phone;
		var listTime = eachData.time;
		tr.append("<td class='eng_name'>" + listContent + "</td>" +
			"<td class='query_pro'>" + listRemark + "</td>" +
			"<td class='match_type'>" + listContact + "</td>" +
			"<td class='match_type'>" + listPhone + "</td>" +
			"<td class='match_type'>" + changeTime(listTime) + "</td>" +
			"<td class='dis_hidden' style='display: none'>" +
			"</td>"
		);
		UQT_unShareNannyTable.append(tr);
	});
}

/**
 * Created by huipu on 2016/1/28.
 *	分页插件
 */
var kkpagerC = {
	//divID
	pagerid: 'unShareNanny_pager',
	//当前页码
	pno: 1,
	//总页码
	total: 1,
	//总数据条数
	totalRecords: 0,
	//是否显示总页数
	isShowTotalPage: true,
	//是否显示总记录数
	isShowTotalRecords: true,
	//是否显示页码跳转输入框
	isGoPage: true,
	//页面条数默认大小
	pagesize: 20,
	//链接前部
	hrefFormer: '',
	//链接尾部
	hrefLatter: '',
	/****链接算法****/
	getLink: function(n) {
		//这里的算法适用于比如：
		//hrefFormer=http://baidu.com/news/20131212
		//hrefLatter=.html
		//那么首页（第1页）就是http://baidu.com/news/20131212.html
		//第2页就是http://baidu.com/news/20131212_2.html
		//第n页就是http://baidu.com/news/20131212_n.html
		if(n == 1) {
			return this.hrefFormer + this.hrefLatter;
		} else {
			return this.hrefFormer + '_' + n + this.hrefLatter;
		}
	},
	//跳转框得到输入焦点时
	focus_gopage: function() {
		var btnGo = $('#btn_go');
		$('#btn_go_input').attr('hideFocus', true);
		btnGo.show();
		btnGo.css('left', '0px');
		$('#go_page_wrap').css('border-color', '#6694E3');
		btnGo.animate({
			left: '+=44'
		}, 50, function() {
			//$('#go_page_wrap').css('width','88px');
		});
	},

	//跳转框失去输入焦点时

	blur_gopage: function() {
		setTimeout(function() {
			var btnGo = $('#btn_go');
			//$('#go_page_wrap').css('width','44px');
			btnGo.animate({
				left: '-=44'
			}, 100, function() {
				$('#btn_go').css('left', '0px');
				$('#btn_go').hide();
				$('#go_page_wrap').css('border-color', '#DFDFDF');
			});
		}, 400);
	},
	//根据页数刷新页面数据
	gopage: function(data) {
		var currentPage = '';
		if(data.tagName == 'A') {
			//点击的是a标签，这里写你的代码
			var tempPage = $(data).html();
			if(tempPage == '下一页') {
				currentPage = parseInt(this.pno) + 1;
			} else if(tempPage == '上一页') {
				currentPage = parseInt(this.pno) - 1;
			} else {
				currentPage = tempPage;
			}
		} else {
			//手动输入要跳转的页数
			var str_page = $("#btn_go_input").val();
			if(isNaN(str_page)) {
				$("#btn_go_input").val(this.next);
				return;
			}
			var n = parseInt(str_page);
			if(n < 1 || n > this.totalUnShareNanny) {
				$("#btn_go_input").val(this.next);
				return;
			}
			currentPage = n;
		}
		refreshData(this.pagesize, currentPage);
		//不管是点击页码还是手动输入页码，都要将下一页的页码选中
		//此时，只需要重新加载本组件即可
	},
	changepageSize: function(data) {
		//更改每页显示条数
		//刷新数据时初始化页数为1，
		var pageSize = $(data).val();
		//alert('要初始化的页面条数为:'+pageSize);
		refreshData(pageSize, 1);
	},
	//分页按钮控件初始化
	init: function(config) {

		//页面条数初始化
		this.pagesize = config.pageSize;
		//赋值
		this.pno = isNaN(config.pno) ? 1 : parseInt(config.pno);
		this.totalUnShareNanny = isNaN(config.totalUnShareNanny) ? 1 : parseInt(config.totalUnShareNanny);
		this.totalRecords = isNaN(config.totalRecords) ? 0 : parseInt(config.totalRecords);
		if(config.pagerid) {
			this.pagerid = pagerid;
		}
		if(config.isShowTotalPage != undefined) {
			this.isShowTotalPage = config.isShowTotalPage;
		}
		if(config.isShowTotalRecords != undefined) {
			this.isShowTotalRecords = config.isShowTotalRecords;
		}
		if(config.isGoPage != undefined) {
			this.isGoPage = config.isGoPage;
		}
		this.hrefFormer = config.hrefFormer || '';
		this.hrefLatter = config.hrefLatter || '';
		if(config.getLink && typeof(config.getLink) == 'function') {
			this.getLink = config.getLink;
		}
		//验证
		if(this.pno < 1) this.pno = 1;
		this.totalUnShareNanny = (this.totalUnShareNanny <= 1) ? 1 : this.totalUnShareNanny;
		if(this.pno > this.totalUnShareNanny) this.pno = this.totalUnShareNanny;
		this.prv = (this.pno <= 2) ? 1 : (this.pno - 1);
		this.next = (this.pno >= this.totalUnShareNanny - 1) ? this.totalUnShareNanny : (this.pno + 1);
		this.hasPrv = (this.pno > 1);
		this.hasNext = (this.pno < this.totalUnShareNanny);

		this.inited = true;
	},
	//生成分页控件Html
	generPageHtml: function() {
		if(!this.inited) {
			return;
		}

		var str_prv = '',
			str_next = '';
		if(this.hasPrv) {
			str_prv = '<a href="javascript:void(0);"  onclick="kkpagerC.gopage(this);" title="上一页">上一页</a>';
			//str_prv = '<a href="javascript:void(0);""javascript:void(0);""' + this.getLink(this.prv) + '" title="上一页">上一页</a>';
		} else {
			str_prv = '<span class="disabled">上一页</span>';
		}

		if(this.hasNext) {
			str_next = '<a href="javascript:void(0);" onclick="kkpagerC.gopage(this);"  title="下一页">下一页</a>';
			//str_next = '<a href="javascript:void(0);""javascript:void(0);""' + this.getLink(this.next) + '" title="下一页">下一页</a>';
		} else {
			str_next = '<span class="disabled">下一页</span>';
		}

		var str = '';
		var dot = '<span>...</span>';
		var total_info = '';
		if(this.isShowTotalPage || this.isShowTotalRecords) {
			total_info = '<span class="normalsize">共';
			if(this.isShowTotalPage) {
				total_info += this.totalUnShareNanny + '页';
				if(this.isShowTotalRecords) {
					total_info += '&nbsp;/&nbsp;';
				}
			}
			if(this.isShowTotalRecords) {
				total_info += this.totalRecords + '条数据';
			}

			total_info += '</span>';
		}

		var pageSize = '<select id="select_pagesize" onchange="kkpagerC.changepageSize(this)">';

		if(this.pagesize == 10)
			pageSize += '<option selected="selected" value="10" >10</option>';
		else
			pageSize += '<option  value="10" >10</option>';
		if(this.pagesize == 15)
			pageSize += '<option selected="selected" value="15" >15</option>';
		else
			pageSize += '<option  value="15" >15</option>';
		if(this.pagesize == 20)
			pageSize += '<option selected="selected" value="20" >20</option>';
		else
			pageSize += '<option  value="20" >20</option>';
		pageSize += '</select><span class="normalsize" >条/页</span>';

		var gopage_info = '';
		if(this.isGoPage) {
			gopage_info = '&nbsp;<span class="normalsize" >转到</span><span id="go_page_wrap" style="display:inline-block;width:44px;height:18px;border:1px solid #DFDFDF;margin:0px 1px;padding:0px;position:relative;left:0px;top:5px;">' +
				'<input type="button" id="btn_go" onclick="kkpagerC.gopage(this);" style="width:44px;height:20px;line-height:20px;padding:0px;font-family:arial,宋体,sans-serif;text-align:center;border:0px;background-color:#0063DC;color:#FFF;position:absolute;left:0px;top:-1px;display:none;" value="确定" />' +
				'<input type="text" id="btn_go_input" onfocus="kkpagerC.focus_gopage()" onkeypress="if(event.keyCode<48 || event.keyCode>57)return false;" onblur="kkpagerC.blur_gopage()" style="width:42px;height:16px;text-align:center;border:0px;position:absolute;left:0px;top:0px;outline:none;" value="' + this.pno + '" /></span><span class="normalsize" >页</span>';
		}

		//分页处理
		if(this.totalUnShareNanny <= 8) {
			for(var i = 1; i <= this.totalUnShareNanny; i++) {
				if(this.pno == i) {
					str += '<span class="curr">' + i + '</span>';
				} else {
					str += '<a href="javascript:void(0);" onclick="kkpagerC.gopage(this);" title="第' + i + '页">' + i + '</a>';
				}
			}
		} else {
			if(this.pno <= 5) {
				for(var i = 1; i <= 7; i++) {
					if(this.pno == i) {
						str += '<span class="curr">' + i + '</span>';
					} else {
						str += '<a href="javascript:void(0);" onclick="kkpagerC.gopage(this);" title="第' + i + '页">' + i + '</a>';
					}
				}
				str += dot;
			} else {
				str += '<a href="javascript:void(0);" onclick="kkpagerC.gopage(this);" title="第1页">1</a>';
				str += '<a href="javascript:void(0);" onclick="kkpagerC.gopage(this);" title="第2页">2</a>';
				str += dot;

				var begin = this.pno - 2;
				var end = this.pno + 2;
				if(end > this.totalUnShareNanny) {
					end = this.totalUnShareNanny;
					begin = end - 4;
					if(this.pno - begin < 2) {
						begin = begin - 1;
					}
				} else if(end + 1 == this.totalUnShareNanny) {
					end = this.totalUnShareNanny;
				}
				for(var i = begin; i <= end; i++) {
					if(this.pno == i) {
						str += '<span class="curr">' + i + '</span>';
					} else {
						str += '<a href="javascript:void(0);" onclick="kkpagerC.gopage(this);" title="第' + i + '页">' + i + '</a>';
					}
				}
				if(end != this.totalUnShareNanny) {
					str += dot;
				}
			}
		}

		str = "&nbsp;" + pageSize + "&nbsp;" + str_prv + str + str_next + total_info + gopage_info;
		$("#" + this.pagerid).html(str);
	}
};

function getParameter(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if(r != null) return unescape(r[2]);
	return null;
};
/*********************************未共享保姆分页列表（结束）***************************************/