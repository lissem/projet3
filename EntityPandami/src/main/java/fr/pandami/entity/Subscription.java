package fr.pandami.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subscription implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	private LocalDateTime subscriptionDate; 
	private LocalDateTime unsubscribeDate;
	
	public Subscription() {
		super();
	}
	public Subscription(Integer id, LocalDateTime subscriptionDate, LocalDateTime unsubscribeDate) {
		super();
		this.id = id;
		this.subscriptionDate = subscriptionDate;
		this.unsubscribeDate = unsubscribeDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDateTime getSubscriptionDate() {
		return subscriptionDate;
	}
	public void setSubscriptionDate(LocalDateTime subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}
	public LocalDateTime getUnsubscribeDate() {
		return unsubscribeDate;
	}
	public void setUnsubscribeDate(LocalDateTime unsubscribeDate) {
		this.unsubscribeDate = unsubscribeDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((subscriptionDate == null) ? 0 : subscriptionDate.hashCode());
		result = prime * result + ((unsubscribeDate == null) ? 0 : unsubscribeDate.hashCode());
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
		Subscription other = (Subscription) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (subscriptionDate == null) {
			if (other.subscriptionDate != null)
				return false;
		} else if (!subscriptionDate.equals(other.subscriptionDate))
			return false;
		if (unsubscribeDate == null) {
			if (other.unsubscribeDate != null)
				return false;
		} else if (!unsubscribeDate.equals(other.unsubscribeDate))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Subscription [id=" + id + ", subscriptionDate=" + subscriptionDate + ", unsubscribeDate="
				+ unsubscribeDate + "]";
	}
	
	
	
	
}
