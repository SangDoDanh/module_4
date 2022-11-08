package com.codegym.service.impl;

import com.codegym.model.contract.ContractDetail;
import com.codegym.repository.contract.IContractDetailRepository;
import com.codegym.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository contractDetailRepository;

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public Optional<ContractDetail> findByAttach(int attachFacility, int contractId) {
        return contractDetailRepository.findByAttach(attachFacility, contractId);
    }

}
