package fr.pandami.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sexe")
public class Sexe implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomSexe;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomSexe() {
		return nomSexe;
	}
	public void setNomSexe(String nomSexe) {
		this.nomSexe = nomSexe;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomSexe == null) ? 0 : nomSexe.hashCode());
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
		Sexe other = (Sexe) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomSexe == null) {
			if (other.nomSexe != null)
				return false;
		} else if (!nomSexe.equals(other.nomSexe))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Sexe [id=" + id + ", nomSexe=" + nomSexe + "]";
	}
	public Sexe(Integer id, String nomSexe) {
		super();
		this.id = id;
		this.nomSexe = nomSexe;
	}
	public Sexe() {
		super();
	}
}
