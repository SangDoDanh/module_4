package com.codegym.model;

import java.util.Arrays;

public class Employee {
    private String id;
    private String name;
    private String contactNumber;
    private String[] languages;

    public Employee() {
    }

    public Employee(String id, String name, String contactNumber, String[] languages) {
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
        this.languages = languages;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", languages=" + Arrays.toString(languages) +
                '}';
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
