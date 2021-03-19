package fr.pandami.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Negociation implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int	id;
	private LocalDate creationLocalDateTime; 
	private LocalDate closingLocalDateTime; 
	private LocalTime proposedStartLocalDateTime; 
	private LocalTime proposedEndLocalDateTime; 

	//ligne pour test commit à retirer :)
	@ManyToOne
	@JoinColumn (referencedColumnName = "id")
	private User beneficiary; 
	
	@ManyToOne
	@JoinColumn (referencedColumnName = "id")
	private User volunteer; 
	
	@ManyToOne
	@JoinColumn (referencedColumnName = "id")
	private Service service;

	public Negociation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Negociation(int id, LocalDate creationLocalDateTime, LocalDate closingLocalDateTime,
			LocalTime proposedStartLocalDateTime, LocalTime proposedEndLocalDateTime, User beneficiary, User volunteer,
			Service service) {
		super();
		this.id = id;
		this.creationLocalDateTime = creationLocalDateTime;
		this.closingLocalDateTime = closingLocalDateTime;
		this.proposedStartLocalDateTime = proposedStartLocalDateTime;
		this.proposedEndLocalDateTime = proposedEndLocalDateTime;
		this.beneficiary = beneficiary;
		this.volunteer = volunteer;
		this.service = service;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beneficiary == null) ? 0 : beneficiary.hashCode());
		result = prime * result + ((closingLocalDateTime == null) ? 0 : closingLocalDateTime.hashCode());
		result = prime * result + ((creationLocalDateTime == null) ? 0 : creationLocalDateTime.hashCode());
		result = prime * result + id;
		result = prime * result + ((proposedEndLocalDateTime == null) ? 0 : proposedEndLocalDateTime.hashCode());
		result = prime * result + ((proposedStartLocalDateTime == null) ? 0 : proposedStartLocalDateTime.hashCode());
		result = prime * result + ((service == null) ? 0 : service.hashCode());
		result = prime * result + ((volunteer == null) ? 0 : volunteer.hashCode());
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
		Negociation other = (Negociation) obj;
		if (beneficiary == null) {
			if (other.beneficiary != null)
				return false;
		} else if (!beneficiary.equals(other.beneficiary))
			return false;
		if (closingLocalDateTime == null) {
			if (other.closingLocalDateTime != null)
				return false;
		} else if (!closingLocalDateTime.equals(other.closingLocalDateTime))
			return false;
		if (creationLocalDateTime == null) {
			if (other.creationLocalDateTime != null)
				return false;
		} else if (!creationLocalDateTime.equals(other.creationLocalDateTime))
			return false;
		if (id != other.id)
			return false;
		if (proposedEndLocalDateTime == null) {
			if (other.proposedEndLocalDateTime != null)
				return false;
		} else if (!proposedEndLocalDateTime.equals(other.proposedEndLocalDateTime))
			return false;
		if (proposedStartLocalDateTime == null) {
			if (other.proposedStartLocalDateTime != null)
				return false;
		} else if (!proposedStartLocalDateTime.equals(other.proposedStartLocalDateTime))
			return false;
		if (service == null) {
			if (other.service != null)
				return false;
		} else if (!service.equals(other.service))
			return false;
		if (volunteer == null) {
			if (other.volunteer != null)
				return false;
		} else if (!volunteer.equals(other.volunteer))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Negociation [id=" + id + ", creationLocalDateTime=" + creationLocalDateTime + ", closingLocalDateTime="
				+ closingLocalDateTime + ", proposedStartLocalDateTime=" + proposedStartLocalDateTime
				+ ", proposedEndLocalDateTime=" + proposedEndLocalDateTime + ", beneficiary=" + beneficiary
				+ ", volunteer=" + volunteer + ", service=" + service + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getCreationLocalDateTime() {
		return creationLocalDateTime;
	}

	public void setCreationLocalDateTime(LocalDate creationLocalDateTime) {
		this.creationLocalDateTime = creationLocalDateTime;
	}

	public LocalDate getClosingLocalDateTime() {
		return closingLocalDateTime;
	}

	public void setClosingLocalDateTime(LocalDate closingLocalDateTime) {
		this.closingLocalDateTime = closingLocalDateTime;
	}

	public LocalTime getProposedStartLocalDateTime() {
		return proposedStartLocalDateTime;
	}

	public void setProposedStartLocalDateTime(LocalTime proposedStartLocalDateTime) {
		this.proposedStartLocalDateTime = proposedStartLocalDateTime;
	}

	public LocalTime getProposedEndLocalDateTime() {
		return proposedEndLocalDateTime;
	}

	public void setProposedEndLocalDateTime(LocalTime proposedEndLocalDateTime) {
		this.proposedEndLocalDateTime = proposedEndLocalDateTime;
	}

	public User getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(User beneficiary) {
		this.beneficiary = beneficiary;
	}

	public User getVolunteer() {
		return volunteer;
	}

	public void setVolunteer(User volunteer) {
		this.volunteer = volunteer;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	} 
	
}