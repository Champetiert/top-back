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
	
	public Collegue() {
		super();
	}
	
	public Collegue( String pseudo,int score,List<String> imageUrl) {
		super();
		this.score = score;
		this.pseudo = pseudo;
		this.imageUrl= new ArrayList<>(imageUrl);
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

}
