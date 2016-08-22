<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 28.06.16
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
<head>

    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
          integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
            integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
            crossorigin="anonymous"></script>

    <title><tiles:getAsString name="title"/></title>
</head>
<body>

<%@taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>

<tilesx:useAttribute name="current" />

<div class="container">
    <!-- Static navbar -->
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                        aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href='<spring:url value="/"/>'>Prestiż</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="${current == 'index' ? 'active' : ''}"><a href='<spring:url value="/"/>'>Strona główna</a></li>
                    <security:authorize access="hasAnyRole('ROLE_ADMIN')">
                        <li class="${current == 'schools' ? 'active' : ''}"><a href="<spring:url value="/przedszkola.html"/>">Przedszkola</a></li>
                    </security:authorize>
                    <security:authorize access="hasAnyRole('ROLE_ADMIN')">
                        <li class="${current == 'employees' ? 'active' : ''}"><a href="<spring:url value="/instruktorzy.html"/>">Instruktorzy</a></li>
                    </security:authorize>
                    <security:authorize access="hasAnyRole('ROLE_EMPLOYEE')">
                        <li class="${current == 'employee' ? 'active' : ''}"><a href="<spring:url value="/zajecia.html"/>">Zajęcia</a></li>
                    </security:authorize>
                    <li><a href="#">Contact</a></li>

                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <security:authorize access="! isAuthenticated()">
                        <li class="${current == 'login' ? 'active' : ''}"><a href='<spring:url value="/login.html" />'>Zaloguj</a></li>
                    </security:authorize>
                    <security:authorize access="isAuthenticated()">
                        <li><a href='<spring:url value="/logout.html" />'>Wyloguj</a></li>
                    </security:authorize>
                </ul>
            </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
    </nav>


    <tiles:insertAttribute name="body"/>

    <br><br>
    <center>
        <tiles:insertAttribute name="footer"/>
    </center>
</div>
</body>
</html>
