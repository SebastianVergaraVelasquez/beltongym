package com.sebastianvv.beltongym.domain.services.supplier;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebastianvv.beltongym.domain.repositories.SupplierRepository;
import com.sebastianvv.beltongym.persistence.entities.Supplier;

@Service
public class SupplierImpl implements ISupplier {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public Optional<Supplier> findById(int id) {
       return supplierRepository.findById(id);
    }

    @Override
    public List<Supplier> findAll() {
        return (List<Supplier>) supplierRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        supplierRepository.deleteById(id);
    }

}
