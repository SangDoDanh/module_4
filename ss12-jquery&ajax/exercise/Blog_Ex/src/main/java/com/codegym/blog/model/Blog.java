package com.codegym.blog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String upDayStatus;
    private String author;
    private String content;

    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @JsonBackReference
    @JsonIgnore
    @ManyToOne
    private Category category;

    public Blog() {
    }

    public Blog(Integer id, String upDayStatus, String author, String content) {
        this.id = id;
        this.upDayStatus = upDayStatus;
        this.author = author;
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
