package com.sebastianvv.beltongym.domain.services.product;

import java.util.List;
import java.util.Optional;

import com.sebastianvv.beltongym.persistence.entities.Product;

public interface IProduct {
    Product save(Product product);
    Optional<Product> findById(int id);
    List<Product> findAll();
    void deleteById(int id);
}
