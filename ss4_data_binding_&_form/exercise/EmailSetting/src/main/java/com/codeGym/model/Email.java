package com.codeGym.model;

public class Email {
    private int id;
    private String languages;
    private String pageSize;
    private boolean sampleFilter;
    private String Signature;

    public Email() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Email(int id, String languages, String pageSize, boolean sampleFilter, String signature) {
        this.id = id;
        this.languages = languages;
        this.pageSize = pageSize;
        this.sampleFilter = sampleFilter;
        Signature = signature;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isSampleFilter() {
        return sampleFilter;
    }

    public void setSampleFilter(boolean sampleFilter) {
        this.sampleFilter = sampleFilter;
    }

    public String getSignature() {
        return Signature;
    }

    public void setSignature(String signature) {
        Signature = signature;
    }
}
