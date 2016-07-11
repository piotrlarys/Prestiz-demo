<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../tiles/layout/taglib.jsp" %>

<h1>${school.name}</h1>

<table class="table table-bordered table-hover table-striped">
    <thead>
    <tr>
        <th>Zajęcia</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${school.activities}" var="activity">

        <tr>
            <td>
                <a href="<spring:url value="/zajecia/${activity.id}.html" />">
                    ${activity.name}
                </a>

            </td>
        </tr>

    </c:forEach>
    </tbody>
</table>
