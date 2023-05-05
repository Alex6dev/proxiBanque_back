
package com.proxiBanque.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

import com.proxiBanque.dto.received.AuthDto;
import com.proxiBanque.model.Advisor;
import com.proxiBanque.model.Manager;
import com.proxiBanque.model.Person;
import com.proxiBanque.repository.AdvisorRepository;
import com.proxiBanque.repository.ManagerRepository;

@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
public class AuthServiceImplTest {
    
    @Autowired
    private IAuthService authService;
    
    @MockBean
    private AdvisorRepository advisorRepository;

    @MockBean
    private ManagerRepository managerRepository;

    @MockBean
    private Advisor advisor;

    @MockBean
    private Manager manager;

    @Test
    public void given_whenIWantToLoginAsAdvisor_ThenReturnAnOptionalWithAdvisor(){
        Optional<Advisor> advisorOpt= Optional.of(advisor);
        Mockito.when(advisorRepository.findByMailAndPassword("testMail", "testPassword")).thenReturn(advisorOpt);
        Optional<Person>personOpt= authService.authentification(new AuthDto("testMail", "testPassword"));
        assertEquals(advisorOpt,personOpt );
    }
    @Test
    public void given_whenIWantToLoginAsManager_ThenReturnAnOptionalWithManager(){
        Optional<Manager> managerOpt= Optional.of(manager);
        Mockito.when(managerRepository.findByMailAndPassword("testMail", "testPassword")).thenReturn(managerOpt);
        Optional<Person>personOpt= authService.authentification(new AuthDto("testMail", "testPassword"));
        assertEquals(managerOpt,personOpt );
    }
    @Test
    public void given_whenIWantToConnectButItFails_ThenReturnAnEmptyOptional(){
        Optional<Manager> managerOpt= Optional.empty();
        Optional<Advisor> advisorOpt= Optional.empty();
        Mockito.when(managerRepository.findByMailAndPassword("testMail", "testPassword")).thenReturn(managerOpt);
        Mockito.when(advisorRepository.findByMailAndPassword("testMail", "testPassword")).thenReturn(advisorOpt);
        Optional<Person>personOpt= authService.authentification(new AuthDto("testMail", "testPassword"));
        assertEquals(Optional.empty(),personOpt );
    }
}
