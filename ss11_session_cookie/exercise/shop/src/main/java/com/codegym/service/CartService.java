package com.codegym.service;

import com.codegym.model.Cart;
import com.codegym.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Service
public class CartService implements ICartService{

    @Autowired
    HttpSession httpSession;
    @Override
    public Cart getCart() {
        if(httpSession.getAttribute("cartList") == null)
            return new Cart();
        return (Cart) httpSession.getAttribute("cartList");
    }

    @Override
    public void deleteProduct(Product product) {
        Cart cart = getCart();
        if(product != null) {
            int quality = cart.getProductMap().get(product);
            if(quality > 1) {
                cart.getProductMap().put(product, quality - 1);
            } else if(quality == 1) {
                cart.getProductMap().remove(product);
            }
        }
        httpSession.setAttribute("cartList", cart);
    }

    @Override
    public void addProduct(Product product) {
        Cart cart = getCart();
        if(product != null) {
            if(cart.getProductMap().containsKey(product)) {
                cart.getProductMap().put(product, cart.getProductMap().get(product) + 1);
            } else {
                cart.getProductMap().put(product, 1);
            }
        }
        httpSession.setAttribute("cartList", cart);
    }

    @Override
    public double totalPay() {
        Cart cart = getCart();
        if(cart.getProductMap().isEmpty()) {
            return 0;
        } else {
            double total = 0;
            for(Map.Entry<Product, Integer> entry : cart.getProductMap().entrySet()) {
                total += entry.getValue() * entry.getKey().getPrice();
            }
            return total;
        }
    }
}
