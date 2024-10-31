<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>

<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

.wrap {
	width: 300px;
	height: 500px;
}

.title {
	width: 100%;
}
.content-box {
	width:100%;

}
textarea {
	width: 100%;
	height: 300px;
}
</style>

<script>

</script>
</head>
<body>
	<h2>리뷰 등록</h2>
	<form action="${pageContext.request.contextPath}/addReview" method="post">
		<div class="wrap">
			<div class="title">
				<label for="title">제목</label> <input type="text" name="title">
			</div>
			<div class="content-box">
				<textarea name="content"></textarea>
			</div>
			<a href="${pageContext.request.contextPath}/addReviews" >등록하기</a>			
		</div>
	</form>
</body>
</html>