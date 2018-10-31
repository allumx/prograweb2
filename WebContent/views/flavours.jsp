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
      <title>Gustos</title>
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
   <body id="page-top" data-ng-app="flavoursApp" data-ng-controller="flavoursCtrl">
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
            <li class="nav-item ">
               <a class="nav-link" href="index.html">
               <i class="fas fa-fw fa-tachometer-alt"></i>
               <span>Ordenes</span>
               </a>
            </li>
            <li class="nav-item">
               <a class="nav-link" href="charts.html">
               <i class="fas fa-fw fa-chart-area"></i>
               <span>Usuarios</span></a>
            </li>
            <li class="nav-item active">
               <a class="nav-link" href="tables.html">
               <i class="fas fa-fw fa-table"></i>
               <span>Gustos</span></a>
            </li>
         </ul>
         <div id="content-wrapper">
            <!-- Icon Cards-->
            <!-- DataTables Example -->
            <div class="card mb-3">
               <div class="card-header">
               
                  <i class="fas fa-table"></i>
                  Gustos
                  <button class="btn btn-success" data-toggle="modal" data-target="#addModal"  data-ng-click="" type="button">Agregar</button>
                  
               </div>
               
               <div class="card-body">
                  <div class="table-responsive">
                  
                     <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                           <tr>
                              <th>Nro(id)</th>
                              <th>Nombre</th>
                              <th>Precio venta</th>
                              <th>Precio costo</th>
                              <th>Acciones</th>
                           </tr>
                        </thead>
                        <tfoot>
                           <tr>
                              <th>Nro(id)</th>
                              <th>Nombre</th>
                              <th>Precio venta</th>
                              <th>Precio costo</th>
                              <th>Acciones</th>
                           </tr>
                        </tfoot>
                        <tbody data-ng-repeat="flavour in flavours">
                           <tr>
                              <td>{{flavour.id}}</td>
                              <td>{{flavour.name}}</td>
                              <td>{{flavour.salePrice}}</td>
                              <td>{{flavour.costPrice}}</td>
                              <td>
                                 <button data-ng-click="getFlavour(flavour.id)" type="button" class="btn btn-info">Editar</button>
                                 <button data-ng-click="deleteFlavour(flavour.id)" class="btn btn-danger">Eliminar</button>
                              </td>
                           </tr>
                        </tbody>
                     </table>
                  </div>
               </div>
            </div>
         </div>
         <!-- /.container-fluid -->
         <!-- Sticky Footer -->
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
      <!-- Logout Modal-->
      <div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
         <div class="modal-dialog" role="document">
            <div class="modal-content">
               <div class="modal-header">
                  <h5 class="modal-title" id="exampleModalLabel" >Editar gusto</h5>
                  <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">×</span>
                  </button>
               </div>
               <div class="modal-body">
               	  <div>
                  <label for="">Nombre: </label>
                  <p>actual: {{flavour.name}}</p>
                  <input ng-model="newFlavour.name" type="text"></input>
                  </div>
                  
                  <div>
                  <label for="">Precio de venta: </label>
                  <p>actual: {{flavour.salePrice}}</p>
                  <input ng-model="newFlavour.salePrice" type="number"></input>
                  </div>
                  
                  <div>
                  <label for="">Costo: </label>
                  <p>actual: {{flavour.costPrice}}</p>
                  <input ng-model="newFlavour.costPrice" type="number"></input>
                  </div>
               
               </div>
               <div class="modal-footer">
                  <button class="btn btn-success" data-ng-click="editFlavour(newFlavour)" type="button">Modificar</button>
               </div>
            </div>
         </div>
      </div>
      
            <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
         <div class="modal-dialog" role="document">
            <div class="modal-content">
               <div class="modal-header">
                  <h5 class="modal-title" id="exampleModalLabel" >Editar gusto</h5>
                  <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">×</span>
                  </button>
               </div>
              <form name="flavourForm">
               <div class="modal-body">
               	  <div>
                  <label for="">Nombre: </label>
                  <input ng-model="newFlavour.name" required="required" type="text"></input>
                  </div>                  
                  <div>
                  <label for="">Precio de venta: </label>
                  <input ng-model="newFlavour.salePrice" required="required" type="number"></input>
                  </div>
                  
                  <div>
                  <label for="">Costo: </label>
                  <input ng-model="newFlavour.costPrice"  required="required" type="number"></input>
                  </div>
               
               </div>
               <div class="modal-footer">
                  <button class="btn btn-success" data-ng-click="addFlavour(newFlavour)"  ng-disabled="flavourForm.$invalid" type="button">Agregar</button>
               </div>
                         </form>

            </div>
         </div>
      </div>
      
      
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
      <script src="../resources/js/controllers/flavoursController.js"></script>
   </body>
</html>