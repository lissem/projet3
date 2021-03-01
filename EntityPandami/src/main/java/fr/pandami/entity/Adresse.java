package fr.pandami.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Adresse")
public class Adresse implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String numero;
	private String nomDeVoie;
	private String codePostal;
	private String ville;
	private float latitude;
	private float longitude;
	
	public Adresse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Adresse(Integer id, String numero, String nomDeVoie, String codePostal, String ville, float latitude,
			float longitude) {
		super();
		this.id = id;
		this.numero = numero;
		this.nomDeVoie = nomDeVoie;
		this.codePostal = codePostal;
		this.ville = ville;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "Adresse [id=" + id + ", numero=" + numero + ", nomDeVoie=" + nomDeVoie + ", codePostal=" + codePostal
				+ ", ville=" + ville + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNomDeVoie() {
		return nomDeVoie;
	}

	public void setNomDeVoie(String nomDeVoie) {
		this.nomDeVoie = nomDeVoie;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}


	
	
}
