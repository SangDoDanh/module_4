package com.codegym.service;

import com.codegym.model.Cart;
import com.codegym.model.Product;

public interface ICartService {
    Cart getCart();

    void deleteProduct(Product product);

    void addProduct(Product product);

    double totalPay();
}
