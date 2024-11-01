<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script>
function getData(){
	//alert("ddfkfkd");
	//서버에요청 고객목록 조회 ,  화면전환없이  Ajax 
	
	
	//json  = >  자바스크립트객체 표기법 , 자바스크립트가 객체를 표현하는 방법    {  id:"test01" , pw: "1234"  }
	$.ajax(  {
		type:"GET",
		url:"/day4/users",
		//콜백함수 2개  성공했을때, 실패했을 때 수행할 코드 
		success : function( data ){
			console.log( data);
		},
		error: function(err){
			alert(" 에러 발생");
			console.log( err);
		}
		
	});  // ajax()	
}  // getData


// 사용자 등록 요청
function regUser(){	
	//alert("dfdf");
	
	let id  = $("#id").val();   // value속성 가져오기
	let pw  = $("#pw").val(); 	
	let user  =  {  id :id, pw: pw};  // json
	console.log( user);
	//user json 객체를 문자열화 해야 함 
	let userString  = JSON.stringify( user);
	console.log ( userString);
	
	 
	$.ajax( {
		type:"POST",
		url :"/day4/users",
		data :userString, 
		contentType: "application/json" ,
		
		//콜백함수
		success: function(data){
			console.log(data)
		},
		error: function(err){
			
			console.log( err);
		}
		
	});   //ajax 
}  //regUser



// 사용자 수정하기
function modifyUser(){
	//alert("ddfjdfkjdfkd");
	
	let id = $("#id2").val(); // value 속성
	let pw=  $("#pw2").val();	
	let  user  = { id: id , pw:  pw};   
	
	console.log(user);
	let userString  =  JSON.stringify( user); 
	console.log(userString );
	
	
	$.ajax( {
		type:"PUT",
		url:"/day4/users",
		data :userString,
		contentType: "application/json",
		//두 개의 콜백함수 		
		success: function( result){
			
			console.log( result);
		}, 
		error: function(err){
			console.log( err);
			
		}		
	});  //ajax	
} //modifyUser



// 사용자 삭제하기
function deleteUser(){
	alert("dkdfkdfjdfkjdfkd");	
	let id  = $("#id3").val();  //  document.getElementById("id3").value ;	
	alert( id);
	
	
	$.ajax( {
		type: "DELETE", 
		url :"/day4/users/"+ id ,   //  pathvariable   /usrs/test01     ,쿼리스티링과 다르다   ==>  ?id=test01   
		success: function(data){
			console.log( data);
			
		},
		error: function(err){
			console.log( err);
		}
		
	});
	
	
}
 

</script>


</head>
<body  onload="getData()">
<h4> main화면</h4> 



<h4>사용자조회 영역</h4>
<div id="result">
</div>



<h4>사용자 등록</h4>
<input type="text"  id="id">
<input type="text"  id="pw">
<button onclick="regUser()">사용자등록</button>



<h4>사용자 수정</h4>
<input type="text" id="id2">
<input type="text" id="pw2">
<button onclick="modifyUser()">사용자 변경하기</button>



<h4>사용자 삭제하기</h4>
<input type="text" id="id3">
<button onclick="deleteUser()">사용자 삭제하기</button>


</body>
</html>