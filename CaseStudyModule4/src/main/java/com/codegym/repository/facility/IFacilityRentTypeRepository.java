package com.codegym.repository.facility;

import com.codegym.model.facility.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityRentTypeRepository extends JpaRepository<RentType, Integer> {
}
