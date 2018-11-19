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
<title>Pedir</title>
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
				<link href="../resources/css/customStyle.css" rel="stylesheet"></link>

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular.js"></script>
</head>
<body id="page-top" data-ng-app="userOrderApp"
	data-ng-controller="userOrderCtrl">
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
				href="index.html"> <i class="fas fa-fw fa-tachometer-alt"></i> <span>Pedir</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="charts.html">
					<i class="fas fa-fw fa-chart-area"></i> <span>Mis Ordenes</span>
			</a></li>
		</ul>
		<div id="content-wrapper" class="container">
			<div class="row">
				<div class="col-md-6">
				<h1> Ordenar </h1>
					<form>
						<div class="form-group">
							<label for="formGroupExampleInput">Helados </label> <select
								id="combo"
								ng-options="product as product.name for product in products"
								ng-model="selectedProduct" ng-change="selectProduct()"></select>
						</div>

						<div class="form-group " ng-show="canshowFlavours">
							<label for="formGroupExampleInput2">Gustos</label>
							<div>
								<button data-ng-repeat="flavour in flavours" type="button"
									ng-class="{'active':flavour.selectFl==true}"
									style="margin-left: 5px; margin-right: 5px;"
									data-ng-click="addFlavour(flavour)"
									class="btn btn-outline-primary">{{flavour.name}}</button>
							</div>
						</div>
						<div>
							<button class="btn btn-success" data-ng-click="addItem()"
								type="button" ng-if="selectedFlavours.length > 0">Agregar</button>
						</div>
					</form>
				</div>
				<div class="col-md-6 scrollDiv" ng-if="canShowPartialOrder">
					<form>
						<div class="form-group">
							<h1> Mi pedido </h1>
						</div>
						<div class="card customCard" style="width: 18rem;"
							data-ng-repeat="item in itemsList">
							<p style="padding-left:262px;">
        						<a href="#" data-ng-click="deleteItem($index)">
         						 <span class="badge badge-pill badge-danger">X</span>
        						</a>
      						</p>
							<img class="card-img-top customCardImage" src={{item.product.imagePath}}>
							<div class="card-body customCardBody">
								<h5 class="card-title">{{item.product.name}}</h5>
							</div>
							<div class="card-body">
								<div class="row">
									<div data-ng-repeat="flav in item.flavourList">{{flav.name}}
										&nbsp;</div>
								</div>
							</div>
						</div>
						<div>
							<h4>TOTAL: $ {{getCost()}}</h4>
						</div>
						<div>
							<button class="btn btn-success" data-ng-click="completeOrder()"
								type="button">Completar orden</button>
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
		<a class="scroll-to-top rounded" href="#page-top"> <i
			class="fas fa-angle-up"></i>
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