<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script>
	function search(){
		 
		//ajax  :   자바스크립트로 만든 라이브러리(jquery)의 기능 , 서버에게 화면전환없이 데이터를 가져올 수 있다. 
		//$.ajax();
		$.ajax(  {
			type:"GET" ,
			url: "/api/member"  ,
			success: function( data ){
				console.log( data);	
				let result  = toHtml( data);
				/*
								
				
				 */				
				
				$("#wrap").html(result); 	  // div 태그 사이의 내용 가져오거나 변경할 때		
				
				console.log( data);
			} ,
			error: function(err){
				console.log( err);
			}			
		});  		
	}
	
	 	
	function toHtml( data){  // json data   =>  원하는 형식의 html으로 변환 			
		console.log( data);
	    let str="";
	    /*
	    for( let i=0;  i< data.length ;  i++){
	    	 let item  = data[i];
	    	 str +="<div>" +  item.id +  item.name  +  "</div>";
	    }	
	    */	    
	    /*
	    data.forEach( function( item,  index){
	    	 str +="<div>" +  item.id +  item.name  +  "</div>";
	    });	
	    */	    
	    data.forEach(  (item, index) =>{
	    	str +="<div>" +  item.id +  item.name  +  "</div>";
	    });
	    
	    
	    
	   return str;		
	} 
</script>

</head>

<body>
<button onclick="search()">조회</button>
<div id="wrap"></div>

</body>
</html>