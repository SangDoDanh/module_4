package com.codeGym.service;

import com.codeGym.model.Email;
import com.codeGym.repository.IEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService implements IEmailService{
    @Autowired
    private IEmailRepository iEmailRepository;

    @Override
    public List<Email> findAll() {
        return iEmailRepository.findAll();
    }

    @Override
    public void update(Email email) {
        iEmailRepository.update(email);
    }

    @Override
    public String[] getLanguages() {
        return iEmailRepository.getLanguages();
    }

    @Override
    public String[] getPageSize() {
        return iEmailRepository.getPageSize();
    }

    @Override
    public Email findEmailById(int emailId) {
        return iEmailRepository.findEmailById(emailId);
    }
}
