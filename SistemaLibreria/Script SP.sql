
CREATE PROCEDURE SP_buscarSucursalAll
AS
	SELECT *
	FROM Sucursal
RETURN
GO

CREATE PROCEDURE SP_buscarSucursalxNombre
@nombre VARCHAR(50)
AS
	SELECT *
	FROM Sucursal s
	WHERE s.nombre like '%' + @nombre + '%';
RETURN
GO

CREATE PROCEDURE SP_buscarSucursalxId
@id int
AS
	SELECT *
	FROM Sucursal s
	WHERE s.id = @id;
RETURN
GO

CREATE PROCEDURE SP_eliminarSucursal
@id int
AS
	DELETE FROM Sucursal WHERE id = @id;
RETURN
GO

CREATE PROCEDURE SP_editarSucursal
@id int,
@nombre varchar(50),
@descripcion varchar(50),
@estado varchar(50)
AS
	UPDATE Sucursal SET nombre=@nombre, descripcion=@descripcion, estado=@estado, fechaActualizacion=GETDATE()
	where id= @id;
RETURN
GO

CREATE PROCEDURE SP_agregarSucursal
@nombre varchar(50),
@descripcion varchar(50),
@estado varchar(50)
AS
	INSERT INTO Sucursal(nombre,descripcion,estado,fechaCreacion,fechaActualizacion)
	VALUES (@nombre,@descripcion,@estado,GETDATE(),GETDATE());
RETURN
GO
