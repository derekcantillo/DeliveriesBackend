package edu.unimagdalena.domicilios.modelo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name="Vehiculos")
public class Vehiculo {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String marca;
	
	@Column
	private String modelo;
	
	
	@ManyToOne
	@JoinColumn(name="idtipovehiculo")
	private TipoVehiculo tipovehiculo;
	
	public TipoVehiculo getTipovehiculo() {
		return tipovehiculo;
	}

	public void setTipovehiculo(TipoVehiculo tipovehiculo) {
		this.tipovehiculo = tipovehiculo;
	}

	public Vehiculo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	
	
}
