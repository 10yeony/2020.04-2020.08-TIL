<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Form 값을 EL로 받아오기.</h2>
<form action="EL2_view.jsp" method="post">

ID <input type="text" name="userId"><br/><br/>

<strong>좋아하는 메뉴.....</strong><p>
<input type="checkbox" name="menu" value="spagetti">spagetti
<input type="checkbox" name="menu" value="pizza">pizza
<input type="checkbox" name="menu" value="hamburger">hamburger
<input type="checkbox" name="menu" value="coke">coke
<br/><br/>

<input type="submit" value="DataSend">
</form>
</body>
</html>