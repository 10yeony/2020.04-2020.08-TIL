<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 아래 있는 건 변수 아님!! EL은 변수 아니라고 했음. 값을 문자로 매핑한 것. -->
<!-- 바인딩된 객체 이름이 var고, value가 객체임. -->
<!-- 
scope="request"를 적어줘야 SurvletRequest에 바인딩됨.
세션은 scope="session"
서블릿컨텍스트는 scope="application"
 -->
<c:set var="CODE" value="1004" scope="request"/>
<c:set var="NAME" value="encore" scope="request"/>
<c:set var="PRICE" value="22000" scope="request"/>

<jsp:forward page="cset2_view.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
상품코드 : ${CODE}
</body>
</html>