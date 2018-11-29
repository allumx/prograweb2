<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Ordenes</title>

<!-- Bootstrap core CSS-->
<link href="../resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom fonts for this template-->
<link href="../resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">

<!-- Page level plugin CSS-->
<link href="../resources/vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="../resources/css/sb-admin.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular.js"></script>


</head>


<body id="page-top" data-ng-app="orderApp"
	data-ng-controller="orderCtrl">

	<nav class="navbar navbar-expand navbar-dark bg-dark static-top">
		<button class="btn btn-link btn-sm text-white order-1 order-sm-0"
			id="sidebarToggle" href="#">
			<i class="fas fa-bars"></i>
		</button>

		<a class="navbar-brand mr-1" href="index.html">Heladeria</a>

		<!-- Navbar Search -->
		<form
			class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
			<div class="input-group">
				<div class="input-group-append"></div>
			</div>
		</form>

		<!-- Navbar -->
		<ul class="navbar-nav ml-auto ml-md-0">
			<li class="nav-item dropdown no-arrow"><a
				class="nav-link dropdown-toggle" href="#" id="userDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fas fa-user-circle fa-fw"></i>
			</a>
				<div class="dropdown-menu dropdown-menu-right"
					aria-labelledby="userDropdown">
					<a class="dropdown-item" href="#" data-toggle="modal"
						data-target="#logoutModal">Logout</a>
				</div></li>
		</ul>

	</nav>

	<div id="wrapper">

		<!-- Sidebar -->
		<ul class="sidebar navbar-nav">
			<li class="nav-item active"><a class="nav-link"
				href="index.html"> <i class="fas fa-fw fa-tachometer-alt"></i> <span>Ordenes</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="charts.html">
					<i class="fas fa-fw fa-chart-area"></i> <span>Usuarios</span>
			</a></li>
			<li class="nav-item"><a class="nav-link"
				href="http://localhost:8080/PW2SpringMVCBase/views/flavours.jsp">
					<i class="fas fa-fw fa-table"></i> <span>Gustos</span>
			</a></li>
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
							<span class="float-left">Ordenes Pendientes</span>

						</a>
					</div>
				</div>
				<div class="col-xl-3 col-sm-6 mb-3">
					<div class="card text-white bg-warning o-hidden h-100">
						<div class="card-body">
						<div ng-if="totalProfit >0">TOTAL RECAUDADO:</div>	
							<div class="card-body-icon">
							
								<i class="fas fa-fw fa-list"></i>
							</div>
							<div class="mr-5">{{ totalProfit | currency }}</div>
						</div>
						<a class="card-footer text-white clearfix small z-1" href="#">
							<span class="float-left">
							<input type="date" ng-model="from" />	
								 <input type="date" ng-model="to" />
						</span>
						 <span class="float-right">
								<button type="button" 
								class="btn-secondary"
								ng-click="filterByDate(from, to)">Filtrar</button>
						</span>

						</a>
					</div>
				</div>
			</div>

			<!-- DataTables Example -->
			<div class="card mb-3">
				<div class="card-header">
					<i class="fas fa-table"></i> Ordenes
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<table class="table table-bordered" id="dataTable" width="100%"
							cellspacing="0">
							<thead>
								<tr>
									<th>Nro order(id)</th>
									<th>Usuario</th>
									<th>Estado</th>
									<th>total</th>
									<th>Acciones</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th>Nro order(id)</th>
									<th>Usuario</th>
									<th>Estado</th>
									<th>total</th>
									<th>Acciones</th>
								</tr>
							</tfoot>
							<tbody data-ng-repeat="order in orders">
								<tr>
									<td>{{order.id}}</td>
									<td>{{order.user.name}}</td>
									<td>{{order.orderState}}</td>
									<td>{{order.total}}</td>
									<td>
										<button data-ng-click="getOrder(order.id)" type="button"
											class="btn btn-info">Info</button>
										<button data-ng-click="changeOrderState(order.id)"
											type="button" class="btn btn-success">Completar</button>
										<button data-ng-click="deleteOrder(order.id)"
											class="btn btn-danger">Eliminar</button>
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
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Informacion de
						la orden</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">
					<label for="">nro Orden: </label> {{selectedOrder.id}}
					</p>
					<label for="">Items: </label>
					<ul data-ng-repeat="item in selectedOrder.itemsList">
						<h1>{{item.product.name}}</h1>
						<li data-ng-repeat="flav in item.flavourList">{{flav.name}}</li>
					</ul>
					<p>{{selectedOrder.date | date : 'd MMMM yyyy'}}</p>
					<!--  <ul >
				  <li data-ng-repeat="prod in selectedOrder.items.products">{{prod}}</li>
     		 </ul>
     		 <label for="">Sabores: </label>
			  <ul>
				  <li data-ng-repeat="flav in selectedOrder.items.flavours">{{flav}}</li>
     		 </ul>
     		  <label for="">Fecha:</label>
              <p>{{selectedOrder.date | date : 'd MMMM yyyy'}}</p>-->

				</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">OK</button>
				</div>
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
	<script src="../resources/js/controllers/ordersController.js"></script>


</body>

</html>