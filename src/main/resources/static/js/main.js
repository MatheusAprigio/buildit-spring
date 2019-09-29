$('.button-collapse').sideNav({
    menuWidth: 300,
    edge: 'left',
    closeOnClick: false,
    draggable: true
});

$(document).ready(function(){
    $('.modal').modal();
});


$(".btn-remove").click(function () {
    var id = $(this).siblings().val();
    $("#modal-id").val(id);
})
