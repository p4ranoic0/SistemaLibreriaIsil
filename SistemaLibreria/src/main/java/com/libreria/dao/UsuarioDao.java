package com.libreria.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.libreria.conexion.Conexion;
import com.libreria.model.Usuario;


public class UsuarioDao {
	Connection cn = Conexion.conectar();
	ResultSet rs =null;
	
	public int validarUsuarioSP(String correo, String password) throws SQLException {
		int existe;
		/*La consulta en BD se hará a través de Stored Procedures*/
		CallableStatement cs = cn.prepareCall("{call SP_validarUsuario(?,?,?)}");
		/*Definiendo los parámetros del SP*/
		cs.setString(1,correo);
		cs.setString(2,password);
		cs.registerOutParameter(3, java.sql.Types.INTEGER);
		cs.execute();
		existe = cs.getInt(3); /*Obtengo la cantidad que me devolvió el SP que está en la columna 0*/
		return existe;		
	}
	
	public void agregarUsuario_SP(Usuario objUsuario) throws SQLException {
		CallableStatement cs = cn.prepareCall("{call SP_agregarUsuario(?,?,?,?,?,?)}");
		cs.setString(1, objUsuario.getCorreo());
		cs.setString(2, objUsuario.getNombre());
		cs.setString(3, objUsuario.getApePaterno());
		cs.setString(4, objUsuario.getApeMaterno());
		cs.setString(5, objUsuario.getDireccion());
		cs.setString(6, objUsuario.getPassword());
		
		cs.execute();
		
	} 
	
	public String buscarContra_SP(String correo) throws SQLException {		
		String password = null;
		try {
			CallableStatement cs = cn.prepareCall("{call SP_recuperarContra(?,?)}");
			cs.setString(1, correo);
			cs.registerOutParameter(2, java.sql.Types.INTEGER);
			cs.execute();			
			password =cs.getString(2);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return password;			
	} 
}
