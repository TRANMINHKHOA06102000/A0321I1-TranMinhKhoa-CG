$(document).ready(function () {
    $(".btn-search").click(function () {
        var nameAuthor = $("#nameAuthor").val();
        $.ajax({
            type: "GET",
            url: "/?s=" + nameAuthor,
            dataType: "HTML",
            success: function (data) {
                $(".body").html(data);
            }
        });
    })
})

$(document).ready(function () {
    $(".btn-view").click(function () {
        $.ajax({
            type: "GET",
            url: "/listBlog",
            dataType: "HTML",
            success: function (data) {
                $(".body").html(data);
            }
        });
    })
})