$(function(){
    let current = 0;
    let totalPage = 0;
    $.ajax({
        type:"get",
        url:"/api/provider",
        success:function(r){
            console.log(r);
            totalPage = Math.ceil(r.list.length/15); // 15개씩 표시하는 페이지의 수
            for(let i=0; i<totalPage; i++) {
                // 페이지 수 만큼 tbody 생성
                $(".provider_table").append('<tbody class="provider_tbody"></tbody>');
            }
            // seq: 1, childCareInstNm: "강원 강릉시 강릉어린이집연합회", addr: "강원도 강릉시 포남동"
            $(".provider_table tbody").html("");
            for(let i=0; i<r.list.length;i++){
                let tag = 
                    '<tr>'+
                        '<td>'+r.list[i].seq+'</td>'+
                        '<td><a href="/sitter?seq='+r.list[i].seq+'">'+r.list[i].childCareInstNm+'</a></td>'+
                        '<td>'+r.list[i].addr+'</td>'+
                    '<tr>';
                // 0~14 : 0 / 15~29 : 1
                let page = Math.floor(i/15); // 현재 데이터가 배치되어야 할 tbody의 번호 계산
                $(".provider_table .provider_tbody").eq(page).append(tag);
            }
            // 모든 tbody 안보이게 처리
            $(".provider_table .provider_tbody").css("display", "none");
            // 첫번째 tbody만 보이게 처리
            $(".provider_table .provider_tbody").eq(0).css("display", "table-row-group");
            // 페이저의 숫자 설정
            $(".current").html(current+1);
            $(".total").html(totalPage);
        }
    })

    $("#prev").click(function(){
        current--;
        if(current < 0) current = 0;
        $(".provider_table .provider_tbody").css("display", "none");
        $(".provider_table .provider_tbody").eq(current).css("display", "table-row-group");
        $(".current").html(current+1);
        $(".total").html(totalPage);
    })
    $("#next").click(function(){
        current++;
        if(current >= totalPage) current = totalPage-1;
        $(".provider_table .provider_tbody").css("display", "none");
        $(".provider_table .provider_tbody").eq(current).css("display", "table-row-group");
        $(".current").html(current+1);
        $(".total").html(totalPage);
    })
})