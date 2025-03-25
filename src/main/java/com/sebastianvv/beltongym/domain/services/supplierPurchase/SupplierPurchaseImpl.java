package com.sebastianvv.beltongym.domain.services.supplierPurchase;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.sebastianvv.beltongym.domain.repositories.SupplierPurchaseRepository;
import com.sebastianvv.beltongym.persistence.entities.SupplierPurchase;

public class SupplierPurchaseImpl implements ISupplierPurchase {

    @Autowired
    private SupplierPurchaseRepository supplierPurchaseRepository;

    @Override
    public SupplierPurchase save(SupplierPurchase supplierPurchase) {
        return supplierPurchaseRepository.save(supplierPurchase);
    }

    @Override
    public Optional<SupplierPurchase> findById(UUID id) {
        return supplierPurchaseRepository.findById(id);
    }

    @Override
    public List<SupplierPurchase> findAll() {
        return (List<SupplierPurchase>) supplierPurchaseRepository.findAll();
    }

    @Override
    public void deleteById(UUID id) {
        supplierPurchaseRepository.deleteById(id);;
    }
    
}
