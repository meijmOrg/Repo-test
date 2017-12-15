var selectOrgName="";
var selectOrgOid="";
var queryOrgName = "";
var isPersonInfoFlag="";
var templetIdOrg = "";
function selectOrgForCreateFlow(obj,isPersonInfo,templetId)
{
	templetIdOrg = templetId;
	isPersonInfoFlag=isPersonInfo;
	/*class='select_unit_dialog' id='dictionaryHtml'*/
	var div="<div class='modal_box select_unit_dialog' id='dictionaryHtml'>"+
				"<div class='modal-dialog-container'>"+
					"<!-- 头部-->"+
					"<div class='md-title'>"+
						"<h3>新建流程<span class='fr md-close close-popdown' onclick='closeRankCode1()'><i class='iconfont icon-close font-16'></i></span></h3>"+
					"</div>"+
					"<div class='md-body'>"+
						"<div class='search-cont search-one-row clearfix'>"+
							"<dl class='search-col'>"+
								"<dt>部门名称</dt>"+
								"<dd><input id='queryOrgNameId' type='text'></dd>"+
							"</dl>"+
							"<button id='searchButton' class='btn-bg-blue btn-noicon btn-default'>查询</button>"+
						"</div>"+
						"<div class='supplier-info'>"+
							"<ul class='fluid' id='set_next_city'>"+
			                	"<div class='clearfix'></div>"+
			            	"</ul>"+
		            	"</div>"+
                	"</div>"+
		        	"<div class='md-btns'>"+
		            	"<button id='unit_add' class='btn-bg-blue btn-default'>新建流程</button>"+
		        	"</div>"+
	        	"</div>"+
        	"</div>";
	if($("#dictionaryHtml").length<=0){
		$(document.getElementsByTagName("body")).append(div);
	}
	$("#dictionaryHtml").show();
	
	/*var orgName=$(obj).attr("name");
	var orgName=$(obj).attr("id");
	var orgOid=$("#orgOid").attr("name");
	var orgOid=$("#orgOid").attr("id");*/
	//查询
	goQuery1(null,"query",queryOrgName);
	
	//选择事件
	$("#unit_add").click(function(){
		queryOrgName = "";
		$(".select_unit_dialog").remove();
		 /*Widget.openContent("goCreateWorkflowBaseInfo.do?method=goCreateFlow&templetId="+templetId+"&orgName="+selectOrgName+"&orgOid="+selectOrgOid,
					function(){
			 			selectOrgName = "";
			 			selectOrgOid = "";
				 		$("#right_wfc").load('goViewWorkflowConfiguration.do?method=goViewWorkflowConfiguration',{"templetId":templetId});
				    }); */
		 HistoryRegister.set("goWorkflowConfigurationUpdate", "goWorkflowConfigurationUpdate.do?method=goWorkflowConfigurationUpdate");
         location.href = "goCreateWorkflowBaseInfo.do?method=goCreateFlow&templetId="+templetId+"&orgName="+selectOrgName+"&orgOid="+selectOrgOid;
         selectOrgName = "";
         selectOrgOid = "";

	});
	
	//供应商信息弹窗
    $(document).on('click','.supplier-info li',function () {
        $(this).addClass('blue').siblings().removeClass('blue');
    });
    
    $("#queryOrgNameId").keydown(function() {
	    if (event.keyCode == "13") {//keyCode=13是回车键
	    	query1();
	    }
	});
	
	$("#searchButton").click(function() {
		query1();
	});

}

//赋值
function findOrg(arg0,arg1)
{
	selectOrgName = arg0;
	selectOrgOid = arg1;
}
//关闭
function closeRankCode1(){
	$(".select_unit_dialog").remove();
}

//查询
function query1()
{
	queryOrgName = $("#queryOrgNameId").val();
	goQuery1(null,"query",queryOrgName);
}


//查询
function goQuery1(pageNo,flag,queryOrgName)
{
	var params = {};
	
	params.orgName=queryOrgName;
	params.isPersonInfoFlag = isPersonInfoFlag;
	params.pageFlag = 'Y';
	params.templetId = templetIdOrg;
	$.ajax({
		url : 'goSelectOrgForCreateFlow.do?method=goSelectOrgForCreateFlow',
		data : params,
		dataType : 'json',
		type:'POST',
		error : function(r,t) {
			alert(t);
		},
		async : true,
		success : function(data) {
			var item=eval(data.rows);
				//清空list内容
				$("#set_next_city").empty("");
				$.each(item,function(index,orgName){
					debugger
	   	 			var tbTr ="<li onclick=findOrg('"+orgName.orgName+"','"+orgName.orgOid+"') title='"+orgName.orgName+"'>"+orgName.orgName+"</li>";
					$("#set_next_city").append(tbTr);
				});
			//}
			//queryHisPositionName="";
		}
	});
}
