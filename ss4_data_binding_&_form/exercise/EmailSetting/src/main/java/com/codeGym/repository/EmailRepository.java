package com.codeGym.repository;

import com.codeGym.model.Email;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailRepository implements  IEmailRepository{

    private  static List<Email> emailList;
    static {
        emailList = new ArrayList<>();
        emailList.add(new Email(1,"English", "5", true, "Sang"));
        emailList.add(new Email(2,"Japanese", "10", false, "Hai"));
        emailList.add(new Email(3,"Vietnamese", "25", true, "Tien"));
        emailList.add(new Email(4,"Chinese", "100", false, "Hung"));
    }
    @Override
    public String[] getLanguages() {
        return new String[]{"English", "Vietnamese", "Japanese", "Chinese"};
    }

    @Override
    public String[] getPageSize() {
        return new String[]{"5", "10", "15", "25", "50", "100"};
    }

    @Override
    public List<Email> findAll() {
        return emailList;
    }

    @Override
    public Email findEmailById(int emailId) {
        for(Email email : emailList) {
            if(email.getId() == emailId) {
                return email;
            }
        }
        return new Email();
    }

    @Override
    public void update(Email email) {
        for(Email e : emailList) {
            if(email.getId() == e.getId()) {
                e.setLanguages(email.getLanguages());
                e.setPageSize(email.getPageSize());
                e.setSignature(email.getSignature());
                e.setSampleFilter(email.isSampleFilter());
                break;
            }
        }
    }
}
