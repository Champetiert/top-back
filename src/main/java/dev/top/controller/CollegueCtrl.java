package dev.top.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.top.entities.ActionButton;
import dev.top.entities.Avis;
import dev.top.entities.Collegue;
import dev.top.entities.Vote;
import dev.top.repos.CollegueRepo;
import dev.top.repos.VoteRepo;


@CrossOrigin
@RestController()
@RequestMapping("/collegues")
public class CollegueCtrl {

    @Autowired
    private CollegueRepo collegueRepo;
    
    @Autowired
    private VoteRepo voteRepo;

    @GetMapping
    public List<Collegue> findAll() {
        return this.collegueRepo.findAll();
    }
    
    @GetMapping("/{pseudo}")
    public Collegue findCollegueDetail(@PathVariable String pseudo) {
        return collegueRepo.findByPseudo(pseudo);
    }
    
    @PatchMapping("/{pseudo}")
    public Vote updateScore(@PathVariable String pseudo,@RequestBody ActionButton action) {
    	Collegue col = collegueRepo.findByPseudo(pseudo);
    		System.out.println(col);
    		if (action.getAction()==Avis.AIMER) {
    			col.setScore(col.getScore()+10);
			}else {
				col.setScore(col.getScore()-5);
			}
    		collegueRepo.save(col);
    		Vote myVote=new Vote(col,action.getAction(),col.getScore(),LocalDateTime.now());
    		voteRepo.save(myVote);
    		return myVote;
    }
}
