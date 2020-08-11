<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log Out</title>
<script>
	function logoutpopup(){
		<% session.invalidate(); %>
		alert("로그아웃 되셨습니다.");
	}
</script>
</head>
<body onload="return logoutpopup()">
	<b>로그아웃 되셨습니다.</b><br/>
	<a href="intro.html">메인으로</a>
</body>
</html>