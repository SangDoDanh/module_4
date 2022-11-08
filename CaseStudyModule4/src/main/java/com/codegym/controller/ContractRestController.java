package com.codegym.controller;

import com.codegym.dto.ContractDto;
import com.codegym.model.contract.Contract;
import com.codegym.model.contract.ContractDetail;
import com.codegym.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/contracts")
public class ContractRestController {
    @Autowired
    private IContractService contractService;

    @GetMapping("")
    public ResponseEntity<List<Contract>> getListContract() {
        List<Contract> contractList = contractService.findAll();
        return new ResponseEntity<>(contractList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contract> getListContract(@PathVariable int id) {
        Contract contract = contractService.findById(id);
        return new ResponseEntity<>(contract, HttpStatus.OK);
    }

}
