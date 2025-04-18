package com.sebastianvv.beltongym.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sebastianvv.beltongym.domain.services.supplierPurchase.ISupplierPurchase;
import com.sebastianvv.beltongym.persistence.entities.SupplierPurchase;

import java.util.List;

@RestController
@RequestMapping("/belton/supplierPurchase")
public class SupplierPurchaseController {
    @Autowired
    private ISupplierPurchase supplierPurchaseService;

    @GetMapping
    public List<SupplierPurchase> getAll() {
        return supplierPurchaseService.findAll();
    }

    @GetMapping("/{id}")
    public SupplierPurchase getById(@PathVariable int id) {
        return supplierPurchaseService.findById(id).get();
    }

    @PostMapping
    public SupplierPurchase save(@RequestBody SupplierPurchase supplierPurchase) {
        return supplierPurchaseService.save(supplierPurchase);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        supplierPurchaseService.deleteById(id);
    }
}
