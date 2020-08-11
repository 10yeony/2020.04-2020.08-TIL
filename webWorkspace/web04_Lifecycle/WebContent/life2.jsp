<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body bgcolor='cyan'>
<h3>LifeCycle CallBack Method...</h3>
<b>Count :: </b>
<%= request.getParameter("cnt") %>
<!-- JSP 안에 출력할 때 %= 쓴다. -->

<!--  
문장이 끝나는 게 아니라 값을 받아오는 것이므로 %> 앞에 ; 쓰면 에러 난다.
-->
</body>
</html>