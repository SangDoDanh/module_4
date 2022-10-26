package com.codegym.service.impl;

import com.codegym.model.Otp;
import com.codegym.repository.IOtpRepository;
import com.codegym.service.IOtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Random;

@Service
public class OtpService implements IOtpService {

    @Autowired
    private IOtpRepository otpRepository;

    @Override
    public int getOtp(int max, int min) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    @Override
    public void save(Otp otp_code) {
        otpRepository.save(otp_code);
    }

    @Override
    public Otp findById(int otpId) {
        Optional<Otp> optional = otpRepository.findById(otpId);
        if(!optional.isPresent()) {
            return  null;
        }
        return optional.get();
    }


    @Modifying
    @Transactional
    @Override
    public void remove(int otpId) {
        otpRepository.deleteById(otpId);
    }

    @Override
    public Otp findByValue(Integer value) {
        return otpRepository.findOtpByValue(value);
    }
}
