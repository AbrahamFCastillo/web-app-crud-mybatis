<!-- Index prueba -->
<!--
<html>
<head>
<title>Spring Web MVC</title> 
</head>

<body>
	<h1>HOLA MUNDO WEB MVC !!!</h1>

	<h2>MENSAJE: ${mensaje}</h2>
</body>

</html>
-->

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en" data-bs-theme="auto">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>

<body>

<div class="container-fluid">
<div class="row">


	<h2>Lista de Empleados</h2>
	
	<div class="d-flex gap-2 justify-content-right py-5">
	  <a class="btn btn-primary rounded-pill px-3" href="nuevo-empleado">Nuevo Empleado</a>
	</div>
	
	<div class="table-responsive small">
		<table class="table table-striped table-sm">
			<thead>
				<tr> 
					<th scope="col">Id</th>
					<th scope="col">Nombre</th>
					<th scope="col">Sueldo</th>
					<th scope="col">Puesto</th>
					<th scope="col">Tipo Puesto</th>
					<th scope="col">Editar</th>
					<th scope="col">Eliminar</th>
				</tr>
			</thead>
			<tbody>
		    <c:forEach var="emp" items="${emps}"> 
			    <tr>
			    <td>${emp.id}</td>
			    <td>${emp.nombre}</td>
			    <td>${emp.sueldo}</td>
			    <td>${emp.puesto}</td>
			    
			    <td>
			    <c:choose>
			    	<c:when test="${emp.sueldo > 100}">DIRECTIVO</c:when>
			    	<c:otherwise>EMPLEADO</c:otherwise>
			    </c:choose>
			    </td>
			    
			    <td><a href="editar-empleado/${emp.id}">Editar</a></td>
			    <td><a href="eliminar-empleado/${emp.id}">Eliminar</a></td>
			    </tr>
		    </c:forEach>
		    </tbody>
	    </table>
    </div>
    <br/>
    
</div>
</div>

</body>
</html>



