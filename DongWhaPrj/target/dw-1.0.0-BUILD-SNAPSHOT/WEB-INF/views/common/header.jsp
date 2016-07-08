<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<link href="/resources/css/jquery/jquery-ui-1.11.4.min.css" rel="stylesheet" />
<script src="/resources/js/jquery/jquery-1.11.3.min.js"></script>
<script src="/resources/js/jquery/jquery.form-3.51.0.min.js"></script>
<script src="/resources/js/jquery/jquery-ui-1.11.4.min.js"></script>
<style type="text/css">
/* 로딩바 START */
div.loadingDiv {
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background-color: gray;
	opacity: 0.3;
	text-align: center;
}
div.loadingDiv .loadingImg {
	position: relative;
	top: 50%;
	transform: translateY(-100%);
}
/* 로딩바 END */
</style>
<script type="text/javascript">
var loadingTag = '<div class="loadingDiv"><img class="loadingImg" alt="loading" src="/resources/image/common/loader.gif"/></div>';
jQuery(function($) {
	var loading = $(loadingTag).appendTo("body").hide();
	$(window).ajaxStart(function(handler) {
    	loading.show();
    });
	$(window).ajaxStop(function() {
    	loading.hide();
    });
});
</script>