<%@page import="java.util.List"%>
<%@page import="dto.TestMybatisDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--  uri는 이 페이지에서 해당하는 옵션의 태그들을 사용하겠다.
		prefix는 기존의 태그와 구별할수있는 구분자
		//file .jpg, mpeg, mp3 등등 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>리스트 (TEST)</h1>
	<!-- 자바코드로 Attribute에 있는 내용 출력하기 -->
	<!-- 1.이니셜 2.list.size() -->
	<p> <%=request.getAttribute("data") %></p>
	<p><%=((List<TestMybatisDTO>)request.getAttribute("list")).size() %></p>
	<p>EL문법</p>
	${data}
	
	${list[1].test_A}
	<!--  객체 한건을 빼서 쓸 변수 : 객체 여러건이 들어있는 리스트 -->
	<!--for(Object obj : list ){ } -->
	<c:forEach var="dto" items="${list}" >
		<p> ${dto.test_A} ||||| ${dto.TEST_DATA1 }</p>
	</c:forEach>
	
</body>
</html>

