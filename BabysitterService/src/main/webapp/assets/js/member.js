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
    var BabysitterAllChart = new Chart($("#MemberAllCnt"), {
        type:"line",
        options:{
            responsive:false,
        },
        data:{
            labels:null,
            datasets:[{
                label:'',
                data:null,
                backgroundColor:[
                    'rgba(30, 30, 255, 0.7)'
                ]
            }],
        }
    })

    getMemberCnt();
    getAllCnt();

    $("#monthlyDate").change(getMemberCnt);

    function getMemberCnt(chart) {
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
                    label: date+' 회원현황',
                    data: datadata,
                    backgroundColor: ['rgba(255, 30, 30, 0.7)']
                });
                BabysitterregionMemberCntChart.update();
            }
        })
    }
    function getAllCnt(chart) {
        let date = $("#babysitterDate").find("option:selected").val();
        console.log(date);
        let url = "/api/MemberAllCnt?date="+date;
        $.ajax({
            type:"get",
            url:url,
            success:function(r) {
                console.log(r);
                let dataList = new Array();
                let dataData = new Array();
                for(let i=0; i<r.data2.length; i++){
                    dataList.push(r.data2[i].crtrYm);
                    dataData.push(r.data2[i].whlMbrCnt);
                }
    
                BabysitterAllChart.data.datasets = new Array(); // 데이터 셋 초기화
                BabysitterAllChart.data.labels = dataList; // 레이블 교체
                BabysitterAllChart.data.datasets.push({
                    label:'월별 회원현황', 
                    data:dataData,
                    backgroundColor:['rgba(255, 30, 30, 0.7)']
                });
                BabysitterAllChart.update();
            }
        })
    }
    getMemberCnt();
    getAllCnt();
})