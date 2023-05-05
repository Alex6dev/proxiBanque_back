package com.proxiBanque.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proxiBanque.ProxiBanqueApplication;
import com.proxiBanque.dto.emis.UserDto;
import com.proxiBanque.dto.received.AuthDto;
import com.proxiBanque.model.Person;
import com.proxiBanque.service.IAuthService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/api/")
public class AuthController {
	@Autowired
	private IAuthService authService;

	private static final Logger logger = ProxiBanqueApplication.logger;

	/**
	 * Controller which allows to connect via a userDTO
	 * 
	 * @param authDto
	 * @return ResponseEntity<UserDto> or ResponseEntity.notFound()
	 */

	@PostMapping("auth")
	public ResponseEntity<UserDto> auth(@Valid @RequestBody AuthDto authDto) {
		try {
			Optional<Person> personOpt = this.authService.authentification(authDto);
			if (personOpt.isPresent()) {
				logger.info("Authentification avec succes");
				return ResponseEntity.ok(new UserDto(personOpt.get()));
			} else {
				logger.warn("Authentification avec erreur");
				return ResponseEntity.notFound().build();
			}

		} catch (Exception e) {
			return ResponseEntity.status(500).build(); 
		}
	}

}
