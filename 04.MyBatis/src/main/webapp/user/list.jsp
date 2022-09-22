<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 유저 정보 목록 </h1>
	${list} <!--  list에 10건의 DTO가 있는데 foreach문의 한건씩 빼줌 dto -->
	<c:forEach items="${list}" var="jsy">
		<p>${jsy.id} : ${jsy.name} : ${jsy.phone} : ${jsy.addr}</p>
		
	</c:forEach>
</body>
</html>