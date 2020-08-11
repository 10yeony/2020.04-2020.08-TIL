<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//서블릿으로 만들면 시간 걸려서 jsp로 예제 만들겠음. 참고.
	int sum = 0;
	for(int cnt=0; cnt<=50; cnt++)
		sum+=cnt;
	
	request.setAttribute("RESULT", new Integer(sum));
	session.setAttribute("RESULT", "세션");
	
	request.getRequestDispatcher("EL1_view.jsp").forward(request, response);
%>
</body>
</html>