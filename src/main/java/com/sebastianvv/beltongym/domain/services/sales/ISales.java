package com.sebastianvv.beltongym.domain.services.sales;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.sebastianvv.beltongym.persistence.entities.Sales;

public interface ISales {
    Sales save(Sales sale);
    Optional<Sales> findById(UUID id);
    List<Sales> findAll();
    void deleteById(UUID id);
}
