package com.sebastianvv.beltongym.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sebastianvv.beltongym.domain.services.sales.ISales;
import com.sebastianvv.beltongym.persistence.entities.Sales;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/belton/sales")
public class SalesController {
    @Autowired
    private ISales salesService;

    @GetMapping
    public List<Sales> getAll() {
        return salesService.findAll();
    }

    @GetMapping("/{id}")
    public Sales getById(@PathVariable UUID id) {
        return salesService.findById(id).get();
    }

    @PostMapping
    public Sales save(@RequestBody Sales sales) {
        return salesService.save(sales);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        salesService.deleteById(id);
    }
}