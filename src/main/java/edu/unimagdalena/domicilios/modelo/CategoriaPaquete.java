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
@Table(name="CategoriasPaquetes")
public class CategoriaPaquete {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nombre;
	
	@OneToMany(mappedBy = "categoriapaquete")
	private Set<Paquete> Paquetes;

	public CategoriaPaquete() {
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

	public Set<Paquete> getPaquetes() {
		return Paquetes;
	}

	public void setPaquetes(Set<Paquete> paquetes) {
		Paquetes = paquetes;
	}

}
