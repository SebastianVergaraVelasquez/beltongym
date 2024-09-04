package com.sebastianvv.beltongym.persistence.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "purchase_detail")
public class PurchaseDetail {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "CHAR(36)")
    private UUID id;

    @ManyToOne
    private SupplierPurchase purchase;

    @ManyToOne
    private Product product;

    private int quantity;

    public PurchaseDetail() {
    }

    public PurchaseDetail(UUID id, SupplierPurchase purchase, Product product, int quantity) {
        this.id = id;
        this.purchase = purchase;
        this.product = product;
        this.quantity = quantity;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public SupplierPurchase getPurchase() {
        return purchase;
    }

    public void setPurchase(SupplierPurchase purchase) {
        this.purchase = purchase;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
