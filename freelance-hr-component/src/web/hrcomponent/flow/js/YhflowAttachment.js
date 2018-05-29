//监听分块上传的时间点，断点续传
var fileMd5;
var fileName;
var file_id;
WebUploader.Uploader.register({
	"before-send-file":"beforeSendFile",
	"before-send":"beforeSend",
	"after-send-file":"afterSendFile"
	},{
		beforeSendFile:function(file) {
			// 创建一个deffered,用于通知是否完成操作
			var deferred = WebUploader.Deferred();
			// 计算文件的唯一标识，用于断点续传和妙传
			(new WebUploader.Uploader()).md5File(file, 0, 5*1024*1024)
				.progress(function(percentage){
					$("#"+file.id).find("span.state").text("正在获取文件信息...");
				})
				.then(function(val) {
					fileMd5 = val;
					fileName = file.name;
					file_id = file.id;
					$("#" + file.id).find("span.state").text("成功获取文件信息");
					// 放行	
					deferred.resolve();
				});
			// 通知完成操作
			return deferred.promise();
		},
		beforeSend:function(block) {
			var deferred = WebUploader.Deferred();
			
			// 支持断点续传，发送到后台判断是否已经上传过
			$.ajax(
				{
					type:'POST',
					url:serverUrl+'/uploadActionServlet?action=checkChunk',
					data:{
						// 文件唯一表示								
						fileMd5:fileMd5,
						// 当前分块下标
						chunk:block.chunk,
						// 当前分块大小
						chunkSize:block.end-block.start
					},
					dataType:'json',
					success:function(response) {
						if(response.ifExist) {
							// 分块存在，跳过该分块
							deferred.reject();
						} else {
							// 分块不存在或不完整，重新发送
							deferred.resolve();
						}
					}
				}
			);
			
			
			// 发送文件md5字符串到后台
			this.owner.options.formData.fileMd5 = fileMd5;
			return deferred.promise();
		},
		afterSendFile:function() {
			// 通知合并分块
			$.ajax(
				{
					type:'POST',
					url:serverUrl+'/uploadActionServlet?action=mergeChunks',
					data:{
						fileMd5:fileMd5,
						fileName:fileName,
						file_id:file_id,
						fileId:fileId,
						faUserName:faUserName
					},
					dataType:'json',
					success:function(response){
						//更新操作按钮
						var faId = response.faId;
						var file_id = response.file_id;
						$li = $( '#'+file_id );
						$li.html(
								"<a href=downloadFile('"+faId+"')>" + fileName + "</a>"+"<span class='state'></span>"+
								"<a href='javascript:void(0)'"+
								" class='mho_float_right mho_red_color' style='margin: 0 10px;' onclick=downloadFile('"+faId+"')>下载</a>"+
								"<a href='javascript:void(0)'"+
								" class='mho_float_right mho_green_color' style='margin: 0 10px;' onclick=deleteFile('"+faId+"')>删除</a>"
								);
						$li.attr('id',faId);
						//$( '#'+faId ).find('span.state').text('已上传');
					}
				}
			);
		}
	}
);
// 上传基本配置
var uploader = WebUploader.create(
	{
		swf:'component/front_transform/webuploader-0.1.5/Uploader.swf',
		server:serverUrl+'/fileUploadServlet',
		pick:{
			id:pick_file,
			multiple: true
		},
		auto:false,
		dnd:"#dndArea",
		disableGlobalDnd:true,
		paste:'document.body',
		//fileNumLimit: maxFileCounts,  
        //fileSizeLimit: * 1024 * 1024,    // 单次上传文件总大小不超过
        fileSingleSizeLimit: maxFileSize,    // 单个文件大小不超过

		// 分块上传设置
		// 是否分块
		chunked:true,
		// 每块文件大小（默认5M）
		chunkSize:5*1024*1024,
		chunkRetry: 3,
		// 开启几个并非线程（默认3个）
		threads:1,
		// 在上传当前文件时，准备好下一个文件
		prepareNextFile:false
	}		
);
// 生成缩略图和上传进度
uploader.on("fileQueued", function(file) {
	$('#file_name').val('已选中'+uploader.getFiles().length+'个文件');
	var start = file.name.lastIndexOf('.');
	var fileType = (start == -1 ? '' : file.name.substring(start+1)).toLowerCase();
	var errorMessage = [];
	var acceptFileTypesArray = acceptFileTypes ? acceptFileTypes.split(',') : [];
	if (acceptFileTypesArray.length > 0 && $.inArray(fileType, acceptFileTypesArray) == -1) {
		errorMessage.push(fileType+',该文件类型不允许上传');
	}
	
	if (maxFileSize > 0 && file.size > maxFileSize) {
		
		errorMessage.push(file.name+',该文件大小已超过 '+$.formatNumber(maxFileSize/(1024*1024),2,'.','')+'MB');
	}
	/*if(maxFileCounts>0) {
		var files = uploader.getFiles().length;
		if(files > maxFileCounts) {
			errorMessage.push('最多只能上传'+maxFileCounts+'个文件');
		}
	}*/
		// 把文件信息追加到fileList的div中
		//$("#fileList").append("<div id='" + file.id + "'><img/><span>" + file.name + "</span><div><span class='state'></span></div><div><span class='percentage'></span></div></div>");
		$("#list_ul").append("<li id='" + file.id + "'><a href='javascript:void(0)'>" + file.name + "</a>"+"<span class='state'></span>"+"<span class='percentage'></span>"+//待上传
				"<a href='javascript:void(0)'"+
				"id='" + file.id + "btn1' name='btn1' class='mho_float_right mho_red_color' style='margin: 0 10px;'>上传</a>"+//上传
				"<a href='javascript:void(0)'"+
				"id='" + file.id + "btn2' name='btn2' class='mho_float_right mho_green_color' style='margin: 0 10px;'  onclick=remove('"+file.id+"')>移除</a>"+//移除
				"</li>");
		$(document).on('click','#'+file.id+'btn1', function() {
			if (uploader.state === 'uploading') {  
				uploader.stop(file);  
				$('#'+file.id+'btn1').text("");  
				$('#'+file.id+'btn2').text(""); 
				} else {  
					uploader.upload(file);  
					$('#'+file.id+'btn1').text(""); 
					$('#'+file.id+'btn2').text(""); 
				}  
		});
		//单个开始上传或停止上传
		$.ajax(
				{
					type:'POST',
					url:'checkAnnexFileName.do?method=checkAnnexFileName',
					data:{
						fileName:file.name
					},
					dataType:'json',
					//async:false,
					success:function(response){
						if(response.success !== false){
							errorMessage.push(response.message);
						}
						debugger
						if(errorMessage.length>0){
							MessageBox.alert('提示', errorMessage, function(){
								var $li = $( '#'+file.id );
								uploader.removeFile(file.id,true);
								$('#'+file.id+'btn1').text("");
								$('#'+file.id+'btn2').text("");
								//3秒后清空
								setTimeout(function(){
									$li.remove();
									if(uploader.getFiles().length == '0'){
										$('#file_name').val("");
									}else{
										$('#file_name').val("已选中"+uploader.getFiles().length+"个文件");
									}
								}, 3000);
						});
						}
					}
				}
			);
	}
);

uploader.on( 'uploadProgress', function(file,percentage) {
    var $li = $( '#'+file.id );
        //$percent = $li.find('.progress .progress-bar');

    // 避免重复创建
   /* if ( !$percent.length ) {
        $percent = $('<div class="progress progress-striped active">' +
          '<div class="progress-bar" role="progressbar" style="width: 0%">' +
          '</div>' +
        '</div>').appendTo( $li ).find('.progress-bar');
    }*/

    $li.find('span.state').text('上传中');
    $("#" + file.id).find("span.percentage").text(Math.round(percentage * 100) + "%");
});
uploader.on( 'uploadSuccess', function( file ) {
    $( '#'+file.id ).find('span.state').text('');
    uploader.removeFile(file,true);
});

uploader.on( 'uploadError', function( file ) {
    $( '#'+file.id ).find('span.state').text('上传出错');
});

uploader.on( 'uploadComplete', function( file ) {
	$('#file_name').val("");
});
//全部开始上传或停止上传
$(document).on('click','#upload_file', function() {
	
	if (uploader.state === 'uploading') {  
		uploader.stop();  
		} else {  
			uploader.upload();  
			$('.btn1').text("");
			$('.btn2').text("");
		}  
});
//移除（从队列）
function remove(id){  
	debugger
	var $li = $( '#'+id );
	uploader.removeFile(id,true);  
	$li.remove();
	if(uploader.getFiles().length == '0'){
		$('#file_name').val("");
	}else{
		$('#file_name').val("已选中"+uploader.getFiles().length+"个文件");
	}
	//
} 
//删除（从服务器）
function deleteFile(faId) {
	MessageBox.yes('提示','请确认是否删除?', function(){
		$.get('deleteAnnexFile.do?method=deleteAnnexFile&faId='+faId, function(data) {
			var message = data.message || '删除成功';
			MessageBox.alert('提示', message, function(){
				debugger
				if (data.success !== false) {
					var $li = $( '#'+faId );
					$li.remove();
				}
			});
		}, 'json');
	});
};
//下载
function downloadFile(faId) {
	MessageBox.openWindow('downAnnexFile.do?method=downAnnexFile&faId='+faId);
};

