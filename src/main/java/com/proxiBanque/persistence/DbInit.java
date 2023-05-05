package com.proxiBanque.persistence;

import java.sql.Timestamp;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proxiBanque.model.Advisor;
import com.proxiBanque.model.Agency;
import com.proxiBanque.model.ECardType;
import com.proxiBanque.model.CheckingAccount;
import com.proxiBanque.model.Client;
import com.proxiBanque.model.Loan;
import com.proxiBanque.model.Manager;
import com.proxiBanque.model.SavingsAccount;
import com.proxiBanque.repository.AccountRepository;
import com.proxiBanque.repository.AgencyRepository;
import com.proxiBanque.repository.ClientRepository;
import com.proxiBanque.repository.LoanRepository;

import jakarta.annotation.PostConstruct;

@Component
public class DbInit {
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private AgencyRepository agencyRepository;
	@Autowired
	private LoanRepository laonRepository;

	@PostConstruct
	public void initDB() {

		Agency agency = new Agency("ProxyBank", "Proxy Bank");
		Manager manager = new Manager("Jean", "Martin", "0642957", "testManager", "testManager",
				agency);
		Advisor advisor1 = new Advisor("Jean", "Martin", "0642957564", "jean.martin@proxybank.com", "jeanmartin123",
				agency);
		Advisor advisor2 = new Advisor("Pierre", "Dupont", "0691547685", "pierre.dupont@proxybank.com",
				"pierredupont123", agency);
		Advisor advisor3 = new Advisor("Jean", "Martin", "065451", "testAdvisor", "testAdvisor", agency);
		agency.setManager(manager);
		agency.addAdvisor(advisor1);
		agency.addAdvisor(advisor2);
		agency.addAdvisor(advisor3);
		agencyRepository.save(agency);


		Client client1 = new Client("Patrick", "Giraud", "7 rue du Gard", 
				"30150", "Montfaucon", "0765248925", advisor1);
		Client client2 = new Client("Antoine", "LeMaire", "7 rue du parque", 
				"30150", "Montfaucon", "0765248925", advisor1);
		Client client3 = new Client("Harriette", "Alton", "7 rue du Gard", 
				"30150", "Montfaucon", "0765248925", advisor1);
		Client client4 = new Client("Armand", "Hector", "7 rue du Gard", 
				"30150", "Montfaucon", "0765248925", advisor2);
		Client client5 = new Client("Edith", "Voice", "7 rue du Gard", 
				"30150", "Montfaucon", "0765248925", advisor2);
		
		Client client6 = new Client("Actus", "Lyod", "7 rue du Gard", "30150","Monfaucon","0765248925", advisor3);
		Client client7 = new Client("Maxime", "Yes", "7 rue du Gard", "30150","Monfaucon","0765248925", advisor3);
		

		clientRepository.save(client1);
		clientRepository.save(client2);
		clientRepository.save(client3);
		clientRepository.save(client4);
		clientRepository.save(client5);
		clientRepository.save(client6);
		clientRepository.save(client7);

		CheckingAccount account1 = new CheckingAccount(-50D, LocalDate.now(), client1, 100D, ECardType.PREMIER);
		SavingsAccount account2 = new SavingsAccount(50D, LocalDate.now(), client1, 3D);
		CheckingAccount account3 = new CheckingAccount(-500D, LocalDate.now(), client2, 500D, ECardType.PREMIER);
		SavingsAccount account4 = new SavingsAccount(50D, LocalDate.now(), client2, 3D);
		CheckingAccount account5 = new CheckingAccount(50D, LocalDate.now(), client3, 0D, ECardType.ELECTRON);
		CheckingAccount account6 = new CheckingAccount(50D, LocalDate.now(), client6, 0D, ECardType.ELECTRON);
		SavingsAccount account7 = new SavingsAccount(50D, LocalDate.now(), client6, 3D);
		CheckingAccount account8 = new CheckingAccount(-50D, LocalDate.now(), client7, 0D, ECardType.PREMIER);

		accountRepository.save(account1);
		accountRepository.save(account2);
		accountRepository.save(account3);
		accountRepository.save(account4);
		accountRepository.save(account5);
		accountRepository.save(account6);
		accountRepository.save(account7);
		accountRepository.save(account8); 

		Loan loan1= new Loan(100000, 100000, 5.5F, 2.0F, false, client7,157788000000L);
		Loan loan2=  new Loan(50000, 25000, new Timestamp(System.currentTimeMillis()-50000000000l), 5.5F, 2.0F, true, client7, 157788000000L);

		laonRepository.save(loan1);
		laonRepository.save(loan2);
	}
}
