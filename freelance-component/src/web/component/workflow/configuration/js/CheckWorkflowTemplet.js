/*
 * 模板信息校验
 */
$(function(){
    $("#workflowConfigurationForm").validate({
        rules:{
        	templateName: {
                required: true
            },
            templateCode:{
                required: true
            },
            templateType:{
            	required:true
            },templateCreatePage:{
            	required: true
            },templateEditPage:{
            	required: true
            },templateInfoPage:{
            	required: true
            },templateFlowPage:{
            	required: true
            },templateReportPage:{
            	required: true
            }
        },   
        messages: {
        	templateName: {
                required: "请输入模板名称"
            },templateCode: {
                required: "请输入模板编码"
            },templateType:{
            	required:"请选择模板分类"
            },templateCreatePage:{
            	required: "请输入新增页面"
            },templateEditPage:{
            	required: "请输入编辑页面"
            },templateInfoPage:{
            	required: "请输入详细页面"
            },templateFlowPage:{
            	required: "请输入流程页面"
            },templateReportPage:{
            	required: "请输入报表页面"
            }
        },
        errorPlacement: function (error, element)
        {
            error.appendTo(element.parents("dl:first"));
        },
        errorLabelContainer: $("#workflowConfigurationForm div.modal-wrong"),
        wrapper: "li",
        submitHandler: function( form) {
        	//alert("数据提交！");
                  var options = {
                      type : "POST" ,  
                      url:'updateWorkflowTemplet.do?method=updateTemplet',
                      success : function(data) {
                    	  data = $.parseJSON(data);
                          if (data.success) {
                        	  if(templateId == null || templateId == ''){
                        		  templateId = data.message;
                        	  }
                        	  //刷新主页面
                        	  Widget.close();
                        	  worktop.grid.store.load({
          						params: {start:0, limit: worktop.grid.page.limit,templateId:templateId}
          					});
                          }
                          else 
                          {
	                          $("#workflowConfigurationForm div.modal-wrong").css('display','block');
	                          $(".wroglist li").html(data.message).css('color','#000000');
                          }
                          return;
                      }
                  };
            $('#workflowConfigurationForm').ajaxSubmit(options);
        }
    });
});


