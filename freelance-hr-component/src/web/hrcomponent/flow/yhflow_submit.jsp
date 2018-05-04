<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="struts-html.tld" prefix="html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>提交流程</title>
<link rel="stylesheet"
	href="component/front_transform/font-awesome-4.7.0/css/font-awesome.css">
<link rel="stylesheet" href="component/front_transform/mho.css">
<script src="component/front_transform/lib/jquery-3.2.1.min.js"></script>
<script src="js/jquery.form.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	$('#confirm').click(function() {
		MessageBox.yes('提示','确认要提交流程吗?', function(){
			var nextUserList = new Array();
			var otherUserList = new Array();
			$('input[name=nextCheckbox]:checked').each(function(index, element) {
				nextUserList.push($(this).val());
			});
			$('input[name=otherCheckbox]:checked').each(function(index, element) {
				otherUserList.push($(this).val());
			});
			$('input[name=nextUserList]').val(nextUserList);
			$('input[name=otherUserList]').val(otherUserList);
			
			//var url = $('#flowComponentForm').attr("action");
			//var data = $('#flowComponentForm').serializeArray();   
			$.ajax({ 
				  url: $('#flowComponentForm').attr("action"), 
				  data: $('#flowComponentForm').serializeArray(),  
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
	});
	/*重置 */
	$('#reset').click(function() {
		$(':checkbox:checked').attr("checked",false);
		$(':radio:checked').attr("checked",false);
		$('textarea[name=messageContent]').val('');
	});
})
</script>
</head>
<body>
	<html:form styleId="flowComponentForm" action="submitFlowStart.do?method=submitFlowStart"  method="post"  onsubmit="return false">
	<input type="hidden" name="nextUserList"/>
	<input type="hidden" name="otherUserList"/>
	<input type="hidden" name="templateId" value="${templateId}"/>
	<input type="hidden" name="taskPreActId" value="${preActId}"/>
	<div style="padding: 20px;">
		<table class="mho_table mho_table_center mho_table_border">
			<thead>
				<tr>
					<td colspan="3">下一步骤</td>
				</tr>
			</thead>
			<tbody>
				<tr style="background: #f3f5ff;">
					<td style="width: 25%;">流程步骤</td>
					<td>用户选择</td>
					<td style="width: 25%;">短信提醒</td>
				</tr>
				<c:forEach items="${nextActivityDTOList}" var="dto" varStatus="s">
				<tr style="text-align: left;">
					<td>${dto.actOrderStr}${dto.actName}</td>
					<td>
					<c:forEach items="${dto.puList}" var="pu" varStatus="ss">
						<c:if test="${pu.userId ne ''}">
						<span class="mho_checkbox" style="margin: 0 5px -4px 5px;">
						<input type="checkbox" name="nextCheckbox" value="${dto.actId}${pu.userId}"><i class="fa fa-check"></i>
						</span> 
						<label style="margin-right: 10px;">${pu.userName}</label> 
						</c:if>
					</c:forEach>
					</td>
					<td>
					<span class="mho_checkbox" style="margin: 0 5px -4px 5px;">
					<input type="radio" name="isSend" value="${dto.actId}Y"><i class="fa fa-check"></i>
					</span> 
					<label style="margin-right: 10px;">是</label> 
					<span class="mho_checkbox" style="margin: 0 5px -4px 5px;">
					<input type="radio" name="isSend" value="${dto.actId}N"><i class="fa fa-check"></i>
					</span> 
					<label style="margin-right: 10px;">否</label></td>
				</tr>
				</c:forEach>
				<tr style="text-align: left;">
					<td>自定义提醒内容（短信）</td>
					<td colspan="2"><textarea name="messageContent" rows="5" style="width: 100%;"></textarea>
					</td>
				</tr>
			</tbody>
		</table>
		<p style="margin: 10px 0 20px 0; color: #e96238;">注：不填写自定义提醒内容时，系统会按默认提醒内容发送</p>
		<table class="mho_table mho_table_center mho_table_border">
			<thead>
				<tr>
					<td colspan="2">设置其他审批步骤办理人</td>
				</tr>
			</thead>
			<tbody>
				<tr style="background: #f3f5ff;">
					<td style="width: 30%;">流程步骤</td>
					<td>用户选择</td>
				</tr>
				<c:forEach items="${allActivityDTOList}" var="adto" varStatus="as">
				<tr style="text-align: left;">
					<td>${adto.actOrderStr}${adto.actName}</td>
					<td>
						<c:forEach items="${adto.puList}" var="apu" varStatus="ass">
						<c:if test="${apu.userId ne ''}">
						<c:if test="${adto.actOrder gt actOrder}">
						<span class="mho_checkbox" style="margin: 0 5px -4px 5px;"><input
								type="checkbox" name="otherCheckbox" value="${adto.actId}${apu.userId}"><i class="fa fa-check"></i>
						</span> <label style="margin-right: 10px;">${apu.userName}</label>
						</c:if>
						</c:if>
						</c:forEach>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</html:form>
</body>
</html>