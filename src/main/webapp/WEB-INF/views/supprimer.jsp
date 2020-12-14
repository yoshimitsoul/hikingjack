<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ma Randonnée</title>
<link rel="stylesheet" href="<c:url value='/includes/styles/style.css'/>">
<link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet">
</head>
<body>
<div id="alert1">Si vous continuez, toutes les données du formulaire en cours seront perdues</div>
<div id="alert2">Voulez-vous supprimer?</div>
<button type="submit" id="button">Supprimer</button>
<button type="button"  onclick="twFermer()" id="button">Fermer</button>
</body>
</html>
