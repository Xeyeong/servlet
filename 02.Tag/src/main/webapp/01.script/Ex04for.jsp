<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>�ݺ���</h1>
	<!-- for ( �ʱ� ����; ����; ������ ) for(;;)-->
	
	<% for(int i = 0; i < 10; i++) {%>
		<!-- HTML�� �ٺ��� �Ǵ� ���� -->
		<p>�������� ����ϱ� <%=i %></p>	
	<%} %>
</body>
</html>