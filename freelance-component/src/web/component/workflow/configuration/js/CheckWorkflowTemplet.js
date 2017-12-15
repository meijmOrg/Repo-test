/*
 * 模板信息校验
 */
$(function(){
	debugger
    $("#workflowConfigurationForm").validate({
        rules:{
        	templateName: {
                required: true
            },
            templateCode:{
                required: true
            }
        },   
        messages: {
        	templateName: {
                required: "请输入模板名称"
            },templateCode: {
                required: "请输入模板编码"
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


