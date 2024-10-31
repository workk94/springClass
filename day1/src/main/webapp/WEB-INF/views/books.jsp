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


<h3> acorn book list</h3> 
 <c:forEach  var="book"  items="${booklist}">
 ${book.code}
 ${book.name}
 <img src="/day1/resources/imgs/${book.img}">
 </c:forEach>
</body>
</html>