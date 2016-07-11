<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../tiles/layout/taglib.jsp" %>

<h1>${employee.firstName} ${employee.lastName}</h1>
${employee.phone}

<table class="table table-bordered table-hover table-striped">
    <thead>
    <tr>
        <th>Zajęcia</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${employee.schools}" var="school">

        <tr>
            <td>
                <a href="<spring:url value="/przedszkole/${school.id}.html" />">
                        ${school.name}
                </a>

            </td>
        </tr>

    </c:forEach>
    </tbody>
</table>