<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h2> 파일업로드</h2>
<!-- method="post" 변경 -->
<!-- method="multipart/form-data" 변경 -->
<form  action="/day4/upload"  method="post" enctype="multipart/form-data">
<input type="text" name="goodsName">
<input type="file" name="file">
<button> 등록</button>
</form>

</body>
</html>