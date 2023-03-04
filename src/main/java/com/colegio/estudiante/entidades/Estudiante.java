package com.colegio.estudiante.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Estudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Long numeroDeIdentificacion;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String fechaDeNacimiento;
	private String direccion;
	private String correo;
	private Long telefono;
	private Double promedio;
	private int usuarioId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getNumeroDeIdentificacion() {
		return numeroDeIdentificacion;
	}

	public void setNumeroDeIdentificacion(Long numeroDeIdentificacion) {
		this.numeroDeIdentificacion = numeroDeIdentificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(String fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public Double getPromedio() {
		return promedio;
	}

	public void setPromedio(Double promedio) {
		this.promedio = promedio;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Estudiante() {}

	public Estudiante(Long numeroDeIdentificacion, String nombre, String apellido1, String apellido2,
			String fechaDeNacimiento, String direccion, String correo, Long telefono, Double promedio, int usuarioId) {
		this.numeroDeIdentificacion = numeroDeIdentificacion;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.direccion = direccion;
		this.correo = correo;
		this.telefono = telefono;
		this.promedio = promedio;
		this.usuarioId = usuarioId;
	}

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", numeroDeIdentificacion=" + numeroDeIdentificacion + ", nombre=" + nombre
				+ ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", fechaDeNacimiento=" + fechaDeNacimiento
				+ ", direccion=" + direccion + ", correo=" + correo + ", telefono=" + telefono + ", promedio="
				+ promedio + ", usuarioId=" + usuarioId + "]";
	}
	
}
