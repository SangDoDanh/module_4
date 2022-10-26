package com.codegym.repository;

import com.codegym.model.Otp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOtpRepository extends JpaRepository<Otp, Integer> {
    public Otp findOtpByValue(Integer value);
}
