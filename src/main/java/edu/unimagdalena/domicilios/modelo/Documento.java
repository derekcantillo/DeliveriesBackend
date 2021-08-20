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
@Table(name="Documentos")
public class Documento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDoc;
	
	@Column
	private Long numberdoc;
	@ManyToOne
	@JoinColumn(name="idtiposdocs")
	private TipoDocumento tipodocumento;
	
	@ManyToOne
	@JoinColumn(name="idpersona")
	private Persona persona;
	
	public Persona getPersona() {
		return persona;
	}


	public void setPersona(Persona persona) {
		this.persona = persona;
	}


	public TipoDocumento getTipodocumento() {
		return tipodocumento;
	}


	public void setTipodocumento(TipoDocumento tipodocumento) {
		this.tipodocumento = tipodocumento;
	}


	public Documento() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Long getIdDoc() {
		return idDoc;
	}

	public void setIdDoc(Long idDoc) {
		this.idDoc = idDoc;
	}

	


	
	
}
