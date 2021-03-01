package fr.pandami.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "utilisateur")
public class Utilisateur implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String email;
	private String password;
	private String nom;
	private String prenom;
	private Date naissance;
	private String telephone;
	private LocalDateTime inscription = LocalDateTime.now();
	private Date desinscription;
	
	public Utilisateur() {
		super();
	}

	public Utilisateur(Integer id, String email, String password, String nom, String prenom, Date naissance,
			String telephone, LocalDateTime inscription, Date desinscription) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.naissance = naissance;
		this.telephone = telephone;
		this.inscription = inscription;
		this.desinscription = desinscription;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", email=" + email + ", password=" + password + ", nom=" + nom + ", prenom="
				+ prenom + ", naissance=" + naissance + ", telephone=" + telephone + ", inscription=" + inscription
				+ ", desinscription=" + desinscription + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desinscription == null) ? 0 : desinscription.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((inscription == null) ? 0 : inscription.hashCode());
		result = prime * result + ((naissance == null) ? 0 : naissance.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
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
		Utilisateur other = (Utilisateur) obj;
		if (desinscription == null) {
			if (other.desinscription != null)
				return false;
		} else if (!desinscription.equals(other.desinscription))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inscription == null) {
			if (other.inscription != null)
				return false;
		} else if (!inscription.equals(other.inscription))
			return false;
		if (naissance == null) {
			if (other.naissance != null)
				return false;
		} else if (!naissance.equals(other.naissance))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		return true;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getNaissance() {
		return naissance;
	}

	public void setNaissance(Date naissance) {
		this.naissance = naissance;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public LocalDateTime getInscription() {
		return inscription;
	}

	public void setInscription(LocalDateTime inscription) {
		this.inscription = inscription;
	}

	public Date getDesinscription() {
		return desinscription;
	}

	public void setDesinscription(Date desinscription) {
		this.desinscription = desinscription;
	}
	
	
	
	
	
	
	
	
	
	

}
