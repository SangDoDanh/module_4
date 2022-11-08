package com.codegym.service.impl;

import com.codegym.model.facility.Facility;
import com.codegym.repository.facility.IFacilityRepository;
import com.codegym.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository facilityRepository;

    @Override
    public Page<Facility> findAll(String nameSearch, String facilityTye, Pageable pageable) {
        return facilityRepository.findAll(nameSearch, facilityTye, pageable);
    }

    @Override
    public Optional<Facility> findById(int id) {
        return facilityRepository.findById(id);
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }

}
