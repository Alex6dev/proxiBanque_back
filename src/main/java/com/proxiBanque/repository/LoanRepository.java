package com.proxiBanque.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proxiBanque.model.Loan;

public interface LoanRepository extends JpaRepository<Loan,Long>{
    Set<Loan> findByOwnerId(Long clientId);
}
