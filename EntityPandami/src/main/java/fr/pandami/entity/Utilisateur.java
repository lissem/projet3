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
	private String nom;
	private String prenom;
	private Date naissance;
	private String telephone;
	private LocalDateTime inscription = LocalDateTime.now();
	private Date desinscription;
	
	
	
	
	public Utilisateur() {
		super();
	}
	public Utilisateur(String email, String nom, String prenom, Date naissance, String telephone) {
		super();
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.naissance = naissance;
		this.telephone = telephone;
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
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
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
