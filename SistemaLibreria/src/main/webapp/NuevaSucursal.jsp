<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Nueva Sucursal</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">  		
  <script src="js/bootstrap.min.js"></script>   
</head>

<body>
	<div class="container">
      <form action="sucursal" method="post" role="form" data-toggle="validator" >
        <c:if test ="${empty action}">            	
          <c:set var="action" value="guardar"/>
        </c:if>

        <input type="hidden" id="action" name="action" value="${action}">
        <input type="hidden" id="idParque" name="idParque" value="${sucursal.id}">
        <h2>Sucursal</h2>

        <div class="form-group">
          <label for="nombre" class="control-label col-xs-4">Nombre:</label>
          <input type="text" name="nombre" id="nombre" class="form-control" value="${sucursal.nombre}" required="true" />
          <label for="descripcion" class="control-label col-xs-4">Descripcion: </label>          
          <input type="text" name="descripcion" id="descripcion" class="form-control" value="${descripcion.aforo}" required="true"/> 
		  
          <br></br>

          <button type="submit" class="btn btn-primary">Guardar</button> 
        </div>                            
      </form>
    </div>
</body>
</html>