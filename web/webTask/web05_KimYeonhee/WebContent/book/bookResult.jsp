<%@page import="servlet.model.BookVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	header{
		width: 70%;
		margin: 0 auto;
		box-sizing: border-box;
		padding: 30px;
		text-align: center;
		font-size: 28px;
		font-weight: bold;
	}
	
	nav{
		width: 70%;
		margin: 0 auto;
		box-sizing: border-box;
		margin-bottom: 30px;
		text-align: center;
		font-size: 22px;
		font-weight: bold;
	}
	
	table{
		width: 70%;
		border-collapse: collapse;
		margin: 0 auto;
	}
	table td{
		border: 1px solid #EAEAEA;
		font-size: 18px;
	}
	table td.left{
		width: 20%;
		text-align: center;
		font-weight: bold;
		background: #E4F7BA;
		padding: 10px 0 10px 0;
	}
	
	footer{
		width: 70%;
		margin: 0 auto;
		text-align: center;
		background: #EAEAEA;
		padding: 10px 0 10px 0;
		margin-top: 30px;
	}
</style>
</head>
<body>
<header>��� ������</header>
<nav>���������� ���� �Ǿ����ϴ�.</nav>
<section>
	<table>
		<tr>
			<th>������ȣ</th>
			<th>��������</th>
			<th>��������</th>
			<th>����</th>
			<th>����</th>
		</tr>
		<tr>
			<td>${param.isbn1}-${param.isbn2}-${param.isbn3}</td>
			<td>${param.title}</td>
			<td>${param.catalogue}</td>
			<td>${param.author}</td>
			<td>${param.price}${param.currency}</td>
		</tr>
	</table>
</section>
<footer><a href="Book.html">�߰����</a> <a href="SA">�������</a></footer>
</body>
</html>