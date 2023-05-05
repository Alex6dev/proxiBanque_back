package com.proxiBanque.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proxiBanque.model.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
    Optional<Manager> findByMailAndPassword(String mail,String password);

}
