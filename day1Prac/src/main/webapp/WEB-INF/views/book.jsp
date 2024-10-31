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
	<form action="${pageContext.request.contextPath}/getBook" method="post">
		<button>책 정보 가져오기</button>
	</form>

	<c:choose>
		<c:when test="${empty bookList }">
			<p>표시할 책이 없습니다</p>
		</c:when>
		<c:otherwise>
			<ul>
			<c:forEach var="book" items="${bookList}">
				<li>${book.title} ${book.author} ${book.price}</li>
			</c:forEach>
			
			</ul>
		</c:otherwise>
	</c:choose>
</body>
</html>