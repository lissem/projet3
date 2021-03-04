package fr.pandami.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Negociation implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int	id;
	private LocalDateTime creationLocalDateTime; 
	private LocalDateTime closingLocalDateTime; 
	private LocalDateTime proposedStartLocalDateTime; 
	private LocalDateTime proposedEndLocalDateTime; 
	private Boolean isAccepted;
	
	public Negociation() {
		super();
	}

	public Negociation(int id, LocalDateTime creationLocalDateTime, LocalDateTime closingLocalDateTime, LocalDateTime proposedStartLocalDateTime, LocalDateTime proposedEndLocalDateTime,
			Boolean isAccepted) {
		super();
		this.id = id;
		this.creationLocalDateTime = creationLocalDateTime;
		this.closingLocalDateTime = closingLocalDateTime;
		this.proposedStartLocalDateTime = proposedStartLocalDateTime;
		this.proposedEndLocalDateTime = proposedEndLocalDateTime;
		this.isAccepted = isAccepted;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getCreationLocalDateTime() {
		return creationLocalDateTime;
	}

	public void setCreationLocalDateTime(LocalDateTime creationLocalDateTime) {
		this.creationLocalDateTime = creationLocalDateTime;
	}

	public LocalDateTime getClosingLocalDateTime() {
		return closingLocalDateTime;
	}

	public void setClosingLocalDateTime(LocalDateTime closingLocalDateTime) {
		this.closingLocalDateTime = closingLocalDateTime;
	}

	public LocalDateTime getProposedStartLocalDateTime() {
		return proposedStartLocalDateTime;
	}

	public void setProposedStartLocalDateTime(LocalDateTime proposedStartLocalDateTime) {
		this.proposedStartLocalDateTime = proposedStartLocalDateTime;
	}

	public LocalDateTime getProposedEndLocalDateTime() {
		return proposedEndLocalDateTime;
	}

	public void setProposedEndLocalDateTime(LocalDateTime proposedEndLocalDateTime) {
		this.proposedEndLocalDateTime = proposedEndLocalDateTime;
	}

	public Boolean getIsAccepted() {
		return isAccepted;
	}

	public void setIsAccepted(Boolean isAccepted) {
		this.isAccepted = isAccepted;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((closingLocalDateTime == null) ? 0 : closingLocalDateTime.hashCode());
		result = prime * result + ((creationLocalDateTime == null) ? 0 : creationLocalDateTime.hashCode());
		result = prime * result + id;
		result = prime * result + ((isAccepted == null) ? 0 : isAccepted.hashCode());
		result = prime * result + ((proposedEndLocalDateTime == null) ? 0 : proposedEndLocalDateTime.hashCode());
		result = prime * result + ((proposedStartLocalDateTime == null) ? 0 : proposedStartLocalDateTime.hashCode());
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
		if (isAccepted == null) {
			if (other.isAccepted != null)
				return false;
		} else if (!isAccepted.equals(other.isAccepted))
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
		return true;
	}

	@Override
	public String toString() {
		return "Negociation [id=" + id + ", creationLocalDateTime=" + creationLocalDateTime + ", closingLocalDateTime=" + closingLocalDateTime
				+ ", proposedStartLocalDateTime=" + proposedStartLocalDateTime + ", proposedEndLocalDateTime=" + proposedEndLocalDateTime + ", isAccepted="
				+ isAccepted + "]";
	}
	
	
	
}
