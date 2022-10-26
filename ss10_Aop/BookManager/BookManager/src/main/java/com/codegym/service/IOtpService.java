package com.codegym.service;

import com.codegym.model.Otp;

public interface IOtpService {
    int getOtp(int i, int i1);

    void save(Otp otp_code);

    Otp findById(int otpID);

    void remove(int otpID);

    Otp findByValue(Integer value);
}
