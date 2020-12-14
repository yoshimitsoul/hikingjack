<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

<c:if  test="${ not empty messageAjoutFormulaire }">
	    <div class="message-validation"><c:out value="${messageAjoutFormulaire }"/></div>
	</c:if>
	<c:if  test="${ not empty messageErreurFormulaire }">
	    <div class="message-erreur"><c:out value="${messageErreurFormulaire }"/></div>
	</c:if>
	
<div class="container"> 
	<div class="row"> 
		<div class="col-xs-12 col-sm-12 col-md-8">
			<a href="<c:url value="/admin/creerItineraire"/>"><button class="btn btn-info" id="creerItineraire">Créer un itinéraire</button></a>
			<div id="tableauItineraire">
		</div>
	</div>
</div>

<div class="container">
	<h4>Tableaux détails des itinéraires</h4>
	<table class="table">
		<thead>
			<tr>
				<th>Itinéraire</th>
				<th>Nombre d'étapes</th>
				<th>Niveau</th>
			</tr>
		</thead>
		<tbody>
			<tr class="table-active">
				<c:forEach items="${listeItineraires }" var="itineraire">
   				<tr>
   					<td class="table-warning"><span><a href="<c:out value="${pageContext.servletContext.contextPath}/admin/itineraire/${itineraire.idItineraire }" />"><c:out value="${itineraire.nomItineraire}"/></a></span>
   					<td class="table-success"><p><c:out value="${itineraire.listeEtapesItineraire.size()}"></c:out></td>
   					<td class="table-info"><p><c:out value="${itineraire.niveauItineraire.libelleNiveau }"></c:out></p></td>
   				</tr>
   			</c:forEach>
			</tr>
		</tbody>
	</table>
</div>


	