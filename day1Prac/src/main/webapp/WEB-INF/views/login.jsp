<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>로그인</h2>
<%= request.getContextPath() %>
<!-- action="day1Prac/hi2" -->
<form action="${pageContext.request.contextPath}/hi3" method="post">
<label for="id">아이디</label>
<input type="text" name="id">
<label for="pw">비밀번호</label>
<input type="password" name="pw">
<button>로그인</button>
</form>
</body>
</html>