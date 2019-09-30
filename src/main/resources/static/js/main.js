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
});

$(".btn-edit").click(function () {
    var id = $(this).siblings().val();
    $("#edit-id").val(id);
});

$(".edit-admin").click(function () {
    var AdminName = $(this).closest("tr").find('td:eq(0)').text();
    $("#name").val(AdminName);

    var email = $(this).closest("tr").find('td:eq(1)').text();
    $("#email").val(email)
});