package com.proxiBanque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proxiBanque.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	List<Account> findByOwnerId(Long clientId);
	List<Account> findByOwnerAdvisorId(Long advisorId);
}
