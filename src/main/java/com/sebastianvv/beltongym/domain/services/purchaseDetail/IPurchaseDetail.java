package com.sebastianvv.beltongym.domain.services.purchaseDetail;

import java.util.List;
import java.util.Optional;

import com.sebastianvv.beltongym.persistence.entities.PurchaseDetail;

public interface IPurchaseDetail {
    PurchaseDetail save(PurchaseDetail purchaseDetail);
    Optional<PurchaseDetail> findById(int id);
    List<PurchaseDetail> findAll();
    void deleteById(int id);
}
