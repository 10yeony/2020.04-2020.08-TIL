<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>회원 정보를 확인하세요</h3>
<% MemberVO vo = (MemberVO)request.getAttribute("vo"); %>
ID : <%=vo.getId() %> <br/>
NAME : <%=vo.getName() %> <br/>
ADDRESS : <%= vo.getAddress() %>
</body>
</html>