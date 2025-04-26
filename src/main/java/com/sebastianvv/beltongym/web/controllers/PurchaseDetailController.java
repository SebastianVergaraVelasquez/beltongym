package com.sebastianvv.beltongym.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sebastianvv.beltongym.domain.services.purchaseDetail.IPurchaseDetail;
import com.sebastianvv.beltongym.persistence.entities.PurchaseDetail;

import java.util.List;

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
    public PurchaseDetail getById(@PathVariable int id) {
        return purchaseDetailService.findById(id).get();
    }

    @GetMapping("/purchase/{purchaseId}")
    public List<PurchaseDetail> getByPurchaseId(@PathVariable int purchaseId) {
        return purchaseDetailService.findByPurchaseId(purchaseId);
    }

    @PostMapping
    public PurchaseDetail save(@RequestBody PurchaseDetail purchaseDetail) {
        return purchaseDetailService.save(purchaseDetail);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        purchaseDetailService.deleteById(id);
    }
}
