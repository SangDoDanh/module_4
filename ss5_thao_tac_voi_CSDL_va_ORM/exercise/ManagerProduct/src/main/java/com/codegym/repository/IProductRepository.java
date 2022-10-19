package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void add(Product product);

    void delete(int id);

    Product findProductById(int id);

    void update(Product product);

    List<Product> searchByName(String nameSearch);
}
