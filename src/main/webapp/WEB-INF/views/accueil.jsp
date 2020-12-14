<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include  page="/WEB-INF/views/header.jsp"></jsp:include>

<div class="container">
		<div class="row">
			<div class="col-md-12 mb-6">
				<h2 class="text-center">Bienvenue Administrateur !</h2>
				<hr>

			</div>
		</div>
	</div>
	
	<!--Grid row-->
<div class="row w-100">
  <!--Grid column-->
  <div class="col-md-6 mb-4">

    <!-- Card 1 -->
    <div class="card-body pb-2 ml-4">
        <div class="card-image" style="background-color: #546686">

          <!-- Content -->
          <a href="<c:url value="/admin/creerEtape"/>">
						<button class="btn btn-info" id="creerEtape">Créer une étape</button>	
            <div class="text-white">
              <div class="first-content align-self-center p-3">
                <h3 class="card-title">HikingJack</h3>
                <p class="lead mb-0">Commencez à créer une Etape </p>
              </div>
            </div>
          </a>
        </div>
    </div>
    <!-- Card 1 end -->
  </div>

  <div class="col-md-6 mb-4">

    <!-- Card 2 -->
    <div class="card-body pb-3 ml-4">

        <div class="card-image" style="background-color: #00725A">

          <!-- Content -->
          <a href="<c:url value="/admin/creerItineraire"/>">
						<button class="btn btn-info" id="creerItineraire">Créer un itinéraire</button>
            <div class="text-white">
              <div class="first-content align-self-center p-3">
                <h3 class="card-title">HikingJack</h3>
                <p class="lead mb-0">Commencez à créer un Itinéraire</p>
              </div>
            </div>
          </a>
        </div>
    </div>
    <!-- Card 2 end -->
  </div>

  <div class="col-md-6 mb-4">

    <!-- Card 3 -->
    <div class="card-body pb-3 ml-4">

        <div class="card-image" style="background-color: #2761A5">

          <!-- Content -->
          <a href="<c:url value="/admin/listeEtapes"/>">
						<button class="btn btn-info" id="listeEtapes">Consulter la liste des étapes</button>
            <div class="text-white">
              <div class="first-content align-self-center p-3">
                <h3 class="card-title">HikingJack</h3>
                <p class="lead mb-0">Consultez la liste des étapes créées</p>
              </div>
            </div>
          </a>
        </div>
    </div>
    <!-- Card  3 end -->

  </div>
  
  <div class="col-md-6 mb-4">

    <!-- Card 4 -->
    <div class="card-body pb-3 ml-4">
        <div class="card-image" style="background-color: #136D74">

          <!-- Content -->
          <a href="<c:url value="/admin/listeItineraires"/>">
						<button class="btn btn-info" id="listeItineraires">Consulter la liste des itinéraires</button>
            <div class="text-white">
              <div class="first-content align-self-center p-3">
                <h3 class="card-title">HikingJack</h3>
                <p class="lead mb-0">Consultez la liste des itinéraires créées</p>
              </div>
            </div>
          </a>
        </div>
    </div>
    <!-- Card 4 -->
  </div>
</div>

<jsp:include  page="/WEB-INF/views/footerFront.jsp"></jsp:include>
