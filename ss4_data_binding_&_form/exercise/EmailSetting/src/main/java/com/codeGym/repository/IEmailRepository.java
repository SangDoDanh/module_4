package com.codeGym.repository;

import com.codeGym.model.Email;

import java.util.List;

public interface IEmailRepository {
    String[] getLanguages();

    String[] getPageSize();

    List<Email> findAll();

    Email findEmailById(int emailId);

    void update(Email email);
}
