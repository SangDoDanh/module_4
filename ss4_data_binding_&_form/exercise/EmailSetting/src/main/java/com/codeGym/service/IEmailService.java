package com.codeGym.service;

import com.codeGym.model.Email;

import java.util.List;

public interface IEmailService {

    List<Email> findAll();

    void update(Email email);

   String[] getLanguages();

    String[] getPageSize();

    Email findEmailById(int emailId);
}
