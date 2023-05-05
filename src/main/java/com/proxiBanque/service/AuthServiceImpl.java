package com.proxiBanque.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proxiBanque.dto.received.AuthDto;
import com.proxiBanque.model.Advisor;
import com.proxiBanque.model.Manager;
import com.proxiBanque.model.Person;
import com.proxiBanque.repository.AdvisorRepository;
import com.proxiBanque.repository.ManagerRepository;

@Service
public class AuthServiceImpl implements IAuthService{
    @Autowired
    private AdvisorRepository advisorRepository;
    @Autowired
    private ManagerRepository managerRepository;

    /**
     * authentication function, checks if the user is present in the database
     * @param authDto
     * @return Optional<Person> or optional.empty()
     */
    public Optional<Person> authentification(AuthDto authDto){
        Optional<Manager> managerOpt=managerRepository.findByMailAndPassword(authDto.getIdentifiant(), authDto.getMdp());
        if(managerOpt.isPresent()){
            return Optional.of(managerOpt.get());
        }
        Optional<Advisor> advisorOpt=advisorRepository.findByMailAndPassword(authDto.getIdentifiant(), authDto.getMdp());
        if(advisorOpt.isPresent()){
            return Optional.of(advisorOpt.get());
        }
        return Optional.empty();
    }
}
