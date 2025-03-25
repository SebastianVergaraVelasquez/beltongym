package com.sebastianvv.beltongym.domain.services.supplier;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.sebastianvv.beltongym.persistence.entities.Supplier;

public interface ISupplier {
    Supplier save(Supplier supplier);
    Optional<Supplier> findById(UUID id);
    List<Supplier> findAll();
    void deleteById(UUID id);
}
