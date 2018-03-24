var uploader = WebUploader.create({
	pick: '#pick_file',
	resize: false
});
uploader.on('fileQueued', function(file) {
	$('#file_name').val(file.name);
});
/**流程按钮控制**/
function buttonControl(params){
	debugger
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
/**流程流转**/
$('#submitFlow').click(function() {
	debugger
    var dialog = new Dialog({
        url: 'goSubmitFlow.do',
        width: '80%',
        title: '流程下一步'
    });
});