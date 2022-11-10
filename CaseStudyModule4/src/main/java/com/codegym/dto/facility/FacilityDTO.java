package com.codegym.dto.facility;

import com.codegym.model.contract.Contract;
import com.codegym.model.facility.FacilityType;
import com.codegym.model.facility.RentType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Set;

public class FacilityDTO implements Validator {
    private Integer id;

    private Boolean status = false;
    @NotBlank(message = "Khong duoc bo trong!")
    private String name;
    private Integer area;
    @DecimalMin(value = "0.0", message = "Toi thieu 0 vnd" )
    private Double cost;
    @Min(value = 1, message = "TOi thieu 1 nguoi")
    @Max(value = 20, message = "TOi da 20 nguoi")
    private Integer maxPeople;

    private RentType rentType;

    private FacilityType facilityType;

    private String standardRoom;
    private String description;
    private Double poolArea;
    private Integer numberOfFloors;
    private String facilityFree;
    private Set<Contract> contractSet;

    public FacilityDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FacilityDTO facilityDTO = (FacilityDTO) target;
        String name = facilityDTO.getName();
        Integer numberOfFloors = facilityDTO.getNumberOfFloors();
        String facilityFree = facilityDTO.getFacilityFree();
        Integer maxPeople = facilityDTO.getMaxPeople();
        Double cost = facilityDTO.getCost();
        if(cost == null) {
            errors.rejectValue("cost", "", "Sai dinh dang roi ban !");
        }
        if(maxPeople == null) {
            errors.rejectValue("maxPeople", "", "Khong duuoc bo trong !");
        }
        if(name!=null) {
            if("admin".equals(name)) {
                errors.rejectValue("name", "", "Khong duoc la admin!");
            }
        }
        switch (facilityDTO.getFacilityType().getId()) {
            //villa
            case 1:
            //home
            case 2:
                if(numberOfFloors == null) {
                    errors.rejectValue("numberOfFloors", "", "Khong duuoc bo trong !");

                } else if(numberOfFloors < 1) {
                    errors.rejectValue("numberOfFloors", "", "So Tang > 1 !");
                }
                break;
            default:
                if(facilityFree == null) {
                    errors.rejectValue("facilityFree", "", "Khong duoc null");
                } else if (facilityFree.equals("")){
                    errors.rejectValue("facilityFree", "", "Khong duoc bo trong");
                }

        }
    }
}
