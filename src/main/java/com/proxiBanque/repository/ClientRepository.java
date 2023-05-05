package com.proxiBanque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proxiBanque.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
	List<Client> findByAdvisorId(Long advisorId);
}
