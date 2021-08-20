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
@Table(name="Paquetes")
public class Paquete {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private int cantidad;
	
	@ManyToOne
	@JoinColumn(name="idcategorypack")
	private CategoriaPaquete categoriapaquete;

	public Paquete() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public CategoriaPaquete getCategoriapaquete() {
		return categoriapaquete;
	}

	public void setCategoriapaquete(CategoriaPaquete categoriapaquete) {
		this.categoriapaquete = categoriapaquete;
	}
	
	
}
