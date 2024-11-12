<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{
	/*border: 1px solid;*/
	padding: 0;
	margin: 0;
	box-sizing: border-box;
	font-size: 14px;
	list-style: none;
}

main{
	border-top: 1px solid #d2d2d2;
	padding: 12px 180px;
}


/*main-top*/
.category{
	display:flex;
}

.category>li{
	display: inline-block;
	height: 40px;
	margin: 0px 16px;
	padding: 12px 16px;
	border: 1px solid #d2d2d2;
	border-radius: 20px; 
}

/*main-bottom*/
.main-bottom{
	padding: 12px 16px;
	display: flex;
	width: 80%;
}

.restaurant-list {
	width:40%;
	height: 500px;
}

.review{
	margin: 12px 16px;
	padding: 12px 16px;
	border-bottom: 1px solid #ddd;
	height: 30%;
}

.review:hover{
	border: 1px solid #0b57d0;
	border-radius: 20px;
}


.map {
	width: 60%;
	height: 500px;
}

@media(max-width: 1124px){
	
	main{
		margin: 0 auto;
		padding: 12px 12px;
	}
	
	.user-info{
		display: none !important;
	}
	
	.category > li {
        display: inline-block;
        padding: 8px 16px; 
        margin: 4px; 
        border: 1px solid #d2d2d2;
        border-radius: 20px; 
        white-space: nowrap;
    }
}


</style>
</head>
<body>

<!-- main.jsp -->
<%@ include file="header.jsp" %>  

<main>

	<div class="main-top">
		<ul class="category">
			<li>한식</li>
			<li>치킨</li>
			<li>분식</li>
			<li>일식</li>
			<li>중식</li>
			<li>양식</li>
			<li>아시아음식</li>
		</ul>
	</div>
	
	<p style="font-size: 28px; padding: 27px 16px 20px;">장소</p>
	<div class="main-bottom">
		<div class="restaurant-list">
			<div class="review">
				<h1 style="font-size: 18px;">가게이름</h1>
				<div style="margin: 10px;"><p>별점</p><p>카테고리</p></div>
				<p>도로명주소</p>
				<p>마지막리뷰</p>
			</div>
			<div class="review">...</div>
			<div class="review">...</div>
		</div>
		<div class="map"></div>
	</div>
	
</main>

<!-- footer.jsp -->
<%@ include file="footer.jsp" %>  


<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=57c248198a6995d408cfef5cd4a3362b"></script>
<script>
	let mapContainer = document.querySelector('.map'), // 지도를 표시할 div 
	    mapOption = { 
	        center: new kakao.maps.LatLng(37.554065, 126.920583), // 지도의 중심좌표
	        level: 3 // 지도의 확대 레벨
	    };
	let map = new kakao.maps.Map(mapContainer, mapOption); 
	
	
	// 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
	let mapTypeControl = new kakao.maps.MapTypeControl();

	// 지도에 컨트롤을 추가해야 지도위에 표시됩니다
	// kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
	map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

	// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
	let zoomControl = new kakao.maps.ZoomControl();
	map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
	
	
	
	let markerPosition  = new kakao.maps.LatLng(37.554065, 126.920583); 

	// 마커를 생성합니다
	let marker = new kakao.maps.Marker({
	    position: markerPosition
	});

	// 마커가 지도 위에 표시되도록 설정합니다
	marker.setMap(map);

	let iwContent = '<div style="padding:5px;">Hello World! <br><a href="https://map.kakao.com/link/map/Hello World!,33.450701,126.570667" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/Hello World!,33.450701,126.570667" style="color:blue" target="_blank">길찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
	    iwPosition = new kakao.maps.LatLng(33.450701, 126.570667); //인포윈도우 표시 위치입니다

	// 인포윈도우 생성
	let infowindow = new kakao.maps.InfoWindow({
	    position : iwPosition, 
	    content : iwContent 
	});

	infowindow.open(map, marker); 

</script>

</body>
</html>