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
        <title>Pedir</title>
        <!-- Bootstrap core CSS-->
        <link href="../resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom fonts for this template-->
        <link href="../resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <!-- Page level plugin CSS-->
        <link href="../resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
        <!-- Custom styles for this template-->
        <link href="../resources/css/sb-admin.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular.js"></script>
    </head>
    <body id="page-top" data-ng-app="userOrderApp" data-ng-controller="userOrderCtrl">
        <nav class="navbar navbar-expand navbar-dark bg-dark static-top">
            <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
            <i class="fas fa-bars"></i>
            </button>
            <a class="navbar-brand mr-1" href="index.html">Heladeria</a>
            <!-- Navbar Search -->
            <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
                <div class="input-group">
                    <div class="input-group-append">
                    </div>
                </div>
            </form>
            <!-- Navbar -->
            <ul class="navbar-nav ml-auto ml-md-0">
                <li class="nav-item dropdown no-arrow">
                    <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-user-circle fa-fw"></i>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                        <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Logout</a>
                    </div>
                </li>
            </ul>
        </nav>
        <div id="wrapper">
        <!-- Sidebar -->
        <ul class="sidebar navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="index.html">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>Pedir</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="charts.html">
                <i class="fas fa-fw fa-chart-area"></i>
                <span>Mis Ordenes</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="tables.html">
                <i class="fas fa-fw fa-table"></i>
                <span>xxx</span></a>
            </li>
        </ul>
        <div id="content-wrapper">
            <!-- Icon Cards-->
            <div class="row">
                <div class="col-xl-3 col-sm-6 mb-3">
                    <div class="card text-white bg-success o-hidden h-100">
                        <div class="card-body">
                            <div class="card-body-icon">
                                <i class="fas fa-fw fa-shopping-cart"></i>
                            </div>
                            <div class="mr-5">{{totalOrders}}</div>
                        </div>
                        <a class="card-footer text-white clearfix small z-1" href="#">
                        <span class="float-left">Mis ordenes Pendientes</span>
                        </a>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <form>
                        <div class="form-group">
                            <label for="formGroupExampleInput">Helados </label>
                            <select id="combo" ng-options="product as product.name for product in products" 
   									ng-model="selectedProduct" ng-change="selectProduct()"></select>
                        </div>
                        <div class="form-group">
                            <label for="formGroupExampleInput2">Gustos</label>
                            <div >
                                <button data-ng-repeat="flavour in flavours" type="button" ng-class="{'active':flavour.selectFl==true}" data-ng-click="addFlavour(flavour)" class="btn btn-outline-primary">{{flavour.name}}</button>
                            </div>
                        </div>
                        <div>
                            <button class="btn btn-secondary" data-ng-click="addItem()" type="button">Agregar</button>
                        </div>
                    </form>
                </div>
                <div class="col-md-6">
                    <form>
                        <div class="form-group">
                            <label for="formGroupExampleInput">Mi pedido </label>
                        </div>
                        <label for="">Helados </label>
                        <ul data-ng-repeat="item in itemsList">
                            <h1>{{item.product.name}}</h1>
                            <li data-ng-repeat="flav in item.flavourList">{{flav.name}}</li>
                        </ul>
                                 <div>
                            <h4>TOTAL: {{getCost()}}</h4>
                        </div>
                        <div>
                            <button class="btn btn-success" data-ng-click="createOrder()" type="button">Completar orden</button>
                        </div>
                    </form>
                </div>
            </div>
            <div>
                <footer class="sticky-footer">
                    <div class="container my-auto">
                        <div class="copyright text-center my-auto">
                            <span>Copyright © Your Website 2018</span>
                        </div>
                    </div>
                </footer>
            </div>
            <!-- /.content-wrapper -->
        </div>
        <!-- /#wrapper -->
        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
        </a>
        <!-- Bootstrap core JavaScript-->
        <script src="../resources/vendor/jquery/jquery.min.js"></script>
        <script src="../resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- Core plugin JavaScript-->
        <script src="../resources/vendor/jquery-easing/jquery.easing.min.js"></script>
        <!-- Page level plugin JavaScript-->
        <script src="../resources/vendor/chart.js/Chart.min.js"></script>
        <script src="../resources/vendor/datatables/jquery.dataTables.js"></script>
        <script src="../resources/vendor/datatables/dataTables.bootstrap4.js"></script>
        <!-- Custom scripts for all pages-->
        <script src="../resources/js/sb-admin.min.js"></script>
        <!-- Demo scripts for this page-->
        <script src="../resources/js/demo/datatables-demo.js"></script>
        <script src="../resources/js/demo/chart-area-demo.js"></script>
        <script src="../resources/js/controllers/userOrderController.js"></script>
    </body>
</html>