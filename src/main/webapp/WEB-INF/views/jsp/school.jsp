<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../tiles/layout/taglib.jsp" %>


<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
    Dodaj Przedszkole
</button>

<form:form commandName="school" cssClass="form-horizontal registrationForm">
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Nowe przedszkole</h4>
            </div>
            <div class="modal-body">

                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">Nazwa:</label>
                    <div class="col-sm-10">
                        <form:input path="name" cssClass="form-control"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">Adres:</label>
                    <div class="col-sm-10">
                        <form:input path="address" cssClass="form-control"/>
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
        <th>Przedszkola</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${schools}" var="school">

        <tr>
            <td>
                <a href="<spring:url value="/przedszkola/${school.id}.html" />">
                        ${school.name}
                </a>

            </td>
        </tr>

    </c:forEach>
    </tbody>
</table>