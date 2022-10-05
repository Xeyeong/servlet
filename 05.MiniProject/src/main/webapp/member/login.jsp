<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.login { width: 300px; height: 300px; }
footer { top: 170px;   position: relative; }
.login input { width: 100%; margin-top: 5px }
#naver {
	background: url('img/naverlogin.png') no-repeat center; background-size: cover;
}
</style>
</head>
<body>
<jsp:include page="/include/header.jsp"/>
<h3>로그인</h3>
<div class='center login'>
<ul>
	<li><input type='text' id='id' class='chk' placeholder="아이디"></li>
	<li><input type='password' id='pw'  class='chk'  placeholder="비밀번호"></li>
	<li><input type='button' value='로그인' onclick='login()'></li>
	<li><hr></li>
	<li><input type='button' id='naver'></li>
</ul>
</div>

<script>
$('#naver').on('click', function(){
	location = 'naverlogin.mb';
});

$('#pw').keypress(function(e){
	if( e.keyCode==13 )	login();
});
function login(){
	//아이디/비번 입력여부 확인	
	if( ! emptyCheck() ) return;
	
	$.ajax({
		url: 'smartLogin.mb',
		data: { id:$('#id').val(), pw:$('#pw').val() },
		success: function(response){
			//로그인여부에 따라
			if( JSON.parse( response ) ){
				location = '<c:url value="/"/>';
			}else{
				alert('아이디나 비밀번호가 일치하지 않습니다!');
			}
			
		},error: function(req, text){
			alert(text+':'+req.status);
		}
	});
	
}

function emptyCheck(){
	var ok = true;
	$('.chk').each(function(){
		if( $(this).val()=='' ){
			alert('입력하세요');
			$(this).focus();
			ok = false;
			return ok;
		}
	});
	return ok;
}

</script>


<jsp:include page="/include/footer.jsp"/>
</body>
</html>