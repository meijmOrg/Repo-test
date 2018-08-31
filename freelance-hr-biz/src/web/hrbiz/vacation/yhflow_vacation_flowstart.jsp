<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/jsp_headers.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>请休假流程启动</title>
<link rel="stylesheet" href="component/front_transform/font-awesome-4.7.0/css/font-awesome.css">
<link rel="stylesheet" href="component/front_transform/mho.css">
<script src="component/front_transform/lib/jquery-3.2.1.min.js"></script>
<script src="component/front_transform/webuploader-0.1.5/webuploader.js"></script>
<script src="hrcomponent/flow/js/yhflow_start.js"></script>
<script type="text/javascript" src="js/component/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
 var submitUrl = 'createVacationInfo.do?method=createVacationInfo';//提交流程请求
 var sighSubmitUrl = 'createVacationInfoSigh.do?method=createVacationInfoSigh';//加签提交请求
 
$('#reback').click(function() {
	 HistoryRegister.go("goBizVacationWorkTop");
});
</script>
</head>
<body>
	<div style="background:#fff;padding:20px 60px 20px 0;">
	<html:form styleId="flowComponentForm" styleClass="form-inline" action="saveVacationInfo.do?method=saveVacationInfo" method="post" onsubmit="return false">
		<div class="mho_row mho_row_no_margin">
			<div class="mho_col mho_col_2">
				<div class="mho_form_group">
					<label style="width: 100%;">请假开始时间</label>
				</div>
			</div>
			<div class="mho_col mho_col_3">
				<div class="mho_form_group mho_form_group_block">
					<input type="text" class="mho_form_field" id="beginTimeStr" name="beginTimeStr" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'});" />
				</div>
			</div>
			<div class="mho_col mho_col_2">
				<div class="mho_form_group">
					<label style="width: 100%;">请假结束时间</label>
				</div>
			</div>
			<div class="mho_col mho_col_3">
				<div class="mho_form_group mho_form_group_block">
					<input type="text" class="mho_form_field" id="endTimeStr" name="endTimeStr" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'});" />
				</div>
			</div>
		</div>
		<div class="mho_row">
			<label class="mho_col mho_col_2 mho_text_right line_height_35">请假原因</label>
			<div class="mho_col mho_col_8">
				<div class="mho_form_group">
					<textarea class="mho_form_field" name="reason" rows="5" style="width:100%;height:100px;" maxlength="500"></textarea>
				</div>
			</div>
		</div>
	</html:form>
		<jsp:include page="/hrcomponent/flow/yhflow_button.jsp"></jsp:include>
		<jsp:include page="/hrcomponent/flow/yhflow_attachment.jsp">
			<jsp:param value="mho_col_8" name="widthFlag"/>
		</jsp:include>
	</div>
</body>
</html>