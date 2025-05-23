package com.sebastianvv.beltongym.domain.services.saleDetail;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebastianvv.beltongym.domain.repositories.SaleDetailRepository;
import com.sebastianvv.beltongym.persistence.entities.SaleDetail;

@Service
public class SaleDetailImpl implements ISaleDetail {

    @Autowired
    private SaleDetailRepository saleDetailRepository;

    @Override
    public SaleDetail save(SaleDetail saleDetail) {
        return saleDetailRepository.save(saleDetail);
    }

    @Override
    public Optional<SaleDetail> findById(int id) {
        return saleDetailRepository.findById(id);
    }

    @Override
    public List<SaleDetail> findAll() {
        return (List<SaleDetail>) saleDetailRepository.findAllWithSaleAndProduct();
    }

    @Override
    public void deleteById(int id) {
        saleDetailRepository.deleteById(id);
    }

    @Override
    public List<SaleDetail> findBySaleId(int saleId) {
        return saleDetailRepository.findBySaleId(saleId);
    }

}
