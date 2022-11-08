package com.codegym.service;

import com.codegym.model.contract.Contract;
import com.codegym.model.contract.ContractDetail;

import java.util.List;
import java.util.Optional;

public interface IContractDetailService {
    List<ContractDetail> findAll();

    void save(ContractDetail contractDetail);

    Optional<ContractDetail> findByAttach(int attachFacility, int contractId);
}
