package com.sebastianvv.beltongym.domain.services.product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebastianvv.beltongym.domain.repositories.ProductRepository;
import com.sebastianvv.beltongym.persistence.entities.Product;

@Service
public class ProductImpl implements IProduct {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save(Product product) {
       return productRepository.save(product);
    }

    @Override
    public Optional<Product> findById(UUID id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public void deleteById(UUID id) {
        productRepository.deleteById(id);
    }

}
