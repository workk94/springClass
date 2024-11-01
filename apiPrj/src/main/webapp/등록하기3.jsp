<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
   
</head>


<body>
<script>

//서버 API 비동기로 호출함 
//브라우저가 제공하는 기증

    document.addEventListener("DOMContentLoaded", function() {
        // btn대상에 클릭이벤트 추가하기
        document.getElementById("btn").addEventListener("click", function() {
            let id = document.getElementById("id").value;
            let name = document.getElementById("name").value;
            let customer = { id: id, name: name };

            console.log(customer);

            window.fetch("/api/member", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(customer),
            })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.text(); // 또는 response.json() 필요에 따라
            })
            .then(data => {
                alert(data);
                alert("등록완료");
                console.log(data);
            })
            .catch(error => {
                alert("error: " + error.message);
            });
        });
    });
</script>
<고객등록>
<input type="text" id="id">
<input type="text" id="name">
<button id="btn">등록</button>
</body>
</html>
