<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--
1. ResourceFactory를 WAS에 Binding:제품을 이름으로 등록... MEta-INF/Context.xml
   (코드로 하는 게 아니라 Context.xml로 한다)
2. ResourceFactory(DataSource)를 하나 받아온다.
  (커넥션을 받아온 게 아니라 커넥션을 가지고 있는 데이터소스를 받음)
- 한번 만들고 계속 해서 씁니다.
-->
<%
	Connection conn=null;
	Context ic = new InitialContext();
	DataSource ds = (DataSource)ic.lookup("java:comp/env/jdbc/mysql");//문법임 java:comp/env/
	out.println("DataSource......Lookup....");
	conn=ds.getConnection();
	out.println("Connection...Rent....OK");
%>
</body>
</html>