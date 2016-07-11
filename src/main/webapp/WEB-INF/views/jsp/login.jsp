<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>

 .form-signin {
   max-width: 330px;
   padding: 15px;
   margin: 0 auto;
 }
 .form-signin .form-signin-heading,
 .form-signin .checkbox {
   margin-bottom: 10px;
 }
 .form-signin .checkbox {
   font-weight: normal;
 }
 .form-signin .form-control {
   position: relative;
   height: auto;
   -webkit-box-sizing: border-box;
      -moz-box-sizing: border-box;
           box-sizing: border-box;
   padding: 10px;
   font-size: 16px;
 }
 .form-signin .form-control:focus {
   z-index: 2;
 }
 .form-signin input[type="email"] {
   margin-bottom: -1px;
   border-bottom-right-radius: 0;
   border-bottom-left-radius: 0;
 }
 .form-signin input[type="password"] {
   margin-bottom: 10px;
   border-top-left-radius: 0;
   border-top-right-radius: 0;
 }
</style>

  <form class="form-signin" role="form"  method="POST">
    <input type="email" name="ssoId" id="username" class="form-control" placeholder="Email" required autofocus>
    <input type="password" id="password" name="password" class="form-control" placeholder="Hasło" required>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Zaloguj</button>
  </form>
