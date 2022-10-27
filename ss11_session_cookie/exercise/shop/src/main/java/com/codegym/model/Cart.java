package com.codegym.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> productMap = new HashMap<>();

    public Cart() {
    }

    public Map<Product, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<Product, Integer> productMap) {
        this.productMap = productMap;
    }

    public void addProduct(Product product) {
        if(product != null) {
            if(productMap.containsKey(product)) {
                productMap.put(product, productMap.get(product) + 1);
            } else {
                productMap.put(product, 1);
            }
        }
    }

    public void deleteProduct(Product product) {
        if(product != null) {
            int quality = productMap.get(product);
            if(quality > 1) {
                productMap.put(product, quality - 1);
            } else if(quality == 1) {
                productMap.remove(product);
            }
        }
    }

    public double totalPay() {
        if(productMap.isEmpty()) {
            return 0;
        } else {
            double total = 0;
            for(Map.Entry<Product, Integer> entry : productMap.entrySet()) {
                total += entry.getValue() * entry.getKey().getPrice();
            }
            return total;
        }
    }
}
