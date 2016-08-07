//activity-detail: dynamic table
$(document).ready(function() {
    $('input[type="checkbox"]').click(function() {
        var index = $(this).attr('name').substr(3);
        index--;
        $('table tr').each(function() {
            //$('td:eq(' + index + ')',this).toggle();
        });
        $('th.' + $(this).attr('name')).toggle();
    });
});

function addSchool(schoolId, employeeId) {

    var schoolData = {
        "employeeId": $("#employee"+employeeId).val(),
        "schoolId": $("#school"+schoolId).val(),
        "index": $("#index"+schoolId).val()
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
            $("#link"+data).remove();
            alert("Przypisano przedszkole !");
        }
    });
}

