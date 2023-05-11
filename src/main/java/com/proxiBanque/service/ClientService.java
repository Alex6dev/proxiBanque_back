package com.proxiBanque.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proxiBanque.model.Advisor;
import com.proxiBanque.model.ECardType;
import com.proxiBanque.model.CheckingAccount;
import com.proxiBanque.model.Client;
import com.proxiBanque.model.SavingsAccount;
import com.proxiBanque.repository.AccountRepository;
import com.proxiBanque.repository.AdvisorRepository;
import com.proxiBanque.repository.ClientRepository;

@Service
public class ClientService implements IClientService{
	private ClientRepository clientRepository;
	private AdvisorRepository advisorRepository;
	private AccountRepository accountRepository;

	public ClientService(ClientRepository clientRepository, AdvisorRepository advisorRepository, AccountRepository accountRepository) {
		this.clientRepository = clientRepository;
		this.advisorRepository = advisorRepository;
		this.accountRepository = accountRepository;
	}

	public List<Client> findClientsByAdvisorId(Long advisorId) {
		return clientRepository.findByAdvisorId(advisorId);
	}

	public Optional<Client> createClient(Map<String, String> clientJson) {
		Optional<Advisor> advisorData = advisorRepository.findById(Long.parseLong(clientJson.get("advisorId")));

		if (advisorData.isPresent()) {
			Advisor advisor = advisorData.get();
			Optional<Client> clientData = Optional.of(clientRepository
					.save(new Client(clientJson.get("name"), clientJson.get("firstName"), clientJson.get("address"),
							clientJson.get("postcode"), clientJson.get("city"), clientJson.get("phone"), advisor)));
			CheckingAccount account1 = new CheckingAccount(0D, LocalDate.now(), clientData.get(), 0D, ECardType.PREMIER);
			SavingsAccount account2 = new SavingsAccount(0D, LocalDate.now(), clientData.get(), 3D);
			accountRepository.save(account1);
			accountRepository.save(account2);
			return clientData;
		} else
			return Optional.empty();
	}

	public Optional<Client> updateClient(Map<String, String> clientJson) {
		Optional<Client> clientData = clientRepository.findById(Long.parseLong(clientJson.get("id")));

		if (clientData.isPresent()) {
			Optional<Advisor> advisorData = advisorRepository.findById(Long.parseLong(clientJson.get("advisorId")));
			Client client = clientData.get();

			if (clientJson.get("name") != null)
				client.setName(clientJson.get("name"));
			if (clientJson.get("firstName") != null)
				client.setFirstName(clientJson.get("firstName"));
			if (clientJson.get("address") != null)
				client.setAddress(clientJson.get("address"));
			if (clientJson.get("postcode") != null)
				client.setPostcode(clientJson.get("postcode"));
			if (clientJson.get("city") != null)
				client.setCity(clientJson.get("city"));
			if (clientJson.get("phone") != null)
				client.setPhone(clientJson.get("phone"));
			if (advisorData.isPresent())
				client.setAdvisor(advisorData.get());

			clientRepository.save(client);

			return Optional.of(client);
		} else
			return Optional.empty();
	}

	public void deleteClient(Long clientId) {
		clientRepository.deleteById(clientId);
	}
}
