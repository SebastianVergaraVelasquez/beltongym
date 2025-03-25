package com.sebastianvv.beltongym.domain.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.sebastianvv.beltongym.persistence.entities.Product;

public interface ProductRepository extends CrudRepository<Product,UUID> {

}
