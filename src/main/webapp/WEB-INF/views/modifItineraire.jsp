<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

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

<form:form method="POST"
	action="${pageContext.servletContext.contextPath}/admin/modifierItineraire"
	modelAttribute="itineraireAModifier">
	<div class="card border-primary rounded-0">
		<div class="card-header p-3">
			<div class="bg-danger text-white text-center py-2">
				<h3>
					Modifier l'itinéraire:
					<c:out value="${itineraireAModifier.nomItineraire }"></c:out>
				</h3>
			</div>
		</div>
		<div class="card-body p-3">
			<form:hidden path="idItineraire"
				value="${itineraireAModifier.idItineraire }" />
			<!--Form body-->
			<div class="form-group">
				<div class="input-group mb-2">
					<form:errors path="*" class="has-error" />
					<form:label path="nomItineraire">Nom</form:label>
					<form:input type="text" path="nomItineraire" />
				</div>
			</div>
			<hr>
			<div class="form-group">
				<div class="input-group mb-2">
					<form:label path="niveauItineraire">Niveau de l'itinéraire</form:label>
					<form:select path="niveauItineraire.idNiveau">
						<form:option value="0" label="--- Sélectionnez ---" />
						<c:forEach items="${listeNiveaux}" var="niveau">
							<c:choose>
								<c:when test="${niveau eq itineraireAModifier.niveauItineraire}">
									<form:option value="${niveau.idNiveau}" selected="true">${niveau.libelleNiveau}</form:option>
								</c:when>
								<c:otherwise>
									<form:option value="${niveau.idNiveau}">${niveau.libelleNiveau}</form:option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</form:select>
				</div>
			</div>
			<hr>
			<div class="text-center">
				<input type="submit" class="btn btn-danger btn-block rounded-0 py-2"
					value="Envoyer" />
			</div>
		</div>
	</div>
</form:form>

<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>


