package com.sebastianvv.beltongym.domain.services.supplierPurchase;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.sebastianvv.beltongym.persistence.entities.SupplierPurchase;

public interface ISupplierPurchase {
    SupplierPurchase save(SupplierPurchase supplierPurchase);
    Optional<SupplierPurchase> findById(UUID id);
    List<SupplierPurchase> findAll();
    void deleteById(UUID id);
}
