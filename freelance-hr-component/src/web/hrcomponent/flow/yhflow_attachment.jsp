<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>附件</title>
<style type="text/css">
	/* #dndArea {
		width: 200px;
		height: 100px;
		border-color: red;
		border-style: dashed;
	} */
</style>
<script type="text/javascript">
	/*  (function($, window, document){
		var params = {};
		params.templateId = ;
		params.templateCode = ;
		params.fileCode = ;
		params.fileTitle = ;
		template_Id//文档模板唯一ID
		template_Code文档模板Code
		file_code文档Code
		file_title文件标题
		file_KeyWord文档描述
		file_Flow_Status流程处理状态
		file_create_org_oid文档创建部门
		file_emergency_level紧急程度
		file_security_rate文档密级
		 params.refRoleCode = params.refRoleCode || refRoleCode;		// 操作角色
		params.refCode = params.refCode || itemNodeCode;			// 当前环节的来源代码
		params.viewRefCodes = params.viewRefCodes || viewRefCodes;	// 要查看的所有来源（为空时查看所有来源，默认为空）
		params.refOid = selectRow[0].data.taskOid;					// 来源主键，业务主键（taskOid） 
		params.maxFileSize = 50*1024*1024;		// 字节 50MB
//		params.acceptFileTypes = (params.acceptFileTypes == undefined || params.acceptFileTypes == null) ? "doc,docx,xls,xlsx,zip,pdf,jpg,png,tif" : params.acceptFileTypes; // 默认为doc,zip,pdf,jpg,tif
		params.noAcceptFileTypes = (params.noAcceptFileTypes == undefined || params.noAcceptFileTypes == null) ? "exe" : params.noAcceptFileTypes; // 默认为exe
		params.maxFileCounts = (params.maxFileCounts == undefined || params.maxFileCounts == null) ? 0 :  params.maxFileCounts;	//最多上传文件的个数（默认为0表示不作限制）
		
		debugger
		var maxFileSize = parseInt('0');
		var acceptFileTypes = '${param.acceptFileTypes}'.toLowerCase();
		var noAcceptFileTypes = '${param.noAcceptFileTypes}'.toLowerCase();
		acceptFileTypes = acceptFileTypes ? acceptFileTypes.split(',') : [];
		noAcceptFileTypes = noAcceptFileTypes ? noAcceptFileTypes.split(',') : [];
		
		var maxFileCounts = $.parseNumber('${param.maxFileCounts}');
		
		$('#fileuploadDomId').fileupload({
			maxChunkSize : 1000000, // 1 MB
			dataType : 'json',
	        sequentialUploads: true,
			add : function(e, data) {
				var file = data.files[0];
				
				var start = file.name.lastIndexOf('.');
				var fileType = (start == -1 ? '' : file.name.substring(start+1)).toLowerCase();
				
				var errorMessage = [];
				if ((acceptFileTypes.length > 0 && $.inArray(fileType, acceptFileTypes) == -1)||(noAcceptFileTypes.length > 0 && $.inArray(fileType, noAcceptFileTypes) >= 0)) {
					
					errorMessage.push('该文件类型不允许上传');
				}
				
				if (maxFileSize > 0 && file.size > maxFileSize) {
					
					errorMessage.push('该文件大小已超过 '+$.formatNumber(maxFileSize/(1024*1024),2,'.','')+'MB');
				}

				if(maxFileCounts>0) {
					var files = $('#trs').size();
					files += data.files.length;
					if(files > maxFileCounts) {
						errorMessage.push('最多只能上传'+maxFileCounts+'个文件');
					}
				}
				
				var buff = [
					'<tr id="trs">',
						'<td style="width:40%!important;" name="name" title="'+file.name+'">','<span class="file-icon file-',fileType,'"></span>',,file.name,'</td>',
						'<td style="width:15%!important;" title="'+$.formatNumber(file.fileLength/(1024*1024),2,'.','')+'MB">',
						$.formatNumber(file.size/(1024*1024),2,'.',''),'MB',
						'</td>',
						'<td style="width:30%!important;" name="progress">',
							(errorMessage.join('；') || '文件读取中...'),
						'</td>',
						'<td style="width:15%!important;" class="st-handle-icons"  name="operation">',
							'<a class="st-handle-upload" button-click="upload" title="上传"></a>', 
							'<a class="st-handle-close" button-click="remove" title="移除"></a>',//停止上传并移除
						'</td>',
					'</tr>'
				];
				var tr = $(buff.join(''));
				data.context = tr.prependTo('#fileuploadListId table >tbody');
				var sp = tr.find('td').eq(0).find('span');
				if(sp.hasClass('file-pdf')||sp.hasClass('file-doc')||sp.hasClass('file-docx')||sp.hasClass('file-txt')||sp.hasClass('file-xls')||sp.hasClass('file-xlsx')||sp.hasClass('file-zip')||sp.hasClass('file-png')||sp.hasClass('file-tif')||sp.hasClass('file-jpg')) {
				}else{
					sp.addClass('file-unknown');
				}
				var operation = data.context.find('td[name=operation]');
				
				if (errorMessage.length > 0) {
					data.context.attr('deprecated','y');
					//data.context.find('td[name=name]').addClass('statesBox_table_hui');
					data.context.find('td[name=progress]').addClass('upload-percent');
					operation.find('[button-click=upload]').addClass('st-handle-upload');
					operation.find('[button-click=remove]')
						.click(function() {
							data.abort();
							data.context.fadeOut(function(){
								data.context.remove();
							});
						});
					//3秒后清空
					setTimeout(function(){
						data.context.fadeOut(function(){
							data.abort();
							data.context.remove();
						});
					}, 3000);
				} 
				else {
					UploadPhotoUtils.md5({
						file : data.files[0],
						progress : function(loaded, total){
							var progress = parseInt(loaded / total * 100, 10);
							data.context.find('td[name=progress]').html('文件读取中('+progress+'%)');
						},
						complete : function(md5, fileName, file, options) {
							//TODO 上传前验证，可实现续传功能，待实现
							
							var uuid = UploadPhotoUtils.uuid();
							
							//构建url
							var url = 'uploadFile.do?method=uploadFile&refOid=${refOid}&refRoleCode=${refRoleCode}&refCode=${refCode}';
							url = url + '&uuid='+uuid;
							url = url + '&fileMD5='+md5;
							url = url + '&fileLength='+file.size;
							
							data.url = url;
							
							data.context.attr('uuid', uuid);
							data.context.find('td[name=progress]').html('<progress max="100" value="0"><ie style="width:100%;"></ie></progress><a class="file-upload-process">等待上传</a>');
							
							//上传
							operation.find('[button-click=upload]')
								.click(function() {
									if (data.context.attr('deprecated') == 'y') {
										return;
									}
									data.submit();
									data.context.attr('uploaded','y');
								});
							//移除
							operation.find('[button-click=remove]')
								.click(function() {
									data.abort();
									data.context.fadeOut(function(){
										data.context.remove();
									});
								});
						}
					});
				}
			},
			submit: function(e, data) {
				if (data.context.attr('uploaded') == 'y' || data.context.attr('deprecated') == 'y') {
					
					return false;
				}
			},
			progress : function(e, data) {
				var progress = parseInt(data.loaded / data.total * 100, 10);
				data.context.find('progress').attr('value', progress).next().html(progress+'%');
			},
			done : function(e, data) {
				
				var label = data.context.find('progress').next();
				
				if (data.result.postComplete === 1) {
					data.context.attr('fileOid', data.result.fileOid);
					label.html('上传完成');
					
					//3秒后清空提示
					setTimeout(function(){
						data.context.find('td[name=progress]').html('<a class="file-upload-process upload-success"> <span>上传成功</span></a>');
					}, 3000);
					
					var operation = data.context.find('td[name=operation]');
					operation.children().remove();
					operation.html('');
					var buff= [
						'<a class="st-handle-delete" button-click="delete" title="删除"></span>',//删除 <span>上传成功</span>的文件
						'<a class="st-handle-look look-gray" button-click="download" title="查看（下载）"></span>'
					];
					operation.html(buff.join(''));
					
					//从服务器上删除
					data.context.find('[button-click=delete]').click(function(){
						deleteFile.call(this, data.result.fileOid, data.context);
					});
					data.context.find('[button-click=download]').click(function(){
						downloadFile.call(this, data.result.fileOid, data.context);
					});
				}
				else if (data.result.success === false) {
					label.html('上传失败');
					data.context.attr('deprecated', 'y');
					//data.context.find('td[name=name]').addClass('statesBox_table_hui');
					label.addClass('upload-percent');
					data.context.find('progress').attr('value', 0).addClass('progress_red');
					data.abort();
				}
			}
		});
		
		//批量上传
		$('#batchUploadId').click(function(){
			
			$('#fileuploadListId table tr[uploaded!=y]').find('[button-click=upload]').click();
		})
		
		//列表查询
		var table = $('#fileuploadListId table >tbody');
		$.get(
			'listUploadFile.do?method=listUploadFile&viewRefCodes=${param.viewRefCodes}&refOid=${param.refOid}&refRoleCode=${param.refRoleCode}&refCode=${param.refCode}',
			function(data){
				$.each(data.rows,function(index, file){
					var authorities = file.authority.split(',');
					
					var buff = [
						'<tr  fileOid="'+file.fileOid+'">',
							'<td style="width:40%!important;" name="name" title="'+file.fileName+'">',
							'<span class="file-icon file-',(file.fileType?file.fileType.toLowerCase():''),'"></span>'
							,file.fileName,'</td>',
							'<td style="width:15%!important;" title="'+$.formatNumber(file.fileLength/(1024*1024),2,'.','')+'MB">',
							$.formatNumber(file.fileLength/(1024*1024),2,'.',''),'MB',
							'</td>',
							'<td style="width:30%!important;" name="progress" class="file-upload-process upload-success">',
							(file.postComplete==null||file.postComplete!=1)?'未上传':' <span>上传成功</span>',
							'</td>',
							'<td style="width:15%!important;" class="st-handle-icons" name="operation">',
								($.inArray('9', authorities) != -1 ? '<a class="st-handle-delete" button-click="delete" title="删除"></a>' : ''), 
								'<a class="st-handle-look look-gray" button-click="download" title="查看（下载）"></a>',
							'</td>',
						'</tr>'
					];
					
					var tr = $(buff.join(''));
					var context = $(buff.join('')).appendTo(table);
					var sp = tr.find('td').eq(0).find('span');
					if(sp.hasClass('file-pdf')||sp.hasClass('file-doc')||sp.hasClass('file-docx')||sp.hasClass('file-txt')||sp.hasClass('file-xls')||sp.hasClass('file-xlsx')||sp.hasClass('file-zip')||sp.hasClass('file-png')||sp.hasClass('file-tif')||sp.hasClass('file-jpg')) {
					}else{
						sp.addClass('file-unknown');
					}
					
					if ($.inArray('9', authorities) != -1) {
						//从服务器上删除
						context.find('[button-click=delete]').click(function(){
							deleteFile.call(this, file.fileOid, context);
						});
					}
					
					context.find('[button-click=download]').click(function(){
						downloadFile.call(this, file.fileOid, context);
					});
					
				});
			}
			,'json'
		);
		
		function deleteFile(fileOid, context) {
			MessageBox.yes('提示','请确认是否删除?', function(){
				$.get('deleteUploadFile.do?method=deleteUploadFile&fileOid='+fileOid, function(data) {
					var message = data.message || '删除成功';
					MessageBox.alert('提示', message, function(){
						if (data.success !== false) {
							context.fadeOut(function(){
								context.remove();
							});
						}
					});
				}, 'json');
			});
		};
		
		function downloadFile(fileOid) {
			MessageBox.openWindow('downloadUploadFile.do?method=downloadUploadFile&fileOid='+fileOid);
		};
	})(jQuery, window, document); */
	</script>
</head>
<body>
	<div class="mho_row mho_row_no_margin">
		<div class="mho_col mho_col_2"></div>
		<div class="mho_col mho_col_8">
			<div class="mho_form_group">
				<input id="file_name" type="text" readonly class="mho_form_field"
					style="width: 200px; flex-grow: 0;">
				<button id="pick_file" type="button"
					class="mho_btn mho_btn_primary mho_btn_file"
					style="margin-left: 20px;">浏览</button>
				<button id="upload_file" type="button" class="mho_btn mho_btn_primary"
					style="margin-left: 20px;">上传</button>
			</div>
			<!-- <div id="uploader" class="mho_form_group">
			<input id="file_name" type="text" readonly class="mho_form_field"
					style="width: 200px; flex-grow: 0;">
		    用来存放文件信息
		    <div id="thelist" class="uploader-list"></div>
		    <div class="btns">
		        <button id="pick_file" type="button"
					class="mho_btn mho_btn_primary mho_btn_file"
					style="margin-left: 20px;">浏览</button>
		        <button id="ctlBtn" class="btn btn-default mho_btn mho_btn_primary" style="margin-left: 20px;">开始上传</button>
		    </div> -->
</div>
		</div>
	</div>
	<div class="mho_row">
		<label class="mho_col mho_col_2 mho_text_right line_height_35">附件信息</label>
			<div class="mho_col <%=request.getParameter("widthFlag")%>">
			<section class="mho_accordion">
				<dl class="mho_accordion_item" style="border: 0;">
					<dt class="mho_accordion_title mho_pink mho_dep_pink_color">文件信息</dt>
					<dd class="mho_accordion_body" style="padding: 0;">
						<ul class="mho_list mho_list_strip" id="list_ul">
							<!-- <li><a href="javascript:void(0)">后勤保障处举办“五小”创新成果评选活动.jpg</a>
								<a href="javascript:void(0)"
								class="mho_float_right mho_red_color" style="margin: 0 10px;">删除</a>
								<a href="javascript:void(0)"
								class="mho_float_right mho_green_color" style="margin: 0 10px;">下载</a>
							</li> -->
						</ul>
					</dd>
				</dl>
			</section>
			</div>
	</div>
</body>
</html>