<%-- �̷� �ּ��� JSP �ּ���.
1) ���þ� <%@ %> : �����̳ʿ��� �˷��� ����...����
    �Ʒ��� �ִ� import ���� �� ���þ�. ���þ�� ����ο� ���´�.
2) ��Ŭ��Ʋ�� <% %> : �ڹ��ڵ�� �� �ȿ�...����
3) ��¹� <%= %> : ����Ϸ��� ����...����
 --%>
 <%--
 JSP �ּ��� HTML �ּ��� ������ : 
 �ҽ������ ���� �� JSP �ּ��� ������ ����.
 
 ��ǰ ��÷ ��ȣ�� �ڹٽ�ũ��Ʈ�� �˰��� ������ �ϴµ� 
 �����ڰ� ���α׷� ¥�ٰ� �ٽ����� ��ȣ�� ���� �ּ����� ����. �ƴϸ� JSP �ּ����� ��.
 ��Ŀ�� �ּ����� ����Ǵ� ���� ������ ��ŷ�� �ϱ⵵ ��.
 ���� ���� ��� �Ǹ� ��Ŀ�� �����ϴ� ���, ���α׷� ���������� ���ϰ� ¥�� ����� �����µ�
 �� �� �ϳ��� �ּ� �ִ� ���... JSP �ּ����� �ϴ� �� ����.
  --%>
<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- % % :: Scriptlet Element :: ������, �ٽ� ���� �ڹ� �ڵ�� �� �� �ȿ� ����ִ´� -->
<%
	MemberVO vo = (MemberVO)application.getAttribute("vo");
%>
<!-- ���尴ü�� �� �ҹ��� -->
<!-- JSP���� application�� Servlet������ ServletContext�� ����. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>ȸ������ ������ ����մϴ�.</h2>
<!-- %= % :: ��¹� (��Ȯ���� Express Element) -->
<li>����� �̸��� <%= vo.getName() %></li>
<li>����� ���̴� <%= vo.getAge() %></li>
<li>����� �ּҴ� <%= vo.getAddr() %></li>
</body>
</html>