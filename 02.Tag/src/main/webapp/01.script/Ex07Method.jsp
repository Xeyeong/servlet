<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
.font-size{
	font-size: 30px;
}
.gr{
	color : green;
}
.red{
	color : red;
}
.or{
	color : orange;
}
</style>
</head>
<body>
	<h1>�޼ҵ� ���</h1>
	<!-- JAVA���� �޼ҵ� ���鶧 . => Ŭ���� �ȿ� �������. -->
	<!-- JSP�����̳�(��Ĺ) : �ٷ� �޼ҵ带 �ڹ��ڵ� �������� ����� ����Ҽ�����-->
	<!-- void <= ��ȯ���� ���� (����) -->
	<%! int getSum(int x , int y){
		int sum = x + y ; //? ����� html �ٵ�κп� ���̰� �Ϸ��� ��� �ؾ��ұ�?
						  // ǥ���� �±� ����ؾ��� ��
		
		return sum;
		/* x�� y�� �Է¹޾� �μ��� ���� ���ϴ� �޼ҵ� , ������ , ������ , ���ϱ�
		�� ���ϴ� �޼ҵ���� ���� ����ð� , ȣ�� �ϼ���(HTML ǥ���� �±� �̿�)*/
	
	}
	 %>
	 
	 
	 <h2 class="font-size green">getSum : <%=getSum(10, 20) %></h2><br>
	 <br>
	 
	 <!-- ������ �޼ҵ� -->
	 <%! double getDiv(double x ,double y){
		 double div = x / y;
		 
		 return div;
	 }
	 %>
	 <h2 class="font-size or">getDiv : <%=getDiv(10, 20) %></h2><br>
	 <br>
	 
	 <!-- ������ �޼ҵ� -->
	<%! int getShare(int x , int y){
		int share = x % y ; //? ����� html �ٵ�κп� ���̰� �Ϸ��� ��� �ؾ��ұ�?
						  // ǥ���� �±� ����ؾ��� ��
		
		return share;
	}
	 %>
	 <h2 class="font-size red">getShare : <%=getShare(10, 20) %></h2><br>
	 <br>
	 
	 <!-- ���ϱ� �޼ҵ� -->
	<%! int getMul(int x , int y){
		int mul = x * y ; //? ����� html �ٵ�κп� ���̰� �Ϸ��� ��� �ؾ��ұ�?
						  // ǥ���� �±� ����ؾ��� ��
		
		return mul;
	}
	 %>
	 
	 <h2 class="font-size gr">getMul : <%=getMul(10, 20) %></h2>
	 
	 
	<!-- getName�̶�� �޼ҵ带 ����� 
			�ش��ϴ� �޼ҵ�� �����̴ϼ��� �����ϴ� �޼ҵ��� 
			�ش��ϴ� �޼ҵ�� HTML�ٵ�κп� ���� �̴ϼ��� ����غ���.
		 -->
	
	<% void getName(String){
		String str = new String();
		str = "JSY";
		return str;
	}
	%>
	
	 <h2 class="font-size gr">name : <%= %></h2>
	 
	 
</body>
</html>













