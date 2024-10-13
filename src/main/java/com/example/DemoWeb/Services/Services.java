package com.example.DemoWeb.Services;

import com.example.DemoWeb.Models.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class Services {

    List<Product> list= new ArrayList<>(Arrays.asList(
            new Product(1,"MacBook", 70000, 5),
            new Product(2,"Acer Swift Go", 60000, 10),
            new Product(3,"Samsung Tab", 40000, 20)
    ));

    public List<Product> getAllProducts() {
        return list;
    }

    public Product getProductById(int id) {
        for(Product p: list) {
            if(p.getId()==id) return p;
        }
        return new Product(-1, "", -1, -1);
    }

    public boolean addProduct(Product product) {
        return list.add(product);
    }

    public boolean updateProduct(Product product) {
        list.removeIf(p -> p.getId() == product.getId());
        return list.add(product);
    }

    public boolean removeProduct(int id) {
        return list.removeIf(p -> p.getId() == id);
    }

    public List<Product> searchProduct(String keyword) {
        List<Product> searchedList= new ArrayList<>();
        for(Product p: list) {
            if(p.getName().contains(keyword)) {
                searchedList.add(p);
            }
        }
        return searchedList;
    }
}
