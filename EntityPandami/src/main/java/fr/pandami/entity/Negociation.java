package fr.pandami.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
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
	private LocalDate creationLocalDateTime = LocalDate.now(); 
	private LocalDate closingLocalDateTime; 
	private LocalDate proposedStartDate; 
	private LocalDate proposedEndDate; 
	private LocalTime proposedStartTime; 
	private LocalTime proposedEndTime;
	private Boolean isAccepted= false;
	
	@ManyToOne
	@JoinColumn (referencedColumnName = "id")
	private User asker; 
	
	@ManyToOne
	@JoinColumn (referencedColumnName = "id")
	private User answerer; 
	
	@ManyToOne
	@JoinColumn (referencedColumnName = "id")
	private Service service;

	public Negociation() {
		super();
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

	public LocalDate getProposedStartDate() {
		return proposedStartDate;
	}

	public void setProposedStartDate(LocalDate proposedStartDate) {
		this.proposedStartDate = proposedStartDate;
	}

	public LocalDate getProposedEndDate() {
		return proposedEndDate;
	}

	public void setProposedEndDate(LocalDate proposedEndDate) {
		this.proposedEndDate = proposedEndDate;
	}

	public LocalTime getProposedStartTime() {
		return proposedStartTime;
	}

	public void setProposedStartTime(LocalTime proposedStartTime) {
		this.proposedStartTime = proposedStartTime;
	}

	public LocalTime getProposedEndTime() {
		return proposedEndTime;
	}

	public void setProposedEndTime(LocalTime proposedEndTime) {
		this.proposedEndTime = proposedEndTime;
	}

	public boolean isAccepted() {
		return isAccepted;
	}

	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}

	public User getAsker() {
		return asker;
	}

	public void setAsker(User asker) {
		this.asker = asker;
	}

	public User getAnswerer() {
		return answerer;
	}

	public void setAnswerer(User answerer) {
		this.answerer = answerer;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((closingLocalDateTime == null) ? 0 : closingLocalDateTime.hashCode());
		result = prime * result + ((creationLocalDateTime == null) ? 0 : creationLocalDateTime.hashCode());
		result = prime * result + id;
		result = prime * result + (isAccepted ? 1231 : 1237);
		result = prime * result + ((proposedEndDate == null) ? 0 : proposedEndDate.hashCode());
		result = prime * result + ((proposedEndTime == null) ? 0 : proposedEndTime.hashCode());
		result = prime * result + ((proposedStartDate == null) ? 0 : proposedStartDate.hashCode());
		result = prime * result + ((proposedStartTime == null) ? 0 : proposedStartTime.hashCode());
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
		if (isAccepted != other.isAccepted)
			return false;
		if (proposedEndDate == null) {
			if (other.proposedEndDate != null)
				return false;
		} else if (!proposedEndDate.equals(other.proposedEndDate))
			return false;
		if (proposedEndTime == null) {
			if (other.proposedEndTime != null)
				return false;
		} else if (!proposedEndTime.equals(other.proposedEndTime))
			return false;
		if (proposedStartDate == null) {
			if (other.proposedStartDate != null)
				return false;
		} else if (!proposedStartDate.equals(other.proposedStartDate))
			return false;
		if (proposedStartTime == null) {
			if (other.proposedStartTime != null)
				return false;
		} else if (!proposedStartTime.equals(other.proposedStartTime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Negociation [id=" + id + ", creationLocalDateTime=" + creationLocalDateTime + ", closingLocalDateTime="
				+ closingLocalDateTime + ", proposedStartDate=" + proposedStartDate + ", proposedEndDate="
				+ proposedEndDate + ", proposedStartTime=" + proposedStartTime + ", proposedEndTime=" + proposedEndTime
				+ ", isAccepted=" + isAccepted + ", asker=" + asker + ", answerer=" + answerer + ", service=" + service
				+ "]";
	}

	
	
}