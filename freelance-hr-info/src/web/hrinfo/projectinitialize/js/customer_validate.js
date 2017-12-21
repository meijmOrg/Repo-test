$(function(){
    $("#formCustomerCreate").validate({
    	rules:{
    		licenseCode:{
	            required: true
	        },
	        newLicenseCode:{
	            required: true
	        },
	        startStatus:{
	            required: true
	        }
	    },
	    messages: {
	    	licenseCode: {
	            required: "请输入License码"
	        },
	        newLicenseCode: {
	            required: "请输入新License码"
	        },
	        startStatus: {
	            required: "请选择启动状态"
	        }
	    },
        errorPlacement: function (error, element)
        {
            error.appendTo(element.parents("li:first"));
        },
        errorLabelContainer: $("#formCustomerCreate div.modal-wrong"),
        wrapper: "li",
        submitHandler: function (form)
        {
                $.ajax({
                    url : $('#formCustomerCreate').attr("action"),
                    data :  $("#formCustomerCreate").serializeArray(),
                    dataType : 'json',
                    type : 'post',
                    async : false,
                    success : function(data) {
                        try {
                            if (data.success) {
                                //$.fn.close_popdown();
                            	Widget.close();//关闭弹出框
                            }
                            else
                            {
                              $("#formCustomerCreate div.modal-wrong").css('display','block');
  	                          $(".wroglist li").html(data.message).css('color','#000000');
  	                          $("#formCustomerCreate div.modal-wrong").append("<li>"+data.message+"</li>");
                            }
                            return;
                        } catch (e) {
                        }
                        
                    }
                });
        }
    });
});
