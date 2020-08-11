<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	var xhr;
	var id;
	function startRequest(){
		id = document.getElementById("memberId").value;
		xhr = new XMLHttpRequest;
		xhr.onreadystatechange = callback;
		xhr.open("get", "find.do?id="+id);
		xhr.send(null);
	}
	
	function callback(){
		if(xhr.readyState==4){
			if(xhr.status==200){
				document.getElementById("resultView").innerHTML = 
					"<font color=green size=4>"+xhr.responseText+"</font>";
			}
		}
	}
</script>
</head>
<body>
<h2 align="center">ID LIST INFORMATION...</h2>
<h3 align="center">list에서 특정 아이디를 선택해주세요...</h3>
<select id="memberId" onchange="startRequest()">
	<option value="">==id choice==</option>
	<c:forEach items="${list}" var="member">
		<option>${member.id}</option>
	</c:forEach>
</select>
<span id="resultView"></span>
</body>
</html>