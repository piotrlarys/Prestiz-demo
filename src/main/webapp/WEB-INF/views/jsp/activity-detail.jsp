<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../tiles/layout/taglib.jsp" %>

<div>

    <!-- Nav tabs -->
    <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Obecności</a></li>
        <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">Płatności</a></li>
        <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">Notatki</a></li>
    </ul>

    <!-- Tab panes -->
    <div class="tab-content">
        <div role="tabpanel" class="tab-pane active" id="Obecności"> </div>
        <div role="tabpanel" class="tab-pane" id="Płatności"> </div>
        <div role="tabpanel" class="tab-pane" id="Notatki"> </div>

    </div>

</div>

<script>
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
</script>

<br />

<form>
    <c:forEach items="${months}" var="month" varStatus="index">
        <input type="checkbox" name="col${index.count}" checked="checked" />${month.name}
    </c:forEach>
</form>

<br />

<div class="table-responsive">
<table class="table table-bordered table-hover table-sm table-striped-column">
    <thead>
    <tr>
        <th colspan="3">${activity.name}</th>

        <c:forEach items="${months}" var="month" varStatus="index">
            <th colspan="${month.day.size()}" class="col${index.count}">${month.name}</th>
        </c:forEach>
    </tr>
    <tr>
        <th>Nr</th>
        <th>Imię i nazwisko</th>
        <th>Klasa</th>

        <c:forEach items="${months}" var="mounth" varStatus="index">
            <c:forEach items="${mounth.day}" var="attendance">
                <th class="col${index.count}">${attendance}</th>
            </c:forEach>
        </c:forEach>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${activity.students}" var="student" varStatus="index">

        <tr>
            <td style="width: 40px">
                ${index.count}
            </td>
            <td style="width: 150px">
                ${student.firstName} ${student.lastName}
            </td>
            <td style="width: 50px">
                ${student.studentClass}
            </td>

            <c:forEach items="${months}" var="mounth" varStatus="index">
                <c:forEach items="${mounth.day}" var="attendance">
                    <th class="col${index.count}"><input type="checkbox"></th>
                </c:forEach>
            </c:forEach>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>





