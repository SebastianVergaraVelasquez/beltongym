package com.sebastianvv.beltongym.persistence.entities;

import java.time.LocalDate;
import java.util.List;

public class SaleDTO {
    
    private int document;
    private LocalDate date;
    private List<SaleDetailDTO> saleDetails;
    
    public SaleDTO(int document, LocalDate date, List<SaleDetailDTO> saleDetails) {
        this.document = document;
        this.date = date;
        this.saleDetails = saleDetails;
    }

    public int getDocument() {
        return document;
    }

    public void setDocument(int document) {
        this.document = document;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<SaleDetailDTO> getSaleDetails() {
        return saleDetails;
    }

    public void setSaleDetails(List<SaleDetailDTO> saleDetails) {
        this.saleDetails = saleDetails;
    }

   
}
