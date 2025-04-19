package com.sebastianvv.beltongym.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sebastianvv.beltongym.persistence.entities.PurchaseDetail;

public interface PurchaseDetailRepository extends CrudRepository<PurchaseDetail,Integer> {
    @Query("SELECT pd FROM PurchaseDetail pd JOIN FETCH pd.purchase JOIN FETCH pd.product")
    List<PurchaseDetail> findAllWithPurchaseAndProduct();
}
