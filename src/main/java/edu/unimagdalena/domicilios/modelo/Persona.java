package edu.unimagdalena.domicilios.modelo;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Personas")
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPersona;
	@Column
	private String nombres;
	@Column
	private String apellidos;
	@Column
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	@Column
	private Long numContacto;
	@Column
	private String correo;
	
	@OneToMany(mappedBy = "persona")
	private Set<Documento> documentos;
	
	
	
	public Set<Documento> getDocumentos() {
		return documentos;
	}



	public void setDocumentos(Set<Documento> documentos) {
		this.documentos = documentos;
	}



	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
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

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Long getNumContacto() {
		return numContacto;
	}

	public void setNumContacto(Long numContacto) {
		this.numContacto = numContacto;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
	
}
