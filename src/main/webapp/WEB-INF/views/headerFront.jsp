<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- -------------------------BEGIN--------------------------------------- -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link title="style" href="<c:url value='/resources/css/style-front.css' />" type="text/css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<title>HikingJack</title>
</head>
<body>

	<!-- Navbar -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-success fixed-top">
		<div class="container">
			<a class="navbar-brand" href="<c:url value='/accueil' />">HikingJack </a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link"
						href="<c:url value='/accueil'/>">Accueil <span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<c:url value='/itineraires'/>">Itinéraires</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<c:url value='/etapes'/>">Étapes</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<c:url value='/contact'/>">Contact</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<c:url value='/admin/'/>">Espace Admin</a></li>
				</ul>
			</div>
		</div>
	</nav>
	
		<!-- Header -->
	<header class="py-5 bg-image-full">
		<img class="img-fluid d-block mx-auto mt-5"
			src="<c:url value='/resources/img/hikingjacklogo.png' />" alt="logo">
	</header>
	
	