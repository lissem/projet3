package fr.pandami.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "motif_annulation")

public class MotifAnnulation implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMotifAnnulation;
	private String libelle;
	
	
	
	public MotifAnnulation() {
		super();
		
	}
	
	public MotifAnnulation(Integer idMotifAnnulation, String libelle) {
		super();
		this.idMotifAnnulation = idMotifAnnulation;
		this.libelle = libelle;
	}
	public Integer getIdMotifAnnulation() {
		return idMotifAnnulation;
	}
	public void setIdMotifAnnulation(Integer idMotifAnnulation) {
		this.idMotifAnnulation = idMotifAnnulation;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idMotifAnnulation == null) ? 0 : idMotifAnnulation.hashCode());
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MotifAnnulation other = (MotifAnnulation) obj;
		if (idMotifAnnulation == null) {
			if (other.idMotifAnnulation != null)
				return false;
		} else if (!idMotifAnnulation.equals(other.idMotifAnnulation))
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MotifAnnulation [idMotifAnnulation=" + idMotifAnnulation + ", libelle=" + libelle + "]";
	}
	
	

}
