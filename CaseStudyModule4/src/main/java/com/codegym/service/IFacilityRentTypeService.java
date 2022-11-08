package com.codegym.service;

import com.codegym.model.facility.RentType;

import java.util.List;

public interface IFacilityRentTypeService {
    List<RentType> findAll();
}
