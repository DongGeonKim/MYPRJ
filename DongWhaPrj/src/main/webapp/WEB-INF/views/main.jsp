<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>MAIN</title>
<jsp:include page="/WEB-INF/views/common/header.jsp" flush="false" />
<script type="text/javascript">
$(document).ready(function() {
	
});

function selectSysdate(){
	var url = "/selectSysdate.json";
	
	$.ajax({
		type : "post",
		url : url,
		dataType : "json",
		success : function(data) {
			$("#sysdate").text(data.value);
		}
	});
}

function selectDbTestList(){
	var url = "/selectDbTestList.ajax";	
	$.ajax({
		type : "post",
		url : url,
		dataType : "html",
		success : function(data) {
			$("#dbResult").html(data);
		}
	});
}

function selectSapTestList(){
	var url = "/selectSapTestList.ajax";	
	$.ajax({
		type : "post",
		url : url,
		dataType : "html",
		success : function(data) {
			$("#sapResult").html(data);
		},
		error: function (request, status, error) {
	        alert(status+":"+ error);
	    }
	});
}
</script>
</head>
<body>
	<h3>���� ������...</h3>
	<a href="javascript:void(0);" onclick="javascript:selectSysdate();">���� ��¥ 2�� �Ŀ� ��������</a>
	<div id="sysdate"></div>
	<br/>
	
	<a href="javascript:void(0);" onclick="javascript:selectDbTestList();">DB ȣ�� ������ ��������</a>
	<div id="dbResult"></div>
	<br/>
	
	<a href="javascript:void(0);" onclick="javascript:selectSapTestList();">Sap ȣ�� ������ ��������</a>
	<div id="sapResult"></div>
	
</body>



<jsp:include page="/WEB-INF/views/common/footer.jsp" flush="false" />
</html>