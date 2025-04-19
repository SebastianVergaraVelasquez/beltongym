package com.sebastianvv.beltongym.domain.services.supplier;

import java.util.List;
import java.util.Optional;

import com.sebastianvv.beltongym.persistence.entities.Supplier;

public interface ISupplier {
    Supplier save(Supplier supplier);
    Optional<Supplier> findById(int id);
    List<Supplier> findAll();
    void deleteById(int id);
}
