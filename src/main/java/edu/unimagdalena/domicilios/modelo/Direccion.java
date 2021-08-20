package edu.unimagdalena.domicilios.modelo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Direcciones")
public class Direccion {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String description;
	
	@Column
	private Long codigopostal;
	
	
	@OneToMany(mappedBy = "direccion")
	private Set<Pais> Paises;
	
	@OneToMany(mappedBy = "direccion")
	private Set<Ciudad> Ciudades;
	
	@OneToMany(mappedBy = "direccion")
	private Set<Departamento> Departamentos;
	
	
	@OneToMany(mappedBy = "direccion")
	private Set<TipoVia> TiposVias;
	
	public Direccion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCodigopostal() {
		return codigopostal;
	}

	public void setCodigopostal(Long codigopostal) {
		this.codigopostal = codigopostal;
	}
	
	
}
