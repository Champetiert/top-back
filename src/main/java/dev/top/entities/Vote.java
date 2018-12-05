package dev.top.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Collegue collegue;
	private Avis avis;
	private int oldScore;
	private LocalDateTime dateVote;
	
	public Vote() {
		super();
	}


	public Vote(Collegue collegue, Avis avis, int oldScore, LocalDateTime dateVote) {
		this.collegue = collegue;
		this.avis = avis;
		this.oldScore = oldScore;
		this.dateVote = dateVote;
	}


	public Collegue getCollegue() {
		return collegue;
	}


	public void setCollegue(Collegue collegue) {
		this.collegue = collegue;
	}


	public Avis getAvis() {
		return avis;
	}


	public void setAvis(Avis avis) {
		this.avis = avis;
	}


	public int getOldScore() {
		return oldScore;
	}


	public void setOldScore(int oldScore) {
		this.oldScore = oldScore;
	}


	public LocalDateTime getDateVote() {
		return dateVote;
	}


	public void setDateVote(LocalDateTime dateVote) {
		this.dateVote = dateVote;
	}
	
	

}
