<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
.wrap {
	width: 300px;
	padding: 10px;
	border: 1px solid black;
	margin: 0 auto;
	font-size: 12px;
}

.wrap input {
	width: 95%;
	height: 30px;
}

.wrap button {
	height: 35px;
	margin-top: 10px;
	width: 97%;
}
</style>
</head>
<body>


<div class="wrap">

<form  action="/day3/acorn" method="post">
아이디<input type="text" name="id">
비번<input type="text" name="pw">
이름<input type="text" name="name">
<button>회원가입</button>
</form>
</div>
</body>
</html>