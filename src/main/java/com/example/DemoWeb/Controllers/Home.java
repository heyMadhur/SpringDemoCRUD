package com.example.DemoWeb.Controllers;

import com.example.DemoWeb.Models.Product;
import com.example.DemoWeb.Services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Home {

    @Autowired
    Services service;

    @RequestMapping("/")
    public String home(){
        return "<h1>Hello World. This world is created by Madhur Gupta</h1>";
    }

    @GetMapping("/allproducts")
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @PostMapping("/addProduct")
    public boolean addProduct(@RequestBody Product product){
        return service.addProduct(product);
    }

    @PutMapping("/updateproduct")
    public boolean updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("deleteproduct/{id}")
    public boolean removeProduct(@PathVariable int id) {
        return service.removeProduct(id);
    }

    @GetMapping("/searchproduct")
    public List<Product> searchProduct(@RequestParam String keyword) {
        return service.searchProduct(keyword);
    }





}
