$(function(){
	//1. p태그가 몇개인지 alert창으로 확인...
	//alert($('p').length);
	
	//2. 2번째 p태그를 firstP라는 변수에 할당
	var firstP = $('p:eq(1)');
	//alert(firstP.html()); 
	//html에 있는 내용 찍어보려면 html(), text() 사용
	
	//3. class가 more인 a 태그를 클릭하면...
	//slideToggle() => 감지해서 꺼지면 켜고, 켜지면 끄는 함수.
	$('a.more').click(function(){
		if(firstP.is(':hidden')){
			//안보인다면 (선택자가 안 보인다면)... is() 함수
			//firstP.show(); //이거 써도 됨
			firstP.slideToggle('slow'); //알아서 보이게 해줌
			$(this).html('read less'); 
		}else{//보인다면
			//firstP.hide(); //이거 써도 됨
			//근데 slideToggle()은 알아서 작동함
			firstP.slideToggle('slow'); //알아서 안 보이게 해줌
			$(this).html('read more');
		}
	});//click
	
	//4.
	var speech = $('div.speech');
	var defaultSize = speech.css('fontSize');
	//alert(defaultSize); //현재 폰트 19.2px
	
	var num = parseInt(defaultSize, 10);
	//10 단위로 끊는다...
	//alert(num); //19
	
	$('#switcher>button').click(function(){
		switch(this.id){//해당되는 버튼의 id
		case 'switcher-large':
			num += 5;
			break;
		case 'switcher-small':
			num -=5;
			break;
		default:
			num = parseInt(defaultSize, 10); 
			break;
		}
		
		//반드시 animate() 적용해줘야 한다...
		speech.animate({fontSize:num+'px'}, 'slow');
	});
});