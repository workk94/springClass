<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
      //등록
      function regComment() {
        //alert('fsdfsdf');

        let title = $('#title').val(); //document.querySelector("#title").value;
        let content = $('#content').val();
        let id = 'c01';
        let sendDataJson = {
          id: id,
          title: title,
          content: content,
        };

        console.log(sendDataJson);

        let sendDataJsonString = JSON.stringify(sendDataJson);
        console.log(sendDataJsonString);

        //$.ajax();
        //$.ajax({});

        //서버와 비동기 통신
        //화면전환없이 서버와 통신할 수 있다.
        //jquery 라이브러리

        //객체를 문자열로 변환 : 직렬화
        $.ajax({
          type: 'post',
          url: '/day4/comments',
          data: sendDataJsonString,
          contentType: 'application/json',

          //콜백함수
          success: function (data) {
            console.log(data);
          },
          error: function (err) {
            console.log(err);
          },
        }); // 호출
      }

      // 변경
      function modifyComment() {
        //alert('sgddsg'); // test
        // 데이터 구성해야 한다
        let id = 'c01';
        let title2 = $('#title2').val();
        let content2 = $('#content2').val();

        // let snack = {
        //   title: '맛동산',
        //   price: '4800',
        //   success: function () {
        //     alert('^^');
        //   },
        // };
        // snack.success();
        let data = {
          id: id,
          title: title2,
          content: content2,
        };
        console.log(data);

        let dataString = JSON.stringify(data);
        console.log(dataString);

        //ajax 통신한다
        $.ajax({
          type: 'put',
          url: '/day4/comments/' + id, // /day4/comments/c01
          data: dataString,
          contentType: 'application/json',
          success: function (data) {
            console.log(data);
            if (data == 1) {
              console.log('변경완료');
            }
          },
          error: function (err) {
            console.log(err);
          },
        });
      }

      function deleteComment() {
        //alert('sdfsadf');
        let id = $('#id').val();

        $.ajax({
          type: 'delete',
          url: '/day4/comments/' + id,
          success: function (data) {
            console.log(data);
          },
          error: function (err) {
            console.log(err);
          },
        });
      }

      //전체 조회
      function getComment() {
        // 리뷰

        $.ajax({
          type: 'get',
          url: '/day4/comments/',
          success: function (data) {
            console.log(data);
          },
          error: function (err) {
            console.log(err);
          },
        });
      }

      //한개조회
      function getCommentOne() {
        alert('sfdadf');
        let id = $('#id2').val();
        $.ajax({
          type: 'get',
          url: '/day4/comments/' + id,
          success: function (data) {
            console.log(data);
          },
          error: function (err) {
            console.log(err);
          },
        });
      }
    </script>
  </head>
  <body>
    <h2>좋은 상품 상세페이지 입니다. ~~~~</h2>
    <h2>리뷰 등록</h2>

    <input type="text" id="title" />
    <input type="text" id="content" />
    <button onclick="regComment()">등록</button>

    <h2>리뷰 수정</h2>
    <input type="text" id="title2" />
    <input type="text" id="content2" />
    <button onclick="modifyComment()">변경</button>

    <h2>리뷰 삭제</h2>
    <input type="text" id="id" />
    <button onclick="deleteComment()">삭제</button>

    <h2>리뷰 조회</h2>
    <button onclick="getComment()">전체조회</button>

    <h2>리뷰 한개 조회</h2>
    <input type="text" id="id2" />
    <button onclick="getCommentOne()">조회</button>
  </body>
</html>
