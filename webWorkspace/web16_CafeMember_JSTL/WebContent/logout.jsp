<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${vo!=null}">
		<% session.invalidate();%>
		<script>
			alert("로그아웃 하셨습니다");
			location.href="index.html";
		</script>
	</c:when>
	<c:otherwise>
		<b><a href="login.html">로그인부터</a></b>
	</c:otherwise>
</c:choose>
<%-- <%
	MemberVO vo = (MemberVO)session.getAttribute("vo");
	if(vo==null){
%>
	<b><a href="login.html">로그인부터</a></b>
<% 
	}else{
		session.invalidate();
	}
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
</html>