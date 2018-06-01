$(function() {
	var defaults = {
		width: null,
		title: null,
		url: null,
		content: null
	};
	var Dialog = function(setting) {
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
			$body: this.$el.find('.mho_modal_body')
		});
		this.init();
	}
	Dialog.prototype = {
		init: function() {
			var that = this;
			this.$el.appendTo($(window.top.document.body)).data('dialog', this);
			if(this.setting.url) {
				var content = this.$body.load(this.setting.url, function(html, status, res) {
					that.rePosition();
				});
				this.content = content;
			}else {
				this.$body.append(this.setting.content);
			}
			this.$dialog.width(this.setting.width);
			this.$title.html(this.setting.title);
			this.$close.click(function() {
				that.close();
			});
		},
		rePosition: function() {
			var that = this;
            (that.$body.height()>$(window.top.document).height()) && that.$dialog.css({
				'transform': 'translate(-50%,0)',
				'top': 0
			});
		},
		close: function() {
			for(var i=0; i<Dialog.dialogs.length; i++) {
				if(Dialog.dialogs[i] == this) {
					Dialog.dialogs.splice(i, 1);
					break;
				}
			}
			this.$el.remove();
			that = null;
		}
	};
	$.extend(Dialog, {
		dialogs: [],
		page: function(setting) {
			var dialog = new Dialog(setting);
			this.dialogs.push(dialog);
		},
		close: function() {
			this.dialogs[this.dialogs.length-1].close();
		}
	});
	window.Dialog = Dialog;
	window.top.Dialog = Dialog;
}());