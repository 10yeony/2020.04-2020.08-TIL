<%@page import="java.util.ArrayList"%>
<%@page import="servlet.model.BookVO"%>
<%@page import="servlet.model.BookDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{
		border-collapse: collapse;
	}
	table th, td{
		border: 1px solid gray;
	}
</style>
</head>
<body>
<table>
	<tr>
		<th>도서번호</th>
		<th>도서제목</th>
		<th>도서종류</th>
		<th>출판국가</th>
		<th>출판일</th>
		<th>출판사</th>
		<th>저자</th>
		<th>도서가격</th>
		<th>요약내용</th>
	</tr>
	<c:forEach items="${vo}" var="part">
	<tr>
		<td>${part.isbn}</td>
		<td>${part.title}</td>
		<td>${part.catalogue}</td>
		<td>${part.nation}</td>
		<td>${part.publishDate}</td>
		<td>${part.publisher}</td>
		<td>${part.author}</td>
		<td>${part.price}${part.currency}</td>
		<td>${part.description}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>