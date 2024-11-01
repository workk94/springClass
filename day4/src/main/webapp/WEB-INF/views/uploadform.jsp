<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
    <form action="/day4/uploadex" method="post" enctype="multipart/form-data">
      <button>업로드</button>
      <input type="text" name="goodsName" />
      <input type="file" name="file" />
    </form>
  </body>
</html>
