package com.proxiBanque.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

import com.proxiBanque.model.Advisor;
import com.proxiBanque.repository.AdvisorRepository;

@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
public class IAdvisorImplTest {
	
	@Autowired
    private IAdvisorService iadvisorService;
	
    @MockBean
    private AdvisorRepository advisorRepository;

   

    @Test
    public void testFindAdvisorById() {
        Long id = 1L;
        Advisor advisor = new Advisor();
        advisor.setId(id);
        when(advisorRepository.findById(id)).thenReturn(Optional.of(advisor));
        Optional<Advisor> result = iadvisorService.findAdvisorById(id);
        assertTrue(result.isPresent());
        assertEquals(advisor, result.get());
    }


}
