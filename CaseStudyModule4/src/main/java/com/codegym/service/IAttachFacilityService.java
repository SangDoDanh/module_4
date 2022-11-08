package com.codegym.service;

import com.codegym.model.facility.AttachFacility;

import java.util.List;

public interface IAttachFacilityService {
    List<AttachFacility> findAll();

    AttachFacility findById(int attachFacility);
}
