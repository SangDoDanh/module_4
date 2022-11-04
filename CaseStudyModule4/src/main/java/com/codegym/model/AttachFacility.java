package com.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AttachFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @Column(columnDefinition = "boolean default false")
    private Boolean status;
    private Double costAttach;
    private String unitAttach;
    private String statusAttach;
    @OneToMany(mappedBy = "attachFacility")
    private Set<ContractDetail> contractDetailSet;

    public AttachFacility() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Double getCostAttach() {
        return costAttach;
    }

    public void setCostAttach(Double costAttach) {
        this.costAttach = costAttach;
    }

    public String getUnitAttach() {
        return unitAttach;
    }

    public void setUnitAttach(String unitAttach) {
        this.unitAttach = unitAttach;
    }

    public String getStatusAttach() {
        return statusAttach;
    }

    public void setStatusAttach(String statusAttach) {
        this.statusAttach = statusAttach;
    }

    public Set<ContractDetail> getContractDetailSet() {
        return contractDetailSet;
    }

    public void setContractDetailSet(Set<ContractDetail> contractDetailSet) {
        this.contractDetailSet = contractDetailSet;
    }
}
