<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>����</h1>
	<%! String var = "sy"; %> <!-- ���� ���� ����(�ʵ�, ��� ����) -->
	<% String lv = "��������"; %> <!-- ���� ���� -->
	<!-- ���������� ǥ���� �±׷� HTML�ٵ� �κп� ���̰� �ϰ�, ���� �ٲ㼭�� ���̰� �غ��� -->
	<%=lv %>
	
	<h1>HTML �±�</h1>
	<%=var %><!-- ǥ���� ���� �� ������ �޼ҵ���� ����� BODY�� �����ֱ� ���� �κ� -->
	<h1>HTML �±�</h1>
	<% var = "�ٸ���"; lv="�ٸ���"; %><!-- ��ũ��Ʋ���±� : �ڹ��ڵ带 �����ϰų� �ڹ� �۾��� ���� ����.(�ڹٿ���) -->
	<%=var %>
	<%=lv %>
</body>
</html>