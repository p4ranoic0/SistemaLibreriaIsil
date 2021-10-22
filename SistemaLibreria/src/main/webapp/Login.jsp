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

	<p class="h1 text-center pb-5 text-info bg-dark">Ingresar al Sistema<p>
 	<div class="container">	
	<div class="row justify-content-around">
	
	<form action="usuario" method="POST">
		<input type="hidden" value="validarUsuario" id="opcion" name="opcion">
		<div class="form-group">
			 <input
				type="email" class="form-control" id="correo" name="correo" placeholder="hgarcia@example.com"
				aria-describedby="emailHelp"> <small id="emailHelp"
				class="form-text text-muted">Nunca compartiremos tus datos
				con otra persona</small>
		</div>
		<div class="form-group">
			<input type="password" class="form-control" id="password" name ="password" placeholder="Contraseña"		>
		</div>

		<button type="submit" class="btn btn-primary btn-block mb-5">Ingresar</button><br>
		
	 <p><a class="btn btn btn-info btn-block mb-2" href="NuevoUsuario.jsp">Crear Usuario</a></p>
	 <p><a class="btn btn-secondary btn-block" href="RecuperarContrasena.jsp">Olvido Contraseña</a></p>
	</form>
	 </div>
</div>
</div>
		
</body>
</html>