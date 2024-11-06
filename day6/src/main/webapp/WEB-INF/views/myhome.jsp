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
	<h2>my home</h2>


	<hr>

	<h2>로그인 여부에 따라 다르게 출력</h2>

	<%
	String userid = (String) session.getAttribute("userId");
	%>

	<c:if test="${empty userId}">


		<a href="${pageContext.request.contextPath}/mylogin">로그인</a>


	</c:if>

	<c:if test="${userId !=null}">

		<a href="${pageContext.request.contextPath}/mylogout">로그아웃</a>
	</c:if>


</body>
</html>