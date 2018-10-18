<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="es">
    <head>
        <meta charset="utf-8">
        <title>Spring MVC Form testing</title>
        <link href="css/style.css" type="text/css" rel="stylesheet">
    </head>
    <body>
        <div>
            <h2>Como pasar data desde el form al controller</h2>
            <p>Pequeño ejemplo:</p>
		</div>
		
		<form:form method="POST"
          action="welcomeProcessForm" modelAttribute="functionalityDto">
             <table>
                <tr>
                    <td><form:label path="description">Descripción:</form:label></td>
                    <td><form:input path="description"/></td>
                </tr>
                <tr>
                    <td><form:label path="category">Categoria:</form:label></td>
                    <td><form:input path="category"/></td>
                </tr>
                <tr>
                    <td><form:label path="sprintApply">
                      Aplica en el Sprint:</form:label></td>
                    <td><form:input path="sprintApply"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>