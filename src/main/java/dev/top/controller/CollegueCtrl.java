package dev.top.controller;

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
import dev.top.repos.CollegueRepo;


@CrossOrigin
@RestController()
@RequestMapping("/collegues")
public class CollegueCtrl {

    @Autowired
    private CollegueRepo collegueRepo;

    @GetMapping
    public List<Collegue> findAll() {
        return this.collegueRepo.findAll();
    }
    
    @PatchMapping("/{pseudo}")
    public Collegue updateScore(@PathVariable String pseudo,@RequestBody ActionButton action) {
    	Collegue col = collegueRepo.findByPseudo("Alexis");
    		System.out.println(col);
    		if (action.getAction()==Avis.AIMER) {
    			col.setScore(col.getScore()+10);
			}else {
				col.setScore(col.getScore()-5);
			}
    		collegueRepo.save(col);	
    		return col;
    }
}
