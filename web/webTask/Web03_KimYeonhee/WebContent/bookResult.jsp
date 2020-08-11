<%@page import="servlet.model.Book"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<!-- 
å���� : request.getParameter("title")
-->
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
			<td class="left">å����</td>
			<td><% Book bk = new Book(); bk = (Book)request.getAttribute("bk"); %><%= bk.getTitle()%></td>
		</tr>
		<tr>
			<td class="left">������ȣ</td>
			<td><%String num = bk.getNum()[0]+"-"+bk.getNum()[1]+"-"+bk.getNum()[2];%><%=num %></td>
		</tr>
		<tr>
			<td class="left">��������</td>
			<td><%= bk.getKind()%></td>
		</tr>
		<tr>
			<td class="left">������</td>
			<td><%= bk.getDate() %></td>
		</tr>
	</table>
</section>
<footer><a href="Book.html">�߰����</a> <a href="#">�������</a></footer>
</body>
</html>