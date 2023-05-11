package com.proxiBanque.service;

import java.util.Optional;
import java.util.Set;

import com.proxiBanque.exception.ForbidenException;
import com.proxiBanque.model.Advisor;

public interface IAdvisorService {

    Set<Advisor> findAdvisorsByManager(Long idManager) throws ForbidenException;

}
