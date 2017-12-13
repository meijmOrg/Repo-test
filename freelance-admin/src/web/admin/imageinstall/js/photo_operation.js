
/************************************************** 相片操作 ****************************************************/
Photo = function(){
    var previewTimeoutId;
    var previewTimeoutId = null;

    return {
        getPosXY: function(a,offset){
            var p=offset?offset.slice(0):[0,0],tn;
            while(a){
                tn=a.tagName.toUpperCase();
                if(tn=='IMG'){
                    a=a.offsetParent;continue;
                }
                p[0]+=a.offsetLeft-(tn=="DIV"&&a.scrollLeft?a.scrollLeft:0);
                p[1]+=a.offsetTop-(tn=="DIV"&&a.scrollTop?a.scrollTop:0);
                if(tn=="BODY"){
                    break;
                }
                a=a.offsetParent;
            }
            return p;
        },

        checkComplete: function(){
            if(this.__img&&this.__img.complete){
                this.__onload();
            }
        },

        __onload : function(){
            clearInterval(this.__timeId);
            var w=this.__img.width;
            var h=this.__img.height;
        },

        showPreview: function(e){
            this.hidePreview(e);
            previewFrom=e.target||e.srcElement;
            previewTimeoutId=setTimeout('Photo._showPreview()',500);
            this.__img=null;
        },

        hidePreview: function(e){
            if(e){
                var toElement=e.relatedTarget||e.toElement;
                while(toElement){
                    if(toElement.id=='PreviewBox')
                        return;
                    toElement=toElement.parentNode;
                }
            }
            try{
                clearInterval(this.__timeId);
                this.__img=null;
            }
            catch(e){}
            clearTimeout(previewTimeoutId);
        },

        _showPreview: function(){
            this.__img=new Image();
            if(previewFrom.tagName.toUpperCase()=='A')
                previewFrom=previewFrom.getElementsByTagName('img')[0];
            var largeSrc=previewFrom.getAttribute("large-src");
            var picLink=previewFrom.getAttribute("pic-link");
            if(!largeSrc)
                return;
            else{
                this.__img.src=largeSrc;
                this.href=picLink;
                this.__timeId=setInterval("Photo.checkComplete()",20);
                var pos=this.getPosXY(previewFrom,[75,-2]);
            }
        }
    };
}()
/********************************************* 相片操作 *******************************************************/

$(function() {
    $("#file_upload").change(function() {
        var $file = $(this);
        var fileObj = $file[0];
        var windowURL = window.URL || window.webkitURL;
        var dataURL;
        var $img = $("#previewImg");
        if(fileObj && fileObj.files && fileObj.files[0]){
            dataURL = windowURL.createObjectURL(fileObj.files[0]);
            $img.attr('src',dataURL);
        }else{
            dataURL = $file.val();

            // $img.css("filter",'progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod = scale,src="' + dataURL + '")');

            // var imgObj = document.getElementById("previewImg");
            // imgObj.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\"" + dataURL + "\")";
            // imgObj.style.width = "48px";
            // imgObj.style.height = "48px";

            var imgObj = document.getElementById("previewImg");
            // 两个坑:
            // 1、在设置filter属性时，元素必须已经存在在DOM树中，动态创建的Node，也需要在设置属性前加入到DOM中，先设置属性在加入，无效；
            // 2、src属性需要像下面的方式添加，上面的两种方式添加，无效；
            imgObj.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
            imgObj.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = dataURL;

        }
    });
    
    $("#file_upload2").change(function() {
        var $file = $(this);
        var fileObj = $file[0];
        var windowURL = window.URL || window.webkitURL;
        var dataURL;
        var $img = $("#previewImg2");
        if(fileObj && fileObj.files && fileObj.files[0]){
            dataURL = windowURL.createObjectURL(fileObj.files[0]);
            $img.attr('src',dataURL);
        }else{
            dataURL = $file.val();

            // $img.css("filter",'progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod = scale,src="' + dataURL + '")');

            // var imgObj = document.getElementById("previewImg");
            // imgObj.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\"" + dataURL + "\")";
            // imgObj.style.width = "48px";
            // imgObj.style.height = "48px";

            var imgObj = document.getElementById("previewImg2");
            // 两个坑:
            // 1、在设置filter属性时，元素必须已经存在在DOM树中，动态创建的Node，也需要在设置属性前加入到DOM中，先设置属性在加入，无效；
            // 2、src属性需要像下面的方式添加，上面的两种方式添加，无效；
            imgObj.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
            imgObj.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = dataURL;

        }
    });
});

//上传图片(logo和banner一起上传)
function uploadPhoto(){
	var logoFile = document.getElementById("file_upload").value;
	var bannerFile = document.getElementById("file_upload2").value;
	if(logoFile == '' || logoFile==null){
		MessageBox.alert('消息', "请选择要上传的Logo文件！");
		return;
	}
	if(bannerFile == '' || bannerFile==null){
		MessageBox.alert('消息', "请选择要上传的Banner文件！");
		return;
	}
	$.ajax({
        url : 'updateImageInstall.do?method=updateImageInstall',
        data: new FormData($('#uploadForm')[0]),
        type : 'post',
        dataType : 'json',
        async : false,
        cache: false,
        processData: false,
        contentType: false,
        success : function(data) {
            if (data.success) {
            	MessageBox.alert('消息',data.message);
            }
            else
            {
            	MessageBox.alert('消息',data.message);
            }
        }
    });
}

//上传logo
function uploadLogoPhoto(){
	var logoFile = document.getElementById("file_upload").value;
	if(logoFile == '' || logoFile==null){
		MessageBox.alert('消息', "请选择要上传的Logo文件！");
		return;
	}
	$.ajax({
        url : 'updateImageInstall.do?method=updateImageInstall&flag=logo',
        data: new FormData($('#uploadForm')[0]),
        type : 'post',
        dataType : 'json',
        async : false,
        cache: false,
        processData: false,
        contentType: false,
        success : function(data) {
            if (data.success) {
            	MessageBox.alert('消息',data.message);
            }
            else
            {
            	MessageBox.alert('消息',data.message);
            }
        }
    });
}

//上传banner
function uploadBannerPhoto(){
	var bannerFile = document.getElementById("file_upload2").value;
	if(bannerFile == '' || bannerFile==null){
		MessageBox.alert('消息', "请选择要上传的Banner文件！");
		return;
	}
	$.ajax({
        url : 'updateImageInstall.do?method=updateImageInstall&flag=banner',
        data: new FormData($('#uploadForm')[0]),
        type : 'post',
        dataType : 'json',
        async : false,
        cache: false,
        processData: false,
        contentType: false,
        success : function(data) {
            if (data.success) {
            	MessageBox.alert('消息',data.message);
            }
            else
            {
            	MessageBox.alert('消息',data.message);
            }
        }
    });
}
