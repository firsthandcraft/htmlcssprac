<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%--jsp 주석문입니다. <% %>
여러줄을 입력할 수 있습니다. --%>
<!-- html 주석문입니다. -->
<!-- <%%> -->
<%
/*
자바 여러줄 주석문
*/
for(int i = 1; i <= 5; i++){ // java 한줄 주석문입니다.
%>
<H<%=i %>> 아름다운 한글 </H<%=i %>>
<%
}
%>
</body>
</html>