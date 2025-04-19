package com.sebastianvv.beltongym.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sebastianvv.beltongym.persistence.entities.Product;

public interface ProductRepository extends CrudRepository<Product,Integer> {

}
