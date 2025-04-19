package com.sebastianvv.beltongym.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sebastianvv.beltongym.domain.services.product.IProduct;
import com.sebastianvv.beltongym.persistence.entities.Product;

import java.util.List;

@RestController
@RequestMapping("/belton/product")
public class ProductController {
    @Autowired
    private IProduct productService;

    @GetMapping
    public List<Product> getAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable int id) {
        return productService.findById(id).get();
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        productService.deleteById(id);
    }
}
