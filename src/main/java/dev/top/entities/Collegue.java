package dev.top.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Collegue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String pseudo;
	private int score;
	@ElementCollection
	private List<String> imageUrl;
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
	
	
	
	public Collegue() {
		super();
	}
	
	public Collegue( String pseudo,int score,List<String> imageUrl) {
		super();
		this.score = score;
		this.pseudo = pseudo;
		this.imageUrl= new ArrayList<>(imageUrl);
	}
	
	public Collegue(String pseudo, int score, List<String> imageUrl, String nom, String prenom, String email,
			String adresse) {
		super();
		this.pseudo = pseudo;
		this.score = score;
		this.imageUrl = imageUrl;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public List<String> getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(List<String> imageUrl) {
		this.imageUrl = imageUrl;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	

}
