<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %> 

<jsp:include  page="/WEB-INF/views/headerFront.jsp"></jsp:include>

	<!-- Page Content -->
	<div class="container">
		<div class="row">
			<div class="col-md-12 mb-6">
				<h2 class="text-center"> ${etape.numeroEtape} - ${etape.nomEtape}</h2>
				<hr>
			</div>
		</div>

		<!--Details Row -->
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
				
				<!-- Card Météo -->
<div class="card weather-card mt-4">

  <!-- Card -->
  <div class="card-body pb-3 text-center">

    <!-- Title -->
    <h4 class="card-title font-weight-bold">Bordeaux</h4>
    <!-- Text -->
    <p class="card-text">Lun, 10:10, Ensoleilé</p>
    <div class="text-center">
      <p class="display-1 degree">31</p>
      <i class="fas fa-sun-o fa-5x pt-3 amber-text"></i>
    </div>
    <div class="d-flex justify-content-between mb-3">
      <p class="text-danger">Pluie : 0%</p>
      <p class="text-success">Vent: 11 km/h </p>
    </div>
  </div>
</div>
				<!-- ----card étape -->
				</div>
				<div class="col-lg-9">
					<div class="card mt-4">
						<img class="card-img-top img-fluid"
							src="https://picsum.photos/900/400" alt="">
						<div class="card-body">
							<h3 class="card-title">${etape.nomEtape}</h3>


							<form action="${urlLike}" method="post">

								<p>
									Vous êtes <em><c:out value="${etape.likesEtape}" /></em> à
									aimer cette étape !
									<c:url value="/detailEtape/${etape.idEtape}" var="urlLike" />
									<button class="btn btn-success" type="submit">J'aime !</button>
								</p>
							</form>
							<h4>Description:</h4>
							<p class="card-text">${etape.descriptionEtape}</p>
						</div>
					</div>
					<div class="col-lg-6">
						<h2 class="my-4">Photos</h2>
						<div id="carouselPhotos" class="carousel slide"
							data-ride="carousel">
							<ol class="carousel-indicators">
								<li data-target="#carouselPhotos" data-slide-to="0"
									class="active"></li>
								<li data-target="#carouselPhotos" data-slide-to="1"></li>
								<li data-target="#carouselPhotos" data-slide-to="2"></li>
							</ol>
							<div class="carousel-inner">
								<div class="carousel-item active">
									<img class="d-block w-100" src="https://picsum.photos/300/200"
										alt="First slide">
								</div>
								<div class="carousel-item">
									<img class="d-block w-100" src="https://picsum.photos/300/200"
										alt="Second slide">
								</div>
								<div class="carousel-item">
									<img class="d-block w-100" src="https://picsum.photos/300/200"
										alt="Third slide">
								</div>
							</div>
							<a class="carousel-control-prev" href="#carouselPhotos"
								role="button" data-slide="prev"> <span
								class="carousel-control-prev-icon" aria-hidden="true"></span> <span
								class="sr-only">Suivant</span>
							</a> <a class="carousel-control-next" href="#carouselPhotos"
								role="button" data-slide="next"> <span
								class="carousel-control-next-icon" aria-hidden="true"></span> <span
								class="sr-only">Précédent</span>
							</a>
						</div>
					</div>
					
					<!-- Card Photodownloader-->
					<div class="col-lg-6">
						<p>
							<c:if test="${not empty  error}">
								<c:out value="${error }"></c:out>
							</c:if>
						</p>
						<form
							action="${pageContext.servletContext.contextPath}/ajouterPhoto"
							method="post" enctype="multipart/form-data">
							<p>
								Ajouter une photo <input type="file" name="file"
									class="form-control-file" required="required" />
							</p>
							<input type="hidden" value="${etape.idEtape }" name="idEtape" />
							<input class="btn btn-success" type="submit" value="Ajouter" />
						</form>
					</div>
					
					<!-- Comments section -->
					<div class="card card-outline-secondary my-4">
						<div class="card-header">Commentaires</div>
						<div class="card-body">
						<c:forEach items="${commentaires}" var="commentaire">
							<p> ${commentaire.messageCommentaire} </p>
							<small class="text-muted">Posté par ${commentaire.pseudoCommentaire} </small>
							<hr>
							
						</c:forEach> 
							<div class="container">
							<c:url value="/commentaires" var = "urlCommentaire"/>
								 <form:form method="POST" action="${urlCommentaire}" modelAttribute="ajoutCommentaire"> 
									<c:choose>
										<c:when test="${not empty  errors}">
										    <div class="error">
										    <c:forEach items="${errors}" var="err">
										        ${err.defaultMessage}
										        <br/>
										    </c:forEach>
										    </div>
										</c:when>
									</c:choose>
									<div class="form-row">
										<div class="col-md-4 mb-3">
											<form:label path="pseudo"></form:label>
											<form:input path="pseudo" cssClass="form-control" id="prenom" placeholder="Pseudo" required="required"/>
											<form:errors path="pseudo" cssClass="invalid-feedback" />
										</div>
										<div class="col-md-4 mb-3">
											<form:label path="message"></form:label>
											<form:input path="message" cssClass="form-control" id="comment" placeholder="Votre commentaire" required="required"/>
											<form:errors path="message" cssClass="invalid-feedback" />
										</div>
									</div>
									<div class="form-group">
										<div class="form-check">
											<input class="form-check-input" type="checkbox" value="" id="cgu" required /> <label class="form-check-label" for="cgu">J'accepte les conditions générales d'utilisation.</label>
											<div class="invalid-feedback">Vous devez accepter les CGU pour continuer</div>
										</div>
									</div>
									<form:hidden path="idEtape" value="${etape.idEtape }" />
									<button class="btn btn-success" type="submit">Laissez un commentaire</button>
							 </form:form> 
							<%-- </form> --%>
										
								
							</div>
							<script>
					           /*La fonction principale de ce script est d'empêcher l'envoi du formulaire si un champ a été mal rempli
					            *et d'appliquer les styles de validation aux différents éléments de formulaire*/
					           (function() {
					             'use strict';
					             window.addEventListener('load', function() {
					               let forms = document.getElementsByClassName('needs-validation');
					               let validation = Array.prototype.filter.call(forms, function(form) {
					                 form.addEventListener('submit', function(event) {
					                   if (form.checkValidity() === false) {
					                     event.preventDefault();
					                     event.stopPropagation();
					                   }
					                   form.classList.add('was-validated');
					                 }, false);
					               });
					             }, false);
					           })();
					        </script>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

<jsp:include  page="/WEB-INF/views/footerFront.jsp"></jsp:include>
