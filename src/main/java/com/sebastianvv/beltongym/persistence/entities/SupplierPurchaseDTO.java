package com.sebastianvv.beltongym.persistence.entities;

import java.time.LocalDate;
import java.util.List;

public class SupplierPurchaseDTO {

    private Supplier supplier;
    private LocalDate date;
    private List<PurchaseDetailDTO> purchaseDetails;

    public Supplier getSupplier() {
        return supplier;
    }
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public List<PurchaseDetailDTO> getPurchaseDetails() {
        return purchaseDetails;
    }
    public void setPurchaseDetails(List<PurchaseDetailDTO> purchaseDetailDTO) {
        this.purchaseDetails = purchaseDetailDTO;
    } 
}
