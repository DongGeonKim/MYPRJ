<%@page import="java.net.URL"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URLConnection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
out.clear();
out = pageContext.pushBody();
String strUrl = request.getParameter("imgUrl");
byte[] buf = null;
URLConnection uCon = null;
InputStream is = null;
OutputStream os = null;	/** 추가 */

	System.out.println("-------Download Start------");
	URL Url;
	int nByteRead;
	int nByteWritten = 0;

	Url = new URL(strUrl);

	uCon = Url.openConnection();
	is = uCon.getInputStream();
	
	os = response.getOutputStream();
	
	buf = new byte[1024];
	while ((nByteRead = is.read(buf)) != -1) {
		
		
		nByteWritten += nByteRead;
		os.write(buf, 0, nByteRead);	/** 추가 */
	}
	
	os.flush();
	os.close();
	
%>