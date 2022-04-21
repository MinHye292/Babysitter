<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/views/includes/menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="/assets/js/login.js"></script>
    <script>
        <c:if test="${member != null}">
            location.href = "/";
        </c:if>
    </script>
    <link rel="stylesheet" href="/assets/css/reset.css">
    <link rel="stylesheet" href="/assets/css/login.css">
</head>
<body>
    <div class="login_box">
        <div class="login_title">
            <h1>로그인</h1>
            <a href="/join">회원가입</a>
        </div>
        <div class="login_form">
            <div class="input_box">
                <i class="fas fa-user"></i>
                <input type="text" placeholder="아이디" id="user_id">
            </div>
            <div class="input_box">
                <i class="fas fa-lock"></i>
                <input type="password" placeholder="비밀번호" id="user_pwd">
            </div>
            
            <button id="login_btn">로그인</button>
        </div>
    </div>
</body>
</html>