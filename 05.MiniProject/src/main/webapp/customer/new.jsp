<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/include/header.jsp"/>
<h3>신규고객등록</h3>
<form method='post' action='insert.cu'>
<table class='styled-table'>
<colgroup>
	<col width='140px'><col width='460px'>
</colgroup>
<tr><th>아이디</th>
	<td><input type='text' name='id'></td>
</tr>
<tr><th>고객명</th>
	<td><input type='text' name='name'></td>
</tr>
<tr><th>성별</th>
	<td><label><input type='radio' name='gender' value='남'>남</label>
		<label><input type='radio' name='gender' value='여' checked>여</label>
	</td>
</tr>
<tr><th>전화번호</th>
	<td><input type='text' name='phone'></td>
</tr>
<tr><th>주소</th>
	<td><input type='text' name='addr'></td>
</tr>
</table>
</form>
<div class='btnSet'>
	<a class='btn-fill' onclick="$('form').submit()">저장</a>
	<a class='btn-empty' href='list.cu'>취소</a>
</div>

<jsp:include page="/include/footer.jsp"/>
</body>
</html>