$.datepicker.setDefaults({
    dateFormat: 'yy-mm-dd',
    prevText: '이전 달',
    nextText: '다음 달',
    monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    dayNames: ['일', '월', '화', '수', '목', '금', '토'],
    dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
    dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
    showMonthAfterYear: true,
    yearSuffix: '년'
});

$(function(){
    let genChart = new Chart($("#gen_chart"), {
        type:"pie",
        options:{
            responsive:false,
        },
        data:null
    })
        var BabysitterChildOldChart = new Chart($("#ChildOldChart"), {
            type:"bar",
            options:{
                responsive:false,
            },
            data:{
                labels:null,
                datasets:[{
                    label:'나이대별 실적현황',
                    data:null,
                    backgroundColor:[
                        'rgba(30, 30, 255, 0.7)'
                    ]
                }],
            }
        })
        var BabysitterTypeChart = new Chart($("#TypeChart"), {
            type:"bar",
            options:{
                responsive:false,
            },
            data:{
                labels:null,
                datasets:[{
                    label:'가정별 실적현황',
                    data:null,
                    backgroundColor:[
                        'rgba(30, 30, 255, 0.7)'
                    ]
                }],
            }
        })

    getBabysitterData();
    getChildOld(BabysitterChildOldChart);
    getType(BabysitterTypeChart);
    $("#babysitterDate").change(getBabysitterData)
    $("#babysitterRegion").change(getBabysitterData)

    function getChildOld(chart) {
        let date = $("#babysitterDate").find("option:selected").val();
        console.log(date);
        let url = "/api/childOld?date="+date;
        $.ajax({
            type:"get",
            url:url,
            success:function(r) {
                console.log(r);
                let dataList = new Array();
                dataList.push(r.list[0].age0);
                dataList.push(r.list[0].age1);
                dataList.push(r.list[0].age2);
                dataList.push(r.list[0].age3);
                dataList.push(r.list[0].age4);
                dataList.push(r.list[0].age5);
                dataList.push(r.list[0].age6);
                dataList.push(r.list[0].age7);
                dataList.push(r.list[0].age8);
                dataList.push(r.list[0].age9);
                dataList.push(r.list[0].age10);
                dataList.push(r.list[0].age11);
                dataList.push(r.list[0].age12);
    
                chart.data.datasets = new Array(); // 데이터 셋 초기화
                chart.data.labels = [
                    "0세", "1세", "2세", "3세", "4세", "5세", 
                "6세", "7세", "8세", "9세", "10세", "11세", "12세"
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
    function getType(chart) {
        let date = $("#babysitterDate").find("option:selected").val();
        console.log(date);
        let url = "/api/type?date="+date;
        $.ajax({
            type:"get",
            url:url,
            success:function(r) {
                console.log(r);
                let dataList = new Array();
                dataList.push(r.list[0].atype);
                dataList.push(r.list[0].btype);
                dataList.push(r.list[0].ctype);
                dataList.push(r.list[0].dtype);
    
                chart.data.datasets = new Array(); // 데이터 셋 초기화
                chart.data.labels = [
                    "가형", "나형", "다형", "라형"
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
    function getBabysitterData(){
        let date = $("#babysitterDate").find("option:selected").val();
        let region = $("#babysitterRegion").find("option:selected").val();
        $.ajax({
            url:"/api/acc_cnt?region="+region+"&date="+date,
            type:"get",
            success:function(r) {
                $("#acc").html(r);
            }
        })

        $.ajax({
            type:"get",
            url:"/api/childGen?region="+region+"&date="+date,
            success:function(r) {
                console.log(r);
                // 가져온 결과 값이 이미 sql 단계에서 합산된 결과니까
                // 여기에서 합산같은 동작을 따로 하지 않고
                // let boy = new Array();
                // let girl = new Array();
                // for(let i=0; i<r.data.length; i++) {
                //     boy.push(r.data[i].boyacc),
                //     girl.push(r.data[i].girlacc)
                // }
                
                genChart.data.datasets = new Array(); // 데이터 셋 초기화
                genChart.data.labels = ['남아', '여아']; // 레이블 교체
                genChart.data.datasets.push({
                    label:'', 
                    // 바로 결과값을 데이터로 사용합니다.
                    data:[r.data.boyacc,r.data.girlacc],
                    backgroundColor:['rgba(30, 30, 255, 0.7)','rgba(255, 30, 30, 0.7)']
                });
                genChart.update();
            }
        });
        getChildOld(BabysitterChildOldChart);
        getType(BabysitterTypeChart);
    }
})
