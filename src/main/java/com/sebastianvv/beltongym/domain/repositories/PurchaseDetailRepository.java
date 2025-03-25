package com.sebastianvv.beltongym.domain.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.sebastianvv.beltongym.persistence.entities.PurchaseDetail;

public interface PurchaseDetailRepository extends CrudRepository<PurchaseDetail,UUID> {

}
