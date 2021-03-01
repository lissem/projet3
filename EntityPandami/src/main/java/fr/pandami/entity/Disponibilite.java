package fr.pandami.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "disponibilite")
public class Disponibilite implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer jourDeLaSemaine;
	private Date heureDeDeDebut;
	private Date heureDeDeFin;
	private Date dateDebutValidite;
	private Date dateFinValidite;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getJourDeLaSemaine() {
		return jourDeLaSemaine;
	}
	public void setJourDeLaSemaine(Integer jourDeLaSemaine) {
		this.jourDeLaSemaine = jourDeLaSemaine;
	}
	public Date getHeureDeDeDebut() {
		return heureDeDeDebut;
	}
	public void setHeureDeDeDebut(Date heureDeDeDebut) {
		this.heureDeDeDebut = heureDeDeDebut;
	}
	public Date getHeureDeDeFin() {
		return heureDeDeFin;
	}
	public void setHeureDeDeFin(Date heureDeDeFin) {
		this.heureDeDeFin = heureDeDeFin;
	}
	public Date getDateDebutValidite() {
		return dateDebutValidite;
	}
	public void setDateDebutValidite(Date dateDebutValidite) {
		this.dateDebutValidite = dateDebutValidite;
	}
	public Date getDateFinValidite() {
		return dateFinValidite;
	}
	public void setDateFinValidite(Date dateFinValidite) {
		this.dateFinValidite = dateFinValidite;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateDebutValidite == null) ? 0 : dateDebutValidite.hashCode());
		result = prime * result + ((dateFinValidite == null) ? 0 : dateFinValidite.hashCode());
		result = prime * result + ((heureDeDeDebut == null) ? 0 : heureDeDeDebut.hashCode());
		result = prime * result + ((heureDeDeFin == null) ? 0 : heureDeDeFin.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((jourDeLaSemaine == null) ? 0 : jourDeLaSemaine.hashCode());
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
		Disponibilite other = (Disponibilite) obj;
		if (dateDebutValidite == null) {
			if (other.dateDebutValidite != null)
				return false;
		} else if (!dateDebutValidite.equals(other.dateDebutValidite))
			return false;
		if (dateFinValidite == null) {
			if (other.dateFinValidite != null)
				return false;
		} else if (!dateFinValidite.equals(other.dateFinValidite))
			return false;
		if (heureDeDeDebut == null) {
			if (other.heureDeDeDebut != null)
				return false;
		} else if (!heureDeDeDebut.equals(other.heureDeDeDebut))
			return false;
		if (heureDeDeFin == null) {
			if (other.heureDeDeFin != null)
				return false;
		} else if (!heureDeDeFin.equals(other.heureDeDeFin))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (jourDeLaSemaine == null) {
			if (other.jourDeLaSemaine != null)
				return false;
		} else if (!jourDeLaSemaine.equals(other.jourDeLaSemaine))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Disponibilite [id=" + id + ", jourDeLaSemaine=" + jourDeLaSemaine + ", heureDeDeDebut=" + heureDeDeDebut
				+ ", heureDeDeFin=" + heureDeDeFin + ", dateDebutValidite=" + dateDebutValidite + ", dateFinValidite="
				+ dateFinValidite + "]";
	}
	public Disponibilite(Integer id, Integer jourDeLaSemaine, Date heureDeDeDebut, Date heureDeDeFin,
			Date dateDebutValidite, Date dateFinValidite) {
		super();
		this.id = id;
		this.jourDeLaSemaine = jourDeLaSemaine;
		this.heureDeDeDebut = heureDeDeDebut;
		this.heureDeDeFin = heureDeDeFin;
		this.dateDebutValidite = dateDebutValidite;
		this.dateFinValidite = dateFinValidite;
	}
	public Disponibilite() {
		super();
	}
	
	
}
