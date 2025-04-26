package com.sebastianvv.beltongym.domain.services.purchaseDetail;

import java.util.List;
import java.util.Optional;

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
    public Optional<PurchaseDetail> findById(int id) {
       return purchaseDetailRepository.findById(id);
    }

    @Override
    public List<PurchaseDetail> findAll() {
        return (List<PurchaseDetail>) purchaseDetailRepository.findAllWithPurchaseAndProduct();
    }

    @Override
    public void deleteById(int id) {
        purchaseDetailRepository.deleteById(id);
    }

    @Override
    public List<PurchaseDetail> findByPurchaseId(int id) {
        return purchaseDetailRepository.findByPurchaseId(id);
    }

}
