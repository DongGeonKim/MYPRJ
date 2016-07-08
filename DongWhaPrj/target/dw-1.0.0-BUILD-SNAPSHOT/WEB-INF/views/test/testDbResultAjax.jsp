<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="com.mh.dw.test.dto.DbTestDto"%>
<%@ page import="java.util.List"%>
<%
if(request.getAttribute("errMsg") == null){
	List<DbTestDto> list = (List<DbTestDto>)request.getAttribute("list");
%>
	<table border="1">
		<tr>
			<th>SEQ</th>
			<th>TEXT</th>
		</tr>
		<%
		if(list != null && !list.isEmpty()){
			for(DbTestDto d : list){
		%>
				<tr>
					<td><%=d.getSeq()%></td>
					<td><%=d.getTestText()%></td>
				</tr>
				<tr>
			</tr>
		<%
			}
		}else{
		%>
			<tr>
				<td colspan="2" align="center">데이터가 없습니다.</td>
			</tr>
		<%
		}
		%>
	</table>
<%
}else{
%>
<script type="text/javascript">
alert("에러발생\n["+"<%=request.getAttribute("errMsg")%>"+"]");
</script>
<%
}
%>