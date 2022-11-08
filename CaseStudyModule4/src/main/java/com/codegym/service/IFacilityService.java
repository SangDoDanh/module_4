package com.codegym.service;

import com.codegym.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IFacilityService {
    Page<Facility> findAll(String nameSearch, String facilityTye, Pageable pageable);

    Optional<Facility> findById(int id);

    void save(Facility facility);

    List<Facility> findAll();
}
