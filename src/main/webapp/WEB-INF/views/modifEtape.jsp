<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>


<hr>
<c:if test="${ not empty messageAjoutFormulaire }">
	<div class="message-validation">
		<c:out value="${messageAjoutFormulaire }" />
	</div>
</c:if>
<c:if test="${ not empty messageErreurFormulaire }">
	<div class="message-erreur">
		<c:out value="${messageErreurFormulaire }" />
	</div>
</c:if>

<!--Form with header-->
<div class="card border-primary rounded-0">
	<div class="card-header p-3">
		<div class="bg-danger text-white text-center py-2">
			<h3>Modifier l'étape: nom de l'étape</h3>
		</div>
	</div>
	<div class="card-body p-3">
		<form:form method="POST"
			action="${pageContext.servletContext.contextPath}/admin/etape-modifier"
			modelAttribute="etapeAModifier">
			<form:hidden path="idEtape" value="${etapeAModifier.idEtape }" />

			<form:errors path="*" class="has-error" />

			<div class="form-group">
				<div class="input-group mb-2">
					<form:label path="nomEtape">Nom</form:label>
					<form:input type="text" path="nomEtape" />
				</div>
			</div>
			<hr>
			<div class="form-group">
				<div class="input-group mb-2">
					<form:label path="descriptionEtape">Description</form:label>
					<form:input type="text" path="descriptionEtape" />
				</div>
			</div>

			<div class="form-group">
				<div class="input-group mb-2">
					<form:label path="itineraireEtape">Itinéraire de l'étape</form:label>
					<form:select path="itineraireEtape.idItineraire">
						<form:option value="0" label="--- Sélectionnez ---" />
						<c:forEach items="${listeItineraire}" var="itineraire">
							<c:choose>
								<c:when test="${itineraire eq etapeAModifier.itineraireEtape}">
									<form:option value="${itineraire.idItineraire}" selected="true">${itineraire.nomItineraire}</form:option>
								</c:when>
								<c:otherwise>
									<form:option value="${itineraire.idItineraire}">${itineraire.nomItineraire}</form:option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</form:select>
				</div>
			</div>

			<div class="form-group">
				<div class="input-group mb-2">
					<form:label path="numeroEtape">Numéro de l'étape</form:label>
					<form:input type="number" path="numeroEtape" />
				</div>
			</div>
			<div class="text-center">
				<input type="submit"
					class="btn btn-danger btn-block rounded-0 py-2" value="Envoyer" />
			</div>

		</form:form>
	</div>
</div>

<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>


