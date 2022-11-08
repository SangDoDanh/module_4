package com.codegym.service.impl;

import com.codegym.model.facility.RentType;
import com.codegym.repository.facility.IFacilityRentTypeRepository;
import com.codegym.service.IFacilityRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityRentTypeService implements IFacilityRentTypeService {
    @Autowired
    private IFacilityRentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}
