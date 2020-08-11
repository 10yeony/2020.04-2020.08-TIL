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
<h1 align="center">Fruit Total List 1. </h1>
<table align="center">
	<tr>
		<c:forEach items="${list}"   var="item">
			<td>
			<a href="itemView.do?itemnumber=${item.itemNumber}"><img alt="" src="img/${item.url}" width="150" height="150" border="2"></a><br/>
				상품명 : ${item.name} <br/>
				가  격 : ${item.price}원
			</td>
		</c:forEach>
	</tr>
</table>
</body>
</html>













