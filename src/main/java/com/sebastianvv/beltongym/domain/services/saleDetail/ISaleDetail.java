package com.sebastianvv.beltongym.domain.services.saleDetail;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.sebastianvv.beltongym.persistence.entities.SaleDetail;

public interface ISaleDetail {
    SaleDetail save(SaleDetail saleDetail);
    Optional<SaleDetail> findById(UUID id);
    List<SaleDetail> findAll();
    void deleteById(UUID id);
}
