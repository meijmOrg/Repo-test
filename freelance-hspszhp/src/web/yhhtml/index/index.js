(function() {
	$('.mho_left_menu_tree li').click(function(e) {
		e.stopPropagation();
		$(this).children('ul').slideToggle();
	});;
	
	$('#toggleLeft').click(function() {
		if($(this).find('i.fa').hasClass('fa-arrow-left')) {
			$('.mho_left_menu').animate({'left': '-200px'});
			$('.mho_center').animate({'left': '0'});
			$(this).find('i.fa').addClass('fa-arrow-right').removeClass('fa-arrow-left');
		}else {
			$('.mho_left_menu').animate({'left': '0'});
			$('.mho_center').animate({'left': '200px'});
			$(this).find('i.fa').addClass('fa-arrow-left').removeClass('fa-arrow-right');
		}
	});
}());