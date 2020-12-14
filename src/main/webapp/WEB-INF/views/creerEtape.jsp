<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<div class="bg-info text-white text-center py-2">
				<h3>Ajout d'une étape</h3>
			</div>
		</div>
		<div class="card-body p-3">

			<!--Form body-->
			<div class="form-group">
				<div class="input-group mb-2">
					<form:form method="POST"
						action="${pageContext.servletContext.contextPath}/admin/etape-ajout"
						modelAttribute="etapeAAjouter">
						<form:errors path="*" class="has-error" />
						<form:label path="nomEtape"></form:label>
						<form:input class="form-control" id="nomEtape" name="nomEtape" placeholder="Nom de l'étape" type="text" path="nomEtape" />
						</div>
						</div>
						<hr>
						
						<div class="form-group">
						<div class="input-group mb-2">
						<form:label path="descriptionEtape"></form:label>
						<form:input class="form-control" id="nomEtape" name="DescrptionEtape" placeholder="Desciption de l'étape" type="text" path="descriptionEtape" />
						</div>
						</div>
						<hr>
						
						<div class="form-group">
						<div class="input-group mb-2">
						<form:label path="itineraireEtape">Itinéraire de l'étape</form:label>
						</div>
						</div>
						<hr>
						
						<div class="form-group">
						<div class="input-group mb-2">
						<form:select path="itineraireEtape.idItineraire">
							<form:option value="0" label="--- Sélectionnez ---" />
							<form:options items="${listeItineraire}"
								itemLabel="nomItineraire" itemValue="idItineraire" />
						</form:select>
						</div>
						</div>
						<hr>
						
						<div class="form-group">
						<div class="input-group mb-2">
						<form:label path="numeroEtape">Numéro de l'étape</form:label>
						<form:input class="form-control mt-20" type="number" path="numeroEtape" />
						</div>
						</div>
						

					
				</div>
			</div>

			<div class="text-center">
				<input type="submit" value="Envoyer"
					class="btn btn-info btn-block rounded-0 py-2">
				
			</div>
</form:form>

<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>

