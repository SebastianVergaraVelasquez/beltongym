package com.sebastianvv.beltongym.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sebastianvv.beltongym.persistence.entities.PurchaseDetail;

public interface PurchaseDetailRepository extends CrudRepository<PurchaseDetail, Integer> {
    
    @Query("SELECT pd FROM PurchaseDetail pd JOIN FETCH pd.purchase JOIN FETCH pd.product")
    List<PurchaseDetail> findAllWithPurchaseAndProduct();

    @Query("SELECT pd FROM PurchaseDetail pd WHERE pd.purchase.id = :purchaseId")
    List<PurchaseDetail> findByPurchaseId(@Param("purchaseId") int purchaseId);
}