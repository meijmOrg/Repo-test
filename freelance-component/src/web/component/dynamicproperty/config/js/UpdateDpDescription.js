/**
 * 提交前数据校验
 */
$(function(){
    $("#formDpDescriptionUpdate").validate({
        rules:{
            dpDescription:{
                required: true,
                maxlength: 200
            }
        },   
        messages: {
        	dpDescription: {
                required: "请输入字段含义",
                maxlength:"字段含义不能超过{0}"
            }
        },
        errorPlacement: function (error, element)
        {
            error.appendTo(element.parents("dl:first"));
        },
        errorLabelContainer: $("#formDpDescriptionUpdate div.modal-wrong"),
        wrapper: "li",
        submitHandler: function( form) {
        	//alert("数据提交！");
                  var options = {
                      type : "POST" ,  
                      url:'updateDpDescription.do?method=updateDpDescription',
                      success : function(data) {
                    	  data = $.parseJSON(data);
                          if (data.success) {
                        	  //刷新主页面
                        	  Widget.close();
                          }
                          else 
                          {
	                          $("#formDpDescriptionUpdate div.modal-wrong").css('display','block');
	                          $(".wroglist li").html(data.message).css('color','#000000');
                          }
                          return;
                      }
                  };
            $('#formDpDescriptionUpdate').ajaxSubmit(options);
        }
    });
});
