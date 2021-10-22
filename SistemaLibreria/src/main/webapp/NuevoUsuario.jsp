<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid pt-5 pb-5 bg-dark text-white">
	<p class="h1 text-center pb-5 text-info bg-dark">Nuevo Usuario
	<p>
	<div class="container">
		<div class="row justify-content-around">

			<form action="usuario" method="POST">
			<input type="hidden" value="nuevoUsuario" id="opcion" name="opcion">
				<div class="form-group">
					
					<label for="exampleInputEmail1">Correo Electronico</label> <input
						type="email" class="form-control" id="correo" name="correo"
						aria-describedby="emailHelp">
				</div>
				<div class="form-group">
					<label for="nombre">Nombre</label> <input type="text"
						class="form-control" id="nombre" name="nombre">
				</div>
				<div class="form-group">
					<label for="apePaterno">Apellido Paterno</label> <input type="text"
						class="form-control" id="apePaterno" name="apePaterno">
				</div>
				<div class="form-group">
					<label for="apeMaterno">Apellido Materno</label> <input type="text"
						class="form-control" id="apeMaterno" name="apeMaterno">
				</div>
				<div class="form-group">
					<label for="direccion">Direccion</label> <input type="text"
						class="form-control" id="direcion" name="direccion">
				</div>

				<div class="form-group">
					<label for="exampleInputPassword1">Password</label> <input
						type="password" class="form-control" id="password" name="password">
				</div>

				<button type="submit" class="btn btn-primary btn-block mb-5">Grabar</button>
				<p>
					<a class="btn btn-secondary btn-block mb-2" href="Login.jsp">Regresar</a>
				</p>
			</form>


		</div>
	</div></div>
</body>
</html>