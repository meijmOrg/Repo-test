/*var uploader_pick = WebUploader.create({
	pick: '#pick_file',
	resize: false
});
uploader_pick.on('fileQueued', function(file) {
	$('#file_name').val(file.name);
});*/

//监听分块上传的时间点，断点续传
var fileMd5;
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
						fileMd5:fileMd5
					},
					success:function(response){
						alert("1");
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
		
		// 分块上传设置
		// 是否分块
		chunked:true,
		// 每块文件大小（默认5M）
		chunkSize:5*1024*1024,
		chunkRetry: 3,
		// 开启几个并非线程（默认3个）
		threads:1,
		// 在上传当前文件时，准备好下一个文件
		prepareNextFile:true
		//formData:function(){return {uniqueFileName: '333'};}
		//formData: {uniqueFileName: uniqueFileName}
	}		
);

// 生成缩略图和上传进度
uploader.on("fileQueued", function(file) {
	$('#file_name').val(file.name);
	debugger
		// 把文件信息追加到fileList的div中
		//$("#fileList").append("<div id='" + file.id + "'><img/><span>" + file.name + "</span><div><span class='state'></span></div><div><span class='percentage'></span></div></div>");
		$("#list_ul").append("<li id='" + file.id + "'><a href='javascript:void(0)'>" + file.name + "</a>"+"<span class='state'></span>"+"<span class='percentage'></span>"+
				"<a href='javascript:void(0)'"+
				"id='btn1' class='mho_float_right mho_red_color' style='margin: 0 10px;' onclick='stop()'>取消上传</a>"+
				"<a href='javascript:void(0)'"+
				"id='btn2' class='mho_float_right mho_green_color' style='margin: 0 10px;'  onclick='remove()'>移除</a>"+
				"</li>");
		// 制作缩略图
		// error：不是图片，则有error
		// src:代表生成缩略图的地址
		/*uploader.makeThumb(file, function(error, src) {
			if (error) {
				$("#" + file.id).find("img").replaceWith("<span>无法预览&nbsp;</span>");
			} else {
				$("#" + file.id).find("img").attr("src", src);
			}
		});*/
	}
);

// 监控上传进度
// percentage:代表上传文件的百分比
/*uploader.on("uploadProgress", function(file, percentage) {
	debugger
	$("#" + file.id).find("span.percentage").text(Math.round(percentage * 100) + "%");
});*/
uploader.on( 'uploadProgress', function(file,percentage) {
	debugger
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
    //$percent.css( 'width', percentage * 100 + '%' );
});
uploader.on( 'uploadSuccess', function( file ) {
    $( '#'+file.id ).find('span.state').text('已上传');
});

uploader.on( 'uploadError', function( file ) {
    $( '#'+file.id ).find('span.state').text('上传出错');
});

uploader.on( 'uploadComplete', function( file ) {
    $( '#'+file.id ).find('.percentage').fadeOut();
});
$(document).on('click','#upload_file', function() {
	debugger
	if (uploader.state === 'uploading') {  
		uploader.stop();  
		} else {  
			uploader.upload();  
		}  
});
function start(){  
	uploader.upload();  
	$('#btn1').attr("onclick","stop()");  
	$('#btn1').text("取消上传");  
}  
          
function stop(){  
	uploader.stop(true);  
	$('#btn1').attr("onclick","start()");  
	$('#btn1').text("继续上传");  
} 
