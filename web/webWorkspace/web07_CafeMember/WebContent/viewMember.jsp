<%@page import="servlet.model.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<b><%=request.getParameter("name") %>님이 방금전 회원가입하셨습니다.</b><p>
<hr>
<h2>전체 Cafe 명단 리스트</h2>
<table border="2">
<%
	//out.println(application); //ServletCotext 주소 나옴.
	//List<MemberVO> list = (List)application.getAttribute("list");
	List<MemberVO> list = (List)request.getAttribute("list");
	for(int i=0; i<list.size(); i++){
%>
	<tr>
		<td><%= i+1 %></td>
		<td><%= list.get(i).getName() %></td>
		<td><%= list.get(i).getAge() %></td>
		<td><%= list.get(i).getAddr() %></td>
	</tr>
<%		
	}
%>
</table>
</body>
</html>