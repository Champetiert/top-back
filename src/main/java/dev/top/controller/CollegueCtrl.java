package dev.top.controller;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import dev.top.entities.ActionButton;
import dev.top.entities.Avis;
import dev.top.entities.Collegue;
import dev.top.entities.Vote;
import dev.top.entities.apiEntities.CollegueApi;
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
	public Vote updateScore(@PathVariable String pseudo, @RequestBody ActionButton action) {
		Collegue col = collegueRepo.findByPseudo(pseudo);
		System.out.println(col);
		if (action.getAction() == Avis.AIMER) {
			col.setScore(col.getScore() + 10);
		} else {
			col.setScore(col.getScore() - 5);
		}
		collegueRepo.save(col);
		Vote myVote = new Vote(col, action.getAction(), col.getScore(), LocalDateTime.now());
		voteRepo.save(myVote);
		return myVote;
	}

	@PostMapping("/nouveau")
	public ResponseEntity create(@RequestBody Map<String, String> form) {
		RestTemplate rt = new RestTemplate();
		CollegueApi[] listCollegue = rt.getForObject(
				"http://collegues-api.cleverapps.io/collegues?matricule=" + form.get("matricule"), CollegueApi[].class);
		if (listCollegue.length > 0) {

			Collegue collegue = new Collegue();
			collegue.setNom(listCollegue[0].getNom());
			collegue.setPrenom(listCollegue[0].getPrenom());
			collegue.setEmail(listCollegue[0].getEmail());
			collegue.setAdresse(listCollegue[0].getAdresse());
			collegue.setPseudo(form.get("pseudo"));
			if (form.get("imgUrl") != null) {
				String[] listImg = { form.get("imgUrl") };
				collegue.setImageUrl(Arrays.asList(listImg));
			} else {
				String[] listImg= {listCollegue[0].getPhoto()};

				collegue.setImageUrl(Arrays.asList(listImg));
			}
			collegueRepo.save(collegue);
			return ResponseEntity.status(HttpStatus.OK).body("ok");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad matricule");
		}
	}

}
