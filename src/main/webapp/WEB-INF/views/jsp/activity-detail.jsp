<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../tiles/layout/taglib.jsp" %>

<h1>${activity.name}</h1>

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

<table class="table table-bordered table-hover table-striped">
    <thead>
    <tr>
        <th>Imię i nazwisko</th>
        <th>Klasa</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${activity.students}" var="student">

        <tr>
            <td>
                ${student.firstName} ${student.lastName}
            </td>
            <td>
                ${student.studentClass}
            </td>
        </tr>


    </c:forEach>
    </tbody>
</table>
