<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../tiles/layout/taglib.jsp" %>

<h1>${employee.firstName} ${employee.lastName}</h1>
${employee.phone}

<br/>
<br/>

<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
    Przypisz przedszkole
</button>

<form:form commandName="school" cssClass="form-horizontal registrationForm">
    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Przypisz przedszkole</h4>
                </div>
                <div class="modal-body">


                    <c:forEach items="${schools}" var="school">
                            <div class="form-group">
                                <label id="id" for="id" class="col-sm-2 control-label">Przedszkole:</label>
                                <div class="col-sm-10">
                                    <div>
                                        <form:hidden path="id" cssClass="form-control" value="${school.id}" />
                                        ${school.name} <form:checkbox path="checked"/>
                                    </div>
                                </div>
                            </div>
                    </c:forEach>


                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Anuluj</button>
                    <input type="submit" class="btn btn-primary" value="Zapisz" />
                </div>
            </div>
        </div>
    </div>
</form:form>

<br/>
<br/>

<table class="table table-bordered table-hover table-striped">
    <thead>
    <tr>
        <th>Zajęcia</th>
        <th>Operacje</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${employee.schools}" var="school">

        <tr>
            <td>
                <a href="<spring:url value="/zajecia/przedszkole/${school.id}.html" />">
                        ${school.name}
                </a>
            </td>
            <td>
                <a href="<spring:url value="/instruktorzy/przedszkole/remove/${school.id}.html" />" class="btn btn-danger">Usuń</a>
            </td>
        </tr>

    </c:forEach>
    </tbody>
</table>