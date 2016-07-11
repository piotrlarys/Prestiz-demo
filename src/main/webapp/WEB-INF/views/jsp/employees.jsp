<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 28.06.16
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../tiles/layout/taglib.jsp" %>

<table class="table table-bordered table-hover table-striped">
    <thead>
        <tr>
            <th>Instruktorzy</th>

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
            </tr>

        </c:forEach>
    </a>
    </tbody>
</table>
