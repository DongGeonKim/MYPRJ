<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.util.Map"%>
<%
if(request.getAttribute("errMsg") == null){
Map<String, Object> list = (Map<String, Object>)request.getAttribute("list");
%>
<%=list%>
<%
}else{
%>
<script type="text/javascript">
alert("�����߻�\n["+"<%=request.getAttribute("errMsg")%>"+"]");
</script>
<%
}
%>