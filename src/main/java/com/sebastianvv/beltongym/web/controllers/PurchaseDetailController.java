package com.sebastianvv.beltongym.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sebastianvv.beltongym.domain.services.purchaseDetail.IPurchaseDetail;
import com.sebastianvv.beltongym.persistence.entities.PurchaseDetail;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/belton/purchaseDetail")
public class PurchaseDetailController {
    @Autowired
    private IPurchaseDetail purchaseDetailService;

    @GetMapping
    public List<PurchaseDetail> getAll() {
        return purchaseDetailService.findAll();
    }

    @GetMapping("/{id}")
    public PurchaseDetail getById(@PathVariable UUID id) {
        return purchaseDetailService.findById(id).get();
    }

    @PostMapping
    public PurchaseDetail save(@RequestBody PurchaseDetail purchaseDetail) {
        return purchaseDetailService.save(purchaseDetail);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        purchaseDetailService.deleteById(id);
    }
}
