package com.proxiBanque.repository;



import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proxiBanque.model.Advisor;
import com.proxiBanque.model.Agency;

public interface AdvisorRepository extends JpaRepository<Advisor, Long> {
    Optional<Advisor> findByMailAndPassword(String mail,String password);
    Set<Advisor> findByAgency(Agency agency);
}
