package edu.unimagdalena.domicilios.modelo;


import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import javax.persistence.Table;


@Entity
@Table(name="Mensajeros")
public class Mensajero {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Column
	private String nombre;
	
	@Column
	private String correo;

	@Column
	private String numeroContacto;
	@Column
	private String numLicencia;
	
	@OneToMany(mappedBy="mensajero", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Domicilio> domicilios;
	
	public Mensajero(Long id, String nombre,String correo, String numeroContacto, String numLicencia, List<Domicilio> domicilios) {
		super();
		this.id = id;
		this.nombre = nombre;
		
		this.correo = correo;
		
		this.numeroContacto = numeroContacto;
		this.numLicencia = numLicencia;
		this.domicilios = domicilios;
		
		
	}

	public Mensajero() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}



	public String getNumeroContacto() {
		return numeroContacto;
	}

	public void setNumeroContacto(String numeroContacto) {
		this.numeroContacto = numeroContacto;
	}

	public String getNumLicencia() {
		return numLicencia;
	}

	public void setNumLicencia(String numLicencia) {
		this.numLicencia = numLicencia;
	}

	public List<Domicilio> getDomicilios() {
		return domicilios;
	}

	public void setDomicilios(List<Domicilio> domicilios) {
		this.domicilios = domicilios;
	}

	@Override
	public String toString() {
		
		return "Mensajero [id="+ id +" , nombre="+ nombre +", correo="+ correo +", numeroContacto="+ numeroContacto +", numLicencia="+ numLicencia+"]";
	}
	
	
}
