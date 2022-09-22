<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>스코프 결과 페이지</h1>
	
	<p>pageContext : <%=pageContext.getAttribute("pageCtx") %></p>
	<!-- 페이지 내에서만 데이터가 유지됨(지역변수) -->
	<p>Request : <%=request.getAttribute("req") %></p>
	<!-- Forward라는 페이지 요청이 있을때만 다음페이지로 넘어감(메소드 파라메터부와 유사) -->
	<p>Session : <%=session.getAttribute("session") %></p>
	<!-- 전역변수(필드) 유사함 크롬창을 새로 띄우거나(브라우저 다른것) 또는 서버가 리스타트 되기전까지 유지됨-->
	<p>Application : <%=application.getAttribute("app") %></p>
	<!-- 특정 기능을 이용해서 삭제하거나 또는 프로젝트를 내리지 않는한 계속해서 유지됨
		( static 과 유사함)
	 -->
</body>
</html>