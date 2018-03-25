$(function() {
	var defaults = {
		type: null,
		title: null,
		content: null,
		$context: null,
		callback: null,
		size: null
	};
	var Dialog = function(setting) {
		debugger
		this.setting = $.extend({}, defaults, setting);
		this.$el = $(
			'<div class="mho_modal">'+
				'<div class="mho_modal_dialog">'+
					'<div class="mho_modal_content">'+
						'<div class="mho_modal_header">'+
							'<span class="mho_modal_title"></span>'+
							'<span class="mho_modal_close"><i class="fa fa-remove"></i></span>'+
						'</div>'+
						'<div class="mho_modal_body"></div>'+
						'<div class="mho_modal_footer">' +
							'<button class="mho_btn mho_btn_empty mho_btn_circle">确认</button>'+
							'<button class="mho_btn mho_btn_empty mho_btn_circle">取消</button>'+
							'<button class="mho_btn mho_btn_empty mho_btn_circle">重置</button>'+
						'</div>'+
					'</div>'+
				'</div>'+
		  '</div>'
		);
		$.extend(this, {
			$dialog: this.$el.find('.mho_modal_dialog'),
			$content: this.$el.find('.mho_modal_content'),
			$header: this.$el.find('.mho_modal_header'),
			$title: this.$el.find('.mho_modal_title'),
			$close: this.$el.find('.mho_modal_close'),
			$body: this.$el.find('.mho_modal_body'),
			$footer: this.$el.find('.mho_modal_footer')
		});
		this.init();
	}
	Dialog.prototype = {
		init: function() {
			var that = this;
			this.$el.appendTo($(window.top.document.body));
			this.$body.load(this.setting.url, function() {
				that.rePosition();
			});
			this.$dialog.width(this.setting.width);
			this.$title.html(this.setting.title);
			this.$close.click(function() {
				that.$el.remove();
				that = null;
			});
		},
		rePosition: function() {
			var that = this;
            (that.$body.height()>$(window.top.document.body).height()) && that.$dialog.css({'margin-top': 100});
		}
	};
	window.Dialog = Dialog;
}());