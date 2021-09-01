$(function () {
    var BabysitterregionMemberCntChart = new Chart($("#regionMemberCnt"), {
        type: "bar",
        options: {
            responsive: false,
        },
        data: {
            labels: null,
            datasets: [{
                label: '지역별 전체회원',
                data: null,
                backgroundColor: [
                    'rgba(30, 30, 255, 0.7)'
                ]
            }],
        }
    })

    getMemberCnt();
    
    $("#monthlyDate").change(getMemberCnt);
    // $("#babysitterRegionCnt").change(getMemberCnt);

    function getMemberCnt(chart) {
        // let region = $("#babysitterRegionCnt").find("option:selected").val();
        let date = $("#monthlyDate").find("option:selected").val();
        console.log(date);
        let url = "/api/MemberCnt?date="+date;
        $.ajax({
            type: "get",
            url: url,
            success: function (r) {
                console.log(r);
                let dataList = new Array();
                let datadata = new Array();
                for (let i = 0; i < r.data1.length; i++) {
                    dataList.push(r.data1[i].upChildCareInstNm);
                    datadata.push(r.data1[i].whlMbrCnt);
                }
                BabysitterregionMemberCntChart.data.datasets = new Array(); // 데이터 셋 초기화
                BabysitterregionMemberCntChart.data.labels = dataList; // 레이블 교체
                BabysitterregionMemberCntChart.data.datasets.push({
                    label: date+'신청현황',
                    data: datadata,
                    backgroundColor: ['rgba(255, 30, 30, 0.7)']
                });
                BabysitterregionMemberCntChart.update();
            }
        })
    }
    getMemberCnt();
})