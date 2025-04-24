package com.sebastianvv.beltongym.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sebastianvv.beltongym.domain.services.saleDetail.ISaleDetail;
import com.sebastianvv.beltongym.persistence.entities.SaleDetail;

import java.util.List;

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
    public SaleDetail getById(@PathVariable int id) {
        return saleDetailService.findById(id).get();
    }

    @GetMapping("/sale/{saleId}")
    public List<SaleDetail> getBySaleId(@PathVariable int saleId) {
        return saleDetailService.findBySaleId(saleId);
    }

    @PostMapping
    public SaleDetail save(@RequestBody SaleDetail saleDetail) {
        return saleDetailService.save(saleDetail);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        saleDetailService.deleteById(id);
    }
}
