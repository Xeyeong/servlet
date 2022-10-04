<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/include/header.jsp"/>
<h3>신규사원등록</h3>
<form method='post' action='insert.hr'>
<table class='styled-table'>
<tr><th>성명</th>
	<td><input type='text' name='last_name' >
		<input type='text' name='first_name' >
	</td>
</tr>
<tr><th>이메일</th>
	<td><input type='text' name='email'></td>
</tr>
<tr><th>전화번호</th>
	<td><input type='text' name='phone_number' ></td>
</tr>
<c:set var='today' value='<%=new java.util.Date()%>'/>
<tr><th>입사일자</th>
	<td><input type='date' name='hire_date' 
			value="<fmt:formatDate value='${today }' pattern='yyyy-MM-dd'/>" >
	</td>
</tr>
<tr><th>급여</th>
	<td><input type='text' name='salary'></td>
</tr>
<tr><th>부서</th>
	<td><select name='department_id' class='w-px250'>
			<option value='-1'>부서선택</option>
			<c:forEach items='${departments}' var='d'>
			<option value='${d.department_id}' >${d.department_name}</option>
			</c:forEach>
		</select>
	</td>
</tr>
<tr><th>업무</th>
	<td><select name='job_id' class='w-px250'>
		<c:forEach items='${jobs}' var='j'>
		<option	value='${j.job_id}'>${j.job_title}</option>
		</c:forEach>
		</select>
	</td>
</tr>
<tr><th>관리자</th>
	<td><select name='manager_id' class='w-px250'>
		<option value='-1'>관리자선택</option>
		<c:forEach items='${managers}' var='m'>
		<option value='${m.manager_id}'>${m.name}</option>
		</c:forEach>
		</select>
	</td>
</tr>
</table>
</form>
<div class='btnSet'>
	<a class='btn-fill' onclick="$('form').submit()">저장</a>
	<a class='btn-empty' href='list.hr'>취소</a>
</div>

<jsp:include page="/include/footer.jsp"/>
</body>
</html>