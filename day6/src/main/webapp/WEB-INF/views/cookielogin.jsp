<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% 
		Cookie[] arr = request.getCookies();
		
		if(arr != null){
			for(Cookie c : arr){
				out.println(c.getValue()); // 이름, 값 한 쌍 
				out.println(c.getName());
			}
		}
	
	
	
	%>


	<!-- 쿠키의 id가 있으면, 아이디 부분에 이름이 나온다, checkbox가 checked 속성 추가 -->
	<form action="${pageContext.request.contextPath}/cookielogin"
		method="post">
		아이디<input type="text" name="id" value="${cookie.id.value}"> 비번<input
			type="password" name="pw"> <input type="checkbox"
			name="checkid" ${empty cookie.id.value ? "": "checked"} >아이디기억
		<button>로그인</button>
	</form>
</body>
</html>