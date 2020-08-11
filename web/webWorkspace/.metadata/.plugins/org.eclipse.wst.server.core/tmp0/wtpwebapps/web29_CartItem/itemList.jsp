<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script> 
<script>
	/* <a> 태그에서 하는 게 더 간단함
	$(function(){
		$('img').click(function(){
			var id = $(this).siblings('span').text();
			location.href="itemDetail.do?id="+id;
		});//click
	});//ready 
	*/
</script>
</head>
<body>
<h1 align="center">Fruit Total List 1.</h1>
<table align="center">
	<tr>
		<c:forEach items="${list}" var="item">
		<td>
			<!-- <span style="display: none">${item.itemNumber}</span> -->
			<a href="itemDetail.do?id=${item.itemNumber}"><img src="${item.url}" border=2 width=150 height=150></a><br/>
			상품명 : ${item.name}<br/>
			가  격 : ${item.price}
		</td>
		</c:forEach>
	</tr>
</table>

<!-- 오늘 본 상품정보를 이곳에다가 출력... -->
<c:if test="${!empty fruits}">
	<h2 align="center"><font color="purple">오늘 본 상품들</font></h2>
<table align="center" bgcolor="lightgray">
	<tr>
		<td>
			<c:forEach items="${fruits}" var="fruit">
				<img src="${fruit}" width="100" height="100">
			</c:forEach>
		</td>
	</tr>
</table>
</c:if>
</body>
</html>