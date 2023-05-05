package com.proxiBanque.controller;

import java.util.Set;
import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proxiBanque.ProxiBanqueApplication;
import com.proxiBanque.dto.received.AcceptLaonDto;
import com.proxiBanque.dto.received.LoanDto;
import com.proxiBanque.dto.received.NewLoanDto;
import com.proxiBanque.exception.ForbidenException;
import com.proxiBanque.model.Loan;
import com.proxiBanque.service.ILoanService;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class LoanController {

    private static final Logger logger = ProxiBanqueApplication.logger;

    @Autowired
    private ILoanService loanService;

    @GetMapping("loans/{idClient}")
    public ResponseEntity getAllLoanById(@PathVariable(value = "idClient") Long idClient){
        Set<Loan> loans= loanService.getAllLoanByIdClient(idClient);
        logger.info("The loan search by client id went well");
        return ResponseEntity.ok().body(loans);
    }

    @PutMapping("loan")
    public ResponseEntity putLoan( @RequestBody AcceptLaonDto acceptLoanDto){
        try {
            LoanDto loanDto= loanService.acceptLoan(new Loan(acceptLoanDto.getLoan()),acceptLoanDto.getIdClient());

            logger.info("The loan acquisition went well");
            return ResponseEntity.ok().body(loanDto);
            
        } catch (ForbidenException e) {
            logger.warn("An error occurred in the putLoan function");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } 
    } 

    @PostMapping("loan")
    public ResponseEntity createLoan(@RequestBody NewLoanDto newLoanDto){
        try{
            LoanDto loanDto= loanService.createLoan(newLoanDto);
            logger.info("The creation of a new loan is well spent");
            return ResponseEntity.ok().body(loanDto);
        }catch(ForbidenException e){
            logger.warn("An error occurred in the createLoan function");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    
}
