// jQuery(document).ready(function($) {
//
//     $('.dropdown-toggle').dropdown('toggle');
//     //$('#msg').html("This is updated by jQuery")
//
//
// });

function addSchool(schoolid, employeeId) {

    var schoolData = {
        "employeeId": $("#employee"+employeeId).val(),
        "schoolId": $("#school"+schoolid).val()
    }

    $(function () {
    
        var token = $("input[name='_csrf']").val();
        var header = "X-CSRF-TOKEN";
        $(document).ajaxSend(function(e, xhr, options) {
            xhr.setRequestHeader(header, token);
        });
    });
    $.ajax({
        type: "POST",
        contentType : 'application/json; charset=utf-8',
        dataType : 'html',
        url: "/instruktorzy/addschool.html",
        data: JSON.stringify(schoolData), // Note it is important
        success : function(data) {
            console.log("Hello");
        }
    });
}

