<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	thead, tfoot { background: orange }
	th { border: 1px solid; font-weight: normal; }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
var totalPrice;//총가격
var amount; //수량
var key; //키
	
	$(function(){
		var price;
		refreshPage();
		
		$('.up').on('click', function(){ //올라가는 화살표 클릭시
			key = $(this).siblings('input[type=hidden]').val();
			amount = eval($(this).siblings('span').text());
			amount++;
			$(this).siblings('span').text(amount);
			totalPrice += eval($(this).parent().prev().text());
			$('#totalPrice').text(totalPrice);
			updateAmount();
		});
		
		$('.down').on('click', function(){ //내려가는 화살표 클릭시
			key = $(this).siblings('input[type=hidden]').val();
			amount = eval($(this).siblings('span').text());
			if(amount>1){
				amount--;
				$(this).siblings('span').text(amount);
				totalPrice -= eval($(this).parent().prev().text());
				$('#totalPrice').text(totalPrice);
				updateAmount();
			}
		});
		
		$('#delete').on('click', function(){//체크 후 삭제
			$('input[type=checkbox]:checked').each(function(){
				key = $(this).val();
				localStorage.removeItem(key); //로컬스토리지에서 삭제
				$(this).parents('#fruitItem').remove(); //화면에서 삭제
				totalPrice -= eval($(this).parent().siblings('th:eq(3)').text())
							* eval($(this).parent().siblings('th:eq(4)').text());
				$('#totalPrice').text(totalPrice);
			});
		});
		
	});//ready
	
	function refreshPage(){
		var html = '';
		var no = 1;
		totalPrice = 0;
		
		for(var key in localStorage){
			if(key=='length') break;
			var data = localStorage.getItem(key).split("#");
			html += '<tr id="fruitItem"><th>'+(no++)+'</th>';
			html += '<th><img src='+data[0]+' width=100 height=100></th>';
			html += '<th>'+data[1]+'</th>';
			html += '<th>'+data[2]+'</th>';
			html += '<th><img src=img/up.jpg class=up width=10 height=10><br>';
			html += '<input type="hidden" value='+key+'><span>'+data[3]+'</span><br>';
			html += '<img src=img/down.jpg class=down width=10 height=10></th>';
			html += '<th><input type=checkbox value='+key+'></th></tr>';
			totalPrice += eval(data[2]);
		}
		
		
		$('#fruitList').html(html);
		$('#totalPrice').html(totalPrice);
	}
	
	function updateAmount(){ //로컬 스토리지에 수량 업데이트
		var data = localStorage.getItem(key).split("#");
		var value = data[0] +"#"+ data[1] +"#"+ data[2] +"#"+ amount;
		localStorage.setItem(key, value);
	}
</script>
</head>
<body>
<h1 align="center">장바구니</h1>
<div align="right" width="80%"></div>
<table align="center" width="80%">
	<tr>
		<td align="right"><a href="itemList.do">쇼핑 계속하기</a></td>
	</tr>
</table>
<table align="center" width="80%">
	<thead>
		<tr>
			<th>번호</th>
			<th>상품이미지</th>
			<th>상품명</th>
			<th>상품가격</th>
			<th>수량</th>
			<th><button id="delete">삭제</button></th>
		</tr>
	</thead>
	<tbody id="fruitList"></tbody>
	<tfoot>
		<tr>
			<td colspan=6>
				<p align="right">
					<span style="font-size: 20px; color: lightgrey;">총 결제금액 : </span>
					<span id="totalPrice" style="font-size: 28px; color: black;"></span>
				</p>
			</td>
		</tr>
	<tfoot>
</table>
</body>
</html>