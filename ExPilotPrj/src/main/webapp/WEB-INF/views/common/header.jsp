<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="org.springframework.security.core.context.SecurityContextImpl"%>
<%@ page import="com.global.bsg.common.session.SessionUserInfo"%>
<%@page import="org.springframework.security.core.GrantedAuthority"%>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<%
SecurityContextImpl sci = (SecurityContextImpl)session.getAttribute("SPRING_SECURITY_CONTEXT");
SessionUserInfo userInfo = null;
if(sci != null){
	userInfo = (SessionUserInfo) sci.getAuthentication().getPrincipal();
	for (GrantedAuthority grantedAuthority : userInfo.getAuthorities()) {
		System.out.println("로그인 사용자 권한 : " + grantedAuthority.getAuthority());
	}
}
%>
<link href="/resources/css/jquery/jquery-ui-1.11.4.min.css" rel="stylesheet">
<script src="/resources/js/jquery/jquery-1.11.3.min.js"></script>
<script src="/resources/js/jquery/jquery.form-3.51.0.min.js"></script>
<script src="/resources/js/jquery/jquery-ui-1.11.4.min.js"></script>
<style type="text/css">
div.loadingDiv {
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background-color: gray;
	opacity: 0.2;
	filter: alpha(opacity=20);
	text-align: center;	
	
}
div.loadingDiv .loadingImg {
	position: relative;
	top: 50%;
	transform: translateY(-100%);
}
</style>
<script type="text/javascript">

</script>
<%
if(userInfo != null){
%>
	<h4><%=userInfo.getUserName()%> 님 로그인</h4>
	<form action="/j_spring_security_logout" method="POST">   
	    <input type="submit" value="logout" />
	</form>
<%
}
%>