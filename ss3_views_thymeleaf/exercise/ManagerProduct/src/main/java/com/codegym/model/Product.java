package com.codegym.model;

public class Product {
    private Integer id;
    private String name;
    private Double price;
    private String manufacture;
    private String description;

    public Product() {
    }

    public Product(Integer id, String name, Double price, String manufacture, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.manufacture = manufacture;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
