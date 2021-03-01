package fr.pandami.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PreferenceService")
public class PreferenceService implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private LocalDateTime debutValidite = LocalDateTime.now();
	private Date finValidite;
	
	public PreferenceService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PreferenceService(Integer id, LocalDateTime debutValidite, Date finValidite) {
		super();
		this.id = id;
		this.debutValidite = debutValidite;
		this.finValidite = finValidite;
	}

	@Override
	public String toString() {
		return "PreferenceService [id=" + id + ", debutValidite=" + debutValidite + ", finValidite=" + finValidite
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((debutValidite == null) ? 0 : debutValidite.hashCode());
		result = prime * result + ((finValidite == null) ? 0 : finValidite.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (debutValidite == null) {
			if (other.debutValidite != null)
				return false;
		} else if (!debutValidite.equals(other.debutValidite))
			return false;
		if (finValidite == null) {
			if (other.finValidite != null)
				return false;
		} else if (!finValidite.equals(other.finValidite))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDebutValidite() {
		return debutValidite;
	}

	public void setDebutValidite(LocalDateTime debutValidite) {
		this.debutValidite = debutValidite;
	}

	public Date getFinValidite() {
		return finValidite;
	}

	public void setFinValidite(Date finValidite) {
		this.finValidite = finValidite;
	}
	
	
}