package fr.pandami.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "preference_service")
public class PreferenceService implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDateTime validityStartDate = LocalDateTime.now();
	private LocalDateTime validityEndDate;

	@ManyToOne
	@JoinColumn (referencedColumnName = "id")
	private ServiceType serviceType;
	@ManyToOne
	@JoinColumn (referencedColumnName = "id")
	private User user;
	

	public PreferenceService() {
		super();
	}
	public PreferenceService(Integer id, LocalDateTime validityStartDate, LocalDateTime validityEndDate) {
		super();
		this.id = id;
		this.validityStartDate = validityStartDate;
		this.validityEndDate = validityEndDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDateTime getValidityStartDate() {
		return validityStartDate;
	}
	public void setValidityStartDate(LocalDateTime validityStartDate) {
		this.validityStartDate = validityStartDate;
	}
	public LocalDateTime getValidityEndDate() {
		return validityEndDate;
	}
	public void setValidityEndDate(LocalDateTime validityEndDate) {
		this.validityEndDate = validityEndDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((validityEndDate == null) ? 0 : validityEndDate.hashCode());
		result = prime * result + ((validityStartDate == null) ? 0 : validityStartDate.hashCode());
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
		PreferenceService other = (PreferenceService) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (validityEndDate == null) {
			if (other.validityEndDate != null)
				return false;
		} else if (!validityEndDate.equals(other.validityEndDate))
			return false;
		if (validityStartDate == null) {
			if (other.validityStartDate != null)
				return false;
		} else if (!validityStartDate.equals(other.validityStartDate))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PreferenceService [id=" + id + ", validityStartDate=" + validityStartDate + ", validityEndDate="
				+ validityEndDate + "]";
	}
	
	public ServiceType getServiceType() {
		return serviceType;
	}
	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}