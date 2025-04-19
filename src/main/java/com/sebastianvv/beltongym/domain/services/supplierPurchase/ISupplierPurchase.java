package com.sebastianvv.beltongym.domain.services.supplierPurchase;

import java.util.List;
import java.util.Optional;

import com.sebastianvv.beltongym.persistence.entities.SupplierPurchase;

public interface ISupplierPurchase {
    SupplierPurchase save(SupplierPurchase supplierPurchase);
    Optional<SupplierPurchase> findById(int id);
    List<SupplierPurchase> findAll();
    void deleteById(int id);
}
