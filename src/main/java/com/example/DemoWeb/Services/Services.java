package com.example.DemoWeb.Services;

import com.example.DemoWeb.Models.Product;
import com.example.DemoWeb.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class Services {
    @Autowired
    ProductRepo repo;

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(new Product(-1, "", -1, -1));
    }

    public boolean addProduct(Product product) {
        Product result= repo.save(product);
        System.out.println("Add Result= "+result);
        return  result != null;
    }

    public boolean updateProduct(Product product) {
        return repo.save(product) != null;
    }

    public boolean removeProduct(int id) {
        repo.deleteById(id);
        return true;
    }

    public List<Product> searchProduct(String keyword) {
        return repo.searchByKeyword(keyword);
    }
}
