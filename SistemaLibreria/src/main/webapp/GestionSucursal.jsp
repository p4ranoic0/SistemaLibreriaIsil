<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<script src="js/bootstrap.min.js"></script>
	</head>
	<body>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
		  <div class="collapse navbar-collapse" id="navbarNav">
		    <ul class="navbar-nav">
		      <li class="nav-item active">
		        <a class="nav-link" href="GestionSucursal.jsp">Sucursales<span class="sr-only">(current)</span></a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="EditarSucursal.jsp">Editar Datos</a>
		      </li>
		    </ul>
		  </div>
		</nav>
	
		<div class="container">
		<h2>Sucursales</h2>
		<!-- Formulario buscar Parque -->
		<form action="sucursal" method="GET" id="buscarSucursal" role="form">
			<input type="hidden" id="opcion" name="opcion" value="buscarPorNombre">
			<div class="form-group col-xs-5">
				Nombre de Sucursal: 
				<input type="text" name="nombreSucursal" id="nombreSucursal"
					class="form-control" 
					placeholder="Escriba el nombre de la Sucursal" />
			</div>
			<button type="submit" class="btn btn-info">
				<span class="glyphicon glyphicon-search"></span> Buscar
			</button>
		</form>
	
		<form action="sucursal" method="GET" id="nuevaSucursal" role="form">
			<input type="hidden" id="opcion" name="opcion" value="nuevo"> <br></br>
			<button type="submit" class="btn btn-primary  btn-md">Nueva Sucursal</button>
		</form>
		
		<form action="sucursal" method="POST" id="sucursalForm" role="form">							
			<input type="hidden" id="action" name="action">
			<input type="hidden" id="idSucursal" name="idSucursal">	
		<c:choose>
			<c:when test="${not empty listaSucursal}">
				<table class="table table-striped">
					<thead>
						<tr>
							<td>Id</td>
							<td>Nombre</td>							
							<td>Descripcion</td>
							<td>Estado</td>
							<td>Acción</td>
						</tr>
					</thead>
					<c:forEach var="objSucursal" items="${listaSucursal}">
						<tr>
							<td>${objSucursal.id}</td>
							<td>${objSucursal.nombre}</td>
							<td>${objSucursal.descripcion}</td>
							<td>${objSucursal.estado}</td>							
							<td><a href="#" id="eliminar"
									onclick="document.getElementById('idSucursal').value='${objSucursal.id}';
	            									document.getElementById('action').value='eliminar';
	            									document.getElementById('sucursalForm').submit();">
										<span class="glyphicon glyphicon-trash" />Eliminar
									</a>
							</td>
						</tr>
					</c:forEach>				
				</table>
			</c:when>
			<c:otherwise>
				<br>
				<div class="alert alert-info">No se encontraron registros para la búsqueda</div>
			</c:otherwise>
		</c:choose>
		</form>
	</div>
	</body>
</html>