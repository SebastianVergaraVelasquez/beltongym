package com.sebastianvv.beltongym.domain.services.supplierPurchase;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebastianvv.beltongym.domain.repositories.SupplierPurchaseRepository;
import com.sebastianvv.beltongym.persistence.entities.SupplierPurchase;

@Service
public class SupplierPurchaseImpl implements ISupplierPurchase {

    @Autowired
    private SupplierPurchaseRepository supplierPurchaseRepository;

    @Override
    public SupplierPurchase save(SupplierPurchase supplierPurchase) {
        return supplierPurchaseRepository.save(supplierPurchase);
    }

    @Override
    public Optional<SupplierPurchase> findById(int id) {
        return supplierPurchaseRepository.findById(id);
    }

    @Override
    public List<SupplierPurchase> findAll() {
        return (List<SupplierPurchase>) supplierPurchaseRepository.findAllWithSupplier();
    }

    @Override
    public void deleteById(int id) {
        supplierPurchaseRepository.deleteById(id);;
    }
    
}
