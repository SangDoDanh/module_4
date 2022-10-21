package com.codegym.productmanagerspringboot.repository;

import com.codegym.productmanagerspringboot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {

//    void add(Product product);
//
//    void delete(int id);
//
//    Product findProductById(int id);
//
//    void update(Product product);
//
//    List<Product> searchByName(String nameSearch);
}
