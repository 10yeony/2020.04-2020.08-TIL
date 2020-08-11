$(function(){
	var totalPrice = 0;
	for(var i=0; i<localStorage.length; i++){
		key = localStorage.key(i); //상품번호
		var value = localStorage[key]; 
		var totalArr = value.split(","); //상품이름, 이미지, 가격순
		var name = totalArr[0]; //상품이름
		var image = totalArr[1]; //이미지
		var price = totalArr[2]; //가격순
		totalPrice += parseInt(price); //주문 가격
		
		//HTML 기존 <tr> 태그 뒤에 붙이기
		var trNum = $('tr').length-1; //기존의 <tr>태그 가장 마지막 인덱스
		//alert($('tr:eq('+trNum+')').html());
		var tag = '<tr><td><p><img src='+image+'></p></td><td><p id="key">'+key+'</p></td><td><p>'+name+'</p></td><td><p id="price">'+price+'</p></td><td><p><button type=button> 삭제 </button></p></td></tr>';
		$('tr:eq('+trNum+')').after(tag);
	}
	//주문 가격 HTML 문서 안에 넣기
	$('#bottom-line p').text("주문 가격:"+totalPrice);
	
	$('button').click(function(){ 
		var key = $($(this).parent().parent().parent().find('p:eq(1)')).text();
		var price = $($(this).parent().parent().parent().find('#price')).text();
		localStorage.removeItem(key);
		$(this).parent().parent().parent().html('');
		totalPrice -= parseInt(price);
		$('#bottom-line p').text("주문 가격:"+totalPrice);
	});
});