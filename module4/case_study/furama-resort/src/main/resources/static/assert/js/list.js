$(document).ready(function () {
    $(".btn-search").click(function () {
        var nameEmployee = $("#nameEmployee").val();
        console.log(nameEmployee)
        $.ajax({
            type: "GET",
            url: "/listEmployee?s=" + nameEmployee,
            dataType: "HTML",
            success: function (data) {
                $("#searchTable").html(data);
            }
        });
    })
})

$(document).ready(function () {
    $(".btnModalView").click(function () {
        $.ajax({
            type: "GET",
            url: "view/" + $(this).next().val(),
            dataType: "HTML",
            success: function (data) {
                $(".modal-body").html(data);
                $("#modelId").modal("show")
            }
        });
    })
})

function showDelete(id) {
    $.ajax({
        type: "GET",
        url: "delete/" + id,
        dataType: "HTML",
        success: function (data) {
            $(".modal-body").html(data);
            $("#modelId").modal("show")
        }
    })
}

function actionDelete(id) {
    $.ajax({
        type: "POST",
        url: "actionDelete/" + id,
        dataType: "HTML",
        success: function (data) {
            let message="Delete succsess!!!"
            setTimeout(function () {
                $("#modelId").modal('hide')
            },2000);
            $("#searchTable").html(data)
            $(".modal-body").html(message);
        }
    })
}