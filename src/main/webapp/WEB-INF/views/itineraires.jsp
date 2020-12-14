<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include  page="/WEB-INF/views/headerFront.jsp"></jsp:include>

	<!-- Page Content -->
	<div class="container">
		<div>
			<h1 class="text-center">Tous les goûts sont dans la nature</h1>
		</div>
		<div class="row">
			<div class="col-md-8 mb-5">
				<h3 class="text-success mt-5">Les itinéraires disponibles</h3>
				<hr>
			</div>
		</div>

		<!-- Row itinerary -->
		<div class="row">
			<c:forEach items="${listeItineraires}" var="itineraire">
				<div class="col-lg-4 col-md-6 mb-4">
					<div class="card h-100">
						<img class="card-img-top"
							src="https://picsum.photos/600/400" alt="">
						<div class="card-body">
							<h4 class="card-title">
								<h3>${itineraire.idItineraire} -
									${itineraire.nomItineraire}</h3>
							</h4>
							<p class="card-text">Niveau : ${itineraire.niveauItineraire.libelleNiveau}</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	
<jsp:include  page="/WEB-INF/views/footerFront.jsp"></jsp:include>


