package edu.unimagdalena.domicilios.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Clientes")
public class Cliente {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Column
	private String nombres;
	@Column
	private String apellidos;
	@Column
	private String correo;
	@Column
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	@Column
	private Long numeroContacto;
	


	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Long getNumeroContacto() {
		return numeroContacto;
	}

	public void setNumeroContacto(Long numeroContacto) {
		this.numeroContacto = numeroContacto;
	}


	
	
	
}
