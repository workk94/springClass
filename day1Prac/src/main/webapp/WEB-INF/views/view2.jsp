<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>과일 목록</h2>

	<ul>
		<c:forEach var="item" items="${list }">
			<li>${item }</li>
		</c:forEach>

	</ul>
</body>
</html>