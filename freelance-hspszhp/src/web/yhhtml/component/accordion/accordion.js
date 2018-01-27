$('.mho_tabs_nav li').on('click.mho_tabs_nav', function() {
	var $tabs = $(this).closest('.mho_tabs');
	$(this).siblings('li').removeClass('mho_active');
	$(this).addClass('mho_active');
	$tabs.find('.mho_tab_panel').removeClass('mho_active');
	$tabs.find('.mho_tab_panel').eq($(this).index()).addClass('mho_active');
});