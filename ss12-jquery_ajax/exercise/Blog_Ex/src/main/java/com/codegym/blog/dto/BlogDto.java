package com.codegym.blog.dto;

public class BlogDto {
    private Integer id;
    private String upDayStatus;
    private String author;
    private String content;
    private int categoryID;

    public BlogDto() {
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

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
}
