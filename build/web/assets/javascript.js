$(document).ready(function () {

    var id;
    var url;
    $("#button").click(function () {
        id = ($(this).val());
        console.log("id is: " + id);
        url = "http://localhost:8080/ExamPrep_REST_API/Servlet?id=" + id;
        console.log("url is: " + url);
        var data;
        $.ajax({
            url: url,
            method: "GET",
            success: function (data) {
                console.log(data);
                fillTable(data);
            }
        });


    });
});

function fillTable(input) {
    input.forEach(function (element) {
        $("#table").append("<tr>" + "<td>" + element.code + "</td>" + "<td>" + element.name + "</td>" + "<td>" + element.continent + "</td>" + "</td>" + "<td>" + element.capital + "</tr>");
    });
}