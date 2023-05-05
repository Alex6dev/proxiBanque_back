package com.proxiBanque.controller;

import java.util.HashSet;
import java.util.Set;

import javax.swing.text.html.parser.Element;

import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proxiBanque.ProxiBanqueApplication;
import com.proxiBanque.dto.emis.AdvisorDto;
import com.proxiBanque.model.Advisor;
import com.proxiBanque.service.IAdvisorService;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class ManagerController {
    private static final Logger logger = ProxiBanqueApplication.logger;

	@Autowired
    private IAdvisorService advisorService;

    /**
     * controller that allows to retrieve the advisors through the manager's id
     * @param idManager
     * @return a set of AdvisorDto or an error message
     */
    @GetMapping("advisors/manager/{id}")
    public ResponseEntity getAllAdvisorByManager(@PathVariable(value = "id") Long idManager){
        
        try {
            Set<AdvisorDto> advisorsDto=new HashSet<>();
            Set<Advisor> advisors=advisorService.findAdvisorsByManager(idManager);
            advisors.forEach(advisor->{advisorsDto.add(new AdvisorDto(advisor));});
            logger.info("The search for advisors is well done");
            return ResponseEntity.ok().body(advisorsDto);
        } catch (Exception e) {
            logger.warn("an error occurred in the getAllAdvisorByManager function");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
    
}
