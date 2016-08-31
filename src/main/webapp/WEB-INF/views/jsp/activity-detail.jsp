    <%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <%@ include file="../tiles/layout/taglib.jsp" %>
    <script src="<c:url value="/static/js/app.js" />"></script>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet">


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

    <br />

    <form>
        <c:forEach items="${months}" var="month" varStatus="index">
        <input type="checkbox" name="col${index.count}" checked="checked" />${month.name}
    </c:forEach>
</form>

<br />

<div class="table-responsive" id="dataTable">
    <p align='center'>
        <table class="table table-bordered table-hover table-sm table-striped-column padding">
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
                <c:forEach items="${mounth.mapDays}" var="attendance">
                <th class="col${index.count}">${attendance['key']}<input class="dateInput" hidden  value="${attendance['value']}"></th>
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
        <c:forEach items="${mounth.mapDays}" var="attendance">
        <th class="col${index.count}">
            <button class="student${student.id} button-white" value="${attendance['value']}" 
            onclick="savePresence(${student.id}, '${attendance['value']}')"/>
        </th>
    </c:forEach>
</c:forEach>
</tr>
</c:forEach>
</tbody>
</table>
</p>
<input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" >
</div>

<script>

    function comparePresences() {

        <c:forEach items="${activity.students}" var="student" varStatus="index">
        <c:forEach items="${student.presences}" var="presence" varStatus="index">
        $('.student${student.id}').map(function(index) {
           
         if (this.value == '${presence.date}'){
          
            if (${presence.presence}) {
                $(this).removeClass('button-white').addClass('button-green');
            }
            if (!${presence.presence}) {
                $(this).removeClass('button-white').addClass('button-red');
            }
        }
    });
    </c:forEach>
</c:forEach>

}
window.onload=comparePresences;

</script>
