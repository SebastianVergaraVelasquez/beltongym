package com.sebastianvv.beltongym.domain.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sebastianvv.beltongym.persistence.entities.SupplierPurchase;

public interface SupplierPurchaseRepository extends CrudRepository <SupplierPurchase, UUID> {
    @Query("SELECT sp FROM SupplierPurchase sp JOIN FETCH sp.supplier")
    List<SupplierPurchase> findAllWithSupplier();
}
