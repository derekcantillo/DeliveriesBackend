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
@Table(name="TiposVehiculos")
public class TipoVehiculo {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nombretipo;
	
	@OneToMany(mappedBy = "tipovehiculo")
	private Set<Vehiculo> Vehiculos;

	public TipoVehiculo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombretipo() {
		return nombretipo;
	}

	public void setNombretipo(String nombretipo) {
		this.nombretipo = nombretipo;
	}

	public Set<Vehiculo> getVehiculos() {
		return Vehiculos;
	}

	public void setVehiculos(Set<Vehiculo> vehiculos) {
		Vehiculos = vehiculos;
	}
	
	
}
