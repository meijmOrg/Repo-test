$(function() {
	var flowdata=window.localStorage.getItem("data");
	//获取后台传值
	$('#myflow').myflow(
		{
			basePath : "",
			allowStateMutiLine:true,
			restore : eval("(" + flowdata + ")"),
			tools : {
				save : function(data) {
					 var id=$("#ruleId").val();
                     var ruleFlowId=$("#ruleFlowId").val();
                     console.log(data);
					jQuery.ajax({
                        url: 'saveRuleFlow.do?method=saveRuleFlow',
                        type: 'POST',
                        dataType: 'json',
                        data: {
                            "ruleFlowContent": data,//encodeURI(data).replace(/\+/g,'%2B'),
                            "id":id,
                            "ruleFlowId":ruleFlowId,
                        },
                        error: function () {
                        	MessageBox.alert('提示',"失败");
                        },
                        success: function (data) {
                            if (data.success) {
                            	MessageBox.alert('提示',"成功");
                            } else {
                                $.message.pop(data.msg, "warning", 3000);
                            }
                        }
                    });
				},
				publish:function(data){
					console.log("发布",eval("("+data+")"));
				},
				addPath:function(id,data){
					console.log("添加路径",id,eval("("+data+")"));
				},
				addRect:function(id,data){
					//console.log("添加状态",id,eval("("+data+")"));
				},
				clickPath:function(id){
					//console.log("点击线",id)
				},
				clickRect:function(id,data){
					//console.log("点击状态",id,eval("("+data+")"));
				},
				deletePath:function(id){
					//console.log("删除线",id);
				},
				deleteRect:function(id,data){
					//console.log("删除状态",id,eval("("+data+")"));
				},
				revoke:function(id){

				}
			}
		});

	});