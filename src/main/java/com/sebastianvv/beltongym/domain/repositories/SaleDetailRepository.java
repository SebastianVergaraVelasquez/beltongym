package com.sebastianvv.beltongym.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sebastianvv.beltongym.persistence.entities.SaleDetail;

public interface SaleDetailRepository extends CrudRepository<SaleDetail, Integer> {
    @Query("SELECT sd FROM SaleDetail sd JOIN FETCH sd.sale JOIN FETCH sd.product")
    List<SaleDetail> findAllWithSaleAndProduct();
}
