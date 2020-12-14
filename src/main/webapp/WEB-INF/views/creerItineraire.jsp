<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	
	<c:if  test="${ not empty messageAjoutFormulaire }">
	    <div class="message-validation"><c:out value="${messageAjoutFormulaire }"/></div>
	</c:if>
	<c:if  test="${ not empty messageErreurFormulaire }">
	    <div class="message-erreur"><c:out value="${messageErreurFormulaire }"/></div>
	</c:if>
	
	<!--Form with header-->

<form action="${pageContext.servletContext.contextPath}/admin/itineraire-ajout" method="post">
	<div class="card border-primary rounded-0">
		<div class="card-header p-3">
			<div class="bg-info text-white text-center py-2">
				<h3>Ajouter un Itinéraire</h3>
			</div>
		</div>
		<div class="card-body p-3">

			<!--Form body-->
			<div class="form-group">
				<div class="input-group mb-2">
					<form:form method="POST"  action="${pageContext.servletContext.contextPath}/admin/itineraire-ajout" modelAttribute="itineraireAAjouter">
					<form:errors path="*" class="has-error" />
					<form:label path="nomItineraire">Nom</form:label>
		           	<form:input type="text" path="nomItineraire"/>
						</div>
						</div>
						<hr>
						
						<div class="form-group">
						<div class="input-group mb-2">
						<form:label path="niveauItineraire">Niveau de l'itinéraire</form:label>
						
						</div>
						</div>
						<hr>
						
						<div class="form-group">
						<div class="input-group mb-2">
							<form:select path="niveauItineraire.idNiveau">
			            	<form:option value="0" label="--- Sélectionnez ---" />
					 		<form:options items="${listeNiveaux}" itemLabel="libelleNiveau" itemValue="idNiveau" />
						</form:select>

						</div>
						</div>
						<hr>
						
						<div class="form-group">
						<div class="input-group mb-2">
						
						
						</div>
						</div>
						<hr>
						
						<div class="form-group">
						<div class="input-group mb-2">
						
						
						</div>
						</div>
						

					
				</div>
			</div>

			<div class="text-center">
				<input type="submit" value="Envoyer"
					class="btn btn-info btn-block rounded-0 py-2">
				
			</div>
			
</form>
</form:form>

<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>

	
	
	
	