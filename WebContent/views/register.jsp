<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Register</title>

    <!-- Bootstrap core CSS-->
    <link href="../resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="../resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template-->
    <link href="../resources/css/sb-admin.css" rel="stylesheet">
    
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular.js"></script>
    

  </head>

  <body class="bg-dark" data-ng-app="registerApp" data-ng-controller="registerCtrl">

    <div class="container">
      <div class="card card-register mx-auto mt-5">
        <div class="card-header">Register an Account</div>
        <div class="card-body">
          <form name="registerForm">
            <div class="form-group">
              <div class="form-row">
                <div class="col-md-6">
                  <div class="form-label-group">
                    <input type="text"
                     id="firstName"
                      class="form-control"
                       placeholder="Nombre"
                        required="required"
                         autofocus="autofocus"
                         ng-model="user.name"
                         >
                    <label for="firstName">Nombre</label>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-label-group">
                    <input type="text" 
                    id="address"
                     class="form-control"
                      placeholder="Direccion"
                       required="required"
                       ng-model="user.address"
                       >
                    <label for="address">Direccion</label>
                  </div>
                </div>
              </div>
            </div>
            <div class="form-group">
              <div class="form-label-group">
                <input type="email"
                 id="inputEmail"
                  class="form-control"
                   placeholder="Direccion e-mail"
                    required="required"
                    ng-model="user.email"
                    >
                <label for="inputEmail">Direccion e-mail</label>
              </div>
            </div>
            <div class="form-group">
              <div class="form-row">
                <div class="col-md-6">
                  <div class="form-label-group">
                    <input type="text"
                     id="inputText"
                      class="form-control" 
                      placeholder="Telefono"
                       required="required"
                       ng-model="user.phone"
                       >
                    <label for="inputPassword">Telefono</label>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-label-group">
                    <input type="password" 
                    id="confirmPassword" 
                    class="form-control"
                     placeholder="Contrase�a" 
                     required="required"
                     ng-model="user.password">
                    <label for="confirmPassword">Contrase�a</label>
                  </div>
                </div>
              </div>
            </div>
            <button  class="btn btn-primary btn-block"
             ng-disabled="registerForm.$invalid"
              data-ng-click="register(user)"
              >
              Register</button>
          </form>
          <div class="text-center">
            <a class="d-block small mt-3" href="login.jsp">Login Page</a>
          </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="../resources/vendor/jquery/jquery.min.js"></script>
    <script src="../resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="../resources/vendor/jquery-easing/jquery.easing.min.js"></script>
    <script src="../resources/js/controllers/registerController.js"></script>

  </body>

</html>