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
    var adminName = $(this).closest("tr").find('td:eq(0)').text();
    $("#name").val(adminName);

    var email = $(this).closest("tr").find('td:eq(1)').text();
    $("#email").val(email)
});

$(".edit-user").click(function () {
    var userName = $(this).closest("tr").find('td:eq(0)').text();
    $("#name").val(userName);

    var email = $(this).closest("tr").find('td:eq(1)').text();
    $("#email").val(email)
});