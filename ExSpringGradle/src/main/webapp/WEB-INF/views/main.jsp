<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page import="org.springframework.security.core.GrantedAuthority"%>
<%@ page import="com.ex.customer.dto.CustomUser"%>
<%@ page import="org.springframework.security.core.context.SecurityContextImpl"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="org.springframework.security.core.userdetails.UserDetails"%>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
/* 세션 정보 */
/* Enumeration e = session.getAttributeNames();
while (e.hasMoreElements()) {
  String name = (String) e.nextElement();
  System.out.println(name + ": " + session.getAttribute(name) + "<BR>");
}
System.out.println(session.getId());
SecurityContextImpl sci = (SecurityContextImpl)session.getAttribute("SPRING_SECURITY_CONTEXT");
if (sci != null) {
	CustomUser cud = (CustomUser) sci.getAuthentication().getPrincipal();
	for (GrantedAuthority a : cud.getAuthorities()) {
		System.out.print(a.getAuthority() + "\t");
	}
	System.out.println();
    System.out.println("username : " + cud.getUsername() + " | password : " + cud.getPassword() + " | userText : " + cud.getUserText());
} */
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>main</title>
<link href="/resources/css/jquery/jquery-ui-1.11.4.min.css" rel="stylesheet">
<script src="/resources/js/jquery/jquery-2.1.4.min.js"></script>
<script src="/resources/js/jquery/jquery.form.min.js"></script>
<script src="/resources/js/jquery/jquery-ui-1.11.4.min.js"></script>
<style type="text/css">
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
</style>
<script type="text/javascript">
var loadingTag = '<div class="loadingDiv"><img class="loadingImg" alt="loading" src="/resources/image/loader.gif"/></div>';
var uploadProgressBarTag = '<div class="loadingDiv"><div class="loadingImg" style="width: 30%; margin: auto;" id="progressbar"></div></div>';
var uploadLoading;
jQuery(function($) {	
	uploadLoading = $(uploadProgressBarTag).appendTo("body").hide();
	
	var loading = $(loadingTag).appendTo("body").hide();
	$(window).ajaxStart(function(handler) {
		/* for(var name in handler){
            $("#divLog").append("<p>name : " + name + " | " + handler[name]+"</p>");
        } */
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
	//alert("ready...");
	
	/* FileUpload(jquery form plugin 을 이용하는 방법.)
	    - 페이지가 로딩될 때, 해당 form이 ajax로 전송될 수 있도록 하기 위해 다음과 같이 ajaxForm()을 실행한다. */
	$("#uploadForm").ajaxForm();
});

function getSysdate(){
	//var url = "/resources/txt/demo_test.txt";
	var url = "/test.json";
	
	$.ajax({
			url : url,
			success : function(data) {
				/* for(var name in data){
                    alert("name : " + name + " | " + data[name]);
                } */
				$("#result").text(data.value);
			}
		});
}

function uploadFile(){
	//$("#uploadForm").submit();
	
	/* FormData 를 이용하는 방법 (익스플로러 10 이상만 가능) START
	
	var form = $("#uploadForm");
	var formData = new FormData();
	formData.append("name", "formDataFileUpload");
	formData.append("file", $("input[name = file]")[0].files[0]);
	formData.append("file", $("input[name = file]")[1].files[0]);
	formData.append("file", $("input[name = file]")[2].files[0]);
	
	$.ajax({
	    url: "/uploadFile",
	    type: 'POST',
	    data: formData,
	    //dataType:'json',
	    async: false,
	    cache: false,
	    contentType: false, 
	    processData: false, 
	    success: function (returndata) {
	      alert(returndata);
	    },
	    error:function(request,status,error){
	        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	    }
	});
	FormData 를 이용하는 방법 (익스플로러 10 이상만 가능) END */
	
	/* jquery form plugin 을 이용하는 방법 START */
	uploadLoading.show();
	var progressbarObj = $("#progressbar");
	progressbarObj.progressbar({
        value: 0, max:100
    });
	$("#uploadForm").ajaxSubmit({
		global : false,	/* ajaxStart, ajaxStop 을 실행하지 않는다. */
		uploadProgress : function(event, position, total, percent) {
			progressbarObj.progressbar( "value", percent );
		},
	    success: function(data) {
	      alert(data.result);
	      uploadLoading.hide();
	    },
	    error:function(request,status,error){
	    	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	    	uploadLoading.hide();
	    }
	  });
	
	/* jquery form plugin 을 이용하는 방법 END */
}
</script>
</head>
<body>

<h1>main.jsp</h1>
<form action="/j_spring_security_logout" method="POST">   
    <input type="submit" value="logout" />
</form>
<a href="/login.json">json</a>
<a href="/login.xml">xml</a>
<br/>
<h1>Ajax 테스트</h1>
<a href="javascript:getSysdate();">날짜 가져오기</a>
<div id="result"></div>
<br/>
<h1>파일업로드(업로드 % 나타내기)</h1>
<form id="uploadForm" action="/uploadFile" method="post" enctype="multipart/form-data">
	<input type="hidden" name="name" value="1212">
	<input type="file" name="file" onchange='javascript:$("#byte0Id").text(Math.ceil(this.files[0].size/1024) + "KB");'><span id="byte0Id"></span><br/>
	<input type="file" name="file" onchange='javascript:$("#byte1Id").text(Math.ceil(this.files[0].size/1024) + "KB");'><span id="byte1Id"></span><br/>
	<input type="file" name="file" onchange='javascript:$("#byte2Id").text(Math.ceil(this.files[0].size/1024) + "KB");'><span id="byte2Id"></span>
</form>
<a href="javascript:uploadFile();">업로드</a>

<br/>
<div id="divLog"></div>
<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_TELLER')">
<h3>ROLE_ADMIN, ROLE_TELLER</h3>
</sec:authorize>
<sec:authorize access="hasAnyRole('ROLE_MANAGER')">
<h3>ROLE_MANAGER</h3>
</sec:authorize>
<sec:authorize access="hasAnyRole('ROLE_TELLER')">
<h3>ROLE_TELLER</h3>
</sec:authorize>

</body>
</html>