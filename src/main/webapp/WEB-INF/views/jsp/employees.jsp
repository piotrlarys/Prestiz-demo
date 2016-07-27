<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../tiles/layout/taglib.jsp" %>

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
                        <label for="name" class="col-sm-2 control-label">Imię:</label>
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
        <c:forEach items="${employees}" var="employee">

            <tr>
                <td>
                    <a href="<spring:url value="/instruktorzy/${employee.id}.html" />">
                        ${employee.firstName} ${employee.lastName}
                    </a>
                </td>
                <td>
                    <a href="<spring:url value="/instruktorzy/delete/${employee.id}" />" class="btn btn-primary">Dodaj przedszkole</a>
                    &nbsp&nbsp
                    <a href="<spring:url value="/instruktorzy/remove/${employee.id}.html" />" class="btn btn-danger">Usuń</a>
                </td>
            </tr>

        </c:forEach>
    </a>
    </tbody>
</table>
