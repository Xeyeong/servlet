<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%! int sVal = 0; %><!--  �������� -->
	<% int iVal = 0; %><!--  �������� -->
	<%=++sVal %>
	<%=++iVal %>
	<% String[] arr1 = {"S","Y","S","Y"}; %><!--  4�� ũ�⸦ ���� �迭(length) -->
		<!-- �迭�� �ε����� 0���� length-1 : 0, 1, 2, 3 -->
		<%=arr1[0] + arr1[1] + arr1[2] + arr1[3] %> <!-- ǥ�����±� syso�� ��� -->
		
	
	<!--Q.���ڸ� �����Ҽ��ִ� ������ ���� ���������� ���������� �����.
		  ���������� �����Ҷ����� �ΰ��� ������ ������������ �������ϰ�
		  ����� BODY�κп� ǥ����. (�� ������ ���̸� �˾ƺ��� )
		  
		Q.String[] �迭�� ����� 4���̻��� ũ�� ( �迭������ T , E , S , T�� ���ڰ� ������
		�ε����� �������.
		ǥ������ �̿��Ͽ� �ش��ϴ� ���ڸ� ��� ����ϱ�.
	  --> 
	  <%! int i = 0; %>
	  <%= i++ %>
	  <% int j = 0; %>
	  <%= j++ %>
	  <%String[] arr = {"T", "E", "S", "T"}; %>
	  <%= arr[0] %> <%= arr[1] %> <%= arr[2] %> <%= arr[3] %>
</body>
</html>





