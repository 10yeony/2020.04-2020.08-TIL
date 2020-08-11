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
<h2>+++++++++++++++++++++ 검색 결과 +++++++++++++++++++++++++</h2>
<table border="1">
	<tr>
		<th>ID</th>
		<th>NAME</th>
		<th>MAKER</th>
		<th>PRICE</th>
	</tr>
	<c:forEach items="${list}" var="vo">
		<tr>
 			<td>${vo.id}</td>
 			<td>${vo.name}</td>
 			<td>${vo.maker}</td>
 			<td>${vo.price}</td>
 		</tr>
	</c:forEach>
</table>
</body>
</html>