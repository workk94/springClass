<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>

<script>

</script>
</head>
<body>
	<h2>리뷰 페이지</h2>
	
	<c:choose>
	<c:when test="${ empty reviewList} ">
		<p>등록된 리뷰가 없습니다</p>
	
	</c:when>
	<c:otherwise>
	<table>
	
	<c:forEach var="review" items="${reviewList}">
		<tr>
			<td>${ review.title}</td>
			<td>${review.content }</td>
		</tr>
	</c:forEach>
	
	</table>
	</c:otherwise>
	</c:choose>
	<a href="${pageContext.request.contextPath}/reviews/new">리뷰추가</a>
</body>
</html>