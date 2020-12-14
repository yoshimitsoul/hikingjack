<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

<div class="container"> 
<div class="row"> 
<div class="col-xs-12 col-sm-12 col-md-8">

<a href="<c:url value="/admin/creerEtape"/>"><button
		class="btn btn-info" id="creerEtape">Créer une étape</button></a>
</div>
</div>
</div>


<div class="container">
	<h4>Tableaux détails des étapes</h4>
	<table class="table">
		<thead>
			<tr>
				<th>Etape</th>
				<th>Description</th>
				<th>Itinéraire</th>
				<th>Ordre dans l'itinéraire</th>
			</tr>
		</thead>
		<tbody>
			<tr class="table-active">
				<c:forEach items="${listeEtapes }" var="itineraire">
					<c:forEach items="${itineraire.listeEtapesItineraire}" var="etape">
						<tr>
							<td class="table-warning"><span>
									<a
										href="<c:out value="${pageContext.servletContext.contextPath}/admin/etape/${etape.idEtape }" />"><c:out
											value="${etape.nomEtape}" /></a>
								</span>
							<td class="table-secondary"><p>
									<c:out value="${etape.descriptionEtape}"></c:out></td>
							<td class="table-success"><p>
									<c:out value="${itineraire.nomItineraire }"></c:out>
								</p></td>
							<td class="table-info"><p>
									<c:out value="${etape.numeroEtape }"></c:out>
								</p></td>
						</tr>
					</c:forEach>
				</c:forEach>
			</tr>
		</tbody>
	</table>
</div>
