<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1> �ڹ� �ڵ� + HTML �±�</h1>
	<%
		int vInt = 10;
		String vStr = "�׽�Ʈ ���Դϴ�.";
		double vDouble = 3.14;
		ArrayList<String> sList = new ArrayList<String>();
		sList.add("J");
		sList.add("S");
		sList.add("Y");
	%> <!-- �ڹ��ڵ� (��ũ��Ʋ�� �±�) -->
	<p> vInt : <%=vInt %></p><!-- �±� ���ʿ� �׳� �����̸��� ������ �׳� ����
								  ������ ���� ����ϰ������ �ٽ� JAVA������ ��������(ǥ��)-->
	<p> vStr  : <%=vStr %></p>
	<!-- ������ �����鵵 ���� p�±׸� �̿��ؼ� ����غ���. -->
	<p> double : <%=vDouble %></p>
	<p> ArrayList : <%=sList.get(0) + sList.get(1) + sList.get(2)%></p>
</body>
</html>









