package com.libreria.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.libreria.conexion.Conexion;
import com.libreria.model.Sucursal;


public class SucursalDao {
	Connection cn = Conexion.conectar();
	ResultSet rs =  null;
	Statement stmt = null;		
	
	public List<Sucursal> buscarSucursalxNombre(String nombreSucursal){
		List<Sucursal> listaSucursal = new ArrayList<>();
		try {	
			stmt = cn.createStatement(); 
			String sentenciaSQL = "SELECT * FROM Sucursal WHERE nombre like '%" + nombreSucursal + "%';";
			rs = stmt.executeQuery(sentenciaSQL); 
			while (rs.next()) {
				
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String descripcion = rs.getString("descripcion");
				String estado = rs.getString("estado");				
				Date fechaCreacion = rs.getDate("fechaCreacion");
				Date fechaActualizacion = rs.getDate("fechaActualizacion");
				
				Sucursal objSucursal = new Sucursal(id,nombre,descripcion,estado,fechaCreacion,fechaActualizacion);
				listaSucursal.add(objSucursal);
				
			}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return listaSucursal;				
	}
	
	public List<Sucursal> buscarSucursalAll(){
		List<Sucursal> listaSucursal = new ArrayList<>(); //Estoy creando la lista de parques vacía
		try {			
			stmt = cn.createStatement(); /*De esta manera estoy creando el objeto para ejecutar querys en la conexión de BD que he abierto*/
			String sentenciaSQL = "SELECT * FROM Sucursal";
			rs = stmt.executeQuery(sentenciaSQL); /*Aquí se está ejecutando el query en BD*/
			while (rs.next()) {				
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String descripcion = rs.getString("descripcion");
				String estado = rs.getString("estado");				
				Date fechaCreacion = rs.getDate("fechaCreacion");
				Date fechaActualizacion = rs.getDate("fechaActualizacion");
				
				Sucursal objSucursal = new Sucursal(id,nombre,descripcion,estado,fechaCreacion,fechaActualizacion);
				listaSucursal.add(objSucursal);
				
				
				
			}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return listaSucursal;				
	}
	
	public void agregarSucursal(Sucursal objSucursal) throws SQLException {		
		stmt = cn.createStatement(); /*De esta manera estoy creando el objeto para ejecutar querys en la conexión de BD que he abierto*/
		String sentenciaSQL = "INSERT INTO Sucursal(nombre,descripcion,estado,fechaCreacion,fechaActualizacion) VALUES ('" + objSucursal.getNombre() + "','" + objSucursal.getDescripcion() + "','" + objSucursal.getEstado() + "',GETDATE(),GETDATE());";		
		stmt.executeUpdate(sentenciaSQL);
	}
	
	public void eliminarSucursal(int idSucursal) throws SQLException {		
		stmt = cn.createStatement(); 
		String sentenciaSQL = "DELETE FROM Sucursal WHERE id="+ idSucursal + ";";
		stmt.executeUpdate(sentenciaSQL);		
	}
}
