package com.codegym.productmanagerspringboot.service;

import com.codegym.productmanagerspringboot.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> finAll();

    void add(Product product);

    void delete(int id);

    Product findProductById(int id);

    void update(Product product);

    List<Product> seachByName(String nameSearch);
}
