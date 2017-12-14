/**
 * 提交前数据校验
 */
$(function(){
    $("#formDynamicPropertyCreate").validate({
        rules:{
            dpCategory: {
                required: true
            },
            dpState:{
                required: true
            },
            dpDescription:{
                required: true,
                maxlength: 200
            }
        },   
        messages: {
        	dpCategory: {
                required: "请输入字段类别"
            },dpState: {
                required: "请输入字段状态"
            },dpDescription: {
                required: "请输入字段含义",
                maxlength:"字段含义不能超过{0}"
            }
        },
        errorPlacement: function (error, element)
        {
            error.appendTo(element.parents("dl:first"));
        },
        errorLabelContainer: $("#formDynamicPropertyCreate div.modal-wrong"),
        wrapper: "li",
        submitHandler: function( form) {
        	//alert("数据提交！");
                  var options = {
                      type : "POST" ,  
                      url:'createDynamicProperty.do?method=createDynamicProperty',
                      success : function(data) {
                    	  data = $.parseJSON(data);
                          if (data.success) {
                        	  //刷新主页面
                        	  Widget.close();
                          }
                          else 
                          {
	                          $("#formDynamicPropertyCreate div.modal-wrong").css('display','block');
	                          $(".wroglist li").html(data.message).css('color','#000000');
                          }
                          return;
                      }
                  };
            $('#formDynamicPropertyCreate').ajaxSubmit(options);
        }
    });
});
//验证输入值为字母：[a-zA-Z] 
jQuery.validator.addMethod("isWord", function(value, element) {   
    var tel = /^[0-9a-zA-Z]*$/;
    return this.optional(element) || (tel.test(value));
}, "用户ID不能包含汉字！");
//验证输入值为数字
jQuery.validator.addMethod("isNum", function(value, element) {   
   // var tel = /^[0-9]*$/;
    var tel = /^1[34578]\d{9}$/;
    return this.optional(element) || (tel.test(value));
}, "请输入正确的联系电话");
