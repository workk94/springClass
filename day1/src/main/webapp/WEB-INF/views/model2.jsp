<%@page import="java.util.ArrayList"%>
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


<c:forEach var="item" items="${list}">
${item}
</c:forEach>


<% ArrayList<String>  list2 = ( ArrayList<String> )  request.getAttribute("list");

  String  str  = list2.get(0);
  

%>
<%= str %>


 
${item[1]}
 

</body>
</html>