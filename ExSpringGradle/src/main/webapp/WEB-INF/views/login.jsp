<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>login</title>
</head>
<body>
<h1>login.jsp</h1>
<h1>�α���</h1>
	<form action="/j_spring_security_check" method="POST">
        ID : <input type="text" name="username" size="20" maxlength="50" value="12"/><br />
        Password : <input type="text" name="password" size="20" value="12"/><br />
        <input type="submit" value="Login" />
    </form>
<br/><br/>
<h1>ȸ������</h1>
	<form action="/registProcess" method="post">
		ID : <input type="text" name="id" id="id" />
		PW : <input type="text" name="password" id="password" />
		�̸� : <input type="text" name="name" id="name" />
		<input type="submit" value="ȸ������">
	</form>
</body>
</html>