package com.proxiBanque.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proxiBanque.model.Client;
import com.proxiBanque.service.ClientService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ClientController {
	private ClientService clientService;

	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}

	@PostMapping("/clients")
	public ResponseEntity<List<Client>> findClientsByAdvisorId(@RequestBody Long advisorId) {
		List<Client> clients = clientService.findClientsByAdvisorId(advisorId);
		return ResponseEntity.ok(clients);
	}

	@PostMapping("/client")
	public ResponseEntity<Client> createClient(@RequestBody Map<String, String> clientJson) {
		Optional<Client> clientData = clientService.createClient(clientJson);

		if (clientData.isPresent())
			return ResponseEntity.ok(clientData.get());
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@PutMapping("/client")
	public ResponseEntity<Client> updateClient(@RequestBody Map<String, String> clientJson) {
		Optional<Client> clientData = clientService.updateClient(clientJson);

		if (clientData.isPresent())
			return ResponseEntity.ok(clientData.get());
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@DeleteMapping("/client/{id}")
	public ResponseEntity<HttpStatus> deleteClient(@PathVariable(value = "id") Long clientId) {
		clientService.deleteClient(clientId);
		return ResponseEntity.ok(null);
	}
}
