package com.codegym.controller;

import com.codegym.model.contract.Contract;
import com.codegym.model.contract.ContractDetail;
import com.codegym.model.facility.AttachFacility;
import com.codegym.service.IAttachFacilityService;
import com.codegym.service.IContractDetailService;
import com.codegym.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/contract-details")
public class ContractDetailRestController {

    @Autowired
    private IContractDetailService contractDetailService;

    @Autowired
    private IContractService contractService;

    @Autowired
    private IAttachFacilityService attachFacilityService;

    @GetMapping
    public ResponseEntity<List<ContractDetail>> getAll() {
        List<ContractDetail> contractDetailList = contractDetailService.findAll();
        return new ResponseEntity<>(contractDetailList, HttpStatus.OK);
    }


    @GetMapping(value = "/add")
    public ResponseEntity<Void> addContractDetail(@RequestParam int contractId,
                                                  @RequestParam int attachFacility,
                                                  @RequestParam int quality) {

        Optional<ContractDetail> contractDetailExists = contractDetailService.findByAttach(attachFacility, contractId);
        if(contractDetailExists.isPresent()) {
            int qualityExists = contractDetailExists.get().getQuantity();
            contractDetailExists.get().setQuantity(qualityExists + quality);
            contractDetailService.save(contractDetailExists.get());
        } else {
            Contract contract = contractService.findById(contractId);
            AttachFacility attachFacilityNew = attachFacilityService.findById(attachFacility);
            ContractDetail contractDetail = new ContractDetail();
            contractDetail.setContract(contract);
            contractDetail.setAttachFacility(attachFacilityNew);
            contractDetail.setQuantity(quality);
            contractDetail.setStatus(false);
            contractDetailService.save(contractDetail);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
