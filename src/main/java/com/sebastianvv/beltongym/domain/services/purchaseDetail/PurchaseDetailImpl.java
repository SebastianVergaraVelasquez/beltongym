package com.sebastianvv.beltongym.domain.services.purchaseDetail;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebastianvv.beltongym.domain.repositories.PurchaseDetailRepository;
import com.sebastianvv.beltongym.persistence.entities.PurchaseDetail;

@Service
public class PurchaseDetailImpl implements IPurchaseDetail{

    @Autowired
    private PurchaseDetailRepository purchaseDetailRepository;

    @Override
    public PurchaseDetail save(PurchaseDetail purchaseDetail) {
        return purchaseDetailRepository.save(purchaseDetail) ;
    }

    @Override
    public Optional<PurchaseDetail> findById(UUID id) {
       return purchaseDetailRepository.findById(id);
    }

    @Override
    public List<PurchaseDetail> findAll() {
        return (List<PurchaseDetail>) purchaseDetailRepository.findAllWithPurchaseAndProduct();
    }

    @Override
    public void deleteById(UUID id) {
        purchaseDetailRepository.deleteById(id);
    }

}
