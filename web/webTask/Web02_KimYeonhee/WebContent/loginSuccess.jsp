<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그인 성공</title>
</head>
<body>
<div align="center">
<p><%= request.getParameter("id") %> 님이 로그인 되었습니다.!!!<p><br/><br/>
<p><a href="#">도서 등록</a></p>
<p><a href="intro.html">로그아웃</a></p>
</div>
</body>
</html>