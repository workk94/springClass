<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="frm" action="/prac4/upload" method="post" enctype="multipart/form-data">
<input type="text"  name="itemId">
<input type="text"  name="itemName">
<input type="file" name="file">
<button>등록</button>
</form>
</body>
</html>