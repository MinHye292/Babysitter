$(function(){
    function getMap() {
        let url = "/api/map";
        $.ajax({
            type:"get",
            url:url,
            success:function(r) {
                console.log(r);
                if(r.status == false) {
                    $("#ctpvNm").html("-");
                    $("#childCareInstNm").html("-");
                    $("#rprsTelno").html("-");
                    $("#drtlnTelno").html("-");
                    $("#fxno").html("-");
                    $("#zip").html("-");
                    $("#addr").html("-");
                    $("#lot").html("-");
                    $("#lat").html("-");
                    return;
                }
                $("#ctpvNm").html(r.formatterctpvNm);
                $("#childCareInstNm").html(r.formatterchildCareInstNm);
                $("#rprsTelno").html(r.formatterrprsTelno);
                $("#drtlnTelno").html(r.formatterdrtlnTelno);
                $("#fxno").html(r.formatterfxno);
                $("#zip").html(r.formatterzip);
                $("#addr").html(r.formatteraddr);
                $("#lot").html(r.formatterlot);
                $("#lat").html(r.formatterlat);
            }
        })
    }
})