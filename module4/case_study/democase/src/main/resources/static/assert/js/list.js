$(document).ready(function () {
    $(".btn-search").click(function () {
        var s = $("#s").val();
        console.log(s)
        $.ajax({
            type: "GET",
            url: "/?s=" + s,
            dataType: "HTML",
            success: function (data) {
                $("#searchTable").html(data);
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
            let message = "Delete succsess!!!"
            setTimeout(function () {
                $("#modelId").modal("hide")
            }, 1000);
            $("#searchTable").html(data)
            $(".modal-body").html(message);
        }
    })
}