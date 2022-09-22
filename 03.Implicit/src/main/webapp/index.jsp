<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>내장 객체</h1>
	<h2>Request ( 요청 )</h2>
	<ul>
		<li><a href="Ex01_Request/Ex00_IntoRequest.jsp"> 관련된 정보 따라해서 확인 </a></li>
		<li><a href="Ex01_Request/Ex01_Request.jsp"> 요청 객체 처음 사용 </a></li>
		<li><a href="Ex01_Request/Ex02_Request.jsp"> 파라메터를 동적 처리 해보기(문제) </a></li>
		<li><a href="Ex01_Request/Ex03_Request.jsp"> JDBC를 이용한 간단 로그인 </a></li>
		<li><a href="Ex01_Request/Ex04_Scope.jsp"> Scope(데이터 전달 범위) </a></li>
		<li><a href="Ex01_Request/Ex05_Scope.jsp"> 서블릿과 같이 사용(Scope)</a></li>
		<!-- Scope <= Zoom 망원경
			데이터를 전달하는 범위가 각각의 스코프(비율)마다 차이가 있음
			많은 데이터를 사용하지 않음. 계속 전달을 하면 메모리에 기억을 해두고 유지를 해야함
			많은 데이터를 사용하지 않는데 어떠한 특정한 key 값으로 계속 쌓아두다보면 혼동이 생김.
			
			PageContext ( JSP 페이지 내에서만 데이터를 전달한다. (=java,js변수) 사용빈도가 낮음
			Request (요청이 들어왔을때, Forward(페이지 요청)시에 딱 한번만 데이터를 유지함
					URL로 요청이 들어옴 => Servlet에서 받음 => 그리고 끝
					대부분의 데이터는 특정한 URL이 들어왔을때 필요하기 때문에 가장 많이 사용됨※
					)
			Session (브라우저 내에서는 계속해서 유지되는 정보
					주로 로그인 정보나 계속 유지되어야하는 정보중 용량이 크지 않은것을 사용함
					)※
			ApplicationContext ( 어플리케이션이 완전히 종료되지 않는한 계속해서 유지됨->
								버전 정보나, 특정한 업데이트를 위한 키값 외에는 사용 X)
		
		
		 -->
	</ul>
</body>
</html>