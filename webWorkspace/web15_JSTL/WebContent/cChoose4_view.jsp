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
<!-- test라는 속성 뒤에 조건이 나옴 -->
<c:choose>
	<c:when test="${param.num1=='1'}">
		안녕하세요... 반갑습니다...
	</c:when>
	<c:when test="${param.num1=='2'}">
		처음 뵙겠습니다. 반갑습니다...
	</c:when>
	<c:otherwise>
		모르는 사람입니다..
	</c:otherwise>
</c:choose>
</body>
</html>