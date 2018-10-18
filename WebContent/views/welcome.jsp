<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="es">
    <head>
        <meta charset="utf-8">
        <title>Spring MVC Test</title>
        <link href="css/style.css" type="text/css" rel="stylesheet">
    </head>
    <body>
        <div>
            <h2>Bienvenido a la prueba de Spring MVC Base!!!!</h2>
            <p>Esta es la funcionalidad que tendrá el proyecto final:</p>
		</div>
		
		<c:if test="${not empty funcionalidades}">
			<ul>
			<c:forEach var="funcionalidad" items="${funcionalidades}">
					<li>${funcionalidad.getDescription()}</li>
			</c:forEach>
			</ul>
		</c:if>
		
    </body>
</html>