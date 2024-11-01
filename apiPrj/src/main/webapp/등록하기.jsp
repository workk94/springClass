<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>

function register(){
	 
	let id = $("#id").val();
	let name = $("#name").val();
	
	alert( id);
	alert( name);	
	//서버에 json형태 데이터로 보내기 
	let user =  {  id:id , name:name} ;
 
	console.log( user); 	
	// Json을 문자열로 형태로 변환하기
	let userString  =  JSON.stringify(user);	
	console.log( userString);
	
	 $.ajax({
		 type:"POST" , 
		 url:"/api/member",
		 
		 data: userString,
		 contentType: "application/json" ,   // clent  -> 서버에게 보내는 데이터 형식 
		 
		 success: function(data){
			  alert("등록성공");
		 },
		 error: function( error){
			  console.log ( error);
		 }		
	});
	   
}
</script>
</head>
<body> 
 
	<input  type="text" name="id"  id="id">
	<input  type="text" name="name"  id="name">
	<button type="button"  onclick="register()">등록</button> 

</body>
</html>