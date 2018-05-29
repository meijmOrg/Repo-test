<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/js_css_base_include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="component/front_transform/font-awesome-4.7.0/css/font-awesome.css">
<link rel="stylesheet" href="component/front_transform/mho.css">
<script src="component/front_transform/lib/jquery-3.2.1.min.js"></script>
<script src="component/front_transform/lib/Chart.min.js"></script>
<!--<script src="../chart.js/dist/Chart.js"></script>-->
<title>首页</title>
</head>
<body>
<div class="mho_row">
	<div class="mho_col mho_col_3" onclick="goFlowWorktop('daiban');">
		<div class="mho_panel">
			<div class="mho_task_panel_content mho_dep_blue_color">
				<h2 id="dbTotal">0</h2>
				<span>Total</span>
				<i class="fa fa-paperclip fa-3x"></i>
			</div>
			<div class="mho_panel_foot mho_dep_blue mho_white_color">待办</div>
		</div>
	</div>
	<div class="mho_col mho_col_3">
		<div class="mho_panel">
			<div class="mho_task_panel_content mho_red_color">
				<h2 id="ybTotal">0</h2>
				<span>Total</span>
				<i class="fa fa-paper-plane-o fa-3x"></i>
			</div>
			<div class="mho_panel_foot mho_red mho_white_color">已办</div>
		</div>
	</div>
	<div class="mho_col mho_col_3">
		<div class="mho_panel">
			<div class="mho_task_panel_content mho_green_color">
				<h2 id="jqTotal">0</h2>
				<span>Total</span>
				<i class="fa fa-unlock-alt fa-3x"></i>
			</div>
			<div class="mho_panel_foot mho_green mho_white_color">加签</div>
		</div>
	</div>
	<div class="mho_col mho_col_3">
		<div class="mho_panel">
			<div class="mho_task_panel_content mho_dep_yellow_color">
				<h2 id="csTotal">0</h2>
				<span>Total</span>
				<i class="fa fa-file-text-o fa-3x"></i>
			</div>
			<div class="mho_panel_foot mho_dep_yellow mho_white_color">抄送</div>
		</div>
	</div>
	<div class="mho_col mho_col_3">
		<div class="mho_panel">
			<div class="mho_task_panel_content mho_dep_yellow_color">
				<h2 id="xtTotal">0</h2>
				<span>Total</span>
				<i class="fa fa-file-text-o fa-3x"></i>
			</div>
			<div class="mho_panel_foot mho_dep_yellow mho_white_color">协同</div>
		</div>
	</div>
</div>
<div class="mho_row">
	<div class="mho_col mho_col_6">
		<div class="mho_panel">
			<div class="mho_panel_head">考勤统计</div>
			<div class="mho_panel_content">
				<canvas id="barChart" width="360" height="260"></canvas>
			</div>
		</div>
	</div>
	<div class="mho_col mho_col_6">
		<div class="mho_row">
			<div class="mho_col mho_col_12 mho_panel">
				<div class="mho_panel_head">请假统计</div>
				<div class="mho_panel_content">
					<div style="width:145px;">
						<canvas id="pieChart" width="80" height="80"></canvas>
					</div>
				</div>
			</div>
			<div class="mho_col mho_col_12 mho_panel" style="margin:0;">
				<div class="mho_panel_head">请假统计</div>
				<div class="mho_panel_content">
					<div style="width:145px;">
						<canvas id="pieChart1" width="80" height="80"></canvas>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="mho_row">
	<div class="mho_col mho_col_6">
		<div class="mho_panel">
			<div class="mho_panel_head">最新签约</div>
			<div class="mho_panel_content">
				<ul class="mho_dot_line">
					<li>
						<a href="javascript:void(0)">
							<small class="mho_gray_color">2016-7-21</small>
							<p class="mho_ellipsis">特朗普幕僚擅发飓风假新闻 吐嘈声完全挡不住！</p>
						</a>
					</li>
					<li>
						<a href="javascript:void(0)">
							<small class="mho_gray_color">2016-7-21</small>
							<p class="mho_ellipsis">特朗普幕僚擅发飓风假新闻 吐嘈声完全挡不住！</p>
						</a>
					</li>
					<li>
						<a href="javascript:void(0)">
							<small class="mho_gray_color">2016-7-21</small>
							<p class="mho_ellipsis">特朗普幕僚擅发飓风假新闻 吐嘈声完全挡不住！</p>
						</a>
					</li>
					<li>
						<a href="javascript:void(0)">
							<small class="mho_gray_color">2016-7-21</small>
							<p class="mho_ellipsis">特朗普幕僚擅发飓风假新闻 吐嘈声完全挡不住！</p>
						</a>
					</li>
					<li>
						<a href="javascript:void(0)">
							<small class="mho_gray_color">2016-7-21</small>
							<p class="mho_ellipsis">特朗普幕僚擅发飓风假新闻 吐嘈声完全挡不住！</p>
						</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<div class="mho_col mho_col_6">
		<div class="mho_panel">
			<div class="mho_panel_head">最新签约</div>
			<div class="mho_panel_content">
				<ul class="mho_dot_line">
					<li>
						<a href="javascript:void(0)">
							<small class="mho_gray_color">2016-7-21</small>
							<p class="mho_ellipsis">特朗普幕僚擅发飓风假新闻 吐嘈声完全挡不住！</p>
						</a>
					</li>
					<li>
						<a href="javascript:void(0)">
							<small class="mho_gray_color">2016-7-21</small>
							<p class="mho_ellipsis">特朗普幕僚擅发飓风假新闻 吐嘈声完全挡不住！</p>
						</a>
					</li>
					<li>
						<a href="javascript:void(0)">
							<small class="mho_gray_color">2016-7-21</small>
							<p class="mho_ellipsis">特朗普幕僚擅发飓风假新闻 吐嘈声完全挡不住！</p>
						</a>
					</li>
					<li>
						<a href="javascript:void(0)">
							<small class="mho_gray_color">2016-7-21</small>
							<p class="mho_ellipsis">特朗普幕僚擅发飓风假新闻 吐嘈声完全挡不住！</p>
						</a>
					</li>
					<li>
						<a href="javascript:void(0)">
							<small class="mho_gray_color">2016-7-21</small>
							<p class="mho_ellipsis">特朗普幕僚擅发飓风假新闻 吐嘈声完全挡不住！</p>
						</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>
<script src="home.js"></script>
</body>
</html>