package com.sebastianvv.beltongym.persistence.entities;

public class PurchaseDetailDTO {
    private Product product;
    private int quantity;

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
