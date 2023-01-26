package com.examenp.app.entity;

import java.io.Serializable;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name="productos")
public class Producto implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod", nullable=false, length = 10, unique=true)
	private Long codigo;
	@Column(name="descripcion", nullable=false, length = 100, unique=false)
	private String descripcion;
	@Column(name="precio", nullable=false, length = 10, unique=false)
	private float precio;
	@Column(name="cantidad", nullable=false, length = 10, unique=false)
	private int cantidad;
	@Column(name="preciot", nullable=false, length = 10, unique=false)
	private float preciototal;
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public float getPreciototal() {
		return preciototal;
	}
	public void setPreciototal(float preciototal) {
		this.preciototal = preciototal;
	}
	
}
