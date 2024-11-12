<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

footer{
	width: 100%;
	height: 105px;
	padding: 12px 0px;
	background-color: #F2F2F2;
	position: absolute;
	bottom: 0px;
	left: 0px;
	color: #70757A;
}

/*footer-top*/
.footer-top{
	height: 40px;
	line-height: 40px;
	padding: 0px 0px 0px 79px;
	border-bottom: 1px solid #d2d2d2;
}

.location-info{
	display: flex;
}

.location-info>li{
	padding: 0px 16px;
}

/*footer-bottom*/
.footer-bottom{
	height: 40px;
	line-height: 40px;
	padding: 0px 0px 0px 79px;
}

.site-info{
	display: flex;
}

.site-info>li{
	padding: 0px 16px;
}


</style>

</head>
<body>

<footer>
	<div class="footer-top">
		<ul class="location-info">
			<li style="font-size: 15px;">대한민국</li>
			<li style="font-weight: bolder; color: #474747;">마포구 서울특별시 - IP 주소기반</li>
		</ul>
	</div>
	
	<div class="footer-bottom">
		<ul class="site-info">
			<li>도움말</li>
			<li>의견보내기</li>
			<li>개인정보처리방침</li>
			<li>약관</li>
		</ul>
	</div>
</footer>

</body>
</html>