function getListAuthor() {
    console.log("call");
    var nameAuthor = $("#nameAuthor").val();
    console.log(nameAuthor);
    $.ajax({
        url: "/list",
        // data: JSON.stringify(json),
        data: {nameAuthor: nameAuthor},
        type: 'get',
        dataType: 'json',
        success: function (response) {
            console.log(response);
            var result = '';
            for (let i = 0; i < response.length; i++) {
                result += `<tr>
                    <td>${response[i].author}</td>
                    <td>${response[i].content}</td>
                    <td>${response[i].createDate}</td>
                    <td>${response[i].title}</td>
                    <td>${response[i].category.categoryName}</td>
                    <td><a href="/id/view(id=${response[i].id})">View</a></td>
                    <td><a href="/edit/${response[i].id}">Edit</a></td>
                    <td><a href="/delete/${response[i].id}">Delete</a></td>
                </tr>`;
            }
            $("#result").html(result);
        }
    });
}

function getList() {
    $.ajax({
        url: "/listBlog",
        type: 'get',
        dataType: 'json',
        success: function (response) {
            var result = '';
            for (let i = 0; i < response.length; i++) {
                result += `<tr>
                    <td>${response[i].author}</td>
                    <td>${response[i].content}</td>
                    <td>${response[i].createDate}</td>
                    <td>${response[i].title}</td>
                    <td>${response[i].category.categoryName}</td>
                    <td><a href="/id/view(id=${response[i].id})">View</a></td>
                    <td><a href="/edit/${response[i].id}">Edit</a></td>
                    <td><a href="/delete/${response[i].id}">Delete</a></td>
                </tr>`;
            }
            $("#result").html(result);
        }
    });
}