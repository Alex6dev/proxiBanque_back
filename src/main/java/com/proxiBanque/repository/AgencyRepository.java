package com.proxiBanque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proxiBanque.model.Agency;

public interface AgencyRepository extends JpaRepository<Agency,Long>{
    
}
