<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../tiles/layout/taglib.jsp" %>

<link href="<c:url value='/static/css/app.css' />" rel="stylesheet">
<script src="<c:url value="/static/js/app.js" />"></script>

<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
    Dodaj instruktora
</button>

<form:form commandName="employee" cssClass="form-horizontal registrationForm">
    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Nowy instruktor</h4>
                </div>
                <div class="modal-body">

                    <div class="form-group">
                        <label id="name" for="name" class="col-sm-2 control-label">Imię:</label>
                        <div class="col-sm-10">
                            <form:input path="firstName" cssClass="form-control"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">Nazwisko:</label>
                        <div class="col-sm-10">
                            <form:input path="lastName" cssClass="form-control"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">Email:</label>
                        <div class="col-sm-10">
                            <form:input path="email" cssClass="form-control"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">Hasło:</label>
                        <div class="col-sm-10">
                            <form:input path="password" cssClass="form-control"/>
                        </div>
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Anuluj</button>
                    <input type="submit" class="btn btn-primary" value="Zapisz" />
                </div>
            </div>
        </div>
    </div>
</form:form>

<br />

<table class="table table-bordered table-hover table-striped">
    <thead>
        <tr>
            <th>Imię i nazwisko</th>
            <th>Operacje</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${employees}" var="employee" varStatus="emIndex">

            <tr>
                <td>
                    <a href="<spring:url value="/instruktorzy/${employee.id}.html" />">
                        ${employee.firstName} ${employee.lastName}
                    </a>
                </td>

                <td>
                    <div class="dropdown bttn-left">
                        <button id="dLabel" class="btn btn-primary"  type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Przypisz przedszkole
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" aria-labelledby="dLabel">
                            <c:forEach items="${schools}" var="school" varStatus="index">
                                <li>
                                    <a onclick="addSchool(${index.count}, ${emIndex.count})">
                                        ${school.name}
                                        <input type="text"  id="employee${emIndex.count}"  value="${employee.id}">
                                        <input type="text"  id="school${index.count}"  value="${school.id}">
                                    </a>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                    <a href="<spring:url value="/instruktorzy/remove/${employee.id}.html" />" class="btn btn-danger bttn-right">Usuń</a>
                </td>
            </tr>

        </c:forEach>
    </a>
    </tbody>
</table>
