package fr.pandami.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "materiel")
public class Materiel implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMateriel;
	private String libelle;
	
	
	
	public Materiel() {
		super();
		
	}


	public Materiel(Integer idMateriel, String libelle) {
		super();
		this.idMateriel = idMateriel;
		this.libelle = libelle;
	}
	
	
	public Integer getIdMateriel() {
		return idMateriel;
	}
	public void setIdMateriel(Integer idMateriel) {
		this.idMateriel = idMateriel;
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
		result = prime * result + ((idMateriel == null) ? 0 : idMateriel.hashCode());
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
		Materiel other = (Materiel) obj;
		if (idMateriel == null) {
			if (other.idMateriel != null)
				return false;
		} else if (!idMateriel.equals(other.idMateriel))
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
		return "Materiel [idMateriel=" + idMateriel + ", libelle=" + libelle + "]";
	}
	
	

}
