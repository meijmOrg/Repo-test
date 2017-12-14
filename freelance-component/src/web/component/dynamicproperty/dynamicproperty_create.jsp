<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%> 
<%@ page import="java.text.*"%>
<%@page import="com.yh.component.dynamicproperty.util.DynamicPropertyUtil"%>
<%@taglib uri="dictionary.tld" prefix="dictionary" %>
<%@taglib uri="c.tld" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="l">
    <meta charset="UTF-8">
    <title>新增动态字段页面</title>
	<link href="hspszhphtml/css/components/search_unit.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/comm/customJs.js"></script>
   	<script src="component/dynamicproperty/js/CreateDynamicProperty.js"></script>
   	<script>
   	</script>
</head>
<body>
<div id="showmodal" class="modal-content">
   <form id="formDynamicPropertyCreate" class="form-inline" action="" method="post" onsubmit="return false">
    	<div class="modal-header">
            <button type="button" class="close close-popdown" data-dismiss="modal" aria-label="Close" button-click="widget-close">
            	<span aria-hidden="true" >&times;</span>
            </button>
            <h4 class="modal-title">动态字段管理&gt;新增</h4>
    	</div>		
     	<div class="modal-body">	
               <input style="display: none;" type="text"  id="dpCode" name="dpCode"  value="${dynamicPropertyForm.dpCode }"/>
               <div class="modal-wrong" style="display: none">
                		<ol class="titwrong"><embed src="img/index/jg.svg" width="20" height="20" top="0" type="image/svg+xml" class="ico"/> 以下信息有误，请重新输入！</ol>
               			<ol class="wroglist">
                    		<logic:messagesPresent>
                        		<html:messages id="error">
                           			<li><bean:write name="error" /></li>
                        		</html:messages>
                    		</logic:messagesPresent>
                		</ol>
            	</div>
            	<div class="modal-row03">
            		<dl>
            			<dt>字段名称</dt>
            			<dd>
            				<label title='${dynamicPropertyForm.dpName }'> 
								<input type="text" name="dpName" readonly="readonly" id="dpName" value="${dynamicPropertyForm.dpName }" /> 
	                      	</label>
            			</dd>
            		</dl>
            		<dl>
            			<dt>字段类型</dt>
            			<dd>
            				<label title='${dynamicPropertyForm.dpType }'> 
								<input type="text" name="dpType" readonly="readonly" id="dpType" value="${dynamicPropertyForm.dpType }" /> 
	                      	</label>
            			</dd>
            		</dl>
            	</div>
            	<div class="modal-row03">
            		<dl>
            			<dt><b class="Required">* </b>字段类别：</dt>
            			<dd>
            				<label>
	                             <dictionary:dicItemSelect styleClass="modal_select"  id="dpCategory" name="dpCategory" dicTypeCode="<%=DynamicPropertyUtil.YHRS3001 %>" selected="0"   emptyText="--请选择--"/> 
	                      	</label>
            			</dd>
            		</dl>
            		<dl>
            			<dt><b class="Required">* </b>字段状态：</dt>
            			<dd>
            				<label>
	                             <dictionary:dicItemSelect styleClass="modal_select"  id="dpState" name="dpState" dicTypeCode="<%=DynamicPropertyUtil.YHRS3002 %>" selected="0"   emptyText="--请选择--"/> 
	                      	</label>
            			</dd>
            		</dl>
            	</div>
            	<div class="modal-row03">
            		<dl class="updown-remark">
						<dt><b class="Required">* </b>字段含义：</dt>
						<dd style="width: 83%;">
							<label><textarea rows="3" name="dpDescription" maxlength="1000"></textarea>
							</label>
						</dd>
					</dl>
            	</div>
           </div>	
      	  <div class="modal-footer">
               <input  type="submit" class="btn btn-primary" value="保　存">
               <button type="button" class="btn btn-default close-login" data-dismiss="modal" button-click="widget-close">
               <a href="#" class="close-popdown">取　消</a></button>
          </div>
     </form>
    </div>
</body>

</html>