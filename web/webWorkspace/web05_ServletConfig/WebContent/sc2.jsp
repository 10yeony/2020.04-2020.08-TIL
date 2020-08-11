<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body bgcolor=lightblue>
<h3>ServletConfigTest2...</h3>
<b>Name :: </b>
<%= request.getParameter("nm") %>
<b>Count :: </b>
<%= request.getParameter("cnt") %>
</body>
</html>