(function() {
	$('.mho_left_menu_tree li').click(function(e) {
		e.stopPropagation();
		$(this).children('ul').slideToggle();
	});;

	var ctx1 = document.getElementById("barChart").getContext("2d");
	var data1 = {
		labels : ["January","February","March","April","May","June","July"],
		datasets : [
			{
				fillColor : "#303f9f",
				data : [65,59,90,81,56,55,40]
			}
		]
	}
	var myNewChart = new Chart(ctx1).Bar(data1);

	var ctx2 = document.getElementById("pieChart").getContext("2d");
	var data2 = [
		{
			value: 30,
			color:"#F38630"
		},
		{
			value : 50,
			color : "#E0E4CC"
		},
		{
			value : 100,
			color : "#69D2E7"
		}			
	]
	var c1 = new Chart(ctx2).Pie(data2);

	var ctx3 = document.getElementById("pieChart1").getContext("2d");
	var data3 = [
		{
			value: 30,
			color:"#F38630"
		},
		{
			value : 50,
			color : "#E0E4CC"
		},
		{
			value : 100,
			color : "#69D2E7"
		}			
	]
	var c1 = new Chart(ctx3).Pie(data3);
	/**var ctx = document.getElementById("barChart").getContext("2d");
	var myChart = new Chart(ctx, {
		type: 'bar',
		data: {
			labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
			datasets: [{
				label: '# of Votes',
				data: [12, 19, 3, 5, 2, 3],
				backgroundColor: [
					'#303f9f',
					'#303f9f',
					'#303f9f',
					'#303f9f',
					'#303f9f',
					'#303f9f'
				],
				borderWidth: 1
			}]
		},
		options: {
			scales: {
				yAxes: [{
					ticks: {
						beginAtZero:true
					}
				}]
			}
		}
	});
	var ctx = document.getElementById("pieChart").getContext("2d");
	var myChart = new Chart(ctx, {
		type: 'pie',
		data: {
			datasets: [{
				data: [10, 20, 30],
				backgroundColor: [
					'red',
					'yellow',
					'blue'
				]
			}],
			// These labels appear in the legend and in the tooltips when hovering different arcs
			labels: [
				'Red',
				'Yellow',
				'Blue'
			]
		}
	});
	var ctx = document.getElementById("pieChart1").getContext("2d");
	var myChart = new Chart(ctx, {
		type: 'pie',
		data: {
			datasets: [{
				data: [10, 20, 30],
				backgroundColor: [
					'red',
					'yellow',
					'blue'
				]
			}],
			// These labels appear in the legend and in the tooltips when hovering different arcs
			labels: [
				'Red',
				'Yellow',
				'Blue'
			]
		}
	});**/
}());