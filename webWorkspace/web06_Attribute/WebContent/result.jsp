<%-- 이런 주석이 JSP 주석임.
1) 지시어 <%@ %> : 컨테이너에게 알려줄 내용...지정
    아래에 있는 import 같은 게 지시어. 지시어는 선언부에 나온다.
2) 스클릿틀릿 <% %> : 자바코드는 이 안에...지정
3) 출력문 <%= %> : 출력하려는 내용...지정
 --%>
 <%--
 JSP 주석과 HTML 주석의 차이점 : 
 소스보기로 봤을 때 JSP 주석은 보이지 않음.
 
 경품 추첨 번호를 자바스크립트로 알고리즘 돌려서 하는데 
 개발자가 프로그램 짜다가 핵심적인 번호를 보통 주석으로 넣음. 아니면 JSP 주석으로 함.
 해커가 주석에서 노출되는 정보 가지고 해킹을 하기도 함.
 보안 수업 듣게 되면 해커가 공격하는 방법, 프로그램 보안적으로 강하게 짜는 방법이 나오는데
 그 중 하나가 주석 넣는 방법... JSP 주석으로 하는 게 맞음.
  --%>
<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- % % :: Scriptlet Element :: 로직은, 다시 말해 자바 코드는 다 이 안에 집어넣는다 -->
<%
	MemberVO vo = (MemberVO)application.getAttribute("vo");
%>
<!-- 내장객체는 다 소문자 -->
<!-- JSP에서 application은 Servlet에서의 ServletContext와 같다. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>회원님의 정보를 출력합니다.</h2>
<!-- %= % :: 출력문 (정확히는 Express Element) -->
<li>당신의 이름은 <%= vo.getName() %></li>
<li>당신의 나이는 <%= vo.getAge() %></li>
<li>당신의 주소는 <%= vo.getAddr() %></li>
</body>
</html>