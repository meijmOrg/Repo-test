$(document).ready(function(){
	$('.mho_tabs_nav li').on('click.mho_tabs_nav', function() {
		var $tabs = $(this).closest('.mho_tabs');
		$(this).siblings('li').removeClass('mho_active');
		$(this).addClass('mho_active');
		$tabs.find('.mho_tab_panel').removeClass('mho_active');
		$tabs.find('.mho_tab_panel').eq($(this).index()).addClass('mho_active');
	});

	$('.mho_accordion .mho_accordion_item_toggle').click(function() {
		console.log($(this).find('i').hasClass('fa-angle-down'));
		if($(this).find('i').hasClass('fa-angle-down')) {
			$(this).find('i').removeClass('fa-angle-down').addClass('fa-angle-up');
		}else if($(this).find('i').hasClass('fa-angle-up')) {
			$(this).find('i').removeClass('fa-angle-up').addClass('fa-angle-down');
		}
		$(this).closest('.mho_accordion_item').find('.mho_accordion_body').slideToggle();
	});
});