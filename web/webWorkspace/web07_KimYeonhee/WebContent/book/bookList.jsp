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
<script src="http://code.jquery.com/jquery-3.1.1.js"></script>
<script>
	$(function(){
		$('a').hover(function(){
			var isbn = $(this).parent().siblings('td:eq(0)').text();
			$.ajax({
				type:'post',
				url:'DS?command=findDesc',
				data:'isbn='+isbn,
				
				success:function(data){
					$('#resultView').html(data);
				}
			});//ajax
		},function(){
			$('#resultView').html("");
		});//hover
	});//ready
</script>
<style>
	div{
		width: 80%;
		margin: 0 auto;
	}
	
	div #search{
		float: right;
	}
	
	div table{
		width: 100%;
	}
	table th{
		border: 1px solid gray;
		background: lightgrey;
		font-weight: normal;
		height: 40px;
	}
	table td{
		border: 1px solid gray;
		height: 40px;
	}
	#resultView{
		text-align: center;
		color: red;
		font-weight: bold;
	}
</style>
</head>
<body>
<h1 style="text-align: center">도서 목록 화면</h1>
<div>
	<form action="DS" method="post">
	<p id="search">
		<input type="hidden" name="command" value="searchBook">
		<select name="option">
			<option>전체</option>
			<option>도서명</option>
			<option>출판사</option>
			<option>가격</option>
			</select>
		<input type="text" name="content">
		<input type="submit" value="검색">
	</p>
	<table>
		<tr>
			<th>도서번호</th>
			<th>도서명</th>
			<th>도서분류</th>
			<th>저자</th>
		</tr>
		<c:forEach items="${list}" var="vo">
		<tr>
			<td style="width: 20%">${vo.isbn}</td>
			<td style="width: 50%"><a href="#">${vo.title}</a></td>
			<td style="width: 15%">${vo.catalogue}</td>
			<td style="width: 15%">${vo.author}</td>
		</tr>
		</c:forEach>
	</table>
	</form>
</div>
<p id="resultView"></p>
<p align="center"><a href="book/Book.jsp">도서 등록</a> <a href="intro.html">메인페이지</a></p>
</body>
</html>