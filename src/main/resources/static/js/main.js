$('.button-collapse').sideNav({
    menuWidth: 300,
    edge: 'left',
    closeOnClick: false,
    draggable: true
});

$(document).ready(function(){
    $('.modal').modal();

    document.addEventListener('DOMContentLoaded', function() {
        var elems = document.querySelectorAll('select');
        var instances = M.FormSelect.init(elems, options);
    });
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

$(".edit-product").click(function () {
    var picture = $(this).closest("tr").find('td:eq(0) > img').attr("src");

    $("#picture").val(picture)
    picture == "" ? picture = "/image/no-image.svg" : null;
    $("#img-product").attr("src", picture);

    var userName = $(this).closest("tr").find('td:eq(1)').text();
    $("#sku").val(userName);

    var email = $(this).closest("tr").find('td:eq(2)').text();
    $("#name").val(email)

    var userName = $(this).closest("tr").find('td:eq(3)').text();
    $("#description").val(userName);

    var userName = $(this).closest("tr").find('td:eq(5)').text();
    $("#measure").val(userName);

    var userName = $(this).closest("tr").find('td:eq(6)').text();
    $("#unitPrice").val(userName);
});