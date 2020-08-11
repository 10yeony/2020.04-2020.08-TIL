<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
EL ::
///////////////////////////
Attribute에 바인딩된 값을 찾아오는 로직을 태그로 바꾼 기술
변수명이 아니라 객체를 바인딩한 이름이 사용된다.
${이름} == attribute.getAttribute("이름")
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Attribute에 바인딩된 값을 받아오겠습니다...</h2>
<b>1~50까지의 합산 결과 값 1) ::</b>
<%=request.getAttribute("RESULT") %>
<hr><p/>

<b>1~50까지의 합산 결과 값 2) ::</b><br/>
<!-- RESULT는 변수명이 아니라 Attribute에 바인딩된 이름 -->
${requestScope.RESULT}<br/>
${sessionScope.RESULT}<br/>
${RESULT}<br/> <!-- 보통 이렇게만 쓴다. 
request에서 찾고 없으면 session에서 찾고 application에서 찾고 
그래도 없으면 NullPointer 에러 안 터지고  출력을 안 해버림. -->
${RESULT+1000000}<br/> <!-- 연산 가능 -->
${NAME}</body><!-- Null이라서 출력 안 됨. -->
</html>