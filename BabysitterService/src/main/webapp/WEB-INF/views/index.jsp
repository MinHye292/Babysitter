<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/WEB-INF/views/includes/menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>아이돌봄 서비스</title>
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" href="/assets/css/reset.css">
    <link rel="stylesheet" href="/assets/css/index.css">
    <script src="/assets/js/login.js"></script>
    <script>
        <c:if test="${member != null}">
            location.href = "/";
        </c:if>
    </script>
</head>
<body>
    <div class="container">
        <div class="main_banner_area">
            <div class="main_banner_contents">
                <div class="text">
                    <h1>아이돌봄 서비스 신청기간 변경안내</h1>
                    <h2>9월 서비스부터 아이돌봄서비스 신청기간이 변경됩니다.</h2>
                    <p>2020년부터 아이돌봄 서비스 이용 활성화 및 대기시간<br>
                        최소화 등을 위해 정기이용 및 대기신청을 전월 별도<br>
                        신청기간에 사전 신청토록 함으로써 공백이발생하지<br>
                        않도록 정책이 변경되었습니다. 자세한 사항은<br>
                        링크를 통해서 확인하세요! 
                    </p>
                    <a href="#">자세히 보기</a>
                </div>
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
            </div>
        </div>
    </div>

    
</body>
</html>