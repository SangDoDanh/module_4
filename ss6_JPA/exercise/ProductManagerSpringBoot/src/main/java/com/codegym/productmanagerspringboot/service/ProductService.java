package com.codegym.productmanagerspringboot.service;

import com.codegym.productmanagerspringboot.model.Product;
import com.codegym.productmanagerspringboot.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> finAll() {
        return iProductRepository.findAll();

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Product findProductById(int id) {
        return null;
    }

    @Override
    public List<Product> seachByName(String nameSearch) {
        return null;
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void add(Product product) {

    }
//
//    @Override
//    public void add(Product product) {
//        iProductRepository.add(product);
//    }
//
//    @Override
//    public void delete(int id) {
//        iProductRepository.delete(id);
//    }
//
//    @Override
//    public Product findProductById(int id) {
//        return iProductRepository.findProductById(id);
//    }
//
//    @Override
//    public void update(Product product) {
//        iProductRepository.update(product);
//    }
//
//    @Override
//    public List<Product> seachByName(String nameSearch) {
//        return iProductRepository.searchByName(nameSearch);
//    }
}
