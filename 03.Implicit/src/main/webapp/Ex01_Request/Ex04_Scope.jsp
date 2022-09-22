<%@page import="org.apache.catalina.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>스코프</h1>
	<h3>JSP에서 제공하는 내장 객체 사용(SCOPE)</h3>
	<%
		//페이지 내에서 데이터 유지하는 객체(pageContext)
		pageContext.setAttribute("pageCtx", "JSY_PAGE_CTX");
		// request <- 2가지 , getParameter <= URL로 요청이 오거나 From 태그를 사용했을때
		// request getAttr <= 어떤 요청을 통해서 오거나, Forwar<=를 통했을때
		request.setAttribute("req", "JSY_REQ");
		
		session.setAttribute("session", "JSY_SESSION");
	
		application.setAttribute("app", "JSY_APP");
	%>
	<p>pageContext : <%=pageContext.getAttribute("pageCtx") %></p>
	<p>Request : <%=request.getAttribute("req") %></p>
	<p>Session : <%=session.getAttribute("session") %></p>
	<p>Application : <%=application.getAttribute("app") %></p>
	
	<a href="Ex04_ScopeResult.jsp"> 다음 페이지로 이동 ScopeReuslt</a>
	
	
</body>
</html>