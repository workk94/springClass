<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>search</title>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        // 등록
        function reg() {
            let inputText = $("#todo-input").val();
            
            if (inputText.trim() === "") {
                alert("일정을 입력하세요.");
                return;
            }

            let currentDate = new Date().toLocaleString();

            let item = `
                <div class="list-item">
                    <div class="checkbox_col"><input type="checkbox" /></div>
                    <div class="title_col">${inputText}</div>
                    <div class="date_col">${currentDate}</div>
                    <div class="btn_col"><button onclick="del(this)">삭제</button></div>
                </div>
            `;
            
            // list-items 컨테이너에 항목 추가
            $(".list-items").append(item);
            
            // 입력 필드 초기화
            $("#todo-input").val('');
        }

    </script>

    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .wrap {
            height: 50%;
            width: 30%;
            padding: 20px;
            display: flex;
            flex-direction: column;
            border: 1px solid lightgray;
        }


        .list-add {
            margin-top: 40px;
        }

        .todo-list {
            display: flex;
            height: 50%;
            margin-top: 10px;
        }

        .todo-list>input {
            width: 80%;
            height: 100%;
        }

        .todo-list>button {
            width: 20%;
            height: 100%;
        }

        .list-search {
            margin-top: 50px;
        }

        .search-bar {
            margin-top: 10px;
            height: 50%;
        }

        .search-bar>input {
            height: 100%;
            width: 100%;
        }

        .list-items {
            margin-top: 20px;
            border-top: 1px solid lightgray;
            height: 200px; /* 고정된 높이 설정 */
            overflow-y: auto; /* 스크롤을 생성 */
        }

        .list-item {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-top: 10px;
        }

        .list-item .checkbox_col {
            width: 10%;
        }

        .list-item .title_col {
            width: 50%;
        }

        .list-item .date_col {
            width: 20%;
        }

        .list-item .btn_col {
            width: 20%;
        }

        .btn_col>button {
            width: 100%;
        }

    </style>
</head>

<body>

    <div class="wrap">
        <div class="list-add">
            <div class="todo-list">
                <input type="text" placeholder="검색어를 입력하세요" id="todo-input">
                <img alt="" src="resources/img/free-icon-magnifier-2866321.png" id="regBtn" onclick="reg()">
            </div>
        </div>

        <!-- 동적으로 추가되는 항목들이 들어갈 컨테이너 -->
        <div class="list-items"></div>
    </div>

</body>
</html>