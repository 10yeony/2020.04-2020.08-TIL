<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function(){
		$('#save').click(function(){
			var key = '${item.itemNumber}';
			var url = '${item.url}';
			var name = '${item.name}';
			var price = '${item.price}';
			var amount = 1;
			if(localStorage.getItem(key)!=null){
				var data = localStorage.getItem(key).split("#");
				amount = data[3];
				alert("이미 저장된 품목입니다.");
			}else{
				alert("장바구니에 성공적으로 저장되었습니다.");
			} 
			var value = url+"#"+name+"#"+price+"#"+amount;
			localStorage.setItem(key, value);
			
		});//click(#save)
		
		$('#check').click(function(){
			location.href="cart.jsp";
		});
	});//ready
</script>
</head>
<body>
<h1 align="center"><b>${item.name} 의 정보</b></h1>
<table align="center" width="600">
	<tr>
		<td align="right">조회수 : ${item.count} &nbsp;&nbsp;&nbsp;&nbsp;
			<button id="save">장바구니 담기</button>&nbsp;&nbsp; <button id="check">장바구니 확인</button>
		</td>
	</tr>
</table>
<table align="center" width="600">
	<tr>
		<td rowspan="3"><img src="${item.url}"></td>
		<td>종류 : ${item.name}</td>
	</tr>
	<tr>
		<td>가격 : ${item.price}</td>
	</tr>
	<tr>
		<td>설명 : ${item.description}</td>
	</tr>
	<tr>
		<td colspan="2" align="center"><a href="itemList.do">상품 목록보기</a></td>
	</tr>
</table>
</body>
</html>