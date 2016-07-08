<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>index.jsp</title>
<style type="text/css">
header, section, article, footer{
	display: block;
}
</style>

<script type="text/javascript">
function doA(){
	alert('doA');
	form1.action = "/success.jsp";
	
	form1.submit();
}
</script>
</head>
<body>
index.jsp
<header>
	header
</header>
<section>
	<article>article1</article>
	<article>article2</article>
</section>
<section>
	<article>
	<form id="form1" onsubmit="javascript:return doA();" >
		<input type="text" name="name1" list="name1">
		<datalist id="name1">
			<option value="a1">1</option>
			<option value="a2">2</option>
			<option value="a3">3</option>
		</datalist>
		<input type="text" name="name2">
		
		<input type="submit">
	</form>
	</article>
</section>
<footer>
	footer
</footer>
</body>
</html>