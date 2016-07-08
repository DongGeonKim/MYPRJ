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
<!--[if (IE 9)]>
<script src="1.js"></script>
<![endif]-->
<!--[if lt IE 9]>
<script src="2.js"></script>
<![endif] -->
<script type="text/javascript">
/**
 * HTML5 input tag의 기본 validation 체크
 */ 
var HTML5InputDefaultValid = function(form){
	var valid = form.checkValidity();
	if(!valid){
		var divChild = form.getElementsByTagName("input");
		var submitName = "";
		for (var i = 0; i < divChild.length; i++) {
			if(divChild[i].type == "submit"){
				submitName = divChild[i].name;
				divChild[i].click();
			}
		}
		if(submitName == ""){
			var newSubmitElement = document.createElement("input");         
			newSubmitElement.name = "customSubmitButton";
			newSubmitElement.type = "submit";
			newSubmitElement.style.display = "none";
		    form.appendChild(newSubmitElement);
			form.customSubmitButton.click();
			form.removeChild(newSubmitElement);	
		}
	}
	return valid;
}

function doA(){
	var form1 = document.getElementById("form1");
	
	/**
	 * HTML5 input tag의 기본 validation 체크
	 */
	if(!HTML5InputDefaultValid(form1)){
		return;	
	}
	
	form1.action = "/vidiotest1.jsp";
	form1.submit();
	
	/* if(!form1.checkValidity()){
		form1.submitButton.click();
		return;
	}
	form1.action = "/vidiotest1.jsp";
	form1.submit(); */
	
}

function doB(){
	alert('doB');
	form1.action = "/vidiotest1.jsp";
	
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
	<form id="form1" onsubmit="javascript:return doB();">
		<input type="text" name="name1" required="required">
		<input type="text" name="name2" required="required">
		<input type="email" name="email" required="required" placeholder="입력...">
		<input type="datetime" name="num"  >
		<input type="datetime-local" name="num1"  >
		<!-- <a href="javascript:void(0);" onclick="javascript:doA();">aaaaaaaaaaaa</a> -->
		<input type="submit">
	</form>
	</article>
</section>
<footer>
	footer
</footer>
</body>
</html>