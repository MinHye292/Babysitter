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
    <title>사업 소개</title>
    <link rel="stylesheet" href="/assets/css/common.css">
    <link rel="stylesheet" href="/assets/css/main.css">
</head>
<body>
    <div class="container">
        <div class="left_area">
            <h1>사업소개</h1>
            <a href="/main" class="current">사업소개</a>
            <a href="/requestTime">신청현황</a>
            <a href="/result">실적현황</a>
            <a href="/member">회원현황</a>
        </div>
        <div class="right_area">
            <h1>사업소개</h1>
            <div class="top_content">
                <div class="top_content_left">
                    <i class="fas fa-hand-holding-heart"></i>
                </div>
                <div class="top_content_right">
                    <h2>아이돌봄 서비스란?</h2>
                    <h4>부모의 맞벌이 등으로 양육공백이 발생한 가정의 만 12세 이하 아동을 대상으로 아이돌보미가 찾아가는 돌봄 서비스를 제공하여 부모의 양육부담을 경감하고 시설보육의 사각지대를 보완하고자 만들어졌습니다.</h4>
                </div>
            </div>

            <h2>아이돌봄 지원사업 목적</h2>
            <h4>아이돌봄 지원사업은 가정의 아이돌봄을 지원하여 아이의 복지증진과 보호자의 일·가정 양립을 통한 가족구성원의 삶의 질 향상과 양육친화적인 사회 환경을 조성하는데 목적이 있습니다.</h4>

            <div class="right_contents">
                <h1>가족구성원 삶의 질 향상</h1>
                <div class="right_items">
                    <div class="item_text">
                        <h2>아동의 안전한 보호</h2>
                        <div class="item_ico">
                            <i class="fas fa-home"></i>
                        </div>
                        <h3>영아 및 방과 후 아동 돌봄</h3>
                        <p>
                            개별 가정 특성 및 아동발달을<br>
                            고려하여 아동의 집에서<br>
                            돌봄 서비스 제공
                        </p>
                    </div>
                    <div class="item_text">
                        <h2>부모의 일·가정 양립</h2>
                        <div class="item_ico">
                            <i class="fas fa-handshake"></i>
                        </div>
                        <h3>취업 부모</h3>
                        <p>
                            야간·주말 등 틈새시간<br>
                            ‘일시 돌봄’ 및 ‘영아종일돌봄’ 등<br>
                            수요자가 원하는 서비스 확충
                        </p>
                    </div>
                    <div class="item_text">
                        <h2>돌봄 자원 창출</h2>
                        <div class="item_ico">
                            <i class="fas fa-search-location"></i>
                        </div>
                        <h3>아이돌보미</h3>
                        <p>
                            육아·돌봄 의사가 있는 여성에게<br>
                            교육지원과 능력개발을 제공하여<br>
                            사회서비스 수요와 연계 활성화
                        </p>
                    </div>
                </div>
        
            </div>
        </div>
    </div>
</body>
</html>