<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="struts-html.tld" prefix="html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>抄送</title>
<link rel="stylesheet"
	href="component/front_transform/font-awesome-4.7.0/css/font-awesome.css">
<link rel="stylesheet" href="component/front_transform/mho.css">
<script src="component/front_transform/lib/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#table").load('listPersonInfo.do?method=listPersonInfo');
	
	$('#button').click(function() {
		var unitName = $('input[name=unitName]').val();
		var deptName = $('input[name=deptName]').val();
		var name = $('input[name=name]').val();
		$("#table").load('listPersonInfo.do?method=listPersonInfo',{unitName:unitName,deptName:deptName,name:name});
	});
	
	$('#confirm').click(function() {
		MessageBox.yes('提示','确认要提交流程吗?', function(){
			var nextUserList = new Array();
			$('input[name=checkbox]:checked').each(function(index, element) {
				nextUserList.push($(this).val());
			});
			$('input[name=nextUserList]').val(nextUserList);
			
			$.ajax({ 
				  url: $('#flowComponentForm').attr("action"), 
				  data: $('#flowComponentForm').serializeArray(),  
				  dataType:'json', 
				  async : false,
				  success:function(data){      
					  if (data.success) {
			              MessageBox.alert('消息',data.message,function(){
			            	  $('#cancel').trigger("click");
			              });
			          }
			          else
			          {
			              MessageBox.alert('消息',data.message);
			          }
				  }
			  })
		})
	});
	/*重置 */
	$('#reset').click(function() {
		$('input[name=unitName]').val('');
		$('input[name=deptName]').val('');
		$('input[name=name]').val('');
		$(':checkbox:checked').attr("checked",false);
	});
})
</script>
</head>
<body>
	<html:form styleId="flowComponentForm" action="submitCoordinationUsers.do?method=submitCoordinationUsers"  method="post"  onsubmit="return false">
	<input type="hidden" name="nextUserList"/>
	<input type="hidden" name="templateId" value="${templateId}"/>
	<input type="hidden" name="taskPreActId" value="${preActId}"/>
	<input type="hidden" name="taskCurrentActId" value="${nextActId}"/>
	<div style="padding: 20px;">
		<div class="mho_row mho_row_no_margin">
			<div class="mho_col mho_col_2">
				<div class="mho_form_group">
					<label style="width: 100%;">单位名称</label>
				</div>
			</div>
			<div class="mho_col mho_col_3">
				<div class="mho_form_group mho_form_group_block">
					<!-- <select class="mho_form_field">
						<option>深圳市宝安区规划建设局</option>
					</select> -->
					<input type="text" class="mho_form_field" name="unitName">
				</div>
			</div>
			<div class="mho_col mho_col_2">
				<div class="mho_form_group">
					<label style="width: 100%;">部门名称</label>
				</div>
			</div>
			<div class="mho_col mho_col_3">
				<div class="mho_form_group mho_form_group_block">
					<!-- <select class="mho_form_field" style="width: 100%;">
						<option>销售部</option>
					</select> -->
					<input type="text" class="mho_form_field" name="deptName">
				</div>
			</div>
		</div>
		<div class="mho_row mho_row_no_margin">
			<div class="mho_col mho_col_2">
				<div class="mho_form_group">
					<label style="width: 100%;">姓名</label>
				</div>
			</div>
			<div class="mho_col mho_col_3">
				<div class="mho_form_group mho_form_group_block">
					<input type="text" class="mho_form_field" name="name">
				</div>
			</div>
		</div>
		<div class="mho_row mho_row_no_margin">
			<button id="button" class="mho_btn mho_btn_primary mho_btn_circle" style="margin: 10px auto; width: 100px;">查询</button>
		</div>
		<div id="table">
		
		</div>
	</div>
	</html:form>
</body>
</html>