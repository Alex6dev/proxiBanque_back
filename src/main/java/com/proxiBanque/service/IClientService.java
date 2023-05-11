package com.proxiBanque.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.proxiBanque.model.Client;

public interface IClientService {
    List<Client> findClientsByAdvisorId(Long advisorId);
	Optional<Client> createClient(Map<String, String> clientJson);
	Optional<Client> updateClient(Map<String, String> clientJson);
	void deleteClient(Long clientId);
}
