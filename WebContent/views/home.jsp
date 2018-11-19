<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="es">
    <head>
        <meta charset="utf-8">
        <title>Spring MVC Test</title>
        <link href="css/style.css" type="text/css" rel="stylesheet">
 	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular.js"></script>
    

    <title>Home</title>

    <!-- Bootstrap core CSS-->
    <link href="../resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="../resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template-->
    <link href="../resources/css/sb-admin.css" rel="stylesheet">

  </head>

  <body class="bg-dark" data-ng-app="loginApp" data-ng-controller="loginCtrl">

    <div class="container">
      <div class="card card-login mx-auto mt-5">
        <div class="card-header">BIENVENDOS</div>
        <div class="card-body">
          <form name="loginForm">
            <div class="form-group">
              <div class="form-label-group">
                <input type="email"
                 id="inputEmail"
                 class="form-control"
                 placeholder="Email address"
                 required="required"
                  autofocus="autofocus"
                  ng-model="user.email"
                  >
                <label for="inputEmail">Email address</label>
              </div>
            </div>
            <div class="form-group">
              <div class="form-label-group">
                <input type="password"
                 id="inputPassword"
                  class="form-control"
                   placeholder="Password" 
                   required="required"
                   ng-model="user.pawwsowrd">
                <label for="inputPassword">Password</label>
              </div>
            </div>
            <button class="btn btn-primary btn-block"
            ng-disabled="loginForm.$invalid"
             data-ng-click="login(user)"
             >Login</button>
          </form>
          <div class="text-center">
            <a class="d-block small mt-3" href="register.jsp">Register an Account</a>
            <a class="d-block small" href="forgot-password.html">Forgot Password?</a>
          </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="../resources/vendor/jquery/jquery.min.js"></script>
    <script src="../resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="../resources/js/controllers/loginController.js"></script>
    

    <!-- Core plugin JavaScript-->
    <script src="../resources/vendor/jquery-easing/jquery.easing.min.js"></script>

  </body>
</html>