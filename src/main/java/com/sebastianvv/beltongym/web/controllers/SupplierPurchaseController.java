package com.sebastianvv.beltongym.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.sebastianvv.beltongym.domain.services.product.IProduct;
import com.sebastianvv.beltongym.domain.services.purchaseDetail.IPurchaseDetail;
import com.sebastianvv.beltongym.domain.services.supplier.ISupplier;
import com.sebastianvv.beltongym.domain.services.supplierPurchase.ISupplierPurchase;
import com.sebastianvv.beltongym.persistence.entities.Product;
import com.sebastianvv.beltongym.persistence.entities.PurchaseDetail;
import com.sebastianvv.beltongym.persistence.entities.PurchaseDetailDTO;
import com.sebastianvv.beltongym.persistence.entities.Supplier;
import com.sebastianvv.beltongym.persistence.entities.SupplierPurchase;
import com.sebastianvv.beltongym.persistence.entities.SupplierPurchaseDTO;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/belton/supplierPurchase")
public class SupplierPurchaseController {
    @Autowired
    private ISupplierPurchase supplierPurchaseService;
    @Autowired
    private ISupplier supplierService;
    @Autowired
    private IProduct productService;
    @Autowired
    private IPurchaseDetail purchaseDetailService;

    @GetMapping
    public List<SupplierPurchase> getAll() {
        return supplierPurchaseService.findAll();
    }

    @GetMapping("/{id}")
    public SupplierPurchase getById(@PathVariable int id) {
        return supplierPurchaseService.findById(id).get();
    }

    @PostMapping
    public SupplierPurchase save(@RequestBody SupplierPurchaseDTO supplierPurchaseDTO) {
    SupplierPurchase purchase = new SupplierPurchase();

    Optional<Supplier> supplierOpt = supplierService.findById(supplierPurchaseDTO.getSupplier().getId());
    if (supplierOpt.isEmpty()) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Proveedor no encontrado con el ID: " + supplierPurchaseDTO.getSupplier().getId());
    }

    purchase.setSupplier(supplierOpt.get());
    purchase.setDate(supplierPurchaseDTO.getDate());

    SupplierPurchase savedPurchase = supplierPurchaseService.save(purchase);

    double total = 0.0;
    for (PurchaseDetailDTO purchaseDetailDTO : supplierPurchaseDTO.getPurchaseDetails()) {
        Product product = productService.findById(purchaseDetailDTO.getProduct().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Producto no encontrado con el ID: " + purchaseDetailDTO.getProduct().getId()));

        double subtotal = product.getPrice() * purchaseDetailDTO.getQuantity();
        total += subtotal;

        PurchaseDetail purchaseDetail = new PurchaseDetail();
        purchaseDetail.setProduct(product);
        purchaseDetail.setQuantity(purchaseDetailDTO.getQuantity());
        purchaseDetail.setPurchase(savedPurchase);
        purchaseDetailService.save(purchaseDetail);
    }

    savedPurchase.setTotal(total);
    return supplierPurchaseService.save(savedPurchase);
}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        supplierPurchaseService.deleteById(id);
    }
}
