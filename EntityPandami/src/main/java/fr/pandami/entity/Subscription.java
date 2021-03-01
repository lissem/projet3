package fr.pandami.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="inscription")
public class Subscription implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idReponse; 
	private Date inscribtion; 
	private Date desinscription;
	
	public Subscription() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subscription(int idReponse, Date inscribtion, Date desinscription) {
		super();
		this.idReponse = idReponse;
		this.inscribtion = inscribtion;
		this.desinscription = desinscription;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desinscription == null) ? 0 : desinscription.hashCode());
		result = prime * result + idReponse;
		result = prime * result + ((inscribtion == null) ? 0 : inscribtion.hashCode());
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
		if (desinscription == null) {
			if (other.desinscription != null)
				return false;
		} else if (!desinscription.equals(other.desinscription))
			return false;
		if (idReponse != other.idReponse)
			return false;
		if (inscribtion == null) {
			if (other.inscribtion != null)
				return false;
		} else if (!inscribtion.equals(other.inscribtion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "subscription [idReponse=" + idReponse + ", inscribtion=" + inscribtion + ", desinscription="
				+ desinscription + "]";
	}

	public int getIdReponse() {
		return idReponse;
	}

	public void setIdReponse(int idReponse) {
		this.idReponse = idReponse;
	}

	public Date getInscribtion() {
		return inscribtion;
	}

	public void setInscribtion(Date inscribtion) {
		this.inscribtion = inscribtion;
	}

	public Date getDesinscription() {
		return desinscription;
	}

	public void setDesinscription(Date desinscription) {
		this.desinscription = desinscription;
	} 
	
	
}
