<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
input[name=address] { width: 500px; margin-top: 5px }
</style>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
  
</head>
<body>
<jsp:include page="/include/header.jsp"/>

<h3>회원가입</h3>
<p style='width:80%; margin: 5px 10%; text-align: right;' >* 는 필수입력항목입니다</p>
<form method='post' action='join.mb'>
<table class='styled-table'>
<tr><th class='w-px140'>성명 *</th>
	<td><input type='text' name='name' ></td>
</tr>
<tr><th>아이디 *</th>
	<td><input type='text' name='id' class='chk'>
		<a class='btn-fill' id='btn-id'>아이디중복확인</a>
		<div class='valid'>아이디를 입력하세요(영문소문자, 숫자만)</div>
	</td>
</tr>
<tr><th>비밀번호 *</th>
	<td><input type='password' name='pw' class='chk'>
		<div class='valid'>비밀번호를 입력하세요(영문 대/소문자,숫자를 모두 포함)</div>
	</td>
</tr>
<tr><th>비밀번호확인 *</th>
	<td><input type='password' name='pw_ck' class='chk'>
		<div class='valid'>비밀번호를 다시 입력하세요</div>
	</td>
</tr>
<tr><th>이메일 *</th>
	<td><input type='text' name='email' class='chk'>
		<div class='valid'>이메일을 입력하세요</div>
	</td>
</tr>
<tr><th>성별 *</th>
	<td><label><input type='radio' name='gender' value='남' checked>남</label>
		<label><input type='radio' name='gender' value='여'>여</label>
	</td>
</tr>
<tr><th>전화번호</th>
	<td><input type='text' name='phone'></td>
</tr>
<tr><th>생년월일</th>
	<td><input type='text' name='birth' readonly>
		<a id='delete'><i class="font fa-regular fa-calendar-xmark"></i></a>
	</td>
</tr>
<tr><th>주소</th>
	<td><a class='btn-fill' onclick='find_post()'>우편번호찾기</a>
		<input type='text' name='post' class='w-px80' readonly><br>
		<input type='text' name='address' readonly><br>
		<input type='text' name='address'>
	</td>
</tr>
</table>
</form>
<div class='btnSet'>
	<a class='btn-fill' onclick="join()">회원가입</a>
	<a class='btn-empty' href='<c:url value="/"/>'>취소</a>
</div>

<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src='js/member.js?<%=new java.util.Date()%>'></script>
<script>
//아이디 중복확인
$('#btn-id').click(function(){
	id_check();	
});

function id_check(){
	//입력아이디가 유효한지부터 확인
	var $id = $('[name=id]');
	if( $id.hasClass('chked') ) return; //이미 중복확인했다면 중복확인을 재차 할 필요없음
	
	var status = member.tag_status( $id );
	if( status.code=='invalid' ){
		alert('아이디 중복확인 불필요!\n' + status.desc);
		$id.focus();
		return;
	}
	console.log('아이디 중복확인')
	//DB에 입력한 아이디 존재여부 확인
	$.ajax({
		url: 'id_check.mb',
		data: { id: $id.val() },
		success: function( response ){
			response = member.id_usable( response );
			$id.siblings('div').text(response.desc)
							   .removeClass().addClass(response.code);
			$id.addClass('chked');
				
		},error: function(req, text){
			alert(text + ':'+req.status);
		}
	});
	
}


$('.chk').keyup(function(e){
	if( $(this).attr('name')=='id' ){
		if( e.keyCode==13 ){
			id_check(); //아이디 태그에서 엔터한 경우 중복확인하기
			return;
		}else
			$(this).removeClass('chked');
	}
	
	var status = member.tag_status( $(this) );
	$(this).siblings('div').text( status.desc )
				.removeClass().addClass( status.code );
});

$('[name=birth]').change(function(){
	$('#delete').css('display', 'inline');
});
 
$('#delete').click(function(){
	$('#delete').css('display', 'none');
	$('[name=birth]').val('');
});

$(function(){
	//만 13세 부터 가입가능
	var today = new Date();
	var begin = today.getFullYear() - 80 ;
	today.setFullYear( today.getFullYear()- 13 );
	today.setDate( today.getDate()-1 );
	var end = today.getFullYear();
	
	$('[name=birth]').datepicker({
		dateFormat: 'yy-mm-dd',
		dayNamesMin: [ '일', '월', '화', '수', '목', '금', '토' ],
		changeYear: true,
		changeMonth: true,
		showMonthAfterYear: true,
		monthNamesShort: [ '1월', '2월', '3월', '4월', '5월', '6월'
						 , '7월', '8월', '9월', '10월', '11월', '12월' ],
		yearRange: begin + ' : ' + end ,
		maxDate : today
	});
});

//우편번호찾기
function find_post(){
	new daum.Postcode({
        oncomplete: function(data) {
			console.log( data );
        	$('[name=post]').val( data.zonecode );
        	//도로명주소R / 지번주소J
        	var address = data.userSelectedType == 'R' 
        					? data.roadAddress : data.jibunAddress;
        	if( data.buildingName != '' ) address += ' ('+ data.buildingName+')'; 
        	$('[name=address]').eq(0).val( address );
        }
    }).open();
}

function join(){
	if( $('[name=name]').val()=='' ){
		alert('성명을 입력하세요');
		$('[name=name]').focus();
		return;
	}
	//아이디는 중복확인 후 이미 사용중인 경우 submit불가
	//아이디 중복확인 하지 않은 경우 submit 불가
	if( $('[name=id]').hasClass('chked') ){
		if( $('[name=id]').siblings('div').hasClass('invalid') ){
			alert('회원가입 불가\n' + member.id.unUsable.desc);
			$('[name=id]').focus();
			return;
		}		
	}else{
		//아이디의 유효성을 확인한 후 submit 하도록 한다
		if( itemIsInvalid( $('[name=id]') ) ) return;
		else{
			//유효하게 입력했다면 중복확인하도록 유도한다
			alert('회원가입 불가\n' +  member.id.valid.desc );
			$('[name=id]').focus();
			return;
		}
	}

	//각 필수입력항목의 유효성을 확인한 후 submit 하도록 한다
	if( itemIsInvalid( $('[name=pw]') ) ) return;
	if( itemIsInvalid( $('[name=pw_ck]') ) ) return;
	if( itemIsInvalid( $('[name=email]') ) ) return;
	
	$('form').submit();
}

function itemIsInvalid( tag ){
	var status = member.tag_status( tag );
	if( status.code == 'invalid' ){
		alert('회원가입 불가\n' +  status.desc);
		tag.focus();
		return true;
	}else
		return false;
}


</script>
<jsp:include page="/include/footer.jsp"/>
</body>
</html>