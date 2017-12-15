<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include/jsp_headers.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=1.0"/>
<title>查看模板信息</title>
	<%@ include file="/include/js_css_base_include.jsp"%>
<style type="text/css">
.words{
    white-space: nowrap;
    text-overflow: ellipsis;
    overflow: hidden;
    width: 160px;
}
.li_front_wfc{
    float: left;
    width: 50%;
    clear: left;
    text-align: right;
    /*overflow: hidden;*/
    /*text-overflow: ellipsis;*/
    /*white-space: nowrap;*/
    font-size: 14px;
    margin-left: 20px;
    color: #7c7c7c;
}
</style>
<style>
/****************模态框基础样式*****************************/
.modal_box {
    position: absolute;
    top: 50px;
    left: 20%;
    width: 60%;
    /*min-width: 680px;*/
    background-color: #fff;
    -webkit-background-clip: padding-box;
    background-clip: padding-box;
    outline: 0;
    -webkit-box-shadow: 0 3px 9px rgba(0, 0, 0, 0.5);
    box-shadow: 0 3px 9px rgba(0, 0, 0, 0.5);
    z-index: 9999;
    border-top-right-radius: 5px;
    border-top-left-radius: 5px;
}
.modal_box .blue {
    color: #5097ed;
}
.small-dialog.modal_box {
    width: 30%;
    top: 200px;
    left: 35%;
    min-width: 300px;
}
.big-dialog.modal_box {
    width: 80%;
    left: 10%;
}
.select_unit_dialog {
	z-index: 99999;
}
@media screen and (min-width:1280px) {
    .modal-dialog-container .people-detail .detail-ul1 li.detail-li1.textArea{
        width: 99%;
    }
    .people-detail .detail-ul1 li.detail-li1{
        float: left;
        width: 33%;
    }
     .people-detail .detail-ul1 li.detail-info-img:nth-child(1){
        display: block;
    }
/*    .people-detail .detail-ul1 li.detail-info-img:nth-child(4){
         display: block;
     } */
    .people-detail .detail-li1.textArea span.info-left{
        width: calc(15.5% - 8px);
    }
    .people-detail .detail-li1.textArea span.info-right{
        width: calc(84.5% + 8px);
        min-height: 80px;
    }
}
@media screen and (max-width:1280px) {
    .modal-dialog-container .people-detail .detail-ul1 li.detail-li1.textArea{
        width: 100%;
    }
    .people-detail .detail-ul1 li.detail-li1{
        float: left;
        width: 50%;
    }
    .people-detail .detail-ul1 li.detail-info-img:nth-child(1){
        display: block;
    }
/*     .people-detail .detail-ul1 li.detail-info-img:nth-child(4){
        display: none;
    } */
    .people-detail .detail-li1.textArea span.info-left{
        width: calc(23% - 5px);
        border-bottom: 1px dotted #fff;
    }
    .people-detail .detail-li1.textArea span.info-right{
        width: calc(77% + 5px);
        min-height: 80px;
    }
}
.md-title {
    width: 100%;
    height: 40px;
    line-height: 40px;
    background-color: #5097ed;
    border-top-right-radius: 5px;
    border-top-left-radius: 5px;
    color: #ffffff;
    padding-left: 20px;
}
.md-title h3 {
    font-weight: bold;
    font-size: 16px;
}
.md-close {
    width: 40px;
    height: 40px;
    text-align: center;
}
.iconfont {
  font-family:"iconfont" !important;
  font-size:16px;
  font-style:normal;
  -webkit-font-smoothing: antialiased;
  -webkit-text-stroke-width: 0.2px;
  -moz-osx-font-smoothing: grayscale;
}
.md-body {
    padding: 0 20px;
    margin: 10px 0;
    max-height: 500px;
    overflow-y: auto;
}

.md-btns {
    padding-bottom: 10px;
    padding-top: 5px;
    text-align: center;
}
.md-btns button {
    padding: 8px 25px;
    font-size: 16px;
    border-radius: 6px;
}
.small-dialog .md-btns button {
    padding: 6px 12px;
    font-size: 14px;
}
.md-btn-close:hover {
    text-decoration: underline;
}
.clearfix { zoom: 1; }
/*渚涘簲鍟嗕俊鎭�/
.supplier-info{
    background-color: #edf4fd;
    padding: 10px 0 10px 20px;
    box-sizing: border-box;
}
/*鍗曠嫭璁剧疆渚涘簲鍟嗕俊鎭ā鎬佹涓讳綋閮ㄥ垎*/
.md-body .supplier-info{
    padding: 0;
    max-height: 440px;
    overflow-y: auto;
    margin-top: 8px;
}
.md-body .role-empower {
    padding: 0;
    max-height: 380px;
  /*  overflow-y: auto;*/
}
.supplier-info li{
    position: relative;
    float: left;
    font-size: 14px;
    color: #555555;
    overflow: hidden;
    -o-text-overflow: ellipsis;
    text-overflow: ellipsis;
    white-space: nowrap;
    word-wrap: break-word;
    line-height: 2.5;
    margin-right: 30px;
    box-sizing: border-box;
    padding:0 15px 0 5px;
    cursor: pointer;
    border: 1px solid #edf4fd;
}
.supplier-info li.blue:after{
    content: '鈭�';
    float: right;
    position: absolute;
    right: 6px;
}
.supplier-info li.blue{
    border: 1px solid #5097ed;
    color: #5097ed;
}
/*娴佷綋甯冨眬*/
@media screen and (min-width:1280px) {
    .fluid li {
        /*width: 33%;*/
         width: calc(33% - 30px);
    }
}
@media screen and (max-width:1280px) {
    .fluid li {
        width: calc(50% - 30px);
    }
}
</style>
<script type="text/javascript" src="component/workflow/configuration/js/selectOrgForCreateFlow.js"></script>
<script type="text/javascript">
function createActivitySelectOrg(){
	var templetId = '${workflowConfigurationForm.templateId}';
		  Widget.openContent("goCreateActivitySelectOrg.do?method=goCreateActivitySelectOrg&templetId="+templetId,
				function(){
			 		$("#right_wfc").load('goViewWorkflowConfiguration.do?method=goViewWorkflowConfiguration',{"templetId":templetId});
			    });  
		 /* HistoryRegister.set("goViewWorkflowConfiguration", "goViewWorkflowConfiguration.do?method=goViewWorkflowConfiguration");
         location.href = 'goCreateActivitySelectOrg.do?method=goCreateActivitySelectOrg&templetId='+templetId;
 */}
function updateFlow(baseInfoId){
		Widget.openContent("goUpdateWorkflowBaseInfo.do?method=goUpdateFlow&baseInfoId="+baseInfoId,function(){
			worktop.grid.store.load({
				params: {start:0, limit: worktop.grid.page.limit}
			});
		});
}
function deleteFlow(baseInfoId){
		$.get("deleteWorkflowBaseInfo.do?method=deleteFlow&baseInfoId="+baseInfoId,function(data){
			if (data.message) {
				MessageBox.alert('提示', data.message, function(){
					worktop.grid.store.load({
						params: {start:0, limit: worktop.grid.page.limit}
					});
				})
			}
		},'json')
	
}
</script>
</head>
<body>
    <div style="clear: both"></div>
    <div class="modal-row03">
            		<dl>
            			<dt>模板名称</dt>
            			<dd>
            				<label title="${workflowConfigurationForm.templateName }"> 
            				${workflowConfigurationForm.templateName }&nbsp;
	                      	</label>
            			</dd>
            		</dl>
            		<dl>
            			<dt>模板编码</dt>
            			<dd>
            				<label title="${workflowConfigurationForm.templateCode }"> 
            				${workflowConfigurationForm.templateCode }&nbsp;
	                      	</label>
            			</dd>
            		</dl>
    </div>
     <div class="modal-row03">
            		<dl>
            			<dt>模板分类</dt>
            			<dd>
            				<label title="${workflowConfigurationForm.templateType }"> 
            				${workflowConfigurationForm.templateType }&nbsp;
	                      	</label>
            			</dd>
            		</dl>
            		<dl>
            			<dt>新增页面</dt>
            			<dd>
            				<label title="${workflowConfigurationForm.templateCreatePage }"> 
            				${workflowConfigurationForm.templateCreatePage }&nbsp;
	                      	</label>
            			</dd>
            		</dl>
    </div>
     <div class="modal-row03">
            		<dl>
            			<dt>编辑页面</dt>
            			<dd>
            				<label title="${workflowConfigurationForm.templateEditPage }"> 
            				${workflowConfigurationForm.templateEditPage }&nbsp;
	                      	</label>
            			</dd>
            		</dl>
            		<dl>
            			<dt>流程页面</dt>
            			<dd>
            				<label title="${workflowConfigurationForm.templateFlowPage }"> 
            				${workflowConfigurationForm.templateFlowPage }&nbsp;
	                      	</label>
            			</dd>
            		</dl>
    </div>
     <div class="modal-row03">
            		<dl>
            			<dt>详细页面</dt>
            			<dd>
            				<label title="${workflowConfigurationForm.templateInfoPage }"> 
            				${workflowConfigurationForm.templateInfoPage }&nbsp;
	                      	</label>
            			</dd>
            		</dl>
            		<dl>
            			<dt>报表页面</dt>
            			<dd>
            				<label title="${workflowConfigurationForm.templateReportPage }"> 
            				${workflowConfigurationForm.templateReportPage }&nbsp;
	                      	</label>
            			</dd>
            		</dl>
    </div>
    
    <div style="clear: both"></div>
        <div>
    	<table width="100%" border="1" cellpadding="0" cellspacing="0" class="list">
		<tr style="heigth:10px">
			<th><div align="center">序号</div></th>
			<th><div align="center">流程名称</div></th>
			<th><div align="center">所属部门</div></th>
			<th><div align="center">流程类型</div></th>
			<th colspan="2"><div align="center"><a href="#" onclick="selectOrgForCreateFlow(this,'Y','${workflowConfigurationForm.templateId}')" style="color:green">新建流程</a></div></th>
		</tr>
		<c:forEach items="${workflowConfigurationForm.baseInfoList}" var="dto" varStatus="status">
		    <tr style="heigth:10px">
		     	<td align="center">${status.index+1 }</td>
		        <td align="center">${dto[0].flowName }</td>
		        <td align="center">${dto[0].flowOrgName }</td>
		        <td align="center">${dto[0].flowType }</td>
		        <td align="center"><a href="#" onclick="updateFlow('${dto[0].flowId}')" style="color:green">修改</a></td>
		        <td align="center"><a href="#" onclick="deleteFlow('${dto[0].flowId}')" style="color:green">删除</a></td>
		    </tr>
		</c:forEach>
    </table>
    </div>
</body>
</html>