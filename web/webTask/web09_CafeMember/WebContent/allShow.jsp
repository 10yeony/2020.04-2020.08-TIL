<%@page import="java.util.ArrayList"%>
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
<h3>전체 회원 보기</h3>
<% ArrayList<MemberVO> list = (ArrayList<MemberVO>)request.getAttribute("list");
String id = ""; String name = ""; String address = "";%>
<table>
	<tr>
		<th>ID</th>
		<th>NAME</th>
		<th>ADDRESS</th>
	</tr>
	<% for(MemberVO m : list){
		id = m.getId();
		name = m.getName();
		address = m.getAddress();%>
	<tr>
		<td><%= id%></td>
		<td><%= name%></td>
		<td><%= address%></td>
	</tr>
	<%} %>
</table>
</body>
</html>