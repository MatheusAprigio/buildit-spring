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
    $("#delete-id").val(id);
})

$(".btn-edit").click(function () {
    var id = $(this).siblings().val();
    $("#edit-id").val(id);
})
