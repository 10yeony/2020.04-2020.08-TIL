<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function closeWindow(result){
		//확인버튼 누르면 이곳으로 온다... 여기서 원래 회원가입(register.jsp)을 제어해야 한다.
		var of = window.opener.document.registerForm; //opener form
		if(result=='true'){//아이디 사용못한다면..
			of.id.value = "";
			of.id.focus();
		}else{//아이디 사용할 수 있다면
			of.password.focus();
			of.id.readOnly=true; //아이디를 수정 못하게 막음.
		}
		self.close(); //이 창을 끈다.
	}
</script>
</head>
<body bgcolor='orange'>
	<!-- c:set은 이 페이지에서 attribute처럼 사용.-->
	<c:set var="message" value="해당 ID를 사용할 수 없음"/>
	<c:if test="${!flag}">
		<c:set var="message" value="해당 ID를 사용할 수 있음"/>
	</c:if>
	${param.id}, ${message}<br/>
	<input type="button" value="확인" onclick="closeWindow('${flag}')">
</body>
</html>