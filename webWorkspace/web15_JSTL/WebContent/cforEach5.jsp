<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 1부터 10까지 돈다. -->
<!-- c:forEach var="cnt" begin="1" end="10" -->
<c:forEach var="cnt" begin="1" end="10" step="2">
	<font size="${cnt}">Hello~~~~~~!!JSTL!!!<br/></font>
</c:forEach>
</body>
</html>