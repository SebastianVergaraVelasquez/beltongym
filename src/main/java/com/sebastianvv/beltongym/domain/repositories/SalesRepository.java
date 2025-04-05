package com.sebastianvv.beltongym.domain.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sebastianvv.beltongym.persistence.entities.Sales;

public interface SalesRepository extends CrudRepository<Sales, UUID>{
    @Query("SELECT s FROM Sales s JOIN FETCH s.user")
    List<Sales> findAllWithUser();
}
