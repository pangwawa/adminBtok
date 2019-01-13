$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'generator/user/list',
        datatype: "json",
        colModel: [			
			{ label: 'userId', name: 'userId', index: 'user_id', width: 50, key: true },
			{ label: '用户名', name: 'username', index: 'username', width: 80 }, 			
			{ label: '手机号', name: 'mobile', index: 'mobile', width: 80 }, 			
			{ label: '密码', name: 'password', index: 'password', width: 80 }, 			
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '', name: 'name', index: 'name', width: 80 }, 			
			{ label: '', name: 'payPwd', index: 'pay_pwd', width: 80 }, 			
			{ label: '', name: 'telPhone', index: 'tel_phone', width: 80 }, 			
			{ label: '', name: 'addree', index: 'addree', width: 80 }, 			
			{ label: '', name: 'userNo', index: 'user_no', width: 80 }, 			
			{ label: '', name: 'sex', index: 'sex', width: 80 }, 			
			{ label: '', name: 'userCard', index: 'user_card', width: 80 }, 			
			{ label: '', name: 'userImg', index: 'user_img', width: 80 }, 			
			{ label: '', name: 'isUnable', index: 'is_unable', width: 80 }, 			
			{ label: '', name: 'isNameAuth', index: 'is_name_auth', width: 80 }, 			
			{ label: '', name: 'isEmailAuth', index: 'is_email_auth', width: 80 }, 			
			{ label: '', name: 'isGoogleAuth', index: 'is_google_auth', width: 80 }, 			
			{ label: '', name: 'isPhoneAuth', index: 'is_phone_auth', width: 80 }, 			
			{ label: '', name: 'birthday', index: 'birthday', width: 80 }, 			
			{ label: '', name: 'lastLoginTime', index: 'last_login_time', width: 80 }, 			
			{ label: '', name: 'userType', index: 'user_type', width: 80 }, 			
			{ label: '', name: 'remark', index: 'remark', width: 80 }, 			
			{ label: '', name: 'points', index: 'points', width: 80 }, 			
			{ label: '', name: 'amount', index: 'amount', width: 80 }, 			
			{ label: '', name: 'totalOrder', index: 'total_order', width: 80 }, 			
			{ label: '', name: 'totalMoney', index: 'total_money', width: 80 }, 			
			{ label: '', name: 'fromId', index: 'from_id', width: 80 }, 			
			{ label: '', name: 'cid', index: 'cid', width: 80 }, 			
			{ label: '', name: 'levelId', index: 'level_id', width: 80 }, 			
			{ label: '', name: 'mycode', index: 'mycode', width: 80 }, 			
			{ label: '', name: 'googleKey', index: 'google_key', width: 80 }, 			
			{ label: '', name: 'googleCode', index: 'google_code', width: 80 }, 			
			{ label: '', name: 'isCoin', index: 'is_coin', width: 80 }, 			
			{ label: '', name: 'isGetcoin', index: 'is_getcoin', width: 80 }, 			
			{ label: '', name: 'isRecharge', index: 'is_recharge', width: 80 }, 			
			{ label: '', name: 'longitude', index: 'longitude', width: 80 }, 			
			{ label: '', name: 'latitude', index: 'latitude', width: 80 }, 			
			{ label: '', name: 'cardPros', index: 'card_pros', width: 80 }, 			
			{ label: '', name: 'cardCons', index: 'card_cons', width: 80 }, 			
			{ label: '', name: 'handCard', index: 'hand_card', width: 80 }, 			
			{ label: '', name: 'creditPoint', index: 'credit_point', width: 80 }, 			
			{ label: '', name: 'clientName', index: 'client_name', width: 80 }, 			
			{ label: '', name: 'clientType', index: 'client_type', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		user: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.user = {};
		},
		update: function (event) {
			var userId = getSelectedRow();
			if(userId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(userId)
		},
		saveOrUpdate: function (event) {
			var url = vm.user.userId == null ? "generator/user/save" : "generator/user/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.user),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var userIds = getSelectedRows();
			if(userIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "generator/user/delete",
                    contentType: "application/json",
				    data: JSON.stringify(userIds),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(userId){
			$.get(baseURL + "generator/user/info/"+userId, function(r){
                vm.user = r.user;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});