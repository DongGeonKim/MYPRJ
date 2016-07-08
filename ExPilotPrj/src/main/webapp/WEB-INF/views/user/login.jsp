<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="/WEB-INF/views/common/header.jsp" flush="false" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>로그인</title>

</head>
<body>
<h1>로그인</h1>
	<form action="/j_spring_security_check" method="POST">
        ID : <input type="text" name="id" size="20" maxlength="50" value="test"/><br />
        PW : <input type="text" name="pw" size="20" value="test"/><br />
        <input type="submit" value="Login" />
    </form>
<br/><br/>
<!-- <h1>회원가입</h1>
	<form action="/registProcess" method="post">
		ID : <input type="text" name="id" id="id" />
		PW : <input type="text" name="password" id="password" />
		이름 : <input type="text" name="name" id="name" />
		<input type="submit" value="회원가입">
	</form> -->
</body>
</html>
<jsp:include page="/WEB-INF/views/common/footer.jsp" flush="false" />