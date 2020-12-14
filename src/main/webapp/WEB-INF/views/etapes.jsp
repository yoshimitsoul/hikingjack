<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include  page="/WEB-INF/views/headerFront.jsp"></jsp:include>

	<!-- Page-content -->
	<div class="container">
		<div>
			<h1 class="text-center">La nature dit toujours quelque chose.</h1>
		</div>
		<div class="row">
			<div class="col-md-8 mb-5">
				<h3 class="text-success mt-5">Veuillez choisir une étape</h3>
				<hr>
			</div>
		</div>
		<div class="row">
			<c:forEach items="${listeEtapes}" var="etape">
				<div class="col-lg-4 col-md-6 mb-4">
					<div class="card h-100">
						<a href="<c:url value='/detailEtape/${etape.idEtape }' />"><img class="card-img-top"
							src="https://picsum.photos/600/400" alt=""></a>
						<div class="card-body">
							<h4 class="card-title">
								<a href="<c:url value='/detailEtape/${etape.idEtape }' />">${etape.numeroEtape} - ${etape.nomEtape}</a>
							</h4>
							<p class="card-text">${etape.descriptionEtape}</p>
						</div>
						<div class="card-footer">
							<a href="<c:url value='/detailEtape/${etape.idEtape}'/>" class="btn btn-success">Détails</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	
<jsp:include  page="/WEB-INF/views/footerFront.jsp"></jsp:include>
