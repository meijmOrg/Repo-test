<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>流程操作</title>
<link rel="stylesheet"
	href="component/front_transform/font-awesome-4.7.0/css/font-awesome.css">
<script src="component/front_transform/lib/jquery-3.2.1.min.js"></script>
<script src="component/front_transform/component/dialog/dialog.js"></script>
<script src="hrcomponent/flow/js/yhflow_button.js"></script>
<script src="hrcomponent/flow/js/yhflow_start.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	var params={};
	params.submitFlow=false;
	params.tempSave=false;
	params.historyData=false;
	params.sign=false;
	params.duplicate=false;
	buttonControl(params);
	$('#submitFlow').click(function() {
	    var dialog = new Dialog({
	        url: 'goUserListPartial.do?method=goUserListPartial',
	        width: '80%',
	        title: '流程下一步'
	    });
	});
	$('#sign').click(function() {
	    var dialog = new Dialog({
	        url: 'goSignFlow.do',
	        width: '80%',
	        title: '加签用户选择'
	    });
	});
	$('#duplicate').click(function() {
	    var dialog = new Dialog({
	        url: 'goDuplicateFlow.do',
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
			<button class="mho_btn mho_btn_empty" id="tempSave">暂存</button>
			<button class="mho_btn mho_btn_empty" id="historyData">历史数据</button>
			<button class="mho_btn mho_btn_empty" id="sign">加签</button>
			<button class="mho_btn mho_btn_empty" id="duplicate">抄送用户</button>
			<button class="mho_btn mho_btn_empty" id="reback">返回</button>
		</div>
	</div>
</body>
</html>