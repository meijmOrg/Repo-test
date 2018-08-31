<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/jsp_headers.jsp"%>
<head>
<meta charset="UTF-8">
<title>请休假表单信息查看页面</title>
<link rel="stylesheet" href="component/front_transform/font-awesome-4.7.0/css/font-awesome.css">
<link rel="stylesheet" href="component/front_transform/mho.css">
<script src="component/front_transform/lib/jquery-3.2.1.min.js"></script>
<script src="component/front_transform/webuploader-0.1.5/webuploader.js"></script>
<script src="hrcomponent/flow/js/yhflow_start.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$.ajax({ 
		  url: 'getVacationInfo.do?method=getVacationInfo&fileId=${fileId}', 
		  data: {},  
		  dataType:'json', 
		  async : false,
		  type : 'post',
		  success:function(data){      
			  if (data.success) {
	              $("#beginTimeStr").html(data.message.beginTimeStr);
	              $("#endTimeStr").html(data.message.endTimeStr);
	              $("#reason").html(data.message.reason);
	          }
	          else
	          {
	              MessageBox.alert('消息',data.message);
	          }
		  }
	  })
});
</script>
</head>
<body>
	<div style="background:#fff;padding:20px 60px 20px 0;">
	<form class="form-inline" action="#" method="post" onsubmit="return false">
		<div class="mho_row mho_row_no_margin">
			<div class="mho_col mho_col_2">
				<div class="mho_form_group">
					<label style="width: 100%;">请假开始时间</label>
				</div>
			</div>
			<div class="mho_col mho_col_3">
				<div class="mho_form_group mho_form_group_block">
					<label id="beginTimeStr">&nbsp;</label>
				</div>
			</div>
			<div class="mho_col mho_col_2">
				<div class="mho_form_group">
					<label style="width: 100%;">请假结束时间</label>
				</div>
			</div>
			<div class="mho_col mho_col_3">
				<div class="mho_form_group mho_form_group_block">
					<label id="endTimeStr">&nbsp;</label>
				</div>
			</div>
		</div>
		<div class="mho_row">
			<label class="mho_col mho_col_2 mho_text_right line_height_35">请假原因</label>
			<div class="mho_col mho_col_8">
				<div class="mho_form_group">
					<label id="reason">&nbsp;</label>
				</div>
			</div>
		</div>
	</form>
	</div>
</body>