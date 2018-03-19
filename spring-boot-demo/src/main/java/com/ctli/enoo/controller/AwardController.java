package com.ctli.enoo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.ctli.enoo.entity.Award;
import com.ctli.enoo.service.IAwardService;

@Controller
@RequestMapping("award")
public class AwardController {
	@Autowired
	private IAwardService awardService;
	@GetMapping("/get/{id}")
	public ResponseEntity<Award> getAwardById(@PathVariable("id") Integer id) {
		Award award = awardService.getAwardById(id);
		return new ResponseEntity<>(award, HttpStatus.OK);
	}
	@GetMapping("/getAll")
	public ResponseEntity<List<Award>> getAllAwards() {
		List<Award> list = awardService.getAllAwards();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	@PostMapping("/create")
	public ResponseEntity<Void> addAward(@RequestBody Award award, UriComponentsBuilder builder) {
        boolean flag = awardService.addAward(award);
        if (!flag) {
        	return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/get/{id}").buildAndExpand(award.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	@PutMapping("/update")
	public ResponseEntity<Award> updateAward(@RequestBody Award award) {
		awardService.updateAward(award);
		return new ResponseEntity<>(award, HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteAward(@PathVariable("id") Integer id) {
		awardService.deleteAward(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}	
} 