package com.codegym.model;

public class UserMoki {

    public UserMoki() {
    }

    public UserMoki(String email, String password) {
        this.password = password;
        this.email = email;
    }

    private String password;
    private String email;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}
