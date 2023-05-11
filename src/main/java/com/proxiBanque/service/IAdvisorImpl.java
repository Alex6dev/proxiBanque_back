package com.proxiBanque.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.proxiBanque.exception.ForbidenException;
import com.proxiBanque.model.Advisor;
import com.proxiBanque.model.Manager;
import com.proxiBanque.repository.AdvisorRepository;
import com.proxiBanque.repository.ManagerRepository;


@Service
public class IAdvisorImpl implements IAdvisorService {
	
	private AdvisorRepository advisorRepository;
	private ManagerRepository managerRepository;
	
	public IAdvisorImpl(AdvisorRepository advisorRepository,ManagerRepository managerRepository) {
		this.managerRepository=managerRepository;
		this.advisorRepository = advisorRepository;
	}



	/**
	 * 
	 * @param idManager 
	 * @return Set of Manager
	 */
	@Override
	public Set<Advisor> findAdvisorsByManager(Long idManager) throws ForbidenException {
		Optional<Manager> managerOpt= managerRepository.findById(idManager);
		if(managerOpt.isPresent()){
			return advisorRepository.findByAgency(managerOpt.get().getAgency());
		}else{
            throw new ForbidenException("Le manager demandé n'existe pas en BDD");
		}
	}

	
}

	





	


