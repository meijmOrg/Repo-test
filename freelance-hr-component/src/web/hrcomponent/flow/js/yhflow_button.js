/**流程按钮控制**/
function buttonControl(params){
	if(params.submitFlow){//提交流程
		$('#submitFlow').hide();
	}
	if(params.tempSave){//暂存
		$('#tempSave').hide();	
	}
	if(params.historyData){//历史数据
		$('#historyData').hide();
	}
	if(params.sign){//加签
		$('#sign').hide();
	}
	if(params.duplicate){//抄送用户
		$('#duplicate').hide();
	}
}