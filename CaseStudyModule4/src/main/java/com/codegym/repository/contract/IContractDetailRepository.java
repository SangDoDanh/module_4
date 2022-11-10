package com.codegym.repository.contract;

import com.codegym.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IContractDetailRepository extends JpaRepository<ContractDetail,Integer> {

    @Query(value = "select * " +
            "from contract_detail " +
            "where contract_id = :contractId and attach_facility_id = :attachFacility",
    nativeQuery = true)
    Optional<ContractDetail> findByAttach(@Param("attachFacility") int attachFacility, @Param("contractId") int contractId);
}
