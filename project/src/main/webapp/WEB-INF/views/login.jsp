<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>

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
	position: absolute;
	top: 33.33%;
	left: 12.5%;
	width: 75%;
	height: 33.33%;
	background-color: #fff;
	border: none;
	border-radius: 30px;
	padding: 50px 50px;
}

.main-left{
	width: 50%;
}

.main-right{
	width: 50%;
	display: flex;
	align-items: center;
}

.main-right>form{
	display: flex;
	flex-direction: column;
	width: 100%;
}

.idnpw{
	display: flex;
	flex-direction: column;
	gap: 10px;
	align-items: center;
}

.idnpw>input{
	height: 40px;
	width: 100%;
	border: 1px solid #d2d2d2;
	border-radius: 3px;
	padding: 20px 15px;
}

.id-remember{
	display: flex;
	justify-content: flex-end;
	width: 100%;
	padding: 10px 10px;
}

.buttons{
	display: flex;
	justify-content: flex-end;
	width: 100%;
	padding: 10px 10px;
}


.buttons>a{
	height: 40px;
	background-color: #0b57d0;
	color: #fff;
	padding: 20px 15px; 
	border: none;
	border-radius: 20px;
	display: flex;
	align-items: center;
	margin: 0 5px;
}

@media(max-width: 1124px){
	main{
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
	}
	
	.main-left{
		display: flex;
		justify-content: center;
	}
	
	.main-left>h1, .main-left>h6{
		display: none;
	}
}
</style>



</head>
<body>


<main>

<div class="main-left">
	<img alt="logo" src="resources/img/logo3.png" style="margin-bottom: 15px;">
	<h1 style="font-size: 32px; margin-bottom: 15px;">Sign in</h1>
	<h6>Use your Acorn Account</h6>
</div>

<div class="main-right">
	<form action="/project/login" method="post">
		<div class="idnpw">
			<input type="text" name="id" value="${cookie.id.value}" placeholder="아이디를 입력하세요" >
			<input type="password" name="pw" placeholder="비밀번호를 입력하세요">
		</div>
		<div class="id-remember">
			 <input type="checkbox" name="checkid" ${empty cookie.id.value ? "" : "checked"}> <h6 style="color:#0b57d0; margin-left: 10px">아이디 기억</h6>
		</div>
	    <div class="buttons">
	    	<a href="${pageContext.request.contextPath}/signup">Create account</a>
	    	<a href="${pageContext.request.contextPath}/login" type="submit">Login</a>
	    </div>
	</form>
</div>

</main>


</body>
</html>