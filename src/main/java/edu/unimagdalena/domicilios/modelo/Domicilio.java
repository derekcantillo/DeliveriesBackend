package edu.unimagdalena.domicilios.modelo;




import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="Domicilios")
public class Domicilio {
	@Id @GeneratedValue(strategy =GenerationType.IDENTITY )
	private Long id;
	
	@Column(nullable=false)
	private String valor;
	
	@Column(nullable=false)
	private String direccionOrigen;
	
	@Column(nullable=false)
	private String direccionDestino;
	
	@Column(nullable=false)
	private String nombreClienteOrigen;
	
	@Column(nullable=false)
	private String nombreClienteDestino;
	
	@Column
	private boolean Estado=false;
	@Column
	@Temporal(TemporalType.DATE)
	private Date fechaDomicilio;

	
	public Domicilio(Long id, String valor, String direccionOrigen, String direccionDestino, String nombreClienteOrigen,
			String nombreClienteDestino, boolean estado, Date fechaDomicilio, Mensajero mensajero) {
		super();
		this.id = id;
		this.valor = valor;
		this.direccionOrigen = direccionOrigen;
		this.direccionDestino = direccionDestino;
		this.nombreClienteOrigen = nombreClienteOrigen;
		this.nombreClienteDestino = nombreClienteDestino;
		Estado = estado;
		this.fechaDomicilio = fechaDomicilio;
		this.mensajero = mensajero;
	}
	public Date getFechaDomicilio() {
		return fechaDomicilio;
	}
	public void setFechaDomicilio(Date fechaDomicilio) {
		this.fechaDomicilio = fechaDomicilio;
	}
	public boolean isEstado() {
		return Estado;
	}
	public void setEstado(boolean estado) {
		Estado = estado;
	}
	public String getDireccionOrigen() {
		return direccionOrigen;
	}
	public void setDireccionOrigen(String direccionOrigen) {
		this.direccionOrigen = direccionOrigen;
	}
	public String getDireccionDestino() {
		return direccionDestino;
	}
	public void setDireccionDestino(String direccionDestino) {
		this.direccionDestino = direccionDestino;
	}
	public String getNombreClienteOrigen() {
		return nombreClienteOrigen;
	}
	public void setNombreClienteOrigen(String nombreClienteOrigen) {
		this.nombreClienteOrigen = nombreClienteOrigen;
	}
	public String getNombreClienteDestino() {
		return nombreClienteDestino;
	}
	public void setNombreClienteDestino(String nombreClienteDestino) {
		this.nombreClienteDestino = nombreClienteDestino;
	}

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="idmensajero")
	private Mensajero mensajero;

	public Domicilio() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mensajero getMensajero() {
		return mensajero;
	}

	public void setMensajero(Mensajero mensajero) {
		this.mensajero = mensajero;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	
	
}
