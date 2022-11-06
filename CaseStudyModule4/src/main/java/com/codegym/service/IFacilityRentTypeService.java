package com.codegym.service;

import com.codegym.model.RentType;

import java.util.List;

public interface IFacilityRentTypeService {
    List<RentType> findAll();
}
