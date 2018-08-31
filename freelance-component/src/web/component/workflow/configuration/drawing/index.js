$(function() {
		/*var flowdata=window.localStorage.getItem("data");*/
		
		/*var flowdata='${workflowConfigurationDto.flowData}';*/
	    if(null==flowdata||undefined==flowdata||""==flowdata)
	    {
	        flowdata="{states:{},paths:{}}";
	    }
		//获取后台传值
		$('#myflow').myflow(
			{
				basePath : "",
				allowStateMutiLine:true,
				restore : eval("(" + flowdata + ")"),
				tools : {
					save : function(data) {
						 var id=$("#ruleId").val();
						 var templetId=$("#templetId").val();
	                     var ruleFlowId=$("#ruleFlowId").val();
	                     var flowName=$("#flowName").val();
	                     var flowId=$("#flowId").val();
	                     if(flowName==""){
	                    	 MessageBox.alert('提示',"请填写流程名称");
	                    	 return;
	                     }
	                     var flowType=$("#flowType").val();
	                     if(flowType==""){
	                    	 MessageBox.alert('提示',"请选择流程类型");
	                    	 return;
	                     }
	                     var flowOrgName=$("#hireDeptName").val();
	                     var flowOrgOid=$("#hireDeptOid").val();
	                     if(flowType=="1"&&flowOrgOid==""){
	                    	 MessageBox.alert('提示',"请选择所属部门");
	                    	 return;
	                     }
	                     var jsonData=data;
	                     if(jsonData==""||jsonData==undefined||jsonData==null)
	                    	 {
	                    	 MessageBox.alert('提示',"请添加流程信息");
	                    	 return;
	                    	 }
	                     var paths=jsonData.paths;
	                     var states=jsonData.states;
	                     if(states==""||states==undefined||states==null)
                    	 {
                    	 MessageBox.alert('提示',"请添加节点");
                    	 return;
                    	 }
	                     if(paths==""||paths==undefined||paths==null)
	                    	 {
	                    	 MessageBox.alert('提示',"请连接节点");
	                    	 return;
	                    	 }
	                     for (var k in states) {
	                    	 var state=states[k];
	                         if ((!state)||state.ruleProps==""||state.ruleProps==undefined||state.ruleProps==null) {
	                        	 MessageBox.alert('提示',"存在节点没有添加属性");
		                    	 return;
	                         }
	                     }
	                     for (var k in paths) {
	                    	 var path=paths[k];
	                         if ((!path)||path.ruleProps==""||path.ruleProps==undefined||path.ruleProps==null) {
	                        	 MessageBox.alert('提示',"存在连线没有添加属性");
		                    	 return;
	                         }
	                     }
						jQuery.ajax({
	                        url: 'saveRuleFlow.do?method=saveRuleFlow',
	                        type: 'POST',
	                        dataType: 'json',
	                        data: {
	                            "ruleFlowContent":JSON.stringify(data),
	                            "id":id,
	                            "ruleFlowId":ruleFlowId,
	                            "flowName":flowName,
	                            "flowType":flowType,
	                            "flowOrgOid":flowOrgOid,
	                            "flowOrgName":flowOrgName,
	                            "templateId":templateId,
	                            "flowId":flowId
	                        },
	                        error: function () {
	                        	MessageBox.alert('提示',"失败");
	                        },
	                        success: function (data) {
	                            if (data.success) {
	                            	MessageBox.alert('提示',"成功");
	                            } else {
	                            	MessageBox.alert('提示',"失败");
	                            }
	                        }
	                    });
					},
					publish:function(data){
						console.log("发布",eval("("+data+")"));
					},
					addPath:function(id,data){
						/*console.log("添加路径",id,eval("("+data+")"));*/
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