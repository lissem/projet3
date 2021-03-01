package fr.pandami.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="NegocationDate")
public class NegociationDate implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int	idNegociation;
	private Date dateCreation; 
	private Date dateCloture; 
	private Date dateDebutProposee; 
	private Date dateFinProposee; 
	private Boolean estAcceptee;
	
	public NegociationDate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public NegociationDate(int idNegociation, Date dateCreation, Date dateCloture, Date dateDebutProposee,
			Date dateFinProposee, Boolean estAcceptee) {
		super();
		this.idNegociation = idNegociation;
		this.dateCreation = dateCreation;
		this.dateCloture = dateCloture;
		this.dateDebutProposee = dateDebutProposee;
		this.dateFinProposee = dateFinProposee;
		this.estAcceptee = estAcceptee;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateCloture == null) ? 0 : dateCloture.hashCode());
		result = prime * result + ((dateCreation == null) ? 0 : dateCreation.hashCode());
		result = prime * result + ((dateDebutProposee == null) ? 0 : dateDebutProposee.hashCode());
		result = prime * result + ((dateFinProposee == null) ? 0 : dateFinProposee.hashCode());
		result = prime * result + ((estAcceptee == null) ? 0 : estAcceptee.hashCode());
		result = prime * result + idNegociation;
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
		NegociationDate other = (NegociationDate) obj;
		if (dateCloture == null) {
			if (other.dateCloture != null)
				return false;
		} else if (!dateCloture.equals(other.dateCloture))
			return false;
		if (dateCreation == null) {
			if (other.dateCreation != null)
				return false;
		} else if (!dateCreation.equals(other.dateCreation))
			return false;
		if (dateDebutProposee == null) {
			if (other.dateDebutProposee != null)
				return false;
		} else if (!dateDebutProposee.equals(other.dateDebutProposee))
			return false;
		if (dateFinProposee == null) {
			if (other.dateFinProposee != null)
				return false;
		} else if (!dateFinProposee.equals(other.dateFinProposee))
			return false;
		if (estAcceptee == null) {
			if (other.estAcceptee != null)
				return false;
		} else if (!estAcceptee.equals(other.estAcceptee))
			return false;
		if (idNegociation != other.idNegociation)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NegociationDate [idNegociation=" + idNegociation + ", dateCreation=" + dateCreation + ", dateCloture="
				+ dateCloture + ", dateDebutProposee=" + dateDebutProposee + ", dateFinProposee=" + dateFinProposee
				+ ", estAcceptee=" + estAcceptee + "]";
	}

	public int getIdNegociation() {
		return idNegociation;
	}

	public void setIdNegociation(int idNegociation) {
		this.idNegociation = idNegociation;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateCloture() {
		return dateCloture;
	}

	public void setDateCloture(Date dateCloture) {
		this.dateCloture = dateCloture;
	}

	public Date getDateDebutProposee() {
		return dateDebutProposee;
	}

	public void setDateDebutProposee(Date dateDebutProposee) {
		this.dateDebutProposee = dateDebutProposee;
	}

	public Date getDateFinProposee() {
		return dateFinProposee;
	}

	public void setDateFinProposee(Date dateFinProposee) {
		this.dateFinProposee = dateFinProposee;
	}

	public Boolean getEstAcceptee() {
		return estAcceptee;
	}

	public void setEstAcceptee(Boolean estAcceptee) {
		this.estAcceptee = estAcceptee;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	} 
	
	
}
