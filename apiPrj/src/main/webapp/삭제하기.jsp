<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<script>
$(document).ready(function(){
	
	 $("#btn").click(function(){
		 let id= $("#id").val(); 
		 alert( id);
		 $.ajax({
			 type:'DELETE', // 수정 요청 메서드
			 url: '/api/member/'+id , // 요청 URI => pathVariable  // /api/member/acorn
			 success : function(result){
			 	alert( result); alert("삭제완료");
			 },
			 error : function(){
				 alert("error");
			 } // 에러가 발생했을 때, 호출될 함수
		 }); // $.ajax()
	 });
});
</script>
아이디:<input type="text" id="id">
<button id="btn">삭제</button>
</body>
</html>