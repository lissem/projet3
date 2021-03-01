package fr.pandami.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "service")
public class Service implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idService;
	private Date dateCreation;
	private Date dateDebut;
	private Date dateFin;
	private Date dateCloture;
	private Date dateAnnulation;
	
	
	
	
	public Service() {
		super();
		
	}
	
	
	public Service(Integer idService, Date dateCreation, Date dateDebut, Date dateFin, Date dateCloture,
			Date dateAnnulation) {
		super();
		this.idService = idService;
		this.dateCreation = dateCreation;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.dateCloture = dateCloture;
		this.dateAnnulation = dateAnnulation;
	}

	

	public Integer getIdService() {
		return idService;
	}
	public void setIdService(Integer idService) {
		this.idService = idService;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public Date getDateCloture() {
		return dateCloture;
	}
	public void setDateCloture(Date dateCloture) {
		this.dateCloture = dateCloture;
	}
	public Date getDateAnnulation() {
		return dateAnnulation;
	}
	public void setDateAnnulation(Date dateAnnulation) {
		this.dateAnnulation = dateAnnulation;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateAnnulation == null) ? 0 : dateAnnulation.hashCode());
		result = prime * result + ((dateCloture == null) ? 0 : dateCloture.hashCode());
		result = prime * result + ((dateCreation == null) ? 0 : dateCreation.hashCode());
		result = prime * result + ((dateDebut == null) ? 0 : dateDebut.hashCode());
		result = prime * result + ((dateFin == null) ? 0 : dateFin.hashCode());
		result = prime * result + ((idService == null) ? 0 : idService.hashCode());
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
		Service other = (Service) obj;
		if (dateAnnulation == null) {
			if (other.dateAnnulation != null)
				return false;
		} else if (!dateAnnulation.equals(other.dateAnnulation))
			return false;
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
		if (dateDebut == null) {
			if (other.dateDebut != null)
				return false;
		} else if (!dateDebut.equals(other.dateDebut))
			return false;
		if (dateFin == null) {
			if (other.dateFin != null)
				return false;
		} else if (!dateFin.equals(other.dateFin))
			return false;
		if (idService == null) {
			if (other.idService != null)
				return false;
		} else if (!idService.equals(other.idService))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Service [idService=" + idService + ", dateCreation=" + dateCreation + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + ", dateCloture=" + dateCloture + ", dateAnnulation=" + dateAnnulation + "]";
	}
	
	
	 

}
