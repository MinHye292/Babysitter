$(function(){
    var BabysitterMonthlyTimeChart = new Chart($("#monthlyRequestChart"), {
        type:"bar",
        options:{
            responsive:false,
        },
        data:{
            labels:null,
            datasets:[{
                label:'월별 시간대별 신청현황',
                data:null,
                backgroundColor:[
                    'rgba(30, 30, 255, 0.7)'
                ]
            }],
        }
    })
    $(function(){
        var BabysitterMonthlyRegionChart = new Chart($("#monthlyRegionChart"), {
            type:"bar",
            options:{
                responsive:false,
            },
            data:{
                labels:null,
                datasets:[{
                    label:'지역별 신청 현황',
                    data:null,
                    backgroundColor:[
                        'rgba(30, 30, 255, 0.7)'
                    ]
                }],
            }
        })
    getMonthly(BabysitterMonthlyTimeChart);

    $("#date").change(function(){
        let region = $("#region_select").find("option:selected").val();
        let date = $("#date").val();
        getbabysitter();
    })
    $("#monthlyDate").change(function(){
        getMonthly(BabysitterMonthlyTimeChart);
    })

    getRegion(BabysitterMonthlyRegionChart);

    $("#date").change(function(){
        let region = $("#region_select").find("option:selected").val();
        let date = $("#date").val();
        getbabysitter();
    })
    $("#monthlyDate").change(function(){
        getRegion(BabysitterMonthlyRegionChart);
    })
})

function getMonthly(chart) {
    let date = $("#monthlyDate").find("option:selected").val();
    console.log(date);
    let url = "/api/monthly?date="+date
    $.ajax({
        type:"get",
        url:url,
        success:function(r) {
            console.log(r);
            let dataList = new Array();
            dataList.push(r.list[0].hr02AplyNocs);
            dataList.push(r.list[0].hr24AplyNocs);
            dataList.push(r.list[0].hr46AplyNocs);
            dataList.push(r.list[0].hr68AplyNocs);
            dataList.push(r.list[0].hr810AplyNocs);
            dataList.push(r.list[0].hr1012AplyNocs);
            dataList.push(r.list[0].hr1214AplyNocs);
            dataList.push(r.list[0].hr1416AplyNocs);
            dataList.push(r.list[0].hr1618AplyNocs);
            dataList.push(r.list[0].hr1820AplyNocs);
            dataList.push(r.list[0].hr2022AplyNocs);
            dataList.push(r.list[0].hr2224AplyNocs);

            chart.data.datasets = new Array(); // 데이터 셋 초기화
            chart.data.labels = [
                "0-2시", "2-4시", "4-6시", "6-8시", "8-10시", "10-12시", 
                "12-14시", "14-16시", "16-18시", "18-20시", "20-22시", "22-24시"
            ]; // 레이블 교체
            chart.data.datasets.push({
                label:date+' 신청현황', 
                data:dataList,
                backgroundColor:['rgba(255, 30, 30, 0.7)']
            });
            chart.update();
        }
    })
}

function getRegion(chart) {
    let date = $("#monthlyDate").find("option:selected").val();
    console.log(date);
    let url = "/api/region?date="+date
    $.ajax({
        type:"get",
        url:url,
        success:function(r) {
            console.log(r);
            let dataList = new Array();
            let datadata = new Array();
            for(let i=0; i<r.list.length; i++){
                dataList.push(r.list[i].region);
                datadata.push(r.list[i].acc);
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

})

// function makeDateString(dt) {
//     dt.getFullYear()+"-"+leadingZero((dt.getMonth()+1))+"-"+leadingZero(dt.getDate());
// }
// function leadingZero(i) {
//     return i<10?"0"+i:""+i;
// }