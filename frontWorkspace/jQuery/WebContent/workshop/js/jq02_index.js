$(function(){
	//버튼을 클릭하면 해당되는 비디오가 나타남
	$('button').click(function(){
		$('video').attr('src', $(this).attr('name'));
	});
	
	//버튼을 클릭하면 로컬스토리지에 key와 value를 추가하고
	//key와 value를 합친 값이 alert창에 뜬다
	$('input[type=button]').click(function(){
		var key = $(this).attr('name'); //키
		var i = 0;
		$('input[type=button]').each(function(index, item){
			if($('input:eq('+index+')').attr('name')==key){
				i = index;
			}
		});
		
		var name = $('#productName>th:eq('+i+')').text(); //DVD제목
		var img = $('#productImg img:eq('+i+')').attr('src'); //파일 경로
		var price = $('input:eq('+i+')').attr('class'); //상품가격
		var value = name+','+img+','+price;
		localStorage.setItem(key, value);
		alert(key+':'+value);
	})
});