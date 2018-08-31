<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>流程操作</title>
<link rel="stylesheet"
	href="component/front_transform/font-awesome-4.7.0/css/font-awesome.css">
<link rel="stylesheet" href="component/front_transform/mho.css">
<script src="component/front_transform/lib/jquery-3.2.1.min.js"></script>
<script src="component/front_transform/component/dialog/dialog.js"></script>
<script src="hrcomponent/flow/js/yhflow_button.js"></script>
<script src="hrcomponent/flow/js/yhflow_start.js"></script>
<script type="text/javascript">
//业务类型（唯一）
$(document).ready(function() {
	var params={};
	params.submitFlow=false;
	params.tempSave=false;
	params.historyData=false;
	params.sign=false;
	params.duplicate=false;
	buttonControl(params);
	$('#submitFlow').click(function() {
		var csUserListStr = '';
		var csUserList = JSON.parse(localStorage.getItem('nextUserList'));
		var formData = $("#flowComponentForm").serializeArray(); //先进行序列化数组操作(业务表单数据)
		var postData = {};  //创建一个对象  
	    $.each(formData, function(n,v) {      
	        postData[formData[n].name]=formData[n].value;  //循环数组，把数组的每一项都添加到对象中  
	    }); 
	    postData['taskProcessExplain']=$('#suggestion').val();
	    localStorage.removeItem('postData');
		localStorage.setItem('postData', JSON.stringify(postData));
	    
		if(null != csUserList){
			csUserListStr = csUserList.join(',');
			localStorage.removeItem('nextUserList');
		}
		Dialog.page({
	        url: 'goUserListPartial.do?method=goUserListPartial&csUserList='+csUserListStr+'&submitUrl='+submitUrl,
	        width: '80%',
	        title: '流程下一步'
	    });
	});
	$('#tempSave').click(function() {
		$.ajax({ 
			  url: $('#flowComponentForm').attr("action")+'&flag=zc', 
			  data: $('#flowComponentForm').serializeArray(),  
			  dataType:'json', 
			  async : false,
			  type : 'post',
			  success:function(data){      
				  if (data.success) {
		              MessageBox.alert('消息',data.message);
		          }
		          else
		          {
		              MessageBox.alert('消息',data.message);
		          }
			  }
		  })
	});
	$('#historyData').click(function() {
		$.ajax({ 
			  url: $('#flowComponentForm').attr("action")+'&flag=ls', 
			  data: $('#flowComponentForm').serializeArray(),  
			  dataType:'json', 
			  async : false,
			  type : 'post',
			  success:function(data){      
				  if (data.success) {
		              MessageBox.alert('消息',data.message);
		          }
		          else
		          {
		              MessageBox.alert('消息',data.message);
		          }
			  }
		  })
	});
	$('#sign').click(function() {
		Dialog.page({
	        url: 'goUserListPartial.do?method=goUserListPartial&flag=jq'+'&submitUrl='+sighSubmitUrl,
	        width: '80%',
	        title: '加签用户选择'
	    });
	});
	$('#duplicate').click(function() {
	    Dialog.page({
	        url: 'goUserListPartial.do?method=goUserListPartial&flag=cc'+'&submitUrl=#',
	        width: '80%',
	        title: '抄送用户选择'
	    });
	});
});
</script>
</head>
<body>
	<div class="mho_row">
		<label class="mho_col mho_col_2 mho_text_right line_height_35">处理意见</label>
		<div class="mho_col mho_col_8">
			<div class="mho_form_group">
				<textarea class="mho_form_field" id="suggestion" name="suggestion" rows="5" style="width:100%;height:100px;" maxlength="500"></textarea>
			</div>
		</div>
	</div>
	<div class="mho_row mho_row_no_margin">
		<div class="mho_col mho_col_2"></div>
		<div class="mho_col mho_col_8 mho_btn_row">
			<button class="mho_btn mho_btn_empty" id="submitFlow">提交流程</button>
			<button class="mho_btn mho_btn_empty" id="tempSave">暂存</button>
			<button class="mho_btn mho_btn_empty" id="historyData">历史数据</button>
			<button class="mho_btn mho_btn_empty" id="sign">加签</button>
			<button class="mho_btn mho_btn_empty" id="duplicate">抄送用户</button>
			<button class="mho_btn mho_btn_empty" id="reback">返回</button>
		</div>
	</div>
</body>
</html>