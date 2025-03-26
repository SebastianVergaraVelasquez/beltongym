package com.sebastianvv.beltongym.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sebastianvv.beltongym.domain.services.saleDetail.ISaleDetail;
import com.sebastianvv.beltongym.persistence.entities.SaleDetail;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/belton/saleDetail")
public class SaleDetailController {
    @Autowired
    private ISaleDetail saleDetailService;

    @GetMapping
    public List<SaleDetail> getAll() {
        return saleDetailService.findAll();
    }

    @GetMapping("/{id}")
    public SaleDetail getById(@PathVariable UUID id) {
        return saleDetailService.findById(id).get();
    }

    @PostMapping
    public SaleDetail save(@RequestBody SaleDetail saleDetail) {
        return saleDetailService.save(saleDetail);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        saleDetailService.deleteById(id);
    }
}
