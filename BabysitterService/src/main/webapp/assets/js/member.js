$(function(){
        var BabysitterregionMemberCntChart = new Chart($("#regionMemberCnt"), {
            type:"bar",
            options:{
                responsive:false,
            },
            data:{
                labels:null,
                datasets:[{
                    label:'지역별 전체회원',
                    data:null,
                    backgroundColor:[
                        'rgba(30, 30, 255, 0.7)'
                    ]
                }],
            }
        })
        getMemberCnt(BabysitterregionMemberCntChart);
        $("#babysitterDate").change(getBabysitterData);
        $("#babysitterRegionCnt").change(getBabysitterData);

        function getMemberCnt(chart) {
            let region = $("#babysitterRegionCnt").find("option:selected").val();
            let date = $("#babysitterDate").find("option:selected").val();
            console.log(date);
            let url = "/api/member?region="+region+"&date="+date;
            $.ajax({
                type:"get",
                url:url,
                success:function(r) {
                    let dataList = new Array();
                    let datadata = new Array();
                    for(let i=0; i<r.list.length; i++){
                        dataList.push(r.list[i].upChildCareInstNm);
                        datadata.push(r.list[i].whlMbrCnt);
                    }
                    chart.data.datasets = new Array(); // 데이터 셋 초기화
                    chart.data.labels = dataList; // 레이블 교체
                    chart.data.datasets.push({
                        label:date+' 신청현황', 
                        data:datadata,
                        backgroundColor:['rgba(255, 30, 30, 0.7)']
                    });
                    chart.update();
                }
            })
        }
        getChildOld(BabysitterregionMemberCntChart);
    }
})