package com.sebastianvv.beltongym.domain.services.supplier;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.sebastianvv.beltongym.domain.repositories.SupplierRepository;
import com.sebastianvv.beltongym.persistence.entities.Supplier;

public class SupplierImpl implements ISupplier {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public Optional<Supplier> findById(UUID id) {
       return supplierRepository.findById(id);
    }

    @Override
    public List<Supplier> findAll() {
        return (List<Supplier>) supplierRepository.findAll();
    }

    @Override
    public void deleteById(UUID id) {
        supplierRepository.deleteById(id);
    }

}
