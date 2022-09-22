<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 로그인 페이지 </h1>
	<!-- url mapping jdbclogin 이라고 만들고
		현재 JSP페이지에서 Form 태그를 이용해서 id와 pw를 전송하시오.
		id, pw같은 개인정보와 관련된 민감한 정보는 post 방식을 사용. URL에 보여질 필요가없음
	 -->
	<form action="../jdbclogin" method="post">
		<input type="text" name ="id" placeholder="아이디 입력"/>
		<input type="text" name ="pw" placeholder="비밀번호 입력"/>
	
	
		<input type="submit" value="로그인"/>
	</form>
	
	
	
	
</body>
</html>



