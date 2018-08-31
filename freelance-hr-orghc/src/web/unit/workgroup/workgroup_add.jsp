<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include/jsp_headers.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
<title>单位查看页面</title>
<!-- 选择内设机构组件 -->
<script type="text/javascript" src="hrcomponent/orgselectjs/selectOrgWorktop.js"></script>
<link href="hspszhphtml/css/components/search_unit.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="component/workflow/configuration/js/selectOrgForCreateFlow.js"></script>
<script type="text/javascript" src="unit/workgroup/workgroup_validate.js"></script>
</head>
<body>
<form id="workGroupForm" class="form-inline" action="createWorkGroup.do?method=createWorkGroup" method="post" onsubmit="return false">
  <input type="hidden" id="orgOid" name="orgOid" value="${orgOid}" />
   <input type="hidden" id="wpId" name="wpId" value="${wpId}" />
    <div class="modal-dialog-container">
        <div class="md-title">
                             小组信息&gt;新增
        </div>
        <div class="md-error" style="display: none">
			<p>以下信息有误,请重新输入</p>
		</div>
        <div class="md-main-content">

	       <div class="md-units md-three-column clearfix">
				<dl class="updown-dl">
					<dt><b class="Required">* </b>小组名称：</dt>
					<dd>
						<label><input type="text" id="wpName" name="wpName" value="${workGroupForm.wpName }" maxlength="100" /></label>
					</dd>
				</dl>
				<dl class='dupdown-dl'>
							<dt class="search-unit-dt"><b class="Required">* </b>所属科室：</dt>
							<dd class="search-unit-dd">
									<input type="text" class="modal_iput" name="wpDepName" id="hireDeptName" readonly="readonly" onclick="selectOrg()" value='${workGroupForm.wpDepName}' /> 
									<input type="hidden" id="hireDeptOid" name="wpDepId" value='${workGroupForm.wpDepId}' /> 
									<!-- <a class="md-unit-clear" onclick="$(this).siblings('input').val('')"></a> -->
							</dd>
						</dl>
				<dl class="updown-remark">
					<dt>小组描叙：</dt>
					<dd>
					<label><textarea  id="wpDescription" name="wpDescription"  maxlength="1000">${workGroupForm.wpDescription}</textarea></label>
					</dd>
				</dl>
			</div>
        </div>
        <div class="md-btn">
            <button id="saveWorkGroup" type="button" class="md-btn-save">保  存</button>
            <button type="button" class="md-btn-cancel close-popdown" data-dismiss="modal" button-click="widget-close">取 消</button>
          </div>
    </div>
</form>
</body>
<script>
</script>
</html>