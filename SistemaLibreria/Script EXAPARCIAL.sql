USE libreriaDB
GO
CREATE OR ALTER PROCEDURE SP_agregarUsuario
@correo VARCHAR(100),
@nombre VARCHAR(40),
@apPaterno VARCHAR(40),
@apMaterno VARCHAR(40),
@direccion VARCHAR(100),
@password VARCHAR(20)
AS
INSERT INTO Usuario(correo,nombre,apePaterno,apeMaterno,direccion,password)
VALUES (@correo,@nombre,@apPaterno,@apMaterno,@direccion,@password);
RETURN
GO

declare  @correo VARCHAR(100),@nombre VARCHAR(40),@apPaterno VARCHAR(40),@apMaterno VARCHAR(40),@direccion VARCHAR(100),@password VARCHAR(20);
execute SP_agregarUsuario 'prueba@gmail.com','nuevo','nuevo','nuevo','casa','123';
go

CREATE OR ALTER PROCEDURE SP_validarUsuario
@correo varchar(100), --input
@password varchar(20), --input
@cantidad int output   --Esto es lo que me devuelve el SP
AS
	SET NOCOUNT ON; --Se activa cuando se utiliza count
	SELECT @cantidad = COUNT(*)
	FROM Usuario u
	where u.correo = @correo and
		  u.password = @password
RETURN
GO

--Comprobacion
DECLARE @correo varchar(100), @password varchar(20),@cantidad int;
EXECUTE SP_validarUsuario 'prueba@gmail.com','123',@cantidad OUTPUT;
SELECT @cantidad
GO


CREATE OR ALTER PROCEDURE SP_recuperarContra
@correo varchar(100), --input
@password varchar(20) output
AS	
	SELECT @password=password
	FROM Usuario u
	where u.correo = @correo		  
RETURN
GO

DECLARE @correo varchar(100), @password varchar(20);
EXECUTE SP_recuperarContra 'prueba@gmail.com', @password OUTPUT;
SELECT @password
GO