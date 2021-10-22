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
	<p class="h1 text-center pb-5 text-info bg-dark">Recuperar Contrasenia
	<p>
	<div class="container">
		<div class="row justify-content-around">

			<form action="usuario" method="POST" role="form">
			
				<div class="form-group">
					<input type="hidden" value="recuperarContra" id="opcion" name="opcion">
					<label>Correo</label><input type="email" class="form-control" id="correo" name="correo" value="${correo}"
						aria-describedby="emailHelp">
				</div>
				
				<div class="form-group">
					<label for="exampleInputPassword1">Password</label> <input
						type="text" class="form-control" id="password" name="password" value="${password}" readonly>
				</div>

				<button type="submit" class="btn btn-primary btn-block mb-5">Recuperar</button>
				<p>
					<a class="btn btn-secondary btn-block mb-2" href="Login.jsp">Regresar a Login</a>
				</p>
			</form>

</div>
		</div>
	</div>
</body>
</html>