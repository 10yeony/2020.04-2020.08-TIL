<%@page import="servlet.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${rvo==null}">
	<script>
		alert("먼저 로그인 해주세요.");
		location.href="../intro.html";
	</script>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 등록 화면</title>
<style>
	header{
		background: #EAEAEA;
		width: 90%;
		margin: 0 auto;
		box-sizing: border-box;
		padding: 30px;
		text-align: center;
		font-size: 28px;
		font-weight: bold;
	}
	
	section{
		width: 90%;
		margin: 0 auto;
		padding-top: 20px;
		padding-bottom: 20px;
	}
	section table{
		width: 100%;
		border-collapse: collapse;
	}
	section table td{
		border: 1px solid #EAEAEA;
		padding: 0;		
	}
	section table span{
		display: inline-block;
		padding-top: 10px;
		padding-bottom: 10px;
	}
	
	footer{
		width: 90%;
		margin: 0 auto;
		text-align: center;
	}
	footer #bottom{
		background: #EAEAEA;
		padding: 20px 0 30px 0;
	}
	footer #copyright{
		color: #050099;
	}
</style>
</head>
<body>
<form action="../DS" method="post" onsubmit="return inputAlert()">
<input type="hidden" name="command" value="bookRegister">
<header>도서 등록 화면</header>
<section>
	<table>
		<tr>
			<td colspan="2" style="text-align: right;">
				<span><font color=orange size="0.1">■</font> 표시가 된 항목은 필수 입력 항목입니다.</span>
			</td>
		</tr>
		<tr>
			<td colspan="2" style="background: #EAEAEA; padding: 20px;">
			</td>
		</tr>
		<tr>
			<td>
				<span><font color=orange size="0.1">■</font> 도서번호</span>
			</td>
			<td>
				<input type="number" name="isbn1" id="isbn1"> - 
				<input type="number" name="isbn2" id="isbn2"> - 
				<input type="number" name="isbn3" id="isbn3">
			</td>
		</tr>
		<tr>
			<td>
				<span><font color=orange size="0.1">■</font> 도서제목</span>
			</td>
			<td>
				<input type="text" name="title" id="title">
			</td>
		</tr>
		<tr>
			<td>
				<span><font color=orange size="0.1">■</font> 도서종류</span>
			</td>
			<td>
				<select name=catalogue id="catalogue">
					<option value="">해당 항목을 선택하세요</option>
					<option>프로그래밍</option>
					<option>운영체제</option>
					<option>네트워크</option>
					<option>데이터베이스</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>
				<span><font color=#EAEAEA size="0.1">■</font> 출판국가</span>
			</td>
			<td>
				<input type="radio" name=nation value="국내도서" checked> 국내도서 
				<input type="radio" name=nation value="외국도서"> 외국도서
			</td>
		</tr>
		<tr>
			<td>
				<span><font color=#EAEAEA size="0.1">■</font> 출판일</span>
			</td>
			<td>
				<input type="date" name="publishDate" id="publishDate">
			</td>
		</tr>
		<tr>
			<td>
				<span><font color=#EAEAEA size="0.1">■</font> 출판사</span>
			</td>
			<td>
				<select name="publisher" id="publisher" value="">
					<option value="">해당 항목을 선택하세요</option>
					<option>엔코아</option>
					<option>한빛미디어</option>
					<option>시나공</option>
					<option>이지스퍼블리싱</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>
				<span><font color=orange size="0.1">■</font> 저   자</span>
			</td>
			<td>
				<input type="text" name="author" id="author">
			</td>
		</tr>
		<tr>
			<td>
				<span><font color=orange size="0.1">■</font> 도서가격</span>
			</td>
			<td>
				<input type="text" name="price" id="price"> 
				<select name="currency" id="currency">
					<option>원</option>
					<option>달러</option>
					<option>유로</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>
				<span><font color=#EAEAEA size="0.1">■</font> 요약내용</span>
			</td>
			<td>
				<textarea rows="4" cols="50" name="description" id="description"></textarea>
			</td>
		</tr>
	</table>
</section>
<footer>
	<div id="bottom">
		<input type="submit" name="submit" value="도서등록">
		<input type="reset" name="reset" value="취소">
	</div>
	<div id="copyright">
		<span>사전 도움말 - 이용약관 - 개인정보취급방침 - 책임의 한계와 법적고지 - 고객센터<br/></span>
		<span>Copyright ⓒ 2020. HaBaRee. All Rights Reserved.</span>
	</div>
</footer>
</form>
<script>
	var isbn1 = document.getElementById('isbn1');
	var isbn2 = document.getElementById('isbn2');
	var isbn3 = document.getElementById('isbn3');
	var title = document.getElementById('title');
	var catalogue = document.getElementById('catalogue');
	var author = document.getElementById('author');
	var price = document.getElementById('price');
	function inputAlert(){
		if(isbn1.value.length<1 || isbn2.value.length<1 ||  isbn3.value.length<1) {
			alert('도서번호를 모두 입력해주세요.');
			return false;
		}
		else if(title.value.length<1) {
			alert('도서제목을 입력해주세요.');
			return false;
		}
		else if(catalogue.value=="") {
			alert('도서종류를 입력해주세요.');
			return false;
		}
		else if(author.value.length<1) {
			alert('저자를 입력해주세요.');
			return false;
		}
		else if(price.value.length<1){
			alert('도서가격을 입력해주세요.');
			return false;
		}
		return true;
	};
</script>

</body>
</html>