<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1> IF�� ����غ���</h1>
	<!-- ������ ���� true�� �Ǿ������ if���� ��ŷ�� ���� 
		if(boolean){ || �Ǵ� && �����ڷ� ���ǹ��� ������� ����
			true �϶� ���Ⱑ ����
		}
	-->
	<%!	int iVar = 0; %>
	<% iVar ++; %>
	<% if(iVar % 2 == 0) { %>
	<p>¦�� �Դϴ�. </p>
	<%= iVar %>
	<%} else{ %>
	<p>Ȧ�� �Դϴ�.</p>
	<%= iVar %>
	<%} %>			
	<!-- ¦���Դϴ�. ���� iVar�� ��������� ����غ��� (p�±׾ȿ���)
		 Ȧ���Դϴ�. ���� iVar�� ����������� ����غ��� (p�±׾ȿ���)
	 -->
	
		
</body>
</html>












