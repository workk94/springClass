<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
function formcheck(frm) {
	
	console.log(frm);
	
	
	// let id = frm.id.value;
	//let id = document.frm.id.value;
	//결과가 true => form의 submit 이벤트가 실행
	//결과가 false => sumit 이벤트 중지 
	
	return true;
	
}
</script>
</head>
<body>
<h2>로그인</h2>
<form action="${pageContext.request.contextPath}/mylogin" method="post" onsubmit="return formcheck(this)">
<input type="text" name="id">
<input type="password" name="pw">
<button>로그인</button>
</form>
</body>
</html>