package com.sebastianvv.beltongym.domain.services.saleDetail;

import java.util.List;
import java.util.Optional;

import com.sebastianvv.beltongym.persistence.entities.SaleDetail;

public interface ISaleDetail {
    SaleDetail save(SaleDetail saleDetail);
    Optional<SaleDetail> findById(int id);
    List<SaleDetail> findAll();
    void deleteById(int id);
}
