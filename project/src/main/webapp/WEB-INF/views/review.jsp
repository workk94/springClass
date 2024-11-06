<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>

<script></script>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

div {
	border: 1px solid;
}

.paging {
	width: 100%;
}

.rating {
	width: 100%;
}
</style>
</head>
<body>

	<div class="review-list">
		<div>리뷰 어쩌고</div>
	
	</div>
	<div class="review-wrap">
		<div class="rating">
			평점 
			<select name="d">
				<option>
			</select>
		</div>
		<textarea name="" id="" cols="40" rows="5" placeholder="리뷰를 작성해주세요"></textarea>
		<button>등록</button>
	</div>
	<div class="paging">페이징공간</div>
</body>
</html>
