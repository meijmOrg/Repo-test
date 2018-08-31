<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>流程过程操作</title>
<link rel="stylesheet"
	href="component/front_transform/font-awesome-4.7.0/css/font-awesome.css">
<link rel="stylesheet" href="component/front_transform/mho.css">
<script src="component/front_transform/lib/jquery-3.2.1.min.js"></script>
<script src="component/front_transform/component/dialog/dialog.js"></script>
<script src="hrcomponent/flow/js/yhflow_button.js"></script>
<script src="hrcomponent/flow/js/yhflow_start.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	var params={};
	params.submitFlow=false;
	params.sign=false;
	params.duplicate=false;
	//params.agree=false;
	params.back=false;
	params.coordination=false;
	buttonControl(params);
	$('#submitFlow').click(function() {
		var csUserListStr = '';
		var csUserList = JSON.parse(localStorage.getItem('nextUserList'));
		if(null != csUserList){
			csUserListStr = csUserList.join(',');
			localStorage.removeItem('nextUserList');
		}
	    var dialog = new Dialog({
	        url: 'goProUserListPartial.do?method=goProUserListPartial&csUserList='+csUserListStr,
	        width: '80%',
	        title: '流程下一步'
	    });
	});
	$('#back').click(function() {
		$.ajax({ 
			  url: 'sendBack.do?method=sendBack', 
			  data: {},  
			  dataType:'json', 
			  async : false,
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
	    var dialog = new Dialog({
	        url: 'goProUserListPartial.do?method=goProUserListPartial&flag=jq',
	        width: '80%',
	        title: '加签用户选择'
	    });
	});
	$('#coordination').click(function() {
	    var dialog = new Dialog({
	        url: 'goProUserListPartial.do?method=goProUserListPartial&flag=xt',
	        width: '80%',
	        title: '协同用户选择'
	    });
	});
	$('#duplicate').click(function() {
	    var dialog = new Dialog({
	        url: 'goProUserListPartial.do?method=goProUserListPartial&flag=cc',
	        width: '80%',
	        title: '抄送用户选择'
	    });
	});
})
</script>
</head>
<body>
	<div class="mho_row mho_row_no_margin">
		<div class="mho_col mho_col_2"></div>
		<div class="mho_col mho_col_8 mho_btn_row">
			<button class="mho_btn mho_btn_empty" id="submitFlow">提交流程</button>
			<!-- <button class="mho_btn mho_btn_empty" id="agree">同意</button> -->
			<button class="mho_btn mho_btn_empty" id="back">退回</button>
			<button class="mho_btn mho_btn_empty" id="sign">加签</button>
			<button class="mho_btn mho_btn_empty" id="coordination">请求协同</button>
			<button class="mho_btn mho_btn_empty" id="duplicate">抄送用户</button>
			<button class="mho_btn mho_btn_empty" id="reback">返回</button>
		</div>
	</div>
</body>
</html>