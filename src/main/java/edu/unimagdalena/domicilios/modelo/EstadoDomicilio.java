package edu.unimagdalena.domicilios.modelo;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="estados")
public class EstadoDomicilio {
	@Id @GeneratedValue(strategy =GenerationType.IDENTITY )
	private Long id;
	@Column
	private String nombreEstado;
	
	

	public EstadoDomicilio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreEstado() {
		return nombreEstado;
	}

	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}

	
	
}
