<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/assets/css/reset.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <link rel="stylesheet" href="/assets/css/menu.css">
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="/assets/js/menu.js"></script>
</head>
<body>
    <div class="left_menu">
        <a href="/" id="logo">
            <img src="http://placehold.it/250x50">
        </a>
        <ul class="main_menu">
            <li>
                <!-- introduction -->
                <a href="/main"> <span>사업소개</span></a>
            </li>
            <li>
                <!-- guidance -->
                <a href="#"> <span>이용안내</span></a>
            </li>
            <li>
                <!-- provider -->
                <a href="/provider"> <span>제공기관</span></a>
            </li>
            <li>
                <!-- qualification -->
                <a href="#"> <span>신청자격 및 요금표</span></a>
            </li>
            <li>
                <!-- babysitter -->
                <a href="#"> <span>아이돌보미</span></a>
            </li>
            <li>
                <!-- page -->
                <a href="#">my  <span>마이페이지</span></a>
            </li>
        </ul>
        <div class="hc_top">
            <div class="user_menu">
                <c:if test="${member == null}">
                    <a href="/login">
                        <i class="fas fa-sign-in-alt"></i>
                        <span>로그인</span>
                    </a>
                    <span>|</span>
                    <a href="/join">
                        <i class="fas fa-user-plus"></i>
                        <span>회원가입</span>
                    </a>
                </c:if>
                <c:if test="${member != null}">
                    <a href="/member/order">
                        <span class="user_grade">
                            <c:if test="${member.mi_grade == 1}">웹회원</c:if>
                            <c:if test="${member.mi_grade == 2}">정회원</c:if>
                            <c:if test="${member.mi_grade == 99}">관리자</c:if>
                        </span> 
                        ${member.mi_name} 님
                    </a>
                    <span>|</span>
                    <!-- <a href="/member/logout">로그아웃</a> -->
                    <a href="#" id="logout">로그아웃</a>
                </c:if>
            </div>
        </div>
    </div>
    <div class="sub">
        <ul>
            <li>
                <a href="#">사업 소개</a>
            </li>
            <li>
                <a href="#">신청 현황</a>
            </li>
            <li>
                <a href="#">실적 현황</a>
            </li>
            <li>
                <a href="#">회원 현황</a>
            </li>
        </ul>
        <ul>
            <li>
                <a href="#">요금표</a>
            </li>
        </ul>
        <ul>
            <li>
                <a href="#">제공 기관 상세</a>
            </li>
        </ul>
        <ul>
            
        </ul>
        <ul>
            <li>
                <a href="#">회원 정보</a>
            </li>
        </ul>
        <ul>
            <li>
                <a href="#">지원 방법</a>
            </li>
        </ul>
    </div>
</body>
</html>