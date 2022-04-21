$(function(){
    $(".main_menu, .sub").mouseover(function(){
        $(".sub").addClass("show")
    })
    $(".main_menu, .sub").mouseout(function(){
        $(".sub").removeClass("show")
    })
})