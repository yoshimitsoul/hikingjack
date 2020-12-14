<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Se connecter à l'application</title>

      <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
  </head>
  <body>
	<jsp:include  page="/WEB-INF/views/headerFront.jsp"></jsp:include>

    <div class="container">
    <div class="row justify-content-center">
			<div class="col-12 col-md-8 col-lg-6 pb-5">
      <form method="POST" action="${contextPath}/admin/login" class="form-signin">
        <h2 class="form-heading">Connexion</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <input name="username" type="text" class="form-control" placeholder="Utilisateur"
                   autofocus="true"/>
            <input name="password" type="password" class="form-control" placeholder="Mot de passe"/>
            <span>${error}</span>

            <button class="btn btn-lg btn-info btn-block" type="submit">Connexion</button>
        </div>
      </form>
    </div>
    </div>
    </div>
  </body>
  
</html>
