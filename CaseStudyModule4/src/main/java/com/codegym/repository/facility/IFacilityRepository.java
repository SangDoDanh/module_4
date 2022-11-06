package com.codegym.repository.facility;

import com.codegym.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IFacilityRepository extends JpaRepository<Facility, Integer> {

    @Query(value = "select * from facility \n" +
            "where name like %:nameSearch% " +
            "and facility_type_id like %:facilityTye% " +
            "and status = false " +
            "order by name",
            nativeQuery = true)
    Page<Facility> findAll(String nameSearch, String facilityTye, Pageable pageable);
}
