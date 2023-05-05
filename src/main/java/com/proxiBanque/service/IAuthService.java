package com.proxiBanque.service;

import java.util.Optional;

import com.proxiBanque.dto.received.AuthDto;
import com.proxiBanque.model.Person;

public interface IAuthService{
    Optional<Person> authentification(AuthDto authDto);

}