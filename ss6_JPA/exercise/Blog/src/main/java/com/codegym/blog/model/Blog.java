package com.codegym.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String upDayStatus;
    private String author;
    private String content;

    public Blog() {
    }

    public Blog(Integer id, String upDayStatus, String author, String content) {
        this.id = id;
        this.upDayStatus = upDayStatus;
        this.author = author;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUpDayStatus() {
        return upDayStatus;
    }

    public void setUpDayStatus(String upDayStatus) {
        this.upDayStatus = upDayStatus;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
