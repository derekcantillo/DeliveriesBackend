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
@Table(name="tiposdocumentos")
public class TipoDocumento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTipoDoc;
	

	@Column
	private String nombredoc;
	
	@OneToMany(mappedBy = "tipodocumento")
	private Set<Documento> documentos;
	
	public TipoDocumento() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getIdTipoDoc() {
		return idTipoDoc;
	}

	public void setIdTipoDoc(Long idTipoDoc) {
		this.idTipoDoc = idTipoDoc;
	}

	public String getNombredoc() {
		return nombredoc;
	}

	public void setNumberdoc(String nombredoc) {
		this.nombredoc = nombredoc;
	}


	public Set<Documento> getDocumentos() {
		return documentos;
	}


	public void setDocumentos(Set<Documento> documentos) {
		this.documentos = documentos;
	}


}
