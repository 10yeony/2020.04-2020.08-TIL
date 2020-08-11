<!-- 
https://jqueryui.com/accordion/
여기에서 view source 눌러서 가져왔음
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1"> <!-- 모바일 반응형 -->
  <title>jQuery UI Accordion - Default functionality</title>
  <!-- 
  테마 바꾸겠다. base에서 sunny로
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
   -->
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/sunny/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script> <!-- 제이쿼리 CDN -->
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script> <!-- UI 자바스크립트 -->
  <!-- bs(부트스트랩) 라이브러리가 가장 나중에 와야 한다 -->
  <script>
  $(function() {
    $( "#accordion" ).accordion({
    	/* default가 fill로 맞춰져 있음. 이러면 지정된 높이만 됨. 
    	content 사이즈에 맞게 늘어나도록 적어준 것*/
    	heightStyle: "content", 
    	
    	//아래 2개 넣어주면 클릭하면 열리고 클릭하면 닫힘
    	active: false, 
    	collapsible: true
    });
    
    //h3를 클릭하면
    $("#accordion h3").click(function(){
    	var text = $(this).text(); //html() 써도 됨
    	//alert(text);
    	
    	//1. 비동기 통신 시작...
    	if(text=="IT Education Subject"){
    		$.ajax({
    			type:'post',
    			url:'front.do',
    			data:'command=subject',
    			
    			success:function(data){
    				$('#subject').html(data);
    			}//callback
    		});//ajax
    	}//if
    	else if(text=="Association Global IT Company"){
    		$.ajax({
    			type:'post',
    			url:'front.do',
    			data:'command=company',
    			
    			success:function(data){
    				$('#itcom').html(data);
    			}//callback
    		});//ajax
    	}//else if
    });//click
    
    $('#createSection').click(function(){
    	var footercontent = "<h3>How TO GET</h3><div>서울 서초동 459 엔코아 아카데미 남부터미널 777</div>";
    	
    	//버튼을 없앤다.
    	$(this).remove();
    	
    	//동적으로 아코디언을 생성하는 기능...append()
    	//동적으로 아코디언을 만들 때는 'destroy' 옵션으로 완벽하게 삭제를 한 후 다시 아코디언을 생성해야 한다.
    	$('#accordion').append(footercontent).accordion('destroy').accordion({
    		heightStyle: 'content'
    	});
    	
    });
  } );//ready
  </script>
</head>
<body>
 
<div id="accordion">
  <h3>Encore Academy Introduction</h3>
  <div>
	플레이데이터의 새로운 교육 프로그램 소개합니다.
  	아래 섹션에서 이수할 교육과목을 확인하시기 바랍니다.
  </div>
  <h3>IT Education Subject</h3>
  <div id="subject">
  </div>
  <h3>Association Global IT Company</h3>
  <div id="itcom">
  </div>
</div>
<hr>

<input type="button" value="Create Section Addition" id="createSection">
</body>
</html>