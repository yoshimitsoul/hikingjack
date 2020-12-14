<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>


<div class="container">
	<div class="row">
		<div class="col-md-12 mb-6">
			<h3 class="text-center">
				Nom de l'itinéraire :
				<c:out value="${itineraire.nomItineraire }"></c:out>
			</h3>
			<hr>
		</div>
	</div>
</div>


<!-- Message en cas de succès à la modification de l'itinéraire -->
<c:if test="${ not empty messageAjoutFormulaire }">
	<div class="message-validation">
		<c:out value="${messageAjoutFormulaire }" />
	</div>
</c:if>


<div class="col-md-12 mb-6">
	<div class="card h-100">
		<a class="text-center"
			href="<c:url value="/admin/modifierItineraire/${itineraire.idItineraire }"/>"><button
				class="btn btn-info" id="modifItineraire">Modifier
				l'itinéraire</button></a>

		<div class="card-body text-center">
			<h4 class="card-title">
				<a
					href="<c:out value="${pageContext.servletContext.contextPath}/admin/supprimer-itineraire/${itineraire.idItineraire }" />">
					<button class="btn btn-info" id="supItineraire">Supprimer</button>
				</a>
			</h4>
			<h3>Niveau :</h3>
			<p>
				<c:out value="${itineraire.niveauItineraire.libelleNiveau }"></c:out>
			</p>
		</div>
	</div>
</div>

