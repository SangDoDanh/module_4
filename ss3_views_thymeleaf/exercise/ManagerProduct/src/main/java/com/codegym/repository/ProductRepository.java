package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductRepository implements IProductRepository{
    private static List<Product> productList;
    static {
        productList = new ArrayList<>();
        productList.add(new Product(1, "iphone 14", 9999.99, "Apple", "Iphone 14 pro max 1TB"));
        productList.add(new Product(2, "iphone 13", 8888.88, "Apple", "Iphone 13 pro max 1TB"));
        productList.add(new Product(3, "iphone 12", 7777.77, "Apple", "Iphone 12 pro max 1TB"));
        productList.add(new Product(4, "iphone 11", 6666.66, "Apple", "Iphone 11 pro max 1TB"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }

    @Override
    public void delete(int id) {
        productList.remove(findProductById(id));
    }

    @Override
    public Product findProductById(int id) {
        for(Product product : productList) {
            if(product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(Product product) {
        for(Product prod : productList) {
            if(prod.getId() == prod.getId()) {
                prod.setName(product.getName());
                prod.setDescription(product.getDescription());
                prod.setManufacture(product.getManufacture());
                prod.setPrice(product.getPrice());
                break;
            }
        }
    }

    @Override
    public List<Product> searchByName(String nameSearch) {
        if(nameSearch.equals(""))
            return productList;
        List<Product> results = new ArrayList<>();
        nameSearch = nameSearch.toLowerCase();
        for(Product product: productList) {
            if(product.getName().toLowerCase().contains(nameSearch)){
                results.add(product);
            }
        }
        return results;
    }

}
