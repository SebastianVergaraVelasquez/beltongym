package com.sebastianvv.beltongym.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sebastianvv.beltongym.domain.services.supplier.ISupplier;
import com.sebastianvv.beltongym.persistence.entities.Supplier;

import java.util.List;

@RestController
@RequestMapping("/belton/supplier")
public class SupplierController {
    @Autowired
    private ISupplier supplierService;

    @GetMapping
    public List<Supplier> getAll() {
        return supplierService.findAll();
    }

    @GetMapping("/{id}")
    public Supplier getById(@PathVariable int id) {
        return supplierService.findById(id).get();
    }

    @PostMapping
    public Supplier save(@RequestBody Supplier supplier) {
        return supplierService.save(supplier);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        supplierService.deleteById(id);
    }
}

