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
    <script src="/assets/js/provider.js"></script>
    <title>서비스제공기관</title>
</head>
<body>
    <div class="container">
        <table class="provider_table">
            <thead>
                <tr>
                    <td>No.</td>
                    <td>기관명</td>
                    <td>주소</td>
                </tr>
            </thead>
            
        </table>
    </div>
    <div class="pager_area">
        <button id="prev">&lt;</button>
        <span class="current"></span>
        /
        <span class="total"></span>
        <button id="next">&gt;</button>
    </div>
    <!-- <div>
        <p>No.</p>
        <p id="ctpvNm">강릉</p>
    </div>
    <div>
        <p>기관이름</p>
        <p id="childCareInstNm">강원 고성군 건강가정지원센터</p>
    </div>
    <div>
        <p>주소</p>
        <p id="rprsTelno">033-655-4385</p>
    </div> -->
</body>
</html>