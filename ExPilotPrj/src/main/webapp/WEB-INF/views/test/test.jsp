<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="/WEB-INF/views/common/header.jsp" flush="false" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>테스트...</title>
<script type="text/javascript">
var loadingTag = '<div class="loadingDiv"><img class="loadingImg" alt="loading" src="/resources/image/loader.gif"/></div>';
var uploadProgressBarTag = '<div class="loadingDiv"><div class="loadingImg" style="width: 30%; margin: auto;" id="progressbar"></div></div>';
var uploadLoading;
jQuery(function($) {	
	uploadLoading = $(uploadProgressBarTag).appendTo("body").hide();
	
	var loading = $(loadingTag).appendTo("body").hide();
	$(window).ajaxStart(function(handler) {
    	loading.show();
    });
	$(window).ajaxStop(function() {
    	loading.hide();
    });
	$( "#progressbar" ).progressbar({
	      value: 50
	});
});

$(document).ready(function() {
	/* FileUpload(jquery form plugin 을 이용하는 방법.) - 페이지가 로딩될 때, 해당 form이 ajax로 전송될 수 있도록 하기 위해 다음과 같이 ajaxForm()을 실행한다. */
	$("#uploadForm").ajaxForm();
});

function getSysdate(){
	var url = "/testSysdate.json";
	
	$.ajax({
			url : url,
			success : function(data) {
				$("#sysdate").text(data.value);
			}
		});
}
</script>
</head>
<body>
<h3>오늘날짜 ajax로 가져오기</h3>
<a href="javascript:getSysdate();">3초 후에 가져오기</a>
<div id="sysdate"></div>
</body>
</html>
<jsp:include page="/WEB-INF/views/common/footer.jsp" flush="false" />