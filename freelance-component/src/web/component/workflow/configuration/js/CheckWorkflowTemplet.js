/*
 * 模板信息校验
 */
$(function(){
	debugger
    $("#workflowConfigurationForm").validate({
        rules:{
        	templetName: {
                required: true
            },
            templetCode:{
                required: true
            }
        },   
        messages: {
        	templetName: {
                required: "请输入模板名称"
            },templetCode: {
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
        	debugger
                  var options = {
                      type : "POST" ,  
                      url:'updateWorkflowTemplet.do?method=updateTemplet',
                      success : function(data) {
                    	  data = $.parseJSON(data);
                          if (data.success) {
                        	  //刷新主页面
                        	  Widget.close();
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


