<%@page import="java.util.StringTokenizer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<% request.setCharacterEncoding("utf-8"); %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/include/header.jsp">
		<jsp:param value="ju" name="id"/>
		<jsp:param value="sy" name="name"/>
	</jsp:include>
	<h3>토큰분리</h3>
	토큰 = 단어단위, split 단점 : 하나밖에 지정할수없음
	<%
	String subjects = "view, oracle, java, servlet/Spring";
	String subject[] = subjects.split(",");
	
	for (String s : subject) {
		out.print("<div>" + s + "</div>");
		String data[] = s.split("/");
		for (String d : data) {
			out.print("<div>" + d + "</div>");

		}
	}
	out.print("<hr>");
	//String s[] = subject[3].split("/");

	StringTokenizer token = new StringTokenizer(subjects, ",/");
	
	while (token.hasMoreTokens()) {
		out.print("<div>" + token.nextToken() + "</div>");

	}
	%>
<hr />

<c:forTokens items="<%=subjects%>" var='subject' delims=",/" >
	<div>${subject}</div>
</c:forTokens>





	<%@ include file="/include/footer.jsp"%>

</body>
</html>