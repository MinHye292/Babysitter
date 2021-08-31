<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원현황</title>
    <link rel="stylesheet" href="/assets/css/reset.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css" integrity="sha512-aOG0c6nPNzGk+5zjwyJaoRUgCdOrfSDhmMID2u4+OIslr0GjpLKo7Xm0Ao3xmpM4T8AmIouRkqwj1nrdVsLKEQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.structure.min.css" integrity="sha512-oM24YOsgj1yCDHwW895ZtK7zoDQgscnwkCLXcPUNsTRwoW1T1nDIuwkZq/O6oLYjpuz4DfEDr02Pguu68r4/3w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.theme.min.css" integrity="sha512-9h7XRlUeUwcHUf9bNiWSTO9ovOWFELxTlViP801e5BbwNJ5ir9ua6L20tEroWZdm+HFBAWBLx2qH4l4QHHlRyg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js@3.5.0/dist/chart.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js" integrity="sha512-uto9mlQzrs59VwILcLiRYeLKPPbS/bT71da/OEBYEwcdNUk8jYIy+D176RYoop1Da+f9mvkYrmj5MCLZWEtQuA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="/assets/js/member.js"></script>
</head>
<body>
    <div class="container">
        <%@include file="/WEB-INF/views/includes/menu.jsp"%>
        <div class="dashboard_area">
            <select id="babysitterRegionCnt">
                <option value="서울특별시 건강가정지원센터">서울</option>
                <option value="대구광역시 광역거점">대구</option>
                <option value="강원도 광역거점">강원</option>
                <option value="경기도 광역거점">경기</option>
                <option value="경상남도 건강가정지원센터">경남</option>
                <option value="경상북도 광역거점">경북</option>
                <option value="충청남도 광역거점">충남</option>
                <option value="광주광역시 광역거점">광주</option>
                <option value="대전광역시 광역거점">대전</option>
                <option value="전라남도 광역거점">전남</option>
                <option value="부산광역시 광역거점">부산</option>
                <option value="전라북도 광역거점">전북</option>
                <option value="세종특별자치시 광역거점">세종</option>
                <option value="울산광역시 광역거점">울산</option>
                <option value="충청북도 광역거점">충북</option>
                <option value="인천광역시 광역거점">인천</option>
                <option value="제주도 광역거점">제주</option>         
            </select>
            <select id="babysitterDate">
                <c:forEach items="${dateList}" var="item">
                    <option value="${item}">${item}</option>
                </c:forEach>
            </select>
            <div class="content_area chart_content">
                <h1>지역별 전체회원</h1>
                <canvas id="regionMemberCnt" style="width:100%; height:100%;"></canvas>
            </div>
        </div>
    </div>
</body>
</html>