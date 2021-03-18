package fr.pandami.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Service implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDateTime creationDate = LocalDateTime.now();
	private LocalDate startDate;
	private LocalTime startTime;
	private LocalDate endDate;
	private LocalTime endTime;
	private LocalDate closingDate;
	private LocalDateTime cancellationDate;
	private LocalDate acceptationDate;
	
	@ManyToOne
	@JoinColumn (referencedColumnName = "id")
	private Address address;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn (referencedColumnName = "id")
	private User creator = new User();
	
	
	@ManyToOne
	@JoinColumn (referencedColumnName = "id")
	private ServiceType serviceType = new ServiceType();
	
	@ManyToOne
	@JoinColumn (referencedColumnName = "id")
	private Equipment equipment = new Equipment();
	
	@ManyToOne
	@JoinColumn (referencedColumnName = "id" )
	private CancellationCause cancellationCause;
	
	@OneToMany(mappedBy = "service", fetch = FetchType.EAGER)
	private List<Subscription> subscriptionList;
	
	
	public CancellationCause getCancellationCause() {
		return cancellationCause;
	}

	public void setCancellationCause(CancellationCause cancellationCause) {
		this.cancellationCause = cancellationCause;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	

	public ServiceType getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	public Service() {
		super();
	}

	public Service(Integer id, LocalDateTime creationDate, LocalDate startDate, LocalDate endDate,
			LocalDate closingDate, LocalDateTime cancellationDate) {
		super();
		this.id = id;
		this.creationDate = creationDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.closingDate = closingDate;
		this.cancellationDate = cancellationDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public LocalDate getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(LocalDate closingDate) {
		this.closingDate = closingDate;
	}

	public LocalDateTime getCancellationDate() {
		return cancellationDate;
	}

	public void setCancellationDate(LocalDateTime cancellationDate) {
		this.cancellationDate = cancellationDate;
	}
	

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public LocalDate getAcceptationDate() {
		return acceptationDate;
	}

	public void setAcceptationDate(LocalDate acceptationDate) {
		this.acceptationDate = acceptationDate;
	}

	@Override
	public String toString() {
		return "Service [id=" + id + ", creationDate=" + creationDate + ", startDate=" + startDate + ", startTime="
				+ startTime + ", endDate=" + endDate + ", endTime=" + endTime + ", closingDate=" + closingDate
				+ ", cancellationDate=" + cancellationDate + ", acceptationDate=" + acceptationDate + ", address="
				+ address + ", creator=" + creator + ", serviceType=" + serviceType + ", equipment=" + equipment
				+ ", cancellationCause=" + cancellationCause + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acceptationDate == null) ? 0 : acceptationDate.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((cancellationCause == null) ? 0 : cancellationCause.hashCode());
		result = prime * result + ((cancellationDate == null) ? 0 : cancellationDate.hashCode());
		result = prime * result + ((closingDate == null) ? 0 : closingDate.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((creator == null) ? 0 : creator.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((equipment == null) ? 0 : equipment.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((serviceType == null) ? 0 : serviceType.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
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
		if (acceptationDate == null) {
			if (other.acceptationDate != null)
				return false;
		} else if (!acceptationDate.equals(other.acceptationDate))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (cancellationCause == null) {
			if (other.cancellationCause != null)
				return false;
		} else if (!cancellationCause.equals(other.cancellationCause))
			return false;
		if (cancellationDate == null) {
			if (other.cancellationDate != null)
				return false;
		} else if (!cancellationDate.equals(other.cancellationDate))
			return false;
		if (closingDate == null) {
			if (other.closingDate != null)
				return false;
		} else if (!closingDate.equals(other.closingDate))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (creator == null) {
			if (other.creator != null)
				return false;
		} else if (!creator.equals(other.creator))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (equipment == null) {
			if (other.equipment != null)
				return false;
		} else if (!equipment.equals(other.equipment))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (serviceType == null) {
			if (other.serviceType != null)
				return false;
		} else if (!serviceType.equals(other.serviceType))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		return true;
	}

	
	 
	
	
	
	 

}
