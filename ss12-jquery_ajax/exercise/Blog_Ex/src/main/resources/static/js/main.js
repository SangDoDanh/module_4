$(document).ready(function () {
    function init() {
        $.ajax({
            url: "http://localhost:8080/api/v1/blog",
            type: "GET",
            dataType: "json",
            success: function (data) {
                let tr = [];
                for (let a of data) {
                    tr.push("<tr>")
                    tr.push("<td>" + a.author + "</td>")
                    tr.push("<td>" + a.content + "</td>")
                    tr.push("<td>" + a.upDayStatus + "</td>")
                    tr.push("</tr>")
                }
                $("#blogs-content").append(tr.join(""));
            }
        });
    }
    // - Tìm kiếm: Người dùng nhập từ vào ô tìm kiếm, ứng dụng sẽ gửi request thông qua AJAX để
    // hiển thị danh sách các bài viết phù hợp
    $("#btn-search").click(function () {
        $("#more").hide();
        $("tbody").empty();
        $.ajax({
            url: "http://localhost:8080/api/v1/search?authorSearch=" + $("#txt-search").val(),
            type: "GET",
            dataType: "json",
            success: function (data) {
                let tr = [];
                for (let a of data) {
                    tr.push("<tr>")
                    tr.push("<td>" + a.author + "</td>")
                    tr.push("<td>" + a.content + "</td>")
                    tr.push("<td>" + a.upDayStatus + "</td>")
                    tr.push("</tr>")
                }
                $("#blogs-content").append(tr.join(""));
            }
        })
    });

    // - Tải thêm: Là tính năng thay thế cho tính năng phân trang.
    // Khi hiển thị danh sách bài viết, chỉ  hiện thị 1 bài viết,
    // sau đó, người dùng sẽ nhấn nút “Tải thêm” để xem các bài viết cũ hơn.
    $("#more").click(function () {
        let pageNumber = parseInt($("#page-number").val());
        $("#page-number").val(pageNumber + 1);
        $.ajax({
            url: "http://localhost:8080/api/v1/blog?page=" + (pageNumber + 1),
            type: "GET",
            dataType: "json",
            success: function (data) {
                let tr = [];
                if (data) {
                    for (let a of data) {
                        tr.push("<tr>")
                        tr.push("<td>" + a.author + "</td>")
                        tr.push("<td>" + a.content + "</td>")
                        tr.push("<td>" + a.upDayStatus + "</td>")
                        tr.push("</tr>")
                    }
                } else {
                    tr.push("<tr>")
                    tr.push("<td colspan='3'> No data... </td>")
                    tr.push("</tr>")
                    $("#more").hide();
                }
                $("#blogs-content").append(tr.join(""));
            }
        });
    });

    init();
})