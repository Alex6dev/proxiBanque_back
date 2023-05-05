package com.proxiBanque.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import com.proxiBanque.model.Advisor;
import com.proxiBanque.service.IAdvisorService;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@TestPropertySource(locations = "classpath:test.properties")
public class AdvisorRestControllerTest {
	
	@MockBean
    private IAdvisorService iadvisorService;
	
	@Autowired
	private AdvisorRestController advisorRestController;
	
	
	@Test
	public void testFindAdvisorByIdWithValidId() {
	    
	    Long id = 1L;
	    Advisor advisor = new Advisor();
	    advisor.setId(id);
	    advisor.setName("John Doe");
	    when(iadvisorService.findAdvisorById(id)).thenReturn(Optional.of(advisor));
	    ResponseEntity<Advisor> response = advisorRestController.findAdvisorById(id);
	    assertEquals(HttpStatus.OK, response.getStatusCode());
	    assertEquals(advisor, response.getBody());
	}

	@Test
	public void testFindAdvisorByIdWithInvalidId() {
	    
	    Long id = 1L;
	    when(iadvisorService.findAdvisorById(id)).thenReturn(Optional.empty());
	    ResponseEntity<Advisor> response = advisorRestController.findAdvisorById(id);
	    assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
}
