<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<style>
	.red{
		color : red
	}
	.blue{
		color : blue;
	}
</style>
<body>
	<% int kSum = 0; %>
	<% int jSum = 0; %>
	<%for(int i = 1; i <= 100; i++) {
			if(i % 2 == 1){ 
			kSum += i; %>
			<p class="red">Ȧ�� i �� <%=i %></p>
		<%}else { 
			jSum += i; %>
			<p class="blue">¦�� i �� <%=i %></p>
		<%}//if %>
	<%}//for %>
			<p class="red"> Ȧ���� ������ <%=kSum %></p>
			<p class="blue"> ¦���� ������ <%=jSum %></p>
</body>
</html>




