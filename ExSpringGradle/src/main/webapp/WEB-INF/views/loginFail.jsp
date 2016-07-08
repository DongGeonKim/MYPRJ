<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>loginFail</title>
</head>
<body>
<h1>로그인 실패</h1>
<h1>이유 : <%=request.getAttribute("errMsg") %></h1>
<a href="/login">로그인페이지 이동</a>
</body>
</html>