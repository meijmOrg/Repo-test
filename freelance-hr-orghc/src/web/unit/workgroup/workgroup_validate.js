$(function(){
	 $('#saveWorkGroup').click(function(){
	        $('#workGroupForm').submit();
	    });
    $("#workGroupForm").validate({
    	  rules:{
  	    	wpName:{
  	            required: true
  	        },
  	      wpDepId:{
	            required: true
	        }
  	    },
  	    messages: {
  	    	wpName: {
  	            required: "请输入小组名称"
  	        },
    	      wpDepId:{
  	            required: "请选择所属科室"
  	        }
  	    },
        errorPlacement: function (error, element)
        {
            error.appendTo(element.parents("dl:first"));
        },
        errorLabelContainer: $("#workGroupForm div.md-error"),
        wrapper: "span",
        submitHandler: function (form)
        {
                $.ajax({
                    url : $('#workGroupForm').attr("action"),
                    data :  $("#workGroupForm").serializeArray(),
                    dataType : 'json',
                    async : false,
                    success : function(data) {
                    	debugger;
                        try {
                            if (data.success) {
                            	 $.fn.close_popdown();
                            	$(".right-content").load("goToWorkGroup.do?method=goToWorkGroup");
                            	Widget.close();
                            }
                            else
                            {
                            	$("#workGroupForm div.md-error").css('display','block');
                                if($("#workGroupForm div.md-error .back-error").length>0) {
                                	$("#workGroupForm div.md-error .back-error").html(data.message);
                                }else {
                                	$("#workGroupForm div.md-error").append("<span class='back-error'>"+data.message+"</span>");
                                }
                            }
                            return;
                        } catch (e) {
                        }
                        $("#popdown-dialog").html(data);
                        $("#workGroupForm div.md-error").css('display','block');
                    }
                });
        }
    });

});