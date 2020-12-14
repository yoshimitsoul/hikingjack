<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>


<div class="container">
	<div class="row">
		<div class="col-md-12 mb-6">
			<h3 class="text-center">
				Nom de l'étape :
				<c:out value="${etape.nomEtape }"></c:out>
			</h3>
			<hr>
		</div>
	</div>
</div>


<!-- Message en cas de succès à la modification de l'étape -->
<c:if test="${ not empty messageAjoutFormulaire }">
	<div class="message-validation">
		<c:out value="${messageAjoutFormulaire }" />
	</div>
</c:if>


<div class="col-md-12 mb-6">
	<div class="card h-100">
		<a class="text-center"
			href="<c:url value="/admin/modifier-etape/${etape.idEtape }"/>"><button
				class="btn btn-info" id="modifEtape">Modifier l'étape</button></a>
		<div class="card-body text-center">
			<h4 class="card-title">
				<a
					href="<c:out value="${pageContext.servletContext.contextPath}/admin/supprimer-etape/${etape.idEtape }" />"><button
						class="btn btn-info" id="supEtape">Supprimer</button></a>
			</h4>
			<b>Description</b>
			<p>
				<c:out value="${etape.descriptionEtape }"></c:out>
			</p>
		</div>
		<div class="card-footer text-center">
			<a
				href="${pageContext.servletContext.contextPath}/admin/generation-rapport-etape.pdf?idEtape=${etape.idEtape }"><button
					class="btn btn-info" id="imprimer">Imprimer</button></a>
		</div>
	</div>
</div>