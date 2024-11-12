	<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="UTF-8">
	<title>header</title>
	
	<style type="text/css">
	
	a:hover{
		cursor: pointer;
	}
	
	header{
		display: flex;
		justify-content: space-between;
		align-items: center;
		height: 69px;
		width: 100%;
		margin: 26px 0;
	}
	
	/*header-left*/
	.header-left{
		display: flex;
		justify-content: space-between;
		width: 50%;
		height: 46px;
		padding-left: 27px;
	}
	
	.logo{
		flex: 1;
		padding: 4px 28px 0px 30px;
	}
	
	.search-bar{
		flex: 9;
		display:flex;
		box-shadow: 0 2px 5px 1px rgba(64, 60, 67, .16);
		border-radius: 24px;
		overflow: hidden;
		position: relative;
	}
	
	.search-bar>input{
		flex: 9;
		border: none;
		outline: none;
		font-size: 16px;
		padding-left: 40px;
	}
	
	.search-bar>img{
		flex: 1;
		position: absolute;
		right: 20px;
		top: 10px;
	}
	
	/*header-right*/
	.header-right{
		width: 50%;
		padding-right: 27px;
	}
	
	.user-bar{
		display: flex;
		justify-content: flex-end;
		position: relative; 
	}
	
	.clickable-div{
		border-radius: 50%;
		border: 1px solid #d2d2d2;
		margin: 0 16px;
		display:flex;
		justify-content: center;
		align-items: center;
		width: 46px;
		height: 46px;
	}
	
	.clickable-div:hover{
		cursor: pointer;
	}
	
	.newDiv1 {
		position: absolute;
		top: 115px;
		right: 70px;
	    width: 350px;
	    height: 550px;
	    background-color: #F2F2F2;
	    display: none; 
	    justify-content: center;
	    text-align: center;
	    margin-top: 10px;
	    padding: 10px;
	    border-radius: 20px;
		box-shadow: 0 2px 5px 1px rgba(64, 60, 67, .16);
		z-index: 1000;
	}
	
	.user-info{
		display: flex;
		flex-direction: column;
		justify-content: space-between;
		color: rgba(60, 64, 67, .9);
		padding: 12px 16px;
		position: relative;
	}
	
	.x-icon{
		position: absolute;
		right: 16px;
		top: 12px;
	}
	
	.x-icon:hover{
		cursor: pointer;
	}
	
	.info-top{
		display: flex;
		flex-direction: column;
		align-items: center;
	}
	
	.info-top>span{
		background-color: #fff;
		border-radius: 50%;
		display: flex;
		justify-content: center;
	}
	
	.info-top p{
		font-size: 20px;
		margin-top: 16px;
	}
	
	.info-bottom>div{
		background-color: #fff;
		border-radius: 40px;
		display: flex;
		justify-content: center;
		line-height: 60px;
		height: 60px;
		width: 300px;
		font-size: 20px;
		margin: 20px 0px;
	}
	
	.logout-icon {
	    display: flex;
	    align-items: center;  
	    justify-content: center;  
	    
	}
	
	.logout-icon>img{
		margin-right: 12px;
	}
	
	.hamberger-icon{
		display: none;
		border-radius: 50%;
		position: relative;
	}
	
	.hamberger-icon:hover{
		cursor: pointer;
		background-color: #F2F2F2;
	}
	
	.hamberger-icon>img{
		display: flex;
		margin: 0 auto;
	}
	
	.newDiv2 {
	    display: none;
	    width: 20%;
	    height: 55%;
	    background-color: #F2F2F2;
	    padding: 36px 48px;
	    position: absolute;
	    top: 240px;
	    right: 27px;
	    border-radius: 10px;
	    box-shadow: 0 2px 5px 1px rgba(64, 60, 67, .16);
	    justify-content: center; 
	    align-items: center;
	    z-index: 1000;
	}
	
	.icons{
		display: flex;
		flex-direction: column;
		justify-content: space-between;
		align-items: center;
		gap: 60px;
	}
	
	.icons>div{
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
	}
	
	.visible {
	    display: flex;
	}
	
	@media(max-width: 1124px){
		.search-bar{
			display: none;
		}
	
		.header-right{
			display: none;
		}
	
		.hamberger-icon{
			display: block;
			margin-right: 27px;
		}	
		
	}
	
	@media (min-width: 1125px) {
	    .newDiv2 {
	        display: none !important;
	    }
	}
	
	</style>
	
	</head>
	
	
	<body>
	
	<header>
	${contextPath}
		<div class="header-left">
			<div class="logo">
				<a><img alt="toHOME" src="resources/img/logo3.png" style="height: 40px;"></a>
			</div>
			
			<div class="search-bar">
				<input type="text" placeholder="검색어를 입력하세요"> 
				<img alt="search-bar" src="resources/img/free-icon-magnifier-2866321.png" style="width: 24px; height: 24px;">
			</div>
		</div>
		
		<div class="header-right">
			<div class="user-bar" >
				<div class="clickable-div" onclick="showNewDiv1()" >
					<img alt="person" src="resources/img/free-icon-user-5264565.png" style="width: 33px; height: 33px;">
				</div>
			</div>
			<div class="newDiv1" id="newDiv1" onclick="showNewDiv1()">
				<div class="user-info">
					<div class="x-icon"><img alt="x" src="resources/img/free-icon-remove-11741047.png" style="width: 30px; height: 30px;"></div>
					<div class="info-top">
						<span style="width: 250px; height: 250px;">프사</span>
						<p>안녕하세요, 유저님.</p>
					</div>
					<div class="info-bottom">
						<div>My page</div>
						<div class="logout-icon"><img alt="logout" src="resources/img/free-icon-exit-15511159.png" style="width: 24px; height: 24px;">로그아웃</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="hamberger-icon" style="width: 50px; height: 50px;" onclick="showNewDiv2()" >
			<img alt="hamberger-icon" src="resources/img/free-icon-menu-dots-8111039.png" style="width: 40px; height: 40px;" >
		</div>
		<div class="newDiv2" id="newDiv2" onclick="showNewDiv2()">
			<div class="icons">
				<div><img alt="위치검색" src="resources/img/free-icon-search-3434913.png" style="width: 60px; height: 60px;"> <b style="margin-top: 12px;">위치검색</b> </div>
				<div><img alt="계정" src="resources/img/free-icon-user-3856336.png"  style="width: 60px; height: 60px;"> <b style="margin-top: 12px;">계정</b> </div>
				<button class="logout-icon" type="button" onclick="${pageContext.request.contextPath}/logout">
				    <img alt="logout" src="resources/img/free-icon-exit-15511159.png" style="width: 60px; height: 60px;">
				    <b style="margin-top: 12px;">로그아웃</b>
				</button>
			</div>
		</div>
	</header>
	
	<script>
		function showNewDiv1() {
		    const newDiv1 = document.getElementById('newDiv1');
		    newDiv1.classList.toggle('visible'); // visible 클래스를 추가/제거하여 보임/숨김 설정
		}
		
		function showNewDiv2() {
		    const newDiv2 = document.getElementById('newDiv2');
		    newDiv2.classList.toggle('visible'); // visible 클래스를 추가/제거하여 보임/숨김 설정
		}
	</script>
	
	</body>
	</html>