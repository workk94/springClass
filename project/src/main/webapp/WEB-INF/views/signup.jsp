<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
*{
	/*border: 1px solid;*/
	padding: 0;
	margin: 0;
	box-sizing: border-box;
	font-size: 16px;
	list-style: none;
}

body{
	background-color: #f5f8ff;
}

main{
	display: flex;
	justify-content: center;
	align-items:center;
	position: absolute;
	top: 25%;
	left: 37.5%;
	width: 25%;
	height: 50%;
	background-color: #fff;
	border: none;
	border-radius: 30px;
	padding: 20px 30px;
}

form{
	display: flex;
	flex-direction: column;
	gap: 5px;
}

input{
	padding: 5px;
}

button{
	height: 40px;
	background-color: #0b57d0;
	color: #fff;
	border: none;
	border-radius: 10px;
	margin-top: 10px;
}


</style>

</head>
<body>

<main>

<div>
	<div class="logo">
		<img alt="logo" src="resources/img/logo3.png">
		<h1 style="padding: 20px 0px; margin-top: 20px;">Acorn 계정 만들기</h1>
	</div>
	
	<form action="${pageContext.request.contextPath}/logout" method="post">
		<input type="text" placeholder="아이디">
		<input type="text" placeholder="이름">
		<input type="password" placeholder="비밀번호">
		<input type="password" placeholder="확인">
		<button>가입</button>
	</form>
</div>


</main>

</body>
</html>