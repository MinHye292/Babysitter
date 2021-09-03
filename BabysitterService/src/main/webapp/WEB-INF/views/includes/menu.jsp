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
    <link rel="stylesheet" href="/assets/css/menu.css">
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
    <div class="left_menu">
        <a href="/" id="logo">Babysitter</a>
        <ul class="main_menu">
            <li>
                <a href="/main">introduction <span>사업소개</span></a>
            </li>
            <li>
                <a href="#">guidance <span>이용안내</span></a>
            </li>
            <li>
                <a href="/provider">provider <span>제공기관</span></a>
            </li>
            <li>
                <a href="#">qualification <span>신청자격 및 요금표</span></a>
            </li>
            <li>
                <a href="#">babysitter <span>아이돌보미</span></a>
            </li>
            <li>
                <a href="#">my page <span>마이페이지</span></a>
            </li>
        </ul>
        <div class="hc_top">
            <div class="user_menu">
                <c:if test="${member == null}">
                    <a href="/login">로그인</a>
                    <span>|</span>
                    <a href="/join">회원가입</a>
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
</body>
</html>