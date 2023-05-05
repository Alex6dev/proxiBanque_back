package com.proxiBanque.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proxiBanque.ProxiBanqueApplication;
import com.proxiBanque.model.Advisor;
import com.proxiBanque.service.IAdvisorService;

@CrossOrigin
@RestController
@RequestMapping("api")
public class AdvisorRestController {
	
	private static final Logger logger= ProxiBanqueApplication.logger;

	private IAdvisorService iAdvisorService;

	public AdvisorRestController(IAdvisorService iAdvisorService) {

		this.iAdvisorService = iAdvisorService;
	}
	
	/**
	 * Controller which allows to connect via Angular
	 * @param id
	 * @return ResponseEntity<Advisor> or ResponseEntity.notFound()
	 */

	@GetMapping("/advisor/{id}")
	public ResponseEntity<Advisor> findAdvisorById(@PathVariable Long id) {
		Optional<Advisor> adv = iAdvisorService.findAdvisorById(id);
		if (adv.isPresent())
			return ResponseEntity.ok(adv.get());
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}
