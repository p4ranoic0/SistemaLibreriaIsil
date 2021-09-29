package com.libreria.model;

import java.sql.Date;

public class Sucursal {
	private int id;
	private String nombre;
	private String descripcion;
	private String estado;
	private Date fechaCreacion;
	private Date fechaActualizacion;	
	
	
	public Sucursal(int id, String nombre, String descripcion, String estado, Date fechaCreacion,
			Date fechaActualizacion) {
		
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
	}
	
	public Sucursal( String nombre, String descripcion, String estado) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}
	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	
	
	
}
