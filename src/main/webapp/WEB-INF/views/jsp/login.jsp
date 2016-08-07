<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>

<link href="<c:url value='/static/css/app.css' />" rel="stylesheet">


  <form class="form-signin" role="form"  method="POST">
    <input type="email" name="ssoId" id="username" class="form-control" placeholder="Email" required autofocus>
    <input type="password" id="password" name="password" class="form-control" placeholder="Hasło" required>
    <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" >

    <button class="btn btn-lg btn-primary btn-block" type="submit">Zaloguj</button>
  </form>
