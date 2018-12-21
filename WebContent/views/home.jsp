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
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Freelancer - Start Bootstrap Theme</title>

<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/resources/home/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom fonts for this template -->
<link
	href="${pageContext.request.contextPath}/resources/home/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css">

<!-- Plugin CSS -->
<link
	href="${pageContext.request.contextPath}/resources/home/vendor/magnific-popup/magnific-popup.css"
	rel="stylesheet" type="text/css">

<!-- Custom styles for this template -->
<link
	href="${pageContext.request.contextPath}/resources/home/css/freelancer.min.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular.js"></script>


</head>

<body id="page-top" data-ng-app="homeApp" data-ng-controller="homeCtrl">

	<!-- Header -->
	<header class="masthead bg-primary text-white text-center">
		<div class="container">
			<img class="img-fluid mb-5 d-block mx-auto" src="img/profile.png"
				alt="">
			<h1 class="text-uppercase mb-0">HELADERIA ALFREDO</h1>
			<hr class="star-light">
			<h2 class="font-weight-light mb-0">El helado tecnologico mas rico</h2>
			<form
				action="http://localhost:8080${pageContext.request.contextPath}/login">
				<button class="btn btn-outline-dark" type="submit"
					style="width: 50%; margin-top: 40px;">login</button>
			</form>
		</div>
	</header>

	<!-- Portfolio Grid Section -->
	<section class="portfolio" id="portfolio">
		<div class="container">
			<h2 class="text-center text-uppercase text-secondary mb-0">Nuestros
				productos</h2>
			<hr class="star-dark mb-5">
			<div class="row">
				<div class="col-md-6 col-lg-4">
					<a class="portfolio-item d-block mx-auto">
						<div
							class="portfolio-item-caption d-flex position-absolute h-100 w-100">
							<div
								class="portfolio-item-caption-content my-auto w-100 text-center text-white">
								<div>Cuarto</div>
							</div>
						</div> <img class="img-fluid"
						src="${pageContext.request.contextPath}/resources/images/cuarto.jpg"
						alt="">
					</a>
				</div>
				<div class="col-md-6 col-lg-4">
					<a class="portfolio-item d-block mx-auto">
						<div
							class="portfolio-item-caption d-flex position-absolute h-100 w-100">
							<div
								class="portfolio-item-caption-content my-auto w-100 text-center text-white">
								<div>Medio KG</div>
							</div>
						</div> <img class="img-fluid"
						src="${pageContext.request.contextPath}/resources/images/medio.jpg"
						alt="">
					</a>
				</div>
				<div class="col-md-6 col-lg-4">
					<a class="portfolio-item d-block mx-auto">
						<div
							class="portfolio-item-caption d-flex position-absolute h-100 w-100">
							<div
								class="portfolio-item-caption-content my-auto w-100 text-center text-white">
								<div>Un KG</div>
							</div>
						</div> <img class="img-fluid"
						src="${pageContext.request.contextPath}/resources/images/kilo.jpg"
						alt="">
					</a>
				</div>
				<div class="col-md-6 col-lg-4">
					<a class="portfolio-item d-block mx-auto">
						<div
							class="portfolio-item-caption d-flex position-absolute h-100 w-100">
							<div
								class="portfolio-item-caption-content my-auto w-100 text-center text-white">
								<div>Vasito</div>
							</div>
						</div> <img class="img-fluid"
						src="${pageContext.request.contextPath}/resources/images/vasito.jpg"
						alt="">
					</a>
				</div>
				<div class="col-md-6 col-lg-4">
					<a class="portfolio-item d-block mx-auto">
						<div
							class="portfolio-item-caption d-flex position-absolute h-100 w-100">
							<div
								class="portfolio-item-caption-content my-auto w-100 text-center text-white">
								<div>Cucurucho</div>
							</div>
						</div> <img class="img-fluid" style="height: 277px !important;"
						src="${pageContext.request.contextPath}/resources/images/cucurucho.jpg"
						alt="">
					</a>
				</div>
			</div>
		</div>
	</section>

	<!-- About Section -->
	<section class="bg-primary text-white mb-0" id="about">
		<div class="container">
			<h2 class="text-center text-uppercase text-white">NUESTROS
				SABORES</h2>
			<hr class="star-light mb-5">
			<div class="row">
				<div class="col-12" style="text-align: center;">
					<h2 class="font-weight-light mb-0"
						data-ng-repeat="flavour in flavours">{{flavour.name}}
						-------- $ {{flavour.salePrice}}</h2>
					<form
						action="http://localhost:8080${pageContext.request.contextPath}/views/user-order.jsp">
						<button class="btn btn-outline-dark" type="submit"
							style="width: 50%; margin-top: 40px;">HACER MI PEDIDO</button>
					</form>
				</div>
			</div>
		</div>
	</section>




	<div class="copyright py-4 text-center text-white">
		<div class="container">
			<small>Copyright &copy; Your Website 2018</small>
		</div>
	</div>

	<!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
	<div class="scroll-to-top d-lg-none position-fixed ">
		<a class="js-scroll-trigger d-block text-center text-white rounded"
			href="#page-top"> <i class="fa fa-chevron-up"></i>
		</a>
	</div>







	<!-- Bootstrap core JavaScript -->
	<script
		src="${pageContext.request.contextPath}/resources/home/vendor/jquery/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/home/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Plugin JavaScript -->
	<script
		src="${pageContext.request.contextPath}/resources/home/vendor/jquery-easing/jquery.easing.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/home/vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

	<!-- Contact Form JavaScript -->
	<script
		src="${pageContext.request.contextPath}/resources/home/js/jqBootstrapValidation.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/home/js/contact_me.js"></script>

	<!-- Custom scripts for this template -->
	<script
		src="${pageContext.request.contextPath}/resources/home/js/freelancer.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/controllers/homeController.js"></script>


</body>

</html>
