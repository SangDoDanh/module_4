package com.codegym.service.impl;

import com.codegym.model.facility.AttachFacility;
import com.codegym.repository.facility.IAttachFacilityRepository;
import com.codegym.service.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityService implements IAttachFacilityService {

    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;

    @Override
    public List<AttachFacility> findAll() {
        return attachFacilityRepository.findAll();
    }

    @Override
    public AttachFacility findById(int attachFacility) {
        return attachFacilityRepository.findById(attachFacility).get();
    }
}
