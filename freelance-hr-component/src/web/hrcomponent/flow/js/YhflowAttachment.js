var uploader = WebUploader.create({
	pick: '#pick_file',
	resize: false
});
uploader.on('fileQueued', function(file) {
	$('#file_name').val(file.name);
});
